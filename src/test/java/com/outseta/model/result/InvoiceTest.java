package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class tests the Invoice class.
 */
@ExtendWith(MockitoExtension.class)
public class InvoiceTest {

    /**
     * The invoice to test.
     */
    private Invoice invoice;

    /**
     * A random timestamp for creating dates.
     */
    private static final long TIMESTAMP = 1612137600;

    /**
     * A random invoice number to use for testing.
     */
    private static final int INVOICE_NUMBER = 1;

    /**
     * A random billing invoice status to use for testing.
     */
    private static final int BILLING_INVOICE_STATUS = 2;

    /**
     * A random amount to use for testing.
     */
    private static final double AMOUNT = 3;

    /**
     * A random amount outstanding to use for testing.
     */
    private static final double AMOUNT_OUTSTANDING = 4;

    /**
     * A random subtotal to use for testing.
     */
    private static final double SUBTOTAL = 5;

    /**
     * A random tax to use for testing.
     */
    private static final double TAX = 6;

    /**
     * A random paid amount to use for testing.
     */
    private static final double PAID = 7;

    /**
     * A random total to use for testing.
     */
    private static final double TOTAL = 8;

    /**
     * A random balance to use for testing.
     */
    private static final double BALANCE = 9;

    /**
     * A mock subscription to use for testing.
     */
    @Mock
    private Subscription subscription1;

    /**
     * A mock subscription to use for testing.
     */
    @Mock
    private Subscription subscription2;

    /**
     * A mock invoice line item to use for testing.
     */
    @Mock
    private InvoiceLineItem invoiceLineItem1;

    /**
     * A mock invoice line item to use for testing.
     */
    @Mock
    private InvoiceLineItem invoiceLineItem2;

    /**
     * A mock invoice display item to use for testing.
     */
    @Mock
    private InvoiceDisplayItem invoiceDisplayItem1;

    /**
     * A mock invoice display item to use for testing.
     */
    @Mock
    private InvoiceDisplayItem invoiceDisplayItem2;

    /**
     * This method sets up the invoice to test.
     */
    @BeforeEach
    public void setUp() {
        invoice = Invoice.builder()
                .invoiceDate(new Date(TIMESTAMP))
                .number(INVOICE_NUMBER)
                .billingInvoiceStatus(BILLING_INVOICE_STATUS)
                .subscription(subscription1)
                .amount(AMOUNT)
                .amountOutstanding(AMOUNT_OUTSTANDING)
                .invoiceLineItems(
                        Arrays.asList(invoiceLineItem1, invoiceLineItem2))
                .isUserGenerated(false)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .subtotal(SUBTOTAL)
                .tax(TAX)
                .taxBehaviour("taxBehaviour")
                .paid(PAID)
                .invoiceDisplayItems(Arrays.asList(invoiceDisplayItem1))
                .total(TOTAL)
                .balance(BALANCE)
                .build();
    }

    /**
     * This method tests that the builder has set all values correctly.
     */
    @Test
    public void testBuilder() {
        assertEquals(TIMESTAMP, invoice.getInvoiceDate().getTime());
        assertEquals(INVOICE_NUMBER, invoice.getNumber());
        assertEquals(BILLING_INVOICE_STATUS, invoice.getBillingInvoiceStatus());
        assertEquals(subscription1, invoice.getSubscription());
        assertEquals(AMOUNT, invoice.getAmount());
        assertEquals(AMOUNT_OUTSTANDING, invoice.getAmountOutstanding());
        assertEquals(Arrays.asList(invoiceLineItem1, invoiceLineItem2),
                invoice.getInvoiceLineItems());
        assertFalse(invoice.isUserGenerated());
        assertEquals("uid", invoice.getUid());
        assertEquals(TIMESTAMP, invoice.getCreated().getTime());
        assertEquals(TIMESTAMP, invoice.getUpdated().getTime());
        assertEquals(SUBTOTAL, invoice.getSubtotal());
        assertEquals(TAX, invoice.getTax());
        assertEquals("taxBehaviour", invoice.getTaxBehaviour());
        assertEquals(PAID, invoice.getPaid());
        assertEquals(Arrays.asList(invoiceDisplayItem1),
                invoice.getInvoiceDisplayItems());
        assertEquals(TOTAL, invoice.getTotal());
        assertEquals(BALANCE, invoice.getBalance());
    }

    /**
     * This method tests the default values set by the builder.
     */
    @Test
    public void testBuilderDefaults() {
        Invoice test = Invoice.builder().build();
        assertNull(test.getInvoiceDate());
        assertNull(test.getNumber());
        assertNull(test.getBillingInvoiceStatus());
        assertNull(test.getSubscription());
        assertNull(test.getAmount());
        assertNull(test.getAmountOutstanding());
        assertNull(test.getInvoiceLineItems());
        assertNull(test.isUserGenerated());
        assertNull(test.getUid());
        assertNull(test.getCreated());
        assertNull(test.getUpdated());
        assertNull(test.getSubtotal());
        assertNull(test.getTax());
        assertNull(test.getTaxBehaviour());
        assertNull(test.getPaid());
        assertNull(test.getInvoiceDisplayItems());
        assertNull(test.getTotal());
        assertNull(test.getBalance());
    }

    /**
     * This method tests the get and set methods for invoice date.
     */
    @Test
    public void testGetSetInvoiceDate() {
        Date date = new Date(TIMESTAMP + 1);
        invoice.setInvoiceDate(date);
        assertEquals(date, invoice.getInvoiceDate());
    }

    /**
     * This method tests the get and set methods for number.
     */
    @Test
    public void testGetSetNumber() {
        invoice.setNumber(INVOICE_NUMBER + 1);
        assertEquals(INVOICE_NUMBER + 1, invoice.getNumber());
    }

