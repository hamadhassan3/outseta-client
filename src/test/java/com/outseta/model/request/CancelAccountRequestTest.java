package com.outseta.model.request;

import com.outseta.model.result.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class is used to test the Cancel Account Request object.
 */
@ExtendWith(MockitoExtension.class)
public class CancelAccountRequestTest {

    /**
     * The cancel account request.
     */
    private CancelAccountRequest cancelAccountRequest;

    /**
     * The mock account to cancel.
     */
    @Mock
    private Account account1;

    /**
     * The mock account to cancel.
     */
    @Mock
    private Account account2;

    /**
     * Sets up before each test.
     */
    @BeforeEach
    public void setup() {
        cancelAccountRequest = new CancelAccountRequest.Builder()
                .cancellationReason("Too expensive")
                .comment("I don't want to use the software for now.")
                .account(account1)
                .build();
    }

    /**
     * This method tests the Cancel Account Request object builder.
     */
    @Test
    public void testCancelAccountRequestBuilder() {

        assertEquals("Too expensive",
                cancelAccountRequest.getCancelationReason());
        assertEquals("I don't want to use the software for now.",
                cancelAccountRequest.getComment());
        assertEquals(account1, cancelAccountRequest.getAccount());
    }

    /**
     * This method tests the Cancel Account Request object builder
     * with defaults.
     */
    @Test
    public void testCancelAccountRequestBuilderWithDefaults() {
        CancelAccountRequest cancelAccountRequest1 = new
                CancelAccountRequest.Builder().build();

        assertNull(cancelAccountRequest1.getCancelationReason());
        assertNull(cancelAccountRequest1.getComment());
        assertNull(cancelAccountRequest1.getAccount());
    }

    /**
     * This method tests the setter for cancellation reason.
     */
    @Test
    public void testSetCancelationReason() {
        cancelAccountRequest.setCancellationReason("Too expensive");
        assertEquals("Too expensive",
                cancelAccountRequest.getCancelationReason());
    }

    /**
     * This method tests the setter for comment.
     */
    @Test
    public void testSetComment() {
        cancelAccountRequest
                .setComment("I don't want to use the software for now.");
        assertEquals("I don't want to use the software for now.",
                cancelAccountRequest.getComment());
    }

    /**
     * This method tests the setter for account.
     */
    @Test
    public void testSetAccount() {
        cancelAccountRequest.setAccount(account2);
        assertEquals(account2, cancelAccountRequest.getAccount());
    }

    /**
     * This method tests the builder method.
     */
    @Test
    public void testBuilder() {
        CancelAccountRequest cancelAccountRequest1 = CancelAccountRequest
                .builder()
                .cancellationReason("Too expensive")
                .comment("I don't want to use the software for now.")
                .account(account1)
                .build();

        assertEquals("Too expensive",
                cancelAccountRequest1.getCancelationReason());
        assertEquals("I don't want to use the software for now.",
                cancelAccountRequest1.getComment());
        assertEquals(account1, cancelAccountRequest1.getAccount());
    }
}
