package com.outseta.model.result;

import com.outseta.constant.BillingRenewalTerm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class is used to test the SubscriptionAddOn class.
 */
@ExtendWith(MockitoExtension.class)
public class SubscriptionAddOnTest {

    /**
     * The SubscriptionAddOn object to be used for testing.
     */
    private SubscriptionAddOn subscriptionAddOn;

    /**
     * The mocked Subscription object to be used for testing.
     */
    @Mock
    private Subscription subscription;

    /**
     * The mocked AddOn object to be used for testing.
     */
    @Mock
    private AddOn addOn;

    /**
     * A random timestamp to be used for creating date objects.
     */
    private static final long TIMESTAMP = 1234567890;

    /**
     * The quantity of the SubscriptionAddOn object to be used for testing.
     */
    private static final int QUANTITY = 2;

    /**
     * The new required quantity of the SubscriptionAddOn object to be used
     * for testing.
     */
    private static final int NEW_REQUIRED_QUANTITY = 3;

    /**
     * This method is run before each test to create a new SubscriptionAddOn
     * object.
     */
    @BeforeEach
    public void setup() {
        subscriptionAddOn = SubscriptionAddOn.builder()
                .billingRenewalTerm(1)
                .billingRenewalTerm(BillingRenewalTerm.Monthly)
                .subscription(subscription)
                .addOn(addOn)
                .quantity(QUANTITY)
                .startDate(new Date(TIMESTAMP))
                .endDate(new Date(TIMESTAMP))
                .renewalDate(new Date(TIMESTAMP))
                .newRequiredQuantity(NEW_REQUIRED_QUANTITY)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
    }

    /**
     * This method tests the builder values of the SubscriptionAddOn object.
     */
    @Test
    public void testBuilderValues() {
        assertEquals(1, subscriptionAddOn.getBillingRenewalTerm());
        assertEquals(BillingRenewalTerm.Monthly.getValue(),
                subscriptionAddOn.getBillingRenewalTerm());
        assertEquals(subscription, subscriptionAddOn.getSubscription());
        assertEquals(addOn, subscriptionAddOn.getAddOn());
        assertEquals(QUANTITY, subscriptionAddOn.getQuantity());
        assertEquals(new Date(TIMESTAMP), subscriptionAddOn.getStartDate());
        assertEquals(new Date(TIMESTAMP), subscriptionAddOn.getEndDate());
        assertEquals(new Date(TIMESTAMP), subscriptionAddOn.getRenewalDate());
        assertEquals(NEW_REQUIRED_QUANTITY,
                subscriptionAddOn.getNewRequiredQuantity());
        assertEquals("uid", subscriptionAddOn.getUid());
        assertEquals(new Date(TIMESTAMP), subscriptionAddOn.getCreated());
        assertEquals(new Date(TIMESTAMP), subscriptionAddOn.getUpdated());
    }

    /**
     * This method tests the default values set by the builder.
     */
    @Test
    public void testBuilderDefaultValues() {
        subscriptionAddOn = SubscriptionAddOn.builder()
                .subscription(subscription)
                .addOn(addOn)
                .build();

        assertNull(subscriptionAddOn.getBillingRenewalTerm());
        assertNull(subscriptionAddOn.getStartDate());
        assertNull(subscriptionAddOn.getEndDate());
        assertNull(subscriptionAddOn.getRenewalDate());
        assertNull(subscriptionAddOn.getNewRequiredQuantity());
        assertNull(subscriptionAddOn.getUid());
        assertNull(subscriptionAddOn.getCreated());
        assertNull(subscriptionAddOn.getUpdated());
    }

    /**
     * This method tests the get and set methods of the billing renewal term.
     */
    @Test
    public void testGetSetBillingRenewalTerm() {
        assertEquals(BillingRenewalTerm.Monthly.getValue(),
                subscriptionAddOn.getBillingRenewalTerm());

        subscriptionAddOn.setBillingRenewalTerm(
                BillingRenewalTerm.Yearly.getValue());
        assertEquals(BillingRenewalTerm.Yearly.getValue(),
                subscriptionAddOn.getBillingRenewalTerm());
        assertEquals(BillingRenewalTerm.Yearly.getValue(),
                subscriptionAddOn.getBillingRenewalTerm());
    }

    /**
     * This method tests the get and set methods of the subscription.
     */
    @Test
    public void testGetSetSubscription() {
        assertEquals(subscription, subscriptionAddOn.getSubscription());

        subscriptionAddOn.setSubscription(null);
        assertNull(subscriptionAddOn.getSubscription());
    }

