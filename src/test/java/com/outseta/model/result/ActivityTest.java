package com.outseta.model.result;

import com.outseta.constant.ActivityType;
import com.outseta.constant.EntityType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class is used to test the Activity class.
 */
@ExtendWith(MockitoExtension.class)
public class ActivityTest {

    /**
     * The Person object used for testing.
     */
    private Activity activity;

    /**
     * Creating a random timestamp for date creation.
     */
    private static final long TIMESTAMP = 123456789L;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    public void setUp() {

        // Creating a Person object for testing
        activity = Activity.builder()
                .activityData("activityData")
                .uid("uid")
                .description("description")
                .title("title")
                .activityDateTime(new Date(TIMESTAMP))
                .entityType(EntityType.ACCOUNT)
                .entityUid("entityUid")
                .activityType(ActivityType.ACCOUNT_ADD_PERSON)
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
    }

    /**
     * This method tests the Activity class's constructor.
     */
    @Test
    public void testConstructor() {
        assertEquals("activityData", activity.getActivityData());
        assertEquals("uid", activity.getUid());
        assertEquals("description", activity.getDescription());
        assertEquals("title", activity.getTitle());
        assertEquals(new Date(TIMESTAMP), activity.getActivityDateTime());
        assertEquals(EntityType.ACCOUNT.getValue(), activity.getEntityType());
        assertEquals("entityUid", activity.getEntityUid());
        assertEquals(ActivityType.ACCOUNT_ADD_PERSON.getValue(),
                activity.getActivityType());
        assertEquals(new Date(TIMESTAMP), activity.getCreated());
        assertEquals(new Date(TIMESTAMP), activity.getUpdated());
    }

    /**
     * This method tests the Activity class's builder.
     */
    @Test
    public void testBuilder() {

        // Testing the builder
        Activity a1 = Activity.builder().build();
        Activity a2 = Activity.builder()
                .activityData("activityData")
                .uid("uid")
                .description("description")
                .title("title")
                .activityDateTime(new Date(TIMESTAMP))
                .entityType(EntityType.ACCOUNT.getValue())
                .entityUid("entityUid")
                .activityType(ActivityType.ACCOUNT_ADD_PERSON.getValue())
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();

        assertNull(a1.getActivityData());
        assertNull(a1.getUid());
        assertNull(a1.getDescription());
        assertNull(a1.getTitle());
        assertNull(a1.getActivityDateTime());
        assertNull(a1.getEntityType());
        assertNull(a1.getEntityUid());
        assertNull(a1.getActivityType());
        assertNull(a1.getCreated());
        assertNull(a1.getUpdated());

        assertEquals("activityData", a2.getActivityData());
        assertEquals("uid", a2.getUid());
        assertEquals("description", a2.getDescription());
        assertEquals("title", a2.getTitle());
        assertEquals(new Date(TIMESTAMP), a2.getActivityDateTime());
        assertEquals(EntityType.ACCOUNT.getValue(), a2.getEntityType());
        assertEquals("entityUid", a2.getEntityUid());
        assertEquals(ActivityType.ACCOUNT_ADD_PERSON.getValue(),
                a2.getActivityType());
        assertEquals(new Date(TIMESTAMP), a2.getCreated());
        assertEquals(new Date(TIMESTAMP), a2.getUpdated());
    }

    /**
     * This method tests the Activity class's getActivityData method.
     */
    @Test
    public void testGetActivityData() {

        // Testing the getActivityData method
        assertEquals("activityData", activity.getActivityData());
    }

    /**
     * This method tests the Activity class's setActivityData method.
     */
    @Test
    public void testSetActivityData() {

        // Testing the setActivityData method
        activity.setActivityData("newActivityData");
        assertEquals("newActivityData", activity.getActivityData());
    }

    /**
     * This method tests the Activity class's getUid method.
     */
    @Test
    public void testGetUid() {

        // Testing the getUid method
        assertEquals("uid", activity.getUid());
    }

    /**
     * This method tests the Activity class's setUid method.
     */
    @Test
    public void testSetUid() {

        // Testing the setUid method
        activity.setUid("newUid");
        assertEquals("newUid", activity.getUid());
    }

    /**
     * This method tests the Activity class's getDescription method.
     */
    @Test
    public void testGetDescription() {

        // Testing the getDescription method
        assertEquals("description", activity.getDescription());
    }

    /**
     * This method tests the Activity class's setDescription method.
     */
    @Test
    public void testSetDescription() {

        // Testing the setDescription method
        activity.setDescription("newDescription");
        assertEquals("newDescription", activity.getDescription());
    }

