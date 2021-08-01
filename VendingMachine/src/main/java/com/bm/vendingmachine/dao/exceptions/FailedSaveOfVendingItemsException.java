package com.bm.vendingmachine.dao.exceptions;

/**
 * @author Benjamin Munoz
 */
public class FailedSaveOfVendingItemsException extends Exception {
    public FailedSaveOfVendingItemsException(String msg) {
        super(msg);
    }

    public FailedSaveOfVendingItemsException(String message, Throwable cause) {
        super(message, cause);
    }
}
