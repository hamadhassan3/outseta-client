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
import com.outseta.model.result.Deal;
import com.outseta.model.result.ItemPage;

import java.util.HashMap;

/**
 * This class is used to make calls to the Deal endpoints of the
 * Outseta API.
 * <p>
 *     The Deal endpoints are used to manage deals. The class
 *     provides a builder to make it easier to construct the client.
 * </p>
 */
public final class DealClient extends BaseClient {

    /**
     * This method is used to get a builder that can be used to build an
     * DealClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build a DealClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static ClientBuilder<DealClient> builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new ClientBuilder<>(new DealClient(baseUrl));
    }

    /**
     * The constructor is intentionally made private so that
     * the builder must be used to create a DealClient object.
     * @param pBaseUrl The base url of the Outseta API.
     * @throws OutsetaClientBuildException If the client cannot be built.
     */
    private DealClient(final String pBaseUrl) throws
            OutsetaClientBuildException {
        super(pBaseUrl);
    }

    /**
     * This method is used to get a page of Deal objects.
     *
     * @param dealPageRequest The page request to use.
     * @return The list of deals.
     * @throws OutsetaInvalidResponseCodeException Thrown if the response code
     *                                             is invalid.
     * @throws OutsetaAPIBadRequestException       Thrown if the request is bad.
     * @throws OutsetaAPIFailedException           Thrown if the request fails.
     * @throws OutsetaAPIUnknownException          Thrown if the request fails
     *                                             for an unknown reason.
     * @throws OutsetaInvalidURLException          Thrown if the url is invalid.
     * @throws OutsetaParseException               Thrown if the deal cannot
     *                                             be parsed.
     * @throws OutsetaInvalidArgumentException    Thrown if the page request
     *                                            is null.
     *
     * Example usage:
     * <pre>{@code
     * DealClient client = DealClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * PageRequest request = PageRequest.builder()
     *      .page(page)
     *      .pageSize(pageSize)
     *      .build();
     * int total = 0;
     * ItemPage<Deal> dealPage = null;
     *
     * do {
     *      // Keep making requests as long as there are more pages
     *      dealPage = dealClient.getDealPage(request);
     *      total = dealPage.getMetadata().getTotal();
     *
     *      // The current page's items are aggregated
     *      allDeals.addAll(dealPage.getItems());
     *      request = request.nextPageRequest();
     * }
     * while (allDeals.size() < total);
     * }</pre>
     */
    public ItemPage<Deal> getDealPage(final PageRequest dealPageRequest)
            throws OutsetaInvalidArgumentException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaParseException {

        if (dealPageRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Page request cannot be null.");
        }

        String result = this.get("/crm/deals",
                dealPageRequest.buildParams());

        return this.getParserFacade()
                .jsonStringToPage(result,
                        Deal.class);
    }

    /**
     * This method is used to get a deal by id.
     *
     * @param dealId The id of the deal to get.
     * @return The deal.
     * @throws OutsetaInvalidArgumentException Thrown if the deal id is null.
     * @throws OutsetaParseException            Thrown if the deal cannot be
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
     * DealClient client = DealClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String dealId = "dealId";
     * Deal deal = client.getDeal(dealId);
     * }</pre>
     */
    public Deal getDeal(final String dealId)
            throws OutsetaInvalidArgumentException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaParseException {

        if (dealId == null || dealId.isBlank()) {
            throw new OutsetaInvalidArgumentException(
                    "Deal id cannot be null.");
        }

        String result = this.get("/crm/deals/" + dealId,
                new HashMap<>());

        return this.getParserFacade().jsonStringToObject(result, Deal.class);
    }

    /**
     * This method is used to create a deal.
     *
     * @param dealRequest The deal to create.
     * @return The created deal.
     * @throws OutsetaInvalidArgumentException Thrown if the deal request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the deal cannot be
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
     * DealClient client = DealClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Deal dealRequest = new Deal();
     * Deal deal = client.createDeal(dealRequest);
     * }</pre>
     */
    public Deal createDeal(final Deal dealRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (dealRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Deal request cannot be null.");
        }

        String result = this.post("/crm/deals", new HashMap<>(),
                this.getParserFacade().objectToJsonString(dealRequest));

        return this.getParserFacade().jsonStringToObject(result, Deal.class);
    }

    /**
     * This method is used to delete a deal.
     *
     * @param dealId The id of the deal to delete.
     * @throws OutsetaInvalidArgumentException Thrown if the deal id is null.
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
     * DealClient client = DealClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String dealId = "dealId";
     * client.deleteDeal(dealId);
     * }</pre>
     */
    public void deleteDeal(final String dealId)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (dealId == null || dealId.isBlank()) {
            throw new OutsetaInvalidArgumentException(
                    "Deal id cannot be null.");
        }

        this.delete("/crm/deals/" + dealId, new HashMap<>());
    }

    /**
     * This method is used to update a deal.
     *
     * @param dealId      The id of the deal to update.
     * @param dealRequest The deal to update.
     * @return The updated deal.
     * @throws OutsetaInvalidArgumentException Thrown if the deal id is null
     *                                          or if the deal request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the deal cannot be
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
     * DealClient client = DealClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String dealId = "dealId";
     * Deal dealRequest = new Deal();
     * Deal deal = client.updateDeal(dealId, dealRequest);
     * }</pre>
     */
    public Deal updateDeal(final String dealId,
                               final Deal dealRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (dealId == null || dealId.isBlank()) {
            throw new OutsetaInvalidArgumentException(
                    "Deal id cannot be null.");
        }

        if (dealRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Deal request cannot be null.");
        }

        String result = this.put("/crm/deals/" + dealId,
                new HashMap<>(),
                this.getParserFacade().objectToJsonString(dealRequest));

        return this.getParserFacade().jsonStringToObject(result, Deal.class);
    }
}
