package com.outseta.client_helper.parser.json;

import com.outseta.exception.OutsetaParseException;
import com.outseta.model.DataComponent;
import com.outseta.model.result.ItemPage;

/**
 * This interface is used to convert objects to json strings and vice versa.
 */
public interface JsonParser {
    /**
     * This method is used to convert an object to a json string.
     * @param obj The object to convert.
     * @return The json string.
     * @param <T> The type of the object to convert.
     * @throws OutsetaParseException If the object cannot be converted to
     *      a json string.
     */
    <T extends DataComponent> String objectToJsonString(T obj)
            throws OutsetaParseException;

    /**
     * This method is used to convert a json string to an object.
     * @param jsonString The json string to convert.
     * @param clazz The class of the object to convert to.
     * @return The object.
     * @param <T> The type of the object to convert to.
     * @throws OutsetaParseException If the json string cannot be converted
     */
    <T extends DataComponent> T jsonStringToObject(
            String jsonString, Class<T> clazz) throws OutsetaParseException;

    /**
     * This method is used to convert a json string to an ItemPage object.
     * @param jsonString The json string to convert.
     * @param clazz The class of the object to convert to.
     * @return The ItemPage object.
     * @param <T> The type of the object whole list is present in ItemPage.
     * @throws OutsetaParseException If the json string cannot be converted
     */
    <T extends DataComponent> ItemPage<T> jsonStringToPage(
            String jsonString, Class<T> clazz) throws OutsetaParseException;
}
