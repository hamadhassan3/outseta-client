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
import com.outseta.model.request.AddOnUsageRequest;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.AddOn;
import com.outseta.model.result.ItemPage;

import java.util.HashMap;

/**
 * This class is used to make calls to the AddOn endpoints of the
 * Outseta API.
 * <p>
 *     The AddOn endpoints are used to manage AddOns.
 *     The class provides a builder to make it easier to construct the client.
 * </p>
 */
public final class AddOnClient extends BaseClient {

    /**
     * This method is used to get a builder that can be used to build an
     * AddOnClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build an AddOnClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static ClientBuilder<AddOnClient> builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new ClientBuilder<>(new AddOnClient(baseUrl));
    }

    /**
     * The constructor creates a new AddOn client with the base url.
     * It is intentionally private to force the use of the builder.
     *
     * @param pBaseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    private AddOnClient(final String pBaseUrl)
            throws OutsetaClientBuildException {
        super(pBaseUrl);
    }

    /**
     * This method is used to get an add-on by id.
     *
     * @param addOnId The id of the addOn to get.
     * @return The addOn.
     * @throws OutsetaInvalidArgumentException Thrown if the addOn
     *                                              id is null.
     * @throws OutsetaParseException            Thrown if the addOn
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
     * AddOnClient client = AddOnClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String addOnId = "addOnId";
     * AddOn addOn = client.getAddOn(addOnId);
     * }</pre>
     */
    public AddOn getAddOn(final String addOnId)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (addOnId == null || addOnId.isBlank()) {
            throw new OutsetaInvalidArgumentException(
                    "AddOn id cannot be null or blank.");
        }

        String result = this.get("/billing/addons/" + addOnId,
                new HashMap<>());

        return this.getParserFacade().jsonStringToObject(result,
                AddOn.class);
    }

    /**
     * This method is used to get a page of AddOn objects.
     *
     * @param pageRequest The page request to use.
     * @return The list of AddOn objects.
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
     * AddOnClient client = AddOnClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * PageRequest request = PageRequest.builder()
     *      .page(page)
     *      .pageSize(pageSize)
     *      .build();
     * int total = 0;
     * ItemPage<AddOn> addOnPage = null;
     *
     * do {
     *      // Keep making requests as long as there are more pages
     *      addOnPage = addOnClient.getAddOnPage(request);
     *      total = addOnPage.getMetadata().getTotal();
     *
     *      // The current page's items are aggregated
     *      allAddOns.addAll(addOnPage.getItems());
     *      request = request.nextPageRequest();
     * }
     * while (addAddOns.size() < total);
     * }</pre>
     */
    public ItemPage<AddOn> getAddOnPage(final PageRequest pageRequest)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException, OutsetaInvalidArgumentException {

        if (pageRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Page request cannot be null.");
        }

        String result = this.get("/billing/addons",
                pageRequest.buildParams());

        return this.getParserFacade()
                .jsonStringToPage(result,
                        AddOn.class);
    }

    /**
     * This method is used to add usage of an add-on.
     *
     * @param addOnUsageRequest The usage request for the addon.
     * @throws OutsetaInvalidArgumentException Thrown if the addOnUsageRequest
     *                                          is null.
     * @throws OutsetaParseException            Thrown if the addOnUsageRequest
     *                                          cannot be parsed.
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
     * AddOnClient client = AddOnClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * AddOn addOnUsageRequest = new AddOnUsageRequest();
     * AddOn addOn = client.addUsageForAddOn(addOnUsageRequest);
     * }</pre>
     */
    public void addUsageForAddOn(final AddOnUsageRequest addOnUsageRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (addOnUsageRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "AddOn request cannot be null.");
        }

        this.post("/billing/usage", new HashMap<>(),
                this.getParserFacade().objectToJsonString(addOnUsageRequest));
    }
}
