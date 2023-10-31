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
 * This class is used to test the PlanFamily class.
 */
@ExtendWith(MockitoExtension.class)
public class PlanFamilyTest {

    /**
     * The PlanFamily object to be tested.
     */
    private PlanFamily planFamily;

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
     * A random timestamp to be used for creating date objects.
     */
    private static final long TIMESTAMP = 1234567890;

    /**
     * The third Plan object to be used in testing.
     */
    @BeforeEach
    void setUp() {
        planFamily = PlanFamily.builder()
                .name("name")
                .active(false)
                .isDefault(false)
                .plans(Arrays.asList(plan1, plan2))
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .uid("uid")
                .activityEventData("activityEventData")
                .build();
    }

    /**
     * This method tests the builder values.
     */
    @Test
    void testBuilderValues() {
        assertEquals("name", planFamily.getName());
        assertFalse(planFamily.isActive());
        assertFalse(planFamily.isDefault());
        assertEquals(Arrays.asList(plan1, plan2), planFamily.getPlans());
        assertEquals(new Date(TIMESTAMP), planFamily.getCreated());
        assertEquals(new Date(TIMESTAMP), planFamily.getUpdated());
        assertEquals("uid", planFamily.getUid());
        assertEquals("activityEventData", planFamily.getActivityEventData());
    }

    /**
     * This method tests the default values set by builder.
     */
    @Test
    void testBuilderDefaultValues() {
        planFamily = PlanFamily.builder().build();
        assertNull(planFamily.getName());
        assertNull(planFamily.isActive());
        assertNull(planFamily.isDefault());
        assertNull(planFamily.getPlans());
        assertNull(planFamily.getCreated());
        assertNull(planFamily.getUpdated());
        assertNull(planFamily.getUid());
        assertNull(planFamily.getActivityEventData());
    }

    /**
     * This method tests the get and set methods for name.
     */
    @Test
    void testGetAndSetName() {
        planFamily.setName("newName");
        assertEquals("newName", planFamily.getName());
    }

    /**
     * This method tests the get and set methods for active.
     */
    @Test
    void testGetAndSetActive() {
        planFamily.setActive(true);
        assertTrue(planFamily.isActive());
    }

    /**
     * This method tests the get and set methods for isDefault.
     */
    @Test
    void testGetAndSetDefault() {
        planFamily.setDefault(true);
        assertTrue(planFamily.isDefault());
    }

    /**
     * This method tests the get and set methods for plans.
     */
    @Test
    void testGetAndSetPlans() {
        planFamily.setPlans(Arrays.asList(plan1));
        assertEquals(Arrays.asList(plan1), planFamily.getPlans());
    }

    /**
     * This method tests the get and set methods for created.
     */
    @Test
    void testGetAndSetCreated() {
        planFamily.setCreated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), planFamily.getCreated());
    }

    /**
     * This method tests the get and set methods for updated.
     */
    @Test
    void testGetAndSetUpdated() {
        planFamily.setUpdated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), planFamily.getUpdated());
    }

    /**
     * This method tests the get and set methods for uid.
     */
    @Test
    void testGetAndSetUid() {
        planFamily.setUid("newUid");
        assertEquals("newUid", planFamily.getUid());
    }

    /**
     * This method tests the get and set methods for activityEventData.
     */
    @Test
    void testGetAndSetActivityEventData() {
        planFamily.setActivityEventData("newActivityEventData");
        assertEquals("newActivityEventData", planFamily.getActivityEventData());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    void testEquals() {
        PlanFamily planFamily2 = PlanFamily.builder()
                .name("name")
                .active(false)
                .isDefault(false)
                .plans(Arrays.asList(plan1, plan2))
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .uid("uid")
                .activityEventData("activityEventData")
                .build();
        assertEquals(planFamily, planFamily2);
        assertEquals(planFamily, planFamily);
        assertNotEquals(planFamily, null);
        assertNotEquals(planFamily, new Object());

        planFamily2.setUid("newUid");
        assertNotEquals(planFamily, planFamily2);
    }

    /**
     * This method tests the hashCode method.
     */
    @Test
    void testHashCode() {
        PlanFamily planFamily2 = PlanFamily.builder()
                .name("name")
                .active(false)
                .isDefault(false)
                .plans(Arrays.asList(plan1, plan2))
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .uid("uid")
                .activityEventData("activityEventData")
                .build();
        assertEquals(planFamily.hashCode(), planFamily2.hashCode());
    }
}
