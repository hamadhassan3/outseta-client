package com.outseta.client_helper.parser.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.exception.OutsetaParseException;
import com.outseta.model.DataComponent;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Metadata;

import java.util.List;

/**
 * This class is a wrapper for the Jackson ObjectMapper class.
 * It implements the JsonParser interface.
 * It is used to convert objects to json strings and vice versa.
 */
public class JsonParserJackson implements JsonParser {

    /**
     * The ObjectMapper object used to convert objects to
     * json strings and vice versa.
     */
    private final ObjectMapper objectMapper;

    /**
     * This constructor is used to initialize the ObjectMapper object.
     * @param pObjectMapper The ObjectMapper object to use.
     */
    public JsonParserJackson(final ObjectMapper pObjectMapper) {
        this.objectMapper = pObjectMapper;
    }

    /**
     * This constructor is used to initialize the ObjectMapper object.
     */
    public JsonParserJackson() {
        this.objectMapper = new ObjectMapper();

        // Configure the parser here
        this.objectMapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .coercionConfigDefaults().setCoercion(
                        CoercionInputShape.EmptyString,
                        CoercionAction.AsNull);
    }

    /**
     * This method converts an object to a json string.
     * @param obj The object to convert.
     * @return The json string.
     * @param <T> The type of the object to convert.
     * @throws OutsetaParseException If the object cannot be converted to
     *      a json string.
     */
    @Override
    public <T extends DataComponent> String objectToJsonString(final T obj)
            throws OutsetaParseException {

        String result;

        try {
            result = this.objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new OutsetaParseException("Unable to convert "
                    + obj.getClass().toString() + " to a json string.");
        }

        return result;
    }

    /**
     * This method converts a json string to an object.
     * @param jsonString The json string to convert.
     * @param clazz The class of the object to convert to.
     * @return The object.
     * @param <T> The type of the object to convert to.
     * @throws OutsetaParseException If the json string cannot be
     *      converted to an object.
     */
    @Override
    public <T extends DataComponent> T jsonStringToObject(
            final String jsonString, final Class<T> clazz)
            throws OutsetaParseException {

        T result = null;

        try {
            result = this.objectMapper.readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            throw new OutsetaParseException("Unable to convert json string to "
                    + clazz.toString() + " type.");
        }

        return result;
    }

    /**
     * This method is used to get the ObjectMapper object.
     * @param jsonString The json string to convert.
     * @param clazz The class of the object to convert to.
     * @return The ItemPage object.
     * @param <T> The type of the object whole list is present in ItemPage.
     * @throws OutsetaParseException If the json string cannot be converted.
     */
    @Override
    public <T extends DataComponent> ItemPage<T> jsonStringToPage(
            final String jsonString, final Class<T> clazz)
                throws OutsetaParseException {

        ItemPage<T> result = null;

        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            String metadata = jsonNode.get("metadata").toString();
            String items = jsonNode.get("items").toString();

            Metadata metadataObj = objectMapper
                    .readValue(metadata, Metadata.class);

            // Read the items as a list of objects
            ObjectReader objectReader = objectMapper.readerForListOf(clazz);
            List<T> itemsObj = objectReader.readValue(items);

            result = new ItemPage<>(
                    metadataObj,
                    itemsObj);

        } catch (JsonProcessingException e) {
            throw new OutsetaParseException("Unable to convert json string to "
                    + "a page of "
                    + clazz.toString() + " type.");
        }

        return result;
    }


}
