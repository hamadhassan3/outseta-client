package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * This class is used to represent a plan family.
 */
public class PlanFamily implements BaseResult {

    /**
     * The Builder class allows creation of a PlanFamily object.
     */
    public static class Builder {

        /**
         * The PlanFamily object to build.
         */
        private PlanFamily planFamily = new PlanFamily();

        /**
         * Sets the name of the PlanFamily.
         * @param name The name to set.
         * @return The Builder object for chaining.
         */
        public Builder name(final String name) {
            planFamily.name = name;
            return this;
        }

        /**
         * Sets whether the PlanFamily is active.
         * @param isActive True to activate, false to deactivate.
         * @return The Builder object for chaining.
         */
        public Builder active(final Boolean isActive) {
            planFamily.isActive = isActive;
            return this;
        }

        /**
         * Sets whether the PlanFamily is the default.
         * @param isDefault True to set as default, false otherwise.
         * @return The Builder object for chaining.
         */
        public Builder isDefault(final Boolean isDefault) {
            planFamily.isDefault = isDefault;
            return this;
        }

        /**
         * Sets the list of plans associated with the PlanFamily.
         * @param plans The list of plans to set.
         * @return The Builder object for chaining.
         */
        public Builder plans(final List<Plan> plans) {
            planFamily.plans = plans;
            return this;
        }

        /**
         * Sets the date when the PlanFamily was created.
         * @param created The creation date to set.
         * @return The Builder object for chaining.
         */
        public Builder created(final Date created) {
            planFamily.created = created;
            return this;
        }

        /**
         * Sets the date when the PlanFamily was last updated.
         * @param updated The last updated date to set.
         * @return The Builder object for chaining.
         */
        public Builder updated(final Date updated) {
            planFamily.updated = updated;
            return this;
        }

        /**
         * Sets additional activity event data for the PlanFamily.
         * @param activityEventData The activity event data to set.
         * @return The Builder object for chaining.
         */
        public Builder activityEventData(final String activityEventData) {
            planFamily.activityEventData = activityEventData;
            return this;
        }

        /**
         * Sets the unique identifier for the PlanFamily.
         * @param uid The unique identifier to set.
         * @return The Builder object for chaining.
         */
        public Builder uid(final String uid) {
            planFamily.uid = uid;
            return this;
        }

        /**
         * Builds the PlanFamily object.
         * @return The PlanFamily object.
         */
        public PlanFamily build() {
            return planFamily;
        }
    }

    /**
     * The name of the plan family.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Whether the plan is active or not.
     */
    @JsonProperty("IsActive")
    private Boolean isActive;

    /**
     * Whether the plan is the default or not.
     */
    @JsonProperty("IsDefault")
    private Boolean isDefault;

    /**
     * The list of plans associated with the plan family.
     */
    @JsonProperty("Plans")
    private List<Plan> plans;

    /**
     * The date when the plan family was created.
     */
    @JsonProperty("Created")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * The date when the plan family was last updated.
     */
    @JsonProperty("Updated")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updated;

    /**
     * Additional activity event data for the plan family.
     */
    @JsonProperty("ActivityEventData")
    private String activityEventData;

    /**
     * The unique identifier for the plan family.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * Returns a builder that can be used to create an PlanFamily instance.
     *
     * @return The builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Gets the name of the PlanFamily.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the PlanFamily.
     *
     * @param pName The name to set.
     */
    public void setName(final String pName) {
        this.name = pName;
    }

    /**
     * Indicates if the PlanFamily is active.
     *
     * @return True if active, false otherwise.
     */
    public Boolean isActive() {
        return isActive;
    }

    /**
     * Sets whether the PlanFamily is active.
     *
     * @param pIsActive True to activate, false to deactivate.
     */
    public void setActive(final Boolean pIsActive) {
        this.isActive = pIsActive;
    }

    /**
     * Indicates if the PlanFamily is the default.
     *
     * @return True if the default, false otherwise.
     */
    public Boolean isDefault() {
        return isDefault;
    }

    /**
     * Sets whether the PlanFamily is the default.
     *
     * @param pIsDefault True to set as default, false otherwise.
     */
    public void setDefault(final Boolean pIsDefault) {
        this.isDefault = pIsDefault;
    }

    /**
     * Gets the list of plans associated with the PlanFamily.
     *
     * @return The list of plans.
     */
    public List<Plan> getPlans() {
        return plans;
    }

    /**
     * Sets the list of plans associated with the PlanFamily.
     *
     * @param pPlans The list of plans to set.
     */
    public void setPlans(final List<Plan> pPlans) {
        this.plans = pPlans;
    }

    /**
     * Gets the date when the PlanFamily was created.
     *
     * @return The creation date.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the date when the PlanFamily was created.
     *
     * @param pCreated The creation date to set.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Gets the date when the PlanFamily was last updated.
     *
     * @return The last updated date.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the date when the PlanFamily was last updated.
     *
     * @param pUpdated The last updated date to set.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * Gets additional activity event data for the PlanFamily.
     *
     * @return The activity event data.
     */
    public String getActivityEventData() {
        return activityEventData;
    }

    /**
     * Sets additional activity event data for the PlanFamily.
     *
     * @param pActivityEventData The activity event data to set.
     */
    public void setActivityEventData(final String pActivityEventData) {
        this.activityEventData = pActivityEventData;
    }

    /**
     * Gets the unique identifier for the PlanFamily.
     *
     * @return The unique identifier.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the unique identifier for the PlanFamily.
     *
     * @param pUid The unique identifier to set.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * This method is used to compare two PlanFamily objects.
     *
     * @param other The other PlanFamily object.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof PlanFamily)) {
            return false;
        }

        PlanFamily otherPlanFamily = (PlanFamily) other;

        return Objects.equals(this.uid, otherPlanFamily.uid);
    }

    /**
     * This method is used to get the hash code for the PlanFamily object.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
            return Objects.hash(uid);
    }
}
