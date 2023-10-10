package com.outseta.client.endpoint_client.crm;

import com.outseta.client.ClientBuilder;
import com.outseta.client_helper.parser.json.JsonParser;
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
import com.outseta.model.result.Metadata;
import com.outseta.model.result.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class tests the PeopleClient class.
 */
@ExtendWith(MockitoExtension.class)
public class PeopleClientUnitTest {

    /**
     * The Outseta URL used for testing.
     */
    private static final String OUTSETA_URL = "https://dummy.com";

    /**
     * The Outseta Key used for testing.
     */
    private static final String OUTSETA_KEY = "dummyKey";

    /**
     * The ParserFacade object used for testing.
     */
    @Mock
    private ParserFacade parserFacade;

    /**
     * The JsonParser object used for testing.
     */
    @Mock
    private JsonParser jsonParser;

    /**
     * The RequestMaker object used for testing.
     */
    @Mock
    private RequestMaker requestMaker;

    /**
     * The PeopleClient object used for testing.
     */
    private PeopleClient peopleClient;

    /**
     * Dummy id of a test person.
     */
    private String personId;

    /**
     * Dummy string of a test person.
     */
    private String personStr;

    /**
     * Dummy object of a test person.
     */
    private Person personObj;

    /**
     * Dummy headers of a test person.
     */
    private HashMap<String, String> headers;

    /**
     * This method sets up the test environment.
     */
    @BeforeEach
    public void setup() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException {

        personId = "123";
        personStr = "{\"Uid\": \"123\", \"firstName\": \"John\""
                + ", \"lastName\": \"Doe\"}";
        personObj = Person.builder()
                .uid("123")
                .firstName("John")
                .lastName("Doe")
                .build();

        headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + OUTSETA_KEY);

        when(parserFacade.getJsonParser()).thenReturn(jsonParser);

