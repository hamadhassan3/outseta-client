package com.outseta.client;

import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;

import java.util.HashMap;
import java.util.Map;

public class BaseClient {
    private final Map<String, String> headers;
    private RequestMaker requestMaker;
    private String baseUrl;
    private ParserFacade parserFacade;

    public BaseClient(String baseUrl) throws OutsetaClientBuildException {

        if(baseUrl == null) {
            throw new OutsetaClientBuildException("Error creating client. Base url cannot be null.");
        }

        this.baseUrl = baseUrl;

        this.requestMaker = null;
        this.headers = new HashMap<>();
        this.headers.put("Content-Type", "application/json");
        this.headers.put("Accept", "application/json");

        this.parserFacade = null;
    }

    public BaseClient(String baseUrl, Map<String, String> headers, RequestMaker requestMaker) throws OutsetaClientBuildException {

        if(baseUrl == null) {
            throw new OutsetaClientBuildException("Error creating client. Base url cannot be null.");
        }

        if(headers == null) {
            throw new OutsetaClientBuildException("Error creating client. Headers cannot be null.");
        }

        if(requestMaker == null) {
            throw new OutsetaClientBuildException("Error creating client. Request Maker cannot be null.");
        }

        this.headers = headers;
        this.requestMaker = requestMaker;
        this.baseUrl = baseUrl;

        if(!this.isHeadersValid()) {
            throw new OutsetaClientBuildException("Invalid headers for authentication client. Please check headers.");
        }
    }

    public boolean isHeadersValid(){
        return this.headers.containsKey("Authorization");
    }

    public void updateHeaders(Map<String, String> headers) throws OutsetaClientBuildException {
        if(headers == null){
            throw new OutsetaClientBuildException("Cannot assign null headers.");
        }
        this.headers.putAll(headers);
    }

    public void replaceHeaders(Map<String, String> headers) throws OutsetaClientBuildException {
        if(headers == null || !headers.containsKey("Authorization")){
            throw new OutsetaClientBuildException("Invalid headers for authentication client. Please check headers.");
        }
        this.headers.clear();
        this.headers.putAll(headers);
    }

    protected String get(String urlSuffix, Map<String, Object> parameters) throws OutsetaInvalidResponseCodeException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException, OutsetaInvalidURLException {
        return this.requestMaker.get(this.baseUrl + urlSuffix, parameters, this.headers);
    }
    protected String put(String urlSuffix, Map<String, Object> parameters, String payload) throws OutsetaInvalidResponseCodeException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaInvalidURLException, OutsetaAPIUnknownException {
        return this.requestMaker.put(this.baseUrl + urlSuffix, parameters, payload, this.headers);
    }
    protected String post(String urlSuffix, Map<String, Object> parameters, String payload) throws OutsetaInvalidResponseCodeException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaInvalidURLException, OutsetaAPIUnknownException {
        return this.requestMaker.post(this.baseUrl + urlSuffix, parameters, payload, this.headers);
    }
    protected String delete(String urlSuffix, Map<String, Object> parameters) throws OutsetaInvalidResponseCodeException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaInvalidURLException, OutsetaAPIUnknownException {
        return this.requestMaker.delete(this.baseUrl + urlSuffix, parameters, this.headers);
    }

    public void setRequestMaker(RequestMaker requestMaker) throws OutsetaClientBuildException {
        if(requestMaker == null) {
            throw new OutsetaClientBuildException("Request maker cannot be null.");
        }
        this.requestMaker = requestMaker;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) throws OutsetaClientBuildException {
        if(baseUrl == null) {
            throw new OutsetaClientBuildException("Error creating client. Base url cannot be null.");
        }
        this.baseUrl = baseUrl;
    }

    public RequestMaker getRequestMaker() {
        return requestMaker;
    }

    public ParserFacade getParserFacade() {
        return parserFacade;
    }

    public void setParserFacade(ParserFacade parserFacade) throws OutsetaClientBuildException {
        if(parserFacade == null) {
            throw new OutsetaClientBuildException("Parser facade cannot be null.");
        }
        this.parserFacade = parserFacade;
    }
}
