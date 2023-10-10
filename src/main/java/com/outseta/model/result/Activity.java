package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.constant.ActivityType;
import com.outseta.constant.EntityType;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.Objects;

/**
 * This class is used to represent the data returned for the Activity
 * entity.
 */
public class Activity implements BaseResult, BaseInput {

    /**
     * This class is used to build an Activity object.
     */
    public static class Builder {

        /**
         * The Activity object to be created.
         */
        private final Activity activity;

        /**
         * The constructor initializes the Activity object that is
         * being built.
         */
        public Builder() {
            this.activity = new Activity();
        }

        /**
         * Sets the title of the activity.
         * @param pTitle The title of the activity.
         * @return The Builder object.
         */
        public Builder title(final String pTitle) {
            this.activity.title = pTitle;
            return this;
        }

        /**
         * Sets the description of the activity.
         * @param pDescription The description of the activity.
         * @return The Builder object.
         */
        public Builder description(final String pDescription) {
            this.activity.description = pDescription;
            return this;
        }

        /**
         * Sets the data of the activity.
         * @param pActivityData The data of the activity.
         * @return The Builder object.
         */
        public Builder activityData(final String pActivityData) {
            this.activity.activityData = pActivityData;
            return this;
        }

        /**
         * Sets the date and time of the activity.
         * @param pActivityDateTime The date and time of the activity.
         * @return The Builder object.
         */
        public Builder activityDateTime(final Date pActivityDateTime) {
            this.activity.activityDateTime = pActivityDateTime;
            return this;
        }

        /**
         * Sets the type of the activity.
         * @param pActivityType The type of the activity.
         * @return The Builder object.
         */
        public Builder activityType(final int pActivityType) {
            this.activity.activityType = pActivityType;
            return this;
        }

        /**
         * Sets the type of the activity.
         * @param pActivityType The type of the activity.
         * @return The Builder object.
         */
        public Builder activityType(final ActivityType pActivityType) {
            this.activity.activityType = pActivityType.getValue();
            return this;
        }

        /**
         * Sets the entity type of the activity.
         * @param pEntityType The entity type of the activity.
         * @return The Builder object.
         */
        public Builder entityType(final int pEntityType) {
            this.activity.entityType = pEntityType;
            return this;
        }

        /**
         * Sets the entity type of the activity.
         * @param pEntityType The entity type of the activity.
         * @return The Builder object.
         */
        public Builder entityType(final EntityType pEntityType) {
            this.activity.entityType = pEntityType.getValue();
            return this;
        }

        /**
         * Sets the entity uid of the activity.
         * @param pEntityUid The entity uid of the activity.
         * @return The Builder object.
         */
        public Builder entityUid(final String pEntityUid) {
            this.activity.entityUid = pEntityUid;
            return this;
        }

        /**
         * Sets the unique identifier for this activity.
         * @param pUid The unique identifier for this activity.
         * @return The Builder object.
         */
        public Builder uid(final String pUid) {
            this.activity.uid = pUid;
            return this;
        }

        /**
         * Sets the date this activity was created.
         * @param pCreated The date this activity was created.
         * @return The Builder object.
         */
        public Builder created(final Date pCreated) {
            this.activity.created = pCreated;
            return this;
        }

        /**
         * Sets the date this activity was last updated.
         * @param pUpdated The date this activity was last updated.
         * @return The Builder object.
         */
        public Builder updated(final Date pUpdated) {
            this.activity.updated = pUpdated;
            return this;
        }

        /**
         * Returns the Activity object that was built.
         * @return The Activity object that was built.
         */
        public Activity build() {
            return this.activity;
        }
    }

    /**
     * The title of the activity.
     */
    @JsonProperty("Title")
    private String title;

    /**
     * The description of the activity.
     */
    @JsonProperty("Description")
    private String description;

    /**
     * The data of the activity.
     */
    @JsonProperty("ActivityData")
    private String activityData;

    /**
     * The date and time of the activity.
     */
    @JsonProperty("ActivityDateTime")
    private Date activityDateTime;

    /**
     * The type of the activity.
     */
    @JsonProperty("ActivityType")
    private int activityType;

    /**
     * The entity type of the activity.
     */
    @JsonProperty("EntityType")
    private int entityType;

