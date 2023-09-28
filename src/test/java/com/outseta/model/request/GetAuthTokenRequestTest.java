package com.outseta.model.request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class tests the GetAuthTokenRequest class.
 */
@ExtendWith(MockitoExtension.class)
public class GetAuthTokenRequestTest {

    /**
     * The GetAuthTokenRequest object used for testing.
     */
    private GetAuthTokenRequest getAuthTokenRequest;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    public void setUp() {
        getAuthTokenRequest = new GetAuthTokenRequest.Builder()
                .username("username")
                .password("password")
                .build();
    }

    /**
     * This method tests that the class has no public constructors.
     */
    @Test
    public void testNoPublicConstructors() {

        // Testing that the class has no public constructors
        assertThrows(IllegalAccessException.class,
                TemporaryPasswordRequest.class::newInstance);
    }

    /**
     * This method tests the GetAuthTokenRequest class's builder's constructor.
     */
    @Test
    public void testBuilderConstructor() {

        // Testing the builder constructor
        GetAuthTokenRequest.Builder builder = new GetAuthTokenRequest.Builder();
        assertNotNull(builder);
    }

    /**
     * This method tests the GetAuthTokenRequest class's builder method.
     */
    @Test
    public void testBuilder() {

        // Testing the builder method
        GetAuthTokenRequest.Builder builder = GetAuthTokenRequest.builder();
        assertNotNull(builder);

        assertNull(builder.build().getUsername());
        assertNull(builder.build().getPassword());

        // Creating a GetAuthTokenRequest object using the builder
        GetAuthTokenRequest request = builder
                .username("username")
                .password("password")
                .build();

        // Testing that the GetAuthTokenRequest object was created correctly
        assertNotNull(request);
        assertEquals("username", request.getUsername());
        assertEquals("password", request.getPassword());
    }

    /**
     * This method tests the GetAuthTokenRequest class's getUsername method.
     */
    @Test
    public void testGetUsername() {

        // Testing the getUsername method
        assertEquals("username", getAuthTokenRequest.getUsername());
    }

    /**
     * This method tests the GetAuthTokenRequest class's setUsername method.
     */
    @Test
    public void testSetUsername() {

        // Testing the setUsername method
        getAuthTokenRequest.setUsername("username");
        assertEquals("username", getAuthTokenRequest.getUsername());
    }

    /**
     * This method tests the GetAuthTokenRequest class's getPassword method.
     */
    @Test
    public void testGetPassword() {

        // Testing the getPassword method
        assertEquals("password", getAuthTokenRequest.getPassword());
    }

    /**
     * This method tests the GetAuthTokenRequest class's setPassword method.
     */
    @Test
    public void testSetPassword() {

        // Testing the setPassword method
        getAuthTokenRequest.setPassword("password");
        assertEquals("password", getAuthTokenRequest.getPassword());
    }
}
