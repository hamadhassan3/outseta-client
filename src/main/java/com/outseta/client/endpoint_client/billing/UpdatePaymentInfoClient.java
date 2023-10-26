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
import com.outseta.model.request.UpdatePaymentInfoRequest;

import java.util.HashMap;

/**
 * This class is used to make calls to the UpdatePaymentInfo endpoints of the
 * Outseta API.
 * <p>
 *     The UpdatePaymentInfo endpoints are used to manage payment info.
 *     The class provides a builder to make it easier to construct the client.
 * </p>
 */
public final class UpdatePaymentInfoClient extends BaseClient {

    /**
     * This method is used to get a builder that can be used to build an
     * UpdatePaymentInfoClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build an
     *      UpdatePaymentInfoClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static ClientBuilder<UpdatePaymentInfoClient> builder(
            final String baseUrl)
            throws OutsetaClientBuildException {
        return new ClientBuilder<>(new UpdatePaymentInfoClient(baseUrl));
    }

    /**
     * The constructor creates a new UpdatePaymentInfoClient client with
     * the base url.
     * It is intentionally private to force the use of the builder.
     *
     * @param pBaseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    private UpdatePaymentInfoClient(final String pBaseUrl)
            throws OutsetaClientBuildException {
        super(pBaseUrl);
    }

    /**
     * This method is used to update payment information.
     *
     * @param updatePaymentInfoRequest The usage request for updating payment
     *                                 info.
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
     * UpdatePaymentInfoClient client = UpdatePaymentInfoClient
     *      .builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * UpdatePaymentInfoRequest updatePaymentInfoRequest
     *      = UpdatePaymentInfoRequest.builder().build();
     * client.updatePaymentInfo(updatePaymentInfoRequest);
     * }</pre>
     */
    public void updatePaymentInfo(
            final UpdatePaymentInfoRequest updatePaymentInfoRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (updatePaymentInfoRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "UpdatePaymentInfo request cannot be null.");
        }

        this.post("/billing/paymentinformation", new HashMap<>(),
                this.getParserFacade()
                        .objectToJsonString(updatePaymentInfoRequest));
    }
}
