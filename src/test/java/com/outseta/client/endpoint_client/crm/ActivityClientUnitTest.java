package com.outseta.client.endpoint_client.crm;

import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.ActivityPageRequest;
import com.outseta.model.result.Activity;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Metadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class tests the ActivityClient class.
 */
@ExtendWith(MockitoExtension.class)
public class ActivityClientUnitTest {

    /**
     * The Outseta URL used for testing.
     */
    private static final String OUTSETA_URL = "https://dummy.com";

    /**
     * The Outseta Key used for testing.
     */
    private static final String OUTSETA_KEY = "dummyKey";

    /**
     * The ParserFacade object used for testing.
     */
    @Mock
    private ParserFacade parserFacade;

    /**
     * The JsonParser object used for testing.
     */
    @Mock
    private JsonParser jsonParser;

    /**
     * The RequestMaker object used for testing.
     */
    @Mock
    private RequestMaker requestMaker;

    /**
     * The ActivityClient object used for testing.
     */
    private ActivityClient activityClient;

    /**
     * The Activity object used for testing.
     */
    private Activity activity;

    /**
     * The Activity object string used for testing.
     */
    private String activityStr;

    /**
     * This method is called before each test.
     */
    @BeforeEach
    public void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {

        when(parserFacade.getJsonParser()).thenReturn(jsonParser);

        activityClient = ActivityClient.builder(OUTSETA_URL)
                .apiKey(OUTSETA_KEY)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .build();

        activity = new Activity();
        activity.setTitle("dummy");

        activityStr = "{\"Title\":\"dummy\"}";
    }

    /**
     * This method tests the ActivityClient's builder.
     */
    @Test
    public void testBuilder() {

        assertDoesNotThrow(() -> {
            ActivityClient.Builder test = ActivityClient.builder(OUTSETA_URL);
            assertEquals(test, test.apiKey(OUTSETA_KEY));
            assertEquals(test, test.defaultParser());
            assertEquals(test, test.defaultRequestMaker());

            ActivityClient activityClient1 = test.build();

            assertNotNull(activityClient1);
        });

        assertDoesNotThrow(() -> {

            when(parserFacade.getJsonParser()).thenReturn(jsonParser);

            ActivityClient.Builder test = ActivityClient.builder(OUTSETA_URL);

            assertEquals(test, test.apiKey(OUTSETA_KEY));
            assertEquals(test, test.accessKey(OUTSETA_KEY));
            assertEquals(test, test.parser(parserFacade));
            assertEquals(test, test.baseUrl(OUTSETA_URL));
            assertEquals(test, test.requestMaker("DEFAULT"));
            assertEquals(test, test.headers(
                    Map.of("Authorization", "dummy")));
            assertEquals(test, test.requestMaker(RequestMakerType.DEFAULT));

            ActivityClient activityClient1 = test.build();

            assertNotNull(activityClient1);
        });
    }

    /**
     * This method tests the failure scenario of the builder method
     * of the ActivityClient class.
     */
    @Test
    public void testBuilderFailure() {

        // Testing empty object
        assertThrows(OutsetaClientBuildException.class, () ->
                ActivityClient.builder(null)
        );
        assertThrows(OutsetaClientBuildException.class, () ->
                ActivityClient.builder("")
        );

        // Testing null outsetaUrl but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                ActivityClient.builder(null)
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing empty outsetaUrl but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                ActivityClient.builder("")
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing null Outseta Key but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                ActivityClient.builder(OUTSETA_URL)
                        .apiKey(null)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing empty Outseta Key but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                ActivityClient.builder(OUTSETA_URL)
                        .apiKey("")
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing without parser but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                ActivityClient.builder(OUTSETA_URL)
                        .apiKey(OUTSETA_KEY)
                        .defaultRequestMaker()
                        .build()
        );

        // Testing without request maker but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                ActivityClient.builder(OUTSETA_URL)
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .build()
        );
    }

    /**
     * This method tests the ActivityClient's getActivityPage method.
     */
    @Test
    public void testGetActivityPage() {

        assertDoesNotThrow(() -> {

            Map<String, Object> params = new HashMap<>();

            params.put("offset", "0");
            params.put("limit", "1");

            ItemPage<Activity> itemPage = new ItemPage<>(
                    new Metadata(1, 0, 1),
                    List.of(activity)
            );

            when(requestMaker.get(OUTSETA_URL + "/activities",
                    params, activityClient.getHeaders()))
                    .thenReturn("result");

            // Mocking parser facade's jsonStringToPage method to return
            // an ItemPage of Activity.
            when(parserFacade
                    .jsonStringToPage("result", Activity.class))
                    .thenReturn(itemPage);

            // Making the request.
            ItemPage<Activity> result1 = activityClient
                    .getActivityPage(ActivityPageRequest
                        .builder()
                        .page(0)
                        .pageSize(1)
                        .build()
            );

            params.remove("offset");

            when(requestMaker.get(OUTSETA_URL + "/activities",
                    params, activityClient.getHeaders()))
                    .thenReturn("result");

            ItemPage<Activity> result2 = activityClient
                    .getActivityPage(ActivityPageRequest
                        .builder()
                        .pageSize(1)
                        .build()
            );

            params.put("offset", "0");
            params.remove("limit");

            when(requestMaker.get(OUTSETA_URL + "/activities",
                    params, activityClient.getHeaders()))
                    .thenReturn("result");

            ItemPage<Activity> result3 = activityClient
                    .getActivityPage(ActivityPageRequest
                        .builder()
                        .page(0)
                        .build()
            );

            params.remove("offset");

            when(requestMaker.get(OUTSETA_URL + "/activities",
                    params, activityClient.getHeaders()))
                    .thenReturn("result");

            ItemPage<Activity> result4 = activityClient
                    .getActivityPage(ActivityPageRequest
                        .builder()
                        .build()
            );

            // Comparing against expected results
            assertNotNull(result1);
            assertEquals(result1, itemPage);

            assertNotNull(result2);
            assertEquals(result2, itemPage);

            assertNotNull(result3);
            assertEquals(result2, itemPage);

            assertNotNull(result4);
            assertEquals(result2, itemPage);

        });
    }

    /**
     * This method tests the ActivityClient's getActivityPage method
     * with a null ActivityPageRequest.
     */
    @Test
    public void testGetActivityPageNullRequest() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            activityClient.getActivityPage(null);
        });
    }

    /**
     * This method tests the createActivity method of the ActivityClient.
     */
    @Test
    public void testCreateActivity() {

        assertDoesNotThrow(() -> {

            when(requestMaker.post(
                    OUTSETA_URL + "/activities/customactivity",
                    new HashMap<>(),
                    activityStr,
                    activityClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(activity))
                    .thenReturn(activityStr);

            when(parserFacade.jsonStringToObject("result", Activity.class))
                    .thenReturn(activity);

            Activity result = activityClient.createCustomActivity(activity);

            assertNotNull(result);
            assertEquals(result, activity);
        });
    }

    /**
     * This method tests the createActivity method of the ActivityClient
     * with a null Activity.
     */
    @Test
    public void testCreateActivityNullActivity() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            activityClient.createCustomActivity(null);
        });
    }
}
