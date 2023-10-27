package com.outseta.client_helper.request_maker;

import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
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

    /**
     * This field is used to make the HTTP requests.
     */
    private final HttpClient httpClient;

    /**
     * This field is used to store the minimum success code.
     */
    private static final int MIN_SUCCESS_CODE = 200;

    /**
     * This field is used to store the maximum success code.
     */
    private static final int MAX_SUCCESS_CODE = 299;

    /**
     * This constructor is used to create a RequestMakerHttpClient object with
     * a custom HttpClient.
     * @param pHttpClient The HttpClient to be used to make the requests.
     */
    RequestMakerHttpClient(final HttpClient pHttpClient) {
        this.httpClient = pHttpClient;
    }

    /**
     * This constructor is used to create a RequestMakerHttpClient object with
     * the default HttpClient.
     */
    RequestMakerHttpClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    /**
     * This method is used to generate a HttpRequest object from the url,
     * parameters and headers.
     * @param url The url to make the request to.
     * @param parameters The parameters to be added to the request.
     * @param headers The headers to be added to the request.
     * @return The HttpRequest object.
     * @throws OutsetaInvalidURLException If the url is invalid.
     */
    private HttpRequest.Builder generateRequest(final String url,
                                                final Map<String, Object>
                                                        parameters,
                                                final Map<String, String>
                                                        headers)
            throws OutsetaInvalidURLException {

        HttpRequest.Builder builder = HttpRequest.newBuilder();

        // Using string builder for efficient string manipulation
        if (url == null) {
            throw new OutsetaInvalidURLException("URL cannot be null.");
        }
        StringBuilder stringBuilder = new StringBuilder(url);

        // Inserting all headers into request
        if (headers != null) {
            headers.forEach(builder::header);
        }

        // Inserting all parameters into the url
        if (parameters != null) {
            if (!parameters.entrySet().isEmpty()) {
                stringBuilder.append("?");
            }

            parameters.forEach((key, value) -> stringBuilder.append(key)
                    .append("=").append(value).append("&"));

            // Deleting the trailing &
            if (!parameters.entrySet().isEmpty()) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }

        try {
            builder.uri(URI.create(stringBuilder.toString()));
        } catch (IllegalArgumentException e) {
            throw new OutsetaInvalidURLException(stringBuilder.toString());
        }

        return builder;
    }

    @Override
    public String get(final String url, final Map<String, Object> parameters,
                      final Map<String, String> headers) throws
                        OutsetaAPIBadRequestException,
                        OutsetaAPIFailedException,
                        OutsetaInvalidResponseCodeException,
                        OutsetaAPIUnknownException,
                        OutsetaInvalidURLException {

        HttpRequest httpRequest = this.generateRequest(url, parameters, headers)
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new OutsetaAPIBadRequestException(
                    e.getMessage(), url, null, parameters, headers, null, e);
        } catch (InterruptedException e) {
            throw new OutsetaAPIFailedException(
                    e.getMessage(), url, null, parameters, headers, null, e);
        }

        if (response == null) {
            throw new OutsetaAPIUnknownException(
                    "An unknown error occurred in the api call to " + url,
                    url, null, parameters, headers, null, null);
        }

        if (response.statusCode() < MIN_SUCCESS_CODE
                || response.statusCode() > MAX_SUCCESS_CODE) {
            // Didn't receive success from outseta
            throw new OutsetaInvalidResponseCodeException(
                    response.body(), url, null, parameters,
                    headers, response.statusCode(), null);
        }

        return response.body();
    }

    @Override
    public String put(final String url, final Map<String, Object> parameters,
                      final String payload, final Map<String, String> headers)
                        throws
                            OutsetaAPIBadRequestException,
                            OutsetaAPIFailedException,
                            OutsetaAPIUnknownException,
                            OutsetaInvalidResponseCodeException,
                            OutsetaInvalidURLException {

        HttpRequest httpRequest = this.generateRequest(url,
                        parameters, headers)
                .PUT(HttpRequest.BodyPublishers.ofString(payload,
                        StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new OutsetaAPIBadRequestException(
                    e.getMessage(), url, payload, parameters, headers, null, e);
        } catch (InterruptedException e) {
            throw new OutsetaAPIFailedException(
                    e.getMessage(), url, payload, parameters, headers, null, e);
        }

        if (response == null) {
            throw new OutsetaAPIUnknownException(
                    "An unknown error occurred in the api call to " + url,
                    url, payload, parameters, headers, null, null);
        }
        if (response.statusCode() < MIN_SUCCESS_CODE
                || response.statusCode() > MAX_SUCCESS_CODE) {
            // Didn't receive success from outseta
            throw new OutsetaInvalidResponseCodeException(
                    response.body(), url, payload, parameters,
                    headers, response.statusCode(), null);
        }

        return response.body();
    }

    @Override
    public String post(final String url, final Map<String, Object> parameters,
                       final String payload, final Map<String, String> headers)
                        throws
                            OutsetaAPIBadRequestException,
                            OutsetaAPIFailedException,
                            OutsetaAPIUnknownException,
                            OutsetaInvalidResponseCodeException,
                            OutsetaInvalidURLException {

        HttpRequest httpRequest = this.generateRequest(url,
                        parameters, headers)
                .POST(HttpRequest.BodyPublishers.ofString(payload,
                        StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new OutsetaAPIBadRequestException(
                    e.getMessage(), url, payload, parameters, headers, null, e);
        } catch (InterruptedException e) {
            throw new OutsetaAPIFailedException(
                    e.getMessage(), url, payload, parameters, headers, null, e);
        }

        if (response == null) {
            throw new OutsetaAPIUnknownException(
                    "An unknown error occurred in the api call to " + url,
                    url, payload, parameters, headers, null, null);
        }
        if (response.statusCode() < MIN_SUCCESS_CODE
                || response.statusCode() > MAX_SUCCESS_CODE) {

            // Didn't receive success from outseta
            throw new OutsetaInvalidResponseCodeException(
                    response.body(), url, payload, parameters,
                    headers, response.statusCode(), null);
        }

        return response.body();
    }

    @Override
    public String delete(final String url, final Map<String, Object> parameters,
                         final Map<String, String> headers) throws
                            OutsetaAPIBadRequestException,
                            OutsetaAPIFailedException,
                            OutsetaAPIUnknownException,
                            OutsetaInvalidResponseCodeException,
                            OutsetaInvalidURLException {

        HttpRequest httpRequest = this.generateRequest(url, parameters, headers)
                .DELETE()
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new OutsetaAPIBadRequestException(
                    e.getMessage(), url, null, parameters, headers, null, e);
        } catch (InterruptedException e) {
            throw new OutsetaAPIFailedException(
                    e.getMessage(), url, null, parameters, headers, null, e);
        }

        if (response == null) {
            throw new OutsetaAPIUnknownException(
                    "An unknown error occurred in the api call to " + url,
                    url, null, parameters, headers, null, null);
        }
        if (response.statusCode() < MIN_SUCCESS_CODE
                || response.statusCode() > MAX_SUCCESS_CODE) {
            // Didn't receive success from outseta
            throw new OutsetaInvalidResponseCodeException(
                    response.body(), url, null, parameters,
                    headers, response.statusCode(), null);
        }

        return response.body();
    }

    @Override
    public String urlEncodePayloadAttribute(final String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

}
