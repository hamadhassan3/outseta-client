package com.outseta.exception;

/**
 * This exception is thrown when the request maker is invalid.
 */
public class OutsetaInvalidRequestMakerException extends Exception {

    /**
     * This constructor is used to create an OutsetaInvalidRequestMakerException
     * with a message.
     * @param message The message to be used.
     */
    public OutsetaInvalidRequestMakerException(final String message) {
        super(message);
    }
}