    /**
     * This method tests the get and set methods of the add-on.
     */
    @Test
    public void testGetSetAddOn() {
        assertEquals(addOn, subscriptionAddOn.getAddOn());

        subscriptionAddOn.setAddOn(null);
        assertNull(subscriptionAddOn.getAddOn());
    }

    /**
     * This method tests the get and set methods of the quantity.
     */
    @Test
    public void testGetSetQuantity() {
        assertEquals(QUANTITY, subscriptionAddOn.getQuantity());

        subscriptionAddOn.setQuantity(0);
        assertEquals(0, subscriptionAddOn.getQuantity());
    }

    /**
     * This method tests the get and set methods of the start date.
     */
    @Test
    public void testGetSetStartDate() {
        assertEquals(new Date(TIMESTAMP), subscriptionAddOn.getStartDate());

        subscriptionAddOn.setStartDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), subscriptionAddOn.getStartDate());
    }

    /**
     * This method tests the get and set methods of the end date.
     */
    @Test
    public void testGetSetEndDate() {
        assertEquals(new Date(TIMESTAMP), subscriptionAddOn.getEndDate());

        subscriptionAddOn.setEndDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), subscriptionAddOn.getEndDate());
    }

    /**
     * This method tests the get and set methods of the renewal date.
     */
    @Test
    public void testGetSetRenewalDate() {
        assertEquals(new Date(TIMESTAMP), subscriptionAddOn.getRenewalDate());

        subscriptionAddOn.setRenewalDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1),
                subscriptionAddOn.getRenewalDate());
    }

    /**
     * This method tests the get and set methods of the new required quantity.
     */
    @Test
    public void testGetSetNewRequiredQuantity() {
        assertEquals(NEW_REQUIRED_QUANTITY,
                subscriptionAddOn.getNewRequiredQuantity());

        subscriptionAddOn.setNewRequiredQuantity(0);
        assertEquals(0, subscriptionAddOn.getNewRequiredQuantity());
    }

    /**
     * This method tests the get and set methods of the uid.
     */
    @Test
    public void testGetSetUid() {
        assertEquals("uid", subscriptionAddOn.getUid());

        subscriptionAddOn.setUid(null);
        assertNull(subscriptionAddOn.getUid());
    }

    /**
     * This method tests the get and set methods of the created date.
     */
    @Test
    public void testGetSetCreated() {
        assertEquals(new Date(TIMESTAMP), subscriptionAddOn.getCreated());

        subscriptionAddOn.setCreated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), subscriptionAddOn.getCreated());
    }

    /**
     * This method tests the get and set methods of the updated date.
     */
    @Test
    public void testGetSetUpdated() {
        assertEquals(new Date(TIMESTAMP), subscriptionAddOn.getUpdated());

        subscriptionAddOn.setUpdated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), subscriptionAddOn.getUpdated());
    }

    /**
     * This method tests the equals method of the SubscriptionAddOn object.
     */
    @Test
    public void testEquals() {
        SubscriptionAddOn subscriptionAddOn2 = SubscriptionAddOn.builder()
                .billingRenewalTerm(1)
                .billingRenewalTerm(BillingRenewalTerm.Monthly)
                .subscription(subscription)
                .addOn(addOn)
                .quantity(QUANTITY)
                .startDate(new Date(TIMESTAMP))
                .endDate(new Date(TIMESTAMP))
                .renewalDate(new Date(TIMESTAMP))
                .newRequiredQuantity(NEW_REQUIRED_QUANTITY)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();

        assertEquals(subscriptionAddOn, subscriptionAddOn2);
        assertEquals(subscriptionAddOn, subscriptionAddOn);

        assertNotEquals(subscriptionAddOn, null);
        assertNotEquals(subscriptionAddOn, new Object());

        subscriptionAddOn2.setUid("uid2");
        assertNotEquals(subscriptionAddOn, subscriptionAddOn2);
    }

    /**
     * This method tests the hash code method of the SubscriptionAddOn object.
     */
    @Test
    public void testHashCode() {
        SubscriptionAddOn subscriptionAddOn2 = SubscriptionAddOn.builder()
                .billingRenewalTerm(1)
                .billingRenewalTerm(BillingRenewalTerm.Monthly)
                .subscription(subscription)
                .addOn(addOn)
                .quantity(QUANTITY)
                .startDate(new Date(TIMESTAMP))
                .endDate(new Date(TIMESTAMP))
                .renewalDate(new Date(TIMESTAMP))
                .newRequiredQuantity(NEW_REQUIRED_QUANTITY)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();

        assertEquals(subscriptionAddOn2.hashCode(),
                subscriptionAddOn.hashCode());
    }
}
