package com.outseta.client_helper.parser.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.outseta.client_helper.parser.json.TestDataComponent;
import com.outseta.client_helper.parser.json.TestNestedData;
import com.outseta.exception.OutsetaParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * This class tests the JsonParserJackson class.
 */
@ExtendWith(MockitoExtension.class)
class JsonParserJacksonTest {

    /**
     * Creating JsonParserJackson object with the mocked ObjectMapper.
     */
    private JsonParserJackson jsonParserJackson;

    /**
     * Creating ObjectMapper mock object.
     */
    @Mock
    private ObjectMapper objectMapper;

    /**
     * Creating TestDataComponent object.
     */
    private static String objectStr;

    /**
     * String representation of the test object.
     */
    private static TestDataComponent testDataComponent;

    @BeforeEach
    void setUpEach() {
        this.jsonParserJackson = new JsonParserJackson(objectMapper);
    }

    @BeforeAll
    static void setUp() {
        // Creating a test object and its json string representation
        objectStr =
                "{\"str\":\"test\",\"dbl\":1.0,\"integer\":1,\"bool\":true,"
                + "\"testNestedData\":{\"str\":\"test\",\"dbl\":1.0,\""
                + "integer\":1,\"bool\":true}}";
        testDataComponent = new TestDataComponent("test", 1.0, 1,
                true,
                new TestNestedData("test", 1.0, 1, true));
    }

    /**
     * This method tests the constructor of the JsonParserJackson class.
     */
    @Test
    void testConstructorSuccess() {
        JsonParserJackson temp = new JsonParserJackson();
    }

    /**
     * This method tests the objectToJsonString method of the JsonParserJackson
     * class.
     */
    @Test
    void testObjectToJsonStringSuccess()
            throws JsonProcessingException, OutsetaParseException {

        // Mock ObjectMapper's writeValueAsString method
        when(objectMapper.writeValueAsString(
                any(TestDataComponent.class))).thenReturn(objectStr);

        String result = jsonParserJackson.objectToJsonString(testDataComponent);

        assertEquals(objectStr, result);
    }

    /**
     * This method tests the jsonStringToObject method of the JsonParserJackson
     * class.
     */
    @Test
    void testJsonStringToObjectSuccess()
            throws JsonProcessingException, OutsetaParseException {

        // Mock ObjectMapper's readValue method
        when(objectMapper.readValue(any(String.class),
                any(Class.class))).thenReturn(testDataComponent);

        TestDataComponent result =
                jsonParserJackson.jsonStringToObject(objectStr,
                        TestDataComponent.class);

        assertEquals(testDataComponent, result);
    }

    /**
     * This method tests the failure scenario of the jsonObjectToString method
     * of the JsonParserJackson class.
     */
    @Test
    void testObjectToJsonStringFailure() throws JsonProcessingException {

        // Mock ObjectMapper's writeValueAsString method
        when(objectMapper.writeValueAsString(
                any(TestDataComponent.class))).thenThrow(
                JsonProcessingException.class);

        assertThrows(OutsetaParseException.class,
                () -> jsonParserJackson.objectToJsonString(testDataComponent));
    }

    /**
     * This method tests the failure scenario of the jsonStringToObject method
     * of the JsonParserJackson class.
     */
    @Test
    void testJsonStringToObjectFailure() throws JsonProcessingException {

        // Mock ObjectMapper's readValue method
        when(objectMapper.readValue(any(String.class),
                any(Class.class))).thenThrow(JsonProcessingException.class);

        assertThrows(OutsetaParseException.class,
                () -> jsonParserJackson.jsonStringToObject(objectStr,
                        TestDataComponent.class));
    }
}
