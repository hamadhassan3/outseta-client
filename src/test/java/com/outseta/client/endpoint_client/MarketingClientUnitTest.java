package com.outseta.client.endpoint_client;

import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.EmailList;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.MarketingSubscription;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the MarketingClient class.
 */
@ExtendWith(MockitoExtension.class)
public class MarketingClientUnitTest {

    /**
     * The Outseta URL used for testing.
     */
    private static final String OUTSETA_URL = "https://dummy.com";

    /**
     * The access key used for testing.
     */
    private static final String API_KEY = "dummyKey";

    /**
     * The marketing client to test.
     */
    private MarketingClient marketingClient;

    /**
     * The mock parser facade.
     */
    @Mock
    private ParserFacade parserFacade;

    /**
     * The mock json parser.
     */
    @Mock
    private JsonParser jsonParser;

    /**
     * The mock request maker.
     */
    @Mock
    private RequestMaker requestMaker;

    /**
     * The mock marketing subscription.
     */
    @Mock
    private MarketingSubscription marketingSubscription;

    /**
     * The mocked page request.
     */
    @Mock
    private PageRequest pageRequest;

    /**
     * The mock marketing subscription string.
     */
    private String marketingSubscriptionStr;

    /**
     * The mock email list.
     */
    @Mock
    private EmailList emailList;

    /**
     * The mock email list string.
     */
    private String emailListStr;

    /**
     * The mock email list page.
     */
    @Mock
    private ItemPage<EmailList> emailListPage;

    /**
     * The mock email list page string.
     */
    private String emailListPageStr;

    /**
     * The mock marketing subscription page.
     */
    @Mock
    private ItemPage<MarketingSubscription> marketingSubscriptionPage;

    /**
     * The mock marketing subscription page string.
     */
    private String marketingSubscriptionPageStr;

    /**
     * The mock request maker.
     */
    @BeforeEach
    void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {

        when(parserFacade.getJsonParser()).thenReturn(jsonParser);

        marketingClient = MarketingClient.builder(OUTSETA_URL)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .accessKey(API_KEY)
                .build();

        marketingSubscriptionStr = "marketingSubscriptionStr";
    }

    /**
     * This method tests the getEmailList method.
     */
    @Test
    void testGetEmailList() {
        assertDoesNotThrow(() -> {
            when(requestMaker.get(OUTSETA_URL + "/email/lists/id",
                    new HashMap<>(), marketingClient.getHeaders()))
                    .thenReturn(emailListStr);
            when(parserFacade.jsonStringToObject(emailListStr,
                    EmailList.class))
                    .thenReturn(emailList);
            EmailList result = marketingClient
                    .getEmailList("id");

            assertEquals(emailList, result);
        });
    }

