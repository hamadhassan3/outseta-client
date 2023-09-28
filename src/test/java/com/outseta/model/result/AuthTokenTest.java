package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class tests the AuthToken class.
 */
@ExtendWith(MockitoExtension.class)
public class AuthTokenTest {

    /**
     * The AuthToken object used for testing.
     */
    private AuthToken authToken;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    public void setUp() {
        final long expiresIn = 123456789L;

        // Creating an Authtoken object for testing
        authToken = new AuthToken("token", "type",
                expiresIn);
    }

    /**
     * This method tests the AuthToken class's constructor.
     */
    @Test
    public void testConstructor() {
        final long expiresIn = 123456789L;

        // Testing the constructor
        AuthToken a1 = new AuthToken();
        AuthToken a2 = new AuthToken("token", "type",
                expiresIn);

        assertNull(a1.getAccessToken());
        assertNull(a1.getTokenType());
        assertNull(a1.getExpiresIn());

        assertEquals("token", a2.getAccessToken());
        assertEquals("type", a2.getTokenType());
        assertEquals(expiresIn, a2.getExpiresIn());

    }

    /**
     * This method tests the AuthToken class's getAccessToken method.
     */
    @Test
    public void testGetAccessToken() {
        // Testing the getAccessToken method
        assertEquals("token", authToken.getAccessToken());
    }

    /**
     * This method tests the AuthToken class's setAccessToken method.
     */
    @Test
    public void testSetAccessToken() {
        // Testing the setAccessToken method
        authToken.setAccessToken("newToken");
        assertEquals("newToken", authToken.getAccessToken());
    }

    /**
     * This method tests the AuthToken class's getTokenType method.
     */
    @Test
    public void testGetTokenType() {
        // Testing the getTokenType method
        assertEquals("type", authToken.getTokenType());
    }

    /**
     * This method tests the AuthToken class's setTokenType method.
     */
    @Test
    public void testSetTokenType() {
        // Testing the setTokenType method
        authToken.setTokenType("newType");
        assertEquals("newType", authToken.getTokenType());
    }

    /**
     * This method tests the AuthToken class's getExpiresIn method.
     */
    @Test
    public void testGetExpiresIn() {
        final long expiresIn = 123456789L;

        // Testing the getExpiresIn method
        assertEquals(expiresIn, authToken.getExpiresIn());
    }

    /**
     * This method tests the AuthToken class's setExpiresIn method.
     */
    @Test
    public void testSetExpiresIn() {
        final long expiresIn = 987654321L;

        // Testing the setExpiresIn method
        authToken.setExpiresIn(expiresIn);
        assertEquals(expiresIn, authToken.getExpiresIn());
    }

    /**
     * This method tests the AuthToken class's equals method.
     */
    @Test
    public void testEquals() {

        final long expiresIn = 123456789L;

        // Creating an object to compare with
        AuthToken a1 = new AuthToken();
        AuthToken a2 = new AuthToken("token", "type",
                expiresIn);

        // Creating an equal object
        AuthToken a3 = new AuthToken("token", "type",
                expiresIn);

        // Testing the equals method
        assertEquals(a1, a1);
        assertEquals(a2, a2);
        assertEquals(authToken, a3);
        assertNotEquals(a1, null);
        assertNotEquals(a1, new Object());
        assertNotEquals(a2, null);
        assertNotEquals(a2, new Object());
        assertNotEquals(a1, a2);
    }

    /**
     * This method tests the AuthToken class's hashCode method.
     */
    @Test
    public void testHashCode() {

        final long expiresIn = 123456789L;

        // Creating an object to compare with
        AuthToken a1 = new AuthToken();
        AuthToken a2 = new AuthToken("token", "type",
                expiresIn);

        // Creating an equal object
        AuthToken a3 = new AuthToken("token", "type",
                expiresIn);

        // Testing the hashCode method
        assertEquals(a1.hashCode(), a1.hashCode());
        assertEquals(a2.hashCode(), a2.hashCode());
        assertEquals(authToken.hashCode(), a3.hashCode());
        assertNotEquals(a1.hashCode(), a2.hashCode());
    }
}
