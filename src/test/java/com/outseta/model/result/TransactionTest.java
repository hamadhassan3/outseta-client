package com.outseta.model.result;

import com.outseta.constant.BillingTransactionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class TransactionTest {

    /**
     * The transaction object to be tested.
     */
    private Transaction transaction;

    /**
     * A random timestamp for creating dates.
     */
    private static final long TIMESTAMP = 1612137600;

    /**
     * The billing transaction type.
     */
    private static final int BILLING_TRANSACTION_TYPE = 1;

    /**
     * The amount of the transaction.
     */
    private static final double AMOUNT = 100.0;

    /**
     * A mocked invoice object.
     */
    @Mock
    private Invoice invoice1;

    /**
     * A mocked account object.
     */
    @Mock
    private Account account1;

    /**
     * A mocked invoice object.
     */
    @Mock
    private Invoice invoice2;

    /**
     * A mocked account object.
     */
    @Mock
    private Account account2;

    /**
     * This method sets up the test environment before each test.
     */
    @BeforeEach
    public void setUp() {
        transaction = Transaction.builder()
                .transactionDate(new Date(TIMESTAMP))
                .billingTransactionType(BILLING_TRANSACTION_TYPE)
                .billingTransactionType(BillingTransactionType.CREDIT)
                .account(account1)
                .invoice(invoice1)
                .amount(AMOUNT)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
    }

    /**
     * This method tests that all values are set correctly by builder.
     */
    @Test
    public void testBuilder() {
        assertEquals(new Date(TIMESTAMP), transaction.getTransactionDate());
        assertEquals(BillingTransactionType.CREDIT.getValue(),
                transaction.getBillingTransactionType());
        assertEquals(account1, transaction.getAccount());
        assertEquals(invoice1, transaction.getInvoice());
        assertEquals(AMOUNT, transaction.getAmount());
        assertEquals("uid", transaction.getUid());
        assertEquals(new Date(TIMESTAMP), transaction.getCreated());
        assertEquals(new Date(TIMESTAMP), transaction.getUpdated());
    }

    /**
     * This method tests the default values set by the builder.
     */
    @Test
    public void testBuilderDefaults() {
        transaction = Transaction.builder().build();
        assertNull(transaction.getTransactionDate());
        assertNull(transaction.getBillingTransactionType());
        assertNull(transaction.getAccount());
        assertNull(transaction.getInvoice());
        assertNull(transaction.getAmount());
        assertNull(transaction.getUid());
        assertNull(transaction.getCreated());
        assertNull(transaction.getUpdated());
    }

    /**
     * This method tests the get and set methods for the transaction date.
     */
    @Test
    public void testGetSetTransactionDate() {
        transaction.setTransactionDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), transaction.getTransactionDate());
    }

    /**
     * This method tests the get and set methods for the billing transaction
     * type.
     */
    @Test
    public void testGetSetBillingTransactionType() {
        transaction.setBillingTransactionType(BILLING_TRANSACTION_TYPE + 1);
        assertEquals(BILLING_TRANSACTION_TYPE + 1,
                transaction.getBillingTransactionType());
    }

    /**
     * This method tests the get and set methods for the account.
     */
    @Test
    public void testGetSetAccount() {
        transaction.setAccount(account2);
        assertEquals(account2, transaction.getAccount());
    }

    /**
     * This method tests the get and set methods for the invoice.
     */
    @Test
    public void testGetSetInvoice() {
        transaction.setInvoice(invoice2);
        assertEquals(invoice2, transaction.getInvoice());
    }

    /**
     * This method tests the get and set methods for the amount.
     */
    @Test
    public void testGetSetAmount() {
        transaction.setAmount(AMOUNT + 1);
        assertEquals(AMOUNT + 1, transaction.getAmount());
    }

    /**
     * This method tests the get and set methods for the uid.
     */
    @Test
    public void testGetSetUid() {
        transaction.setUid("uid2");
        assertEquals("uid2", transaction.getUid());
    }

    /**
     * This method tests the get and set methods for the created date.
     */
    @Test
    public void testGetSetCreated() {
        transaction.setCreated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), transaction.getCreated());
    }

    /**
     * This method tests the get and set methods for the updated date.
     */
    @Test
    public void testGetSetUpdated() {
        transaction.setUpdated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), transaction.getUpdated());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {
        Transaction transaction2 = Transaction.builder()
                .transactionDate(new Date(TIMESTAMP))
                .billingTransactionType(BILLING_TRANSACTION_TYPE)
                .billingTransactionType(BillingTransactionType.CREDIT)
                .account(account1)
                .invoice(invoice1)
                .amount(AMOUNT)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
        assertEquals(transaction, transaction2);
        assertEquals(transaction, transaction);

        assertNotEquals(transaction, null);
        assertNotEquals(transaction, new Object());
        assertNotEquals(transaction, Transaction.builder().build());
    }

    /**
     * This method tests the hash code method.
     */
    @Test
    public void testHashCode() {
        Transaction transaction2 = Transaction.builder()
                .transactionDate(new Date(TIMESTAMP))
                .billingTransactionType(BILLING_TRANSACTION_TYPE)
                .billingTransactionType(BillingTransactionType.CREDIT)
                .account(account1)
                .invoice(invoice1)
                .amount(AMOUNT)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
        assertEquals(transaction.hashCode(), transaction2.hashCode());
    }
}
