package com.outseta.client_helper.request_maker;

import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * This class is intentionally non-public. No one needs to know about its
 * existence and user must use RequestMakerFactory.
 *
 * This class gives a generic, reusable implementation of the relevant HTTP
 * endpoints. There are multiple frameworks available for sending HTTP
 * requests in Java and this class uses HttpClient for this purpose. If in the
 * future a different framework is needed, a new implementation of RequestMaker
 * will be needed that would use the relevant library.
 *
 * This class depends on HttpClient from Java 11. Due to this dependency,
 * the client cannot be used with earlier versions of Java.
 */
class RequestMakerHttpClient implements RequestMaker {

    private final HttpClient httpClient;

    public RequestMakerHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public RequestMakerHttpClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    private HttpRequest.Builder generateRequest(String url,
                                                Map<String, Object> parameters,
                                                Map<String, String> headers) throws OutsetaInvalidURLException {

        HttpRequest.Builder builder = HttpRequest.newBuilder();

        // Using string builder for efficient string manipulation
        StringBuilder stringBuilder = new StringBuilder(url);

        // Inserting all headers into request
        if(headers != null) {
            headers.forEach(builder::header);
        }

        // Inserting all parameters into the url
        if(parameters != null) {
            if (!parameters.entrySet().isEmpty()) {
                stringBuilder.append("?");
            }

            parameters.forEach((key, value) -> stringBuilder.append(key).append("=").append(value).append("&"));

            // Deleting the trailing &
            if (!parameters.entrySet().isEmpty()) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }

        try {
            builder.uri(URI.create(stringBuilder.toString()));
        }
        catch (NullPointerException e){
            throw new OutsetaInvalidURLException("The url provided was null");
        }
        catch (IllegalArgumentException e){
            throw new OutsetaInvalidURLException(stringBuilder.toString());
        }

        return builder;
    }

    @Override
    public String get(String url, Map<String, Object> parameters, Map<String, String> headers) throws OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaInvalidResponseCodeException, OutsetaAPIUnknownException, OutsetaInvalidURLException {
        HttpRequest httpRequest = this.generateRequest(url, parameters, headers)
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new OutsetaAPIBadRequestException(e.getMessage(), url, null, parameters, headers, null, e);
        } catch (InterruptedException e) {
            throw new OutsetaAPIFailedException(e.getMessage(), url, null, parameters, headers, null, e);
        }

        if(response == null){
            throw new OutsetaAPIUnknownException("An unknown error occurred in the api call to " + url,
                    url, null, parameters, headers, null, null);
        }
        if(response.statusCode() < 200 || response.statusCode() > 299) {
            // Didn't receive success from outseta
            throw new OutsetaInvalidResponseCodeException(response.body(), url, null, parameters,
                    headers, response.statusCode(), null);
        }

        return response.body();
    }

    @Override
    public String put(String url, Map<String, Object> parameters, String payload, Map<String, String> headers) throws OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException, OutsetaInvalidResponseCodeException, OutsetaInvalidURLException {
        HttpRequest httpRequest = this.generateRequest(url, parameters, headers)
                .PUT(HttpRequest.BodyPublishers.ofString(payload, StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new OutsetaAPIBadRequestException(e.getMessage(), url, payload, parameters, headers, null, e);
        } catch (InterruptedException e) {
            throw new OutsetaAPIFailedException(e.getMessage(), url, payload, parameters, headers, null, e);
        }

        if(response == null){
            throw new OutsetaAPIUnknownException("An unknown error occurred in the api call to " + url,
                    url, payload, parameters, headers, null, null);
        }
        if(response.statusCode() < 200 || response.statusCode() > 299) {
            // Didn't receive success from outseta
            throw new OutsetaInvalidResponseCodeException(response.body(), url, payload, parameters,
                    headers, response.statusCode(), null);
        }

        return response.body();
    }

    @Override
    public String post(String url, Map<String, Object> parameters, String payload, Map<String, String> headers) throws OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException, OutsetaInvalidResponseCodeException, OutsetaInvalidURLException {
        HttpRequest httpRequest = this.generateRequest(url, parameters, headers)
                .POST(HttpRequest.BodyPublishers.ofString(payload, StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new OutsetaAPIBadRequestException(e.getMessage(), url, payload, parameters, headers, null, e);
        } catch (InterruptedException e) {
            throw new OutsetaAPIFailedException(e.getMessage(), url, payload, parameters, headers, null, e);
        }

        if(response == null){
            throw new OutsetaAPIUnknownException("An unknown error occurred in the api call to " + url,
                    url, payload, parameters, headers, null, null);
        }
        if(response.statusCode() < 200 || response.statusCode() > 299) {
            // Didn't receive success from outseta
            throw new OutsetaInvalidResponseCodeException(response.body(), url, payload, parameters,
                    headers, response.statusCode(), null);
        }

        return response.body();
    }

    @Override
    public String delete(String url, Map<String, Object> parameters, Map<String, String> headers) throws OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException, OutsetaInvalidResponseCodeException, OutsetaInvalidURLException {
        HttpRequest httpRequest = this.generateRequest(url, parameters, headers)
                .DELETE()
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new OutsetaAPIBadRequestException(e.getMessage(), url, null, parameters, headers, null, e);
        } catch (InterruptedException e) {
            throw new OutsetaAPIFailedException(e.getMessage(), url, null, parameters, headers, null, e);
        }

        if(response == null){
            throw new OutsetaAPIUnknownException("An unknown error occurred in the api call to " + url,
                    url, null, parameters, headers, null, null);
        }
        if(response.statusCode() < 200 || response.statusCode() > 299) {
            // Didn't receive success from outseta
            throw new OutsetaInvalidResponseCodeException(response.body(), url, null, parameters,
                    headers, response.statusCode(), null);
        }

        return response.body();
    }

}
