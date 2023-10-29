package com.outseta.client.endpoint_client;

import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.UpdatePasswordRequest;
import com.outseta.model.result.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the ProfileClient class.
 */
@ExtendWith(MockitoExtension.class)
public class ProfileClientUnitTest {

    /**
     * The Outseta URL used for testing.
     */
    private static final String OUTSETA_URL = "https://dummy.com";

    /**
     * The access key used for testing.
     */
    private static final String ACCESS_KEY = "dummyKey";

    /**
     * The profile client to test.
     */
    private ProfileClient profileClient;

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
     * The mock profile string.
     */
    private String profileStr;

    /**
     * The mock profile.
     */
    @Mock
    private Person profile;

    /**
     * The mock update password request.
     */
    @Mock
    private UpdatePasswordRequest updatePasswordRequest;

    /**
     * The mock update password request string.
     */
    private String updatePasswordRequestStr;

    /**
     * Sets up the test.
     */
    @BeforeEach
    public void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {

        when(parserFacade.getJsonParser()).thenReturn(jsonParser);

        this.profileClient = ProfileClient.builder(OUTSETA_URL)
                .accessKey(ACCESS_KEY)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .build();

        profileStr = "profileDummy";
        updatePasswordRequestStr = "updatePasswordRequestDummy";
    }

    /**
     * This method tests that the builder throws an exception if api key
     * method is called instead of access key.
     */
    @Test
    public void testApiKeyThrowsException() {
        assertThrows(OutsetaClientBuildException.class, () -> {
            profileClient = ProfileClient.builder(OUTSETA_URL)
                    .apiKey(ACCESS_KEY)
                    .parser(parserFacade)
                    .requestMaker(requestMaker)
                    .build();
        });
    }

    /**
     * This method tests the getProfile method.
     */
    @Test
    public void testGetProfile() {
        assertDoesNotThrow(() -> {
            when(requestMaker.get(OUTSETA_URL + "/profile",
                    new HashMap<>(), profileClient.getHeaders()))
                    .thenReturn(profileStr);
            when(parserFacade.jsonStringToObject(profileStr,
                    Person.class))
                    .thenReturn(profile);
            Person result = profileClient
                    .getProfile();

            assertEquals(profile, result);
        });
    }

    /**
     * This method tests the updateProfile method.
     */
    @Test
    public void testUpdateProfile() {
        assertDoesNotThrow(() -> {
            when(requestMaker.put(OUTSETA_URL + "/profile",
                    new HashMap<>(),
                    profileStr, profileClient.getHeaders()))
                    .thenReturn(profileStr);
            when(parserFacade.jsonStringToObject(profileStr,
                    Person.class))
                    .thenReturn(profile);
            when(parserFacade.objectToJsonString(profile))
                    .thenReturn(profileStr);
            Person result = profileClient
                    .updateProfile(profile);

            assertEquals(profile, result);
        });
    }

    /**
     * This method tests the updateProfile method.
     * It tests that the method throws an exception if the profile is null.
     */
    @Test
    public void testUpdateProfileThrowsException() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            profileClient.updateProfile(null);
        });
    }

    /**
     * This method tests the updatePassword method.
     */
    @Test
    public void testUpdatePassword() {
        assertDoesNotThrow(() -> {
            when(requestMaker.put(OUTSETA_URL + "/profile/password",
                    new HashMap<>(),
                    updatePasswordRequestStr, profileClient.getHeaders()))
                    .thenReturn("");
            when(parserFacade.objectToJsonString(updatePasswordRequest))
                    .thenReturn(updatePasswordRequestStr);
            profileClient
                    .updatePassword(updatePasswordRequest);
        });
    }

    /**
     * This method tests the updatePassword method.
     * It tests that the method throws an exception if the request is null.
     */
    @Test
    public void testUpdatePasswordThrowsException() {
        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            profileClient.updatePassword(null);
        });
    }
}
