/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.classroster.dao;

import com.bm.classroster.dto.Student;
import java.util.List;


public interface ClassRosterDao {
    /**
     * Adds the given Student to the roster and associates it with the given
     * student id.If there already exists a student with the given id, that 
 student will be returned. Otherwise, null will be returned.
     * 
     * @param studentId
     * @param student
     * @return The Student associated with the student id if it exists, null otherwise
     * @throws com.bm.classroster.dao.ClassRosterDaoException
     */
    Student addStudent(String studentId, Student student) throws ClassRosterDaoException;
    
    /**
     * Returns a List of all students in the roster.
     * 
     * @return List containing all students in the roster
     * @throws com.bm.classroster.dao.ClassRosterDaoException
     */
    List<Student> getAllStudents() throws ClassRosterDaoException;
    
    /**
     * Returns the student object associated with a given student id.Returns null if such a student does not exist
     * 
     * @param studentId
     * @return The student associated with the given student id, or null otherwise
     * @throws com.bm.classroster.dao.ClassRosterDaoException
     */
    Student getStudent(String studentId) throws ClassRosterDaoException;
    
    /**
     * Removes from the roster the student associated with the given id.If such a student exists, it is also returned.
     * Otherwise, null is returned
     * @param studentId
     * @return The student that was removed and associated with the given id. Otherwise, null
     * @throws com.bm.classroster.dao.ClassRosterDaoException
     */
    Student removeStudent(String studentId) throws ClassRosterDaoException;
}
