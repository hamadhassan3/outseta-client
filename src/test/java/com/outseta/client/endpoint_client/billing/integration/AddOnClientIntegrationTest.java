package com.outseta.client.endpoint_client.billing.integration;

import com.outseta.client.endpoint_client.billing.AddOnClient;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.AddOnUsageRequest;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.AddOn;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.SubscriptionAddOn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class is used to test the AddOnClient class.
 * It contains integration tests as it does not mock the API calls.
 */
@ExtendWith(MockitoExtension.class)
@Tag("integration")
public class AddOnClientIntegrationTest {

    /**
     * The Outseta API Key.
     */
    private static String outsetaKey = System.getenv("OUTSETA_KEY");

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");

    /**
     * The AddOnClient to test.
     */
    private AddOnClient addOnClient;

    /**
     * This method is run before each test.
     * @throws OutsetaClientBuildException if the client cannot be built.
     */
    @BeforeEach
    public void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        addOnClient = AddOnClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();
    }

    /**
     * This method tests the getAddOnPage, getAddOn method.
     */
    @Test
    public void getAddOnTest() {
        final int page = 0;
        final int pageSize = 25;

        List<AddOn> allAddOns = new ArrayList<>();

        assertDoesNotThrow(() -> {
            PageRequest request = PageRequest.builder()
                    .page(page)
                    .pageSize(pageSize)
                    .build();

            int total = 0;
            ItemPage<AddOn> itemPage = null;
            final int maxSize = 100;
            do {
                // Keep making requests as long as there are more pages
                itemPage = addOnClient.getAddOnPage(request);
                total = itemPage.getMetadata().getTotal();

                assertNotNull(itemPage);

                // The current page's items are aggregated
                allAddOns.addAll(itemPage.getItems());

                assertEquals(
                        (request.getPageSize() * request.getPageNum())
                                + itemPage.getItems().size(),
                        allAddOns.size());

                request = request.nextPageRequest();

            }
            while (allAddOns.size() < total
                    && allAddOns.size() < maxSize);

            // Testing getAddOn
            AddOn addOn = addOnClient.getAddOn(allAddOns.get(0).getUid());
            assertEquals(addOn.getUid(), allAddOns.get(0).getUid());
        });
    }

    /**
     * This method tests the addUsageForAddOn method.
     */
    @Test
    public void testAddUsageForAddOn() {

        assertDoesNotThrow(() -> {
            // Testing addUsageForAddOn
            AddOnUsageRequest addOnUsageRequest = AddOnUsageRequest.builder()
                    .subscriptionAddOn(SubscriptionAddOn.builder()
                            .uid("z9M0RGQ4").build())
                    .amount(1)
                    .usageDate(new Date())
                    .build();
            addOnClient.addUsageForAddOn(addOnUsageRequest);
        });
    }
}
