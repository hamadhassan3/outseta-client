package com.outseta.client.endpoint_client.crm.integration;

import com.outseta.client.endpoint_client.crm.PeopleClient;
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
import com.outseta.model.result.Address;
import com.outseta.model.result.Person;
import com.outseta.model.result.ItemPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class tests the PeopleClient class.
 * These are integration tests as no object is mocked and the
 * tests are run with the actual API.
 */
@Tag("integration")
@ExtendWith(MockitoExtension.class)
class PeopleClientIntegrationTest {

    /**
     * The Outseta API Key.
     */
    private static String outsetaKey = System.getenv("OUTSETA_KEY");

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");

    /**
     * The PeopleClient object that will be making all requests.
     */
    private PeopleClient peopleClient;

    /**
     * The Person object that will be used to make requests.
     */
    private Person personRequest;

    /**
     * The MailingAddress object that will be used to make requests.
     */
    private Address address;

    /**
     * The MailingAddress object that will be used to make update request.
     */
    private Address updatedAddress;

    /**
     * The Person object that will be used to make update requests.
     */
    private Person updatedPerson;

    /**
     * The Person object that will be used to test apis.
     */
    private Person createdPerson;

    /**
     * This method sets up the PeopleClient object that will be used to make
     * requests.
     * @throws OutsetaClientBuildException This exception is thrown if the
     *      PeopleClient object cannot be created.
     */
    @BeforeEach
    public void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaParseException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {
        peopleClient = PeopleClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();

        address = Address.builder()
                .addressLine1("address line 1")
                .addressLine2("address line 2")
                .addressLine3("address line 3")
                .city("city")
                .country("country")
                .build();

        personRequest = Person.builder()
                .email("hammad-test-outseta-client@outseta-client.com")
                .firstName("hammad-outseta")
                .lastName("hammad-client")
                .mailingAddress(address)
                .build();

        updatedAddress = Address.builder()
                .addressLine1("updated address line 1")
                .addressLine2("updated address line 2")
                .addressLine3("updated address line 3")
                .city("updated city")
                .country("updated country")
                .build();

        updatedPerson = Person.builder()
                .email("updated-outseta-client@outseta-client.com")
                .firstName("updated-outseta")
                .lastName("updated-client")
                .mailingAddress(updatedAddress)
                .build();

        createdPerson = peopleClient.createPerson(personRequest);
    }

    /**
     * This method cleans up after each test.
     */
    @AfterEach
    public void tearDown() throws
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {
        peopleClient.deletePerson(createdPerson.getUid());
    }

    /**
     * This test tests the getPerson method of the PeopleClient class.
     * It tests the success scenario.
     */
    @Test
    public void testGetPerson() {

        assertDoesNotThrow(() -> {
            // Create a person
            Person person = peopleClient.getPerson(createdPerson.getUid());

            assertNotNull(person);
        });
    }

    /**
     * This test tests the getPerson method of the PeopleClient class.
     * It tests the failure scenario.
     */
    @Test
    public void testGetPersonFailure() {

        assertThrows(OutsetaInvalidArgumentException.class, () ->
                peopleClient.getPerson(null)
        );
    }

    /**
     * This test tests the getPersonPage method of the PeopleClient class.
     * It tests the success scenario.
     */
    @Test
    public void getAllPerson() {

        final int page = 0;
        final int pageSize = 25;

        List<Person> allPeople = new ArrayList<>();

        assertDoesNotThrow(() -> {
            PageRequest request = PageRequest.builder()
                    .page(page)
                    .pageSize(pageSize)
                    .build();

            int total = 0;
            ItemPage<Person> itemPage = null;
            final int maxSize = 100;
            do {
                // Keep making requests as long as there are more pages
                itemPage = peopleClient.getPersonPage(request);
                total = itemPage.getMetadata().getTotal();

                assertNotNull(itemPage);

                // The current page's items are aggregated
                allPeople.addAll(itemPage.getItems());

                assertEquals(
                        (request.getPageSize() * request.getPageNum())
                                + itemPage.getItems().size(),
                        allPeople.size());

                request = request.nextPageRequest();

            }
            while (allPeople.size() < total && allPeople.size() < maxSize);

            // assertEquals(total, allPeople.size());
        });
    }

