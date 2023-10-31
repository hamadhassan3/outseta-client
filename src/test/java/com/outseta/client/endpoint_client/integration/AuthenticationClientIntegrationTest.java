package com.outseta.client.endpoint_client.integration;

import com.outseta.client.endpoint_client.AuthenticationClient;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.OutsetaParseException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.model.request.GetAuthTokenRequest;
import com.outseta.model.result.AuthToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class is used to test the AuthenticationClient class.
 * It contains integration tests that make calls to the Outseta API.
 */
@ExtendWith(MockitoExtension.class)
@Tag("integration")
public class AuthenticationClientIntegrationTest {

    /**
     * The Outseta API Key.
     */
    private static String outsetaKey = System.getenv("OUTSETA_KEY");

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");

    /**
     * The authentication client to test.
     */
    private AuthenticationClient authenticationClient;

    /**
     * This method is called before each test to set up the test environment.
     */
    @BeforeEach
    public void setup() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaParseException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {
        authenticationClient = AuthenticationClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();
    }

    /**
     * This method tests the getAuthToken method with api key.
     */
    @Test
    public void testGetAuthTokenWithApiKey() {

        assertDoesNotThrow(() -> {

            AuthToken authToken = authenticationClient.getAuthToken(
                    GetAuthTokenRequest.builder()
                            .username(System.getenv("SIGNED_UP_USERNAME"))
                            .build());

            assertNotNull(authToken);
            assertNotNull(authToken.getAccessToken());
            assertNotNull(authToken.getTokenType());
            assertFalse(authToken.getAccessToken().trim().isEmpty());
            assertFalse(authToken.getAccessToken().trim().isEmpty());
            assertNotEquals(0, authToken.getExpiresIn());
        });
    }

    /**
     * This method tests the getAuthToken method with just username and
     * password.
     */
    @Test
    public void testGetAuthTokenWithoutApiKey() {

        assertDoesNotThrow(() -> {

            // Creating an authentication client without any authentication
            // token or api key.
            AuthenticationClient testAuthenticationClient =
                    AuthenticationClient.builder(outsetaUrl)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build();

            AuthToken authToken = testAuthenticationClient.getAuthToken(
                    GetAuthTokenRequest.builder()
                            .username(System.getenv("SIGNED_UP_USERNAME"))
                            .password(System.getenv("SIGNED_UP_PASSWORD"))
                            .build());

            assertNotNull(authToken);
            assertNotNull(authToken.getAccessToken());
            assertNotNull(authToken.getTokenType());
            assertFalse(authToken.getAccessToken().trim().isEmpty());
            assertFalse(authToken.getAccessToken().trim().isEmpty());
            assertNotEquals(0, authToken.getExpiresIn());
        });
    }
}
