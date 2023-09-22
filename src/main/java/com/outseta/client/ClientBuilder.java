package com.outseta.client;

import com.outseta.client_helper.parser.json.jackson.JsonParserJackson;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMakerFactory;
import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaClientBuildException;

import java.util.Map;

public class ClientBuilder {

    private final BaseClient baseClient;

    public ClientBuilder(BaseClient baseClient) throws OutsetaClientBuildException {

        if(baseClient == null){
            throw new OutsetaClientBuildException("Base client cannot be null.");
        }

        this.baseClient = baseClient;

    }

    public ClientBuilder withBaseUrl(String baseUrl) throws OutsetaClientBuildException {

        if(baseUrl == null) {
            throw new OutsetaClientBuildException("Cannot initialize with null base url.");
        }
        else if(baseUrl.isBlank()) {
            throw new OutsetaClientBuildException("The base url cannot be blank.");
        }

        this.baseClient.setBaseUrl(baseUrl);
        return this;
    }

    public ClientBuilder withApiKey(String apiKey) throws OutsetaClientBuildException {

        if(apiKey == null) {
            throw new OutsetaClientBuildException("Cannot initialize with null api key.");
        }
        else if(apiKey.isBlank()) {
            throw new OutsetaClientBuildException("The api key cannot be blank.");
        }

        this.baseClient.getHeaders().put("Authorization", apiKey);
        return this;
    }

    public ClientBuilder withAccessKey(String accessKey) throws OutsetaClientBuildException {

        if(accessKey == null) {
            throw new OutsetaClientBuildException("Cannot initialize with null api key.");
        }
        else if(accessKey.isBlank()) {
            throw new OutsetaClientBuildException("The api key cannot be blank.");
        }

        this.baseClient.getHeaders().put("Authorization", "Bearer " + accessKey);
        return this;
    }

    public ClientBuilder withHeaders(Map<String, String> headers) throws OutsetaClientBuildException{

        if(headers == null) {
            throw new OutsetaClientBuildException("Headers map cannot be null.");
        }

        this.baseClient.getHeaders().putAll(headers);
        return this;
    }

    public ClientBuilder withRequestMaker(RequestMakerType requestMakerType) throws OutsetaClientBuildException{

        if(requestMakerType == null){
            throw new OutsetaClientBuildException("Request maker type cannot be null.");
        }

        this.baseClient.setRequestMaker(RequestMakerFactory.getRequestMaker(requestMakerType));
        return this;
    }

    public ClientBuilder withDefaultRequestMaker() throws OutsetaClientBuildException {
        this.baseClient.setRequestMaker(RequestMakerFactory.getRequestMaker(RequestMakerType.DEFAULT));
        return this;
    }

    public ClientBuilder withRequestMaker(String requestMakerType) throws OutsetaClientBuildException {

        if(requestMakerType == null) {
            throw new OutsetaClientBuildException("Request maker type cannot be null.");
        }
        else if(requestMakerType.isBlank()) {
            throw new OutsetaClientBuildException("Request maker type cannot be blank.");
        }

        RequestMakerType type;

        try {
            type = RequestMakerType.valueOf(requestMakerType.toUpperCase());
        }
        catch (IllegalArgumentException ex) {
            throw new OutsetaClientBuildException("A request maker of this type does not exist.");
        }

        this.baseClient.setRequestMaker(RequestMakerFactory.getRequestMaker(type));
        return this;
    }

    public ClientBuilder withParser(ParserFacade parserFacade) throws OutsetaClientBuildException {

        if(parserFacade == null) {
            throw new OutsetaClientBuildException("Parser cannot be null.");
        }
        else if(parserFacade.getJsonParser() == null){
            throw new OutsetaClientBuildException("Json parser cannot be null.");
        }

        this.baseClient.setParserFacade(parserFacade);
        return this;
    }

    public ClientBuilder withDefaultParser() throws OutsetaClientBuildException {
        this.baseClient.setParserFacade(new ParserFacade(new JsonParserJackson()));
        return this;
    }

    public BaseClient build() throws OutsetaClientBuildException {

        if (this.baseClient.getBaseUrl() == null || this.baseClient.getBaseUrl().isBlank()) {
            throw new OutsetaClientBuildException("Cannot initialize with null or blank base url.");
        }

        if(!this.baseClient.isHeadersValid()) {
            throw new OutsetaClientBuildException("Either an api key or an access key is required. " +
                    "Both cannot be null. Alternatively, provide the Authorization header directly.");
        }
        if(this.baseClient.getParserFacade() == null){
            throw new OutsetaClientBuildException("Parser cannot be null. Chooser default parser if you dont want to " +
                    "set a parser yourself.");
        }
        if(this.baseClient.getRequestMaker() == null){
            throw new OutsetaClientBuildException("You must specify a request maker. Choose default " +
                    "if you are uncertain.");
        }

        return this.baseClient;
    }
}
