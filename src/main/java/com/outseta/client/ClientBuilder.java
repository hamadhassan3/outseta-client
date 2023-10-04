package com.outseta.client;

import com.outseta.client_helper.parser.json.jackson.JsonParserJackson;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.client_helper.request_maker.RequestMakerFactory;
import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;

import java.util.Map;

/**
 * This class is used to build a client. It is used to set the base url,
 * api key, access key, headers, request maker, and parser.
 * <p>
 *     This class acts as the base class for all builders for clients.
 *     <b>
 *         It is highly recommended that any class that extends BaseClient
 *         also creates a builder that extends ClientBuilder.
 *     </b>
 * </p>
 */
public class ClientBuilder {

    /**
     * The base client that is being built.
     */
    private final BaseClient baseClient;

    /**
     * This constructor is used to initialize the base client.
     * @param pBaseClient The base client to be built.
     * @throws OutsetaClientBuildException If the base client is null.
     */
    public ClientBuilder(final BaseClient pBaseClient)
            throws OutsetaClientBuildException {

        if (pBaseClient == null) {
            throw new OutsetaClientBuildException(
                    "Base client cannot be null.");
        }

        this.baseClient = pBaseClient;

    }

    /**
     * This method is used to set the base url of the base client.
     * @param baseUrl The base url to set.
     * @return The client builder so that it can be chained.
     * @throws OutsetaClientBuildException If the base url is null or blank.
     */
    public ClientBuilder baseUrl(final String baseUrl)
            throws OutsetaClientBuildException {

        if (baseUrl == null) {
            throw new OutsetaClientBuildException(
                    "Cannot initialize with null base url.");
        } else if (baseUrl.isBlank()) {
            throw new OutsetaClientBuildException(
                    "The base url cannot be blank.");
        }

        this.baseClient.setBaseUrl(baseUrl);
        return this;
    }

    /**
     * This method is used to set the api key of the base client.
     * @param apiKey The api key to set.
     * @return The client builder so that it can be chained.
     * @throws OutsetaClientBuildException If the api key is null or blank.
     */
    public ClientBuilder apiKey(final String apiKey)
            throws OutsetaClientBuildException {

        if (apiKey == null) {
            throw new OutsetaClientBuildException(
                    "Cannot initialize with null api key.");
        } else if (apiKey.isBlank()) {
            throw new OutsetaClientBuildException(
                    "The api key cannot be blank.");
        }

        this.baseClient.getHeaders().put("Authorization", apiKey);
        return this;
    }

    /**
     * This method is used to set the access key of the base client.
     * @param accessKey The access key to set.
     * @return The client builder so that it can be chained.
     * @throws OutsetaClientBuildException If the access key is null or blank.
     */
    public ClientBuilder accessKey(final String accessKey)
            throws OutsetaClientBuildException {

        if (accessKey == null) {
            throw new OutsetaClientBuildException(
                    "Cannot initialize with null api key.");
        } else if (accessKey.isBlank()) {
            throw new OutsetaClientBuildException(
                    "The api key cannot be blank.");
        }

        this.baseClient.getHeaders().put(
                "Authorization", "Bearer " + accessKey);
        return this;
    }

    /**
     * This method is used to set the headers of the base client.
     * @param headers The headers to set.
     * @return The client builder so that it can be chained.
     * @throws OutsetaClientBuildException If the headers are null.
     */
    public ClientBuilder headers(final Map<String, String> headers)
            throws OutsetaClientBuildException {

        if (headers == null) {
            throw new
                    OutsetaClientBuildException("Headers map cannot be null.");
        }

        this.baseClient.getHeaders().putAll(headers);
        return this;
    }

