package com.outseta.client.endpoint_client.billing.integration;

import com.outseta.client.endpoint_client.billing.DiscountClient;
import com.outseta.constant.DiscountDuration;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.result.Discount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class is used to test the DiscountClient class.
 * It contains integration tests as it does not mock the API calls.
 */
@ExtendWith(MockitoExtension.class)
@Tag("integration")
public class DiscountClientIntegrationTest {

    /**
     * The Outseta API Key.
     */
    private static String outsetaKey = System.getenv("OUTSETA_KEY");

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");

    /**
     * The DiscountClient to test.
     */
    private DiscountClient discountClient;

    /**
     * This method is run before each test.
     * @throws OutsetaClientBuildException if the client cannot be built.
     */
    @BeforeEach
    public void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        discountClient = DiscountClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();
    }

    /**
     * This method tests the createDiscount method.
     */
    @Test
    public void testAddUsageForAddOn() {

        final double off = 100.1;
        assertDoesNotThrow(() -> {
            // Testing addUsageForAddOn
            Discount discount = Discount.builder()
                    .uniqueIdentifier("test")
                    .active(false)
                    .maxRedemptions(1)
                    .durationInMonths(1)
                    .duration(DiscountDuration.FOREVER)
                    .amountOff(off)
                    .name("Hammad Test Discount")
                    .build();
            Discount result = discountClient.createDiscount(discount);

            assertNotNull(result);
            assertNotNull(result.getUniqueIdentifier());
            assertEquals(discount.getName(), result.getName());
            assertFalse(result.isActive());
            assertEquals(discount.getMaxRedemptions(),
                    result.getMaxRedemptions());
            assertEquals(discount.getDurationInMonths(),
                    result.getDurationInMonths());
            assertEquals(discount.getUniqueIdentifier(),
                    result.getUniqueIdentifier());
        });

    }
}
