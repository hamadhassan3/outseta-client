package com.outseta.client.endpoint_client;

import com.outseta.client.BaseClient;
import com.outseta.client.ClientBuilder;
import com.outseta.exception.OutsetaClientBuildException;

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
     * Creates a new builder for the client.
     * @param baseUrl The base url for the client to use.
     * @return The builder.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *     built.
     */
    public static ClientBuilder<AuthenticationClient>
                builder(final String baseUrl)
                    throws OutsetaClientBuildException {
        return new ClientBuilder<>(new AuthenticationClient(baseUrl));
    }

    /**
     * The constructor is intentionally private to ensure that builder is used.
     * @param baseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be built.
     */
    private AuthenticationClient(final String baseUrl)
            throws OutsetaClientBuildException {
        super(baseUrl);
    }

    /*
     * TODO: Implement this method with example usage comment.
    public AuthToken getAuthToken(final GetAuthTokenRequest getAuthTokenRequest)
            throws OutsetaParseException,
                    OutsetaInvalidResponseCodeException,
                    OutsetaAPIBadRequestException,
                    OutsetaAPIFailedException,
                    OutsetaInvalidURLException,
                    OutsetaAPIUnknownException {

        String result = this.post("/tokens", new HashMap<>(),
                this.getParserFacade().objectToJsonString(getAuthTokenRequest));

        return this.getParserFacade().jsonStringToObject(
                result, AuthToken.class);
    }
     */
}
