package com.outseta.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit tests for OutsetaAPIException.
 */
@ExtendWith(MockitoExtension.class)
public class OutsetaAPIExceptionTest {

    /**
     * Test that the OutsetaAPIException constructor works.
     */
    @Test
    public void testConstructorWithCause() {
        OutsetaAPIException ex =
                new OutsetaAPIException("test");

        assertEquals("test", ex.getMessage());
        assertNull(ex.getCause());
        assertNull(ex.getUrl());
        assertNull(ex.getParameters());
        assertNull(ex.getResponseCode());
        assertNull(ex.getHeaders());
        assertNull(ex.getTriggeredBy());
        assertNull(ex.getPayload());

    }

    /**
     * Test that the OutsetaAPIException parametrized constructor works.
     */
    @Test
    public void testConstructorWithCauseAndUrl() {

        String message = "test";
        String payload = "payload";
        String url = "url";
        final Integer responseCode = 200;
        Map<String, String> headers = new HashMap<>();
        Map<String, Object> parameters = new HashMap<>();
        Exception triggeredBy = new Exception();

        OutsetaAPIException ex =
                new OutsetaAPIException(message, url, payload,
                        parameters, headers, responseCode, triggeredBy);

        assertEquals(message, ex.getMessage());
        assertEquals(payload, ex.getPayload());
        assertEquals(url, ex.getUrl());
        assertEquals(parameters, ex.getParameters());
        assertEquals(responseCode, ex.getResponseCode());
        assertEquals(headers, ex.getHeaders());
        assertEquals(triggeredBy, ex.getTriggeredBy());

    }

    /**
     * This method tests the setter for url.
     */
    @Test
    public void testSetUrl() {

        final String url = "url";

        final OutsetaAPIException exception = new OutsetaAPIException("test");

        exception.setUrl(url);

        assertEquals(url, exception.getUrl());

    }

    /**
     * This method tests the setter for parameters.
     */
    @Test
    public void testSetParameters() {

        final Map<String, Object> parameters = new HashMap<>();

        final OutsetaAPIException exception = new OutsetaAPIException("test");

        exception.setParameters(parameters);

        assertEquals(parameters, exception.getParameters());

    }

    /**
     * This method tests the setter for headers.
     */
    @Test
    public void testSetHeaders() {

        final Map<String, String> headers = new HashMap<>();

        final OutsetaAPIException exception = new OutsetaAPIException("test");

        exception.setHeaders(headers);

        assertEquals(headers, exception.getHeaders());

    }

    /**
     * This method tests the setter for responseCode.
     */
    @Test
    public void testSetResponseCode() {

        final Integer responseCode = 200;

        final OutsetaAPIException exception = new OutsetaAPIException("test");

        exception.setResponseCode(responseCode);

        assertEquals(responseCode, exception.getResponseCode());

    }

    /**
     * This method tests the setter for triggeredBy.
     */
    @Test
    public void testSetTriggeredBy() {

        final Exception triggeredBy = new Exception();

        final OutsetaAPIException exception = new OutsetaAPIException("test");

        exception.setTriggeredBy(triggeredBy);

        assertEquals(triggeredBy, exception.getTriggeredBy());

    }

    /**
     * This method tests the setter for payload.
     */
    @Test
    public void testSetPayload() {

        final String payload = "payload";

        final OutsetaAPIException exception = new OutsetaAPIException("test");

        exception.setPayload(payload);

        assertEquals(payload, exception.getPayload());

    }

}
