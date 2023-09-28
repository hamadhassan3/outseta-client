package com.outseta.exception;

/**
 * This exception is thrown when the page builder fails to build a page.
 */
public class OutsetaPageBuildException extends Exception {

    /**
     * Constructs a new OutsetaPageBuildException with the specified
     * detail message.
     *
     * @param message the detail message
     */
    public OutsetaPageBuildException(final String message) {
        super(message);
    }

}
