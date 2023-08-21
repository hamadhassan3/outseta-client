package com.outseta.client_helper.parser.json;

import com.outseta.model.DataComponent;

/**
 * This is a utility class for parsing any json data.
 * It is a facade for data manipulation as the calling class does
 * not need to know the inner working of the data and its
 * conversion.
 */
public class ParserFacade {

    private JsonParser jsonParser;

    public ParserFacade(JsonParser jsonParser){
        this.jsonParser = jsonParser;
    }

    public <T extends DataComponent> String objectToJsonString(T obj){
        return jsonParser.objectToJsonString(obj);
    }

    public <T extends DataComponent> T jsonStringToObject(String jsonString, Class<T> clazz){
        return jsonParser.jsonStringToObject(jsonString, clazz);
    }

}
