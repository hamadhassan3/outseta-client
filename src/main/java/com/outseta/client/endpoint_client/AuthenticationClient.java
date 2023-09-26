package com.outseta.client.endpoint_client;

import com.outseta.client.BaseClient;
import com.outseta.client.ClientBuilder;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaClientBuildException;
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

public class AuthenticationClient extends BaseClient {

    public static class AuthenticationClientBuilder extends ClientBuilder {

        public AuthenticationClientBuilder(String baseUrl) throws OutsetaClientBuildException {
            super(new AuthenticationClient(baseUrl));
        }

        @Override
        public AuthenticationClientBuilder withBaseUrl(String baseUrl) throws OutsetaClientBuildException {

            super.withBaseUrl(baseUrl);
            return this;
        }

        @Override
        public AuthenticationClientBuilder withApiKey(String apiKey) throws OutsetaClientBuildException {

            super.withApiKey(apiKey);
            return this;
        }

        @Override
        public AuthenticationClientBuilder withAccessKey(String accessKey) throws OutsetaClientBuildException {

            super.withAccessKey(accessKey);
            return this;
        }

        @Override
        public AuthenticationClientBuilder withHeaders(Map<String, String> headers) throws OutsetaClientBuildException{

            super.withHeaders(headers);
            return this;
        }

        @Override
        public AuthenticationClientBuilder withRequestMaker(RequestMakerType requestMakerType) throws OutsetaClientBuildException{

            super.withRequestMaker(requestMakerType);
            return this;
        }

        @Override
        public AuthenticationClientBuilder withRequestMaker(String requestMakerType) throws OutsetaClientBuildException {
            super.withRequestMaker(requestMakerType);
            return this;
        }

        @Override
        public AuthenticationClientBuilder withParser(ParserFacade parserFacade) throws OutsetaClientBuildException {
            super.withParser(parserFacade);
            return this;
        }

        @Override
        public AuthenticationClientBuilder withDefaultParser() throws OutsetaClientBuildException {
            super.withDefaultParser();
            return this;
        }

        @Override
        public AuthenticationClientBuilder withDefaultRequestMaker() throws OutsetaClientBuildException{

            super.withDefaultRequestMaker();
            return this;
        }

        @Override
        public AuthenticationClient build() throws OutsetaClientBuildException {
            return (AuthenticationClient) super.build();
        }
    }

    public static AuthenticationClientBuilder builder(String baseUrl) throws OutsetaClientBuildException {
        return new AuthenticationClientBuilder(baseUrl);
    }

    /**
     * The constructor is intentionally private to ensure that builder is used.
     * @param baseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be built.
     */
    private AuthenticationClient(String baseUrl) throws OutsetaClientBuildException {
        super(baseUrl);
    }

    /**
     * The constructor is intentionally private to ensure that builder is used.
     * @param baseUrl The base url for the client to use.
     * @param headers The headers to use for the client.
     * @param requestMaker The request maker to use for the client.
     * @throws OutsetaClientBuildException Thrown if the client cannot be built.
     */
    private AuthenticationClient(String baseUrl, Map<String, String> headers, RequestMaker requestMaker)
            throws OutsetaClientBuildException {
        super(baseUrl, headers, requestMaker);
    }

    public AuthToken getAuthToken(GetAuthTokenRequest getAuthTokenRequest) throws OutsetaParseException, OutsetaInvalidResponseCodeException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaInvalidURLException, OutsetaAPIUnknownException {

        String result = this.post("/tokens", new HashMap<>(),
                this.getParserFacade().objectToJsonString(getAuthTokenRequest));

        return this.getParserFacade().jsonStringToObject(result, AuthToken.class);
    }
}
