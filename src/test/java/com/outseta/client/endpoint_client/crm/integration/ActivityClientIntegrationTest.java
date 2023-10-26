package com.outseta.client.endpoint_client.crm.integration;

import com.outseta.client.endpoint_client.crm.ActivityClient;
import com.outseta.client.endpoint_client.crm.PeopleClient;
import com.outseta.constant.ActivityType;
import com.outseta.constant.EntityType;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.Activity;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Person;
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
 * This class is used to test the ActivityClient class.
 * It is an integration test because it uses the actual API.
 * It is not a unit test because it does not mock the API calls.
 */
@ExtendWith(MockitoExtension.class)
@Tag("integration")
public class ActivityClientIntegrationTest {

    /**
     * The Outseta API Key.
     */
    private static String outsetaKey = System.getenv("OUTSETA_KEY");

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");

    /**
     * The ActivityClient to test.
     */
    private ActivityClient activityClient;

    /**
     * This method is run before each test.
     * @throws OutsetaClientBuildException if the client cannot be built.
     */
    @BeforeEach
    public void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        activityClient = ActivityClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();
    }

    /**
     * This method tests the getActivities method.
     */
    @Test
    public void testGetAllActivities() {

        final int page = 0;
        final int pageSize = 25;

        List<Activity> allActivities = new ArrayList<>();

        assertDoesNotThrow(() -> {
            PageRequest request = PageRequest.builder()
                    .page(page)
                    .pageSize(pageSize)
                    .build();

            int total = 0;
            ItemPage<Activity> itemPage = null;
            final int maxSize = 100;
            do {
                // Keep making requests as long as there are more pages
                itemPage = activityClient.getActivityPage(request);
                total = itemPage.getMetadata().getTotal();

                assertNotNull(itemPage);

                // The current page's items are aggregated
                allActivities.addAll(itemPage.getItems());

                assertEquals(
                        (request.getPageSize() * request.getPageNum())
                                + itemPage.getItems().size(),
                        allActivities.size());

                request = request.nextPageRequest();

            }
            while (allActivities.size() < total
                    && allActivities.size() < maxSize);

        });
    }

    /**
     * This method tests the createCustomActivity method.
     */
    @Test
    public void testCreateCustomActivity() {
            assertDoesNotThrow(() -> {
                PeopleClient peopleClient = PeopleClient.builder(outsetaUrl)
                        .apiKey(outsetaKey)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build();
                Person person = peopleClient.createPerson(Person.builder()
                        .fullName("Hammad Hassan sdk test")
                        .email("hammadCreateWithActivity@dummy.com")
                        .build());

                Activity activity = Activity.builder()
                        .activityType(ActivityType.CUSTOM)
                        .entityType(EntityType.PERSON)
                        .entityUid(person.getUid())
                        .description("Hammad outseta-java-sdk test")
                        .title("Hammad outseta-java-sdk test")
                        .build();

                Activity createdActivity = activityClient
                        .createCustomActivity(activity);

                peopleClient.deletePerson(person.getUid());

                assertNotNull(createdActivity);
                assertNotNull(createdActivity.getUid());
                assertEquals(activity.getDescription(),
                        createdActivity.getDescription());
                assertEquals(activity.getTitle(),
                        createdActivity.getTitle());
                assertEquals(activity.getActivityType(),
                        createdActivity.getActivityType());
                assertEquals(activity.getEntityType(),
                        createdActivity.getEntityType());
            });
    }
}
