package com.outseta.client.endpoint_client.crm;

import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.model.request.PageRequest;
import com.outseta.model.request.TemporaryPasswordRequest;
import com.outseta.model.result.MailingAddress;
import com.outseta.model.result.Person;
import com.outseta.model.result.ItemPage;
import org.junit.jupiter.api.BeforeAll;
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
@ExtendWith(MockitoExtension.class)
class PeopleClientTest {

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
    private static PeopleClient peopleClient;

    /**
     * The Person object that will be used to make requests.
     */
    private static Person personRequest;

    /**
     * The MailingAddress object that will be used to make requests.
     */
    private static MailingAddress mailingAddress;

    /**
     * The MailingAddress object that will be used to make update request.
     */
    private static MailingAddress updatedMailingAddress;

    /**
     * The Person object that will be used to make update requests.
     */
    private static Person updatedPerson;

    /**
     * This method sets up the PeopleClient object that will be used to make
     * requests.
     * @throws OutsetaClientBuildException This exception is thrown if the
     *      PeopleClient object cannot be created.
     */
    @BeforeAll
    public static void setUp() throws OutsetaClientBuildException {
        peopleClient = PeopleClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();

        mailingAddress = MailingAddress.builder()
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
                .mailingAddress(mailingAddress)
                .build();

        updatedMailingAddress = MailingAddress.builder()
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
                .mailingAddress(updatedMailingAddress)
                .build();
    }

    /**
     * This method tests the builder of the PeopleClient class.
     */
    @Test
    public void testBuilder() {

        assertDoesNotThrow(() -> {
            PeopleClient test = PeopleClient.builder(outsetaUrl)
                    .apiKey(outsetaKey)
                    .defaultParser()
                    .defaultRequestMaker()
                    .build();

            assertNotNull(test);
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
                        .apiKey(outsetaKey)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing empty outsetaUrl but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                PeopleClient.builder("")
                        .apiKey(outsetaKey)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing null Outseta Key but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                PeopleClient.builder(outsetaUrl)
                        .apiKey(null)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing empty Outseta Key but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                PeopleClient.builder(outsetaUrl)
                        .apiKey("")
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing without parser but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                PeopleClient.builder(outsetaUrl)
                        .apiKey(outsetaKey)
                        .defaultRequestMaker()
                        .build()
        );

        // Testing without request maker but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                PeopleClient.builder(outsetaUrl)
                        .apiKey(outsetaKey)
                        .defaultParser()
                        .build()
        );
    }

    /**
     * This test tests the getPerson method of the PeopleClient class.
     * It tests the success scenario.
     */
    @Test
    public void testGetPerson() {

        assertDoesNotThrow(() -> {
            // Create a person
            Person createdPerson = peopleClient.createPerson(personRequest);
            Person person = peopleClient.getPerson(createdPerson.getUid());

            assertNotNull(person);

            // Cleaning up
            peopleClient.deletePerson(createdPerson.getUid());
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
            Person person = peopleClient.createPerson(personRequest);
            assertEquals(personRequest.getEmail(), person.getEmail());
            assertEquals(personRequest.getFirstName(), person.getFirstName());
            assertEquals(personRequest.getLastName(), person.getLastName());
            assertEquals(personRequest.getMailingAddress().getAddressLine1(),
                    person.getMailingAddress().getAddressLine1());
            assertEquals(personRequest.getMailingAddress().getAddressLine2(),
                    person.getMailingAddress().getAddressLine2());
            assertEquals(personRequest.getMailingAddress().getAddressLine3(),
                    person.getMailingAddress().getAddressLine3());
            assertEquals(personRequest.getMailingAddress().getCity(),
                    person.getMailingAddress().getCity());
            assertEquals(personRequest.getMailingAddress().getCountry(),
                    person.getMailingAddress().getCountry());

            // Cleaning up
            peopleClient.deletePerson(person.getUid());
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
            Person createdPerson = peopleClient.createPerson(personRequest);
            Person updatedPersonActual = peopleClient
                    .updatePerson(createdPerson.getUid(), updatedPerson);
            assertEquals(updatedPerson.getEmail(),
                    updatedPersonActual.getEmail());
            assertEquals(updatedPerson.getFirstName(),
                    updatedPersonActual.getFirstName());
            assertEquals(updatedPerson.getLastName(),
                    updatedPersonActual.getLastName());
            assertEquals(updatedPerson.getMailingAddress().getAddressLine1(),
                    updatedPersonActual.getMailingAddress().getAddressLine1());
            assertEquals(updatedPerson.getMailingAddress().getAddressLine2(),
                    updatedPersonActual.getMailingAddress().getAddressLine2());
            assertEquals(updatedPerson.getMailingAddress().getAddressLine3(),
                    updatedPersonActual.getMailingAddress().getAddressLine3());
            assertEquals(updatedPerson.getMailingAddress().getCity(),
                    updatedPersonActual.getMailingAddress().getCity());
            assertEquals(updatedPerson.getMailingAddress().getCountry(),
                    updatedPersonActual.getMailingAddress().getCountry());
            // Cleaning up
            peopleClient.deletePerson(createdPerson.getUid());
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
     */
    @Test
    public void testDeletePerson() {

        assertDoesNotThrow(() -> {
            Person createdPerson = peopleClient.createPerson(personRequest);
            peopleClient.deletePerson(createdPerson.getUid());
        });
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
            Person createdPerson = peopleClient.createPerson(personRequest);
            peopleClient.setTemporaryPassword(createdPerson.getUid(),
                    temporaryPasswordRequest);
            peopleClient.deletePerson(createdPerson.getUid());
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
