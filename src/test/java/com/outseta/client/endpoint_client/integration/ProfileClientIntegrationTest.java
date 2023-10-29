package com.outseta.client.endpoint_client.integration;

import com.outseta.client.endpoint_client.AuthenticationClient;
import com.outseta.client.endpoint_client.ProfileClient;
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
import com.outseta.model.request.UpdatePasswordRequest;
import com.outseta.model.result.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class is used to test the ProfileClient class.
 * It is an integration test because it uses the actual ProfileClient class.
 */
@ExtendWith(MockitoExtension.class)
@Tag("integration")
public class ProfileClientIntegrationTest {

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");

    /**
     * The ProfileClient to test.
     */
    private static ProfileClient profileClient;

    /**
     * This method is called before each test to set up the test environment.
     */
    @BeforeAll
    public static void setup() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaParseException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        String accessKey = AuthenticationClient.builder(outsetaUrl)
                .defaultParser()
                .defaultRequestMaker()
                .build()
                .getAuthToken(GetAuthTokenRequest.builder()
                        .username(System.getenv("SIGNED_UP_USERNAME"))
                        .password(System.getenv("SIGNED_UP_PASSWORD"))
                        .build())
                .getAccessToken();

        profileClient = ProfileClient.builder(outsetaUrl)
                .accessKey(accessKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();
    }

    /**
     * This method tests the getProfile method.
     */
    @Test
    public void getProfileTest() {
        assertDoesNotThrow(() -> {
            Person profile = profileClient.getProfile();

            assertEquals(System.getenv("SIGNED_UP_USERNAME"),
                    profile.getEmail());
        });
    }

    /**
     * This method tests the updateProfile method.
     */
    @Test
    public void updateProfileTest() {
        assertDoesNotThrow(() -> {

            Person currentProfile = profileClient.getProfile();

            Person profile = profileClient.updateProfile(Person.builder()
                    .email(System.getenv("SIGNED_UP_USERNAME"))
                    .firstName("Test")
                    .lastName("User")
                    .build());

            assertEquals("Test", profile.getFirstName());
            assertEquals("User", profile.getLastName());

            // Reset the profile.
            Person resetProfile = profileClient.updateProfile(currentProfile);

            assertEquals(currentProfile.getEmail(),
                    resetProfile.getEmail());
            assertEquals(currentProfile.getFirstName(),
                    resetProfile.getFirstName());
            assertEquals(currentProfile.getLastName(),
                    resetProfile.getLastName());
        });
    }

    /**
     * This method tests the updatePassword method.
     */
    @Test
    public void updatePasswordTest() {
        assertDoesNotThrow(() -> {

            profileClient.updatePassword(UpdatePasswordRequest.builder()
                    .existingPassword(System.getenv("SIGNED_UP_PASSWORD"))
                    .newPassword("Testing9!")
                    .build());

            // Reset the password.
            profileClient.updatePassword(UpdatePasswordRequest.builder()
                    .existingPassword("Testing9!")
                    .newPassword(System.getenv("SIGNED_UP_PASSWORD"))
                    .build());
        });
    }
}