    /**
     * This method tests the Activity class's getTitle method.
     */
    @Test
    public void testGetTitle() {

        // Testing the getTitle method
        assertEquals("title", activity.getTitle());
    }

    /**
     * This method tests the Activity class's setTitle method.
     */
    @Test
    public void testSetTitle() {

        // Testing the setTitle method
        activity.setTitle("newTitle");
        assertEquals("newTitle", activity.getTitle());
    }

    /**
     * This method tests the Activity class's getActivityDateTime method.
     */
    @Test
    public void testGetActivityDateTime() {

        // Testing the getActivityDateTime method
        assertEquals(new Date(TIMESTAMP), activity.getActivityDateTime());
    }

    /**
     * This method tests the Activity class's setActivityDateTime method.
     */
    @Test
    public void testSetActivityDateTime() {

        // Testing the setActivityDateTime method
        activity.setActivityDateTime(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), activity.getActivityDateTime());
    }

    /**
     * This method tests the Activity class's getEntityType method.
     */
    @Test
    public void testGetEntityType() {

        // Testing the getEntityType method
        assertEquals(EntityType.ACCOUNT.getValue(), activity.getEntityType());
    }

    /**
     * This method tests the Activity class's setEntityType method.
     */
    @Test
    public void testSetEntityType() {

        // Testing the setEntityType method
        activity.setEntityType(EntityType.DEAL.getValue());
        assertEquals(EntityType.DEAL.getValue(), activity.getEntityType());
    }

    /**
     * This method tests the Activity class's getEntityUid method.
     */
    @Test
    public void testGetEntityUid() {

        // Testing the getEntityUid method
        assertEquals("entityUid", activity.getEntityUid());
    }

    /**
     * This method tests the Activity class's setEntityUid method.
     */
    @Test
    public void testSetEntityUid() {

        // Testing the setEntityUid method
        activity.setEntityUid("newEntityUid");
        assertEquals("newEntityUid", activity.getEntityUid());
    }

    /**
     * This method tests the Activity class's getActivityType method.
     */
    @Test
    public void testGetActivityType() {

        // Testing the getActivityType method
        assertEquals(ActivityType.ACCOUNT_ADD_PERSON.getValue(),
                activity.getActivityType());
    }

    /**
     * This method tests the Activity class's setActivityType method.
     */
    @Test
    public void testSetActivityType() {

        // Testing the setActivityType method
        activity.setActivityType(ActivityType.ACCOUNT_STAGE_UPDATED.getValue());
        assertEquals(ActivityType.ACCOUNT_STAGE_UPDATED.getValue(),
                activity.getActivityType());
    }

    /**
     * This method tests the Activity class's getCreated method.
     */
    @Test
    public void testGetCreated() {

        // Testing the getCreated method
        assertEquals(new Date(TIMESTAMP), activity.getCreated());
    }

    /**
     * This method tests the Activity class's setCreated method.
     */
    @Test
    public void testSetCreated() {

        // Testing the setCreated method
        activity.setCreated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), activity.getCreated());
    }

    /**
     * This method tests the Activity class's getUpdated method.
     */
    @Test
    public void testGetUpdated() {

        // Testing the getUpdated method
        assertEquals(new Date(TIMESTAMP), activity.getUpdated());
    }

    /**
     * This method tests the Activity class's setUpdated method.
     */
    @Test
    public void testSetUpdated() {

        // Testing the setUpdated method
        activity.setUpdated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), activity.getUpdated());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {

        // Creating objects to compare
        Activity a1 = Activity.builder().build();
        Activity a2 = Activity.builder().build();
        Activity a3 = Activity.builder()
                .activityData("activityData")
                .uid("uid")
                .description("description")
                .title("title")
                .activityDateTime(new Date(TIMESTAMP))
                .entityType(EntityType.ACCOUNT.getValue())
                .entityUid("entityUid")
                .activityType(ActivityType.ACCOUNT_ADD_PERSON.getValue())
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();

        // Testing the equals method
        assertEquals(a1, a2);
        assertEquals(a1.hashCode(), a2.hashCode());
        assertEquals(a1, a1);
        assertEquals(a1.hashCode(), a1.hashCode());
        assertNotEquals(a1, a3);
        assertNotEquals(a1.hashCode(), a3.hashCode());

        assertNotEquals(a1, null);
        assertNotEquals(a1, new Object());

        assertEquals(a3, activity);

    }
}
