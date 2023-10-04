package com.outseta.constant;

/**
 * This enum is used to indicate the type of request maker to use.
 */
public enum RequestMakerType {
    /**
     * This enum value is used to indicate that the request maker should be
     * created using the HttpClient.
     */
    HTTP_CLIENT,
    /**
     * This enum value is used to indicate that the request maker should be
     * created using the Default implementation.
     */
    DEFAULT,

    /**
     * This enum value is used to indicate that the request maker is invalid.
     */
    INVALID
}
