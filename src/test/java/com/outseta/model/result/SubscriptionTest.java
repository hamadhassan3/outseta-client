package com.outseta.model.result;

import com.outseta.constant.BillingRenewalTerm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class test the Subscription class.
 */
@ExtendWith(MockitoExtension.class)
public class SubscriptionTest {

    /**
     * The subscription object used for testing.
     */
    private Subscription subscription;

    /**
     * The account object used for testing.
     */
    @Mock
    private Account account1;

    /**
     * The account object used for testing.
     */
    @Mock
    private Account account2;

    /**
     * The plan object used for testing.
     */
    @Mock
    private Plan plan1;

    /**
     * The plan object used for testing.
     */
    @Mock
    private Plan plan2;

    /**
     * The SubscriptionAddOn object used for testing.
     */
    @Mock
    private SubscriptionAddOn subscriptionAddOn1;

    /**
     * The SubscriptionAddOn object used for testing.
     */
    @Mock
    private SubscriptionAddOn subscriptionAddOn2;

    /**
     * A random timestamp to create dates.
     */
    private static final long TIMESTAMP = 1612137600;

    /**
     * The quantity used for testing.
     */
    private static final int QUANTITY = 2;

    /**
     * The newRequiredQuantity used for testing.
     */
    private static final int NEW_REQUIRED_QUANTITY = 3;

    /**
     * This method is called before each test.
     */
    @BeforeEach
    public void setUp() {

        subscription = Subscription.builder()
                .billingRenewalTerm(1)
                .billingRenewalTerm(BillingRenewalTerm.Monthly.getValue())
                .account(account1)
                .plan(plan1)
                .quantity(QUANTITY)
                .startDate(new Date(TIMESTAMP))
                .endDate(new Date(TIMESTAMP))
                .renewalDate(new Date(TIMESTAMP))
                .newRequiredQuantity(NEW_REQUIRED_QUANTITY)
                .planUpgradeRequired(false)
                .planUpgradeRequiredMessage("message")
                .subscriptionAddOns(Arrays.asList(subscriptionAddOn1))
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
    }

    /**
     * This method tests that correct values are set by the builder.
     */
    @Test
    public void testBuilder() {
        assertEquals(1, subscription.getBillingRenewalTerm());
        assertEquals(account1, subscription.getAccount());
        assertEquals(plan1, subscription.getPlan());
        assertEquals(QUANTITY, subscription.getQuantity());
        assertEquals(new Date(TIMESTAMP), subscription.getStartDate());
        assertEquals(new Date(TIMESTAMP), subscription.getEndDate());
        assertEquals(new Date(TIMESTAMP), subscription.getRenewalDate());
        assertEquals(NEW_REQUIRED_QUANTITY, subscription
                .getNewRequiredQuantity());
        assertFalse(subscription.isPlanUpgradeRequired());
        assertEquals("message", subscription
                .getPlanUpgradeRequiredMessage());
        assertEquals(Arrays.asList(subscriptionAddOn1), subscription
                .getSubscriptionAddOns());
        assertEquals("uid", subscription.getUid());
        assertEquals(new Date(TIMESTAMP), subscription.getCreated());
        assertEquals(new Date(TIMESTAMP), subscription.getUpdated());
    }

    /**
     * This method tests the default values set by the builder.
     */
    @Test
    public void testBuilderDefaults() {
        subscription = Subscription.builder()
                .build();

        assertNull(subscription.getBillingRenewalTerm());
        assertNull(subscription.getAccount());
        assertNull(subscription.getPlan());
        assertNull(subscription.getQuantity());
        assertNull(subscription.getStartDate());
        assertNull(subscription.getEndDate());
        assertNull(subscription.getRenewalDate());
        assertNull(subscription.getNewRequiredQuantity());
        assertNull(subscription.isPlanUpgradeRequired());
        assertNull(subscription.getPlanUpgradeRequiredMessage());
        assertNull(subscription.getSubscriptionAddOns());
        assertNull(subscription.getUid());
        assertNull(subscription.getCreated());
        assertNull(subscription.getUpdated());
    }

    /**
     * This method tests the get and set methods of billingRenewalTerm field.
     */
    @Test
    public void testGetSetBillingRenewalTerm() {
        subscription.setBillingRenewalTerm(2);
        assertEquals(2, subscription.getBillingRenewalTerm());
    }

    /**
     * This method tests the get and set methods of account field.
     */
    @Test
    public void testGetSetAccount() {
        subscription.setAccount(account2);
        assertEquals(account2, subscription.getAccount());
    }

