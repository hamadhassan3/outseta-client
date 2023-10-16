package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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
     * This method is called before each test.
     */
    @BeforeEach
    public void setUp() {
        subscription = new Subscription();
    }

    /**
     * This method tests the constructor of Subscription class.
     */
    @Test
    public void testConstructor() {
    }
}