    /**
     * This method tests the get and set methods for billing invoice status.
     */
    @Test
    public void testGetSetBillingInvoiceStatus() {
        invoice.setBillingInvoiceStatus(BILLING_INVOICE_STATUS + 1);
        assertEquals(BILLING_INVOICE_STATUS + 1,
                invoice.getBillingInvoiceStatus());
    }

    /**
     * This method tests the get and set methods for subscription.
     */
    @Test
    public void testGetSetSubscription() {
        invoice.setSubscription(subscription2);
        assertEquals(subscription2, invoice.getSubscription());
    }

    /**
     * This method tests the get and set methods for amount.
     */
    @Test
    public void testGetSetAmount() {
        invoice.setAmount(AMOUNT + 1);
        assertEquals(AMOUNT + 1, invoice.getAmount());
    }

    /**
     * This method tests the get and set methods for amount outstanding.
     */
    @Test
    public void testGetSetAmountOutstanding() {
        invoice.setAmountOutstanding(AMOUNT_OUTSTANDING + 1);
        assertEquals(AMOUNT_OUTSTANDING + 1,
                invoice.getAmountOutstanding());
    }

    /**
     * This method tests the get and set methods for invoice line items.
     */
    @Test
    public void testGetSetInvoiceLineItems() {
        invoice.setInvoiceLineItems(Arrays.asList(invoiceLineItem2));
        assertEquals(Arrays.asList(invoiceLineItem2),
                invoice.getInvoiceLineItems());
    }

    /**
     * This method tests the get and set methods for is user generated.
     */
    @Test
    public void testGetSetIsUserGenerated() {
        invoice.setUserGenerated(true);
        assertTrue(invoice.isUserGenerated());
    }

    /**
     * This method tests the get and set methods for uid.
     */
    @Test
    public void testGetSetUid() {
        invoice.setUid("uidNew");
        assertEquals("uidNew", invoice.getUid());
    }

    /**
     * This method tests the get and set methods for created.
     */
    @Test
    public void testGetSetCreated() {
        Date date = new Date(TIMESTAMP + 1);
        invoice.setCreated(date);
        assertEquals(date, invoice.getCreated());
    }

    /**
     * This method tests the get and set methods for updated.
     */
    @Test
    public void testGetSetUpdated() {
        Date date = new Date(TIMESTAMP + 1);
        invoice.setUpdated(date);
        assertEquals(date, invoice.getUpdated());
    }

    /**
     * This method tests the get and set methods for subtotal.
     */
    @Test
    public void testGetSetSubtotal() {
        invoice.setSubtotal(SUBTOTAL + 1);
        assertEquals(SUBTOTAL + 1, invoice.getSubtotal());
    }

    /**
     * This method tests the get and set methods for tax.
     */
    @Test
    public void testGetSetTax() {
        invoice.setTax(TAX + 1);
        assertEquals(TAX + 1, invoice.getTax());
    }

    /**
     * This method tests the get and set methods for tax behaviour.
     */
    @Test
    public void testGetSetTaxBehaviour() {
        invoice.setTaxBehaviour("taxBehaviourNew");
        assertEquals("taxBehaviourNew", invoice.getTaxBehaviour());
    }

    /**
     * This method tests the get and set methods for paid.
     */
    @Test
    public void testGetSetPaid() {
        invoice.setPaid(PAID + 1);
        assertEquals(PAID + 1, invoice.getPaid());
    }

    /**
     * This method tests the get and set methods for invoice display items.
     */
    @Test
    public void testGetSetInvoiceDisplayItems() {
        invoice.setInvoiceDisplayItems(Arrays.asList(invoiceDisplayItem2));
        assertEquals(Arrays.asList(invoiceDisplayItem2),
                invoice.getInvoiceDisplayItems());
    }

    /**
     * This method tests the get and set methods for total.
     */
    @Test
    public void testGetSetTotal() {
        invoice.setTotal(TOTAL + 1);
        assertEquals(TOTAL + 1, invoice.getTotal());
    }

    /**
     * This method tests the get and set methods for balance.
     */
    @Test
    public void testGetSetBalance() {
        invoice.setBalance(BALANCE + 1);
        assertEquals(BALANCE + 1, invoice.getBalance());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {
        Invoice test = Invoice.builder()
                .invoiceDate(new Date(TIMESTAMP))
                .number(INVOICE_NUMBER)
                .billingInvoiceStatus(BILLING_INVOICE_STATUS)
                .subscription(subscription1)
                .amount(AMOUNT)
                .amountOutstanding(AMOUNT_OUTSTANDING)
                .invoiceLineItems(Arrays.asList(invoiceLineItem1,
                        invoiceLineItem2))
                .isUserGenerated(false)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
        assertEquals(invoice, test);
        assertEquals(invoice, invoice);

        assertNotEquals(invoice, null);
        assertNotEquals(invoice, new Object());
        assertNotEquals(invoice, Invoice.builder().build());
    }

    /**
     * This method tests the hash code method.
     */
    @Test
    public void testHashCode() {
        Invoice test = Invoice.builder()
                .invoiceDate(new Date(TIMESTAMP))
                .number(INVOICE_NUMBER)
                .billingInvoiceStatus(BILLING_INVOICE_STATUS)
                .subscription(subscription1)
                .amount(AMOUNT)
                .amountOutstanding(AMOUNT_OUTSTANDING)
                .invoiceLineItems(Arrays.asList(invoiceLineItem1,
                        invoiceLineItem2))
                .isUserGenerated(false)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
        assertEquals(invoice.hashCode(), test.hashCode());
    }
}
