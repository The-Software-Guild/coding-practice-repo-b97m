/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.classroster.ui;

import com.bm.classroster.dto.Student;
import java.util.List;

public class ClassRosterView {
    private UserIO io;

    public ClassRosterView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Students");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");
            
        return io.readInt("Please select from the above choices", 1, 5);
    }
    
    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("Student successfully created. Please hit ENTER to continue");
    }
    
    public Student getNewStudentInfo() {
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String cohort = io.readString("Please enter cohort");
        
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        
        return currentStudent;
    }
    
    public void displayAllBanner() {
        io.print("=== Display All Students ===");
    }
    
    public void displayStudentList(List<Student> studentList) {
        studentList.stream().forEach(stud -> {
            io.print(String.format(
                "#%s  : %s %s",
                stud.getStudentId(),
                stud.getFirstName(),
                stud.getLastName()
            ));
        });
        io.readString("Please hit ENTER to continue.");
    }
    
    public void displayDisplayStudentBanner() {
        io.print("=== Display Student ===");
    }
    
    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }
    
    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveStudentBanner() {
        io.print("=== Remove Student ===");
    }
    
    public void displayRemoveResult(Student studentRecord) {
        if (studentRecord != null) {
            io.print("Student successfully removed.");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit ENTER to continue");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errMsg) {
        io.print("=== ERROR ===");
        io.print(errMsg);
    }
}
