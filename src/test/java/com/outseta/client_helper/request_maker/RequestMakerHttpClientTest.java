package com.outseta.client_helper.request_maker;

import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * This class tests the RequestMakerHttpClient class.
 */
@ExtendWith(MockitoExtension.class)
class RequestMakerHttpClientTest {

    @Mock
    private HttpClient httpClient;

    private RequestMakerHttpClient requestMakerHttpClient;

    /**
     * Sets up the class data before any tests are run
     */
    @BeforeEach
    public void setUp() {
        this.requestMakerHttpClient = new RequestMakerHttpClient(httpClient);
    }

    /**
     * A test for the constructor of the class RequestMakerHttpClient
     */
    @Test
    public void testDefaultConstructor()
            throws OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException {

        RequestMakerHttpClient client = new RequestMakerHttpClient();

        // We only need to test successful creation of client
    }

    /**
     * A test for invalid url in get request
     */
    @Test
    public void testGetInvalidUrl() {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        // Assert that OutsetaInvalidURLException is thrown when url is invalid

        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.get("invalid url", null, null);
        });

        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.get("invalid url", params, headers);
        });

        params.put("key", "value");
        headers.put("key", "value");

        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.get("invalid url", params, headers);
        });

    }

    /**
     * A test for invalid url in post request
     */
    @Test
    public void testPostInvalidUrl() {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaInvalidURLException is thrown when url is invalid

        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.post("invalid url", null, null, null);
        });

        String finalPayload1 = payload;
        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.post("invalid url", params, finalPayload1,
                    headers);
        });

        params.put("key", "value");
        headers.put("key", "value");

        payload = "payload";

        String finalPayload2 = payload;
        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.post("invalid url", params, finalPayload2,
                    headers);
        });

    }

    /**
     * A test for invalid url in put request
     */
    @Test
    public void testPutInvalidUrl() {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaInvalidURLException is thrown when url is invalid

        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.put("invalid url", null, null, null);
        });

        String finalPayload1 = payload;
        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.put("invalid url", params, finalPayload1,
                    headers);
        });

        params.put("key", "value");
        headers.put("key", "value");

        payload = "payload";

        String finalPayload2 = payload;
        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.put("invalid url", params, finalPayload2,
                    headers);
        });

    }

    /**
     * A test for invalid url in delete request
     */
    @Test
    public void testDeleteInvalidUrl() {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        // Assert that OutsetaInvalidURLException is thrown when url is invalid

        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.delete("invalid url", null, null);
        });

        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.delete("invalid url", params, headers);
        });

        params.put("key", "value");
        headers.put("key", "value");

        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.delete("invalid url", params, headers);
        });

    }

    /**
     * A test that checks if OutsetaBadRequestException is thrown when get request fails with IOException
     */
    @Test
    public void testGetIOException() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        // Assert that OutsetaBadRequestException is thrown when request fails with IOException

        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenThrow(
                new IOException());

        assertThrows(OutsetaAPIBadRequestException.class, () -> {
            requestMakerHttpClient.get("http://validurl", params, headers);
        });

    }

    /**
     * A test that checks if OutsetaBadRequestException is thrown when post request fails with IOException
     */
    @Test
    public void testPostIOException() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaBadRequestException is thrown when request fails with IOException

        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenThrow(
                new IOException());

        assertThrows(OutsetaAPIBadRequestException.class, () -> {
            requestMakerHttpClient.post("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * A test that checks if OutsetaBadRequestException is thrown when put request fails with IOException
     */
    @Test
    public void testPutIOException() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaBadRequestException is thrown when request fails with IOException

        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenThrow(
                new IOException());

        assertThrows(OutsetaAPIBadRequestException.class, () -> {
            requestMakerHttpClient.put("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * A test that checks if OutsetaBadRequestException is thrown when delete request fails with IOException
     */
    @Test
    public void testDeleteIOException()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        // Assert that OutsetaBadRequestException is thrown when request fails with IOException

        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenThrow(
                new IOException());

        assertThrows(OutsetaAPIBadRequestException.class, () -> {
            requestMakerHttpClient.delete("http://validurl", params, headers);
        });

    }

    /**
     * A test that checks if OutsetaAPIFailedException is thrown when get request fails with InterruptedException
     */
    @Test
    public void testGetInterruptedException()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        // Assert that OutsetaAPIFailedException is thrown when request fails with InterruptedException

        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenThrow(
                new InterruptedException());

        assertThrows(OutsetaAPIFailedException.class, () -> {
            requestMakerHttpClient.get("http://validurl", params, headers);
        });

    }

    /**
     * A test that checks if OutsetaAPIFailedException is thrown when post request fails with InterruptedException
     */
    @Test
    public void testPostInterruptedException()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaAPIFailedException is thrown when request fails with InterruptedException

        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenThrow(
                new InterruptedException());

        assertThrows(OutsetaAPIFailedException.class, () -> {
            requestMakerHttpClient.post("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * A test that checks if OutsetaAPIFailedException is thrown when put request fails with InterruptedException
     */
    @Test
    public void testPutInterruptedException()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaAPIFailedException is thrown when request fails with InterruptedException

        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenThrow(
                new InterruptedException());

        assertThrows(OutsetaAPIFailedException.class, () -> {
            requestMakerHttpClient.put("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * A test that checks if OutsetaAPIFailedException is thrown when delete request fails with InterruptedException
     */
    @Test
    public void testDeleteInterruptedException()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        // Assert that OutsetaAPIFailedException is thrown when request fails with InterruptedException

        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenThrow(
                new InterruptedException());

        assertThrows(OutsetaAPIFailedException.class, () -> {
            requestMakerHttpClient.delete("http://validurl", params, headers);
        });

    }

    /**
     * A test that checks if OutsetaAPIUnknownException is thrown when get request fails with null response
     */
    @Test
    public void testGetNullResponse() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        // Assert that OutsetaAPIUnknownException is thrown when request fails with null response

        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(null);

        assertThrows(OutsetaAPIUnknownException.class, () -> {
            requestMakerHttpClient.get("http://validurl", params, headers);
        });

    }

    /**
     * A test that checks if OutsetaAPIUnknownException is thrown when post request fails with null response
     */
    @Test
    public void testPostNullResponse()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaAPIUnknownException is thrown when request fails with null response

        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(null);

        assertThrows(OutsetaAPIUnknownException.class, () -> {
            requestMakerHttpClient.post("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * A test that checks if OutsetaAPIUnknownException is thrown when put request fails with null response
     */
    @Test
    public void testPutNullResponse() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaAPIUnknownException is thrown when request fails with null response

        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(null);

        assertThrows(OutsetaAPIUnknownException.class, () -> {
            requestMakerHttpClient.put("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * A test that checks if OutsetaAPIUnknownException is thrown when delete request fails with null response
     */
    @Test
    public void testDeleteNullResponse()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        // Assert that OutsetaAPIUnknownException is thrown when request fails with null response

        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(null);

        assertThrows(OutsetaAPIUnknownException.class, () -> {
            requestMakerHttpClient.delete("http://validurl", params, headers);
        });

    }

    /**
     * A test that checks if OutsetaInvalidResponseCodeException is thrown when get request fails with invalid response code
     */
    @Test
    public void testGetInvalidResponseCode()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        HttpResponse mockResponse = Mockito.mock(HttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.statusCode()).thenReturn(200);
        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.get("http://validurl", params, headers);
        });

        // Assert that exception is thrown when status code is invalid
        when(mockResponse.statusCode()).thenReturn(400);
        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> {
            requestMakerHttpClient.get("http://validurl", params, headers);
        });

    }

    /**
     * A test that checks if OutsetaInvalidResponseCodeException is thrown when post request fails with invalid response code
     */
    @Test
    public void testPostInvalidResponseCode()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        HttpResponse mockResponse = Mockito.mock(HttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.statusCode()).thenReturn(200);
        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.post("http://validurl", params, payload,
                    headers);
        });

        // Assert that exception is thrown when status code is invalid
        when(mockResponse.statusCode()).thenReturn(400);
        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> {
            requestMakerHttpClient.post("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * A test that checks if OutsetaInvalidResponseCodeException is thrown when put request fails with invalid response code
     */
    @Test
    public void testPutInvalidResponseCode()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        HttpResponse mockResponse = Mockito.mock(HttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.statusCode()).thenReturn(200);
        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.put("http://validurl", params, payload,
                    headers);
        });

        // Assert that exception is thrown when status code is invalid
        when(mockResponse.statusCode()).thenReturn(400);
        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> {
            requestMakerHttpClient.put("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * A test that checks if OutsetaInvalidResponseCodeException is thrown when delete request fails with invalid response code
     */
    @Test
    public void testDeleteInvalidResponseCode()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        HttpResponse mockResponse = Mockito.mock(HttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.statusCode()).thenReturn(200);
        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.delete("http://validurl", params, headers);
        });

        // Assert that exception is thrown when status code is invalid
        when(mockResponse.statusCode()).thenReturn(400);
        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> {
            requestMakerHttpClient.delete("http://validurl", params, headers);
        });

    }

    /**
     * A test that checks a valid get request and its response
     */
    @Test
    public void testGetValid() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        String response = "response";

        HttpResponse mockResponse = Mockito.mock(HttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockResponse.body()).thenReturn(response);
        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            String res = requestMakerHttpClient.get("http://validurl", params,
                    headers);
            assertEquals(res, response);
        });

    }

    /**
     * A test that checks a valid post request and its response
     */
    @Test
    public void testPostValid() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "payload";

        String response = "response";

        HttpResponse mockResponse = Mockito.mock(HttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockResponse.body()).thenReturn(response);
        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            String res = requestMakerHttpClient.post("http://validurl", params,
                    payload, headers);
            assertEquals(res, response);
        });


    }

    /**
     * A test that checks a valid put request and its response
     */
    @Test
    public void testPutValid() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "payload";

        String response = "response";

        HttpResponse mockResponse = Mockito.mock(HttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockResponse.body()).thenReturn(response);
        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            String res = requestMakerHttpClient.put("http://validurl", params,
                    payload, headers);
            assertEquals(res, response);
        });

    }

    /**
     * A test that checks a valid delete request and its response
     */
    @Test
    public void testDeleteValid() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        String response = "response";

        HttpResponse mockResponse = Mockito.mock(HttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockResponse.body()).thenReturn(response);
        when(httpClient.send(any(HttpRequest.class),
                any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            String res =
                    requestMakerHttpClient.delete("http://validurl", params,
                            headers);
            assertEquals(res, response);
        });


    }
}