        peopleClient = PeopleClient.builder(OUTSETA_URL)
                .apiKey(OUTSETA_KEY)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .build();
        peopleClient.replaceHeaders(headers);
    }

    /**
     * This method tests the builder of the PeopleClient class.
     */
    @Test
    public void testBuilder() {

        assertDoesNotThrow(() -> {
            ClientBuilder<PeopleClient> test = PeopleClient
                    .builder(OUTSETA_URL);
            assertEquals(test, test.apiKey(OUTSETA_KEY));
            assertEquals(test, test.defaultParser());
            assertEquals(test, test.defaultRequestMaker());

            PeopleClient peopleClient1 = test.build();

            assertNotNull(peopleClient1);
        });

        assertDoesNotThrow(() -> {

            ClientBuilder<PeopleClient> test =
                    PeopleClient.builder(OUTSETA_URL);

            assertEquals(test, test.apiKey(OUTSETA_KEY));
            assertEquals(test, test.accessKey(OUTSETA_KEY));
            assertEquals(test, test.parser(parserFacade));
            assertEquals(test, test.baseUrl(OUTSETA_URL));
            assertEquals(test, test.requestMaker("DEFAULT"));
            assertEquals(test, test.headers(
                    Map.of("Authorization", "dummy")));
            assertEquals(test, test.requestMaker(RequestMakerType.DEFAULT));

            PeopleClient peopleClient1 = test.build();

            assertNotNull(peopleClient1);
        });
    }

    /**
     * This method tests the failure scenario of the builder method
     * of the PeopleClient class.
     */
    @Test
    public void testBuilderFailure() {

        // Testing empty object
        assertThrows(OutsetaClientBuildException.class, () ->
                PeopleClient.builder(null)
        );
        assertThrows(OutsetaClientBuildException.class, () ->
                PeopleClient.builder("")
        );

        // Testing null outsetaUrl but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                PeopleClient.builder(null)
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing empty outsetaUrl but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                PeopleClient.builder("")
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing null Outseta Key but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                PeopleClient.builder(OUTSETA_URL)
                        .apiKey(null)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing empty Outseta Key but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                PeopleClient.builder(OUTSETA_URL)
                        .apiKey("")
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing without parser but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                PeopleClient.builder(OUTSETA_URL)
                        .apiKey(OUTSETA_KEY)
                        .defaultRequestMaker()
                        .build()
        );

        // Testing without request maker but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                PeopleClient.builder(OUTSETA_URL)
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .build()
        );
    }

    /**
     * This method tests the getPerson method of the people client.
     */
    @Test
    public void testGetPerson() {

        // Making the request.
        assertDoesNotThrow(() -> {

            when(requestMaker.get(OUTSETA_URL + "/crm/people/123",
                    new HashMap<>(), headers))
                    .thenReturn(personStr);
            when(parserFacade.jsonStringToObject(personStr, Person.class))
                    .thenReturn(personObj);

            Person result = peopleClient.getPerson(personId);

            assertNotNull(result);
            assertEquals(personObj.getUid(), result.getUid());
            assertEquals(personObj.getFirstName(), result.getFirstName());
            assertEquals(personObj.getLastName(), result.getLastName());
        });

    }

    /**
     * Tests the scenario when the personId is null or empty.
     */
    @Test
    public void testGetPersonWithInvalidId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> peopleClient.getPerson(null));
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> peopleClient.getPerson(""));
    }

    /**
     * Tests the scenario when an invalid response code is encountered.
     */
    @Test
    public void testGetPersonWithInvalidResponseCode()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException {
        when(requestMaker.get(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), headers))
                .thenThrow(OutsetaInvalidResponseCodeException.class);
        assertThrows(OutsetaInvalidResponseCodeException.class,
                () -> peopleClient.getPerson(personId));
    }

    /**
     * Tests the scenario when an invalid URL is encountered.
     */
    @Test
    public void testGetPersonWithInvalidUrl()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException {
        when(requestMaker.get(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), headers))
                .thenThrow(OutsetaInvalidURLException.class);
        assertThrows(OutsetaInvalidURLException.class,
                () -> peopleClient.getPerson(personId));
    }

    // Similar breakdowns for other exceptions...

    /**
     * Tests the scenario when the parser throws an exception.
     */
    @Test
    public void testGetPersonWithParserException()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        when(requestMaker.get(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), headers))
                .thenReturn(personStr);
        when(parserFacade.jsonStringToObject(personStr, Person.class))
                .thenThrow(OutsetaParseException.class);
        assertThrows(OutsetaParseException.class,
                () -> peopleClient.getPerson(personId));
    }

    /**
     * This method tests the createPerson method of the people client.
     */
    @Test
    public void testCreatePerson() {

        assertDoesNotThrow(() -> {
            when(requestMaker.post(OUTSETA_URL + "/crm/people",
                    new HashMap<>(), personStr, headers))
                    .thenReturn(personStr);
            when(parserFacade.objectToJsonString(personObj))
                    .thenReturn(personStr);

            when(parserFacade.jsonStringToObject(personStr, Person.class))
                    .thenReturn(personObj);

            // Making the request.
            Person result = peopleClient.createPerson(personObj);

            // Comparing against expected results
            assertNotNull(result);
            assertEquals(personObj.getUid(), result.getUid());
            assertEquals(personObj.getFirstName(), result.getFirstName());
            assertEquals(personObj.getLastName(), result.getLastName());
        });
    }

    /**
     * Tests the scenario when the person is null.
     */
    @Test
    public void testCreatePersonWithNullPerson() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> peopleClient.createPerson(null));
    }

    /**
     * Tests the scenario with invalid response code.
     */
    @Test
    public void testCreatePersonWithInvalidResponseCode()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        when(requestMaker.post(OUTSETA_URL + "/crm/people",
                new HashMap<>(), personStr, headers))
                .thenThrow(OutsetaInvalidResponseCodeException.class);
        when(parserFacade.objectToJsonString(personObj))
                .thenReturn(personStr);
        assertThrows(OutsetaInvalidResponseCodeException.class,
                () -> peopleClient.createPerson(personObj));
    }

    /**
     * Tests the scenario with invalid URL.
     */
    @Test
    public void testCreatePersonWithInvalidUrl()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        when(requestMaker.post(OUTSETA_URL + "/crm/people",
                new HashMap<>(), personStr, headers))
                .thenThrow(OutsetaInvalidURLException.class);
        when(parserFacade.objectToJsonString(personObj))
                .thenReturn(personStr);
        assertThrows(OutsetaInvalidURLException.class,
                () -> peopleClient.createPerson(personObj));
    }

    /**
     * Tests the scenario with bad request.
     */
    @Test
    public void testCreatePersonWithBadRequest()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        when(requestMaker.post(OUTSETA_URL + "/crm/people",
                new HashMap<>(), personStr, headers))
                .thenThrow(OutsetaAPIBadRequestException.class);
        when(parserFacade.objectToJsonString(personObj))
                .thenReturn(personStr);
        assertThrows(OutsetaAPIBadRequestException.class,
                () -> peopleClient.createPerson(personObj));
    }

    /**
     * Tests the scenario with failed request.
     */
    @Test
    public void testCreatePersonWithFailedRequest()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        when(requestMaker.post(OUTSETA_URL + "/crm/people",
                new HashMap<>(), personStr, headers))
                .thenThrow(OutsetaAPIFailedException.class);
        when(parserFacade.objectToJsonString(personObj))
                .thenReturn(personStr);
        assertThrows(OutsetaAPIFailedException.class,
                () -> peopleClient.createPerson(personObj));
    }

    /**
     * Tests the scenario with unknown exception.
     */
    @Test
    public void testCreatePersonWithUnknownException()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        when(requestMaker.post(OUTSETA_URL + "/crm/people",
                new HashMap<>(), personStr, headers))
                .thenThrow(OutsetaAPIUnknownException.class);
        when(parserFacade.objectToJsonString(personObj))
                .thenReturn(personStr);
        assertThrows(OutsetaAPIUnknownException.class,
                () -> peopleClient.createPerson(personObj));
    }

    /**
     * Tests the scenario with parser exception.
     */
    @Test
    public void testCreatePersonWithParserException()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        when(requestMaker.post(OUTSETA_URL + "/crm/people",
                new HashMap<>(), personStr, headers))
                .thenReturn(personStr);
        when(parserFacade.objectToJsonString(personObj))
                .thenReturn(personStr);
        when(parserFacade.jsonStringToObject(personStr, Person.class))
                .thenThrow(OutsetaParseException.class);
        assertThrows(OutsetaParseException.class,
                () -> peopleClient.createPerson(personObj));
    }

    /**
     * This method tests the updatePerson method of the people client.
     */
    @Test
    public void testUpdatePerson() {

        assertDoesNotThrow(() -> {
            when(requestMaker.put(OUTSETA_URL + "/crm/people/123",
                    new HashMap<>(), personStr, headers))
                    .thenReturn(personStr);
            when(parserFacade.objectToJsonString(personObj))
                    .thenReturn(personStr);

            when(parserFacade.jsonStringToObject(personStr, Person.class))
                    .thenReturn(personObj);

            // Making the request.
            Person result = peopleClient.updatePerson(personId, personObj);

            // Comparing against expected results
            assertNotNull(result);
            assertEquals(personObj.getUid(), result.getUid());
            assertEquals(personObj.getFirstName(), result.getFirstName());
            assertEquals(personObj.getLastName(), result.getLastName());
        });
    }

    /**
     * Tests the scenario when the personId is null or empty.
     */
    @Test
    public void testUpdatePersonWithInvalidId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> peopleClient.updatePerson(null, personObj));
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> peopleClient.updatePerson("", personObj));
    }

    /**
     * Tests the scenario when the person is null.
     */
    @Test
    public void testUpdatePersonWithNullPerson() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> peopleClient.updatePerson(personId, null));
    }

    /**
     * Tests the scenario with invalid response code.
     */
    @Test
    public void testUpdatePersonWithInvalidResponseCode()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        when(requestMaker.put(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), personStr, headers))
                .thenThrow(OutsetaInvalidResponseCodeException.class);
        when(parserFacade.objectToJsonString(personObj))
                .thenReturn(personStr);
        assertThrows(OutsetaInvalidResponseCodeException.class,
                () -> peopleClient.updatePerson(personId, personObj));
    }

    /**
     * Tests the scenario with invalid URL.
     */
    @Test
    public void testUpdatePersonWithInvalidUrl()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        when(requestMaker.put(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), personStr, headers))
                .thenThrow(OutsetaInvalidURLException.class);
        when(parserFacade.objectToJsonString(personObj))
                .thenReturn(personStr);
        assertThrows(OutsetaInvalidURLException.class,
                () -> peopleClient.updatePerson(personId, personObj));
    }

    /**
     * Tests the scenario with bad request.
     */
    @Test
    public void testUpdatePersonWithBadRequest()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        when(requestMaker.put(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), personStr, headers))
                .thenThrow(OutsetaAPIBadRequestException.class);
        when(parserFacade.objectToJsonString(personObj))
                .thenReturn(personStr);
        assertThrows(OutsetaAPIBadRequestException.class,
                () -> peopleClient.updatePerson(personId, personObj));
    }

    /**
     * Tests the scenario with failed request.
     */
    @Test
    public void testUpdatePersonWithFailedRequest()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        when(requestMaker.put(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), personStr, headers))
                .thenThrow(OutsetaAPIFailedException.class);
        when(parserFacade.objectToJsonString(personObj))
                .thenReturn(personStr);
        assertThrows(OutsetaAPIFailedException.class,
                () -> peopleClient.updatePerson(personId, personObj));
    }

    /**
     * Tests the scenario with unknown exception.
     */
    @Test
    public void testUpdatePersonWithUnknownException()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        when(requestMaker.put(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), personStr, headers))
                .thenThrow(OutsetaAPIUnknownException.class);
        when(parserFacade.objectToJsonString(personObj))
                .thenReturn(personStr);
        assertThrows(OutsetaAPIUnknownException.class,
                () -> peopleClient.updatePerson(personId, personObj));
    }

    /**
     * Tests the scenario with parser exception.
     */
    @Test
    public void testUpdatePersonWithParserException()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException {
        when(requestMaker.put(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), personStr, headers))
                .thenReturn(personStr);
        when(parserFacade.objectToJsonString(personObj))
                .thenReturn(personStr);
        when(parserFacade.jsonStringToObject(personStr, Person.class))
                .thenThrow(OutsetaParseException.class);
        assertThrows(OutsetaParseException.class,
                () -> peopleClient.updatePerson(personId, personObj));
    }

    /**
     * This method tests the deletePerson method of the people client.
     */
    @Test
    public void testDeletePerson() {

        assertDoesNotThrow(() -> {
            when(requestMaker.delete(OUTSETA_URL + "/crm/people/123",
                    new HashMap<>(), headers))
                    .thenReturn("success");

            // Making the request.
            peopleClient.deletePerson(personId);

        });
    }

    /**
     * Tests the scenario when the personId is null or empty.
     */
    @Test
    public void testDeletePersonWithInvalidId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> peopleClient.deletePerson(null));
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> peopleClient.deletePerson(""));
    }

    /**
     * Tests the scenario with invalid response code.
     */
    @Test
    public void testDeletePersonWithInvalidResponseCode()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException {
        when(requestMaker.delete(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), headers))
                .thenThrow(OutsetaInvalidResponseCodeException.class);
        assertThrows(OutsetaInvalidResponseCodeException.class,
                () -> peopleClient.deletePerson(personId));
    }

    /**
     * Tests the scenario with invalid URL.
     */
    @Test
    public void testDeletePersonWithInvalidUrl()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException {
        when(requestMaker.delete(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), headers))
                .thenThrow(OutsetaInvalidURLException.class);
        assertThrows(OutsetaInvalidURLException.class,
                () -> peopleClient.deletePerson(personId));
    }

    /**
     * Tests the scenario with bad request.
     */
    @Test
    public void testDeletePersonWithBadRequest()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException {
        when(requestMaker.delete(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), headers))
                .thenThrow(OutsetaAPIBadRequestException.class);
        assertThrows(OutsetaAPIBadRequestException.class,
                () -> peopleClient.deletePerson(personId));
    }

    /**
     * Tests the scenario with failed request.
     */
    @Test
    public void testDeletePersonWithFailedRequest()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException {
        when(requestMaker.delete(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), headers))
                .thenThrow(OutsetaAPIFailedException.class);
        assertThrows(OutsetaAPIFailedException.class,
                () -> peopleClient.deletePerson(personId));
    }

    /**
     * Tests the scenario with unknown exception.
     */
    @Test
    public void testDeletePersonWithUnknownException()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException {
        when(requestMaker.delete(OUTSETA_URL + "/crm/people/123",
                new HashMap<>(), headers))
                .thenThrow(OutsetaAPIUnknownException.class);
        assertThrows(OutsetaAPIUnknownException.class,
                () -> peopleClient.deletePerson(personId));
    }

    /**
     * This method tests the setTemporaryPassword method of the people client.
     */
    @Test
    public void testSetTemporaryPassword() {

        assertDoesNotThrow(() -> {

            // Making the request.
            peopleClient.setTemporaryPassword(personId,
                    TemporaryPasswordRequest.builder()
                            .temporaryPassword("123")
                            .build());

        });
    }

    /**
     * Tests the scenario when the personId is null or empty.
     */
    @Test
    public void testSetTemporaryPasswordWithInvalidId() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> peopleClient.setTemporaryPassword(null,
                        TemporaryPasswordRequest.builder()
                                .temporaryPassword("123")
                                .build()));
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> peopleClient.setTemporaryPassword("",
                        TemporaryPasswordRequest.builder()
                                .temporaryPassword("123")
                                .build()));
    }

    /**
     * Tests the scenario when the request is null.
     */
    @Test
    public void testSetTemporaryPasswordWithNullRequest() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> peopleClient.setTemporaryPassword(personId,
                        null));
    }

    /**
     * Tests the scenario with invalid response code.
     */
    @Test
    public void testSetTemporaryPasswordWithInvalidResponseCode()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaParseException {
        when(requestMaker.put(OUTSETA_URL
                        + "/crm/people/123/setTemporaryPassword",
                new HashMap<>(), "{\"TemporaryPassword\": \"123\"}",
                headers))
                .thenThrow(OutsetaInvalidResponseCodeException.class);
        TemporaryPasswordRequest request = TemporaryPasswordRequest.builder()
                .temporaryPassword("123")
                .build();
        when(parserFacade.objectToJsonString(request))
                .thenReturn("{\"TemporaryPassword\": \"123\"}");
        assertThrows(OutsetaInvalidResponseCodeException.class,
                () -> peopleClient.setTemporaryPassword(personId,
                        request));
    }

    /**
     * Tests the scenario with invalid URL.
     */
    @Test
    public void testSetTemporaryPasswordWithInvalidUrl()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaParseException {
        when(requestMaker.put(OUTSETA_URL
                        + "/crm/people/123/setTemporaryPassword",
                new HashMap<>(), "{\"TemporaryPassword\": \"123\"}",
                headers))
                .thenThrow(OutsetaInvalidURLException.class);
        TemporaryPasswordRequest request = TemporaryPasswordRequest.builder()
                .temporaryPassword("123")
                .build();
        when(parserFacade.objectToJsonString(request))
                .thenReturn("{\"TemporaryPassword\": \"123\"}");
        assertThrows(OutsetaInvalidURLException.class,
                () -> peopleClient.setTemporaryPassword(personId,
                        request));
    }

    /**
     * Tests the scenario with bad request.
     */
    @Test
    public void testSetTemporaryPasswordWithBadRequest()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaParseException {
        when(requestMaker.put(OUTSETA_URL
                        + "/crm/people/123/setTemporaryPassword",
                new HashMap<>(), "{\"TemporaryPassword\": \"123\"}",
                headers))
                .thenThrow(OutsetaAPIBadRequestException.class);
        TemporaryPasswordRequest request = TemporaryPasswordRequest.builder()
                .temporaryPassword("123")
                .build();
        when(parserFacade.objectToJsonString(request))
                .thenReturn("{\"TemporaryPassword\": \"123\"}");
        assertThrows(OutsetaAPIBadRequestException.class,
                () -> peopleClient.setTemporaryPassword(personId,
                        request));
    }

    /**
     * Tests the scenario with failed request.
     */
    @Test
    public void testSetTemporaryPasswordWithFailedRequest()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaParseException {
        when(requestMaker.put(OUTSETA_URL
                        + "/crm/people/123/setTemporaryPassword",
                new HashMap<>(), "{\"TemporaryPassword\": \"123\"}",
                headers))
                .thenThrow(OutsetaAPIFailedException.class);
        TemporaryPasswordRequest request = TemporaryPasswordRequest.builder()
                .temporaryPassword("123")
                .build();
        when(parserFacade.objectToJsonString(request))
                .thenReturn("{\"TemporaryPassword\": \"123\"}");
        assertThrows(OutsetaAPIFailedException.class,
                () -> peopleClient.setTemporaryPassword(personId,
                        request));
    }

    /**
     * Tests the scenario with unknown exception.
     */
    @Test
    public void testSetTemporaryPasswordWithUnknownException()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaParseException {
        when(requestMaker.put(OUTSETA_URL
                        + "/crm/people/123/setTemporaryPassword",
                new HashMap<>(), "{\"TemporaryPassword\": \"123\"}",
                headers))
                .thenThrow(OutsetaAPIUnknownException.class);
        TemporaryPasswordRequest request = TemporaryPasswordRequest.builder()
                .temporaryPassword("123")
                .build();
        when(parserFacade.objectToJsonString(request))
                .thenReturn("{\"TemporaryPassword\": \"123\"}");
        assertThrows(OutsetaAPIUnknownException.class,
                () -> peopleClient.setTemporaryPassword(personId,
                        request));
    }

    /**
     * Tests the scenario with parser exception.
     */
    @Test
    public void testSetTemporaryPasswordWithParserException()
            throws OutsetaParseException {
        TemporaryPasswordRequest request = TemporaryPasswordRequest.builder()
                .temporaryPassword("123")
                .build();
        when(parserFacade.objectToJsonString(request))
                .thenThrow(OutsetaParseException.class);
        assertThrows(OutsetaParseException.class,
                () -> peopleClient.setTemporaryPassword(personId,
                        request));
    }

    /**
     * This method tests the getPersonPage method of the people client.
     */
    @Test
    public void testGetPersonPage() {

        assertDoesNotThrow(() -> {

            Map<String, Object> params = new HashMap<>();

            params.put("offset", "0");
            params.put("limit", "1");

            ItemPage<Person> itemPage = new ItemPage<Person>(
                    new Metadata(1, 0, 1),
                    List.of(personObj)
            );

            when(requestMaker.get(OUTSETA_URL + "/crm/people",
                    params, headers))
                    .thenReturn("result");

            // Mocking parser facade's jsonStringToPage method to return
            // an ItemPage of Person.
            when(parserFacade.jsonStringToPage("result", Person.class))
                    .thenReturn(itemPage);

            // Making the request.
            ItemPage<Person> result1 = peopleClient.getPersonPage(PageRequest
                    .builder()
                    .page(0)
                    .pageSize(1)
                    .build()
            );

            params.remove("offset");

            when(requestMaker.get(OUTSETA_URL + "/crm/people",
                    params, headers))
                    .thenReturn("result");

            ItemPage<Person> result2 = peopleClient.getPersonPage(PageRequest
                    .builder()
                    .pageSize(1)
                    .build()
            );

            params.put("offset", "0");
            params.remove("limit");

            when(requestMaker.get(OUTSETA_URL + "/crm/people",
                    params, headers))
                    .thenReturn("result");

            ItemPage<Person> result3 = peopleClient.getPersonPage(PageRequest
                    .builder()
                    .page(0)
                    .build()
            );

            params.remove("offset");

            when(requestMaker.get(OUTSETA_URL + "/crm/people",
                    params, headers))
                    .thenReturn("result");

            ItemPage<Person> result4 = peopleClient.getPersonPage(PageRequest
                    .builder()
                    .build()
            );

            // Comparing against expected results
            assertNotNull(result1);
            assertEquals(result1, itemPage);

            assertNotNull(result2);
            assertEquals(result2, itemPage);

            assertNotNull(result3);
            assertEquals(result2, itemPage);

            assertNotNull(result4);
            assertEquals(result2, itemPage);

        });
    }

    /**
     * Tests the scenario when the pageRequest is null.
     */
    @Test
    public void testGetPersonPageWithNullPageRequest() {
        assertThrows(OutsetaInvalidArgumentException.class,
                () -> peopleClient.getPersonPage(null));
    }

    /**
     * Tests the scenario with invalid response code.
     */
    @Test
    public void testGetPersonPageWithInvalidResponseCode()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaAPIUnknownException {
        Map<String, Object> params = new HashMap<>();

        params.put("offset", "0");
        params.put("limit", "1");

        // Mocking request maker's get method to return a string
        when(requestMaker.get(OUTSETA_URL + "/crm/people",
                params, headers))
                .thenThrow(OutsetaInvalidResponseCodeException.class);

        assertThrows(OutsetaInvalidResponseCodeException.class,
                () -> peopleClient.getPersonPage(PageRequest
                        .builder()
                        .page(0)
                        .pageSize(1)
                        .build()
                ));
    }

    /**
     * Tests the scenario with invalid URL.
     */
    @Test
    public void testGetPersonPageWithInvalidUrl()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaAPIUnknownException {
        Map<String, Object> params = new HashMap<>();

        params.put("offset", "0");
        params.put("limit", "1");

        // Mocking request maker's get method to return a string
        when(requestMaker.get(OUTSETA_URL + "/crm/people",
                params, headers))
                .thenThrow(OutsetaInvalidURLException.class);

        assertThrows(OutsetaInvalidURLException.class,
                () -> peopleClient.getPersonPage(PageRequest
                        .builder()
                        .page(0)
                        .pageSize(1)
                        .build()
                ));
    }

    /**
     * Tests the scenario with bad request.
     */
    @Test
    public void testGetPersonPageWithBadRequest()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaAPIUnknownException {
        Map<String, Object> params = new HashMap<>();

        params.put("offset", "0");
        params.put("limit", "1");

        // Mocking request maker's get method to return a string
        when(requestMaker.get(OUTSETA_URL + "/crm/people",
                params, headers))
                .thenThrow(OutsetaAPIBadRequestException.class);

        assertThrows(OutsetaAPIBadRequestException.class,
                () -> peopleClient.getPersonPage(PageRequest
                        .builder()
                        .page(0)
                        .pageSize(1)
                        .build()
                ));
    }

    /**
     * Tests the scenario with failed request.
     */
    @Test
    public void testGetPersonPageWithFailedRequest()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaAPIUnknownException {
        Map<String, Object> params = new HashMap<>();

        params.put("offset", "0");
        params.put("limit", "1");

        // Mocking request maker's get method to return a string
        when(requestMaker.get(OUTSETA_URL + "/crm/people",
                params, headers))
                .thenThrow(OutsetaAPIFailedException.class);

        assertThrows(OutsetaAPIFailedException.class,
                () -> peopleClient.getPersonPage(PageRequest
                        .builder()
                        .page(0)
                        .pageSize(1)
                        .build()
                ));
    }

    /**
     * Tests the scenario with unknown exception.
     */
    @Test
    public void testGetPersonPageWithUnknownException()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaAPIUnknownException {
        Map<String, Object> params = new HashMap<>();

        params.put("offset", "0");
        params.put("limit", "1");

        // Mocking request maker's get method to return a string
        when(requestMaker.get(OUTSETA_URL + "/crm/people",
                params, headers))
                .thenThrow(OutsetaAPIUnknownException.class);

        assertThrows(OutsetaAPIUnknownException.class,
                () -> peopleClient.getPersonPage(PageRequest
                        .builder()
                        .page(0)
                        .pageSize(1)
                        .build()
                ));
    }

    /**
     * Tests the scenario with parser exception.
     */
    @Test
    public void testGetPersonPageWithParserException()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaParseException {
        Map<String, Object> params = new HashMap<>();

        params.put("offset", "0");
        params.put("limit", "1");

        // Mocking request maker's get method to return a string
        when(requestMaker.get(OUTSETA_URL + "/crm/people",
                params, headers))
                .thenReturn("result");

        // Mocking parser facade's jsonStringToPage method to throw
        // an exception.
        when(parserFacade.jsonStringToPage("result", Person.class))
                .thenThrow(OutsetaParseException.class);

        assertThrows(OutsetaParseException.class,
                () -> peopleClient.getPersonPage(PageRequest
                        .builder()
                        .page(0)
                        .pageSize(1)
                        .build()
                ));
    }
}
