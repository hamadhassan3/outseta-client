package com.outseta.exception.api_exception;

import com.outseta.exception.OutsetaAPIException;

import java.util.Map;

/**
 * This class is used to represent an exception that occurred due to a bad
 * request to the Outseta API.
 */
public class OutsetaAPIBadRequestException extends OutsetaAPIException {

    /**
     * This constructor is used to create a new OutsetaAPIBadRequestException.
     * @param reason The reason for the exception.
     */
    public OutsetaAPIBadRequestException(final String reason) {
        super(reason);
    }

    /**
     * This constructor is used to create a new OutsetaAPIBadRequestException
     * object.
     * @param reason The reason for the exception.
     * @param url The url on which the exception occurred.
     * @param payload The payload of the request that caused the exception.
     * @param parameters The parameters of the request that caused the
     *                   exception.
     * @param headers The headers of the request that caused the exception.
     * @param responseCode The response code of the request that caused the
     *                     exception.
     * @param triggeredBy The exception that caused this exception to be thrown.
     */
    public OutsetaAPIBadRequestException(final String reason, final String url,
                                         final String payload,
                                         final Map<String, Object> parameters,
                                         final Map<String, String> headers,
                                         final Integer responseCode,
                                         final Exception triggeredBy) {
        super(reason, url, payload, parameters, headers,
                responseCode, triggeredBy);
    }
}
