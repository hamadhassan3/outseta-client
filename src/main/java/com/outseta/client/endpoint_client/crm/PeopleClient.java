package com.outseta.client.endpoint_client.crm;

import com.outseta.client.BaseClient;
import com.outseta.client.ClientBuilder;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.OutsetaParseException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.model.request.PageRequest;
import com.outseta.model.request.TemporaryPasswordRequest;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to make calls to the People endpoints of the CRM API.
 * <p>
 *     The People endpoints are used to manage the people in your CRM. The class
 *     provides a builder to make it easier to construct the client.
 * </p>
 */
public final class PeopleClient extends BaseClient {

    /**
     * This class is used to build a PeopleClient object.
     * <p>
     *     The builder is used to make it easier to construct a PeopleClient
     *     object.
     * </p>
     */
    public static class Builder extends ClientBuilder {

        /**
         * This constructor is used to initialize the builder with the base url
         * for the api.
         *
         * @param baseUrl The base url for the api
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *                                     built
         */
        public Builder(final String baseUrl)
                throws OutsetaClientBuildException {
            super(new PeopleClient(baseUrl));
        }

        /**
         * This method is used to set the base url for the api.
         *
         * @param baseUrl The base url for the api.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *                                     built.
         */
        @Override
        public Builder baseUrl(final String baseUrl)
                throws OutsetaClientBuildException {

            super.baseUrl(baseUrl);
            return this;
        }

        /**
         * This method is used to set the api key for the api.
         *
         * @param apiKey The api key for the api.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *                                     built.
         */
        @Override
        public Builder apiKey(final String apiKey)
                throws OutsetaClientBuildException {

            super.apiKey(apiKey);
            return this;
        }

        /**
         * This method is used to set the access key for the api.
         *
         * @param accessKey The access key for the api.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *                                     built.
         */
        @Override
        public Builder accessKey(final String accessKey)
                throws OutsetaClientBuildException {

            super.accessKey(accessKey);
            return this;
        }

        /**
         * This method is used to set the headers for the api.
         *
         * @param headers The headers for the api.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *                                     built.
         */
        @Override
        public Builder headers(final Map<String, String> headers)
                throws OutsetaClientBuildException {

            super.headers(headers);
            return this;
        }

        /**
         * This method is used to set the request maker for the api.
         *
         * @param requestMakerType The request maker for the api.
         * @return The builder so that calls can be chained.
         * @throws OutsetaInvalidRequestMakerException Thrown if the client
         *                                      cannot be built.
         */
        @Override
        public Builder requestMaker(
                final RequestMakerType requestMakerType)
                throws OutsetaInvalidRequestMakerException {

            super.requestMaker(requestMakerType);
            return this;
        }

        /**
         * This method is used to set the request maker for the api.
         * @param requestMakerType The request maker to set.
         * @return The builder so that calls can be chained.
         * @throws OutsetaInvalidRequestMakerException Thrown if the client
         *      cannot be built.
         */
        @Override
        public Builder requestMaker(final String requestMakerType)
                throws OutsetaInvalidRequestMakerException {
            super.requestMaker(requestMakerType);
            return this;
        }

        /**
         * This method is used to set the request maker for the api.
         * @param requestMaker The request maker to set.
         * @return The builder so that calls can be chained.
         * @throws OutsetaInvalidRequestMakerException Thrown if the client
         *      cannot be built.
         */
        @Override
        public Builder requestMaker(final RequestMaker requestMaker)
                throws OutsetaInvalidRequestMakerException {
            super.requestMaker(requestMaker);
            return this;
        }

        /**
         * This method is used to set the parser for the api.
         * @param parserFacade The parser to set.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *      built.
         */
        @Override
        public Builder parser(final ParserFacade parserFacade)
                throws OutsetaClientBuildException {
            super.parser(parserFacade);
            return this;
        }

        /**
         * This method is used to set the default parser for the api.
         * @return The builder so that calls can be chained.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *      built.
         */
        @Override
        public Builder defaultParser()
                throws OutsetaClientBuildException {
            super.defaultParser();
            return this;
        }

        /**
         * This method is used to set the default request maker for the api.
         * @return The builder so that calls can be chained.
         * @throws OutsetaInvalidRequestMakerException Thrown if the client
         *      cannot be built.
         */
        @Override
        public Builder defaultRequestMaker()
                throws OutsetaInvalidRequestMakerException {

            super.defaultRequestMaker();
            return this;
        }

        /**
         * This method is used to build the PeopleClient object.
         *
         * @return The PeopleClient object.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *                                     built.
         */
        @Override
        public PeopleClient build() throws OutsetaClientBuildException {
            return (PeopleClient) super.build();
        }
    }

    /**
     * This method is used to get a builder that can be used to build a
     * PeopleClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build a PeopleClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static Builder builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new Builder(baseUrl);
    }

    /**
     * Constructor is intentionally private to ensure that builder is used.
     *
     * @param baseUrl The base url for the api
     * @throws OutsetaClientBuildException Thrown if the client cannot be built
     */
    private PeopleClient(final String baseUrl)
            throws OutsetaClientBuildException {
        super(baseUrl);
    }

