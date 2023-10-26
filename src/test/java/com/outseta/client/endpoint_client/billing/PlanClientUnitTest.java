package com.outseta.client.endpoint_client.billing;

import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Plan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the PlanClient class.
 */
@ExtendWith(MockitoExtension.class)
public class PlanClientUnitTest {

    /**
     * The client that is used to make calls to the plan endpoints.
     */
    private PlanClient planClient;

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
     * The plan used for testing.
     */
    @Mock
    private Plan plan;

    /**
     * The plan page used for testing.
     */
    @Mock
    private ItemPage<Plan> planPage;

    /**
     * The plan string used for testing.
     */
    private String planStr;

    /**
     * The page size used for testing.
     */
    private static final int PAGE_SIZE = 10;

    /**
     * This method is used to set up the tests.
     */
    @BeforeEach
    public void setup() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        when(parserFacade.getJsonParser()).thenReturn(jsonParser);
        planClient = PlanClient.builder(OUTSETA_URL)
                .apiKey(OUTSETA_KEY)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .build();
        planStr = "planJsonDummy";
    }

    /**
     * This method is used to test the getPlan method.
     */
    @Test
    public void testGetPlan() throws Exception {
        when(requestMaker.get(OUTSETA_URL + "/billing/plans/planId",
                new HashMap<>(), planClient.getHeaders())).thenReturn(planStr);
        when(parserFacade.jsonStringToObject(planStr, Plan.class))
                .thenReturn(plan);
        Plan result = planClient.getPlan("planId");

        assertEquals(plan, result);
    }

    /**
     * This method is used to test the getPlan method when the plan id is null.
     */
    @Test
    public void testGetPlanNullPlanId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            planClient.getPlan(null);
        });
    }

    /**
     * This method is used to test the getPlan method when the plan id is blank.
     */
    @Test
    public void testGetPlanBlankPlanId() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            planClient.getPlan("");
        });
    }

    /**
     * This method is used to test the getPlanPage method.
     */
    @Test
    public void testGetPlanPage() throws Exception {

        PageRequest pageRequest = PageRequest.builder()
                .pageSize(PAGE_SIZE)
                .page(1)
                .build();

        when(requestMaker.get(OUTSETA_URL + "/billing/plans",
                pageRequest.buildParams(),
                planClient.getHeaders())).thenReturn(planStr);
        when(parserFacade.jsonStringToPage(planStr, Plan.class))
                .thenReturn(planPage);
        ItemPage<Plan> result = planClient.getPlanPage(
                pageRequest
        );

        assertEquals(planPage, result);
    }

    /**
     * This method is used to test the getPlanPage method when the page request
     * is null.
     */
    @Test
    public void testGetPlanPageNullPageRequest() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            planClient.getPlanPage(null);
        });
    }
}
