package com.outseta.exception;

import java.util.Map;

/**
 * This class is used to represent an exception that occurred while making a
 * request to the Outseta API.
 */
public class OutsetaAPIException extends Exception {

    /**
     * The url on which the exception occurred.
     */
    private String url;

    /**
     * The payload of the request that caused the exception.
     */
    private String payload;

    /**
     * The parameters of the request that caused the exception.
     */
    private Map<String, Object> parameters;

    /**
     * The headers of the request that caused the exception.
     */
    private Map<String, String> headers;

    /**
     * The response code of the request that caused the exception.
     */
    private Integer responseCode;

    /**
     * The exception that caused this exception to be thrown.
     */
    private Exception triggeredBy;

    /**
     * This constructor is used to create a new OutsetaAPIException object.
     * @param reason The reason for the exception.
     */
    public OutsetaAPIException(final String reason) {
        super(reason);
    }

    /**
     * This constructor is used to create a new OutsetaAPIException object.
     * @param reason The reason for the exception.
     * @param pUrl The url on which the exception occurred.
     * @param pPayload The payload of the request that caused the exception.
     * @param pParameters The parameters of the request that caused the
     *                   exception.
     * @param pHeaders The headers of the request that caused the exception.
     * @param pResponseCode The response code of the request that caused the
     *                     exception.
     * @param pTriggeredBy The exception that caused this exception to be
     *                     thrown.
     */
    public OutsetaAPIException(final String reason, final String pUrl,
                               final String pPayload,
                               final Map<String, Object> pParameters,
                               final Map<String, String> pHeaders,
                               final Integer pResponseCode,
                               final Exception pTriggeredBy) {
        super(reason);
        this.url = pUrl;
        this.payload = pPayload;
        this.parameters = pParameters;
        this.headers = pHeaders;
        this.responseCode = pResponseCode;
        this.triggeredBy = pTriggeredBy;
    }

    /**
     * Returns the url on which the exception occurred.
     * @return The url on which the exception occurred.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url on which the exception occurred.
     * @param pUrl The url on which the exception occurred.
     */
    public void setUrl(final String pUrl) {
        this.url = pUrl;
    }

    /**
     * Returns the parameters of the request that caused the exception.
     * @return The parameters of the request that caused the exception.
     */
    public Map<String, Object> getParameters() {
        return parameters;
    }

    /**
     * Sets the parameters of the request that caused the exception.
     * @param pParameters The parameters of the request that caused the
     *                    exception.
     */
    public void setParameters(final Map<String, Object> pParameters) {
        this.parameters = pParameters;
    }

    /**
     * Returns the headers of the request that caused the exception.
     * @return The headers of the request that caused the exception.
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Sets the headers of the request that caused the exception.
     * @param pHeaders The headers of the request that caused the exception.
     */
    public void setHeaders(final Map<String, String> pHeaders) {
        this.headers = pHeaders;
    }

    /**
     * Returns the payload of the request that caused the exception.
     * @return The payload of the request that caused the exception.
     */
    public Integer getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the payload of the request that caused the exception.
     * @param pResponseCode The payload of the request that caused the
     *                      exception.
     */
    public void setResponseCode(final Integer pResponseCode) {
        this.responseCode = pResponseCode;
    }

    /**
     * Returns the exception that caused this exception to be thrown.
     * @return The exception that caused this exception to be thrown.
     */
    public Exception getTriggeredBy() {
        return triggeredBy;
    }

    /**
     * Sets the exception that caused this exception to be thrown.
     * @param pTriggeredBy The exception that caused this exception to be
     *                     thrown.
     */
    public void setTriggeredBy(final Exception pTriggeredBy) {
        this.triggeredBy = pTriggeredBy;
    }

    /**
     * Gets the payload.
     * @return The payload.
     */
    public String getPayload() {
        return payload;
    }

    /**
     * Sets the payload.
     * @param pPayload The payload.
     */
    public void setPayload(final String pPayload) {
        this.payload = pPayload;
    }
}
