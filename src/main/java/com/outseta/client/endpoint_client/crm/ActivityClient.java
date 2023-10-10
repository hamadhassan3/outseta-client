package com.outseta.client.endpoint_client.crm;

import com.outseta.client.BaseClient;
import com.outseta.client.ClientBuilder;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.OutsetaParseException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.model.request.ActivityPageRequest;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.Activity;
import com.outseta.model.result.ItemPage;

import java.util.HashMap;
import java.util.Map;

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
     * The builder class is used to make it easier to construct the client.
     */
    public static class Builder extends ClientBuilder {

        /**
         * The constructor creates a new builder with the base url.
         * @param baseUrl The base url for the client to use.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *      built.
         */
        public Builder(final String baseUrl)
                throws OutsetaClientBuildException {
            super(new ActivityClient(baseUrl));
        }

        /**
         * Sets the base url for the client.
         * @param baseUrl The base url to set.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *      built.
         */
        @Override
        public Builder baseUrl(final String baseUrl)
                throws OutsetaClientBuildException {
            super.baseUrl(baseUrl);
            return this;
        }

        /**
         * Sets the api key for the client.
         * @param apiKey The api key to set.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *      built.
         */
        @Override
        public Builder apiKey(final String apiKey)
                throws OutsetaClientBuildException {
            super.apiKey(apiKey);
            return this;
        }

        /**
         * Sets the access key for the client.
         * @param accessKey The access key to set.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *      built.
         */
        @Override
        public Builder accessKey(final String accessKey)
                throws OutsetaClientBuildException {
            super.accessKey(accessKey);
            return this;
        }

        /**
         * Sets the headers for the client.
         * @param headers The headers to set.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *      built.
         */
        @Override
        public Builder headers(final Map<String, String> headers)
                throws OutsetaClientBuildException {
            super.headers(headers);
            return this;
        }

        /**
         * Sets the request maker for the client.
         * @param requestMakerType The request maker to set.
         * @return The builder so that calls can be chained.
         * @throws OutsetaInvalidRequestMakerException Thrown if the request
         *      maker is invalid.
         */
        @Override
        public Builder requestMaker(
                final RequestMakerType requestMakerType)
                throws OutsetaInvalidRequestMakerException {
            super.requestMaker(requestMakerType);
            return this;
        }

        /**
         * Sets the request maker for the client.
         * @param requestMaker The request maker to set.
         * @return The builder so that calls can be chained.
         * @throws OutsetaInvalidRequestMakerException Thrown if the request
         *      maker is invalid.
         */
        @Override
        public Builder requestMaker(final RequestMaker requestMaker)
                throws OutsetaInvalidRequestMakerException {
            super.requestMaker(requestMaker);
            return this;
        }

        /**
         * Sets the request maker for the client.
         * @return The builder so that calls can be chained.
         * @throws OutsetaInvalidRequestMakerException Thrown if the request
         *      maker is invalid.
         */
        @Override
        public Builder defaultRequestMaker()
                throws OutsetaInvalidRequestMakerException {
            super.defaultRequestMaker();
            return this;
        }

        /**
         * Sets the request maker for the client.
         * @param requestMakerType The request maker to set.
         * @return The builder so that calls can be chained.
         * @throws OutsetaInvalidRequestMakerException Thrown if the request
         *      maker is invalid.
         */
        @Override
        public Builder requestMaker(final String requestMakerType)
                throws OutsetaInvalidRequestMakerException {
            super.requestMaker(requestMakerType);
            return this;
        }

        /**
         * Sets the parser for the client.
         * @param parserFacade The parser to set.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *      built.
         */
        @Override
        public Builder parser(final ParserFacade parserFacade)
                throws OutsetaClientBuildException {
            super.parser(parserFacade);
            return this;
        }

        /**
         * Sets the default parser for the client.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *      built.
         */
        @Override
        public Builder defaultParser()
                throws OutsetaClientBuildException {
            super.defaultParser();
            return this;
        }

        /**
         * Builds the client.
         * @return The built client.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *      built.
         */
        @Override
        public ActivityClient build() throws OutsetaClientBuildException {
            return (ActivityClient) super.build();
        }
    }

    /**
     * This method is used to get a builder that can be used to build an
     * ActivityClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build a ActivityClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static Builder builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new ActivityClient.Builder(baseUrl);
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
