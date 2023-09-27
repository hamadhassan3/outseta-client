package com.outseta.exception;

/**
 * This class is used to represent an exception that occurred due to an invalid
 * URL.
 */
public class OutsetaInvalidURLException extends Exception {

    /**
     * The url that caused the exception.
     */
    private String url;

    /**
     * This constructor is used to create a new OutsetaInvalidURLException
     * object.
     * @param pUrl The url that caused the exception.
     */
    public OutsetaInvalidURLException(final String pUrl) {
        super("Invalid URL: " + pUrl);
        this.url = pUrl;
    }

}
