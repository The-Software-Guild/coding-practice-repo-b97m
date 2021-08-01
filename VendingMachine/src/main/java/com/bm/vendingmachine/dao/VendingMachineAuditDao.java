package com.bm.vendingmachine.dao;

/**
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 31, 2021
 */
public interface VendingMachineAuditDao {
    public void appendRecord(String s);
    public void close();
}
