package com.outseta.model.request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class tests the UpdatePasswordRequest class.
 */
@ExtendWith(MockitoExtension.class)
public class UpdatePasswordRequestTest {

    /**
     * The instance of UpdatePasswordRequest to be tested.
     */
    private UpdatePasswordRequest updatePasswordRequest;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    public void setUp() {
        updatePasswordRequest = UpdatePasswordRequest.builder()
                .existingPassword("existingPassword")
                .newPassword("newPassword")
                .build();
    }

    /**
     * Tests the values set by the builder.
     */
    @Test
    public void testBuilder() {
        assertEquals("existingPassword",
                updatePasswordRequest.getExistingPassword());
        assertEquals("newPassword",
                updatePasswordRequest.getNewPassword());
    }

    /**
     * This method tests the default values set by the builder.
     */
    @Test
    public void testDefaultValues() {
        updatePasswordRequest = new UpdatePasswordRequest.Builder().build();
        assertNull(updatePasswordRequest.getExistingPassword());
        assertNull(updatePasswordRequest.getNewPassword());
    }

    /**
     * This method tests the get and set methods of the existing password.
     */
    @Test
    public void testGetSetExistingPassword() {
        updatePasswordRequest.setExistingPassword("newExistingPassword");
        assertEquals("newExistingPassword",
                updatePasswordRequest.getExistingPassword());
    }

    /**
     * This method tests the get and set methods of the new password.
     */
    @Test
    public void testGetSetNewPassword() {
        updatePasswordRequest.setNewPassword("newNewPassword");
        assertEquals("newNewPassword",
                updatePasswordRequest.getNewPassword());
    }
}
