package com.outseta.client.endpoint_client;

import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.Case;
import com.outseta.model.result.CaseReply;
import com.outseta.model.result.ItemPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the SupportClient class.
 */
@ExtendWith(MockitoExtension.class)
public class SupportClientUnitTest {

    /**
     * The Outseta URL used for testing.
     */
    private static final String OUTSETA_URL = "https://dummy.com";

    /**
     * The access key used for testing.
     */
    private static final String API_KEY = "dummyKey";

    /**
     * The support client to test.
     */
    private SupportClient supportClient;

    /**
     * The mock parser facade.
     */
    @Mock
    private ParserFacade parserFacade;

    /**
     * The mock json parser.
     */
    @Mock
    private JsonParser jsonParser;

    /**
     * The mock request maker.
     */
    @Mock
    private RequestMaker requestMaker;

    /**
     * The mock case object.
     */
    @Mock
    private Case caseObject;

    /**
     * The mock case item page.
     */
    @Mock
    private ItemPage<Case> caseItemPage;

    /**
     * The mock page request.
     */
    @Mock
    private PageRequest pageRequest;

    /**
     * The mock case item page string.
     */
    private String caseItemPageStr;

    /**
     * The mock case object string.
     */
    private String caseObjectStr;

    /**
     * The mock case reply object.
     */
    @Mock
    private CaseReply caseReply;

    /**
     * The mock case reply object string.
     */
    private String caseReplyStr;

    /**
     * This method is used to set up the tests.
     */
    @BeforeEach
    public void setup() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {

        when(this.parserFacade.getJsonParser()).thenReturn(this.jsonParser);

        this.supportClient = SupportClient.builder(OUTSETA_URL)
                .apiKey(API_KEY)
                .requestMaker(this.requestMaker)
                .parser(this.parserFacade)
                .build();
        this.caseObjectStr = "caseObjectStr";
        this.caseReplyStr = "caseReplyStr";
    }

    /**
     * This method tests the getCase method.
     */
    @Test
    public void testGetCase() {

        assertDoesNotThrow(() -> {
            when(this.requestMaker.get(OUTSETA_URL + "/support/cases/1",
                    new HashMap<>(),
                    this.supportClient.getHeaders()))
                    .thenReturn(this.caseObjectStr);

            when(this.parserFacade.jsonStringToObject(this.caseObjectStr,
                    Case.class))
                    .thenReturn(this.caseObject);

            Case result = this.supportClient.getCase("1");

            assertNotNull(result);
            assertEquals(result, this.caseObject);
        });
    }

