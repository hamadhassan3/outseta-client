package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class is used to test the PlanAddOn class.
 */
@ExtendWith(MockitoExtension.class)
public class PlanAddOnTest {

    /**
     * The PlanAddOn object to be tested.
     */
    private PlanAddOn planAddOn;

    /**
     * The first Plan object to be used in testing.
     */
    @Mock
    private Plan plan1;

    /**
     * The second Plan object to be used in testing.
     */
    @Mock
    private Plan plan2;

    /**
     * The AddOn object to be used in testing.
     */
    @Mock
    private AddOn addOn1;

    /**
     * The AddOn object to be used in testing.
     */
    @Mock
    private AddOn addOn2;

    /**
     * A random timestamp to be used for creating date objects.
     */
    private static final long TIMESTAMP = 1234567890;

    /**
     * Sets up each test.
     */
    @BeforeEach
    void setUp() {
        planAddOn = PlanAddOn.builder()
                .plan(plan1)
                .addOn(addOn1)
                .userSelectable(false)
                .activityEventData("activityEventData")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .uid("uid")
                .build();
    }

    /**
     * This method tests the values set by builder.
     */
    @Test
    void testBuilderValues() {
        assertEquals(plan1, planAddOn.getPlan());
        assertEquals(addOn1, planAddOn.getAddOn());
        assertFalse(planAddOn.isUserSelectable());
        assertEquals("activityEventData", planAddOn.getActivityEventData());
        assertEquals(new Date(TIMESTAMP), planAddOn.getCreated());
        assertEquals(new Date(TIMESTAMP), planAddOn.getUpdated());
        assertEquals("uid", planAddOn.getUid());
    }

    /**
     * This method tests the default values set by builder.
     */
    @Test
    void testBuilderDefaultValues() {
        planAddOn = PlanAddOn.builder().build();
        assertNull(planAddOn.getPlan());
        assertNull(planAddOn.getAddOn());
        assertNull(planAddOn.isUserSelectable());
        assertNull(planAddOn.getActivityEventData());
        assertNull(planAddOn.getCreated());
        assertNull(planAddOn.getUpdated());
        assertNull(planAddOn.getUid());
    }

    /**
     * This method tests the get and set of plan.
     */
    @Test
    void testGetSetPlan() {
        planAddOn.setPlan(plan2);
        assertEquals(plan2, planAddOn.getPlan());
    }

    /**
     * This method tests the get and set of addOn.
     */
    @Test
    void testGetSetAddOn() {
        planAddOn.setAddOn(addOn2);
        assertEquals(addOn2, planAddOn.getAddOn());
    }

    /**
     * This method tests the get and set of userSelectable.
     */
    @Test
    void testGetSetUserSelectable() {
        planAddOn.setUserSelectable(true);
        assertTrue(planAddOn.isUserSelectable());
    }

    /**
     * This method tests the get and set of activityEventData.
     */
    @Test
    void testGetSetActivityEventData() {
        planAddOn.setActivityEventData("newActivityEventData");
        assertEquals("newActivityEventData",
                planAddOn.getActivityEventData());
    }

    /**
     * This method tests the get and set of created.
     */
    @Test
    void testGetSetCreated() {
        planAddOn.setCreated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), planAddOn.getCreated());
    }

    /**
     * This method tests the get and set of updated.
     */
    @Test
    void testGetSetUpdated() {
        planAddOn.setUpdated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), planAddOn.getUpdated());
    }

    /**
     * This method tests the get and set of uid.
     */
    @Test
    void testGetSetUid() {
        planAddOn.setUid("newUid");
        assertEquals("newUid", planAddOn.getUid());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    void testEquals() {
        PlanAddOn planAddOn2 = PlanAddOn.builder()
                .plan(plan1)
                .addOn(addOn1)
                .userSelectable(false)
                .activityEventData("activityEventData")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .uid("uid")
                .build();
        assertEquals(planAddOn, planAddOn2);
        assertEquals(planAddOn, planAddOn);

        assertNotEquals(planAddOn, null);
        assertNotEquals(planAddOn, new Object());
        planAddOn2.setUid("newUid");
        assertNotEquals(planAddOn, planAddOn2);
    }

    /**
     * This method tests the hashcode method.
     */
    @Test
    void testHashCode() {
        PlanAddOn planAddOn2 = PlanAddOn.builder()
                .plan(plan1)
                .addOn(addOn1)
                .userSelectable(false)
                .activityEventData("activityEventData")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .uid("uid")
                .build();
        assertEquals(planAddOn.hashCode(), planAddOn2.hashCode());
        planAddOn2.setUid("newUid");
        assertNotEquals(planAddOn.hashCode(), planAddOn2.hashCode());
    }
}