    /**
     * This method is used to get a person by id.
     *
     * @param personId The id of the person to get.
     * @return The person.
     * @throws OutsetaInvalidArgumentException Thrown if the person id is null.
     * @throws OutsetaParseException            Thrown if the person cannot be
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
     * PeopleClient client = PeopleClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String personId = "personId";
     * Person person = client.getPerson(personId);
     * }</pre>
     */
    public Person getPerson(final String personId)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (personId == null || personId.isBlank()) {
            throw new OutsetaInvalidArgumentException(
                    "Person id cannot be null.");
        }

        String result = this.get("/crm/people/" + personId,
                new HashMap<>());

        return this.getParserFacade().jsonStringToObject(result, Person.class);
    }

    /**
     * This method is used to get a page of Person objects.
     *
     * @param pageRequest The page request to use.
     * @return The list of people.
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
     * PeopleClient client = PeopleClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * PageRequest request = PageRequest.builder()
     *      .page(page)
     *      .pageSize(pageSize)
     *      .build();
     * int total = 0;
     * PersonPage personPage = null;
     *
     * do {
     *      // Keep making requests as long as there are more pages
     *      personPage = peopleClient.getPersonPage(request);
     *      total = personPage.getMetadata().getTotal();
     *
     *      // The current page's items are aggregated
     *      allPeople.addAll(personPage.getItems());
     *      request = request.nextPageRequest();
     * }
     * while (allPeople.size() < total);
     * }</pre>
     */
    public ItemPage<Person> getPersonPage(final PageRequest pageRequest)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException, OutsetaInvalidArgumentException {

        if (pageRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Page request cannot be null.");
        }

        HashMap<String, Object> params = new HashMap<>();
        if (pageRequest.getPageNum() != null) {
            params.put("offset", pageRequest.getPageNum().toString());
        }
        if (pageRequest.getPageSize() != null) {
            params.put("limit", pageRequest.getPageSize().toString());
        }

        String result = this.get("/crm/people", params);

        return this.getParserFacade()
                .jsonStringToPage(result,
                        Person.class);
    }

    /**
     * This method is used to create a person.
     *
     * @param personRequest The person to create.
     * @return The created person.
     * @throws OutsetaInvalidArgumentException Thrown if the person request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the person cannot be
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
     * PeopleClient client = PeopleClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Person personRequest = new Person();
     * Person person = client.createPerson(personRequest);
     * }</pre>
     */
    public Person createPerson(final Person personRequest)
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

    /**
     * This method is used to update a person.
     *
     * @param personId      The id of the person to update.
     * @param personRequest The person to update.
     * @return The updated person.
     * @throws OutsetaInvalidArgumentException Thrown if the person id is null
     *                                          or if the person request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the person cannot be
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
     * PeopleClient client = PeopleClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String personId = "personId";
     * Person personRequest = new Person();
     * Person person = client.updatePerson(personId, personRequest);
     * }</pre>
     */
    public Person updatePerson(final String personId,
                               final Person personRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (personId == null || personId.isBlank()) {
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

    /**
     * This method is used to delete a person.
     *
     * @param personId The id of the person to delete.
     * @throws OutsetaInvalidArgumentException Thrown if the person id is null.
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
     * PeopleClient client = PeopleClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String personId = "personId";
     * client.deletePerson(personId);
     * }</pre>
     */
    public void deletePerson(final String personId)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (personId == null || personId.isBlank()) {
            throw new OutsetaInvalidArgumentException(
                    "Person id cannot be null.");
        }

        this.delete("/crm/people/" + personId, new HashMap<>());
    }

    /**
     * This method is used to set a temporary password for a person.
     *
     * @param personId                  The id of the person to set the
     *                                  temporary password for.
     * @param temporaryPasswordRequest  The temporary password request to use.
     * @throws OutsetaInvalidArgumentException Thrown if the person id is null
     *                                          or if the temporary password
     *                                          request is null.
     * @throws OutsetaParseException            Thrown if the temporary
     *                                          password request cannot be
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
     * PeopleClient client = PeopleClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String personId = "personId";
     * TemporaryPasswordRequest temporaryPasswordRequest =
     *      new TemporaryPasswordRequest();
     * client.setTemporaryPassword(personId, temporaryPasswordRequest);
     * }</pre>
     */
    public void setTemporaryPassword(final String personId,
                                     final TemporaryPasswordRequest
                                             temporaryPasswordRequest)
            throws OutsetaInvalidArgumentException, OutsetaParseException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException {

        if (temporaryPasswordRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Temporary password request cannot be null.");
        }

        if (personId == null || personId.isBlank()) {
            throw new OutsetaInvalidArgumentException(
                    "Person id cannot be null.");
        }

        this.put("/crm/people/" + personId + "/setTemporaryPassword",
                new HashMap<>(), this.getParserFacade()
                        .objectToJsonString(temporaryPasswordRequest));
    }

}
