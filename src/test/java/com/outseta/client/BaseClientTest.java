package com.outseta.client;

import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * This class tests the BaseClient class.
 */
@ExtendWith(MockitoExtension.class)
class BaseClientTest {

    @Mock
    private ParserFacade parserFacade;

    @Mock
    private RequestMaker requestMaker;

    private HashMap<String, String> validHeaders;
    private HashMap<String, String> invalidHeaders;

    private BaseClient baseClient;

    private String dummyBaseUrl;

    @BeforeEach
    void setUp() throws OutsetaClientBuildException {
        this.validHeaders = new HashMap<>();
        this.validHeaders.put("Content-Type", "application/json");
        this.validHeaders.put("Accept", "application/json");
        this.validHeaders.put("Authorization", "key and secret");

        this.invalidHeaders = new HashMap<>();

        dummyBaseUrl = "http://dummyurl.com";
        baseClient = new BaseClient(dummyBaseUrl, validHeaders, requestMaker);
        baseClient.setParserFacade(parserFacade);
    }

    /**
     * This method tests the constructor of the BaseClient class.
     */
    @Test
    void testConstructor() {

        HashMap<String, String> defaultHeaders = new HashMap<>();
        defaultHeaders.put("Content-Type", "application/json");
        defaultHeaders.put("Accept", "application/json");

        assertDoesNotThrow(() -> {
            BaseClient testClient = new BaseClient(dummyBaseUrl);
            assertEquals(dummyBaseUrl, testClient.getBaseUrl());
            assertEquals(defaultHeaders, testClient.getHeaders());
            assertNull(testClient.getParserFacade());
            assertNull(testClient.getRequestMaker());

        });

    }

    /**
     * Test all arguments constructor.
     */
    @Test
    void testAllArgsConstructor() {

        assertDoesNotThrow(() -> {
            BaseClient testClient = new BaseClient(dummyBaseUrl, this.validHeaders, requestMaker);
            assertEquals(dummyBaseUrl, testClient.getBaseUrl());
            assertEquals(this.validHeaders, testClient.getHeaders());
            assertEquals(requestMaker, testClient.getRequestMaker());
            assertNull(testClient.getParserFacade());
        });

    }

    /**
     * This method tests the failure scenario for constructor of the BaseClient class.
     */
    @Test
    void testConstructorFailure() {

        assertThrows(OutsetaClientBuildException.class, () -> new BaseClient(null));

    }

    /**
     * This method tests the failure scenarios of the all arguments constructor
     */
    @Test
    void testAllArgsConstructorFailure() {

        assertThrows(OutsetaClientBuildException.class, () -> new BaseClient(null, this.validHeaders, requestMaker));
        assertThrows(OutsetaClientBuildException.class, () -> new BaseClient(dummyBaseUrl, null, requestMaker));
        assertThrows(OutsetaClientBuildException.class, () -> new BaseClient(dummyBaseUrl, this.validHeaders, null));

        // Testing with invalid headers
        assertThrows(OutsetaClientBuildException.class, () -> new BaseClient(dummyBaseUrl, this.invalidHeaders, requestMaker));
    }

    /**
     * This method tests the setBaseUrl method of the BaseClient class.
     */
    @Test
    void testSetBaseUrl() {
        assertDoesNotThrow(() -> baseClient.setBaseUrl("http://dummyurl.com"));
    }

    /**
     * This method tests the failure scenario for the setBaseUrl method of the BaseClient class.
     */
    @Test
    void testSetBaseUrlFailure() {
        assertThrows(OutsetaClientBuildException.class, () -> baseClient.setBaseUrl(null));
    }

    /**
     * This method tests the setBaseUrl and getBaseUrl method of the BaseClient class.
     */
    @Test
    void testGetBaseUrl() {
        assertEquals(dummyBaseUrl, baseClient.getBaseUrl());

        String newUrl = "http://newurl.com";

        assertDoesNotThrow(() -> {
            baseClient.setBaseUrl(newUrl);
            assertEquals(newUrl, baseClient.getBaseUrl());
        });

    }

