package com.outseta.exception.api_exception;

import com.outseta.exception.OutsetaAPIException;

import java.util.Map;

public class OutsetaInvalidResponseCodeException extends OutsetaAPIException {

    public OutsetaInvalidResponseCodeException(String reason, String url, String payload, Map<String, Object> parameters,
                                               Map<String, String> headers, Integer responseCode, Exception triggeredBy) {
        super(reason, url, payload, parameters, headers, responseCode, triggeredBy);
    }
}
