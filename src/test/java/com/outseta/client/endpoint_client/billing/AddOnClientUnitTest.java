package com.outseta.client.endpoint_client.billing;

import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.AddOnUsageRequest;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.AddOn;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.SubscriptionAddOn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the AddOnClient class.
 */
@ExtendWith(MockitoExtension.class)
public class AddOnClientUnitTest {

    /**
     * The client that is used to make calls to the addOn endpoints.
     */
    private AddOnClient addOnClient;

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
     * The addon used for testing.
     */
    @Mock
    private AddOn addOn;

    /**
     * The subscription addon used for testing.
     */
    @Mock
    private SubscriptionAddOn subscriptionAddOn;

    /**
     * The addon page used for testing.
     */
    @Mock
    private ItemPage<AddOn> addOnPage;

    /**
     * The addOn string used for testing.
     */
    private String addOnStr;

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
        addOnClient = AddOnClient.builder(OUTSETA_URL)
                .apiKey(OUTSETA_KEY)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .build();
        addOnStr = "addOnJsonDummy";
    }

    /**
     * This method tests the getAddOn method.
     */
    @Test
    public void testGetAddOn() {

        assertDoesNotThrow(() -> {
            when(requestMaker.get(OUTSETA_URL + "/billing/addons/id",
                    new HashMap<>(), addOnClient.getHeaders()))
                    .thenReturn(addOnStr);
            when(parserFacade.jsonStringToObject(addOnStr, AddOn.class))
                    .thenReturn(addOn);
            AddOn result = addOnClient.getAddOn("id");

            assertEquals(addOn, result);
        });
    }

    /**
     * This method tests the getAddOn method when the addOn id is null.
     */
    @Test
    public void testGetAddOnNullId() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            addOnClient.getAddOn(null);
        });
    }

    /**
     * This method tests the getAddOn method when the addOn id is blank.
     */
    @Test
    public void testGetAddOnBlankId() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            addOnClient.getAddOn("");
        });
    }

    /**
     * This method tests the getAddOnPage method.
     */
    @Test
    public void testGetAddOnPage() {

        assertDoesNotThrow(() -> {
            PageRequest pageRequest = PageRequest.builder()
                    .pageSize(PAGE_SIZE)
                    .page(1)
                    .build();

            when(requestMaker.get(OUTSETA_URL + "/billing/addons",
                    pageRequest.buildParams(), addOnClient.getHeaders()))
                    .thenReturn(addOnStr);
            when(parserFacade.jsonStringToPage(addOnStr,
                    AddOn.class))
                    .thenReturn(addOnPage);
            ItemPage<AddOn> result = addOnClient.getAddOnPage(pageRequest);

            assertEquals(addOnPage, result);
        });
    }

    /**
     * This method tests the getAddOnPage method when the page request is null.
     */
    @Test
    public void testGetAddOnPageNullPageRequest() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            addOnClient.getAddOnPage(null);
        });
    }

    /**
     * This method tests the addUsageForAddOn method.
     */
    @Test
    public void testAddUsageForAddOn() {

        assertDoesNotThrow(() -> {

            AddOnUsageRequest addOnUsageRequest = AddOnUsageRequest.builder()
                    .usageDate(new Date())
                    .subscriptionAddOn(subscriptionAddOn)
                    .amount(1)
                    .build();

            when(requestMaker.post(
                    OUTSETA_URL + "/billing/usage",
                    new HashMap<>(),
                    addOnStr,
                    addOnClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(addOnUsageRequest))
                    .thenReturn(addOnStr);

            addOnClient.addUsageForAddOn(addOnUsageRequest);
        });
    }

    /**
     * This method tests the addUsageForAddOn method when the addOnUsageRequest
     * is null.
     */
    @Test
    public void testAddUsageForAddOnNullAddOnUsageRequest() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            addOnClient.addUsageForAddOn(null);
        });
    }

}
