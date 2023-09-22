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
        assertEquals(this.clientBuilder, this.clientBuilder.withHeaders(headers));
        assertEquals(headers, baseClient.getHeaders());
    }

    @Test
    void testBuildWithAllRequiredFields() throws OutsetaClientBuildException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("Authorization", "apiKey");
        assertEquals(this.clientBuilder, this.clientBuilder.withAccessKey("accessKey"));
        assertEquals(this.clientBuilder, this.clientBuilder.withDefaultParser());
        assertEquals(this.clientBuilder, this.clientBuilder.withBaseUrl("http://dummyurl2.com"));
        assertEquals(this.clientBuilder, this.clientBuilder.withRequestMaker(RequestMakerType.HTTP_CLIENT));
        assertEquals(this.clientBuilder, this.clientBuilder.withApiKey("apiKey"));
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
            this.clientBuilder.withRequestMaker("INVALID");
        });
    }

    @Test
    void testBuildWithInvalidParserFacade() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.withParser(null);
        });
    }

    @Test
    void testBuildWithMissingApiKey() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.withAccessKey("accessKey").withBaseUrl("http://dummyurl2.com").build();
        });
    }

    @Test
    void testBuildWithMissingAccessKey() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.withApiKey("apiKey").withBaseUrl("http://dummyurl2.com").build();
        });
    }

    @Test
    void testBuildWithMissingBaseUrl() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.withApiKey("apiKey").withAccessKey("accessKey").build();
        });
    }

    @Test
    void testBuildWithDefaultRequestMaker() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.withDefaultRequestMaker().build();
        });
    }

    @Test
    void testBuildWithDefaultParser() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.withDefaultParser().build();
        });
    }

    @Test
    void testBuildWithDefaultParserAndRequestMaker() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            this.clientBuilder.withDefaultParser().withDefaultRequestMaker().build();
        });
    }

}
