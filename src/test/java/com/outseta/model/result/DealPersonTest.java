package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * This class is used to test the DealPerson class.
 */
@ExtendWith(MockitoExtension.class)
public class DealPersonTest {

    /**
     * The DealPerson object to test.
     */
    private DealPerson dealPerson;

    /**
     * The mock Person object.
     */
    @Mock
    private Person person1;

    /**
     * The mock Person object.
     */
    @Mock
    private Person person2;

    /**
     * This method initializes the DealPerson object to test.
     */
    @BeforeEach
    public void setup() {
        dealPerson = new DealPerson(person1);
    }

    /**
     * This method tests the setPerson method.
     */
    @Test
    public void testSetPerson() {
        dealPerson.setPerson(person2);
        assertEquals(person2, dealPerson.getPerson());

        DealPerson dealPerson2 = new DealPerson();
        dealPerson2.setPerson(person1);
        assertEquals(person1, dealPerson2.getPerson());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {
        assertEquals(dealPerson, new DealPerson(person1));
        assertNotEquals(dealPerson, new DealPerson(person2));
        assertNotEquals(dealPerson, new Object());
    }

    /**
     * This method tests the hashCode method.
     */
    @Test
    public void testHashCode() {
        assertEquals(dealPerson.hashCode(), new DealPerson(person1).hashCode());
    }

}
