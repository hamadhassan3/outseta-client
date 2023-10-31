package com.outseta.client_helper.request_maker;

import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicStatusLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * This class tests the RequestMakerHttpClient class.
 */
@ExtendWith(MockitoExtension.class)
class RequestMakerHttpClientTest {

    /**
     * Creating HttpClient mock object.
     */
    @Mock
    private CloseableHttpClient httpClient;

    /**
     * Creating RequestMakerHttpClient object with the mocked HttpClient.
     */
    private RequestMakerHttpClient requestMakerHttpClient;

    /**
     * Valid response codes for the tests.
     */
    private static final int SUCCESS_CODE = 200;

    /**
     * Invalid response codes for the tests.
     */
    private static final int FAILURE_CODE_1 = 400;

    /**
     * Invalid response codes for the tests.
     */
    private static final int FAILURE_CODE_2 = 199;

    /**
     * Sets up the class data before any tests are run.
     */
    @BeforeEach
    public void setUp() {
        this.requestMakerHttpClient = new RequestMakerHttpClient(httpClient);
    }

    /**
     * A test for the constructor of the class RequestMakerHttpClient.
     */
    @Test
    public void testDefaultConstructor() {

        // We only need to test successful creation of client
        assertDoesNotThrow(() -> {
            RequestMakerHttpClient client = new RequestMakerHttpClient();
        });
    }

