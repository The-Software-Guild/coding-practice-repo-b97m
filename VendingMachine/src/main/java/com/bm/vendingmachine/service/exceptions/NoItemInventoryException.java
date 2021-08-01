package com.bm.vendingmachine.service.exceptions;

/**
 * @author Benjamin Munoz
 */
public class NoItemInventoryException extends Exception {
    public NoItemInventoryException(String msg) {
        super(msg);
    }

    public NoItemInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
