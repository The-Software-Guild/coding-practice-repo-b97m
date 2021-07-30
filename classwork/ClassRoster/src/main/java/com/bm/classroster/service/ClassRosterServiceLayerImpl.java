/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 30, 2021
 * purpose: (TODO)
 */

package com.bm.classroster.service;

import com.bm.classroster.dao.ClassRosterAuditDao;
import com.bm.classroster.dao.ClassRosterDao;
import com.bm.classroster.dao.ClassRosterPersistenceException;
import com.bm.classroster.dto.Student;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

    private ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    @Override
    public void createStudent(Student student) throws 
        ClassRosterDuplicateIdException, 
        ClassRosterDataValidationException, 
        ClassRosterPersistenceException {
        
        if (Objects.nonNull(dao.getStudent(student.getStudentId()))) {
            throw new ClassRosterDuplicateIdException(String.format(
                "ERROR: Could not create student. Student ID %s already exists",
                student.getStudentId()
            ));
        }
        
        validateStudentData(student);
        
        dao.addStudent(student.getStudentId(), student);
        
        auditDao.writeAuditEntry(String.format(
            "Student %s CREATED", 
            student.getStudentId()
        ));
    }

    @Override
    public List<Student> getAllStudents() throws 
        ClassRosterPersistenceException {
        
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws
        ClassRosterPersistenceException {
        
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws 
        ClassRosterPersistenceException {
        
        Student removedStudent = dao.removeStudent(studentId);
        auditDao.writeAuditEntry(String.format(
            "Student %s REMOVED.", 
            removedStudent.getStudentId()
        ));
        
        return removedStudent;
    }
    
    private void validateStudentData(Student student) throws
        ClassRosterDataValidationException {
        
        Predicate<String> nullOrTrimEmpty = s -> {
            return (s == null) || (s.trim().length() == 0);
        };
        
        if (nullOrTrimEmpty.test(student.getFirstName())
            || nullOrTrimEmpty.test(student.getLastName())
            || nullOrTrimEmpty.test(student.getCohort())) {
            
            throw new ClassRosterDataValidationException(
                "ERROR: All fields [First Name, Last Name, Cohort] are required"
            );
        }
    }
}