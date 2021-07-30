/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.classroster.dao;

import com.bm.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class ClassRosterDaoFileImpl implements ClassRosterDao {
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, Student> students = new HashMap<>();
    
    @Override
    public Student addStudent(String studentId, Student student)
        throws ClassRosterPersistenceException {
        loadRoster();
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        loadRoster();
        return new ArrayList<>(students.values());
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        loadRoster();
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }

    /**
     * Converts a String representation of a Student
     * to the Student it represents
     * 
     * Such representation is assumed to follow the grammar
     * S =: STUDENT_ID::STUDENT_FNAME::STUDENT_LNAME::COHORT
     * 
     * @param studentAsText
     * @return The student based on this string representation
     */
    private Student unmarshallStudent(String studentAsText) {
        String[] tokens = studentAsText.split(DELIMITER);
        
        Student studentFromFile = new Student(tokens[0]);
        studentFromFile.setFirstName(tokens[1]);
        studentFromFile.setLastName(tokens[2]);
        studentFromFile.setCohort(tokens[3]);
        
        return studentFromFile;
    }
    
    private void loadRoster() throws ClassRosterPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                new BufferedReader(new FileReader(ROSTER_FILE))
            );
        } catch (FileNotFoundException ex) {
            throw new ClassRosterPersistenceException(
                "-_- Could not load roster data into memory.", ex
            );
        }
        
        while (scanner.hasNextLine()) {
            Student currStudent = unmarshallStudent(scanner.nextLine());
            students.put(currStudent.getStudentId(), currStudent);
        }
        
        scanner.close();
    }
    
    /**
     * Converts a student into a string representation
     * This representation follows the grammar
     * S =: STUDENT_ID::STUDENT_FNAME::STUDENT_LNAME::COHORT
     * 
     * It is intended for file storage of students
     * 
     * @param aStudent
     * @return the string representation of this student
     */
    private String marshallStudent(Student aStudent) {
        return String.format(
            "%s::%s::%s::%s",
            aStudent.getStudentId(),
            aStudent.getFirstName(),
            aStudent.getLastName(),
            aStudent.getCohort()
        );
    }
    
    private void writeRoster() throws ClassRosterPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException ex) {
            throw new ClassRosterPersistenceException(
                "Could not save student data.",
                ex
            );
        }
        
        this.getAllStudents().stream().forEach(stud -> {
            out.println(marshallStudent(stud));
            out.flush();
        });
        
        out.close();
    }
}