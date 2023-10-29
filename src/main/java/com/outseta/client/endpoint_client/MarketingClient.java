package com.outseta.client.endpoint_client;

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
import com.outseta.model.result.EmailList;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.MarketingSubscription;

import java.util.HashMap;

/**
 * This class is used to make calls to the Marketing endpoints of the
 * Outseta API.
 * <p>
 *     The Marketing endpoints are used to manage email subscriptions.
 *     The class provides a builder to make it easier to construct
 *     the client.
 * </p>
 */
public final class MarketingClient extends BaseClient {

    /**
     * This method is used to get a builder that can be used to build a
     * MarketingClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build an MarketingClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static ClientBuilder<MarketingClient> builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new ClientBuilder<>(new MarketingClient(baseUrl));
    }

    /**
     * The constructor creates a new Marketing client with the base url.
     * It is intentionally private to force the use of the builder.
     *
     * @param pBaseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    private MarketingClient(final String pBaseUrl)
            throws OutsetaClientBuildException {
        super(pBaseUrl);
    }

    /**
     * Gets an email list by id.
     *
     * @param emailListId The id of the email list.
     * @return The email list.
     * @throws OutsetaInvalidArgumentException Thrown if the
     *                                              id is null.
     * @throws OutsetaParseException            Thrown if the email list
     *                                              cannot be parsed.
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
     * MarketingClient client = MarketingClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String emailListId = "emailListId";
     * EmailList emailList = client.getEmailList(emailListId);
     * }</pre>
     */
    public EmailList getEmailList(
            final String emailListId)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (emailListId == null
                || emailListId.isBlank()) {
            throw new OutsetaInvalidArgumentException(
                    "Email list id cannot be null or blank.");
        }

        String result = this.get("/email/lists/" + emailListId,
                new HashMap<>());

        return this.getParserFacade().jsonStringToObject(result,
                EmailList.class);
    }

    /**
     * This method is used to get a page of Email List objects.
     *
     * @param pageRequest The page request to use.
     * @return The list of email list objects.
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
     * MarketingClient client = MarketingClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * PageRequest request = PageRequest.builder()
     *      .page(page)
     *      .pageSize(pageSize)
     *      .build();
     * int total = 0;
     * ItemPage<EmailList> emailListPage = null;
     *
     * do {
     *      // Keep making requests as long as there are more pages
     *      emailListPage = client.getEmailListPage(request);
     *      total = emailListPage.getMetadata().getTotal();
     *
     *      // The current page's items are aggregated
     *      allEmailLists.addAll(emailListPage.getItems());
     *      request = request.nextPageRequest();
     * }
     * while (allEmailLists.size() < total);
     * }</pre>
     */
    public ItemPage<EmailList> getEmailListPage(final PageRequest pageRequest)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException, OutsetaInvalidArgumentException {

        if (pageRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Page request cannot be null.");
        }

        String result = this.get("/email/lists",
                pageRequest.buildParams());

        return this.getParserFacade()
                .jsonStringToPage(result,
                        EmailList.class);
    }

    /**
     * Retrieves all the people subscribing to an email list.
     *
     * @param emailListId The id of the email list.
     * @param pageRequest The page request to use.
     * @return The list of email list objects.
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
     * MarketingClient client = MarketingClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * PageRequest request = PageRequest.builder()
     *      .page(page)
     *      .pageSize(pageSize)
     *      .build();
     * int total = 0;
     * ItemPage<MarketingSubscription> subscriberPage = null;
     * String emailListId = "emailListId";
     * do {
     *      // Keep making requests as long as there are more pages
     *      subscriberPage = client.getSubscriptionPage(emailListId, request);
     *      total = subscriberPage.getMetadata().getTotal();
     *
     *      // The current page's items are aggregated
     *      allSubscribers.addAll(subscriberPage.getItems());
     *      request = request.nextPageRequest();
     * }
     * while (allSubscribers.size() < total);
     * }</pre>
     */
    public ItemPage<MarketingSubscription> getSubscriptionPage(
            final String emailListId,
            final PageRequest pageRequest)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException, OutsetaInvalidArgumentException {

        if (emailListId == null
                || emailListId.isBlank()) {
            throw new OutsetaInvalidArgumentException(
                    "Email list id cannot be null or blank.");
        }

        if (pageRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Page request cannot be null.");
        }

        String result = this.get("/email/lists/" + emailListId
                        + "/subscriptions",
                pageRequest.buildParams());

        return this.getParserFacade()
                .jsonStringToPage(result,
                        MarketingSubscription.class);
    }

    /**
     * This method adds a new person as a subscriber to an existing email list.
     * The SendWelcomeEmail property determines if the person added to the
     * email list is sent a welcome email. The property defaults to false.
     *
     * @param emailListId The id of the email list.
     * @param marketingSubscription The marketing subscriber to add.
     * @return The marketing subscriber.
     * @throws OutsetaInvalidArgumentException Thrown if the
     *                                              id is null.
     * @throws OutsetaParseException            Thrown if the email list
     *                                              cannot be parsed.
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
     * MarketingClient client = MarketingClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String emailListId = "emailListId";
     * MarketingSubscription MarketingSubscription =
     *      MarketingSubscription.builder()
     *     .build();
     * MarketingSubscription createdSubscription = client
     *      .subscribePersonToList(
     *      emailListId, MarketingSubscription);
     * }</pre>
     */
    public MarketingSubscription subscribePersonToList(
            final String emailListId,
            final MarketingSubscription marketingSubscription)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (emailListId == null
                || emailListId.isBlank()) {
            throw new OutsetaInvalidArgumentException(
                    "Email list id cannot be null or blank.");
        }

        if (marketingSubscription == null) {
            throw new OutsetaInvalidArgumentException(
                    "Marketing subscription cannot be null.");
        }

        String result = this.post("/email/lists/" + emailListId
                        + "/subscriptions",
                new HashMap<>(), this.getParserFacade().objectToJsonString(
                        marketingSubscription));

        return this.getParserFacade().jsonStringToObject(result,
                MarketingSubscription.class);
    }

    /**
     * This method removes a subscriber from an email list.
     *
     * @param subscriptionId The id of the subscriber.
     * @param emailListId The id of the email list.
     * @throws OutsetaInvalidArgumentException Thrown if the
     *                                              id is null.
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
     * MarketingClient client = MarketingClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String subscriptionId = "subscriptionId";
     * String emailListId = "emailListId";
     * client.removeSubscriberFromList(emailListId,
     *          subscriptionId);
     * }</pre>
     */
    public void removeSubscriberFromList(
            final String emailListId,
            final String subscriptionId)
            throws OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (emailListId == null
                || emailListId.isBlank()) {
            throw new OutsetaInvalidArgumentException(
                    "Email list id cannot be null or blank.");
        }

        if (subscriptionId == null
                || subscriptionId.isBlank()) {
            throw new OutsetaInvalidArgumentException(
                    "Subscriber id cannot be null or blank.");
        }

        this.delete("/email/lists/" + emailListId
                        + "/subscriptions/" + subscriptionId,
                new HashMap<>());
    }
}
