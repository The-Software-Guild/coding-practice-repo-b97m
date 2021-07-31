/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.classroster.dao;

import com.bm.classroster.dao.ClassRosterDao;
import com.bm.classroster.dao.ClassRosterDaoFileImpl;
import com.bm.classroster.dto.Student;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Benjamin Munoz
 */
public class ClassRosterDaoFileImplTest {
    
    ClassRosterDao testDao;
    
    public ClassRosterDaoFileImplTest() {
    }
    
    @BeforeEach
    public void setUp() throws IOException {
        String testFile = "testroster.txt";
        // done solely to initialize the above file
        new FileWriter(testFile);
        
        testDao = new ClassRosterDaoFileImpl(testFile);
    }
    
    @Test
    public void testAddGetStudent() throws Exception {
        String studentId = "0001";
        Student student = new Student(studentId);
        student.setFirstName("Ada");
        student.setLastName("Lovelace");
        student.setCohort("Java-May-1845");
        
        testDao.addStudent(studentId, student);
        
        Student retrievedStudent = testDao.getStudent(studentId);
        
        assertEquals(
            student.getStudentId(), 
            retrievedStudent.getStudentId(), 
            "Checking student id."
        );
        assertEquals(
            student.getFirstName(),
            retrievedStudent.getFirstName(),
            "Checking student first name."
        );
        assertEquals(
            student.getLastName(),
            retrievedStudent.getLastName(),
            "Checking student last name."
        );
        assertEquals(
            student.getCohort(),
            retrievedStudent.getCohort(),
            "Checking student cohort."
        );
    }
    
    @Test
    public void testAddGetAllStudents() throws Exception {
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1845");
        
        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1845");
        
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        testDao.addStudent(secondStudent.getStudentId(), secondStudent);
        
        List<Student> allStudents = testDao.getAllStudents();
        
        assertNotNull(allStudents, "The list of students must not be null");
        assertEquals(
            2, 
            allStudents.size(), 
            "List of students should have two students"
        );
        
        assertTrue(
            allStudents.contains(firstStudent), 
            "The list of students should include Ada."
        );
        assertTrue(
            allStudents.contains(secondStudent),
            "The list of students should include Charles."
        );
    }

    @Test
    public void testRemoveStudent() throws Exception {
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1845");
        
        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1845");
        
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        testDao.addStudent(secondStudent.getStudentId(), secondStudent);
        
        Student removedStudent = testDao.removeStudent(
            firstStudent.getStudentId()
        );
        
        assertEquals(
            removedStudent, 
            firstStudent, 
            "The removed student should be Ada."
        );
        
        List<Student> allStudents = testDao.getAllStudents();
        
        assertNotNull(allStudents, "All students list should not be null.");
        assertEquals(
            1, 
            allStudents.size(), 
            "All students should have only one student."
        );
        
        removedStudent = testDao.removeStudent(secondStudent.getStudentId());
        assertEquals(
            removedStudent, 
            secondStudent, 
            "The removed student should be Charles."
        );
        
        allStudents = testDao.getAllStudents();
        assertTrue(
            allStudents.isEmpty(), 
            "The retrieved list of students should be empty."
        );
        
        Student retrievedStudent = testDao.getStudent(
            firstStudent.getStudentId()
        );
        assertNull(retrievedStudent, "Ada was removed, so this should be null");
        
        retrievedStudent = testDao.getStudent(secondStudent.getStudentId());
        assertNull(
            retrievedStudent, 
            "Charles was removed, so this should be null"
        );
    }
}
