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
import com.outseta.model.result.Discount;

import java.util.HashMap;

/**
 * This class is used to make calls to the Discount endpoints of the
 * Outseta API.
 * <p>
 *     The Discount endpoints are used to manage Dicounts.
 *     The class provides a builder to make it easier to construct the client.
 * </p>
 */
public final class DiscountClient extends BaseClient {

    /**
     * This method is used to get a builder that can be used to build an
     * DiscountClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build an DiscountClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static ClientBuilder<DiscountClient> builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new ClientBuilder<>(new DiscountClient(baseUrl));
    }

    /**
     * The constructor creates a new Discount client with the base url.
     * It is intentionally private to force the use of the builder.
     *
     * @param pBaseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    private DiscountClient(final String pBaseUrl)
            throws OutsetaClientBuildException {
        super(pBaseUrl);
    }

    /**
     * This method is used to create a discount.
     *
     * @param discountRequest The discount to create.
     * @return The created discount.
     * @throws OutsetaInvalidArgumentException Thrown if the discount request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the discount cannot be
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
     * DisountClient client = DisountClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Discount discountRequest = new Discount();
     * Discount discount = client.createDiscount(discountRequest);
     * }</pre>
     */
    public Discount createDiscount(final Discount discountRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (discountRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Discount request cannot be null.");
        }

        String req = this.getParserFacade().objectToJsonString(discountRequest);
        String result = this.post("/billing/discountcoupons",
                new HashMap<>(),
                req);

        return this.getParserFacade()
                .jsonStringToObject(result, Discount.class);
    }
}
