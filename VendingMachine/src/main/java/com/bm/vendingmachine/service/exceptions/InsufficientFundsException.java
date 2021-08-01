package com.bm.vendingmachine.service.exceptions;

/**
 * @author Benjamin Munoz
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) {
        super(msg);
    }

    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
}