    /**
     * This method tests the replaceHeaders method of the BaseClient class.
     */
    @Test
    void testReplaceHeaders() {
        assertDoesNotThrow(() -> {
            BaseClient test = new BaseClient("http://dummyurl.com");
            HashMap<String, String> testHeaders = new HashMap<>();
            testHeaders.putAll(validHeaders);
            testHeaders.put("Junk", "Junk");

            HashMap<String, String> expectedHeaders = new HashMap<>();
            expectedHeaders.putAll(validHeaders);
            expectedHeaders.putAll(testHeaders);

            baseClient.replaceHeaders(validHeaders);
            test.replaceHeaders(testHeaders);
            assertEquals(validHeaders, baseClient.getHeaders());
            assertEquals(testHeaders, test.getHeaders());
        });
    }

    /**
     * This method tests the failure scenario for the replaceHeaders method of the BaseClient class.
     */
    @Test
    void testReplaceHeadersFailure() {
        assertThrows(OutsetaClientBuildException.class, () -> baseClient.replaceHeaders(null));
        assertThrows(OutsetaClientBuildException.class, () -> baseClient.replaceHeaders(invalidHeaders));
    }

    /**
     * This method tests the updateHeaders method of the BaseClient class.
     */
    @Test
    void testUpdateHeaders() {
        assertDoesNotThrow(() -> {
            BaseClient test = new BaseClient("http://dummyurl.com");
            HashMap<String, String> testHeaders = new HashMap<>();
            testHeaders.putAll(validHeaders);
            testHeaders.put("Junk", "Junk");

            HashMap<String, String> expectedHeaders = new HashMap<>();
            expectedHeaders.putAll(validHeaders);
            expectedHeaders.putAll(testHeaders);

            baseClient.updateHeaders(validHeaders);
            test.updateHeaders(testHeaders);
            assertEquals(validHeaders, baseClient.getHeaders());
            assertEquals(expectedHeaders, test.getHeaders());
        });
    }

    /**
     * This method tests the failure scenario for the updateHeaders method of the BaseClient class.
     */
    @Test
    void testUpdateHeadersFailure() {
        assertThrows(OutsetaClientBuildException.class, () -> baseClient.updateHeaders(null));
    }

    /**
     * This method tests the setRequestMaker method of the BaseClient class.
     */
    @Test
    void testSetRequestMaker() {
        assertDoesNotThrow(() -> baseClient.setRequestMaker(requestMaker));
    }

    /**
     * This method tests the failure scenario for the setRequestMaker method of the BaseClient class.
     */
    @Test
    void testSetRequestMakerFailure() {
        assertThrows(OutsetaClientBuildException.class, () -> baseClient.setRequestMaker(null));
    }

    /**
     * This method tests the setParserFacade method of the BaseClient class.
     */
    @Test
    void testSetParserFacade() {
        assertDoesNotThrow(() -> baseClient.setParserFacade(parserFacade));
    }

    /**
     * This method tests the failure scenario for the setParserFacade method of the BaseClient class.
     */
    @Test
    void testSetParserFacadeFailure() {
        assertThrows(OutsetaClientBuildException.class, () -> baseClient.setParserFacade(null));
    }

    /**
     * This method tests the getHeaders method of the BaseClient class.
     */
    @Test
    void testGetHeaders() {
        assertEquals(validHeaders, baseClient.getHeaders());
    }

    /**
     * This method tests the getRequestMaker method of the BaseClient class.
     */
    @Test
    void testGetRequestMaker() {
        assertEquals(requestMaker, baseClient.getRequestMaker());
    }

    /**
     * This method tests the getParserFacade method of the BaseClient class.
     */
    @Test
    void testGetParserFacade() {
        assertEquals(parserFacade, baseClient.getParserFacade());
    }

    /**
     * This method tests the get method of the BaseClient class.
     */
    @Test
    void testGet() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {
        // Mocking request maker response for get
        when(requestMaker.get(dummyBaseUrl + "/crm/people", new HashMap<>(), validHeaders)).thenReturn("Success");

        assertDoesNotThrow(() -> {
            String res = baseClient.get("/crm/people", new HashMap<>());
            assertEquals("Success", res);
        });
    }

