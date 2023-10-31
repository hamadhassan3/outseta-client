package com.outseta.client.endpoint_client.billing;

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
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Plan;

import java.util.HashMap;

/**
 * This class is used to make calls to the Plan endpoints of the
 * Outseta API.
 * <p>
 *     The Plan endpoints are used to manage plans.
 *     The class provides a builder to make it easier to construct the client.
 * </p>
 */
public final class PlanClient extends BaseClient {

    /**
     * This method is used to get a builder that can be used to build an
     * PlanClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build an PlanClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static ClientBuilder<PlanClient> builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new ClientBuilder<>(new PlanClient(baseUrl));
    }

    /**
     * The constructor creates a new Plan client with the base url.
     * It is intentionally private to force the use of the builder.
     *
     * @param pBaseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    private PlanClient(final String pBaseUrl)
            throws OutsetaClientBuildException {
        super(pBaseUrl);
    }

    /**
     * This method is used to get a plan by id.
     *
     * @param planId The id of the plan to get.
     * @return The plan.
     * @throws OutsetaInvalidArgumentException Thrown if the plan
     *                                              id is null.
     * @throws OutsetaParseException            Thrown if the plan
     *                                              cannot be parsed.
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
     * PlanClient client = PlanClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String planId = "planId";
     * Plan plan = client.getPlan(planId);
     * }</pre>
     */
    public Plan getPlan(final String planId)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (planId == null || planId.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Plan id cannot be null or blank.");
        }

        String result = this.get("/billing/plans/" + planId,
                new HashMap<>());

        return this.getParserFacade().jsonStringToObject(result,
                Plan.class);
    }

    /**
     * This method is used to get a page of Plan objects.
     *
     * @param pageRequest The page request to use.
     * @return The list of plan objects.
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
     * PlanClient client = PlanClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * PageRequest request = PageRequest.builder()
     *      .page(page)
     *      .pageSize(pageSize)
     *      .build();
     * int total = 0;
     * ItemPage<Plan> planPage = null;
     *
     * do {
     *      // Keep making requests as long as there are more pages
     *      planPage = planClient.getPlanPage(request);
     *      total = planPage.getMetadata().getTotal();
     *
     *      // The current page's items are aggregated
     *      allPlans.addAll(planPage.getItems());
     *      request = request.nextPageRequest();
     * }
     * while (allPlans.size() < total);
     * }</pre>
     */
    public ItemPage<Plan> getPlanPage(final PageRequest pageRequest)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException, OutsetaInvalidArgumentException {

        if (pageRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Page request cannot be null.");
        }

        String result = this.get("/billing/plans",
                pageRequest.buildParams());

        return this.getParserFacade()
                .jsonStringToPage(result,
                        Plan.class);
    }
}
