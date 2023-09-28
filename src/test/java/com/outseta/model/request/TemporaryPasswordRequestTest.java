package com.outseta.model.request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class tests the TemporaryPasswordRequest class.
 */
public class TemporaryPasswordRequestTest {

    /**
     * The TemporaryPasswordRequest object used for testing.
     */
    private TemporaryPasswordRequest temporaryPasswordRequest;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    public void setUp() {
        temporaryPasswordRequest = TemporaryPasswordRequest.builder()
                .temporaryPassword("tempPassword")
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
     * This method tests the TemporaryPasswordRequest class's builder's
     * constructor.
     */
    @Test
    public void testBuilderConstructor() {

        // Testing the builder constructor
        TemporaryPasswordRequest.Builder builder =
                TemporaryPasswordRequest.builder();
        assertNotNull(builder);
    }

    /**
     * This method tests the TemporaryPasswordRequest class's builder method.
     */
    @Test
    public void testBuilder() {

        // Testing the builder method
        TemporaryPasswordRequest.Builder builder =
                TemporaryPasswordRequest.builder();
        assertNotNull(builder);

        assertNull(builder.build().getTemporaryPassword());

        // Creating a GetAuthTokenRequest object using the builder
        TemporaryPasswordRequest request = builder
                .temporaryPassword("tempPassword")
                .build();

        // Testing that the GetAuthTokenRequest object was created correctly
        assertNotNull(request);
        assertEquals("tempPassword", request.getTemporaryPassword());
    }

    /**
     * This method tests the TemporaryPasswordRequest class's getter and setter
     * methods.
     */
    @Test
    public void testGettersAndSetters() {

        // Testing the getter and setter methods
        assertNotNull(temporaryPasswordRequest);
        assertEquals("tempPassword", temporaryPasswordRequest
                .getTemporaryPassword());

        temporaryPasswordRequest.setTemporaryPassword("tempPassword2");
        assertEquals("tempPassword2", temporaryPasswordRequest
                .getTemporaryPassword());
    }

}
