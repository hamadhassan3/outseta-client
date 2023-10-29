package com.outseta.client.endpoint_client.billing;

import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.exception.OutsetaPageBuildException;
import com.outseta.model.request.CreateOrChangeSubscriptionRequest;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.Invoice;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Subscription;
import com.outseta.model.result.SubscriptionAddOn;
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
 * This class is used to test the SubscriptionClient class.
 */
@ExtendWith(MockitoExtension.class)
public class SubscriptionClientUnitTest {

    /**
     * The client that is used to make calls to the subscription endpoints.
     */
    private SubscriptionClient subscriptionClient;

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
     * The subscription used for testing.
     */
    @Mock
    private Subscription subscription;

    /**
     * The subscription page used for testing.
     */
    @Mock
    private ItemPage<Subscription> subscriptionPage;

    /**
     * The create or change subscription request used for testing.
     */
    @Mock
    private CreateOrChangeSubscriptionRequest createOrChangeSubscriptionRequest;

    /**
     * The subscription add-on used for testing.
     */
    @Mock
    private SubscriptionAddOn subscriptionAddOn;

    /**
     * The subscription add-on string used for testing.
     */
    private String subscriptionAddOnStr;

    /**
     * The invoice used for testing.
     */
    @Mock
    private Invoice invoice;

    /**
     * The invoice string used for testing.
     */
    private String invoiceStr;

    /**
     * The create or change subscription request string used for testing.
     */
    private String createOrChangeSubscriptionRequestStr;

    /**
     * The subscription string used for testing.
     */
    private String subscriptionStr;

    /**
     * The page size used for testing.
     */
    private static final int PAGE_SIZE = 10;

    /**
     * This method is used to set up the tests.
     */
    @BeforeEach
    public void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        when(parserFacade.getJsonParser()).thenReturn(jsonParser);
        subscriptionClient = SubscriptionClient.builder(OUTSETA_URL)
                .apiKey(OUTSETA_KEY)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .build();