    /**
     * This method tests the failure scenario for the get method of the BaseClient class.
     */
    @Test
    void testGetFailure() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {
        // Mocking request maker response for get
        when(requestMaker.get(dummyBaseUrl + "/crm/people", new HashMap<>(), validHeaders)).thenThrow(OutsetaInvalidResponseCodeException.class);

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> baseClient.get("/crm/people", new HashMap<>()));
    }

    /**
     * This method tests the failure scenario of the get method of BaseClient.
     * It tests what happens when request maker throws OutsetaInvalidURLException.
     */
    @Test
    void testGetFailureInvalidUrl() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {
        // Mocking request maker response for get
        when(requestMaker.get(dummyBaseUrl + "/crm/people", new HashMap<>(), validHeaders)).thenThrow(OutsetaInvalidURLException.class);

        assertThrows(OutsetaInvalidURLException.class, () -> baseClient.get("/crm/people", new HashMap<>()));
    }

    /**
     * This method tests the failure scenario of the get method of BaseClient.
     * It tests what happens when request maker throws OutsetaAPIBadRequestException.
     */
    @Test
    void testGetFailureBadRequest() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {
        // Mocking request maker response for get
        when(requestMaker.get(dummyBaseUrl + "/crm/people", new HashMap<>(), validHeaders)).thenThrow(OutsetaAPIBadRequestException.class);

        assertThrows(OutsetaAPIBadRequestException.class, () -> baseClient.get("/crm/people", new HashMap<>()));
    }

    /**
     * This method tests the failure scenario of the get method of BaseClient.
     * It tests what happens when request maker throws OutsetaAPIFailedException.
     */
    @Test
    void testGetFailureFailed() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {
        // Mocking request maker response for get
        when(requestMaker.get(dummyBaseUrl + "/crm/people", new HashMap<>(), validHeaders)).thenThrow(OutsetaAPIFailedException.class);

        assertThrows(OutsetaAPIFailedException.class, () -> baseClient.get("/crm/people", new HashMap<>()));
    }

    /**
     * This method tests the failure scenario of the get method of BaseClient.
     * It tests what happens when request maker throws OutsetaAPIUnknownException.
     */
    @Test
    void testGetFailureUnknown() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {
        // Mocking request maker response for get
        when(requestMaker.get(dummyBaseUrl + "/crm/people", new HashMap<>(), validHeaders)).thenThrow(OutsetaAPIUnknownException.class);

        assertThrows(OutsetaAPIUnknownException.class, () -> baseClient.get("/crm/people", new HashMap<>()));
    }

    /**
     * This method tests the put method of the BaseClient class.
     */
    @Test
    void testPut() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {
        // Mocking request maker response for put
        when(requestMaker.put(dummyBaseUrl + "/crm/people", new HashMap<>(), "payload", validHeaders)).thenReturn("Success");

        assertDoesNotThrow(() -> {
            String res = baseClient.put("/crm/people", new HashMap<>(), "payload");
            assertEquals("Success", res);
        });
    }

    /**
     * This method tests the failure scenario for the put method of the BaseClient class.
     */
    @Test
    void testPutFailure() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {
        // Mocking request maker response for put
        when(requestMaker.put(dummyBaseUrl + "/crm/people", new HashMap<>(), "payload", validHeaders)).thenThrow(OutsetaInvalidResponseCodeException.class);

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> baseClient.put("/crm/people", new HashMap<>(), "payload"));
    }

    /**
     * This method tests the failure scenario of the put method of BaseClient.
     * It tests what happens when request maker throws OutsetaInvalidURLException.
     */
    @Test
    void testPutFailureInvalidUrl() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {
        // Mocking request maker response for put
        when(requestMaker.put(dummyBaseUrl + "/crm/people", new HashMap<>(), "payload", validHeaders)).thenThrow(OutsetaInvalidURLException.class);

        assertThrows(OutsetaInvalidURLException.class, () -> baseClient.put("/crm/people", new HashMap<>(), "payload"));
    }

    /**
     * This method tests the failure scenario of the put method of BaseClient.
     * It tests what happens when request maker throws OutsetaAPIBadRequestException.
     */
    @Test
    void testPutFailureBadRequest() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {
        // Mocking request maker response for put
        when(requestMaker.put(dummyBaseUrl + "/crm/people", new HashMap<>(), "payload", validHeaders)).thenThrow(OutsetaAPIBadRequestException.class);

        assertThrows(OutsetaAPIBadRequestException.class, () -> baseClient.put("/crm/people", new HashMap<>(), "payload"));
    }

    /**
     * This method tests the failure scenario of the put method of BaseClient.
     * It tests what happens when request maker throws OutsetaAPIFailedException.
     */
    @Test
    void testPutFailureFailed() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {
        // Mocking request maker response for put
        when(requestMaker.put(dummyBaseUrl + "/crm/people", new HashMap<>(), "payload", validHeaders)).thenThrow(OutsetaAPIFailedException.class);

        assertThrows(OutsetaAPIFailedException.class, () -> baseClient.put("/crm/people", new HashMap<>(), "payload"));
    }

    /**
     * This method tests the failure scenario of the put method of BaseClient.
     * It tests what happens when request maker throws OutsetaAPIUnknownException.
     */
    @Test
    void testPutFailureUnknown() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {
        // Mocking request maker response for put
        when(requestMaker.put(dummyBaseUrl + "/crm/people", new HashMap<>(), "payload", validHeaders)).thenThrow(OutsetaAPIUnknownException.class);

        assertThrows(OutsetaAPIUnknownException.class, () -> baseClient.put("/crm/people", new HashMap<>(), "payload"));
    }

    /**
     * This method tests the post method of the BaseClient class.
     */
    @Test
    void testPost() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {

        // Mocking request maker response for post
        when(requestMaker.post(dummyBaseUrl + "/crm/people", new HashMap<>(), "payload", validHeaders)).thenReturn("Success");

        assertDoesNotThrow(() -> {
            String res = baseClient.post("/crm/people", new HashMap<>(), "payload");
            assertEquals("Success", res);
        });
    }

    /**
     * This method tests the failure scenario for the post method of the BaseClient class.
     */
    @Test
    void testPostFailure() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {

        // Mocking request maker response for post
        when(requestMaker.post(dummyBaseUrl + "/crm/people", new HashMap<>(), "payload", validHeaders)).thenThrow(OutsetaInvalidResponseCodeException.class);

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> baseClient.post("/crm/people", new HashMap<>(), "payload"));
    }

    /**
     * This method tests the failure scenario of the post method of BaseClient.
     * It tests what happens when request maker throws OutsetaInvalidURLException.
     */
    @Test
    void testPostFailureInvalidUrl() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {

        // Mocking request maker response for post
        when(requestMaker.post(dummyBaseUrl + "/crm/people", new HashMap<>(), "payload", validHeaders)).thenThrow(OutsetaInvalidURLException.class);

        assertThrows(OutsetaInvalidURLException.class, () -> baseClient.post("/crm/people", new HashMap<>(), "payload"));
    }

    /**
     * This method tests the failure scenario of the post method of BaseClient.
     * It tests what happens when request maker throws OutsetaAPIBadRequestException.
     */
    @Test
    void testPostFailureBadRequest() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {

        // Mocking request maker response for post
        when(requestMaker.post(dummyBaseUrl + "/crm/people", new HashMap<>(), "payload", validHeaders)).thenThrow(OutsetaAPIBadRequestException.class);

        assertThrows(OutsetaAPIBadRequestException.class, () -> baseClient.post("/crm/people", new HashMap<>(), "payload"));
    }

    /**
     * This method tests the failure scenario of the post method of BaseClient.
     * It tests what happens when request maker throws OutsetaAPIFailedException.
     */
    @Test
    void testPostFailureFailed() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {

        // Mocking request maker response for post
        when(requestMaker.post(dummyBaseUrl + "/crm/people", new HashMap<>(), "payload", validHeaders)).thenThrow(OutsetaAPIFailedException.class);

        assertThrows(OutsetaAPIFailedException.class, () -> baseClient.post("/crm/people", new HashMap<>(), "payload"));
    }

    /**
     * This method tests the failure scenario of the post method of BaseClient.
     * It tests what happens when request maker throws OutsetaAPIUnknownException.
     */
    @Test
    void testPostFailureUnknown() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {

        // Mocking request maker response for post
        when(requestMaker.post(dummyBaseUrl + "/crm/people", new HashMap<>(), "payload", validHeaders)).thenThrow(OutsetaAPIUnknownException.class);

        assertThrows(OutsetaAPIUnknownException.class, () -> baseClient.post("/crm/people", new HashMap<>(), "payload"));
    }

    /**
     * This method tests the delete method of the BaseClient class.
     */
    @Test
    void testDelete() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {

        // Mocking request maker response for delete
        when(requestMaker.delete(dummyBaseUrl + "/crm/people", new HashMap<>(), validHeaders)).thenReturn("Success");

        assertDoesNotThrow(() -> {
            String res = baseClient.delete("/crm/people", new HashMap<>());
            assertEquals("Success", res);
        });
    }

    /**
     * This method tests the failure scenario for the delete method of the BaseClient class.
     */
    @Test
    void testDeleteFailure() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {

        // Mocking request maker response for delete
        when(requestMaker.delete(dummyBaseUrl + "/crm/people", new HashMap<>(), validHeaders)).thenThrow(OutsetaInvalidResponseCodeException.class);

        assertThrows(OutsetaInvalidResponseCodeException.class, () -> baseClient.delete("/crm/people", new HashMap<>()));
    }

    /**
     * This method tests the failure scenario of the delete method of BaseClient.
     * It tests what happens when request maker throws OutsetaInvalidURLException.
     */
    @Test
    void testDeleteFailureInvalidUrl() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {

        // Mocking request maker response for delete
        when(requestMaker.delete(dummyBaseUrl + "/crm/people", new HashMap<>(), validHeaders)).thenThrow(OutsetaInvalidURLException.class);
        assertThrows(OutsetaInvalidURLException.class, () -> baseClient.delete("/crm/people", new HashMap<>()));
    }

    /**
     * This method tests the failure scenario of the delete method of BaseClient.
     * It tests what happens when request maker throws OutsetaAPIBadRequestException.
     */
    @Test
    void testDeleteFailureBadRequest() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {

        // Mocking request maker response for delete
        when(requestMaker.delete(dummyBaseUrl + "/crm/people", new HashMap<>(), validHeaders)).thenThrow(OutsetaAPIBadRequestException.class);

        assertThrows(OutsetaAPIBadRequestException.class, () -> baseClient.delete("/crm/people", new HashMap<>()));
    }

    /**
     * This method tests the failure scenario of the delete method of BaseClient.
     * It tests what happens when request maker throws OutsetaAPIFailedException.
     */
    @Test
    void testDeleteFailureFailed() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {

        // Mocking request maker response for delete
        when(requestMaker.delete(dummyBaseUrl + "/crm/people", new HashMap<>(), validHeaders)).thenThrow(OutsetaAPIFailedException.class);

        assertThrows(OutsetaAPIFailedException.class, () -> baseClient.delete("/crm/people", new HashMap<>()));
    }

    /**
     * This method tests the failure scenario of the delete method of BaseClient.
     * It tests what happens when request maker throws OutsetaAPIUnknownException.
     */
    @Test
    void testDeleteFailureUnknown() throws OutsetaInvalidResponseCodeException, OutsetaInvalidURLException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException {

        // Mocking request maker response for delete
        when(requestMaker.delete(dummyBaseUrl + "/crm/people", new HashMap<>(), validHeaders)).thenThrow(OutsetaAPIUnknownException.class);

        assertThrows(OutsetaAPIUnknownException.class, () -> baseClient.delete("/crm/people", new HashMap<>()));
    }

    /**
     * This method tests the isHeadersValid method of the BaseClient class.
     */
    @Test
    void testIsHeadersValid() {
        assertTrue(baseClient.isHeadersValid());
    }

    /**
     * This method tests the isHeadersValid method of the BaseClient class.
     */
    @Test
    void testIsHeadersValidFailure() throws OutsetaClientBuildException {
        BaseClient test = new BaseClient("http://dummyurl.com");
        assertFalse(test.isHeadersValid());
    }

}
