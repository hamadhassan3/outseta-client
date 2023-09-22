package com.outseta.client_helper.parser.json;

import com.outseta.exception.OutsetaParseException;
import com.outseta.model.DataComponent;

public interface JsonParser {
    <T extends DataComponent> String objectToJsonString(T obj) throws OutsetaParseException;
    <T extends DataComponent> T jsonStringToObject(String jsonString, Class<T> clazz) throws OutsetaParseException;
}
