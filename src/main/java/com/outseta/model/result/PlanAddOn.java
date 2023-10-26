package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a PlanAddOn object.
 */
public class PlanAddOn implements BaseInput, BaseResult {

    /**
     * Builder class for PlanAddOn.
     */
    public static class Builder {

        /**
         * The PlanAddOn object to build.
         */
        private PlanAddOn planAddOn;

        /**
         * Constructor to initialize the PlanAddOn object in the builder.
         */
        public Builder() {
            this.planAddOn = new PlanAddOn();
        }

        /**
         * Sets the plan associated with the PlanAddOn.
         *
         * @param plan The plan associated with the PlanAddOn.
         * @return The builder instance for method chaining.
         */
        public Builder plan(final Plan plan) {
            planAddOn.setPlan(plan);
            return this;
        }

        /**
         * Sets the add-on associated with the PlanAddOn.
         *
         * @param addOn The add-on associated with the PlanAddOn.
         * @return The builder instance for method chaining.
         */
        public Builder addOn(final AddOn addOn) {
            planAddOn.setAddOn(addOn);
            return this;
        }

        /**
         * Sets whether the add-on is user-selectable.
         *
         * @param userSelectable True if the add-on is user-selectable,
         *                       false otherwise.
         * @return The builder instance for method chaining.
         */
        public Builder userSelectable(final Boolean userSelectable) {
            planAddOn.setUserSelectable(userSelectable);
            return this;
        }

        /**
         * Sets the activity event data associated with the PlanAddOn.
         *
         * @param activityEventData The activity event data associated with the
         *                          PlanAddOn.
         * @return The builder instance for method chaining.
         */
        public Builder activityEventData(final String activityEventData) {
            planAddOn.setActivityEventData(activityEventData);
            return this;
        }

        /**
         * Sets the unique identifier of the PlanAddOn.
         *
         * @param uid The unique identifier of the PlanAddOn.
         * @return The builder instance for method chaining.
         */
        public Builder uid(final String uid) {
            planAddOn.setUid(uid);
            return this;
        }

        /**
         * Sets the creation timestamp of the PlanAddOn.
         *
         * @param created The creation timestamp of the PlanAddOn.
         * @return The builder instance for method chaining.
         */
        public Builder created(final Date created) {
            planAddOn.setCreated(created);
            return this;
        }

        /**
         * Sets the last update timestamp of the PlanAddOn.
         *
         * @param updated The last update timestamp of the PlanAddOn.
         * @return The builder instance for method chaining.
         */
        public Builder updated(final Date updated) {
            planAddOn.setUpdated(updated);
            return this;
        }

        /**
         * Builds the PlanAddOn object.
         *
         * @return The built PlanAddOn object.
         */
        public PlanAddOn build() {
            return planAddOn;
        }
    }

    /**
     * The plan associated with the PlanAddOn.
     */
    @JsonProperty("Plan")
    private Plan plan;

    /**
     * The add-on associated with the PlanAddOn.
     */
    @JsonProperty("AddOn")
    private AddOn addOn;

    /**
     * Indicates whether the add-on is user-selectable.
     */
    @JsonProperty("IsUserSelectable")
    private Boolean isUserSelectable;

    /**
     * Activity event data associated with the PlanAddOn.
     */
    @JsonProperty("ActivityEventData")
    private String activityEventData;

    /**
     * The unique identifier of the PlanAddOn.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * The creation timestamp of the PlanAddOn.
     */
    @JsonProperty("Created")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * The last update timestamp of the PlanAddOn.
     */
    @JsonProperty("Updated")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updated;

    /**
     * This method is used to get a builder that can be used to build a
     * PlanAddOn object.
     *
     * @return The builder that can be used to build a PlanAddOn object.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Default constructor.
     */
    public PlanAddOn() {
    }

    /**
     * Gets the plan associated with the PlanAddOn.
     *
     * @return The plan associated with the PlanAddOn.
     */
    public Plan getPlan() {
        return plan;
    }

    /**
     * Sets the plan associated with the PlanAddOn.
     *
     * @param pPlan The plan associated with the PlanAddOn.
     */
    public void setPlan(final Plan pPlan) {
        this.plan = pPlan;
    }

    /**
     * Gets the add-on associated with the PlanAddOn.
     *
     * @return The add-on associated with the PlanAddOn.
     */
    public AddOn getAddOn() {
        return addOn;
    }

    /**
     * Sets the add-on associated with the PlanAddOn.
     *
     * @param pAddOn The add-on associated with the PlanAddOn.
     */
    public void setAddOn(final AddOn pAddOn) {
        this.addOn = pAddOn;
    }

    /**
     * Checks whether the add-on is user-selectable.
     *
     * @return True if the add-on is user-selectable, false otherwise.
     */
    public Boolean isUserSelectable() {
        return isUserSelectable;
    }

    /**
     * Sets whether the add-on is user-selectable.
     *
     * @param pIsUserSelectable True if the add-on is user-selectable,
     *                          false otherwise.
     */
    public void setUserSelectable(final Boolean pIsUserSelectable) {
        this.isUserSelectable = pIsUserSelectable;
    }

    /**
     * Gets the activity event data associated with the PlanAddOn.
     *
     * @return The activity event data associated with the PlanAddOn.
     */
    public String getActivityEventData() {
        return activityEventData;
    }

    /**
     * Sets the activity event data associated with the PlanAddOn.
     *
     * @param pActivityEventData The activity event data associated with
     *                           the PlanAddOn.
     */
    public void setActivityEventData(final String pActivityEventData) {
        this.activityEventData = pActivityEventData;
    }

    /**
     * Gets the unique identifier of the PlanAddOn.
     *
     * @return The unique identifier of the PlanAddOn.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the unique identifier of the PlanAddOn.
     *
     * @param pUid The unique identifier of the PlanAddOn.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Gets the creation timestamp of the PlanAddOn.
     *
     * @return The creation timestamp of the PlanAddOn.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the creation timestamp of the PlanAddOn.
     *
     * @param pCreated The creation timestamp of the PlanAddOn.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Gets the last update timestamp of the PlanAddOn.
     *
     * @return The last update timestamp of the PlanAddOn.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the last update timestamp of the PlanAddOn.
     *
     * @param pUpdated The last update timestamp of the PlanAddOn.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * This method is used to compare two PlanAddOn objects.
     *
     * @param other The other PlanAddOn object.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof PlanAddOn)) {
            return false;
        }

        PlanAddOn planAddOn = (PlanAddOn) other;

        return Objects.equals(this.uid, planAddOn.uid);
    }

    /**
     * This method is used to get the hash code for the PlanAddOn object.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
