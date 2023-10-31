package com.outseta.exception;

import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit tests for OutsetaAPIFailedException.
 */
@ExtendWith(MockitoExtension.class)
public class OutsetaAPIFailedExceptionTest {

    /**
     * Test that the OutsetaAPIFailedException constructor works.
     */
    @Test
    public void testConstructorWithCause() {
        OutsetaAPIFailedException ex =
                new OutsetaAPIFailedException("test", null, null,
                        null, null,
                        null, null);

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
     * Test that the OutsetaAPIFailedException parametrized constructor works.
     */
    @Test
    public void testConstructorWithCauseAndUrl() {

        String message = "test";
        String payload = "payload";
        String url = "url";
        final Integer responseCode = 200;
        Exception triggeredBy = new Exception();
        HashMap<String, Object> parameters = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();

        OutsetaAPIFailedException ex =
                new OutsetaAPIFailedException(message, url, payload,
                        parameters, headers,
                        responseCode, triggeredBy);

        assertEquals(message, ex.getMessage());
        assertEquals(payload, ex.getPayload());
        assertEquals(url, ex.getUrl());
        assertEquals(responseCode, ex.getResponseCode());
    }

}