    /**
     * This method tests the get and set methods of plan field.
     */
    @Test
    public void testGetSetPlan() {
        subscription.setPlan(plan2);
        assertEquals(plan2, subscription.getPlan());
    }

    /**
     * This method tests the get and set methods of quantity field.
     */
    @Test
    public void testGetSetQuantity() {
        subscription.setQuantity(QUANTITY + 1);
        assertEquals(QUANTITY + 1, subscription.getQuantity());
    }

    /**
     * This method tests the get and set methods of startDate field.
     */
    @Test
    public void testGetSetStartDate() {
        subscription.setStartDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), subscription.getStartDate());
    }

    /**
     * This method tests the get and set methods of endDate field.
     */
    @Test
    public void testGetSetEndDate() {
        subscription.setEndDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), subscription.getEndDate());
    }

    /**
     * This method tests the get and set methods of renewalDate field.
     */
    @Test
    public void testGetSetRenewalDate() {
        subscription.setRenewalDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), subscription.getRenewalDate());
    }

    /**
     * This method tests the get and set methods of newRequiredQuantity field.
     */
    @Test
    public void testGetSetNewRequiredQuantity() {
        subscription.setNewRequiredQuantity(NEW_REQUIRED_QUANTITY + 1);
        assertEquals(NEW_REQUIRED_QUANTITY + 1,
                subscription.getNewRequiredQuantity());
    }

    /**
     * This method tests the get and set methods of planUpgradeRequired field.
     */
    @Test
    public void testGetSetPlanUpgradeRequired() {
        subscription.setPlanUpgradeRequired(true);
        assertTrue(subscription.isPlanUpgradeRequired());
    }

    /**
     * This method tests the get and set methods of
     * planUpgradeRequiredMessage field.
     */
    @Test
    public void testGetSetPlanUpgradeRequiredMessage() {
        subscription.setPlanUpgradeRequiredMessage("message2");
        assertEquals("message2", subscription
                .getPlanUpgradeRequiredMessage());
    }

    /**
     * This method tests the get and set methods of subscriptionAddOns field.
     */
    @Test
    public void testGetSetSubscriptionAddOns() {
        subscription.setSubscriptionAddOns(Arrays.asList(subscriptionAddOn2));
        assertEquals(Arrays.asList(subscriptionAddOn2),
                subscription.getSubscriptionAddOns());
    }

    /**
     * This method tests the get and set methods of uid field.
     */
    @Test
    public void testGetSetUid() {
        subscription.setUid("uid2");
        assertEquals("uid2", subscription.getUid());
    }

    /**
     * This method tests the get and set methods of created field.
     */
    @Test
    public void testGetSetCreated() {
        subscription.setCreated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), subscription.getCreated());
    }

    /**
     * This method tests the get and set methods of updated field.
     */
    @Test
    public void testGetSetUpdated() {
        subscription.setUpdated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), subscription.getUpdated());
    }

    /**
     * This method tests the equals method of the Subscription class.
     */
    @Test
    public void testEquals() {
        Subscription subscription2 = Subscription.builder()
                .billingRenewalTerm(1)
                .billingRenewalTerm(BillingRenewalTerm.Monthly.getValue())
                .account(account1)
                .plan(plan1)
                .quantity(QUANTITY)
                .startDate(new Date(TIMESTAMP))
                .endDate(new Date(TIMESTAMP))
                .renewalDate(new Date(TIMESTAMP))
                .newRequiredQuantity(NEW_REQUIRED_QUANTITY)
                .planUpgradeRequired(false)
                .planUpgradeRequiredMessage("message")
                .subscriptionAddOns(Arrays.asList(subscriptionAddOn1))
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();

        assertEquals(subscription, subscription2);
        assertEquals(subscription, subscription);

        assertNotEquals(subscription, null);
        assertNotEquals(subscription, new Object());
        assertNotEquals(subscription, Subscription.builder().build());
    }

    /**
     * This method tests the hashCode method of the Subscription class.
     */
    @Test
    public void testHashCode() {
        Subscription subscription2 = Subscription.builder()
                .billingRenewalTerm(1)
                .billingRenewalTerm(BillingRenewalTerm.Monthly.getValue())
                .account(account1)
                .plan(plan1)
                .quantity(QUANTITY)
                .startDate(new Date(TIMESTAMP))
                .endDate(new Date(TIMESTAMP))
                .renewalDate(new Date(TIMESTAMP))
                .newRequiredQuantity(NEW_REQUIRED_QUANTITY)
                .planUpgradeRequired(false)
                .planUpgradeRequiredMessage("message")
                .subscriptionAddOns(Arrays.asList(subscriptionAddOn1))
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();

        assertEquals(subscription.hashCode(), subscription2.hashCode());
    }
}
