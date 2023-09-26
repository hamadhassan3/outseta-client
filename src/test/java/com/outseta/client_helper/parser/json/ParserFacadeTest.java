package com.outseta.client_helper.parser.json;

import com.outseta.exception.OutsetaParseException;
import com.outseta.model.DataComponent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * This class tests the ParserFacade class. It mocks a JsonParser.
 */
@ExtendWith(MockitoExtension.class)
class ParserFacadeTest {
    private static String objectStr;
            // String representation of the test object

    private static TestDataComponent testDataComponent;   // Test object

    @BeforeAll
    static void setUp() {
        // Creating a test object and its json string representation
        objectStr =
                "{\"str\":\"test\",\"dbl\":1.0,\"integer\":1,\"bool\":true,\"testNestedData\":{\"str\":\"test\",\"dbl\":1.0,\"integer\":1,\"bool\":true}}";
        testDataComponent = new TestDataComponent("test", 1.0, 1, true,
                new TestNestedData("test", 1.0, 1, true));
    }

    /**
     * Creating JsonParser mock object.
     */
    @Mock
    private JsonParser jsonParser;

    /**
     * Creating ParserFacade object with the mocked JsonParser.
     */
    @InjectMocks
    private ParserFacade parserFacade;

    /**
     * This method tests the constructor of the ParserFacade class.
     */
    @Test
    void testConstructorSuccess() {
        ParserFacade temp = new ParserFacade(jsonParser);
    }

    /**
     * This method tests the objectToJsonString method of the ParserFacade class.
     */
    @Test
    void testObjectToJsonStringSuccess() throws OutsetaParseException {

        // Mock JsonParser's objectToJsonString method
        when(jsonParser.objectToJsonString(
                any(DataComponent.class))).thenReturn(objectStr);

        // Call the method
        String jsonString = parserFacade.objectToJsonString(testDataComponent);

        // Assert that the result matches
        assertEquals(objectStr, jsonString);
    }

    /**
     * This method tests the jsonStringToObject method of the ParserFacade class.
     */
    @Test
    void testJsonStringToObjectSuccess() throws OutsetaParseException {

        // Mock JsonParser's jsonStringToObject method
        when(jsonParser.jsonStringToObject(any(String.class),
                any(Class.class))).thenReturn(testDataComponent);

        // Call the method
        TestDataComponent result = parserFacade.jsonStringToObject(objectStr,
                TestDataComponent.class);

        // Verify the result
        assertEquals(testDataComponent, result);
    }

    /**
     * This method tests the jsonStringToObject method of the ParserFacade class.
     * It tests the failure scenario.
     */
    @Test
    void testJsonStringToObjectFailure() throws OutsetaParseException {

        // Mock JsonParser's jsonStringToObject method
        when(jsonParser.jsonStringToObject(any(String.class),
                any(Class.class))).thenThrow(new OutsetaParseException(""));

        // Verify the result
        assertThrows(OutsetaParseException.class, () ->
                parserFacade.jsonStringToObject(objectStr,
                        TestDataComponent.class));
    }

    /**
     * This method tests the objectToJsonString method of the ParserFacade class.
     * It tests the failure scenario.
     */
    @Test
    void testObjectToJsonStringFailure() throws OutsetaParseException {

        // Mock JsonParser's objectToJsonString method
        when(jsonParser.objectToJsonString(any(DataComponent.class))).thenThrow(
                new OutsetaParseException(""));

        // Verify the result
        assertThrows(OutsetaParseException.class, () ->
                parserFacade.objectToJsonString(testDataComponent));
    }
}
