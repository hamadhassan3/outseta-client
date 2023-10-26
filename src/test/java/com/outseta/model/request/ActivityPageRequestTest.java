package com.outseta.model.request;

import com.outseta.constant.ActivityType;
import com.outseta.constant.EntityType;
import com.outseta.constant.Sort;
import com.outseta.exception.OutsetaPageBuildException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class tests the ActivityPageRequest class.
 */
@ExtendWith(MockitoExtension.class)
public class ActivityPageRequestTest {

    /**
     * The ActivityPageRequest object to test.
     */
    private ActivityPageRequest activityPageRequest;

    /**
     * This method is called before each test.
     */
    @BeforeEach
    public void setUp() throws OutsetaPageBuildException {

        final int page = 1;
        final int pageSize = 10;
        final ActivityType activityType = ActivityType.ACCOUNT_ADD_PERSON;
        final EntityType entityType = EntityType.ACCOUNT;

        activityPageRequest = ActivityPageRequest.builder()
                .page(page)
                .pageSize(pageSize)
                .activityType(activityType)
                .entityType(entityType)
                .orderBy("id")
                .orderByDirection(Sort.ASC)
                .customParams(new HashMap<>())
                .build();
    }

    /**
     * This method tests the ActivityPageRequest's builder's constructor.
     */
    @Test
    public void testBuilderConstructor() throws OutsetaPageBuildException {

        final int page = 1;
        final int pageSize = 10;
        final ActivityType activityType = ActivityType.ACCOUNT_ADD_PERSON;
        final EntityType entityType = EntityType.ACCOUNT;

        final ActivityPageRequest.Builder builder =
                new ActivityPageRequest.Builder();

        assertNull(builder.build().getPageNum());
        assertNull(builder.build().getPageSize());
        assertNull(builder.build().getActivityType());
        assertNull(builder.build().getEntityType());

        assertEquals(builder.page(page).build().getPageNum(), page);
        assertEquals(builder
                .pageSize(pageSize).build().getPageSize(), pageSize);
        assertEquals(builder.activityType(activityType)
                .build().getActivityType(), activityType.getValue());
        assertEquals(builder
                .activityType(ActivityType.ACCOUNT_ADD_PERSON.getValue())
                .build().getActivityType(), activityType.getValue());
        assertEquals(builder
                .entityType(EntityType.ACCOUNT.getValue())
                        .build().getEntityType(),
                entityType.getValue());
    }

    /**
     * This method tests the ActivityPageRequest's builder method.
     */
    @Test
    public void testBuilder() throws OutsetaPageBuildException {

        final int page = 1;
        final int pageSize = 10;
        final ActivityType activityType = ActivityType.ACCOUNT_ADD_PERSON;
        final EntityType entityType = EntityType.ACCOUNT;

        final ActivityPageRequest.Builder builder =
                ActivityPageRequest.builder()
                        .page(page)
                        .pageSize(pageSize)
                        .activityType(activityType)
                        .entityType(entityType);

        assertEquals(builder.build().getPageNum(), page);
        assertEquals(builder.build().getPageSize(), pageSize);
        assertEquals(builder.build().getActivityType(),
                activityType.getValue());
        assertEquals(builder.build().getEntityType(),
                entityType.getValue());
    }

    /**
     * This method tests the build params method.
     */
    @Test
    public void testBuildParams() throws OutsetaPageBuildException {

        final int page = 1;
        final int pageSize = 10;
        final ActivityType activityType = ActivityType.ACCOUNT_ADD_PERSON;
        final EntityType entityType = EntityType.ACCOUNT;

        final ActivityPageRequest.Builder builder =
                ActivityPageRequest.builder()
                        .page(page)
                        .pageSize(pageSize)
                        .activityType(activityType)
                        .entityType(entityType);

        assertEquals(builder.build().buildParams().get("offset"),
                Integer.toString(page));
        assertEquals(builder.build().buildParams().get("limit"),
                Integer.toString(pageSize));
        assertEquals(builder.build().buildParams().get("ActivityType"),
                activityType.getValue());
        assertEquals(builder.build().buildParams().get("EntityType"),
                entityType.getValue());

        assertFalse(ActivityPageRequest.builder()
                .build().buildParams().containsKey("ActivityType"));
        assertFalse(ActivityPageRequest.builder()
                .build().buildParams().containsKey("EntityType"));
    }

    /**
     * This method tests the set activity type method.
     */
    @Test
    public void testSetActivityType() {

        this.activityPageRequest.setActivityType(1);
        assertEquals(1, this.activityPageRequest.getActivityType());

    }

    /**
     * This method tests the set entity type method.
     */
    @Test
    public void testSetEntityType() {

        this.activityPageRequest.setEntityType(1);
        assertEquals(1, this.activityPageRequest.getEntityType());

    }

    /**
     * This method tests the getNextPage method of ActivityPageRequest.
     */
    @Test
    public void testTransactionPageRequestGetNextPage() {

        final int page = 1;
        final int pageSize = 10;
        final ActivityType activityType = ActivityType.ACCOUNT_ADD_PERSON;
        final EntityType entityType = EntityType.ACCOUNT;

        assertDoesNotThrow(() -> {

            ActivityPageRequest nextPageRequest = activityPageRequest
                    .nextPageRequest();

            assertNotNull(nextPageRequest);
            assertEquals(nextPageRequest.getPageNum(), page + 1);
            assertEquals(nextPageRequest.getPageSize(), pageSize);
            assertEquals(nextPageRequest.getActivityType(),
                    activityType.getValue());
            assertEquals(nextPageRequest.getEntityType(),
                    entityType.getValue());
        });
    }
}
