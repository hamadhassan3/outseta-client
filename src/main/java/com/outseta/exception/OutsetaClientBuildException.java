package com.outseta.exception;

/**
 * This class is used to represent an exception that occurred while building
 * the Outseta client.
 */
public class OutsetaClientBuildException extends Exception {

    /**
     * This constructor is used to create a new OutsetaClientBuildException
     * object.
     * @param reason The reason for the exception.
     */
    public OutsetaClientBuildException(final String reason) {
        super(reason);
    }
}
