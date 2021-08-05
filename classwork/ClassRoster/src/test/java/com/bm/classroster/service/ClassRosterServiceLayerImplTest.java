/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.classroster.service;

import com.bm.classroster.dao.ClassRosterPersistenceException;
import com.bm.classroster.dto.Student;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author drive
 */
public class ClassRosterServiceLayerImplTest {

    private ClassRosterServiceLayer service;
    
    public ClassRosterServiceLayerImplTest() {
        /*
        service = new ClassRosterServiceLayerImpl(
            new ClassRosterDaoStubImpl(),
            new ClassRosterAuditDaoStubImpl()
        );
        */
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceLayer", ClassRosterServiceLayer.class);
    }

    @Test
    public void testCreateValidStudent() {
        Student student = new Student("0002");
        student.setFirstName("Charles");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");
        
        try {
            service.createStudent(student);
        } catch (ClassRosterPersistenceException 
                | ClassRosterDataValidationException 
                | ClassRosterDuplicateIdException ex) {
            
            fail("Student was valid. No exception should have been thrown");
        }
    }
    
    @Test
    public void testCreateStudentDuplicateId() {
        Student student = new Student("0001");
        student.setFirstName("Charles");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");
        
        try {
            service.createStudent(student);
            fail("Expected Duplicate Id Exception, but it was not thrown");
        } catch (ClassRosterPersistenceException | ClassRosterDataValidationException wrongEx) {
            fail("Expected Duplicate Id Exception, but a different one was thrown");
        } catch (ClassRosterDuplicateIdException ex) {
        }
    }
    
    @Test
    public void testCreateStudentInvalidData() throws Exception {
        Student student = new Student("0002");
        student.setFirstName("");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");
        
        try {
            service.createStudent(student);
            fail("Expected Validation Exception, but it was not thrown");
        } catch (ClassRosterPersistenceException | ClassRosterDuplicateIdException wrongEx) {
            fail("Expected Validation Exception, but a different one was thrown");
        } catch (ClassRosterDataValidationException ex) {            
        }
    }
    
    @Test
    public void testGetStudent() throws Exception {
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");
        
        Student shouldBeAda = service.getStudent("0001");
        assertNotNull(shouldBeAda, "Getting 0001 should not be null");
        assertEquals(
            testClone, 
            shouldBeAda, 
            "Student stored under 0001 should be Ada."
        );
        
        Student shouldBeNull = service.getStudent("0042");
        assertNull(shouldBeNull, "Getting 0042 should be null");
    }
}
