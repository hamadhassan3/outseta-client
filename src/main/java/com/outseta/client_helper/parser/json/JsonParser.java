package com.outseta.client_helper.parser.json;

import com.outseta.model.DataComponent;

public interface JsonParser {
    <T extends DataComponent> String objectToJsonString(T obj);
    <T extends DataComponent> T jsonStringToObject(String jsonString, Class<T> clazz);
}