    /**
     * This method tests the getEmailList method with a null
     * id.
     */
    @Test
    void testGetEmailListNullId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> marketingClient
                    .getEmailList(null));
    }

    /**
     * This method tests the getEmailList method with a blank id.
     */
    @Test
    void testGetEmailListBlankId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> marketingClient
                    .getEmailList(""));
    }

    /**
     * This method tests the getEmailListPage method.
     */
    @Test
    void testGetEmailListPage() {
        assertDoesNotThrow(() -> {
            when(requestMaker.get(OUTSETA_URL + "/email/lists",
                    new HashMap<>(), marketingClient.getHeaders()))
                    .thenReturn(emailListPageStr);
            when(parserFacade.jsonStringToPage(emailListStr,
                    EmailList.class))
                    .thenReturn(emailListPage);
            ItemPage<EmailList> result = marketingClient
                    .getEmailListPage(pageRequest);

            assertEquals(emailListPage, result);
        });
    }

    /**
     * This method tests the getEmailListPage method with a null
     * page request.
     */
    @Test
    void testGetEmailListPageNullPageRequest() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> marketingClient
                    .getEmailListPage(null));
    }

    /**
     * This method tests the getSubscriptionPage method.
     */
    @Test
    void testGetSubscriptionPage() {
        assertDoesNotThrow(() -> {
            when(requestMaker.get(OUTSETA_URL + "/email/lists/emailListId"
                            + "/subscriptions",
                    new HashMap<>(), marketingClient.getHeaders()))
                    .thenReturn(marketingSubscriptionPageStr);
            when(parserFacade.jsonStringToPage(marketingSubscriptionPageStr,
                    MarketingSubscription.class))
                    .thenReturn(marketingSubscriptionPage);
            ItemPage<MarketingSubscription> result = marketingClient
                    .getSubscriptionPage("emailListId",
                            pageRequest);

            assertEquals(marketingSubscriptionPage, result);
        });
    }

    /**
     * This method tests the getSubscriptionPage method with a null
     * email list id.
     */
    @Test
    void testGetSubscriptionPageNullEmailListId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> marketingClient
                    .getSubscriptionPage(null,
                            pageRequest));
    }

    /**
     * This method tests the getSubscriptionPage method with a blank
     * email list id.
     */
    @Test
    void testGetSubscriptionPageBlankEmailListId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> marketingClient
                    .getSubscriptionPage("",
                            pageRequest));
    }

    /**
     * This method tests the getSubscriptionPage method with a null
     * page request.
     */
    @Test
    void testGetSubscriptionPageNullPageRequest() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> marketingClient
                    .getSubscriptionPage("emailListId",
                            null));
    }

    /**
     * This method tests the subscribePersonToList method.
     */
    @Test
    void testSubscribePersonToList() {
        assertDoesNotThrow(() -> {
            when(requestMaker.post(OUTSETA_URL + "/email/lists/emailListId"
                            + "/subscriptions",
                    new HashMap<>(), marketingSubscriptionStr,
                    marketingClient.getHeaders()))
                    .thenReturn(marketingSubscriptionStr);
            when(parserFacade.jsonStringToObject(marketingSubscriptionStr,
                    MarketingSubscription.class))
                    .thenReturn(marketingSubscription);
            when(parserFacade.objectToJsonString(marketingSubscription))
                    .thenReturn(marketingSubscriptionStr);
            MarketingSubscription result = marketingClient
                    .subscribePersonToList("emailListId",
                            marketingSubscription);

            assertEquals(marketingSubscription, result);
        });
    }

    /**
     * This method tests the subscribePersonToList method with a null
     * email list id.
     */
    @Test
    void testSubscribePersonToListNullEmailListId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> marketingClient
                    .subscribePersonToList(null,
                            marketingSubscription));
    }

    /**
     * This method tests the subscribePersonToList method with a blank
     * email list id.
     */
    @Test
    void testSubscribePersonToListBlankEmailListId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> marketingClient
                    .subscribePersonToList("",
                            marketingSubscription));
    }

    /**
     * This method tests the subscribePersonToList method with a null
     * marketing subscription.
     */
    @Test
    void testSubscribePersonToListNullMarketingSubscription() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> marketingClient
                    .subscribePersonToList("emailListId",
                            null));
    }

    /**
     * This method tests the removeSubscriberFromList method.
     */
    @Test
    void testRemovePersonFromList() {
        assertDoesNotThrow(() -> {
            when(requestMaker.delete(OUTSETA_URL + "/email/lists/emailListId"
                            + "/subscriptions/subscriptionId",
                    new HashMap<>(), marketingClient.getHeaders()))
                    .thenReturn("");
            marketingClient
                    .removeSubscriberFromList("emailListId",
                            "subscriptionId");

        });
    }

    /**
     * This method tests the removeSubscriberFromList method with a null
     * email list id.
     */
    @Test
    void testRemovePersonFromListNullEmailListId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> marketingClient
                    .removeSubscriberFromList(null,
                            "subscriptionId"));
    }

    /**
     * This method tests the removeSubscriberFromList method with a blank
     * email list id.
     */
    @Test
    void testRemovePersonFromListBlankEmailListId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> marketingClient
                    .removeSubscriberFromList("",
                            "subscriptionId"));
    }

    /**
     * This method tests the removeSubscriberFromList method with a null
     * subscription id.
     */
    @Test
    void testRemovePersonFromListNullSubscriptionId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> marketingClient
                    .removeSubscriberFromList("emailListId",
                            null));
    }

    /**
     * This method tests the removeSubscriberFromList method with a blank
     * subscription id.
     */
    @Test
    void testRemovePersonFromListBlankSubscriptionId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> marketingClient
                    .removeSubscriberFromList("emailListId",
                            ""));
    }
}
