package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class tests the Metadata class.
 */
@ExtendWith(MockitoExtension.class)
public class MetadataTest {

    /**
     * The Metadata object used for testing.
     */
    private Metadata metadata;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    public void setUp() {
        // Creating a Metadata object for testing
        final int limit = 1;
        final int offset = 2;
        final int total = 3;
        metadata = new Metadata(limit, offset, total);
    }

    /**
     * This method tests the Metadata class's constructor.
     */
    @Test
    public void testConstructor() {

        final int limit = 1;
        final int offset = 2;
        final int total = 3;
        final int zero = 0;

        // Testing the constructor
        Metadata m1 = new Metadata();
        Metadata m2 = new Metadata(limit, offset, total);

        assertNull(m1.getLimit());
        assertNull(m1.getOffset());
        assertNull(m1.getTotal());

        assertEquals(limit, m2.getLimit());
        assertEquals(offset, m2.getOffset());
        assertEquals(total, m2.getTotal());
    }

    /**
     * This method tests the Metadata class's getLimit method.
     */
    @Test
    public void testGetLimit() {
        final int limit = 1;

        // Testing the getLimit method
        assertEquals(limit, metadata.getLimit());
    }

    /**
     * This method tests the Metadata class's setLimit method.
     */
    @Test
    public void testSetLimit() {
        final int limit = 100;

        // Testing the setLimit method
        metadata.setLimit(limit);
        assertEquals(limit, metadata.getLimit());
    }

    /**
     * This method tests the Metadata class's getOffset method.
     */
    @Test
    public void testGetOffset() {
        final int offset = 2;

        // Testing the getOffset method
        assertEquals(offset, metadata.getOffset());
    }

    /**
     * This method tests the Metadata class's setOffset method.
     */
    @Test
    public void testSetOffset() {
        final int offset = 200;

        // Testing the setOffset method
        metadata.setOffset(offset);
        assertEquals(offset, metadata.getOffset());
    }

    /**
     * This method tests the Metadata class's getTotal method.
     */
    @Test
    public void testGetTotal() {
        final int total = 3;

        // Testing the getTotal method
        assertEquals(total, metadata.getTotal());
    }

    /**
     * This method tests the Metadata class's setTotal method.
     */
    @Test
    public void testSetTotal() {
        final int total = 300;

        // Testing the setTotal method
        metadata.setTotal(total);
        assertEquals(total, metadata.getTotal());
    }

    /**
     * This method tests the Metadata class's equals method.
     */
    @Test
    public void testEquals() {

        final int limit = 1;
        final int offset = 2;
        final int total = 3;

        // Testing the equals method
        Metadata m1 = new Metadata(limit, offset, total);
        Metadata m2 = new Metadata(limit, offset, total);
        Metadata m3 = new Metadata(limit, offset, total + 1);

        assertEquals(m1, m2);
        assertEquals(m1, m1);
        assertNotEquals(m1, m3);

        assertNotEquals(m1, null);
        assertNotEquals(m1, new Object());

        m1.setLimit(m1.getLimit() + 1);
        assertNotEquals(m1, m2);
        m1.setLimit(m2.getLimit());

        m1.setOffset(m1.getOffset() + 1);
        assertNotEquals(m1, m2);
        m1.setOffset(m2.getOffset());

        m1.setTotal(m1.getTotal() + 1);
        assertNotEquals(m1, m2);
        m1.setTotal(m2.getTotal());
    }

    /**
     * This method tests the hashCode method.
     */
    @Test
    public void testHashCode() {

        final int limit = 1;
        final int offset = 2;
        final int total = 3;

        // Testing the hashCode method
        Metadata m1 = new Metadata(limit, offset, total);
        Metadata m2 = new Metadata(limit, offset, total);
        Metadata m3 = new Metadata(limit, offset, total + 1);

        assertEquals(m1.hashCode(), m2.hashCode());
        assertEquals(m1.hashCode(), m1.hashCode());
        assertNotEquals(m1.hashCode(), m3.hashCode());
    }


}
