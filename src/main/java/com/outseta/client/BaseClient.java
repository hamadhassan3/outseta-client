package com.outseta.client;

import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is the base class for all Outseta clients.
 * <p>
 *     This class contains the base url, headers, and request maker for all
 *     Outseta clients.
 * </p>
 */
public class BaseClient {

    /**
     * The headers to be used for all requests.
     */
    private final Map<String, String> headers;

    /**
     * The request maker to be used for all requests.
     */
    private RequestMaker requestMaker;

    /**
     * The base url to be used for all requests.
     */
    private String baseUrl;

    /**
     * The parser facade to be used for all requests.
     */
    private ParserFacade parserFacade;

    /**
     * This constructor is used to initialize the base url.
     * @param pBaseUrl The base url to be used for all requests.
     * @throws OutsetaClientBuildException If the base url is null.
     */
    protected BaseClient(final String pBaseUrl)
            throws OutsetaClientBuildException {

        if (pBaseUrl == null || pBaseUrl.isEmpty()) {
            throw new OutsetaClientBuildException(
                    "Error creating client. Base url cannot be null.");
        }

        this.baseUrl = pBaseUrl;

        this.requestMaker = null;
        this.headers = new HashMap<>();
        this.headers.put("Content-Type", "application/json");
        this.headers.put("Accept", "application/json");

        this.parserFacade = null;
    }

    /**
     * This constructor is used to initialize the base url and headers.
     * @param pBaseUrl The base url to be used for all requests.
     * @param pHeaders The headers to be used for all requests.
     * @param pRequestMaker The request maker to be used for all requests.
     * @throws OutsetaClientBuildException If the base url, headers, or
     *      request maker is null.
     */
    protected BaseClient(final String pBaseUrl,
                         final Map<String, String> pHeaders,
                         final RequestMaker pRequestMaker)
            throws OutsetaClientBuildException {

        if (pBaseUrl == null || pBaseUrl.isEmpty()) {
            throw new OutsetaClientBuildException(
                    "Error creating client. Base url cannot be null.");
        }

        if (pHeaders == null) {
            throw new OutsetaClientBuildException(
                    "Error creating client. Headers cannot be null.");
        }

        if (pRequestMaker == null) {
            throw new OutsetaClientBuildException(
                    "Error creating client. Request Maker cannot be null.");
        }

        this.headers = pHeaders;
        this.requestMaker = pRequestMaker;
        this.baseUrl = pBaseUrl;

        if (!this.isHeadersValid()) {
            throw new OutsetaClientBuildException(
                    "Invalid headers for authentication client. "
                            + "Please check headers.");
        }
    }

    /**
     * This method is used to check if the headers are valid.
     * @return True if the headers are valid, false otherwise.
     */
    public boolean isHeadersValid() {
        return this.headers.containsKey("Authorization");
    }

    /**
     * This method is used to add a header to the headers.
     * @param pHeaders The headers to add.
     * @throws OutsetaClientBuildException If the headers are null.
     */
    public void updateHeaders(final Map<String, String> pHeaders)
            throws OutsetaClientBuildException {

        if (pHeaders == null) {
            throw new OutsetaClientBuildException(
                    "Cannot assign null headers.");
        }
        this.headers.putAll(pHeaders);
    }

    /**
     * This method is used to replace the headers.
     * @param pHeaders The headers to replace the current headers with.
     * @throws OutsetaClientBuildException If the headers are null or do not
     *      contain an authorization header.
     */
    public void replaceHeaders(final Map<String, String> pHeaders)
            throws OutsetaClientBuildException {

        if (pHeaders == null || !pHeaders.containsKey("Authorization")) {
            throw new OutsetaClientBuildException(
                    "Invalid headers for authentication client. "
                            + "Please check headers.");
        }
        this.headers.clear();
        this.headers.putAll(pHeaders);
    }

    /**
     * This method is used to set the request maker.
     * @param pRequestMaker The request maker to use.
     * @throws OutsetaInvalidRequestMakerException If the request maker is null.
     */
    public void setRequestMaker(final RequestMaker pRequestMaker)
            throws OutsetaInvalidRequestMakerException {

        if (pRequestMaker == null) {
            throw new OutsetaInvalidRequestMakerException(
                    "Request maker cannot be null.");
        }
        this.requestMaker = pRequestMaker;
    }

    /**
     * This method is used to get the headers.
     * @return The headers.
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * This method is used to get the base url.
     * @return The base url.
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * This method is used to set the base url.
     * @param pBaseUrl The base url to use.
     * @throws OutsetaClientBuildException If the base url is null.
     */
    public void setBaseUrl(final String pBaseUrl)
            throws OutsetaClientBuildException {
        if (pBaseUrl == null) {
            throw new OutsetaClientBuildException(
                    "Error creating client. Base url cannot be null.");
        }
        this.baseUrl = pBaseUrl;
    }

