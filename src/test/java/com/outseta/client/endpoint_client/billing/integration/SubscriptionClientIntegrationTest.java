package com.outseta.client.endpoint_client.billing.integration;

import com.outseta.client.endpoint_client.billing.DiscountClient;
import com.outseta.client.endpoint_client.billing.PlanClient;
import com.outseta.client.endpoint_client.billing.SubscriptionClient;
import com.outseta.client.endpoint_client.crm.AccountClient;
import com.outseta.client.endpoint_client.crm.PeopleClient;
import com.outseta.constant.AccountStage;
import com.outseta.constant.BillingRenewalTerm;
import com.outseta.constant.DiscountDuration;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.OutsetaPageBuildException;
import com.outseta.exception.OutsetaParseException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.model.request.CreateOrChangeSubscriptionRequest;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.Account;
import com.outseta.model.result.AddOn;
import com.outseta.model.result.Discount;
import com.outseta.model.result.Invoice;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Person;
import com.outseta.model.result.PersonAccount;
import com.outseta.model.result.Plan;
import com.outseta.model.result.Subscription;
import com.outseta.model.result.SubscriptionAddOn;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class tests the SubscriptionClient class.
 * It contains integration tests that make calls to the Outseta API.
 */
@ExtendWith(MockitoExtension.class)
@Tag("integration")
public class SubscriptionClientIntegrationTest {

    /**
     * The Outseta API Key.
     */
    private static String outsetaKey = System.getenv("OUTSETA_KEY");

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");


    /**
     * The SubscriptionClient object to test.
     */
    private SubscriptionClient subscriptionClient;

    /**
     * The Plan object to use for testing.
     */
    private Plan createdPlan;

    /**
     * The Account object to use for testing.
     */
    private Account createdAccount;

    /**
     * The Person object to use for testing.
     */
    private Person createdPerson;

    /**
     * The Invoice object to use for testing.
     */
    private Invoice invoice;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    public void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException, OutsetaPageBuildException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaParseException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {
        subscriptionClient = SubscriptionClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();

        PlanClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build()
                .getPlanPage(PageRequest.builder()
                        .page(0)
                        .pageSize(1)
                        .build())
                .getItems()
                .stream()
                .findFirst()
                .ifPresent(plan -> createdPlan = plan);

        createdPerson = PeopleClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build().createPerson(Person.builder()
                        .email("hammad-test-outseta-client@outseta-client.com")
                        .firstName("hammad-outseta")
                        .lastName("hammad-client")
                        .build());

        createdAccount = AccountClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build().createAccountWithExistingPerson(Account.builder()
                        .name("hammad-test-outseta-client")
                        .accountStage(AccountStage.Trialing)
                        .personAccount(Arrays.asList(PersonAccount.builder()
                                .person(createdPerson)
                                .primary(true)
                                .build()))
                        .build());

    }

    /**
     * This method is run after each test.
     */
    @AfterEach
    public void tearDown() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        AccountClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build().deleteAccount(createdAccount.getUid());

        PeopleClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build().deletePerson(createdPerson.getUid());
    }

    /**
     * This method tests the getSubscription, getSubscriptionPage and
     * addFirstTimeSubscription methods.
     */
    @Test
    public void getSubscriptionTest() {
        final int page = 0;
        final int pageSize = 25;

        List<Subscription> allSubscriptions = new ArrayList<>();

        assertDoesNotThrow(() -> {

            subscriptionClient.addFirstTimeSubscription(
                    CreateOrChangeSubscriptionRequest.builder()
                            .account(createdAccount)
                            .plan(createdPlan)
                            .billingRenewalTerm(
                                    BillingRenewalTerm.Monthly.getValue())
                            .build());

            PageRequest request = PageRequest.builder()
                    .page(page)
                    .pageSize(pageSize)
                    .build();

            int total = 0;
            ItemPage<Subscription> itemPage = null;
            final int maxSize = 100;
            do {
                // Keep making requests as long as there are more pages
                itemPage = subscriptionClient.getSubscriptionPage(request);
                total = itemPage.getMetadata().getTotal();

                assertNotNull(itemPage);

                // The current page's items are aggregated
                allSubscriptions.addAll(itemPage.getItems());

                assertEquals(
                        (request.getPageSize() * request.getPageNum())
                                + itemPage.getItems().size(),
                        allSubscriptions.size());

                request = request.nextPageRequest();

            }
            while (allSubscriptions.size() < total
                    && allSubscriptions.size() < maxSize);

            // Testing getSubscription
            Subscription subscription = subscriptionClient.getSubscription(
                    allSubscriptions.get(0).getUid());
            assertEquals(subscription.getUid(),
                    allSubscriptions.get(0).getUid());
        });
    }

    /**
     * This method tests the addFirstTimeSubscriptionPreview method.
     */
    @Test
    public void addFirstTimeSubscriptionPreviewTest() {

        assertDoesNotThrow(() -> {
            Invoice inv = subscriptionClient.addFirstTimeSubscriptionPreview(
                    "now",
                    CreateOrChangeSubscriptionRequest.builder()
                            .account(createdAccount)
                            .plan(createdPlan)
                            .billingRenewalTerm(
                                    BillingRenewalTerm.Monthly.getValue())
                            .build());

            assertNotNull(inv);
        });
    }

    /**
     * This method tests the addSubscription method with addon.
     */
    @Test
    public void addSubscriptionWithAddonTest() {

        assertDoesNotThrow(() -> {
            Subscription sub = subscriptionClient.addFirstTimeSubscription(
                    CreateOrChangeSubscriptionRequest.builder()
                            .account(createdAccount)
                            .plan(createdPlan)
                            .billingRenewalTerm(
                                    BillingRenewalTerm.Monthly.getValue())
                            .subscriptionAddOns(Arrays.asList(SubscriptionAddOn
                                    .builder()
                                            .addOn(AddOn.builder()
                                                    .uid("zWZz3bWp")
                                                    .build())
                                    .build()))
                            .build());

            assertNotNull(sub);
            assertEquals(sub.getAccount().getUid(), createdAccount.getUid());
            assertEquals(sub.getPlan().getUid(), createdPlan.getUid());
            assertEquals(sub.getBillingRenewalTerm(),
                    BillingRenewalTerm.Monthly.getValue());
            assertEquals(1, sub.getSubscriptionAddOns().size());
        });
    }

    /**
     * This method tests the changeSubscriptionPreview method.
     */
    @Test
    public void changeSubscriptionPreviewTest() {

        assertDoesNotThrow(() -> {
            Subscription sub = subscriptionClient.addFirstTimeSubscription(
                    CreateOrChangeSubscriptionRequest.builder()
                            .account(createdAccount)
                            .plan(createdPlan)
                            .billingRenewalTerm(
                                    BillingRenewalTerm.Monthly.getValue())
                            .build());

            assertNotNull(sub);

            Invoice inv = subscriptionClient.changeSubscriptionPreview(
                    sub.getUid(),
                    CreateOrChangeSubscriptionRequest.builder()
                            .account(createdAccount)
                            .plan(createdPlan)
                            .billingRenewalTerm(
                                    BillingRenewalTerm.Monthly.getValue())
                            .build());

            assertNotNull(inv);
        });
    }

    /**
     * This method tests the changeSubscription method.
     */
    @Test
    public void changeSubscriptionTest() {

        assertDoesNotThrow(() -> {
            Subscription sub = subscriptionClient.addFirstTimeSubscription(
                    CreateOrChangeSubscriptionRequest.builder()
                            .account(createdAccount)
                            .plan(createdPlan)
                            .billingRenewalTerm(
                                    BillingRenewalTerm.Monthly.getValue())
                            .build());

            assertNotNull(sub);

            Subscription result = subscriptionClient.changeSubscription(
                    sub.getUid(),
                    CreateOrChangeSubscriptionRequest.builder()
                            .account(createdAccount)
                            .plan(createdPlan)
                            .billingRenewalTerm(
                                    BillingRenewalTerm.Monthly.getValue())
                            .build());

            assertNotNull(result);
            assertEquals(createdAccount, result.getAccount());
            assertEquals(createdPlan, result.getPlan());
            assertEquals(BillingRenewalTerm.Monthly.getValue(),
                    result.getBillingRenewalTerm());
        });
    }

    /**
     * This method tests the setSubscriptionUpgradeRequired method.
     */
    @Test
    public void setSubscriptionUpgradeRequiredTest() {

        assertDoesNotThrow(() -> {
            Subscription sub = subscriptionClient.addFirstTimeSubscription(
                    CreateOrChangeSubscriptionRequest.builder()
                            .account(createdAccount)
                            .plan(createdPlan)
                            .billingRenewalTerm(
                                    BillingRenewalTerm.Monthly.getValue())
                            .build());

            assertNotNull(sub);

            sub.setPlanUpgradeRequired(true);
            sub.setPlanUpgradeRequiredMessage("Because I said so");

            Subscription result = subscriptionClient
                    .setSubscriptionUpgradeRequired(
                        sub.getUid(),
                            sub);

            assertNotNull(result);
            assertEquals(createdAccount, result.getAccount());
            assertEquals(createdPlan, result.getPlan());
            assertEquals(BillingRenewalTerm.Monthly.getValue(),
                    result.getBillingRenewalTerm());
            assertTrue(result.isPlanUpgradeRequired());
            assertEquals("Because I said so",
                    result.getPlanUpgradeRequiredMessage());
        });
    }

    /**
     * This method tests the extendTrialSubscription method.
     */
    @Test
    public void extendTrialSubscriptionTest() {

        assertDoesNotThrow(() -> {

            // Set the account stage to TrialExpired
            AccountClient accountClient = AccountClient.builder(outsetaUrl)
                    .apiKey(outsetaKey)
                    .defaultParser()
                    .defaultRequestMaker()
                    .build();
            Subscription sub = subscriptionClient.addFirstTimeSubscription(
                    CreateOrChangeSubscriptionRequest.builder()
                            .account(createdAccount)
                            .plan(createdPlan)
                            .billingRenewalTerm(
                                    BillingRenewalTerm.Monthly.getValue())
                            .build());

            assertNotNull(sub);

            // Expiring the account
            createdAccount.setPersonAccount(null);
            createdAccount.setAccountStage(AccountStage.TrialExpired
                    .getValue());

            createdAccount = accountClient.updateAccount(
                    createdAccount.getUid(),
                    createdAccount);

            subscriptionClient.extendTrialSubscription(
                    createdAccount.getUid(),
                    "2023-11-11");

            createdAccount = accountClient.getAccount(createdAccount.getUid());

            assertEquals(AccountStage.Trialing.getValue(),
                    createdAccount.getAccountStage());
        });
    }

    /**
     * This method tests the addAddOnToSubscription method.
     */
    @Test
    public void addAddOnToSubscriptionTest() {

        assertDoesNotThrow(() -> {
            Subscription sub = subscriptionClient.addFirstTimeSubscription(
                    CreateOrChangeSubscriptionRequest.builder()
                            .account(createdAccount)
                            .plan(createdPlan)
                            .billingRenewalTerm(
                                    BillingRenewalTerm.Monthly.getValue())
                            .build());

            assertNotNull(sub);

            SubscriptionAddOn subscriptionAddOn = SubscriptionAddOn.builder()
                    .addOn(AddOn.builder()
                            .uid("zWZz3bWp")
                            .build())
                    .billingRenewalTerm(BillingRenewalTerm.Monthly.getValue())
                    .quantity(1)
                    .subscription(sub)
                    .build();

            Subscription result = subscriptionClient.addAddOnToSubscription(
                    subscriptionAddOn);


            assertNotNull(result);
            assertEquals(createdAccount, result.getAccount());
            assertEquals(createdPlan, result.getPlan());
            assertEquals(BillingRenewalTerm.Monthly.getValue(),
                    result.getBillingRenewalTerm());
            assertEquals(1, result.getSubscriptionAddOns().size());
        });
    }

    /**
     * This method tests the addDiscountToSubscription method.
     */
    @Test
    public void addDiscountToSubscriptionTest() {

        assertDoesNotThrow(() -> {
            Subscription sub = subscriptionClient.addFirstTimeSubscription(
                    CreateOrChangeSubscriptionRequest.builder()
                            .account(createdAccount)
                            .plan(createdPlan)
                            .billingRenewalTerm(
                                    BillingRenewalTerm.Monthly.getValue())
                            .build());

            assertNotNull(sub);

            final double amountOff = 10.1;

            DiscountClient discountClient = DiscountClient.builder(outsetaUrl)
                    .apiKey(outsetaKey)
                    .defaultParser()
                    .defaultRequestMaker()
                    .build();

            Discount discount = discountClient.createDiscount(Discount.builder()
                            .uniqueIdentifier("testSubscription")
                            .active(true)
                            .maxRedemptions(1)
                            .durationInMonths(1)
                            .duration(DiscountDuration.FOREVER)
                            .amountOff(amountOff)
                            .name("Hammad Test Discount")
                            .build());

            subscriptionClient.addDiscountToSubscription(
                    sub.getUid(),
                    discount.getUid());

        });
    }

}
