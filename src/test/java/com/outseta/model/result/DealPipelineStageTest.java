package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * This class is used to test the DealPipelineStage class.
 */
@ExtendWith(MockitoExtension.class)
public class DealPipelineStageTest {

    /**
     * The DealPipelineStage object to test.
     */
    private DealPipelineStage dealPipelineStage;

    /**
     * This method initializes the DealPipelineStage object to test.
     */
    @BeforeEach
    public void setup() {
        dealPipelineStage = new DealPipelineStage("uid");
    }

    /**
     * This method tests the setUid method.
     */
    @Test
    public void testSetUid() {
        dealPipelineStage.setUid("uid2");
        assertEquals("uid2", dealPipelineStage.getUid());

        DealPipelineStage dealPipelineStage2 = new DealPipelineStage();
        dealPipelineStage2.setUid("uid");
        assertEquals("uid", dealPipelineStage2.getUid());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {
        assertEquals(dealPipelineStage, new DealPipelineStage("uid"));
        assertNotEquals(dealPipelineStage, new DealPipelineStage("uid2"));
        assertNotEquals(dealPipelineStage, new Object());
    }

    /**
     * This method tests the hashCode method.
     */
    @Test
    public void testHashCode() {
        assertEquals(dealPipelineStage.hashCode(),
                new DealPipelineStage("uid").hashCode());
    }

}
