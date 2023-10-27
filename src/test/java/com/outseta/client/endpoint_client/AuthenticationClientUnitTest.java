package com.outseta.client.endpoint_client;

import com.outseta.client.ClientBuilder;
import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.GetAuthTokenRequest;
import com.outseta.model.result.AuthToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the AuthenticationClient class.
 */
@ExtendWith(MockitoExtension.class)
public class AuthenticationClientUnitTest {

    /**
     * The Outseta URL used for testing.
     */
    private static final String OUTSETA_URL = "https://dummy.com";

    /**
     * The Outseta Key used for testing.
     */
    private static final String OUTSETA_KEY = "dummyKey";

    /**
     * The authentication client to test.
     */
    private AuthenticationClient authenticationClient;

    /**
     * The mock parser facade.
     */
    @Mock
    private ParserFacade parserFacade;

    /**
     * The mock json parser.
     */
    @Mock
    private JsonParser jsonParser;

    /**
     * The mock request maker.
     */
    @Mock
    private RequestMaker requestMaker;

    /**
     * The mock get auth token request.
     */
    @Mock
    private GetAuthTokenRequest getAuthTokenRequest;

    /**
     * The mock auth token.
     */
    @Mock
    private AuthToken authToken;

    /**
     * This method is used to setup the tests.
     */
    @BeforeEach
    public void setup() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        when(parserFacade.getJsonParser()).thenReturn(jsonParser);
        authenticationClient = AuthenticationClient.builder(OUTSETA_URL)
                .apiKey(OUTSETA_KEY)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .build();
    }

    /**
     * This method is used to test the builder of AuthenticationClient class.
     */
    @Test
    public void testBuilder() {

        assertDoesNotThrow(() -> {
            ClientBuilder<AuthenticationClient> builder1 =
                    AuthenticationClient
                            .builder(OUTSETA_URL);
            assertEquals(builder1, builder1.defaultParser());
            assertEquals(builder1, builder1.defaultRequestMaker());
            assertEquals(builder1, builder1.apiKey(OUTSETA_KEY));
            assertEquals(builder1, builder1.baseUrl(OUTSETA_URL));
            assertEquals(builder1, builder1.accessKey("dummy"));
            assertEquals(builder1, builder1
                    .headers(Map.of("Authorization", "dummy")));
            assertEquals(builder1, builder1
                    .requestMaker("DEFAULT"));
            assertEquals(builder1, builder1
                    .requestMaker(RequestMakerType.DEFAULT));

            assertNotNull(builder1.build());
        });

        assertDoesNotThrow(() -> {

            when(parserFacade.getJsonParser()).thenReturn(jsonParser);
            ClientBuilder<AuthenticationClient> builder2 =
                    AuthenticationClient
                            .builder(OUTSETA_URL);
            assertEquals(builder2, builder2.defaultParser());
            assertEquals(builder2, builder2.defaultRequestMaker());
            assertEquals(builder2, builder2.apiKey(OUTSETA_KEY));
            assertEquals(builder2, builder2.baseUrl(OUTSETA_URL));
            assertEquals(builder2, builder2.parser(parserFacade));
            assertEquals(builder2, builder2.requestMaker(requestMaker));

            assertNotNull(builder2.build());
        });
    }

    /**
     * This method tests the failure scenario of the builder method
     * of the AuthenticationClient class.
     */
    @Test
    public void testBuilderFailure() {

        // Testing empty object
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder(null)
        );
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder("")
        );

        // Testing null outsetaUrl but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder(null)
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing empty outsetaUrl but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder("")
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing null Outseta Key but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder(OUTSETA_URL)
                        .apiKey(null)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing empty Outseta Key but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder(OUTSETA_URL)
                        .apiKey("")
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing without parser but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder(OUTSETA_URL)
                        .apiKey(OUTSETA_KEY)
                        .defaultRequestMaker()
                        .build()
        );

        // Testing without request maker but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AuthenticationClient.builder(OUTSETA_URL)
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .build()
        );
    }

    /**
     * This method is used to test the getAuthToken method of the
     * AuthenticationClient class.
     */
    @Test
    public void testGetAuthToken() {

        assertDoesNotThrow(() -> {

            when(parserFacade.jsonStringToObject("dummyToken",
                    AuthToken.class)).thenReturn(authToken);
            when(getAuthTokenRequest.getUsername())
                    .thenReturn("dummyUsername");
            when(getAuthTokenRequest.getPassword())
                    .thenReturn("dummyPassword");
            when(requestMaker.urlEncodePayloadAttribute("dummyUsername"))
                    .thenReturn("dummyUsername");
            when(requestMaker.urlEncodePayloadAttribute("dummyPassword"))
                    .thenReturn("dummyPassword");
            when(requestMaker.post(OUTSETA_URL + "/tokens", new HashMap<>(),
                    "username=dummyUsername&password=dummyPassword",
                    authenticationClient.getHeaders()))
                    .thenReturn("dummyToken");

            AuthToken result = authenticationClient
                    .getAuthToken(getAuthTokenRequest);
            assertNotNull(result);
            assertEquals(result, authToken);
        });
    }

    /**
     * This method is used to test the getAuthToken method of the
     * AuthenticationClient class with null request.
     */
    @Test
    public void testGetAuthTokenNullRequest() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            authenticationClient.getAuthToken(null);
        });
    }

    /**
     * This method is used to test the getAuthToken method of the
     * AuthenticationClient class with null username.
     */
    @Test
    public void testGetAuthTokenNullUsername() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            when(getAuthTokenRequest.getUsername()).thenReturn(null);
            authenticationClient.getAuthToken(getAuthTokenRequest);
        });
    }

    /**
     * This method is used to test the getAuthToken method of the
     * AuthenticationClient class with empty username.
     */
    @Test
    public void testGetAuthTokenEmptyUsername() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            when(getAuthTokenRequest.getUsername()).thenReturn("");
            authenticationClient.getAuthToken(getAuthTokenRequest);
        });
    }

    /**
     * This method is used to test the getAuthToken method of the
     * AuthenticationClient class with null password.
     */
    @Test
    public void testGetAuthTokenNullPassword() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            authenticationClient.getHeaders().remove("Authorization");
            when(getAuthTokenRequest.getUsername())
                    .thenReturn("dummyUsername");
            when(getAuthTokenRequest.getPassword())
                    .thenReturn(null);
            authenticationClient.getAuthToken(getAuthTokenRequest);
        });
    }

    /**
     * This method is used to test the getAuthToken method of the
     * AuthenticationClient class with empty password.
     */
    @Test
    public void testGetAuthTokenEmptyPassword() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {

            authenticationClient.getHeaders().remove("Authorization");
            when(getAuthTokenRequest.getUsername())
                    .thenReturn("dummyUsername");
            when(getAuthTokenRequest.getPassword()).thenReturn("");
            authenticationClient.getAuthToken(getAuthTokenRequest);
        });
    }

    /**
     * This method tests without Authorization but with password.
     */
    @Test
    public void testWithoutAuthorizationButWithPassword() {
        assertDoesNotThrow(() -> {

            authenticationClient.getHeaders().remove("Authorization");
            when(parserFacade.jsonStringToObject("dummyToken",
                    AuthToken.class)).thenReturn(authToken);
            when(getAuthTokenRequest.getUsername())
                    .thenReturn("dummyUsername");
            when(getAuthTokenRequest.getPassword()).thenReturn(
                    "dummyPassword");
            when(requestMaker.urlEncodePayloadAttribute("dummyUsername"))
                    .thenReturn("dummyUsername");
            when(requestMaker.urlEncodePayloadAttribute("dummyPassword"))
                    .thenReturn("dummyPassword");
            when(requestMaker.post(OUTSETA_URL + "/tokens", new HashMap<>(),
                    "username=dummyUsername&password=dummyPassword",
                    authenticationClient.getHeaders()))
                    .thenReturn("dummyToken");

            AuthToken result = authenticationClient
                    .getAuthToken(getAuthTokenRequest);
            assertNotNull(result);
            assertEquals(result, authToken);
        });
    }

    /**
     * This method tests with Authorization but without password.
     */
    @Test
    public void testWithAuthorizationButWithoutPassword() {

        assertDoesNotThrow(() -> {

            when(parserFacade.jsonStringToObject("dummyToken",
                    AuthToken.class)).thenReturn(authToken);
            when(getAuthTokenRequest.getUsername())
                    .thenReturn("dummyUsername");
            when(getAuthTokenRequest.getPassword())
                    .thenReturn(null);
            when(requestMaker.urlEncodePayloadAttribute("dummyUsername"))
                    .thenReturn("dummyUsername");
            when(requestMaker.post(OUTSETA_URL + "/tokens", new HashMap<>(),
                    "username=dummyUsername",
                    authenticationClient.getHeaders()))
                    .thenReturn("dummyToken");

            AuthToken result = authenticationClient
                    .getAuthToken(getAuthTokenRequest);
            assertNotNull(result);
            assertEquals(result, authToken);
        });
    }

    /**
     * This method tests with Authorization but without password.
     */
    @Test
    public void testWithAuthorizationButWithBlankPassword() {

        assertDoesNotThrow(() -> {

            when(parserFacade.jsonStringToObject("dummyToken",
                    AuthToken.class)).thenReturn(authToken);
            when(getAuthTokenRequest.getUsername())
                    .thenReturn("dummyUsername");
            when(getAuthTokenRequest.getPassword())
                    .thenReturn("");
            when(requestMaker.urlEncodePayloadAttribute("dummyUsername"))
                    .thenReturn("dummyUsername");
            when(requestMaker.post(OUTSETA_URL + "/tokens", new HashMap<>(),
                    "username=dummyUsername",
                    authenticationClient.getHeaders()))
                    .thenReturn("dummyToken");

            AuthToken result = authenticationClient
                    .getAuthToken(getAuthTokenRequest);
            assertNotNull(result);
            assertEquals(result, authToken);
        });
    }

}