        invoiceStr = "invoice";
        createOrChangeSubscriptionRequestStr =
                "createOrChangeSubscriptionRequest";
        subscriptionStr = "subscription";
        subscriptionAddOnStr = "subscriptionAddOn";
    }

    /**
     * This method tests the getSubscription method.
     */
    @Test
    public void testGetSubscription() {
        assertDoesNotThrow(() -> {
            when(requestMaker.get(OUTSETA_URL + "/billing/subscriptions/id",
                    new HashMap<>(), subscriptionClient.getHeaders()))
                    .thenReturn(subscriptionStr);
            when(parserFacade.jsonStringToObject(subscriptionStr,
                    Subscription.class))
                    .thenReturn(subscription);
            Subscription result = subscriptionClient
                    .getSubscription("id");

            assertEquals(subscription, result);
        });
    }

    /**
     * This method tests getSubscription with a null id.
     */
    @Test
    public void testGetSubscriptionNullId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.getSubscription(null);
        });
    }

    /**
     * This method tests getSubscription with a blank id.
     */
    @Test
    public void testGetSubscriptionBlankId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.getSubscription("");
        });
    }

    /**
     * This method tests the getSubscriptionPage method.
     */
    @Test
    public void testGetSubscriptionPage() throws OutsetaPageBuildException {
        PageRequest pageRequest = PageRequest.builder()
                .pageSize(PAGE_SIZE)
                .page(1)
                .build();

        assertDoesNotThrow(() -> {
            when(requestMaker.get(OUTSETA_URL + "/billing/subscriptions",
                    pageRequest.buildParams(),
                    subscriptionClient.getHeaders()))
                    .thenReturn(subscriptionStr);
            when(parserFacade.jsonStringToPage(subscriptionStr,
                    Subscription.class))
                    .thenReturn(subscriptionPage);
            ItemPage<Subscription> result = subscriptionClient
                    .getSubscriptionPage(pageRequest);

            assertEquals(subscriptionPage, result);
        });
    }

    /**
     * This method tests the getSubscriptionPage method with a null page
     * request.
     */
    @Test
    public void testGetSubscriptionPageNullPageRequest() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.getSubscriptionPage(null);
        });
    }

    /**
     * This method tests the addFirstTimeSubscriptionPreview method.
     */
    @Test
    public void testAddFirstTimeSubscriptionPreview() {

        HashMap<String, Object> params = new HashMap<>();
        params.put("asOf", "now");
        assertDoesNotThrow(() -> {
            when(requestMaker.post(OUTSETA_URL
                            + "/billing/subscriptions/compute-charge-summary",
                    params,
                    createOrChangeSubscriptionRequestStr,
                    subscriptionClient.getHeaders()))
                    .thenReturn(invoiceStr);
            when(parserFacade.objectToJsonString(
                        createOrChangeSubscriptionRequest))
                    .thenReturn(createOrChangeSubscriptionRequestStr);
            when(parserFacade.jsonStringToObject(invoiceStr,
                    Invoice.class))
                    .thenReturn(invoice);
            Invoice result = subscriptionClient
                    .addFirstTimeSubscriptionPreview("now",
                            createOrChangeSubscriptionRequest);

            assertEquals(invoice, result);
        });
    }

    /**
     * This method tests the addFirstTimeSubscriptionPreview method.
     */
    @Test
    public void testAddFirstTimeSubscriptionPreviewWithNullAsOf() {

        HashMap<String, Object> params = new HashMap<>();
        assertDoesNotThrow(() -> {
            when(requestMaker.post(OUTSETA_URL
                            + "/billing/subscriptions/compute-charge-summary",
                    params,
                    createOrChangeSubscriptionRequestStr,
                    subscriptionClient.getHeaders()))
                    .thenReturn(invoiceStr);
            when(parserFacade.objectToJsonString(
                    createOrChangeSubscriptionRequest))
                    .thenReturn(createOrChangeSubscriptionRequestStr);
            when(parserFacade.jsonStringToObject(invoiceStr,
                    Invoice.class))
                    .thenReturn(invoice);
            Invoice result = subscriptionClient
                    .addFirstTimeSubscriptionPreview(null,
                            createOrChangeSubscriptionRequest);

            assertEquals(invoice, result);
        });
    }

    /**
     * This method tests the addFirstTimeSubscriptionPreview method with a null
     * create or change subscription request.
     */
    @Test
    public void testAddFirstTimeSubscriptionPreviewNullRequest() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.addFirstTimeSubscriptionPreview(null,
                    null);
        });
    }

    /**
     * This method tests the addFirstTimeSubscription method.
     */
    @Test
    public void testAddFirstTimeSubscription() {
        assertDoesNotThrow(() -> {
            when(requestMaker.put(OUTSETA_URL
                            + "/billing/subscriptions/firsttimesubscription",
                    new HashMap<>(),
                    createOrChangeSubscriptionRequestStr,
                    subscriptionClient.getHeaders()))
                    .thenReturn(subscriptionStr);
            when(parserFacade.objectToJsonString(
                    createOrChangeSubscriptionRequest))
                    .thenReturn(createOrChangeSubscriptionRequestStr);
            when(parserFacade.jsonStringToObject(subscriptionStr,
                    Subscription.class))
                    .thenReturn(subscription);
            Subscription result = subscriptionClient
                    .addFirstTimeSubscription(
                            createOrChangeSubscriptionRequest);

            assertEquals(subscription, result);
        });
    }

    /**
     * This method tests the addFirstTimeSubscription method with a null
     * create or change subscription request.
     */
    @Test
    public void testAddFirstTimeSubscriptionNullRequest() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.addFirstTimeSubscription(null);
        });
    }

    /**
     * This method tests the changeSubscriptionPreview method.
     */
    @Test
    public void testChangeSubscriptionPreview() {
        assertDoesNotThrow(() -> {
            when(requestMaker.put(OUTSETA_URL
                            + "/billing/subscriptions/"
                            + "id/changesubscriptionpreview",
                    new HashMap<>(),
                    createOrChangeSubscriptionRequestStr,
                    subscriptionClient.getHeaders()))
                    .thenReturn(invoiceStr);
            when(parserFacade.objectToJsonString(
                    createOrChangeSubscriptionRequest))
                    .thenReturn(createOrChangeSubscriptionRequestStr);
            when(parserFacade.jsonStringToObject(invoiceStr,
                    Invoice.class))
                    .thenReturn(invoice);
            Invoice result = subscriptionClient
                    .changeSubscriptionPreview("id",
                            createOrChangeSubscriptionRequest);

            assertEquals(invoice, result);
        });
    }

    /**
     * This method tests the changeSubscriptionPreview method with a null id.
     */
    @Test
    public void testChangeSubscriptionPreviewNullId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.changeSubscriptionPreview(null,
                    createOrChangeSubscriptionRequest);
        });
    }

    /**
     * This method tests the changeSubscriptionPreview method with a blank id.
     */
    @Test
    public void testChangeSubscriptionPreviewBlankId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.changeSubscriptionPreview("",
                    createOrChangeSubscriptionRequest);
        });
    }

    /**
     * This method tests the changeSubscriptionPreview method with a null
     * create or change subscription request.
     */
    @Test
    public void testChangeSubscriptionPreviewNullRequest() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.changeSubscriptionPreview("id",
                    null);
        });
    }

    /**
     * This method tests the changeSubscription method.
     */
    @Test
    public void testChangeSubscription() {
        assertDoesNotThrow(() -> {
            when(requestMaker.put(OUTSETA_URL
                            + "/billing/subscriptions/"
                            + "id/changesubscription",
                    new HashMap<>(),
                    createOrChangeSubscriptionRequestStr,
                    subscriptionClient.getHeaders()))
                    .thenReturn(subscriptionStr);
            when(parserFacade.objectToJsonString(
                    createOrChangeSubscriptionRequest))
                    .thenReturn(createOrChangeSubscriptionRequestStr);
            when(parserFacade.jsonStringToObject(subscriptionStr,
                    Subscription.class))
                    .thenReturn(subscription);
            Subscription result = subscriptionClient
                    .changeSubscription("id",
                            createOrChangeSubscriptionRequest);

            assertEquals(subscription, result);
        });
    }

    /**
     * This method tests the changeSubscription method with a null id.
     */
    @Test
    public void testChangeSubscriptionNullId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.changeSubscription(null,
                    createOrChangeSubscriptionRequest);
        });
    }

    /**
     * This method tests the changeSubscription method with a blank id.
     */
    @Test
    public void testChangeSubscriptionBlankId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.changeSubscription("",
                    createOrChangeSubscriptionRequest);
        });
    }

    /**
     * This method tests the changeSubscription method with a null
     * create or change subscription request.
     */
    @Test
    public void testChangeSubscriptionNullRequest() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.changeSubscription("id",
                    null);
        });
    }

    /**
     * This method tests the setSubscriptionUpgradeRequired method.
     */
    @Test
    public void testSetSubscriptionUpgradeRequired() {
        assertDoesNotThrow(() -> {
            when(requestMaker.put(OUTSETA_URL
                            + "/billing/subscriptions/"
                            + "id/setsubscriptionupgraderequired",
                    new HashMap<>(),
                    subscriptionStr,
                    subscriptionClient.getHeaders())).thenReturn(
                            subscriptionStr);
            when(parserFacade.objectToJsonString(
                    subscription))
                    .thenReturn(subscriptionStr);

            when(parserFacade.jsonStringToObject(subscriptionStr,
                    Subscription.class))
                    .thenReturn(subscription);

            Subscription result = subscriptionClient
                    .setSubscriptionUpgradeRequired("id",
                            subscription);
        });
    }

    /**
     * This method tests the setSubscriptionUpgradeRequired method with a null
     * id.
     */
    @Test
    public void testSetSubscriptionUpgradeRequiredNullId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.setSubscriptionUpgradeRequired(null,
                    subscription);
        });
    }

    /**
     * This method tests the setSubscriptionUpgradeRequired method with a blank
     * id.
     */
    @Test
    public void testSetSubscriptionUpgradeRequiredBlankId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.setSubscriptionUpgradeRequired("",
                    subscription);
        });
    }

    /**
     * This method tests the setSubscriptionUpgradeRequired method with a null
     * subscription.
     */
    @Test
    public void testSetSubscriptionUpgradeRequiredNullSubscription() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.setSubscriptionUpgradeRequired("id",
                    null);
        });
    }

    /**
     * This method tests the extendTrialSubscription method.
     */
    @Test
    public void testExtendTrialSubscription() {
        assertDoesNotThrow(() -> {
            when(requestMaker.put(OUTSETA_URL
                            + "/crm/accounts/extendtrial/accountId/date",
                    new HashMap<>(),
                    "",
                    subscriptionClient.getHeaders())).thenReturn("");
            subscriptionClient
                    .extendTrialSubscription("accountId",
                            "date");
        });
    }

