package com.outseta.client_helper.request_maker;

import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
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
    private final CloseableHttpClient httpClient;

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
    RequestMakerHttpClient(final CloseableHttpClient pHttpClient) {
        this.httpClient = pHttpClient;
    }

    /**
     * This constructor is used to create a RequestMakerHttpClient object with
     * the default HttpClient.
     */
    RequestMakerHttpClient() {
        this.httpClient = HttpClients.createDefault();
    }

    /**
     * This method is used to generate a HttpRequest object from the url,
     * parameters and headers.
     * @param url The url to make the request to.
     * @param parameters The parameters to be added to the request.
     * @return The URI object.
     * @throws OutsetaInvalidURLException If the url is invalid.
     */
    private URI generateRequest(final String url,
                                final Map<String, Object> parameters)
            throws OutsetaInvalidURLException {

        if (url == null) {
            throw new OutsetaInvalidURLException("URL cannot be null.");
        }

        try {
            URIBuilder uriBuilder = new URIBuilder(url);

            // Inserting all parameters into the url
            if (parameters != null && !parameters.isEmpty()) {
                parameters.forEach((key, value) -> uriBuilder
                        .addParameter(key, String.valueOf(value)));
            }

            return uriBuilder.build();
        } catch (URISyntaxException e) {
            throw new OutsetaInvalidURLException("Invalid URI: "
                    + e.getMessage());
        }

    }

    @Override
    public String get(final String url, final Map<String, Object> parameters,
                      final Map<String, String> headers) throws
            OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaInvalidResponseCodeException,
            OutsetaAPIUnknownException,
            OutsetaInvalidURLException {

        URI uri = this.generateRequest(url, parameters);

        HttpGet request = new HttpGet(uri);

        // Inserting all headers into request
        if (headers != null && !headers.isEmpty()) {
            headers.forEach((key, value) -> request.addHeader(
                    new BasicHeader(key, value)));
        }

        HttpResponse response = null;
        try {
            HttpResponse httpResponse = httpClient.execute(request);

            if (httpResponse == null) {
                throw new OutsetaAPIUnknownException(
                        "Response is null.", url, "", parameters,
                        headers, null, null);
            }

            int statusCode = httpResponse.getStatusLine().getStatusCode();
            String responseBody = EntityUtils
                    .toString(httpResponse.getEntity());

            if (statusCode < MIN_SUCCESS_CODE
                    || statusCode > MAX_SUCCESS_CODE) {
                // Didn't receive success from outseta
                throw new OutsetaInvalidResponseCodeException(
                        responseBody, url, null, parameters,
                        headers, statusCode, null);
            }

            return responseBody;
        } catch (IOException e) {
            throw new OutsetaAPIBadRequestException(
                    e.getMessage(), url, null, parameters, headers, null, e);
        }
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

        URI uri = generateRequest(url, parameters);

        HttpPut httpPut = new HttpPut(uri);

        // Adding headers to the request
        if (headers != null && !headers.isEmpty()) {
            headers.forEach(httpPut::addHeader);
        }

        // Adding payload to the request
        if (payload != null && !payload.isEmpty()) {
            httpPut.setEntity(new StringEntity(
                    payload, StandardCharsets.UTF_8));
        }

        try {
            HttpResponse httpResponse = httpClient.execute(httpPut);

            if (httpResponse == null) {
                throw new OutsetaAPIUnknownException(
                        "Response is null.", url, payload, parameters,
                        headers, null, null);
            }

            int statusCode = httpResponse.getStatusLine().getStatusCode();
            String responseBody = EntityUtils
                    .toString(httpResponse.getEntity());

            if (statusCode < MIN_SUCCESS_CODE
                    || statusCode > MAX_SUCCESS_CODE) {
                // Didn't receive success from outseta
                throw new OutsetaInvalidResponseCodeException(
                        responseBody, url, payload, parameters, headers,
                        statusCode, null);
            }

            return responseBody;
        } catch (IOException e) {
            throw new OutsetaAPIBadRequestException(
                    e.getMessage(), url, payload, parameters, headers, null, e);
        }
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

        URI uri = generateRequest(url, parameters);

        HttpPost httpPost = new HttpPost(uri);

        // Adding headers to the request
        if (headers != null && !headers.isEmpty()) {
            headers.forEach(httpPost::addHeader);
        }

        // Adding payload to the request
        if (payload != null && !payload.isEmpty()) {
            httpPost.setEntity(new StringEntity(payload,
                    StandardCharsets.UTF_8));
        }

        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);

            if (httpResponse == null) {
                throw new OutsetaAPIUnknownException(
                        "Response is null.", url, payload, parameters,
                        headers, null, null);
            }

            int statusCode = httpResponse.getStatusLine().getStatusCode();
            String responseBody = EntityUtils
                    .toString(httpResponse.getEntity());

            if (statusCode < MIN_SUCCESS_CODE
                    || statusCode > MAX_SUCCESS_CODE) {
                // Didn't receive success from outseta
                throw new OutsetaInvalidResponseCodeException(
                        responseBody, url, payload, parameters,
                        headers, statusCode, null);
            }

            return responseBody;
        } catch (IOException e) {
            throw new OutsetaAPIBadRequestException(
                    e.getMessage(), url, payload, parameters, headers, null, e);
        }
    }

    @Override
    public String delete(final String url, final Map<String, Object> parameters,
                         final Map<String, String> headers) throws
            OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaAPIUnknownException,
            OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException {

        URI uri = generateRequest(url, parameters);

        HttpDelete httpDelete = new HttpDelete(uri);

        // Adding headers to the request
        if (headers != null && !headers.isEmpty()) {
            headers.forEach(httpDelete::addHeader);
        }

        try {
            HttpResponse httpResponse = httpClient.execute(httpDelete);

            if (httpResponse == null) {
                throw new OutsetaAPIUnknownException(
                        "Response is null.", url, "", parameters,
                        headers, null, null);
            }

            int statusCode = httpResponse.getStatusLine().getStatusCode();
            String responseBody = EntityUtils
                    .toString(httpResponse.getEntity());

            if (statusCode < MIN_SUCCESS_CODE
                    || statusCode > MAX_SUCCESS_CODE) {
                // Didn't receive success from outseta
                throw new OutsetaInvalidResponseCodeException(
                        responseBody, url, null, parameters,
                        headers, statusCode, null);
            }

            return responseBody;
        } catch (IOException e) {
            throw new OutsetaAPIBadRequestException(
                    e.getMessage(), url, null, parameters, headers, null, e);
        }
    }

    @Override
    public String urlEncodePayloadAttribute(final String value)
            throws OutsetaInvalidURLException {
        if (value == null) {
            return null;
        }
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            // This should never happen.
            throw new OutsetaInvalidURLException(
                    "Unsupported encoding: " + e.getMessage());
        }
    }

}
