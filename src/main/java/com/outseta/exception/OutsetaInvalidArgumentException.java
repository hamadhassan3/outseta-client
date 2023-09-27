package com.outseta.exception;

/**
 * This class is used to represent an exception that occurred due to an invalid
 * argument.
 */
public class OutsetaInvalidArgumentException extends Exception {

    /**
     * This constructor is used to create a new
     * OutsetaInvalidArgumentException object.
     * @param message The message of the exception.
     */
    public OutsetaInvalidArgumentException(final String message) {
        super(message);
    }
}
