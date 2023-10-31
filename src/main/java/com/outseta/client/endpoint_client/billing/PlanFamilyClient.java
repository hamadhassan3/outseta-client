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
import com.outseta.model.result.PlanFamily;

import java.util.HashMap;

/**
 * This class is used to make calls to the PlanFamily endpoints of the
 * Outseta API.
 * <p>
 *     The PlanFamily endpoints are used to manage plan families.
 *     The class provides a builder to make it easier to construct the client.
 * </p>
 */
public final class PlanFamilyClient extends BaseClient {

    /**
     * This method is used to get a builder that can be used to build an
     * PlanFamilyClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build an PlanFamilyClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static ClientBuilder<PlanFamilyClient> builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new ClientBuilder<>(new PlanFamilyClient(baseUrl));
    }

    /**
     * The constructor creates a new PlanFamily client with the base url.
     * It is intentionally private to force the use of the builder.
     *
     * @param pBaseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    private PlanFamilyClient(final String pBaseUrl)
            throws OutsetaClientBuildException {
        super(pBaseUrl);
    }

    /**
     * This method is used to get a plan family by id.
     *
     * @param planFamilyId The id of the plan family to get.
     * @return The plan family.
     * @throws OutsetaInvalidArgumentException Thrown if the plan family
     *                                              id is null.
     * @throws OutsetaParseException            Thrown if the plan family
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
     * PlanFamilyClient client = PlanFamilyClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String planFamilyId = "planFamilyId";
     * PlanFamily planFamily = client.getPlanFamily(planFamilyId);
     * }</pre>
     */
    public PlanFamily getPlanFamily(final String planFamilyId)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (planFamilyId == null || planFamilyId.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Plan Family id cannot be null or blank.");
        }

        String result = this.get("/billing/planfamilies/" + planFamilyId,
                new HashMap<>());

        return this.getParserFacade().jsonStringToObject(result,
                PlanFamily.class);
    }

    /**
     * This method is used to get a page of Plan Family objects.
     *
     * @param pageRequest The page request to use.
     * @return The list of plan family objects.
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
     * PlanFamilyClient client = PlanFamilyClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * PageRequest request = PageRequest.builder()
     *      .page(page)
     *      .pageSize(pageSize)
     *      .build();
     * int total = 0;
     * ItemPage<PlanFamily> planFamilyPage = null;
     *
     * do {
     *      // Keep making requests as long as there are more pages
     *      planFamilyPage = planFamilyClient.getPlanFamilyPage(request);
     *      total = planFamilyPage.getMetadata().getTotal();
     *
     *      // The current page's items are aggregated
     *      allPlanFamilies.addAll(planFamilyPage.getItems());
     *      request = request.nextPageRequest();
     * }
     * while (allPlanFamilies.size() < total);
     * }</pre>
     */
    public ItemPage<PlanFamily> getPlanFamilyPage(final PageRequest pageRequest)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException, OutsetaInvalidArgumentException {

        if (pageRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Page request cannot be null.");
        }

        String result = this.get("/billing/planfamilies",
                pageRequest.buildParams());

        return this.getParserFacade()
                .jsonStringToPage(result,
                        PlanFamily.class);
    }

}
