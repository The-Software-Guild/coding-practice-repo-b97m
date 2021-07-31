/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 30, 2021
 * purpose: (TODO)
 */

package com.bm.classroster.service;

import com.bm.classroster.dao.ClassRosterDao;
import com.bm.classroster.dao.ClassRosterPersistenceException;
import com.bm.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;


public class ClassRosterDaoStubImpl implements ClassRosterDao {

    private Student onlyStudent;

    public ClassRosterDaoStubImpl() {
        onlyStudent = new Student("0001");
        onlyStudent.setFirstName("Ada");
        onlyStudent.setLastName("Lovelace");
        onlyStudent.setCohort("Java-May-1845");
    }
    
    @Override
    public Student addStudent(String studentId, Student student) throws 
        ClassRosterPersistenceException {

        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() throws
        ClassRosterPersistenceException {
        
        List<Student> studentList = new ArrayList<>();
        studentList.add(onlyStudent);
        return studentList;
    }

    @Override
    public Student getStudent(String studentId) throws 
        ClassRosterPersistenceException {
        
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public Student removeStudent(String studentId) throws 
        ClassRosterPersistenceException {
        
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

}
