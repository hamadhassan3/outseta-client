package com.outseta.exception;

/**
 * This class is used to represent an exception that occurred due to an invalid
 * argument.
 */
public class OutsetaParseException extends Exception {

    /**
     * This constructor is used to create a new
     * OutsetaParseException object.
     * @param reason The reason for the exception.
     */
    public OutsetaParseException(final String reason) {
        super(reason);
    }
}
