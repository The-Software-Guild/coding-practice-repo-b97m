/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 30, 2021
 * purpose: (TODO)
 */

package com.bm.classroster.service;

public class ClassRosterDataValidationException extends Exception {
    public ClassRosterDataValidationException(String message) {
        super(message);
    }

    public ClassRosterDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
