package com.outseta.client.endpoint_client.crm;

import com.outseta.client.BaseClient;
import com.outseta.client.ClientBuilder;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.OutsetaParseException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.model.request.TemporaryPasswordRequest;
import com.outseta.model.result.MultiplePerson;
import com.outseta.model.result.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to make calls to the People endpoint of the CRM API.
 * More information about this endpoint can be found at https://documenter.getpostman.com/view/3613332/outseta-rest-api-v1
 */
public class PeopleClient extends BaseClient {

    public static class PeopleClientBuilder extends ClientBuilder {

        public PeopleClientBuilder(String baseUrl)
                throws OutsetaClientBuildException {
            super(new PeopleClient(baseUrl));
        }

        @Override
        public PeopleClientBuilder withBaseUrl(String baseUrl)
                throws OutsetaClientBuildException {

            super.withBaseUrl(baseUrl);
            return this;
        }

        @Override
        public PeopleClientBuilder withApiKey(String apiKey)
                throws OutsetaClientBuildException {

            super.withApiKey(apiKey);
            return this;
        }

        @Override
        public PeopleClientBuilder withAccessKey(String accessKey)
                throws OutsetaClientBuildException {

            super.withAccessKey(accessKey);
            return this;
        }

        @Override
        public PeopleClientBuilder withHeaders(Map<String, String> headers)
                throws OutsetaClientBuildException {

            super.withHeaders(headers);
            return this;
        }

        @Override
        public PeopleClientBuilder withRequestMaker(
                RequestMakerType requestMakerType)
                throws OutsetaClientBuildException {

            super.withRequestMaker(requestMakerType);
            return this;
        }

        @Override
        public PeopleClientBuilder withRequestMaker(String requestMakerType)
                throws OutsetaClientBuildException {
            super.withRequestMaker(requestMakerType);
            return this;
        }

        @Override
        public PeopleClientBuilder withParser(ParserFacade parserFacade)
                throws OutsetaClientBuildException {
            super.withParser(parserFacade);
            return this;
        }

        @Override
        public PeopleClientBuilder withDefaultParser()
                throws OutsetaClientBuildException {
            super.withDefaultParser();
            return this;
        }

        @Override
        public PeopleClientBuilder withDefaultRequestMaker()
                throws OutsetaClientBuildException {

            super.withDefaultRequestMaker();
            return this;
        }

        @Override
        public PeopleClient build() throws OutsetaClientBuildException {
            return (PeopleClient) super.build();
        }
    }

    public static PeopleClientBuilder builder(String baseUrl)
            throws OutsetaClientBuildException {
        return new PeopleClientBuilder(baseUrl);
    }

    /**
     * Constructor is intentionally private to ensure that builder is used.
     *
     * @param baseUrl The base url for the api
     * @throws OutsetaClientBuildException Thrown if the client cannot be built
     */
    private PeopleClient(String baseUrl) throws OutsetaClientBuildException {
        super(baseUrl);
    }

    /**
     * Constructor is intentionally private to ensure that builder is used.
     *
     * @param baseUrl      The base url for the api
     * @param headers      The headers to use for the api
     * @param requestMaker The request maker to use for the api
     * @throws OutsetaClientBuildException Thrown if the client cannot be built
     */
    private PeopleClient(String baseUrl, Map<String, String> headers,
                         RequestMaker requestMaker)
            throws OutsetaClientBuildException {
        super(baseUrl, headers, requestMaker);
    }

    public Person getPerson(String personId)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (personId == null) {
            throw new OutsetaInvalidArgumentException(
                    "Person id cannot be null.");
        }

        String result = this.get("/crm/people/" + personId, new HashMap<>());

        return this.getParserFacade().jsonStringToObject(result, Person.class);
    }

    /**
     * TODO Do this method using paginators!!!
     */
    public List<Person> getAllPerson()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        String result = this.get("/crm/people", new HashMap<>());

        return this.getParserFacade()
                .jsonStringToObject(result, MultiplePerson.class).getItems();
    }

    public Person createPerson(Person personRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (personRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Person request cannot be null.");
        }

        String result = this.post("/crm/people", new HashMap<>(),
                this.getParserFacade().objectToJsonString(personRequest));

        return this.getParserFacade().jsonStringToObject(result, Person.class);
    }

    public Person updatePerson(String personId, Person personRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (personId == null) {
            throw new OutsetaInvalidArgumentException(
                    "Person id cannot be null.");
        }

        if (personRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Person request cannot be null.");
        }

        String result = this.put("/crm/people/" + personId, new HashMap<>(),
                this.getParserFacade().objectToJsonString(personRequest));

        return this.getParserFacade().jsonStringToObject(result, Person.class);
    }

    public void deletePerson(String personId)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (personId == null) {
            throw new OutsetaInvalidArgumentException(
                    "Person id cannot be null.");
        }

        this.delete("/crm/people/" + personId, new HashMap<>());
    }

    public void setTemporaryPassword(String personId,
                                     TemporaryPasswordRequest temporaryPasswordRequest)
            throws OutsetaInvalidArgumentException, OutsetaParseException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException {

        if (temporaryPasswordRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Temporary password request cannot be null.");
        }

        if (personId == null) {
            throw new OutsetaInvalidArgumentException(
                    "Person id cannot be null.");
        }

        this.put("/crm/people/" + personId + "/setTemporaryPassword",
                new HashMap<>(), this.getParserFacade()
                        .objectToJsonString(temporaryPasswordRequest));
    }

}