    /**
     * This method tests the getCase method with null case id.
     */
    @Test
    public void testGetCaseNullCaseId() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            this.supportClient.getCase(null);
        });
    }

    /**
     * This method tests the getCase method with blank case id.
     */
    @Test
    public void testGetCaseBlankCaseId() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            this.supportClient.getCase("");
        });
    }

    /**
     * This method tests the getCasePage method.
     */
    @Test
    public void testGetCasePage() {

        assertDoesNotThrow(() -> {
            when(this.requestMaker.get(OUTSETA_URL + "/support/cases",
                    new HashMap<>(),
                    this.supportClient.getHeaders()))
                    .thenReturn(this.caseItemPageStr);

            when(this.parserFacade.jsonStringToPage(this.caseItemPageStr,
                    Case.class))
                    .thenReturn(this.caseItemPage);

            ItemPage<Case> casePg = this.supportClient.getCasePage(pageRequest);

            assertNotNull(casePg);
            assertEquals(casePg, this.caseItemPage);
        });
    }

    /**
     * This method tests the getCasePage method with null page request.
     */
    @Test
    public void testGetCasePageNullPageRequest() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            this.supportClient.getCasePage(null);
        });
    }

    /**
     * This method tests the addCase method.
     */
    @Test
    public void testAddCase() {

        assertDoesNotThrow(() -> {
            when(this.requestMaker.post(OUTSETA_URL + "/support/cases?"
                            + "sendAutoResponder=false",
                    new HashMap<>(),
                    this.caseObjectStr,
                    this.supportClient.getHeaders()))
                    .thenReturn(this.caseObjectStr);

            when(this.parserFacade.jsonStringToObject(this.caseObjectStr,
                    Case.class))
                    .thenReturn(this.caseObject);

            when(this.parserFacade.objectToJsonString(this.caseObject))
                    .thenReturn(this.caseObjectStr);

            Case result = this.supportClient.addCase(false,
                    this.caseObject);

            assertNotNull(result);
            assertEquals(result, this.caseObject);
        });
    }

    /**
     * This method tests the addCase method with null case object.
     */
    @Test
    public void testAddCaseNullCaseObject() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            this.supportClient.addCase(false, null);
        });
    }

    /**
     * This method tests the addCase method with true send auto responder.
     */
    @Test
    public void testAddCaseTrueSendAutoResponder() {

        assertDoesNotThrow(() -> {
            when(this.requestMaker.post(OUTSETA_URL + "/support/cases?"
                            + "sendAutoResponder=true",
                    new HashMap<>(),
                    this.caseObjectStr,
                    this.supportClient.getHeaders()))
                    .thenReturn(this.caseObjectStr);

            when(this.parserFacade.jsonStringToObject(this.caseObjectStr,
                    Case.class))
                    .thenReturn(this.caseObject);

            when(this.parserFacade.objectToJsonString(this.caseObject))
                    .thenReturn(this.caseObjectStr);

            Case result = this.supportClient.addCase(true,
                    this.caseObject);

            assertNotNull(result);
            assertEquals(result, this.caseObject);
        });
    }

    /**
     * This method tests the addClientResponse method.
     */
    @Test
    public void testAddClientResponse() {

        assertDoesNotThrow(() -> {
            when(this.requestMaker.post(OUTSETA_URL + "/support/cases/1"
                            + "/clientresponse/response",
                    new HashMap<>(),
                    "",
                    this.supportClient.getHeaders()))
                    .thenReturn(this.caseObjectStr);

            this.supportClient.addClientResponse(
                    "1",
                    "response");

        });
    }

    /**
     * This method tests the addClientResponse method with null case id.
     */
    @Test
    public void testAddClientResponseNullCaseId() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            this.supportClient.addClientResponse(null, "response");
        });
    }

    /**
     * This method tests the addClientResponse method with null response.
     */
    @Test
    public void testAddClientResponseNullResponse() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            this.supportClient.addClientResponse("1", null);
        });
    }

    /**
     * This method tests the addClientResponse method with a blank case id.
     */
    @Test
    public void testAddClientResponseBlankCaseId() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            this.supportClient.addClientResponse("", "response");
        });
    }

    /**
     * This method tests the addClientResponse method with a blank response.
     */
    @Test
    public void testAddClientResponseBlankResponse() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            this.supportClient.addClientResponse("1", "");
        });
    }

    /**
     * This method tests the addReply method.
     */
    @Test
    public void testAddReply() {

        assertDoesNotThrow(() -> {
            when(this.requestMaker.post(OUTSETA_URL + "/support/cases/1"
                            + "/replies",
                    new HashMap<>(),
                    this.caseReplyStr,
                    this.supportClient.getHeaders()))
                    .thenReturn(this.caseObjectStr);

            when(this.parserFacade.jsonStringToObject(this.caseObjectStr,
                    Case.class))
                    .thenReturn(this.caseObject);

            when(this.parserFacade.objectToJsonString(this.caseReply))
                    .thenReturn(this.caseReplyStr);

            Case result = this.supportClient.addReply(
                    "1",
                    this.caseReply);

            assertNotNull(result);
            assertEquals(result, this.caseObject);
        });
    }

    /**
     * This method tests the addReply method with null case id.
     */
    @Test
    public void testAddReplyNullCaseId() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            this.supportClient.addReply(null, this.caseReply);
        });
    }

    /**
     * This method tests the addReply method with null case reply.
     */
    @Test
    public void testAddReplyNullCaseReply() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            this.supportClient.addReply("1", null);
        });
    }

    /**
     * This method tests the addReply method with blank case id.
     */
    @Test
    public void testAddReplyBlankCaseId() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            this.supportClient.addReply("", this.caseReply);
        });
    }
}
