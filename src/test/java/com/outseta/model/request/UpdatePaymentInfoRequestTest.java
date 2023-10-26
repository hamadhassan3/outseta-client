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
 * This class is used to test the UpdatePaymentInfoRequest class.
 */
@ExtendWith(MockitoExtension.class)
public class UpdatePaymentInfoRequestTest {

    /**
     * The object to be tested.
     */
    private UpdatePaymentInfoRequest updatePaymentInfoRequest;

    /**
     * The mock account object for testing.
     */
    @Mock
    private Account account;

    /**
     * Sets up before each test.
     */
    @BeforeEach
    public void setup() {
        updatePaymentInfoRequest = UpdatePaymentInfoRequest.builder()
                .account(account)
                .customerToken("customerToken")
                .nameOnCard("nameOnCard")
                .paymentToken("paymentToken")
                .build();
    }

    /**
     * This method tests that all values were set correctly.
     */
    @Test
    public void testUpdatePaymentInfoRequestBuilder() {
        assertEquals(account,
                updatePaymentInfoRequest.getAccount());
        assertEquals("customerToken",
                updatePaymentInfoRequest.getCustomerToken());
        assertEquals("nameOnCard",
                updatePaymentInfoRequest.getNameOnCard());
        assertEquals("paymentToken",
                updatePaymentInfoRequest.getPaymentToken());
    }

    /**
     * This method tests the default values of the builder.
     */
    @Test
    public void testUpdatePaymentInfoRequestBuilderDefaults() {
        UpdatePaymentInfoRequest test = UpdatePaymentInfoRequest.builder()
                .build();
        assertNull(test.getAccount());
        assertNull(test.getCustomerToken());
        assertNull(test.getNameOnCard());
        assertNull(test.getPaymentToken());
    }

    /**
     * This method tests the get and set methods for the account.
     */
    @Test
    public void testGetAndSetAccount() {
        updatePaymentInfoRequest.setAccount(account);
        assertEquals(account, updatePaymentInfoRequest.getAccount());
    }

    /**
     * This method tests the get and set methods for the customer token.
     */
    @Test
    public void testGetAndSetCustomerToken() {
        updatePaymentInfoRequest.setCustomerToken("customerToken");
        assertEquals("customerToken",
                updatePaymentInfoRequest.getCustomerToken());
    }

    /**
     * This method tests the get and set methods for the name on card.
     */
    @Test
    public void testGetAndSetNameOnCard() {
        updatePaymentInfoRequest.setNameOnCard("nameOnCard");
        assertEquals("nameOnCard", updatePaymentInfoRequest.getNameOnCard());
    }

    /**
     * This method tests the get and set methods for the payment token.
     */
    @Test
    public void testGetAndSetPaymentToken() {
        updatePaymentInfoRequest.setPaymentToken("paymentToken");
        assertEquals("paymentToken",
                updatePaymentInfoRequest.getPaymentToken());
    }
}