    /**
     * This method is used to get the request maker.
     * @return The request maker.
     */
    public RequestMaker getRequestMaker() {
        return requestMaker;
    }

    /**
     * This method is used to get the parser facade.
     * @return The parser facade.
     */
    public ParserFacade getParserFacade() {
        return parserFacade;
    }

    /**
     * This method is used to set the parser facade.
     * @param pParserFacade The parser facade to use.
     * @throws OutsetaClientBuildException If the parser facade is null.
     */
    public void setParserFacade(final ParserFacade pParserFacade)
            throws OutsetaClientBuildException {
        if (pParserFacade == null) {
            throw new OutsetaClientBuildException(
                    "Parser facade cannot be null.");
        }
        this.parserFacade = pParserFacade;
    }

    /**
     * This method sends a get request using the request maker that was
     *      provided.
     * @param urlSuffix The url suffix to use for the request.
     * @param parameters The parameters to use for the request.
     * @return The response from the request.
     * @throws OutsetaInvalidResponseCodeException If the response code is
     *      invalid.
     * @throws OutsetaAPIBadRequestException If the request was bad.
     * @throws OutsetaAPIFailedException If the request failed.
     * @throws OutsetaAPIUnknownException If the request failed for an unknown
     *      reason.
     * @throws OutsetaInvalidURLException If the url is invalid.
     */
    protected String get(final String urlSuffix,
                         final Map<String, Object> parameters)
            throws OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaAPIUnknownException,
            OutsetaInvalidURLException {

        return this.requestMaker.get(this.baseUrl + urlSuffix, parameters,
                this.headers);
    }

    /**
     * This method sends a put request using the request maker that was
     *      provided.
     * @param urlSuffix The url suffix to use for the request.
     * @param parameters The parameters to use for the request.
     * @param payload The payload to use for the request.
     * @return The response from the request.
     * @throws OutsetaInvalidResponseCodeException If the response code is
     *      invalid.
     * @throws OutsetaAPIBadRequestException If the request was bad.
     * @throws OutsetaAPIFailedException If the request failed.
     * @throws OutsetaInvalidURLException If the url is invalid.
     * @throws OutsetaAPIUnknownException If the request failed for an unknown
     *      reason.
     */
    protected String put(final String urlSuffix,
                         final Map<String, Object> parameters,
                         final String payload)
            throws OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaInvalidURLException,
            OutsetaAPIUnknownException {

        return this.requestMaker.put(this.baseUrl + urlSuffix, parameters,
                payload, this.headers);
    }

    /**
     * This method sends a post request using the request maker that was
     *      provided.
     * @param urlSuffix The url suffix to use for the request.
     * @param parameters The parameters to use for the request.
     * @param payload The payload to use for the request.
     * @return The response from the request.
     * @throws OutsetaInvalidResponseCodeException If the response code is
     *      invalid.
     * @throws OutsetaAPIBadRequestException If the request was bad.
     * @throws OutsetaAPIFailedException If the request failed.
     * @throws OutsetaInvalidURLException If the url is invalid.
     * @throws OutsetaAPIUnknownException If the request failed for an unknown
     *      reason.
     */
    protected String post(final String urlSuffix,
                          final Map<String, Object> parameters,
                          final String payload)
            throws OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaInvalidURLException,
            OutsetaAPIUnknownException {

        return this.requestMaker.post(this.baseUrl + urlSuffix, parameters,
                payload, this.headers);
    }

    /**
     * This method sends a delete request using the request maker that was
     *      provided.
     * @param urlSuffix The url suffix to use for the request.
     * @param parameters The parameters to use for the request.
     * @return The response from the request.
     * @throws OutsetaInvalidResponseCodeException If the response code is
     *      invalid.
     * @throws OutsetaAPIBadRequestException If the request was bad.
     * @throws OutsetaAPIFailedException If the request failed.
     * @throws OutsetaInvalidURLException If the url is invalid.
     * @throws OutsetaAPIUnknownException If the request failed for an unknown
     *      reason.
     */
    protected String delete(final String urlSuffix,
                            final Map<String, Object> parameters)
            throws OutsetaInvalidResponseCodeException,
            OutsetaAPIBadRequestException,
            OutsetaAPIFailedException,
            OutsetaInvalidURLException,
            OutsetaAPIUnknownException {

        return this.requestMaker.delete(this.baseUrl + urlSuffix,
                parameters, this.headers);
    }
}
