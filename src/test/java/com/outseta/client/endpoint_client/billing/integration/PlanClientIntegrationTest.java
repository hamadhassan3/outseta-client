package com.outseta.client.endpoint_client.billing.integration;

import com.outseta.client.endpoint_client.billing.PlanClient;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Plan;
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
 * This class is used to test the PlanClient class.
 * It contains integration tests as it does not mock the API calls.
 */
@ExtendWith(MockitoExtension.class)
@Tag("integration")
public class PlanClientIntegrationTest {

    /**
     * The Outseta API Key.
     */
    private static String outsetaKey = System.getenv("OUTSETA_KEY");

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");

    /**
     * The PlanClient to test.
     */
    private PlanClient planClient;

    /**
     * This method is run before each test.
     * @throws OutsetaClientBuildException if the client cannot be built.
     */
    @BeforeEach
    public void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        planClient = PlanClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();
    }

    /**
     * This method tests the getPlan, getPlanPage method.
     */
    @Test
    public void getPlanTest() {
        final int page = 0;
        final int pageSize = 25;

        List<Plan> allPlans = new ArrayList<>();

        assertDoesNotThrow(() -> {
            PageRequest request = PageRequest.builder()
                    .page(page)
                    .pageSize(pageSize)
                    .build();

            int total = 0;
            ItemPage<Plan> itemPage = null;
            final int maxSize = 100;
            do {
                // Keep making requests as long as there are more pages
                itemPage = planClient.getPlanPage(request);
                total = itemPage.getMetadata().getTotal();

                assertNotNull(itemPage);

                // The current page's items are aggregated
                allPlans.addAll(itemPage.getItems());

                assertEquals(
                        (request.getPageSize() * request.getPageNum())
                                + itemPage.getItems().size(),
                        allPlans.size());

                request = request.nextPageRequest();

            }
            while (allPlans.size() < total
                    && allPlans.size() < maxSize);

            // Testing getPlan
            Plan plan = planClient.getPlan(allPlans.get(0).getUid());
            assertEquals(plan.getUid(), allPlans.get(0).getUid());
        });
    }
}
