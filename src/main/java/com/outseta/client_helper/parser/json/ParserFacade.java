package com.outseta.client_helper.parser.json;

import com.outseta.exception.OutsetaParseException;
import com.outseta.model.DataComponent;

/**
 * This is a utility class for parsing any json data.
 * It is a facade for data manipulation as the calling class does
 * not need to know the inner working of the data and its
 * conversion.
 */
public class ParserFacade {

    /**
     * The JsonParser object used to convert objects to
     * json strings and vice versa.
     */
    private final JsonParser jsonParser;

    /**
     * This constructor is used to initialize the JsonParser object.
     * @param pJsonParser The JsonParser object to use.
     */
    public ParserFacade(final JsonParser pJsonParser) {
        this.jsonParser = pJsonParser;
    }

    /**
     * This method converts an object to a json string.
     * @param obj The object to convert.
     * @return The json string.
     * @param <T> The type of the object to convert.
     * @throws OutsetaParseException If the object cannot be converted to
     *      a json string.
     */
    public <T extends DataComponent> String objectToJsonString(final T obj)
            throws OutsetaParseException {
        return jsonParser.objectToJsonString(obj);
    }

    /**
     * This method converts a json string to an object.
     * @param jsonString The json string to convert.
     * @param clazz The class of the object to convert to.
     * @return The object.
     * @param <T> The type of the object to convert to.
     * @throws OutsetaParseException If the json string cannot be converted
     *      to an object.
     */
    public <T extends DataComponent> T jsonStringToObject(
            final String jsonString, final Class<T> clazz)
            throws OutsetaParseException {

        return jsonParser.jsonStringToObject(jsonString, clazz);
    }

    /**
     * This method is used to get the JsonParser object.
     * @return The JsonParser object.
     */
    public JsonParser getJsonParser() {
        return jsonParser;
    }
}
