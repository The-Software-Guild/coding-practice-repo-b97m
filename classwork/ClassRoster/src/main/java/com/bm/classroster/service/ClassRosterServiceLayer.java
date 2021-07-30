/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 30, 2021
 * purpose: (TODO)
 */

package com.bm.classroster.service;

import com.bm.classroster.dao.ClassRosterPersistenceException;
import com.bm.classroster.dto.Student;
import java.util.List;


public interface ClassRosterServiceLayer {
    void createStudent(Student student) throws
        ClassRosterDuplicateIdException,
        ClassRosterDataValidationException,
        ClassRosterPersistenceException;
    
    List<Student> getAllStudents() throws ClassRosterPersistenceException;
    
    Student getStudent(String studentId) throws ClassRosterPersistenceException;
    
    Student removeStudent(String studentId) throws 
        ClassRosterPersistenceException;
}
