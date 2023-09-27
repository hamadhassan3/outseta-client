package com.outseta.client;

import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaClientBuildException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientBuilderTest {

    private BaseClient baseClient;
    private ClientBuilder clientBuilder;

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
    void testBuildWithAllRequiredFields() throws OutsetaClientBuildException {
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
    void testBuildWithMissingRequiredFields() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.build();
        });
    }

    @Test
    void testBuildWithInvalidRequestMaker() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.requestMaker("INVALID");
        });
    }

    @Test
    void testBuildWithInvalidParserFacade() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.parser(null);
        });
    }

    @Test
    void testBuildWithMissingApiKey() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.accessKey("accessKey")
                    .baseUrl("http://dummyurl2.com").build();
        });
    }

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

}
