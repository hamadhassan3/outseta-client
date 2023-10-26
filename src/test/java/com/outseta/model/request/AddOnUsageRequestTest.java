package com.outseta.model.request;

import com.outseta.model.result.SubscriptionAddOn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class is used to test the AddOnUsageRequest class.
 */
@ExtendWith(MockitoExtension.class)
public class AddOnUsageRequestTest {

    /**
     * The object to be tested.
     */
    private AddOnUsageRequest addOnUsageRequest;

    /**
     * Mocked add-on for testing.
     */
    @Mock
    private SubscriptionAddOn addOn1;

    /**
     * Mocked add-on for testing.
     */
    @Mock
    private SubscriptionAddOn addOn2;

    /**
     * A random timestamp used for creating date objects.
     */
    private static final long TIMESTAMP = 1612137600;

    /**
     * Sets up before each test.
     */
    @BeforeEach
    public void setup() {
        addOnUsageRequest = AddOnUsageRequest.builder()
                .amount(1)
                .usageDate(new Date(TIMESTAMP))
                .subscriptionAddOn(addOn1)
                .build();
    }

    /**
     * This method tests the AddOnUsageRequest builder.
     */
    @Test
    public void testAddOnUsageRequestBuilder() {
        assertEquals(1, addOnUsageRequest.getAmount());
        assertEquals(new Date(TIMESTAMP), addOnUsageRequest.getUsageDate());
        assertEquals(addOn1, addOnUsageRequest.getSubscriptionAddOn());
    }

    /**
     * This method tests the AddOnUsageRequest builder's with defaults.
     */
    @Test
    public void testAddOnUsageRequestBuilderWithDefaults() {
        AddOnUsageRequest test = AddOnUsageRequest.builder()
                .build();

        assertNull(test.getAmount());
        assertNull(test.getSubscriptionAddOn());
        assertNull(test.getUsageDate());
    }

    /**
     * This method tests the setter and getter for the amount.
     */
    @Test
    public void testSetAndGetAmount() {
        addOnUsageRequest.setAmount(2);
        assertEquals(2, addOnUsageRequest.getAmount());
    }

    /**
     * This method tests the setter and getter for the usage date.
     */
    @Test
    public void testSetAndGetUsageDate() {
        addOnUsageRequest.setUsageDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), addOnUsageRequest.getUsageDate());
    }

    /**
     * This method tests the setter and getter for the add-on.
     */
    @Test
    public void testSetAndGetSubscriptionAddOn() {
        addOnUsageRequest.setSubscriptionAddOn(addOn2);
        assertEquals(addOn2, addOnUsageRequest.getSubscriptionAddOn());
    }
}
