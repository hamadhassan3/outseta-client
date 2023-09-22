package com.outseta.client.endpoint_client.crm;

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
import com.outseta.model.result.Person;

import java.util.HashMap;
import java.util.Map;

public class PeopleClient extends BaseClient {

    public static class PeopleClientBuilder extends ClientBuilder {

        public PeopleClientBuilder(String baseUrl) throws OutsetaClientBuildException {
            super(new PeopleClient(baseUrl));
        }

        @Override
        public PeopleClientBuilder withBaseUrl(String baseUrl) throws OutsetaClientBuildException {

            super.withBaseUrl(baseUrl);
            return this;
        }

        @Override
        public PeopleClientBuilder withApiKey(String apiKey) throws OutsetaClientBuildException {

            super.withApiKey(apiKey);
            return this;
        }

        @Override
        public PeopleClientBuilder withAccessKey(String accessKey) throws OutsetaClientBuildException {

            super.withAccessKey(accessKey);
            return this;
        }

        @Override
        public PeopleClientBuilder withHeaders(Map<String, String> headers) throws OutsetaClientBuildException{

            super.withHeaders(headers);
            return this;
        }

        @Override
        public PeopleClientBuilder withRequestMaker(RequestMakerType requestMakerType) throws OutsetaClientBuildException{

            super.withRequestMaker(requestMakerType);
            return this;
        }

        @Override
        public PeopleClientBuilder withRequestMaker(String requestMakerType) throws OutsetaClientBuildException {
            super.withRequestMaker(requestMakerType);
            return this;
        }

        @Override
        public PeopleClientBuilder withParser(ParserFacade parserFacade) throws OutsetaClientBuildException {
            super.withParser(parserFacade);
            return this;
        }

        @Override
        public PeopleClientBuilder withDefaultParser() throws OutsetaClientBuildException {
            super.withDefaultParser();
            return this;
        }

        @Override
        public PeopleClientBuilder withDefaultRequestMaker() throws OutsetaClientBuildException{

            super.withDefaultRequestMaker();
            return this;
        }

        @Override
        public PeopleClient build() throws OutsetaClientBuildException {
            return (PeopleClient) super.build();
        }
    }

    public static PeopleClientBuilder builder(String baseUrl) throws OutsetaClientBuildException {
        return new PeopleClientBuilder(baseUrl);
    }

    protected PeopleClient(String baseUrl) throws OutsetaClientBuildException {
        super(baseUrl);
    }

    protected PeopleClient(String baseUrl, Map<String, String> headers, RequestMaker requestMaker) throws OutsetaClientBuildException {
        super(baseUrl, headers, requestMaker);
    }

    public Person getPerson(String personId) throws OutsetaParseException, OutsetaInvalidResponseCodeException, OutsetaAPIBadRequestException, OutsetaAPIFailedException, OutsetaAPIUnknownException, OutsetaInvalidURLException {

        String result = this.get("/crm/people/" + personId, new HashMap<>());

        return this.getParserFacade().jsonStringToObject(result, Person.class);
    }

}
