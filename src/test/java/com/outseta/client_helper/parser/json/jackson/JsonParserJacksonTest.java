package com.outseta.client_helper.parser.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.outseta.client_helper.parser.json.TestDataComponent;
import com.outseta.client_helper.parser.json.TestNestedData;
import com.outseta.exception.OutsetaParseException;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Metadata;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * This class tests the JsonParserJackson class.
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
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
     * Creating ObjectReader mock object.
     */
    @Mock
    private ObjectReader objectReader;

    /**
     * Creating JsonNode mock object.
     */
    @Mock
    private JsonNode jsonNode;

    /**
     * Creating metadata JsonNode mock object.
     */
    @Mock
    private JsonNode metadataJsonNode;

    /**
     * Creating items JsonNode mock object.
     */
    @Mock
    private JsonNode itemsJsonNode;

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

    /**
     * This method tests the json string to page method of the
     * JsonParserJackson.
     */
    @Test
    void testJsonStringToPageSuccess()
            throws JsonProcessingException, OutsetaParseException {

        final String metadataStr = "{\n"
                + "        \"limit\": 10,\n"
                + "        \"offset\": 0,\n"
                + "        \"total\": 1\n"
                + "    }";

        final String itemsStr = "[" + objectStr + ", " + objectStr + "]";

        final Metadata metadataObj = new Metadata(10, 0, 1);

        when(objectReader.readValue(itemsStr)).thenReturn(
                List.of(testDataComponent, testDataComponent)
        );

        // Mock ObjectMapper's readValue method
        when(objectMapper.
                readerForListOf(eq(TestDataComponent.class)))
                .thenReturn(objectReader);

        when(objectMapper.readValue(any(String.class),
                eq(Metadata.class))).thenReturn(metadataObj);

        when(objectMapper.readTree(any(String.class)))
                .thenReturn(jsonNode);

        when(jsonNode.get("metadata")).thenReturn(metadataJsonNode);
        when(jsonNode.get("items")).thenReturn(itemsJsonNode);

        when(metadataJsonNode.toString()).thenReturn(
                metadataStr
        );

        when(itemsJsonNode.toString()).thenReturn(
                itemsStr
        );

        ItemPage<TestDataComponent> result =
                jsonParserJackson.jsonStringToPage(objectStr,
                        TestDataComponent.class);

        assertEquals(testDataComponent, result.getItems().get(0));
    }

    /**
     * This method tests the json string to page method of the
     * JsonParserJackson.
     * It tests the failure scenario of the method.
     */
    @Test
    void testJsonStringToPageFailure()
            throws JsonProcessingException, OutsetaParseException {

        final String metadataStr = "{\n"
                + "        \"limit\": 10,\n"
                + "        \"offset\": 0,\n"
                + "        \"total\": 1\n"
                + "    }";

        final String itemsStr = "[" + objectStr + ", " + objectStr + "]";

        final Metadata metadataObj = new Metadata(10, 0, 1);

        when(objectReader.readValue(itemsStr)).thenReturn(
                List.of(testDataComponent, testDataComponent)
        );

        // Mock ObjectMapper's readValue method
        when(objectMapper.
                readerForListOf(eq(TestDataComponent.class)))
                .thenReturn(objectReader);

        when(objectMapper.readTree(any(String.class)))
                .thenReturn(jsonNode);

        when(jsonNode.get("metadata")).thenReturn(metadataJsonNode);
        when(jsonNode.get("items")).thenReturn(itemsJsonNode);

        when(metadataJsonNode.toString()).thenReturn(
                metadataStr
        );

        when(itemsJsonNode.toString()).thenReturn(
                itemsStr
        );

        when(objectMapper.readValue(any(String.class),
                any(Class.class))).thenThrow(JsonProcessingException.class);

        assertThrows(OutsetaParseException.class,
                () -> jsonParserJackson.jsonStringToPage(objectStr,
                        TestDataComponent.class));
    }
}
