package com.outseta.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for OutsetaInvalidArgumentException.
 */
@ExtendWith(MockitoExtension.class)
public class OutsetaInvalidArgumentExceptionTest {

    /**
     * Test that the OutsetaInvalidArgumentException constructor works.
     */
    @Test
    public void testConstructorWithCause() {
        OutsetaInvalidArgumentException ex =
                new OutsetaInvalidArgumentException("test");

        assertEquals("test", ex.getMessage());
    }
}
