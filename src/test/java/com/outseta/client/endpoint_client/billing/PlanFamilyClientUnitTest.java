package com.outseta.client.endpoint_client.billing;

import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.exception.OutsetaPageBuildException;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.PlanFamily;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the PlanFamilyClient class.
 */
@ExtendWith(MockitoExtension.class)
public class PlanFamilyClientUnitTest {

    /**
     * The client that is used to make calls to the plan family endpoints.
     */
    private PlanFamilyClient planFamilyClient;

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
     * The plan family used for testing.
     */
    @Mock
    private PlanFamily planFamily;

    /**
     * The plan family page used for testing.
     */
    @Mock
    private ItemPage<PlanFamily> planFamilyPage;

    /**
     * The plan family string used for testing.
     */
    private String planFamilyStr;

    /**
     * The page size used for testing.
     */
    private static final int PAGE_SIZE = 10;

    /**
     * Sets up the data before each test.
     */
    @BeforeEach
    void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        when(parserFacade.getJsonParser()).thenReturn(jsonParser);
        planFamilyClient = PlanFamilyClient.builder(OUTSETA_URL)
                .apiKey(OUTSETA_KEY)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .build();
        planFamilyStr = "planFamilyDummyStr";
    }

    /**
     * This method tests the getPlanFamily method.
     */
    @Test
    void getPlanFamilyTest() {

        assertDoesNotThrow(() -> {
            when(requestMaker.get(OUTSETA_URL + "/billing/planfamilies/id",
                    new HashMap<>(), planFamilyClient.getHeaders()))
                    .thenReturn(planFamilyStr);
            when(parserFacade.jsonStringToObject(planFamilyStr,
                    PlanFamily.class))
                    .thenReturn(planFamily);
            PlanFamily result = planFamilyClient.getPlanFamily("id");

            assertEquals(planFamily, result);
        });
    }

    /**
     * This method tests the getPlanFamilies method with null id.
     */
    @Test
    void getPlanFamiliesTest() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            planFamilyClient.getPlanFamily(null);
        });
    }

    /**
     * This method tests the getPlanFamilies method with blank id.
     */
    @Test
    void getPlanFamiliesBlankIdTest() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            planFamilyClient.getPlanFamily("");
        });
    }

    /**
     * This method tests the getPlanFamilyPage method.
     */
    @Test
    public void testGetPlanFamilyPage() throws OutsetaPageBuildException {
        PageRequest pageRequest = PageRequest.builder()
                .pageSize(PAGE_SIZE)
                .page(1)
                .build();

        assertDoesNotThrow(() -> {
            when(requestMaker.get(OUTSETA_URL + "/billing/planfamilies",
                    pageRequest.buildParams(),
                    planFamilyClient.getHeaders())).thenReturn(planFamilyStr);
            when(parserFacade.jsonStringToPage(planFamilyStr, PlanFamily.class))
                    .thenReturn(planFamilyPage);
            ItemPage<PlanFamily> result = planFamilyClient.getPlanFamilyPage(
                    pageRequest
            );

            assertEquals(planFamilyPage, result);
        });
    }

    /**
     * This method tests the getPlanFamilyPage method with null page request.
     */
    @Test
    public void testGetPlanFamilyPageNullPageRequest() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            planFamilyClient.getPlanFamilyPage(null);
        });
    }
}
