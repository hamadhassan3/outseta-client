package com.outseta.client.endpoint_client.billing;

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
import com.outseta.model.request.CreateOrChangeSubscriptionRequest;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.Invoice;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Subscription;
import com.outseta.model.result.SubscriptionAddOn;

import java.util.HashMap;

/**
 * This class is used to make calls to the Subscription endpoints of the
 * Outseta API.
 * <p>
 *     The Subscription endpoints are used to manage subscriptions.
 *     The class provides a builder to make it easier to construct the client.
 * </p>
 */
public final class SubscriptionClient extends BaseClient {

    /**
     * This method is used to get a builder that can be used to build an
     * SubscriptionClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build an SubscriptionClient
     * object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static ClientBuilder<SubscriptionClient> builder(
            final String baseUrl)
            throws OutsetaClientBuildException {
        return new ClientBuilder<>(new SubscriptionClient(baseUrl));
    }

    /**
     * The constructor creates a new SubscriptionClient with the base url.
     * It is intentionally private to force the use of the builder.
     *
     * @param pBaseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    private SubscriptionClient(final String pBaseUrl)
            throws OutsetaClientBuildException {
        super(pBaseUrl);
    }

    /**
     * This method is used to get a subscription by id.
     *
     * @param subscriptionId The id of the subscription to get.
     * @return The subscription.
     * @throws OutsetaInvalidArgumentException Thrown if the subscription
     *                                              id is null.
     * @throws OutsetaParseException            Thrown if the subscription
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
     * SubscriptionClient client = SubscriptionClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String subscriptionId = "subscriptionId";
     * Subscription subscription = client.getSubscription(subscriptionId);
     * }</pre>
     */
    public Subscription getSubscription(final String subscriptionId)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (subscriptionId == null || subscriptionId.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Subscription id cannot be null or blank.");
        }

        String result = this.get("/billing/subscriptions/"
                        + subscriptionId,
                new HashMap<>());

