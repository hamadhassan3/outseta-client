package com.outseta.exception;

import com.outseta.exception.OutsetaAPIException;

public class OutsetaInvalidURLException extends Exception {

    private String url;

    public OutsetaInvalidURLException(String url) {
        super("Invalid URL: " + url);
        this.url = url;
    }

}
