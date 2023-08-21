package com.outseta.client_helper.request_maker;

import java.util.Map;

public interface RequestMaker {
    String get(String url, Map<String, Object> parameters, Map<String, String> headers);
    String put(String url, Map<String, Object> parameters, String payload, Map<String, String> headers);
    String post(String url, Map<String, Object> parameters, String payload, Map<String, String> headers);
    String patch(String url, Map<String, Object> parameters, String payload, Map<String, String> headers);
    String delete(String url, Map<String, Object> parameters, Map<String, String> headers);
}