        return this.getParserFacade().jsonStringToObject(result,
                Subscription.class);
    }

    /**
     * This method is used to get a page of Subscription objects.
     *
     * @param pageRequest The page request to use.
     * @return The list of subscription objects.
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
     * SubscriptionClient client = SubscriptionClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * PageRequest request = PageRequest.builder()
     *      .page(page)
     *      .pageSize(pageSize)
     *      .build();
     * int total = 0;
     * ItemPage<Subscription> subscriptionPage = null;
     *
     * do {
     *      // Keep making requests as long as there are more pages
     *      subscriptionPage = subscriptionClient.getSubscriptionPage(request);
     *      total = subscriptionPage.getMetadata().getTotal();
     *
     *      // The current page's items are aggregated
     *      allSubscriptions.addAll(subscriptionPage.getItems());
     *      request = request.nextPageRequest();
     * }
     * while (allSubscriptions.size() < total);
     * }</pre>
     */
    public ItemPage<Subscription> getSubscriptionPage(
            final PageRequest pageRequest)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException, OutsetaInvalidArgumentException {

        if (pageRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Page request cannot be null.");
        }

        String result = this.get("/billing/subscriptions",
                pageRequest.buildParams());

        return this.getParserFacade()
                .jsonStringToPage(result,
                        Subscription.class);
    }

    /**
     * This method is used to see what the initial or renewal invoice would
     * look like if an account were to register with this subscription. The
     * method returns an invoice object with information about the amount
     * outstanding that can be used to show the user a confirmation page.
     *
     * @param asOf now or renewal.
     * @param createOrChangeSubscriptionRequest The subscription to create.
     * @return The invoice.
     *
     * @throws OutsetaInvalidArgumentException Thrown if the request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the request cannot be
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
     * SubscriptionClient client = SubscriptionClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * CreateOrChangeSubscriptionRequest createOrChangeSubscriptionRequest
     *              = CreateOrChangeSubscriptionRequest.builder().build();
     * Invoice invoice = client.addFirstTimeSubscriptionPreview(
     *              "now",
     *              createOrChangeSubscriptionRequest);
     * }</pre>
     */
    public Invoice addFirstTimeSubscriptionPreview(
            final String asOf,
            final CreateOrChangeSubscriptionRequest
                    createOrChangeSubscriptionRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (createOrChangeSubscriptionRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Create Subscription request cannot be null.");
        }

        HashMap<String, Object> params = new HashMap<>();

        if (asOf != null) {
            params.put("asOf", asOf);
        }

        String result = this.post(
                "/billing/subscriptions/compute-charge-summary",
                params,
                this.getParserFacade()
                        .objectToJsonString(createOrChangeSubscriptionRequest));

        return this.getParserFacade().jsonStringToObject(result,
                Invoice.class);
    }

    /**
     * This method is used when adding a subscription to an account for the
     * first time. The method returns an invoice object with information about
     * the amount outstanding.
     *
     * @param createOrChangeSubscriptionRequest The subscription to change.
     * @return The subscription.
     *
     * @throws OutsetaInvalidArgumentException Thrown if the request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the request cannot be
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
     * SubscriptionClient client = SubscriptionClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * CreateOrChangeSubscriptionRequest createOrChangeSubscriptionRequest
     *              = CreateOrChangeSubscriptionRequest.builder().build();
     * Invoice invoice = client.addFirstTimeSubscription(
     *              createOrChangeSubscriptionRequest);
     * }</pre>
     */
    public Subscription addFirstTimeSubscription(
            final CreateOrChangeSubscriptionRequest
                    createOrChangeSubscriptionRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (createOrChangeSubscriptionRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Create Subscription request cannot be null.");
        }

        HashMap<String, Object> params = new HashMap<>();

        String result = this.put(
                "/billing/subscriptions/firsttimesubscription",
                params,
                this.getParserFacade()
                        .objectToJsonString(createOrChangeSubscriptionRequest));

        return this.getParserFacade().jsonStringToObject(result,
                Subscription.class);
    }

    /**
     * This method is used when changing a subscription on an account. The
     * method returns an invoice object with information about the amount
     * outstanding that can be used to show the user a confirmation page.
     *
     * This method does not committ the subscription to the database.
     * Rather it can be used as a preview.
     *
     * @param subscriptionId The id of the subscription to change.
     * @param createOrChangeSubscriptionRequest The subscription to create.
     * @return The invoice.
     *
     * @throws OutsetaInvalidArgumentException Thrown if the request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the request cannot be
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
     * SubscriptionClient client = SubscriptionClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * CreateOrChangeSubscriptionRequest createOrChangeSubscriptionRequest
     *              = CreateOrChangeSubscriptionRequest.builder().build();
     * Invoice invoice = client.changeSubscriptionPreview(
     *              subscriptionId,
     *              CreateOrChangeSubscriptionRequest);
     * }</pre>
     */
    public Invoice changeSubscriptionPreview(
            final String subscriptionId,
            final CreateOrChangeSubscriptionRequest
                    createOrChangeSubscriptionRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (subscriptionId == null || subscriptionId.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Subscription id cannot be null or blank.");
        }

        if (createOrChangeSubscriptionRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Change Subscription request cannot be null.");
        }

        HashMap<String, Object> params = new HashMap<>();

        String result = this.put(
                "/billing/subscriptions/"
                        + subscriptionId + "/changesubscriptionpreview",
                params,
                this.getParserFacade()
                        .objectToJsonString(createOrChangeSubscriptionRequest));

        return this.getParserFacade().jsonStringToObject(result,
                Invoice.class);
    }

    /**
     * This method is used when changing a subscription on an account. The
     * method returns an invoice object with information about the amount
     * outstanding.
     *
     * @param subscriptionId The id of the subscription to change.
     * @param createOrChangeSubscriptionRequest The subscription to create.
     * @return The subscription.
     *
     * @throws OutsetaInvalidArgumentException Thrown if the request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the request cannot be
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
     * SubscriptionClient client = SubscriptionClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * CreateOrChangeSubscriptionRequest createOrChangeSubscriptionRequest
     *              = CreateOrChangeSubscriptionRequest.builder().build();
     * Invoice invoice = client.changeSubscription(
     *              subscriptionId, CreateOrChangeSubscriptionRequest);
     * }</pre>
     */
    public Subscription changeSubscription(
            final String subscriptionId,
            final CreateOrChangeSubscriptionRequest
                    createOrChangeSubscriptionRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (subscriptionId == null || subscriptionId.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Subscription id cannot be null or blank.");
        }

        if (createOrChangeSubscriptionRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Change Subscription request cannot be null.");
        }

        HashMap<String, Object> params = new HashMap<>();

        String result = this.put(
                "/billing/subscriptions/"
                        + subscriptionId + "/changesubscription",
                params,
                this.getParserFacade()
                        .objectToJsonString(createOrChangeSubscriptionRequest));

        return this.getParserFacade().jsonStringToObject(result,
                Subscription.class);
    }

    /**
     * This method is used when changing a subscription on an account. The
     * method returns an invoice object with information about the amount
     * outstanding.
     *
     * @param subscriptionId The id of the subscription to change.
     * @param subscriptionRequest The request to set upgrade required.
     * @return The subscription.
     *
     * @throws OutsetaInvalidArgumentException Thrown if the request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the request cannot be
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
     * SubscriptionClient client = SubscriptionClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Subscription subscriptionRequest
     *              = Subscription.builder().build();
     * client.setSubscriptionUpgradeRequired(
     *              subscriptionId, subscriptionRequest);
     * }</pre>
     */
    public Subscription setSubscriptionUpgradeRequired(
            final String subscriptionId,
            final Subscription
                    subscriptionRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (subscriptionId == null || subscriptionId.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Subscription id cannot be null or blank.");
        }

        if (subscriptionRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Subscription request cannot be null.");
        }

        HashMap<String, Object> params = new HashMap<>();

        String result = this.put(
                "/billing/subscriptions/"
                        + subscriptionId + "/setsubscriptionupgraderequired",
                params,
                this.getParserFacade()
                        .objectToJsonString(subscriptionRequest));

        return this.getParserFacade().jsonStringToObject(result,
                Subscription.class);
    }

    /**
     * Use this method to extend the date that a trial subscription expires.
     *
     * @param accountId The id of the account.
     * @param date The date for extension.
     *
     * @throws OutsetaInvalidArgumentException Thrown if the request is
     *                                          null.
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
     * SubscriptionClient client = SubscriptionClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String accountId = "accountId";
     * String date = "date";
     * client.extendTrialSubscription(accountId, date);
     * }</pre>
     */
    public void extendTrialSubscription(final String accountId,
                                        final String date)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (accountId == null || accountId.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Account id cannot be null or blank.");
        }

        if (date == null || date.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Date cannot be null or blank.");
        }

        HashMap<String, Object> params = new HashMap<>();

        this.put(
                "/crm/accounts/extendtrial/"
                        + accountId + "/" + date,
                params,
                "");
    }

    /**
     * Use this method to add add-on to the subscription.
     *
     * @param subscriptionAddOnRequest The subscription add-on.
     * @return The subscription.
     *
     * @throws OutsetaInvalidArgumentException Thrown if the request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the request cannot be
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
     * SubscriptionClient client = SubscriptionClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * SubscriptionAddOn subscriptionAddOnRequest = SubscriptionAddOn
     *                      .builder().build();
     * client.addAddOnToSubscription(subscriptionAddOnRequest);
     * }</pre>
     */
    public Subscription addAddOnToSubscription(
            final SubscriptionAddOn subscriptionAddOnRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (subscriptionAddOnRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Subscription add-on cannot be null or blank.");
        }

        HashMap<String, Object> params = new HashMap<>();

        String result = this.post(
                "/billing/subscriptionaddons",
                params,
                this.getParserFacade()
                        .objectToJsonString(subscriptionAddOnRequest));

        return this.getParserFacade().jsonStringToObject(result,
                Subscription.class);
    }

    /**
     * Use this method to add a discount to a subscription.
     *
     * @param subscriptionId The subscription id.
     * @param discountId The discount id of the discount to add.
     *
     * @throws OutsetaInvalidArgumentException Thrown if the request is
     *                                          null.
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
     * SubscriptionClient client = SubscriptionClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String subscriptionId = "sId";
     * String discountId = "dId";
     * client.addDiscountToSubscription(subscriptionId, discountId);
     * }</pre>
     */
    public void addDiscountToSubscription(
            final String subscriptionId,
            final String discountId)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (subscriptionId == null || subscriptionId.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Subscription id cannot be null or blank.");
        }

        if (discountId == null || discountId.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Discount Id cannot be null");
        }

        HashMap<String, Object> params = new HashMap<>();

        this.post(
                "/billing/subscriptions/"
                        + subscriptionId + "/discounts/" + discountId,
                params, "");
    }
}
