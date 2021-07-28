/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.classroster.controller;

import com.bm.classroster.dao.ClassRosterDao;
import com.bm.classroster.dao.ClassRosterDaoException;
import com.bm.classroster.dto.Student;
import com.bm.classroster.ui.ClassRosterView;

public class ClassRosterController {
    private ClassRosterView view;
    private ClassRosterDao dao;
    
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
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
        } catch (ClassRosterDaoException ex) {
            view.displayErrorMessage(ex.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createStudent() throws ClassRosterDaoException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }
    
    private void listStudents() throws ClassRosterDaoException {
        view.displayAllBanner();
        view.displayStudentList(dao.getAllStudents());
    }
    
    private void viewStudent() throws ClassRosterDaoException {
        view.displayDisplayStudentBanner();
        view.displayStudent(dao.getStudent(view.getStudentIdChoice()));
    }
    
    private void removeStudent() throws ClassRosterDaoException {
        view.displayRemoveStudentBanner();
        view.displayRemoveResult(dao.removeStudent(view.getStudentIdChoice()));
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
}
