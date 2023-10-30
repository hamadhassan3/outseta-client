package com.outseta.client.endpoint_client.integration;

import com.outseta.client.endpoint_client.SupportClient;
import com.outseta.client.endpoint_client.crm.PeopleClient;
import com.outseta.constant.CaseSource;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.Case;
import com.outseta.model.result.CaseReply;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Person;
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

/**
 * This class is used to test the SupportClient class.
 * It contains integration tests and therefore requires a valid Outseta API key.
 */
@ExtendWith(MockitoExtension.class)
@Tag("integration")
public class SupportClientIntegrationTest {

    /**
     * The Outseta API Key.
     */
    private static String outsetaKey = System.getenv("OUTSETA_KEY");

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");

    /**
     * The Object to be tested.
     */
    private SupportClient supportClient;

    /**
     * The case ID to be used in testing.
     */
    private String caseId;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        supportClient = SupportClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();

        caseId = System.getenv("CASE_ID");
    }

    /**
     * This method tests the get case method.
     */
    @Test
    void getCase() {
        assertDoesNotThrow(() -> {
            Case aCase = supportClient.getCase(caseId);

            assertEquals(caseId,
                    aCase.getUid());
        });
    }

    /**
     * This method tests the getCasePage method.
     */
    @Test
    void getCasePage() {
        final int page = 0;
        final int pageSize = 25;

        List<Case> allCases = new ArrayList<>();

        assertDoesNotThrow(() -> {
            PageRequest request = PageRequest.builder()
                    .page(page)
                    .pageSize(pageSize)
                    .build();

            int total = 0;
            ItemPage<Case> itemPage = null;
            final int maxSize = 100;
            do {
                // Keep making requests as long as there are more pages
                itemPage = supportClient.getCasePage(request);
                total = itemPage.getMetadata().getTotal();

                assertNotNull(itemPage);

                // The current page's items are aggregated
                allCases.addAll(itemPage.getItems());

                assertEquals(
                        (request.getPageSize() * request.getPageNum())
                                + itemPage.getItems().size(),
                        allCases.size());

                request = request.nextPageRequest();

            }
            while (allCases.size() < total
                    && allCases.size() < maxSize);

        });
    }

    /**
     * This method tests the addCase method.
     */
    @Test
    void addCase() {
        assertDoesNotThrow(() -> {

            PeopleClient peopleClient = PeopleClient.builder(outsetaUrl)
                    .apiKey(outsetaKey)
                    .defaultParser()
                    .defaultRequestMaker()
                    .build();

            Person person = peopleClient.createPerson(Person.builder()
                    .email("testSupport@dummy.com")
                    .firstName("Test")
                    .lastName("Marketing")
                    .build());

            Case aCase = Case.builder()
                    .subject("Test Case")
                    .body("This is a test case.")
                    .source(CaseSource.EMAIL)
                    .fromPerson(person)
                    .build();

            Case addedCase = supportClient.addCase(false, aCase);

            assertEquals(aCase.getSubject(),
                    addedCase.getSubject());
            assertEquals(aCase.getBody(),
                    addedCase.getBody());
            assertEquals(aCase.getSource(),
                    addedCase.getSource());
            assertEquals(aCase.getFromPerson(), addedCase.getFromPerson());

            peopleClient.deletePerson(person.getUid());
        });
    }

    /**
     * This method tests the add client response method.
     */
    @Test
    void addClientResponse() {
        assertDoesNotThrow(() -> {

            supportClient.addClientResponse(caseId,
                    "This is a test response.");
        });
    }

    /**
     * This method tests the addReply method.
     */
    @Test
    void addReply() {
        assertDoesNotThrow(() -> {
            Case aCase = supportClient.getCase(caseId);

            Case updatedCase = supportClient.addReply(caseId,
                    CaseReply.builder()
                            .comment("This is a test reply.")
                            .agentName("Test Agent")
                            .caseObject(aCase)
                            .build());

            assertEquals(aCase.getUid(),
                    updatedCase.getUid());
            assertEquals(aCase.getSubject(),
                    updatedCase.getSubject());
            assertEquals(aCase.getBody(),
                    updatedCase.getBody());
            assertEquals(aCase.getSource(),
                    updatedCase.getSource());
            assertEquals(aCase.getFromPerson(), updatedCase.getFromPerson());
        });
    }
}
