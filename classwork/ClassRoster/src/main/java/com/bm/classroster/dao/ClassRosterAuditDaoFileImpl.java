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

package com.bm.classroster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao {
    public static final String AUDIT_FILE = "audit.txt";
    
    @Override
    public void writeAuditEntry(String entry)
        throws ClassRosterPersistenceException {
        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException ex) {
            throw new ClassRosterPersistenceException(
                "Could not persist audit information", 
                ex
            );
        }
        
        out.println(String.format("%s : %s%n",
            LocalDateTime.now().toString(),
            entry
        ));
        out.flush();
    }
}