    /**
     * This method tests the createPerson method of the PeopleClient class.
     * It tests the success scenario.
     */
    @Test
    public void testCreatePerson() {


        assertDoesNotThrow(() -> {
            assertEquals(personRequest.getEmail(), createdPerson.getEmail());
            assertEquals(personRequest.getFirstName(),
                    createdPerson.getFirstName());
            assertEquals(personRequest.getLastName(),
                    createdPerson.getLastName());
            assertEquals(personRequest.getAddress().getAddressLine1(),
                    createdPerson.getAddress().getAddressLine1());
            assertEquals(personRequest.getAddress().getAddressLine2(),
                    createdPerson.getAddress().getAddressLine2());
            assertEquals(personRequest.getAddress().getAddressLine3(),
                    createdPerson.getAddress().getAddressLine3());
            assertEquals(personRequest.getAddress().getCity(),
                    createdPerson.getAddress().getCity());
            assertEquals(personRequest.getAddress().getCountry(),
                    createdPerson.getAddress().getCountry());
        });
    }

    /**
     * This method tests the createPerson method of the PeopleClient class.
     * It tests the failure scenario.
     */
    @Test
    public void testCreatePersonFailure() {

        assertThrows(OutsetaInvalidArgumentException.class, () ->
                peopleClient.createPerson(null)
        );
    }

    /**
     * This method tests the updatePerson method of the PeopleClient class.
     * It tests the success scenario.
     */
    @Test
    public void testUpdatePerson() {

        assertDoesNotThrow(() -> {
            Person updatedPersonActual = peopleClient
                    .updatePerson(createdPerson.getUid(), updatedPerson);
            assertEquals(updatedPerson.getEmail(),
                    updatedPersonActual.getEmail());
            assertEquals(updatedPerson.getFirstName(),
                    updatedPersonActual.getFirstName());
            assertEquals(updatedPerson.getLastName(),
                    updatedPersonActual.getLastName());
            assertEquals(updatedPerson.getAddress().getAddressLine1(),
                    updatedPersonActual.getAddress().getAddressLine1());
            assertEquals(updatedPerson.getAddress().getAddressLine2(),
                    updatedPersonActual.getAddress().getAddressLine2());
            assertEquals(updatedPerson.getAddress().getAddressLine3(),
                    updatedPersonActual.getAddress().getAddressLine3());
            assertEquals(updatedPerson.getAddress().getCity(),
                    updatedPersonActual.getAddress().getCity());
            assertEquals(updatedPerson.getAddress().getCountry(),
                    updatedPersonActual.getAddress().getCountry());

        });
    }

    /**
     * This method tests the updatePerson method of the PeopleClient class.
     * It tests the failure scenario.
     */
    @Test
    public void testUpdatePersonFailure() {

        // Test first param null
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                peopleClient.updatePerson(null, updatedPerson)
        );

        // Test second param null
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                peopleClient.updatePerson("test", null)
        );

        // Test both params null
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                peopleClient.updatePerson(null, null)
        );
    }

    /**
     * This method tests the deletePerson method of the PeopleClient class.
     * It tests the failure scenario.
     */
    @Test
    public void testDeletePersonFailure() {

        assertThrows(OutsetaInvalidArgumentException.class, () ->
                peopleClient.deletePerson(null)
        );
    }

    /**
     * This method tests the setTemporaryPassword method of the
     * PeopleClient class.
     */
    @Test
    public void testSetTemporaryPassword() {

        TemporaryPasswordRequest temporaryPasswordRequest =
                TemporaryPasswordRequest.builder()
                        .temporaryPassword("temporaryPassword")
                        .build();

        assertDoesNotThrow(() -> {
            peopleClient.setTemporaryPassword(createdPerson.getUid(),
                    temporaryPasswordRequest);
        });
    }

    /**
     * This method tests the setTemporaryPassword method of the
     * PeopleClient class.
     * It tests the failure scenario.
     */
    @Test
    public void testSetTemporaryPasswordFailure() {

        TemporaryPasswordRequest temporaryPasswordRequest =
                TemporaryPasswordRequest.builder()
                        .temporaryPassword("temporaryPassword")
                        .build();

        // Test first param null
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                peopleClient.setTemporaryPassword(null,
                        temporaryPasswordRequest)
        );

        // Test second param null
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                peopleClient.setTemporaryPassword("test",
                        null)
        );

        // Test both params null
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                peopleClient.setTemporaryPassword(null,
                        null)
        );
    }
}
