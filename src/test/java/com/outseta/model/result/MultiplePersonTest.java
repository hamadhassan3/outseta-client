package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class is used to test the MultiplePerson class.
 */
@ExtendWith(MockitoExtension.class)
public class MultiplePersonTest {

    /**
     * The MultiplePerson object used for testing.
     */
    private MultiplePerson multiplePerson;

    /**
     * The Metadata object used for testing.
     */
    private Metadata metadata;

    /**
     * The list of Person objects used for testing.
     */
    private List<Person> items;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    public void setUp() {

        // Initializing the Metadata object
        final int limit = 1;
        final int offset = 2;
        final int total = 3;
        metadata = new Metadata(limit, offset, total);

        // Initializing the list of Person objects
        items = List.of(new Person(),
                Person.builder().language("language").build());

        // Creating a MultiplePerson object for testing
        multiplePerson = new MultiplePerson(metadata, items);
    }

    /**
     * This method tests the MultiplePerson class's constructor.
     */
    @Test
    public void testConstructor() {

        // Testing the constructor
        MultiplePerson m1 = new MultiplePerson();
        MultiplePerson m2 = new MultiplePerson(metadata, items);

        assertNull(m1.getMetadata());
        assertNull(m1.getItems());

        assertEquals(metadata, m2.getMetadata());
        assertEquals(items, m2.getItems());
    }

    /**
     * This method tests the MultiplePerson class's getMetadata method.
     */
    @Test
    public void testGetMetadata() {

        // Testing the getMetadata method
        assertEquals(metadata, multiplePerson.getMetadata());
    }

    /**
     * This method tests the MultiplePerson class's setMetadata method.
     */
    @Test
    public void testSetMetadata() {

        // Testing the setMetadata method
        Metadata newMetadata = new Metadata();
        multiplePerson.setMetadata(newMetadata);
        assertEquals(newMetadata, multiplePerson.getMetadata());
    }

    /**
     * This method tests the MultiplePerson class's getItems method.
     */
    @Test
    public void testGetItems() {

        // Testing the getItems method
        assertEquals(items, multiplePerson.getItems());
    }

    /**
     * This method tests the MultiplePerson class's setItems method.
     */
    @Test
    public void testSetItems() {

        // Testing the setItems method
        List<Person> newItems = List.of(new Person());
        multiplePerson.setItems(newItems);
        assertEquals(newItems, multiplePerson.getItems());
    }

    /**
     * This method tests the MultiplePerson class's equals method.
     */
    @Test
    public void testEquals() {

        // Creating an object to compare with
        MultiplePerson m1 = new MultiplePerson();
        MultiplePerson m2 = new MultiplePerson(metadata, items);

        // Creating an equal object
        MultiplePerson m3 = new MultiplePerson(metadata, items);

        // Testing the equals method
        assertEquals(m1, m1);
        assertEquals(m2, m2);
        assertEquals(m2, m3);
        assertNotEquals(m1, null);
        assertNotEquals(m1, new Object());
        assertNotEquals(m2, null);
        assertNotEquals(m2, new Object());
        assertNotEquals(m1, m2);
    }

    /**
     * This method tests the MultiplePerson class's hashCode method.
     */
    @Test
    public void testHashCode() {

        // Creating an object to compare with
        MultiplePerson m1 = new MultiplePerson();
        MultiplePerson m2 = new MultiplePerson(metadata, items);

        // Creating an equal object
        MultiplePerson m3 = new MultiplePerson(metadata, items);

        // Testing the hashCode method
        assertEquals(m1.hashCode(), m1.hashCode());
        assertEquals(m2.hashCode(), m2.hashCode());
        assertEquals(m2.hashCode(), m3.hashCode());
        assertNotEquals(m1.hashCode(), m2.hashCode());
    }

}
