package com.bm.vendingmachine.dao.exceptions;

/**
 * @author Benjamin Munoz
 */
public class FailedLoadOfVendingItemsException extends Exception {
    public FailedLoadOfVendingItemsException(String msg) {
        super(msg);
    }

    public FailedLoadOfVendingItemsException(String message, Throwable cause) {
        super(message, cause);
    }
}
