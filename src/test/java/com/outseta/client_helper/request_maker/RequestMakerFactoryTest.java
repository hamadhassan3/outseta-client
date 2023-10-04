package com.outseta.client_helper.request_maker;

import com.outseta.exception.OutsetaInvalidRequestMakerException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.outseta.constant.RequestMakerType;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class is used to test the RequestMakerFactory class.
 */
@ExtendWith(MockitoExtension.class)
public class RequestMakerFactoryTest {

    /**
     * This method tests the RequestMakerFactory's factory method.
     */
    @Test
    public void testFactory() {

        assertDoesNotThrow(() -> RequestMakerFactory
                .getRequestMaker(RequestMakerType.DEFAULT));

        assertThrows(OutsetaInvalidRequestMakerException.class, () ->
                RequestMakerFactory.getRequestMaker(null));

        assertThrows(OutsetaInvalidRequestMakerException.class, () ->
                RequestMakerFactory.getRequestMaker(RequestMakerType.INVALID));

    }
}
