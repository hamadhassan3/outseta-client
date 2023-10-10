package com.outseta.client.endpoint_client.crm;

import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.Deal;
import com.outseta.model.result.DealPipelineStage;
import com.outseta.model.result.ItemPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class is used to test the DealClient class.
 * It contains integration tests and does not need to use Mocks.
 */
@ExtendWith(MockitoExtension.class)
public class DealClientIntegrationTest {

    /**
     * The Outseta API Key.
     */
    private static String outsetaKey = System.getenv("OUTSETA_KEY");

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");

    /**
     * The DealClient object to use for testing.
     */
    private DealClient dealClient;

    /**
     * This method is used to set up the tests.
     */
    @BeforeEach
    public void setup() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        dealClient = DealClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();
    }

    /**
     * This method is used to test the getDeals method.
     */
    @Test
    public void testGetAllDeals() {

        final int page = 0;
        final int pageSize = 25;

        List<Deal> allDeals = new ArrayList<>();

        assertDoesNotThrow(() -> {
            PageRequest request = PageRequest.builder()
                    .page(page)
                    .pageSize(pageSize)
                    .build();

            int total = 0;
            ItemPage<Deal> itemPage = null;
            final int maxSize = 100;
            do {
                // Keep making requests as long as there are more pages
                itemPage = dealClient.getDealPage(request);
                total = itemPage.getMetadata().getTotal();

                assertNotNull(itemPage);

                // The current page's items are aggregated
                allDeals.addAll(itemPage.getItems());

                assertEquals(
                        (request.getPageSize() * request.getPageNum())
                                + itemPage.getItems().size(),
                        allDeals.size());

                request = request.nextPageRequest();

            }
            while (allDeals.size() < total
                    && allDeals.size() < maxSize);

        });
    }

    /**
     * This method is used to test the crud methods.
     */
    @Test
    public void testCrudDeal() {

        assertDoesNotThrow(() -> {
            Deal createdDeal = dealClient.createDeal(Deal.builder()
                    .name("Hammad Test")
                    .dealPipelineStage(new DealPipelineStage("vW5x1O94"))
                    .build());

            assertNotNull(createdDeal);
            assertEquals("Hammad Test", createdDeal.getName());

            createdDeal.setName("Hammad Test Updated");
            Deal updatedDeal = dealClient.updateDeal(createdDeal.getUid(),
                    createdDeal);

            assertNotNull(updatedDeal);
            assertEquals("Hammad Test Updated", updatedDeal.getName());

            Deal getDeal = dealClient.getDeal(updatedDeal.getUid());

            assertNotNull(getDeal);
            assertEquals("Hammad Test Updated", getDeal.getName());

            // Clean up
            dealClient.deleteDeal(getDeal.getUid());
        });
    }
}