    /**
     * This method is used to set the request maker of the base client.
     * @param requestMakerType The request maker to set.
     * @return The client builder so that it can be chained.
     * @throws OutsetaInvalidRequestMakerException If the request maker is null.
     */
    public ClientBuilder requestMaker(final RequestMakerType requestMakerType)
            throws OutsetaInvalidRequestMakerException {

        if (requestMakerType == null) {
            throw new OutsetaInvalidRequestMakerException(
                    "Request maker type cannot be null.");
        }

        RequestMaker requestMaker =
                RequestMakerFactory.getRequestMaker(requestMakerType);

        this.baseClient.setRequestMaker(requestMaker);
        return this;
    }

    /**
     * This method is used to set a default request maker for making requests.
     * @return The client builder so that it can be chained.
     * @throws OutsetaInvalidRequestMakerException If the request maker
     *      cannot be created.
     */
    public ClientBuilder defaultRequestMaker()
            throws OutsetaInvalidRequestMakerException {

        RequestMaker requestMaker = RequestMakerFactory
                    .getRequestMaker(RequestMakerType.DEFAULT);

        this.baseClient.setRequestMaker(requestMaker);
        return this;
    }

    /**
     * This method is used to set the request maker of the base client.
     * @param requestMakerType The request maker to set.
     * @return The client builder so that it can be chained.
     * @throws OutsetaInvalidRequestMakerException If the request maker type
     *      is null or blank.
     */
    public ClientBuilder requestMaker(final String requestMakerType)
            throws OutsetaInvalidRequestMakerException {

        if (requestMakerType == null) {
            throw new OutsetaInvalidRequestMakerException(
                    "Request maker type cannot be null.");
        } else if (requestMakerType.isBlank()) {
            throw new OutsetaInvalidRequestMakerException(
                    "Request maker type cannot be blank.");
        }

        RequestMaker requestMaker;

        try {
            RequestMakerType type = RequestMakerType
                    .valueOf(requestMakerType.toUpperCase());
            requestMaker = RequestMakerFactory.getRequestMaker(type);
            this.baseClient.setRequestMaker(requestMaker);
        } catch (IllegalArgumentException ex) {
            throw new OutsetaInvalidRequestMakerException(
                    "A request maker of this type does not exist.");
        }

        return this;
    }

    /**
     * This method is used to set the parser of the base client.
     * @param parserFacade The parser to set.
     * @return The client builder so that it can be chained.
     * @throws OutsetaClientBuildException If the parser is null or not
     *      configured correctly.
     */
    public ClientBuilder parser(final ParserFacade parserFacade)
            throws OutsetaClientBuildException {

        if (parserFacade == null) {
            throw new OutsetaClientBuildException("Parser cannot be null.");
        } else if (parserFacade.getJsonParser() == null) {
            throw new OutsetaClientBuildException(
                    "Json parser cannot be null.");
        }

        this.baseClient.setParserFacade(parserFacade);
        return this;
    }

    /**
     * This method is used to set a default parser of the base client.
     * @return The client builder so that it can be chained.
     * @throws OutsetaClientBuildException If the parser cannot be created.
     */
    public ClientBuilder defaultParser() throws OutsetaClientBuildException {
        this.baseClient.setParserFacade(
                new ParserFacade(new JsonParserJackson()));
        return this;
    }

    /**
     * This method is used to build the base client.
     * @return The built base client.
     * @throws OutsetaClientBuildException If the base url, api key, access key,
     *      headers, request maker, or parser are not set.
     */
    public BaseClient build() throws OutsetaClientBuildException {

        if (!this.baseClient.isHeadersValid()) {
            throw new OutsetaClientBuildException(
                    "Either an api key or an access key is required. "
                            + "Both cannot be null. Alternatively, provide the "
                            + "Authorization header directly.");
        }
        if (this.baseClient.getParserFacade() == null) {
            throw new OutsetaClientBuildException(
                    "Parser cannot be null. Chooser default"
                            + " parser if you dont want to "
                            + "set a parser yourself.");
        }
        if (this.baseClient.getRequestMaker() == null) {
            throw new OutsetaClientBuildException(
                    "You must specify a request maker. Choose default "
                            + "if you are uncertain.");
        }

        return this.baseClient;
    }
}
