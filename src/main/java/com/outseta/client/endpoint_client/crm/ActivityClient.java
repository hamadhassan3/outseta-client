package com.outseta.client.endpoint_client.crm;

import com.outseta.client.BaseClient;
import com.outseta.client.ClientBuilder;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.OutsetaParseException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.Activity;
import com.outseta.model.result.ItemPage;

import java.util.HashMap;

/**
 * This class is used to make calls to the Activity endpoints of the
 * Outseta API.
 * <p>
 *     The Activity endpoints are used to manage activities. The class
 *     provides a builder to make it easier to construct the client.
 * </p>
 */
public final class ActivityClient extends BaseClient {

    /**
     * This method is used to get a builder that can be used to build an
     * ActivityClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build a ActivityClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static ClientBuilder<ActivityClient> builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new ClientBuilder<>(new ActivityClient(baseUrl));
    }

    /**
     * The constructor creates a new Activity client with the base url.
     * It is intentionally private to force the use of the builder.
     *
     * @param pBaseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    private ActivityClient(final String pBaseUrl)
            throws OutsetaClientBuildException {
        super(pBaseUrl);
    }

    /**
     * This method is used to get a page of Activity objects.
     *
     * @param activityPageRequest The page request to use.
     * @return The list of activities.
     * @throws OutsetaInvalidResponseCodeException Thrown if the response code
     *                                             is invalid.
     * @throws OutsetaAPIBadRequestException       Thrown if the request is bad.
     * @throws OutsetaAPIFailedException           Thrown if the request fails.
     * @throws OutsetaAPIUnknownException          Thrown if the request fails
     *                                             for an unknown reason.
     * @throws OutsetaInvalidURLException          Thrown if the url is invalid.
     * @throws OutsetaParseException               Thrown if the people cannot
     *                                             be parsed.
     * @throws OutsetaInvalidArgumentException    Thrown if the page request
     *                                            is null.
     *
     * Example usage:
     * <pre>{@code
     * ActivityClient client = ActivityClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * ActivityRequest request = ActivityRequest.builder()
     *      .page(page)
     *      .pageSize(pageSize)
     *      .build();
     * int total = 0;
     * ItemPage<Activity> activityPage = null;
     *
     * do {
     *      // Keep making requests as long as there are more pages
     *      activityPage = activityClient.getActivityPage(request);
     *      total = activityPage.getMetadata().getTotal();
     *
     *      // The current page's items are aggregated
     *      allActivities.addAll(activityPage.getItems());
     *      request = request.nextPageRequest();
     * }
     * while (allActivities.size() < total);
     * }</pre>
     */
    public ItemPage<Activity> getActivityPage(
                final PageRequest activityPageRequest)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException, OutsetaInvalidArgumentException {

        if (activityPageRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Page request cannot be null.");
        }

        String result = this.get("/activities",
                activityPageRequest.buildParams());

        return this.getParserFacade()
                .jsonStringToPage(result,
                        Activity.class);
    }

    /**
     * This method is used to create a person.
     *
     * @param activityRequest The person to create.
     * @return The created person.
     * @throws OutsetaInvalidArgumentException Thrown if the person request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the person cannot be
     *                                          parsed.
     * @throws OutsetaInvalidResponseCodeException Thrown if the response code
     *                                          is invalid.
     * @throws OutsetaAPIBadRequestException    Thrown if the request is bad.
     * @throws OutsetaAPIFailedException        Thrown if the request fails.
     * @throws OutsetaAPIUnknownException       Thrown if the request fails for
     *                                          an unknown reason.
     * @throws OutsetaInvalidURLException       Thrown if the url is invalid.
     *
     * Example usage:
     * <pre>{@code
     * ActivityClient client = ActivityClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Activity activityRequest = new Activity();
     * Activity activity = client.createCustomActivity(activityRequest);
     * }</pre>
     */
    public Activity createCustomActivity(final Activity activityRequest)
            throws OutsetaInvalidArgumentException, OutsetaParseException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException {

        if (activityRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Activity Request cannot be null.");
        }

        String result = this.post("/activities/customactivity",
                new HashMap<>(),
                this.getParserFacade().objectToJsonString(activityRequest));

        return this.getParserFacade().jsonStringToObject(result,
                Activity.class);
    }
}
