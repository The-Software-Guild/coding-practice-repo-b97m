package com.bm.vendingmachine.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 31, 2021
 */
public class VendingMachineAuditDaoConsoleImpl implements VendingMachineAuditDao {

    public static final String AUDIT_FILE = "audit.txt";
    private PrintWriter writer;
    private boolean writerAvailable;
    
    public VendingMachineAuditDaoConsoleImpl() {
        try {
            writer = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException ex) {
        }
    }
    
    @Override
    public void appendRecord(String s) {
        if (writer != null) {
          writer.println(s);            
        }
    }
    
    @Override
    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
