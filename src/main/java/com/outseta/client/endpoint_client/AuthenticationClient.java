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
import com.outseta.model.request.GetAuthTokenRequest;
import com.outseta.model.result.AuthToken;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to make calls to the Authentication endpoints of the
 * Outseta API.
 * <p>
 *     The Authentication endpoints are used to manage authentication of
 *     users. The class provides a builder to make it easier to construct
 *     the client.
 * </p>
 */
public final class AuthenticationClient extends BaseClient {

    /**
     * A customized builder for the client.
     */
    public static final class Builder
            extends ClientBuilder<AuthenticationClient> {

        /**
         * The constructor to create an object of AuthenticationClient.Builder.
         *
         * @param client The client to build.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *    built.
         */
        public Builder(final AuthenticationClient client)
                throws OutsetaClientBuildException {
            super(client);
        }

        /**
         * Builds the client.
         * It is overridden so that the headers don't give exception without
         * the Authentication attribute, as Authentication client
         * endpoints may be executed without an authentication header.
         *
         * @return The client.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *     built.
         */
        @Override
        public AuthenticationClient build() throws OutsetaClientBuildException {
            if (this.getBaseClient().getParserFacade() == null) {
                throw new OutsetaClientBuildException(
                        "Parser cannot be null. Chooser default"
                                + " parser if you dont want to "
                                + "set a parser yourself.");
            }
            if (this.getBaseClient().getRequestMaker() == null) {
                throw new OutsetaClientBuildException(
                        "You must specify a request maker. Choose default "
                                + "if you are uncertain.");
            }

            return this.getBaseClient();
        }
    }

    /**
     * Creates a new builder for the client.
     * @param baseUrl The base url for the client to use.
     * @return The builder.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *     built.
     */
    public static Builder
                builder(final String baseUrl)
                    throws OutsetaClientBuildException {
        return new Builder(new AuthenticationClient(baseUrl));
    }

    /**
     * The constructor is intentionally private to ensure that builder is used.
     * @param baseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be built.
     */
    private AuthenticationClient(final String baseUrl)
            throws OutsetaClientBuildException {
        super(baseUrl);

        // The authentication client accepts payload as urlencoded.
        // This is an exceptional case, so it's okay to handle it here
        // without disrupting other clients.
        Map<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put("Accept", "application/x-www-form-urlencoded");
        this.updateHeaders(map);
    }

    /**
     * Call this API from the server to retrieve an access token that you can
     * use to make API calls via the client side. Make sure to secure your
     * username and password and not make them visible on the client side.
     *
     * To retrieve an access token for a user who has registered with your
     * service, the URL should point to your Outseta domain
     * (e.g. https://my-company.outseta.com).
     *
     * To retrieve an access token for an administrative user who logs into
     * the Outseta admin site, the URL should be https://go.outseta.com.
     *
     * *** This method can also be used to get the auth token for a user
     * using the outseta api key. Just configure the client with the api key.
     * Just pass the api key when creating the client.
     *
     * Reference:
     * https://documenter.getpostman.com/view/3613332/outseta-rest-api-v1/
     * 7TNfr6k
     *
     * @param getAuthTokenRequest The request for getting auth token.
     * @return The auth token.
     * @throws OutsetaInvalidArgumentException Thrown if the request is null.
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
     * AuthenticationClient client = AuthenticationClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * GetAuthTokenRequest request = GetAuthTokenRequest.builder().build();
     * AuthToken token = client.getAuthToken(request);
     * }</pre>
     */
    public AuthToken getAuthToken(final GetAuthTokenRequest getAuthTokenRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (getAuthTokenRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "The request cannot be null.");
        }

        if (getAuthTokenRequest.getUsername() == null
                || getAuthTokenRequest.getUsername().trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "The username cannot be null or empty.");
        }

        if (!this.isHeadersValid()) {
            // If there is no authentication attribute in headers, there must
            // be a password defined.

            if (getAuthTokenRequest.getPassword() == null
                    || getAuthTokenRequest.getPassword().trim().isEmpty()) {
                throw new OutsetaInvalidArgumentException(
                        "The password cannot be null or empty if there is no"
                                + "authentication header specified.");
            }
        }

        String urlEncoded = "username="
                + this.getRequestMaker()
                        .urlEncodePayloadAttribute(
                                getAuthTokenRequest.getUsername());

        if (getAuthTokenRequest.getPassword() != null
                && !getAuthTokenRequest.getPassword().trim().isEmpty()) {
            urlEncoded += "&password="
                    + this.getRequestMaker()
                    .urlEncodePayloadAttribute(
                            getAuthTokenRequest.getPassword());
        }

        String result = this.post("/tokens", new HashMap<>(),
                urlEncoded);

        return this.getParserFacade().jsonStringToObject(result,
                AuthToken.class);
    }
}