/**
     * This method tests the extendTrialSubscription method with a null
     * account id.
     */
    @Test
    public void testExtendTrialSubscriptionNullAccountId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.extendTrialSubscription(null,
                    "date");
        });
    }

    /**
     * This method tests the extendTrialSubscription method with a blank
     * account id.
     */
    @Test
    public void testExtendTrialSubscriptionBlankAccountId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.extendTrialSubscription("",
                    "date");
        });
    }

    /**
     * This method tests the extendTrialSubscription method with a null
     * date.
     */
    @Test
    public void testExtendTrialSubscriptionNullDate() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.extendTrialSubscription("accountId",
                    null);
        });
    }

    /**
     * This method tests the extendTrialSubscription method with a blank
     * date.
     */
    @Test
    public void testExtendTrialSubscriptionBlankDate() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.extendTrialSubscription("accountId",
                    "");
        });
    }

    /**
     * This method tests the addAddOnToSubscription method.
     */
    @Test
    public void testAddAddOnToSubscription() {
        assertDoesNotThrow(() -> {
            when(requestMaker.post(OUTSETA_URL
                            + "/billing/subscriptionaddons",
                    new HashMap<>(),
                    subscriptionAddOnStr,
                    subscriptionClient.getHeaders()))
                    .thenReturn(subscriptionStr);
            when(parserFacade.objectToJsonString(
                    subscriptionAddOn))
                    .thenReturn(subscriptionAddOnStr);
            when(parserFacade.jsonStringToObject(subscriptionStr,
                    Subscription.class))
                    .thenReturn(subscription);
            Subscription result = subscriptionClient
                    .addAddOnToSubscription(subscriptionAddOn);

            assertNotNull(result);
            assertEquals(result, subscription);
        });
    }

    /**
     * This method tests the addAddOnToSubscription method with a null
     * subscription add-on.
     */
    @Test
    public void testAddAddOnToSubscriptionNullSubscriptionAddOn() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.addAddOnToSubscription(null);
        });
    }

    /**
     * This method tests the addDiscountToSubscription method.
     */
    @Test
    public void testAddDiscountToSubscription() {
        assertDoesNotThrow(() -> {
            when(requestMaker.post(OUTSETA_URL
                            + "/billing/subscriptions/subId/discounts/id",
                    new HashMap<>(),
                    "",
                    subscriptionClient.getHeaders())).thenReturn("");
            subscriptionClient
                    .addDiscountToSubscription("subId", "id");
        });
    }

    /**
     * This method tests with null subscription id.
     */
    @Test
    public void testAddDiscountToSubscriptionNullSubscriptionId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.addDiscountToSubscription(null,
                    "id");
        });
    }

    /**
     * This method tests with blank subscription id.
     */
    @Test
    public void testAddDiscountToSubscriptionBlankSubscriptionId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.addDiscountToSubscription("",
                    "id");
        });
    }

    /**
     * This method tests with null discount id.
     */
    @Test
    public void testAddDiscountToSubscriptionNullDiscountId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.addDiscountToSubscription("subId",
                    null);
        });
    }

    /**
     * This method tests with blank discount id.
     */
    @Test
    public void testAddDiscountToSubscriptionBlankDiscountId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            subscriptionClient.addDiscountToSubscription("subId",
                    "");
        });
    }
}
