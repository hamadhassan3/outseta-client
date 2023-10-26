package com.outseta.client.endpoint_client.billing;

import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.result.Discount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the DiscountClient class.
 */
@ExtendWith(MockitoExtension.class)
public class DiscountClientUnitTest {

    /**
     * The client that is used to make calls to the Discount endpoints.
     */
    private DiscountClient discountClient;

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
     * The discount used for testing.
     */
    @Mock
    private Discount discount;

    /**
     * The Discount string used for testing.
     */
    private String dicountStr;

    /**
     * The page size used for testing.
     */
    private static final int PAGE_SIZE = 10;

    /**
     * This method is used to set up the tests.
     */
    @BeforeEach
    public void setup() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        when(parserFacade.getJsonParser()).thenReturn(jsonParser);
        discountClient = DiscountClient.builder(OUTSETA_URL)
                .apiKey(OUTSETA_KEY)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .build();
        dicountStr = "discountJsonDummyStr";
    }

    /**
     * This method is used to test the createDiscount method.
     */
    @Test
    public void testCreateDiscount() {

        assertDoesNotThrow(() -> {

            when(requestMaker.post(
                    OUTSETA_URL + "/billing/discountcoupons",
                    new HashMap<>(),
                    dicountStr,
                    discountClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(discount))
                    .thenReturn(dicountStr);

            when(parserFacade.jsonStringToObject("result",
                    Discount.class))
                    .thenReturn(discount);

            Discount result = discountClient.createDiscount(discount);

            assertNotNull(result);
            assertEquals(result, discount);
        });
    }

    /**
     * This method is used to test the getDiscount method with null request.
     */
    @Test
    public void testCreateDiscountNullRequest() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            discountClient.createDiscount(null);
        });
    }
}
