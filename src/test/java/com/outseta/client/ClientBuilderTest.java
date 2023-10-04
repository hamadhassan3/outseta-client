package com.outseta.client;

import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class tests the ClientBuilder class.
 */
@ExtendWith(MockitoExtension.class)
class ClientBuilderTest {

    /**
     * The client to be tested.
     */
    private BaseClient baseClient;

    /**
     * The client builder to be tested.
     */
    private ClientBuilder clientBuilder;

    /**
     * The parser facade to be used.
     */
    @Mock
    private ParserFacade parserFacade;

    /**
     * The json parser to be used.
     */
    @Mock
    private JsonParser jsonParser;

    @BeforeEach
    void setUp() throws OutsetaClientBuildException {
        this.baseClient = new BaseClient("http://dummyurl1.com");
        this.clientBuilder = new ClientBuilder(this.baseClient);
    }

    @Test
    void testValidBuild() throws OutsetaClientBuildException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        assertEquals(headers, baseClient.getHeaders());
        assertEquals("http://dummyurl1.com", baseClient.getBaseUrl());
        assertNull(baseClient.getRequestMaker());
        assertNull(baseClient.getParserFacade());
        headers.put("Authorization", "auth");
        assertEquals(this.clientBuilder,
                this.clientBuilder.headers(headers));
        assertEquals(headers, baseClient.getHeaders());
    }

    @Test
    void testBuildWithAllRequiredFields() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("Authorization", "apiKey");
        assertEquals(this.clientBuilder,
                this.clientBuilder.accessKey("accessKey"));
        assertEquals(this.clientBuilder,
                this.clientBuilder.defaultParser());
        assertEquals(this.clientBuilder,
                this.clientBuilder.baseUrl("http://dummyurl2.com"));
        assertEquals(this.clientBuilder, this.clientBuilder.requestMaker(
                RequestMakerType.HTTP_CLIENT));
        assertEquals(this.clientBuilder,
                this.clientBuilder.apiKey("apiKey"));
        assertDoesNotThrow(() -> {
            assertEquals(baseClient, this.clientBuilder.build());
        });
        assertEquals("http://dummyurl2.com", baseClient.getBaseUrl());
        assertEquals(headers, baseClient.getHeaders());
        assertNotNull(baseClient.getParserFacade());
        assertNotNull(baseClient.getRequestMaker());
        assertTrue(baseClient.isHeadersValid());
    }

    @Test
    void testBuildWithAllRequiredFields2() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("Authorization", "apiKey");
        assertEquals(this.clientBuilder,
                this.clientBuilder.accessKey("accessKey"));

        when(parserFacade.getJsonParser()).thenReturn(jsonParser);
        assertEquals(this.clientBuilder,
                this.clientBuilder.parser(parserFacade));
        assertEquals(this.clientBuilder,
                this.clientBuilder.baseUrl("http://dummyurl2.com"));
        assertEquals(this.clientBuilder, this.clientBuilder.requestMaker(
                "HTTP_CLIENT"));
        assertEquals(this.clientBuilder,
                this.clientBuilder.apiKey("apiKey"));
        assertDoesNotThrow(() -> {
            assertEquals(baseClient, this.clientBuilder.build());
        });
        assertEquals("http://dummyurl2.com", baseClient.getBaseUrl());
        assertEquals(headers, baseClient.getHeaders());
        assertNotNull(baseClient.getParserFacade());
        assertNotNull(baseClient.getRequestMaker());
        assertTrue(baseClient.isHeadersValid());
    }

    @Test
    void testBuildWithMissingRequiredFields() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.build();
        });
    }

    @Test
    void testBuildWithInvalidRequestMaker() {
        assertThrows(OutsetaInvalidRequestMakerException.class, () -> {
            this.clientBuilder.requestMaker("INVALID_VALUE");
        });
    }

    @Test
    void testBuildWithInvalidParserFacade() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.parser(null);
        });
    }

    /**
     * This method tests the builder with a null api key.
     */
    @Test
    void testBuildWithNullApiKey() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.apiKey(null)
                    .baseUrl("http://dummyurl2.com");
        });
    }

    /**
     * This method tests the builder with a blank api key.
     */
    @Test
    void testBuildWithBlankApiKey() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.apiKey("")
                    .baseUrl("http://dummyurl2.com");
        });
    }

    @Test
    void testBuildWithMissingApiKey() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.accessKey("accessKey")
                    .baseUrl("http://dummyurl2.com").build();
        });
    }

    /**
     * This method tests the builder with a null access.
     */
    @Test
    void testBuildWithNullAccessKey() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.accessKey(null)
                    .baseUrl("http://dummyurl2.com").build();
        });
    }

    /**
     * This method tests the builder with a blank access key.
     */
    @Test
    void testBuildWithBlankAccessKey() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.accessKey("")
                    .baseUrl("http://dummyurl2.com");
        });
    }

    /**
     * This method tests the build method with a missing access key.
     */
    @Test
    void testBuildWithMissingAccessKey() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.apiKey("apiKey")
                    .baseUrl("http://dummyurl2.com").build();
        });
    }

    @Test
    void testBuildWithMissingBaseUrl() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.apiKey("apiKey").accessKey("accessKey")
                    .build();
        });
    }

    @Test
    void testBuildWithDefaultRequestMaker() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.defaultRequestMaker().build();
        });
    }

    @Test
    void testBuildWithDefaultParser() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.defaultParser().build();
        });
    }

    @Test
    void testBuildWithDefaultParserAndRequestMaker() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.defaultParser().defaultRequestMaker()
                    .build();
        });
    }

    /**
     * This method tests the builder with a null base url.
     */
    @Test
    void testBuildWithNullBaseUrl() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.baseUrl(null);
        });
    }

    /**
     * This method tests the builder with a blank base url.
     */
    @Test
    void testBuildWithBlankBaseUrl() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.baseUrl("");
        });
    }

    /**
     * This method tess the build method with null headers.
     */
    @Test
    void testBuildWithNullHeaders() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.headers(null);
        });
    }

    /**
     * This method tests the build method with a null request maker.
     */
    @Test
    void testBuildWithNullRequestMaker() {
        assertThrows(OutsetaInvalidRequestMakerException.class, () -> {
            this.clientBuilder.requestMaker((String) null);
        });
    }

    /**
     * This method tests the build method with a blank request maker.
     */
    @Test
    void testBuildWithBlankRequestMaker() {
        assertThrows(OutsetaInvalidRequestMakerException.class, () -> {
            this.clientBuilder.requestMaker("");
        });
    }

    /**
     * This method tests the build method with a null request maker.
     */
    @Test
    void testBuildWithNullRequestMakerType() {
        assertThrows(OutsetaInvalidRequestMakerException.class, () -> {
            this.clientBuilder.requestMaker((RequestMakerType) null);
        });
    }

    /**
     * This method tests the build method with a null parser facade.
     */
    @Test
    void testBuildWithNullParserFacade() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.parser(null);
        });
    }

    /**
     * This method tests the build method with a null parser
     * inside parser facade.
     */
    @Test
    void testBuildWithNullParser() {

        when(parserFacade.getJsonParser()).thenReturn(null);
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.parser(parserFacade);
        });
    }

    /**
     * This method tests constructor with null base client.
     */
    @Test
    void testConstructorWithNullBaseClient() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            new ClientBuilder(null);
        });
    }

    /**
     * This method tests the build method with a null base url.
     */
    @Test
    void testBuildWithNullBaseUrl2() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.baseUrl(null);
        });
    }

    /**
     * This method tests the build method with a null requestmaker.
     */
    @Test
    void testBuildWithNullRequestMaker2() {
        assertThrows(OutsetaClientBuildException.class, () -> {

            when(parserFacade.getJsonParser()).thenReturn(jsonParser);

            Map<String, String> origHeaders = new HashMap<>();
            origHeaders.put("Authorization",
                    "apiKey");

            new ClientBuilder(new BaseClient("http://valid-url"))
                    .headers(origHeaders)
                    .parser(parserFacade)
                    .build();
        });
    }

}
