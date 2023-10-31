package com.outseta.client.endpoint_client;

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
import com.outseta.model.result.Case;
import com.outseta.model.result.CaseReply;
import com.outseta.model.result.ItemPage;

import java.util.HashMap;

/**
 * This class is used to make calls to the Support endpoints of the
 * Outseta API.
 * <p>
 *     The Profile endpoints are used to manage support cases.
 *     The class provides a builder to make it easier to construct
 *     the client.
 * </p>
 */
public final class SupportClient extends BaseClient {

    /**
     * This method is used to get a builder that can be used to build a
     * SupportClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build an SupportClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static ClientBuilder<SupportClient> builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new ClientBuilder<>(new SupportClient(baseUrl));
    }

    /**
     * The constructor creates a new Support client with the base url.
     * It is intentionally private to force the use of the builder.
     *
     * @param pBaseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    private SupportClient(final String pBaseUrl)
            throws OutsetaClientBuildException {
        super(pBaseUrl);
    }

    /**
     * Gets a case by id.
     *
     * @param caseId The id of the case.
     * @return The case.
     * @throws OutsetaInvalidArgumentException Thrown if the
     *                                              id is null.
     * @throws OutsetaParseException            Thrown if the email list
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
     * SupportClient client = SupportClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String caseId = "caseId";
     * Case caseObject = client.getCase(caseId);
     * }</pre>
     */
    public Case getCase(
            final String caseId)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (caseId == null
                || caseId.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Case id cannot be null or blank.");
        }

        String result = this.get("/support/cases/" + caseId,
                new HashMap<>());

        return this.getParserFacade().jsonStringToObject(result,
                Case.class);
    }

    /**
     * This method is used to get a page of Case objects.
     *
     * @param pageRequest The page request to use.
     * @return The list of case objects.
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
     * CaseClient client = CaseClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * PageRequest request = PageRequest.builder()
     *      .page(page)
     *      .pageSize(pageSize)
     *      .build();
     *
     * pageRequest.setCustomParams(Map.of("FromPerson.Uid", "asd"))
     * int total = 0;
     * ItemPage<Case> casePage = null;
     *
     * do {
     *      // Keep making requests as long as there are more pages
     *      casePage = client.getCasePage(request);
     *      total = casePage.getMetadata().getTotal();
     *
     *      // The current page's items are aggregated
     *      allCases.addAll(casePage.getItems());
     *      request = request.nextPageRequest();
     * }
     * while (allCases.size() < total);
     * }</pre>
     */
    public ItemPage<Case> getCasePage(final PageRequest pageRequest)
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaParseException, OutsetaInvalidArgumentException {


        if (pageRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Page request cannot be null.");
        }

        String result = this.get("/support/cases",
                pageRequest.buildParams());

        return this.getParserFacade()
                .jsonStringToPage(result,
                        Case.class);
    }

    /**
     * Adds a case into the support system.
     *
     * Set sendAutoResponder=false if you'd like the system not to send an
     * automatic message that the ticket has been created.
     *
     * @param sendAutoResponder Whether to send an automated message.
     * @param caseObject The case object to add.
     * @return The case.
     * @throws OutsetaInvalidArgumentException Thrown if the
     *                                              id is null.
     * @throws OutsetaParseException            Thrown if the email list
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
     * SupportClient client = SupportClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Case caseObject = Case.builder().build();
     * Case createdCase = client.addCase(caseObject);
     * }</pre>
     */
    public Case addCase(
            final boolean sendAutoResponder,
            final Case caseObject)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (caseObject == null) {
            throw new OutsetaInvalidArgumentException(
                    "Case object cannot be null.");
        }

        String result = this.post("/support/cases?sendAutoResponder="
                        + (sendAutoResponder ? "true" : "false"),
                new HashMap<>(),
                this.getParserFacade().objectToJsonString(caseObject));

        return this.getParserFacade().jsonStringToObject(result,
                Case.class);
    }

    /**
     * Adds a response to the case from the person that opened the case.
     *
     * @param caseUid The id of the case.
     * @param comment The comment to be added.
     * @throws OutsetaInvalidArgumentException Thrown if the
     *                                              id is null.
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
     * SupportClient client = SupportClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String caseId = "caseId";
     * String comment = "comment";
     * Case result = client.addClientResponse(caseUid, comment);
     * }</pre>
     */
    public void addClientResponse(
            final String caseUid,
            final String comment)
            throws OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (caseUid == null || caseUid.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Case uid cannot be null or blank.");
        }

        if (comment == null || comment.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Comment cannot be null or blank.");
        }

        String safeComment = comment.replaceAll(" ", "%20");

        this.post("/support/cases/" + caseUid
                        + "/clientresponse/" + safeComment,
                new HashMap<>(),
                "");
    }

    /**
     * Adds a reply from an agent to a support case.
     *
     * @param caseUid The id of the case.
     * @param caseReply The reply to the case from agent.
     * @return The case.
     * @throws OutsetaInvalidArgumentException Thrown if the
     *                                              id is null.
     * @throws OutsetaParseException            Thrown if the email list
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
     * SupportClient client = SupportClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String caseId = "caseId";
     * CaseReply caseReply = CaseReply.builder().build();
     * Case result = client.addReply(caseUid, caseReply);
     * }</pre>
     */
    public Case addReply(
            final String caseUid,
            final CaseReply caseReply)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaInvalidURLException,
            OutsetaInvalidArgumentException {

        if (caseUid == null || caseUid.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Case uid cannot be null or blank.");
        }

        if (caseReply == null) {
            throw new OutsetaInvalidArgumentException(
                    "Case reply cannot be null.");
        }

        String result = this.post("/support/cases/" + caseUid
                        + "/replies",
                new HashMap<>(),
                this.getParserFacade().objectToJsonString(caseReply));

        return this.getParserFacade().jsonStringToObject(result,
                Case.class);
    }
}
