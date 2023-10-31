package com.outseta.model.request;

import com.outseta.constant.BillingRenewalTerm;
import com.outseta.model.result.Account;
import com.outseta.model.result.Plan;
import com.outseta.model.result.SubscriptionAddOn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class is used to test the CreateSubscriptionRequest class.
 */
@ExtendWith(MockitoExtension.class)
public class CreateOrChangeSubscriptionRequestTest {

    /**
     * The CreateSubscriptionRequest object to test.
     */
    private CreateOrChangeSubscriptionRequest createOrChangeSubscriptionRequest;

    /**
     * The plan to use for testing.
     */
    @Mock
    private Plan plan1;

    /**
     * The plan to use for testing.
     */
    @Mock
    private Plan plan2;

    /**
     * The account to use for testing.
     */
    @Mock
    private Account account1;

    /**
     * The account to use for testing.
     */
    @Mock
    private Account account2;

    /**
     * The add-on to use for testing.
     */
    @Mock
    private SubscriptionAddOn subscriptionAddOn1;

    /**
     * The add-on to use for testing.
     */
    @Mock
    private SubscriptionAddOn subscriptionAddOn2;

    /**
     * This method is run before each test to set up the test environment.
     */
    @BeforeEach
    public void setUp() {
        createOrChangeSubscriptionRequest = CreateOrChangeSubscriptionRequest
                .builder()
                .account(account1)
                .billingRenewalTerm(BillingRenewalTerm.OneTime.getValue())
                .plan(plan1)
                .subscriptionAddOns(Arrays.asList(subscriptionAddOn1))
                .build();

    }

    /**
     * This method tests that correct values are set by builder.
     */
    @Test
    public void testBuilder() {
        assertEquals(account1, createOrChangeSubscriptionRequest.getAccount());
        assertEquals(BillingRenewalTerm.OneTime.getValue(),
                createOrChangeSubscriptionRequest.getBillingRenewalTerm());
        assertEquals(plan1, createOrChangeSubscriptionRequest.getPlan());
        assertEquals(Arrays.asList(subscriptionAddOn1),
                createOrChangeSubscriptionRequest.getSubscriptionAddOns());
    }

    /**
     * This method tests the default values set by builder.
     */
    @Test
    public void testBuilderDefaults() {
        createOrChangeSubscriptionRequest = CreateOrChangeSubscriptionRequest
                .builder()
                .build();

        assertNull(createOrChangeSubscriptionRequest.getAccount());
        assertNull(createOrChangeSubscriptionRequest.getBillingRenewalTerm());
        assertNull(createOrChangeSubscriptionRequest.getPlan());
        assertNull(createOrChangeSubscriptionRequest.getSubscriptionAddOns());
    }

    /**
     * This method tests the get and set methods for the account.
     */
    @Test
    public void testGetSetAccount() {
        assertEquals(account1, createOrChangeSubscriptionRequest.getAccount());
        createOrChangeSubscriptionRequest.setAccount(account2);
        assertEquals(account2, createOrChangeSubscriptionRequest.getAccount());
    }

    /**
     * This method tests the get and set methods for the billing renewal term.
     */
    @Test
    public void testGetSetBillingRenewalTerm() {
        assertEquals(BillingRenewalTerm.OneTime.getValue(),
                createOrChangeSubscriptionRequest.getBillingRenewalTerm());
        createOrChangeSubscriptionRequest.setBillingRenewalTerm(
                BillingRenewalTerm.Monthly.getValue());
        assertEquals(BillingRenewalTerm.Monthly.getValue(),
                createOrChangeSubscriptionRequest.getBillingRenewalTerm());
    }

    /**
     * This method tests the get and set methods for the plan.
     */
    @Test
    public void testGetSetPlan() {
        assertEquals(plan1, createOrChangeSubscriptionRequest.getPlan());
        createOrChangeSubscriptionRequest.setPlan(plan2);
        assertEquals(plan2, createOrChangeSubscriptionRequest.getPlan());
    }

    /**
     * This method tests the get and set methods for the subscription add-ons.
     */
    @Test
    public void testGetSetSubscriptionAddOns() {
        assertEquals(Arrays.asList(subscriptionAddOn1),
                createOrChangeSubscriptionRequest.getSubscriptionAddOns());
        createOrChangeSubscriptionRequest.setSubscriptionAddOns(
                Arrays.asList(subscriptionAddOn2));
        assertEquals(Arrays.asList(subscriptionAddOn2),
                createOrChangeSubscriptionRequest.getSubscriptionAddOns());
    }

}
