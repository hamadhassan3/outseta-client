package com.outseta.client.endpoint_client.integration;

import com.outseta.client.endpoint_client.MarketingClient;
import com.outseta.client.endpoint_client.crm.PeopleClient;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.OutsetaParseException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.EmailList;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.MarketingSubscription;
import com.outseta.model.result.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class is used to test the MarketingClient class.
 * It is an integration test because it uses the actual Outseta API.
 */
@ExtendWith(MockitoExtension.class)
@Tag("integration")
public class MarketingClientIntegrationTest {

    /**
     * The Outseta API Key.
     */
    private static String outsetaKey = System.getenv("OUTSETA_KEY");

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");

    /**
     * The marketing client to test.
     */
    private MarketingClient marketingClient;

    /**
     * The people client to aid in testing.
     */
    private static PeopleClient peopleClient;

    /**
     * The person to aid in testing.
     */
    private static Person person;

    /**
     * This method is called before all tests to set up the test environment.
     */
    @BeforeAll
    public static void setupAll() throws OutsetaClientBuildException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaParseException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException,
            OutsetaInvalidRequestMakerException {
        peopleClient = PeopleClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();

        person = peopleClient.createPerson(Person.builder()
                .email("testMarketing@dummy.com")
                .firstName("Test")
                .lastName("Marketing")
                .build());
    }

    /**
     * This method is called before each test to set up the test environment.
     */
    @BeforeEach
    public void setup() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaParseException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {
        marketingClient = MarketingClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();
    }

    /**
     * This method is called after all tests to clean up the test environment.
     */
    @AfterAll
    public static void tearDown() throws
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaParseException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {
        peopleClient.deletePerson(person.getUid());
    }

    /**
     * This method tests the getEmailList method.
     */
    @Test
    public void getEmailListTest() {
        assertDoesNotThrow(() -> {
            EmailList emailList =
               marketingClient.getEmailList(System.getenv("EMAIL_LIST_ID"));

            assertEquals(System.getenv("EMAIL_LIST_ID"),
                    emailList.getUid());
        });
    }

    /**
     * This method tests the getEmailListPage method.
     */
    @Test
    public void testGetEmailListPage() {

        final int page = 0;
        final int pageSize = 25;

        List<EmailList> allEmailLists = new ArrayList<>();

        assertDoesNotThrow(() -> {
            PageRequest request = PageRequest.builder()
                    .page(page)
                    .pageSize(pageSize)
                    .build();

            int total = 0;
            ItemPage<EmailList> itemPage = null;
            final int maxSize = 100;
            do {
                // Keep making requests as long as there are more pages
                itemPage = marketingClient.getEmailListPage(request);
                total = itemPage.getMetadata().getTotal();

                assertNotNull(itemPage);

                // The current page's items are aggregated
                allEmailLists.addAll(itemPage.getItems());

                assertEquals(
                        (request.getPageSize() * request.getPageNum())
                                + itemPage.getItems().size(),
                        allEmailLists.size());

                request = request.nextPageRequest();

            }
            while (allEmailLists.size() < total
                    && allEmailLists.size() < maxSize);

        });
    }

    /**
     * This method tests the subscribePersonToList, getSubscription and
     * removeSubscriptionFromList method.
     */
    @Test
    public void testCreateAndGetSubscription() {
        assertDoesNotThrow(() -> {

            String emailListId = System.getenv("EMAIL_LIST_ID");

            MarketingSubscription newSub = MarketingSubscription.builder()
                    .emailList(EmailList.builder().uid(emailListId).build())
                    .person(person)
                    .sendWelcomeEmail(false)
                    .build();

            MarketingSubscription createdSub = marketingClient
                    .subscribePersonToList(emailListId, newSub);

            assertNotNull(createdSub);
            assertNotNull(createdSub.getUid());
            assertEquals(person, createdSub.getPerson());
            assertEquals(emailListId, createdSub.getEmailList().getUid());

            marketingClient.removeSubscriberFromList(emailListId,
                    createdSub.getUid());
        });
    }

    /**
     * This method tests the getSubscriptionPage method.
     */
    @Test
    public void testGetSubscriptionPage() {

        final int page = 0;
        final int pageSize = 25;

        List<MarketingSubscription> allSubs = new ArrayList<>();

        assertDoesNotThrow(() -> {

            PageRequest request = PageRequest.builder()
                    .page(page)
                    .pageSize(pageSize)
                    .build();

            int total = 0;
            ItemPage<MarketingSubscription> itemPage = null;
            final int maxSize = 100;
            do {
                // Keep making requests as long as there are more pages
                itemPage = marketingClient.getSubscriptionPage(
                        System.getenv("EMAIL_LIST_ID"),
                        request);
                total = itemPage.getMetadata().getTotal();

                assertNotNull(itemPage);

                // The current page's items are aggregated
                allSubs.addAll(itemPage.getItems());

                assertEquals(
                        (request.getPageSize() * request.getPageNum())
                                + itemPage.getItems().size(),
                        allSubs.size());

                request = request.nextPageRequest();

            }
            while (allSubs.size() < total
                    && allSubs.size() < maxSize);

        });
    }
}
