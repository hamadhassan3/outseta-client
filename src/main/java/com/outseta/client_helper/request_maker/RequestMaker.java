package com.outseta.client_helper.request_maker;

import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;

import java.util.Map;

public interface RequestMaker {
    String get(String url, Map<String, Object> parameters, Map<String, String> headers) throws OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaInvalidResponseCodeException, OutsetaAPIUnknownException, OutsetaInvalidURLException;
    String put(String url, Map<String, Object> parameters, String payload, Map<String, String> headers) throws OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaInvalidResponseCodeException, OutsetaAPIUnknownException, OutsetaInvalidURLException;
    String post(String url, Map<String, Object> parameters, String payload, Map<String, String> headers) throws OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaInvalidResponseCodeException, OutsetaAPIUnknownException, OutsetaInvalidURLException;
    String delete(String url, Map<String, Object> parameters, Map<String, String> headers) throws OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaInvalidResponseCodeException, OutsetaAPIUnknownException, OutsetaInvalidURLException;
}
