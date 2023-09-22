package com.outseta.exception;

import java.util.Map;

public class OutsetaAPIException extends Exception {

    private String url;
    private String payload;
    private Map<String, Object> parameters;
    private Map<String, String> headers;
    private Integer responseCode;
    private Exception triggeredBy;
    public OutsetaAPIException(String reason, String url, String payload, Map<String, Object> parameters,
                               Map<String, String> headers, Integer responseCode, Exception triggeredBy){
        super(reason);
        this.url = url;
        this.payload = payload;
        this.parameters = parameters;
        this.headers = headers;
        this.responseCode = responseCode;
        this.triggeredBy = triggeredBy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Exception getTriggeredBy() {
        return triggeredBy;
    }

    public void setTriggeredBy(Exception triggeredBy) {
        this.triggeredBy = triggeredBy;
    }
}
