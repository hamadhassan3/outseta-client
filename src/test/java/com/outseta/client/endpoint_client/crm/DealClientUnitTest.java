package com.outseta.client.endpoint_client.crm;

import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.Deal;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Metadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the DealClient class.
 */
@ExtendWith(MockitoExtension.class)
public class DealClientUnitTest {

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
     * The DealClient object used for testing.
     */
    private DealClient dealClient;

    /**
     * The Deal object used for testing.
     */
    @Mock
    private Deal deal;

    /**
     * The Deal object string used for testing.
     */
    private String dealStr;

    /**
     * This method initializes the DealClient object and the
     * Deal object used for testing.
     */
    @BeforeEach
    public void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {

        when(parserFacade.getJsonParser()).thenReturn(jsonParser);
        dealClient = DealClient.builder(OUTSETA_URL)
                .apiKey(OUTSETA_KEY)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .build();
        dealStr = "{\"Name\":\"name\",\"DealPipelineStageUid\":\"uid\","
                + "\"Amount\":0.0,\"AssignedToPersonClientIdentifier\":\""
                + "personUid\"}";
    }

    /**
     * This method tests the getDealPage method.
     */
    @Test
    public void testGetDealPage() {
        assertDoesNotThrow(() -> {

            Map<String, Object> params = new HashMap<>();

            params.put("offset", "0");
            params.put("limit", "1");

            ItemPage<Deal> itemPage = new ItemPage<>(
                    new Metadata(1, 0, 1),
                    List.of(deal)
            );

            when(requestMaker.get(OUTSETA_URL + "/crm/deals",
                    params, dealClient.getHeaders()))
                    .thenReturn("result");

            // Mocking parser facade's jsonStringToPage method to return
            // an ItemPage of Deal.
            when(parserFacade
                    .jsonStringToPage("result", Deal.class))
                    .thenReturn(itemPage);

            // Making the request.
            ItemPage<Deal> result1 = dealClient
                    .getDealPage(PageRequest
                            .builder()
                            .page(0)
                            .pageSize(1)
                            .build()
                    );

            params.remove("offset");

            when(requestMaker.get(OUTSETA_URL + "/crm/deals",
                    params, dealClient.getHeaders()))
                    .thenReturn("result");

            ItemPage<Deal> result2 = dealClient
                    .getDealPage(PageRequest
                            .builder()
                            .pageSize(1)
                            .build()
                    );

            params.put("offset", "0");
            params.remove("limit");

            when(requestMaker.get(OUTSETA_URL + "/crm/deals",
                    params, dealClient.getHeaders()))
                    .thenReturn("result");

            ItemPage<Deal> result3 = dealClient
                    .getDealPage(PageRequest
                            .builder()
                            .page(0)
                            .build()
                    );

            params.remove("offset");

            when(requestMaker.get(OUTSETA_URL + "/crm/deals",
                    params, dealClient.getHeaders()))
                    .thenReturn("result");

            ItemPage<Deal> result4 = dealClient
                    .getDealPage(PageRequest
                            .builder()
                            .build()
                    );

            // Comparing against expected results
            assertNotNull(result1);
            assertEquals(result1, itemPage);

            assertNotNull(result2);
            assertEquals(result2, itemPage);

            assertNotNull(result3);
            assertEquals(result2, itemPage);

            assertNotNull(result4);
            assertEquals(result2, itemPage);

        });
    }

    /**
     * This method tests the getDealPage method with null page request.
     */
    @Test
    public void testGetDealPageNullPageRequest() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            // Making the request.
            ItemPage<Deal> result = dealClient
                    .getDealPage(null);

        });
    }

    /**
     * This method tests the getDeal method.
     */
    @Test
    public void testGetDeal() {
        assertDoesNotThrow(() -> {

            when(requestMaker.get(OUTSETA_URL + "/crm/deals/uid",
                    new HashMap<>(), dealClient.getHeaders()))
                    .thenReturn(dealStr);

            // Mocking parser facade's jsonStringToObject method to return
            // a Deal.
            when(parserFacade
                    .jsonStringToObject(dealStr, Deal.class))
                    .thenReturn(deal);

            // Making the request.
            Deal result = dealClient.getDeal("uid");

            // Comparing against expected results
            assertNotNull(result);
            assertEquals(result, deal);

        });
    }

    /**
     * This method tests the getDeal method with null uid.
     */
    @Test
    public void testGetDealNullUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            // Making the request.
            dealClient.getDeal(null);

        });
    }

    /**
     * This method tests the getDeal method with empty uid.
     */
    @Test
    public void testGetDealEmptyUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            // Making the request.
            dealClient.getDeal("");

        });
    }

    /**
     * This method tests the createDeal method.
     */
    @Test
    public void testCreateDeal() {

        assertDoesNotThrow(() -> {

            when(requestMaker.post(
                    OUTSETA_URL + "/crm/deals",
                    new HashMap<>(),
                    dealStr,
                    dealClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(deal))
                    .thenReturn(dealStr);

            when(parserFacade.jsonStringToObject("result", Deal.class))
                    .thenReturn(deal);

            Deal result = dealClient.createDeal(deal);

            assertNotNull(result);
            assertEquals(result, deal);
        });
    }

    /**
     * This method tests the createDeal method with null deal.
     */
    @Test
    public void testCreateDealNullDeal() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            // Making the request.
            dealClient.createDeal(null);

        });
    }

    /**
     * This method tests the deleteDeal method.
     */
    @Test
    public void testDeleteDeal() {
        assertDoesNotThrow(() -> {

            when(requestMaker.delete(OUTSETA_URL + "/crm/deals/uid",
                    new HashMap<>(), dealClient.getHeaders()))
                    .thenReturn("result");

            // Making the request.
            dealClient.deleteDeal("uid");

        });
    }

    /**
     * This method tests the deleteDeal method with null uid.
     */
    @Test
    public void testDeleteDealNullUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            // Making the request.
            dealClient.deleteDeal(null);

        });
    }

    /**
     * This method tests the deleteDeal method with empty uid.
     */
    @Test
    public void testDeleteDealEmptyUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            // Making the request.
            dealClient.deleteDeal("");

        });
    }

    /**
     * This method tests the updateDeal method.
     */
    @Test
    public void testUpdateDeal() {
        assertDoesNotThrow(() -> {

            when(requestMaker.put(OUTSETA_URL + "/crm/deals/uid",
                    new HashMap<>(), dealStr, dealClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(deal))
                    .thenReturn(dealStr);

            when(parserFacade.jsonStringToObject("result", Deal.class))
                    .thenReturn(deal);

            Deal result = dealClient.updateDeal("uid", deal);

            assertNotNull(result);
            assertEquals(result, deal);
        });
    }

    /**
     * This method tests the updateDeal method with null uid.
     */
    @Test
    public void testUpdateDealNullUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            // Making the request.
            dealClient.updateDeal(null, deal);

        });
    }

    /**
     * This method tests the updateDeal method with empty uid.
     */
    @Test
    public void testUpdateDealEmptyUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            // Making the request.
            dealClient.updateDeal("", deal);

        });
    }

    /**
     * This method tests the updateDeal method with null deal.
     */
    @Test
    public void testUpdateDealNullDeal() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            // Making the request.
            dealClient.updateDeal("uid", null);

        });
    }
}
