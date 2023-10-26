package com.outseta.model.request;

import com.outseta.model.result.Account;
import com.outseta.model.result.Invoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class tests the AddInvoicePaymentRequest class.
 */
@ExtendWith(MockitoExtension.class)
public class AddInvoicePaymentRequestTest {

    /**
     * The AddInvoicePaymentRequest object to be tested.
     */
    private AddInvoicePaymentRequest addInvoicePaymentRequest;

    /**
     * A mocked invoice object.
     */
    @Mock
    private Account account1;

    /**
     * A mocked account object.
     */
    @Mock
    private Invoice invoice1;

    /**
     * A mocked invoice object.
     */
    @Mock
    private Account account2;

    /**
     * A mocked account object.
     */
    @Mock
    private Invoice invoice2;

    /**
     * The amount of the payment.
     */
    private static final double AMOUNT = 100.0;

    /**
     * Set up the test environment.
     */
    @BeforeEach
    public void setUp() {
        addInvoicePaymentRequest = AddInvoicePaymentRequest.builder()
                .invoice(invoice1)
                .account(account1)
                .amount(AMOUNT)
                .build();
    }

    /**
     * This method tests that all the fields are set correctly.
     */
    @Test
    public void testAddInvoicePaymentRequestBuilder() {
        assertEquals(invoice1, addInvoicePaymentRequest.getInvoice());
        assertEquals(account1, addInvoicePaymentRequest.getAccount());
        assertEquals(AMOUNT, addInvoicePaymentRequest.getAmount());
    }

    /**
     * This method tests the defaults set by builder.
     */
    @Test
    public void testAddInvoicePaymentRequestBuilderWithDefaults() {
        AddInvoicePaymentRequest test = AddInvoicePaymentRequest.builder()
                .build();

        assertNull(test.getAmount());
        assertNull(test.getAccount());
        assertNull(test.getInvoice());
    }

    /**
     * This method tests the get and set methods for the account.
     */
    @Test
    public void testGetAndSetAccount() {
        addInvoicePaymentRequest.setAccount(account2);
        assertEquals(account2, addInvoicePaymentRequest.getAccount());
    }

    /**
     * This method tests the get and set methods for the invoice.
     */
    @Test
    public void testGetAndSetInvoice() {
        addInvoicePaymentRequest.setInvoice(invoice2);
        assertEquals(invoice2, addInvoicePaymentRequest.getInvoice());
    }

    /**
     * This method tests the get and set methods for the amount.
     */
    @Test
    public void testGetAndSetAmount() {
        addInvoicePaymentRequest.setAmount(AMOUNT + 1);
        assertEquals(AMOUNT + 1, addInvoicePaymentRequest.getAmount());
    }
}
