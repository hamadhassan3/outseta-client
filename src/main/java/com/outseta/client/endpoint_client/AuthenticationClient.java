package com.outseta.client.endpoint_client;

import com.outseta.client.BaseClient;
import com.outseta.client.ClientBuilder;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaClientBuildException;
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

    public static class Builder extends ClientBuilder {

        /**
         * The constructor creates a new builder with the base url.
         * @param baseUrl The base url for the client to use.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *      built.
         */
        public Builder(final String baseUrl)
                throws OutsetaClientBuildException {

            super(new AuthenticationClient(baseUrl));
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
         *     built.
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
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *     built.
         */
        @Override
        public Builder requestMaker(final RequestMakerType requestMakerType)
                throws OutsetaClientBuildException {

            super.requestMaker(requestMakerType);
            return this;
        }

        /**
         * Sets the request maker for the client.
         * @param requestMakerType The request maker to set.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *     built.
         */
        @Override
        public Builder requestMaker(final String requestMakerType)
                throws OutsetaClientBuildException {
            super.requestMaker(requestMakerType);
            return this;
        }

        /**
         * Sets the parser for the client.
         * @param parserFacade The parser to set.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *     built.
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
         *     built.
         */
        @Override
        public Builder defaultParser() throws OutsetaClientBuildException {
            super.defaultParser();
            return this;
        }

        /**
         * Sets the default request maker for the client.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *     built.
         */
        @Override
        public Builder defaultRequestMaker()
                throws OutsetaClientBuildException {

            super.defaultRequestMaker();
            return this;
        }

        /**
         * Builds the client.
         * @return The built client.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *     built.
         */
        @Override
        public AuthenticationClient build() throws OutsetaClientBuildException {
            return (AuthenticationClient) super.build();
        }
    }

    /**
     * Creates a new builder for the client.
     * @param baseUrl The base url for the client to use.
     * @return The builder.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *     built.
     */
    public static Builder builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new Builder(baseUrl);
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
