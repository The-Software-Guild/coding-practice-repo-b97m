/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.classroster.controller;

import com.bm.classroster.dao.ClassRosterPersistenceException;
import com.bm.classroster.dto.Student;
import com.bm.classroster.service.ClassRosterDataValidationException;
import com.bm.classroster.service.ClassRosterDuplicateIdException;
import com.bm.classroster.service.ClassRosterServiceLayer;
import com.bm.classroster.ui.ClassRosterView;

public class ClassRosterController {
    private ClassRosterView view;
    private ClassRosterServiceLayer service;

    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        try {
            while (keepGoing) {          
                switch (getMenuSelection()) {
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (ClassRosterPersistenceException ex) {
            view.displayErrorMessage(ex.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do {
            Student curentStudent = view.getNewStudentInfo();
            try {
                service.createStudent(curentStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (ClassRosterDataValidationException | ClassRosterDuplicateIdException ex) {
                hasErrors = true;
                view.displayErrorMessage(ex.getMessage());
            }
        } while (hasErrors);
    }
    
    private void listStudents() throws ClassRosterPersistenceException {
        view.displayAllBanner();
        view.displayStudentList(service.getAllStudents());
    }
    
    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        view.displayStudent(service.getStudent(view.getStudentIdChoice()));
    }
    
    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        view.displayRemoveResult(service.removeStudent(view.getStudentIdChoice()));
        // The new code-along mentions a view.displayRemoveSuccessBanner()
        // This method wasn't in the previous code-along for ClassRoster
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
}
