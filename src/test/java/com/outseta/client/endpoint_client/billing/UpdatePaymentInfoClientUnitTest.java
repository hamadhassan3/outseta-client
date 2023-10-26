package com.outseta.client.endpoint_client.billing;

import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.UpdatePaymentInfoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the UpdatePaymentInfoClient class.
 * It has unit tests because it does not make calls to the Outseta API.
 */
@ExtendWith(MockitoExtension.class)
public class UpdatePaymentInfoClientUnitTest {

    /**
     * The client that is used to make calls to the update payment info
     * endpoints.
     */
    private UpdatePaymentInfoClient updatePaymentInfoClient;

    /**
     * The Outseta URL used for testing.
     */
    private static final String OUTSETA_URL = "https://dummy.com";

    /**
     * The Outseta Key used for testing.
     */
    private static final String OUTSETA_KEY = "dummyKey";

    /**
     * The ParserFacade object used for testing.
     */
    @Mock
    private ParserFacade parserFacade;

    /**
     * The JsonParser object used for testing.
     */
    @Mock
    private JsonParser jsonParser;

    /**
     * The RequestMaker object used for testing.
     */
    @Mock
    private RequestMaker requestMaker;

    /**
     * The update payment request used for testing.
     */
    @Mock
    private UpdatePaymentInfoRequest updatePaymentInfoRequest;

    /**
     * The update payment request string used for testing.
     */
    private String updatePaymentInfoRequestStr;

    /**
     * This method is used to set up the tests.
     */
    @BeforeEach
    public void setup() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        when(parserFacade.getJsonParser()).thenReturn(jsonParser);
        updatePaymentInfoClient = UpdatePaymentInfoClient.builder(OUTSETA_URL)
                .apiKey(OUTSETA_KEY)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .build();
    }

    /**
     * This method tests the updatePaymentInfo method.
     */
    @Test
    public void testUpdatePaymentInfo() {

        assertDoesNotThrow(() -> {

            when(requestMaker.post(
                    OUTSETA_URL + "/billing/paymentinformation",
                    new HashMap<>(),
                    updatePaymentInfoRequestStr,
                    updatePaymentInfoClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(updatePaymentInfoRequest))
                    .thenReturn(updatePaymentInfoRequestStr);

            updatePaymentInfoClient.updatePaymentInfo(updatePaymentInfoRequest);
        });
    }

    /**
     * This method tests the updatePaymentInfo method with a null request.
     */
    @Test
    public void testUpdatePaymentInfoNullRequest() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            updatePaymentInfoClient.updatePaymentInfo(null);
        });
    }
}
