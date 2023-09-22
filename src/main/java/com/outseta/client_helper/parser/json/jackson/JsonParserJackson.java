package com.outseta.client_helper.parser.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.exception.OutsetaParseException;
import com.outseta.model.DataComponent;

public class JsonParserJackson implements JsonParser {

    private final ObjectMapper objectMapper;

    public JsonParserJackson(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JsonParserJackson(){
        this.objectMapper = new ObjectMapper();

        // Configure the parser here
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public <T extends DataComponent> String objectToJsonString(T obj) throws OutsetaParseException {

        String result;

        try {
            result = this.objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new OutsetaParseException("Unable to convert " + obj.getClass().toString() + " to a json string.");
        }

        return result;
    }

    @Override
    public <T extends DataComponent> T jsonStringToObject(String jsonString, Class<T> clazz) throws OutsetaParseException {
        T result = null;

        try {
            result = this.objectMapper.readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            throw new OutsetaParseException("Unable to convert json string to " + clazz.toString() + " type.");
        }

        return result;
    }
}
