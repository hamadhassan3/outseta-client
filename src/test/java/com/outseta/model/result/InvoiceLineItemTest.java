package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class tests the InvoiceLineItem class.
 */
@ExtendWith(MockitoExtension.class)
public class InvoiceLineItemTest {

    /**
     * The invoice line item to test.
     */
    private InvoiceLineItem invoiceLineItem;

    /**
     * A random timestamp for creating dates.
     */
    private static final long TIMESTAMP = 1612137600;

    /**
     * A random quantity for testing.
     */
    private static final int QUANTITY = 1;

    /**
     * A random rate for testing.
     */
    private static final double RATE = 2.2;

    /**
     * A random amount for testing.
     */
    private static final double AMOUNT = 3.3;

    /**
     * A random tax for testing.
     */
    private static final double TAX = 4.4;

    /**
     * The invoice to test.
     */
    @Mock
    private Invoice invoice1;

    /**
     * The invoice to test.
     */
    @Mock
    private Invoice invoice2;

    /**
     * Sets up data before each test.
     */
    @BeforeEach
    void setUp() {
        invoiceLineItem = InvoiceLineItem.builder()
                .startDate(new Date(TIMESTAMP))
                .endDate(new Date(TIMESTAMP))
                .description("Test Description")
                .unitOfMeasure("Test Unit of Measure")
                .quantity(QUANTITY)
                .rate(RATE)
                .amount(AMOUNT)
                .tax(TAX)
                .invoice(invoice1)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
    }

    /**
     * This method tests that builder has set correct values.
     */
    @Test
    void testBuilder() {
        assertEquals(new Date(TIMESTAMP), invoiceLineItem.getStartDate());
        assertEquals(new Date(TIMESTAMP), invoiceLineItem.getEndDate());
        assertEquals("Test Description",
                invoiceLineItem.getDescription());
        assertEquals("Test Unit of Measure",
                invoiceLineItem.getUnitOfMeasure());
        assertEquals(QUANTITY, invoiceLineItem.getQuantity());
        assertEquals(RATE, invoiceLineItem.getRate());
        assertEquals(AMOUNT, invoiceLineItem.getAmount());
        assertEquals(TAX, invoiceLineItem.getTax());
        assertEquals(invoice1, invoiceLineItem.getInvoice());
        assertEquals("uid", invoiceLineItem.getUid());
        assertEquals(new Date(TIMESTAMP), invoiceLineItem.getCreated());
        assertEquals(new Date(TIMESTAMP), invoiceLineItem.getUpdated());
    }

    /**
     * This method tests that default values are set correctly.
     */
    @Test
    void testDefaultValues() {
        invoiceLineItem = InvoiceLineItem.builder().build();
        assertNull(invoiceLineItem.getStartDate());
        assertNull(invoiceLineItem.getEndDate());
        assertNull(invoiceLineItem.getDescription());
        assertNull(invoiceLineItem.getUnitOfMeasure());
        assertNull(invoiceLineItem.getQuantity());
        assertNull(invoiceLineItem.getRate());
        assertNull(invoiceLineItem.getAmount());
        assertNull(invoiceLineItem.getTax());
        assertNull(invoiceLineItem.getInvoice());
        assertNull(invoiceLineItem.getUid());
        assertNull(invoiceLineItem.getCreated());
        assertNull(invoiceLineItem.getUpdated());
    }

    /**
     * This method tests the get and set methods for the start date.
     */
    @Test
    void testGetSetStartDate() {
        invoiceLineItem.setStartDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), invoiceLineItem.getStartDate());
    }

    /**
     * This method tests the get and set methods for the end date.
     */
    @Test
    void testGetSetEndDate() {
        invoiceLineItem.setEndDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), invoiceLineItem.getEndDate());
    }

    /**
     * This method tests the get and set methods for the description.
     */
    @Test
    void testGetSetDescription() {
        invoiceLineItem.setDescription("New Description");
        assertEquals("New Description", invoiceLineItem.getDescription());
    }

    /**
     * This method tests the get and set methods for the unit of measure.
     */
    @Test
    void testGetSetUnitOfMeasure() {
        invoiceLineItem.setUnitOfMeasure("New Unit of Measure");
        assertEquals("New Unit of Measure", invoiceLineItem.getUnitOfMeasure());
    }

    /**
     * This method tests the get and set methods for the quantity.
     */
    @Test
    void testGetSetQuantity() {
        invoiceLineItem.setQuantity(QUANTITY + 1);
        assertEquals(QUANTITY + 1, invoiceLineItem.getQuantity());
    }

    /**
     * This method tests the get and set methods for the rate.
     */
    @Test
    void testGetSetRate() {
        invoiceLineItem.setRate(RATE + 1);
        assertEquals(RATE + 1, invoiceLineItem.getRate());
    }

    /**
     * This method tests the get and set methods for the amount.
     */
    @Test
    void testGetSetAmount() {
        invoiceLineItem.setAmount(AMOUNT + 1);
        assertEquals(AMOUNT + 1, invoiceLineItem.getAmount());
    }

    /**
     * This method tests the get and set methods for the tax.
     */
    @Test
    void testGetSetTax() {
        invoiceLineItem.setTax(TAX + 1);
        assertEquals(TAX + 1, invoiceLineItem.getTax());
    }

    /**
     * This method tests the get and set methods for the invoice.
     */
    @Test
    void testGetSetInvoice() {
        invoiceLineItem.setInvoice(invoice2);
        assertEquals(invoice2, invoiceLineItem.getInvoice());
    }

    /**
     * This method tests the get and set methods for the uid.
     */
    @Test
    void testGetSetUid() {
        invoiceLineItem.setUid("new uid");
        assertEquals("new uid", invoiceLineItem.getUid());
    }

    /**
     * This method tests the get and set methods for the created date.
     */
    @Test
    void testGetSetCreated() {
        invoiceLineItem.setCreated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), invoiceLineItem.getCreated());
    }

    /**
     * This method tests the get and set methods for the updated date.
     */
    @Test
    void testGetSetUpdated() {
        invoiceLineItem.setUpdated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), invoiceLineItem.getUpdated());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    void testEquals() {
        InvoiceLineItem invoiceLineItem2 = InvoiceLineItem.builder()
                .startDate(new Date(TIMESTAMP))
                .endDate(new Date(TIMESTAMP))
                .description("Test Description")
                .unitOfMeasure("Test Unit of Measure")
                .quantity(QUANTITY)
                .rate(RATE)
                .amount(AMOUNT)
                .tax(TAX)
                .invoice(invoice1)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();

        assertEquals(invoiceLineItem, invoiceLineItem2);
        assertEquals(invoiceLineItem, invoiceLineItem);

        assertNotEquals(invoiceLineItem, null);
        assertNotEquals(invoiceLineItem, new Object());
        assertNotEquals(invoiceLineItem, InvoiceLineItem.builder().build());
    }

    /**
     * This method tests the hashcode method.
     */
    @Test
    void testHashCode() {
        InvoiceLineItem invoiceLineItem2 = InvoiceLineItem.builder()
                .startDate(new Date(TIMESTAMP))
                .endDate(new Date(TIMESTAMP))
                .description("Test Description")
                .unitOfMeasure("Test Unit of Measure")
                .quantity(QUANTITY)
                .rate(RATE)
                .amount(AMOUNT)
                .tax(TAX)
                .invoice(invoice1)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
        assertEquals(invoiceLineItem.hashCode(), invoiceLineItem2.hashCode());
    }
}