    /**
     * A test for invalid url in get request.
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
     * A test for invalid url in post request.
     */
    @Test
    public void testPostInvalidUrl() {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaInvalidURLException is thrown when url is invalid

        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.post("invalid url", null,
                    null, null);
        });

        String finalPayload1 = payload;
        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.post("invalid url", params,
                    finalPayload1,
                    headers);
        });

        params.put("key", "value");
        headers.put("key", "value");

        payload = "payload";

        String finalPayload2 = payload;
        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.post("invalid url", params,
                    finalPayload2,
                    headers);
        });

    }

    /**
     * A test for invalid url in put request.
     */
    @Test
    public void testPutInvalidUrl() {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaInvalidURLException is thrown when url is invalid

        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.put("invalid url",
                    null, null, null);
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
     * A test for invalid url in delete request.
     */
    @Test
    public void testDeleteInvalidUrl() {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        // Assert that OutsetaInvalidURLException is thrown when url is invalid

        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.delete("invalid url",
                    null, null);
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
     * A test that checks if OutsetaBadRequestException is thrown
     * when get request fails with IOException.
     */
    @Test
    public void testGetIOException() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        // Assert that OutsetaBadRequestException is thrown when request
        // fails with IOException

        when(httpClient.execute(any(HttpGet.class))).thenThrow(
                new IOException());

        assertThrows(OutsetaAPIBadRequestException.class, () -> {
            requestMakerHttpClient.get("http://validurl", params, headers);
        });

    }

    /**
     * A test that checks if OutsetaBadRequestException is thrown.
     */
    @Test
    public void testUrlNullException() {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        assertThrows(OutsetaInvalidURLException.class, () -> {
            requestMakerHttpClient.get(null, params, headers);
        });

    }

    /**
     * A test that checks if OutsetaBadRequestException is
     * thrown when post request fails with IOException.
     */
    @Test
    public void testPostIOException() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaBadRequestException is thrown when request
        // fails with IOException

        when(httpClient.execute(any(HttpPost.class))).thenThrow(
                new IOException());

        assertThrows(OutsetaAPIBadRequestException.class, () -> {
            requestMakerHttpClient.post("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * A test that checks if OutsetaBadRequestException
     * is thrown when put request fails with IOException.
     */
    @Test
    public void testPutIOException() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaBadRequestException is thrown when request
        // fails with IOException

        when(httpClient.execute(any(HttpPut.class))).thenThrow(
                new IOException());

        assertThrows(OutsetaAPIBadRequestException.class, () -> {
            requestMakerHttpClient.put("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * A test that checks if OutsetaBadRequestException is thrown
     * when delete request fails with IOException.
     */
    @Test
    public void testDeleteIOException()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        // Assert that OutsetaBadRequestException is thrown when
        // request fails with IOException

        when(httpClient.execute(any(HttpDelete.class))).thenThrow(
                new IOException());

        assertThrows(OutsetaAPIBadRequestException.class, () -> {
            requestMakerHttpClient.delete("http://validurl",
                    params, headers);
        });

    }

    /**
     * A test that checks if OutsetaAPIUnknownException is thrown
     * when get request fails with null response.
     */
    @Test
    public void testGetNullResponse() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        // Assert that OutsetaAPIUnknownException is thrown when
        // request fails with null response

        when(httpClient.execute(any(HttpGet.class))).thenReturn(null);

        assertThrows(OutsetaAPIUnknownException.class, () -> {
            requestMakerHttpClient.get("http://validurl", params, headers);
        });

    }

    /**
     * A test that checks if OutsetaAPIUnknownException is thrown
     * when post request fails with null response.
     */
    @Test
    public void testPostNullResponse()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaAPIUnknownException is thrown when
        // request fails with null response

        when(httpClient.execute(any(HttpPost.class))).thenReturn(null);

        assertThrows(OutsetaAPIUnknownException.class, () -> {
            requestMakerHttpClient.post("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * A test that checks if OutsetaAPIUnknownException is
     * thrown when put request fails with null response.
     */
    @Test
    public void testPutNullResponse() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        // Assert that OutsetaAPIUnknownException is thrown when
        // request fails with null response

        when(httpClient.execute(any(HttpPut.class))).thenReturn(null);

        assertThrows(OutsetaAPIUnknownException.class, () -> {
            requestMakerHttpClient.put("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * A test that checks if OutsetaAPIUnknownException is thrown
     * when delete request fails with null response.
     */
    @Test
    public void testDeleteNullResponse()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        // Assert that OutsetaAPIUnknownException is thrown when
        // request fails with null response

        when(httpClient.execute(any(HttpDelete.class))).thenReturn(null);

        assertThrows(OutsetaAPIUnknownException.class, () -> {
            requestMakerHttpClient.delete("http://validurl",
                    params, headers);
        });

    }

    /**
     * A test that checks if OutsetaInvalidResponseCodeException is thrown when
     * get request fails with invalid response code.
     */
    @Test
    public void testGetInvalidResponseCode()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                        new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));
        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));
        when(httpClient.execute(any(HttpGet.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.get("http://validurl", params, headers);
        });

        // Assert that exception is thrown when status code is invalid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                FAILURE_CODE_1, "NOT_OK"));
        when(httpClient.execute(any(HttpGet.class))).thenReturn(mockResponse);

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> {
            requestMakerHttpClient.get("http://validurl", params, headers);
        });

        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                FAILURE_CODE_2, "NOT_OK"));

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> {
            requestMakerHttpClient.get("http://validurl", params, headers);
        });
    }

    /**
     * A test that checks if OutsetaInvalidResponseCodeException is thrown when
     * post request fails with invalid response code.
     */
    @Test
    public void testPostInvalidResponseCode()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));
        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpPost.class))).thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.post("http://validurl", params, payload,
                    headers);
        });

        // Assert that exception is thrown when status code is invalid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                FAILURE_CODE_1, "NOT_OK"));
        when(httpClient.execute(any(HttpPost.class))).thenReturn(mockResponse);

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> {
            requestMakerHttpClient.post("http://validurl", params, payload,
                    headers);
        });

        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                FAILURE_CODE_2, "NOT_OK"));
        assertThrows(OutsetaInvalidResponseCodeException.class, () -> {
            requestMakerHttpClient.post("http://validurl", params, payload,
                    headers);
        });


    }

    /**
     * A test that checks if OutsetaInvalidResponseCodeException is thrown
     * when put request fails with invalid response code.
     */
    @Test
    public void testPutInvalidResponseCode()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));
        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpPut.class))).thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.put("http://validurl", params, payload,
                    headers);
        });

        // Assert that exception is thrown when status code is invalid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                FAILURE_CODE_1, "NOT_OK"));
        when(httpClient.execute(any(HttpPut.class))).thenReturn(mockResponse);

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> {
            requestMakerHttpClient.put("http://validurl", params, payload,
                    headers);
        });

        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                FAILURE_CODE_2, "NOT_OK"));

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> {
            requestMakerHttpClient.put("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * A test that checks if OutsetaInvalidResponseCodeException is thrown
     * when delete request fails with invalid response code.
     */
    @Test
    public void testDeleteInvalidResponseCode()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));
        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));
        when(httpClient.execute(any(HttpDelete.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.delete("http://validurl", params,
                    headers);
        });

        // Assert that exception is thrown when status code is invalid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                FAILURE_CODE_1, "NOT_OK"));
        when(httpClient.execute(any(HttpDelete.class)))
                .thenReturn(mockResponse);

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> {
            requestMakerHttpClient.delete("http://validurl", params,
                    headers);
        });

        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                FAILURE_CODE_2, "NOT_OK"));


        assertThrows(OutsetaInvalidResponseCodeException.class, () -> {
            requestMakerHttpClient.delete("http://validurl", params,
                    headers);
        });

    }

    /**
     * This method tests with parameters.
     */
    @Test
    public void testGetWithParams() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        params.put("key", "value");

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));
        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));
        when(httpClient.execute(any(HttpGet.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.get("http://validurl", params, headers);
        });

    }

    /**
     * This method tests with null parameters.
     */
    @Test
    public void testGetWithNullParams()
            throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        params.put("key", "value");

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));
        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));
        when(httpClient.execute(any(HttpGet.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.get("http://validurl", null, headers);
        });

    }

    /**
     * This method tests with headers.
     */
    @Test
    public void testGetWithHeaders() throws IOException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        headers.put("key", "value");

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));
        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));
        when(httpClient.execute(any(HttpGet.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.get("http://validurl", params, headers);
        });

    }

    /**
     * This method tests with null headers.
     */
    @Test
    public void testGetWithNullHeaders() throws IOException {

        HashMap<String, Object> params = new HashMap<>();

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));
        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));
        when(httpClient.execute(any(HttpGet.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.get("http://validurl", params, null);
        });

    }

    /**
     * This method tests put with headers.
     */
    @Test
    public void testPutWithHeaders() throws IOException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        headers.put("key", "value");

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code
        // is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));

        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpPut.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.put("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * This method tests put with null headers.
     */
    @Test
    public void testPutWithNullHeaders() throws IOException {

        HashMap<String, Object> params = new HashMap<>();
        String payload = "";

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code
        // is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));

        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpPut.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.put("http://validurl", params, payload,
                    null);
        });

    }

    /**
     * This method tests post with headers.
     */
    @Test
    public void testPostWithHeaders() throws IOException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "";

        headers.put("key", "value");

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code
        // is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));

        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpPost.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.post("http://validurl", params, payload,
                    headers);
        });

    }

    /**
     * This method tests post with null headers.
     */
    @Test
    public void testPostWithNullHeaders() throws IOException {

        HashMap<String, Object> params = new HashMap<>();
        String payload = "";

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code
        // is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));

        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpPost.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.post("http://validurl", params, payload,
                    null);
        });

    }

    /**
     * This method tests post with null payload.
     */
    @Test
    public void testPostWithNullPayload() throws IOException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        headers.put("key", "value");

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is thrown when payload is null
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));

        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpPost.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.post("http://validurl", params, null,
                    headers);
        });

    }

    /**
     * This method tests put with null payload.
     */
    @Test
    public void testPutWithNullPayload() throws IOException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        headers.put("key", "value");

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is thrown when payload is null
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));

        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpPut.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.put("http://validurl", params, null,
                    headers);
        });

    }

    /**
     * This method tests put with empty payload.
     */
    @Test
    public void testPutWithEmptyPayload() throws IOException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        headers.put("key", "value");

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is thrown when payload is empty
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));

        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpPut.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.put("http://validurl", params, "",
                    headers);
        });

    }

    /**
     * This method tests delete with headers.
     */
    @Test
    public void testDeleteWithHeaders() throws IOException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        headers.put("key", "value");

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code
        // is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));

        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpDelete.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.delete("http://validurl", params,
                    headers);
        });

    }

    /**
     * This method tests delete with null headers.
     */
    @Test
    public void testDeleteWithNullHeaders() throws IOException {

        HashMap<String, Object> params = new HashMap<>();

        CloseableHttpResponse mockResponse = Mockito
                .mock(CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code
        // is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));

        when(mockResponse.getEntity()).thenReturn(
                new StringEntity("content",
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpDelete.class)))
                .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            requestMakerHttpClient.delete("http://validurl", params,
                    null);
        });

    }

    /**
     * A test that checks a valid get request and its response.
     */
    @Test
    public void testGetValid() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        String response = "response";

        CloseableHttpResponse mockResponse = Mockito.mock(
                CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));
        when(mockResponse.getEntity()).thenReturn(
                new StringEntity(response,
                        ContentType.TEXT_PLAIN));
        when(httpClient.execute(any(HttpGet.class)))
          .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            String res = requestMakerHttpClient.get("http://validurl",
                    params,
                    headers);
            assertEquals(res, response);
        });

    }

    /**
     * A test that checks a valid post request and its response.
     */
    @Test
    public void testPostValid() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "payload";

        String response = "response";

        CloseableHttpResponse mockResponse = Mockito.mock(
                CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));
        when(mockResponse.getEntity()).thenReturn(
                new StringEntity(response,
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpPost.class)))
          .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            String res = requestMakerHttpClient
              .post("http://validurl", params,
                    payload, headers);
            assertEquals(res, response);
        });


    }

    /**
     * A test that checks a valid put request and its response.
     */
    @Test
    public void testPutValid() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String payload = "payload";

        String response = "response";

        CloseableHttpResponse mockResponse = Mockito.mock(
                CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));
        when(mockResponse.getEntity()).thenReturn(
                new StringEntity(response,
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpPut.class)))
          .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            String res = requestMakerHttpClient.put("http://validurl", params,
                    payload, headers);
            assertEquals(res, response);
        });

    }

    /**
     * A test that checks a valid delete request and its response.
     */
    @Test
    public void testDeleteValid() throws IOException, InterruptedException {

        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        String response = "response";

        CloseableHttpResponse mockResponse = Mockito.mock(
                CloseableHttpResponse.class);

        // Assert that exception is not thrown when status code is valid
        when(mockResponse.getStatusLine()).thenReturn(new BasicStatusLine(
                new ProtocolVersion("", 1, 1),
                SUCCESS_CODE, "OK"));
        when(mockResponse.getEntity()).thenReturn(
                new StringEntity(response,
                        ContentType.TEXT_PLAIN));

        when(httpClient.execute(any(HttpDelete.class)))
          .thenReturn(mockResponse);

        assertDoesNotThrow(() -> {
            String res =
                    requestMakerHttpClient.delete("http://validurl", params,
                            headers);
            assertEquals(res, response);
        });


    }

    /**
     * This method tests the urlEncodePayloadAttribute method.
     */
    @Test
    public void testUrlEncodePayloadAttribute()
            throws UnsupportedEncodingException {

        String encoded = URLEncoder.encode("test",
                StandardCharsets.UTF_8.toString());

        assertDoesNotThrow(() -> {
            String encodedAttribute = requestMakerHttpClient
                    .urlEncodePayloadAttribute("test");
            assertNotNull(encodedAttribute);
            assertEquals(encodedAttribute, encoded);

            assertNull(requestMakerHttpClient
                    .urlEncodePayloadAttribute(null));
        });

    }

    /**
     * This method tests the urlEncodePayloadAttribute method.
     */
    @Test
    public void testUrlEncodePayloadAttributeNull() {
        String value = "your_value_to_encode";

        // Mock URLEncoder.encode to throw UnsupportedEncodingException
        try (MockedStatic<URLEncoder> mockedEncoder = Mockito
                .mockStatic(URLEncoder.class)) {
            mockedEncoder.when(() -> URLEncoder.encode(any(), any()))
                    .thenThrow(new UnsupportedEncodingException(
                            "Mocked exception"));

            // Assert that OutsetaInvalidURLException is
            // thrown when encoding fails
            assertThrows(OutsetaInvalidURLException.class, () ->
                    requestMakerHttpClient.urlEncodePayloadAttribute(value));
        }
    }
}