    /**
     * The entity uid of the activity.
     */
    @JsonProperty("EntityUid")
    private String entityUid;

    /**
     * The unique identifier for this activity.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * The date this activity was created.
     */
    @JsonProperty("Created")
    private Date created;

    /**
     * The date this activity was last updated.
     */
    @JsonProperty("Updated")
    private Date updated;

    /**
     * This method is used to create a new Builder object.
     * @return A new Builder object.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Default constructor for the creation of an Activity object.
     */
    public Activity() {

    }

    /**
     * Gets the title of the activity.
     * @return The title of the activity.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the activity.
     * @param pTitle The title of the activity.
     */
    public void setTitle(final String pTitle) {
        this.title = pTitle;
    }

    /**
     * Gets the description of the activity.
     * @return The description of the activity.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the activity.
     * @param pDescription The description of the activity.
     */
    public void setDescription(final String pDescription) {
        this.description = pDescription;
    }

    /**
     * Gets the data of the activity.
     * @return The data of the activity.
     */
    public String getActivityData() {
        return activityData;
    }

    /**
     * Sets the data of the activity.
     * @param pActivityData The data of the activity.
     */
    public void setActivityData(final String pActivityData) {
        this.activityData = pActivityData;
    }

    /**
     * Gets the date and time of the activity.
     * @return The date and time of the activity.
     */
    public Date getActivityDateTime() {
        return activityDateTime;
    }

    /**
     * Sets the date and time of the activity.
     * @param pActivityDateTime The date and time of the activity.
     */
    public void setActivityDateTime(final Date pActivityDateTime) {
        this.activityDateTime = pActivityDateTime;
    }

    /**
     * Gets the type of the activity.
     * @return The type of the activity.
     */
    public int getActivityType() {
        return activityType;
    }

    /**
     * Sets the type of the activity.
     * @param pActivityType The type of the activity.
     */
    public void setActivityType(final int pActivityType) {
        this.activityType = pActivityType;
    }

    /**
     * Gets the entity type of the activity.
     * @return The entity type of the activity.
     */
    public int getEntityType() {
        return entityType;
    }

    /**
     * Sets the entity type of the activity.
     * @param pEntityType The entity type of the activity.
     */
    public void setEntityType(final int pEntityType) {
        this.entityType = pEntityType;
    }

    /**
     * Gets the entity uid of the activity.
     * @return The entity uid of the activity.
     */
    public String getEntityUid() {
        return entityUid;
    }

    /**
     * Sets the entity uid of the activity.
     * @param pEntityUid The entity uid of the activity.
     */
    public void setEntityUid(final String pEntityUid) {
        this.entityUid = pEntityUid;
    }

    /**
     * Gets the unique identifier for this activity.
     * @return The unique identifier for this activity.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the unique identifier for this activity.
     * @param pUid The unique identifier for this activity.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Gets the date this activity was created.
     * @return The date this activity was created.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the date this activity was created.
     * @param pCreated The date this activity was created.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Gets the date this activity was last updated.
     * @return The date this activity was last updated.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the date this activity was last updated.
     * @param pUpdated The date this activity was last updated.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * Compares this Activity to another Object for equality.
     * @param pObject The Object to compare to.
     * @return True if the Activities are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object pObject) {
        if (this == pObject) {
            return true;
        }

        if (!(pObject instanceof Activity)) {
            return false;
        }

        Activity otherActivity = (Activity) pObject;

        return Objects.equals(this.title, otherActivity.title)
                && Objects.equals(this.description, otherActivity.description)
                && Objects.equals(this.activityData, otherActivity.activityData)
                && Objects
                    .equals(this.activityDateTime,
                            otherActivity.activityDateTime)
                && Objects.equals(this.activityType, otherActivity.activityType)
                && Objects.equals(this.entityType, otherActivity.entityType)
                && Objects.equals(this.entityUid, otherActivity.entityUid)
                && Objects.equals(this.uid, otherActivity.uid)
                && Objects.equals(this.created, otherActivity.created)
                && Objects.equals(this.updated, otherActivity.updated);
    }

    /**
     * Returns the hash code for this Activity.
     * @return The hash code for this Activity.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.description, this.activityData,
                this.activityDateTime, this.activityType, this.entityType,
                this.entityUid, this.uid, this.created, this.updated);
    }
}
