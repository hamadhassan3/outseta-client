package com.outseta.exception;

import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests the OutsetaAPIBadRequestException class.
 */
@ExtendWith(MockitoExtension.class)
public class OutsetaAPIBadRequestExceptionTest {

    /**
     * This method tests the OutsetaAPIBadRequestException's constructor.
     */
    @Test
    public void testConstructor() {

        final String message = "test message";

        final OutsetaAPIBadRequestException exception =
                new OutsetaAPIBadRequestException(message);

        assertEquals(message, exception.getMessage());

    }
}
