package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class tests the InvoiceDisplayItem class.
 */
@ExtendWith(MockitoExtension.class)
public class InvoiceDisplayItemTest {

    /**
     * The InvoiceDisplayItem object to test.
     */
    private InvoiceDisplayItem invoiceDisplayItem;

    /**
     * A random timestamp for creating dates.
     */
    private static final long TIMESTAMP = 1612137600;

    /**
     * This method sets up the tests.
     */
    @BeforeEach
    public void setup() {
        invoiceDisplayItem = new InvoiceDisplayItem();
        invoiceDisplayItem.setDate(new Date(TIMESTAMP));
    }

    /**
     * This method tests the default values set on the InvoiceDisplayItem
     * object.
     */
    @Test
    public void testDefaultValues() {
        assertEquals(new Date(TIMESTAMP), invoiceDisplayItem.getDate());
        assertNull(invoiceDisplayItem.getStartDate());
        assertNull(invoiceDisplayItem.getEndDate());
        assertNull(invoiceDisplayItem.getType());
        assertNull(invoiceDisplayItem.getDescription());
        assertNull(invoiceDisplayItem.getOriginalDescription());
        assertNull(invoiceDisplayItem.getAmount());
        assertNull(invoiceDisplayItem.getTax());
        assertNull(invoiceDisplayItem.getQuantity());
        assertNull(invoiceDisplayItem.getTotal());
        assertNull(invoiceDisplayItem.getQuantity());
        assertNull(invoiceDisplayItem.getUnits());
        assertNull(invoiceDisplayItem.getQuantityAndUnits());
        assertNull(invoiceDisplayItem.getLineItemType());
        assertNull(invoiceDisplayItem.getLineItemEntityUid());
    }

    /**
     * This method tests the get and set methods of date.
     */
    @Test
    public void testGetAndSetDate() {
        invoiceDisplayItem.setDate(new Date(TIMESTAMP));
        assertEquals(new Date(TIMESTAMP), invoiceDisplayItem.getDate());
    }

    /**
     * This method tests the get and set methods of start date.
     */
    @Test
    public void testGetAndSetStartDate() {
        invoiceDisplayItem.setStartDate(new Date(TIMESTAMP));
        assertEquals(new Date(TIMESTAMP), invoiceDisplayItem.getStartDate());
    }

    /**
     * This method tests the get and set methods of end date.
     */
    @Test
    public void testGetAndSetEndDate() {
        invoiceDisplayItem.setEndDate(new Date(TIMESTAMP));
        assertEquals(new Date(TIMESTAMP), invoiceDisplayItem.getEndDate());
    }

    /**
     * This method tests the get and set methods of type.
     */
    @Test
    public void testGetAndSetType() {
        invoiceDisplayItem.setType("type");
        assertEquals("type", invoiceDisplayItem.getType());
    }

    /**
     * This method tests the get and set methods of description.
     */
    @Test
    public void testGetAndSetDescription() {
        invoiceDisplayItem.setDescription("description");
        assertEquals("description", invoiceDisplayItem.getDescription());
    }

    /**
     * This method tests the get and set methods of original description.
     */
    @Test
    public void testGetAndSetOriginalDescription() {
        invoiceDisplayItem.setOriginalDescription("original description");
        assertEquals("original description",
                invoiceDisplayItem.getOriginalDescription());
    }

    /**
     * This method tests the get and set methods of amount.
     */
    @Test
    public void testGetAndSetAmount() {
        invoiceDisplayItem.setAmount(1.0);
        assertEquals(1.0, invoiceDisplayItem.getAmount());
    }

    /**
     * This method tests the get and set methods of tax.
     */
    @Test
    public void testGetAndSetTax() {
        invoiceDisplayItem.setTax(1.0);
        assertEquals(1.0, invoiceDisplayItem.getTax());
    }

    /**
     * This method tests the get and set methods of quantity.
     */
    @Test
    public void testGetAndSetQuantity() {
        invoiceDisplayItem.setQuantity(1);
        assertEquals(1, invoiceDisplayItem.getQuantity());
    }

    /**
     * This method tests the get and set methods of total.
     */
    @Test
    public void testGetAndSetTotal() {
        invoiceDisplayItem.setTotal(1.0);
        assertEquals(1.0, invoiceDisplayItem.getTotal());
    }

    /**
     * This method tests the get and set methods of units.
     */
    @Test
    public void testGetAndSetUnits() {
        invoiceDisplayItem.setUnits("units");
        assertEquals("units", invoiceDisplayItem.getUnits());
    }

    /**
     * This method tests the get and set methods of quantity and units.
     */
    @Test
    public void testGetAndSetQuantityAndUnits() {
        invoiceDisplayItem.setQuantityAndUnits("quantity and units");
        assertEquals("quantity and units",
                invoiceDisplayItem.getQuantityAndUnits());
    }

    /**
     * This method tests the get and set methods of line item type.
     */
    @Test
    public void testGetAndSetLineItemType() {
        invoiceDisplayItem.setLineItemType(1);
        assertEquals(1, invoiceDisplayItem.getLineItemType());
    }

    /**
     * This method tests the get and set methods of line item entity uid.
     */
    @Test
    public void testGetAndSetLineItemEntityUid() {
        invoiceDisplayItem.setLineItemEntityUid("line item entity uid");
        assertEquals("line item entity uid",
                invoiceDisplayItem.getLineItemEntityUid());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {
        InvoiceDisplayItem invoiceDisplayItem2 = new InvoiceDisplayItem();
        invoiceDisplayItem2.setDate(new Date(TIMESTAMP));
        assertEquals(invoiceDisplayItem2, invoiceDisplayItem);
        assertEquals(invoiceDisplayItem, invoiceDisplayItem);

        assertNotEquals(invoiceDisplayItem, null);
        assertNotEquals(invoiceDisplayItem, new Object());
        assertNotEquals(invoiceDisplayItem, new InvoiceDisplayItem());
    }

    /**
     * This method tests the hash code method.
     */
    @Test
    public void testHashCode() {
        InvoiceDisplayItem invoiceDisplayItem2 = new InvoiceDisplayItem();
        invoiceDisplayItem2.setDate(new Date(TIMESTAMP));
        assertEquals(invoiceDisplayItem2.hashCode(),
                invoiceDisplayItem.hashCode());
    }
}
