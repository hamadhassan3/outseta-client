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
import com.outseta.model.request.TemporaryPasswordRequest;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Person;

import java.util.HashMap;

/**
 * This class is used to make calls to the People endpoints of the CRM API.
 * <p>
 *     The People endpoints are used to manage the people in your CRM. The class
 *     provides a builder to make it easier to construct the client.
 * </p>
 */
public final class PeopleClient extends BaseClient {

    /**
     * This method is used to get a builder that can be used to build a
     * PeopleClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build a PeopleClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static ClientBuilder<PeopleClient> builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new ClientBuilder<>(new PeopleClient(baseUrl));
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
                    "Person id cannot be null or blank.");
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
     * ItemPage<Person> personPage = null;
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

        String result = this.get("/crm/people",
                pageRequest.buildParams());

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
                    "Person id cannot be null or blank.");
        }

        if (personRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Person request cannot be null.");
        }

        String result = this.put("/crm/people/" + personId,
                new HashMap<>(),
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
                    "Person id cannot be null or blank.");
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
                    "Person id cannot be null or blank.");
        }

        this.put("/crm/people/" + personId + "/setTemporaryPassword",
                new HashMap<>(), this.getParserFacade()
                        .objectToJsonString(temporaryPasswordRequest));
    }

}
