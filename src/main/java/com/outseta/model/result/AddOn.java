package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * This class is used to represent an add-on.
 */
public class AddOn implements BaseInput, BaseResult {

    /**
     * Builder class for constructing an instance of AddOn.
     */
    public static class Builder {

        /**
         * The AddOn instance being constructed.
         */
        private final AddOn addOn;

        /**
         * Constructs a new instance of the Builder.
         */
        public Builder() {
            addOn = new AddOn();
        }

        /**
         * Sets the name of the AddOn.
         *
         * @param pName The name to set.
         * @return The builder instance.
         */
        public Builder name(final String pName) {
            addOn.name = pName;
            return this;
        }

        /**
         * Sets the billing add-on type.
         *
         * @param pBillingAddOnType The billing add-on type to set.
         * @return The builder instance.
         */
        public Builder billingAddOnType(final Integer pBillingAddOnType) {
            addOn.billingAddOnType = pBillingAddOnType;
            return this;
        }

        /**
         * Sets whether the quantity is editable.
         *
         * @param pIsQuantityEditable True if the quantity is editable,
         *                            false otherwise.
         * @return The builder instance.
         */
        public Builder quantityEditable(final Boolean pIsQuantityEditable) {
            addOn.isQuantityEditable = pIsQuantityEditable;
            return this;
        }

        /**
         * Sets the minimum quantity allowed.
         *
         * @param pMinimumQuantity The minimum quantity to set.
         * @return The builder instance.
         */
        public Builder minimumQuantity(final Integer pMinimumQuantity) {
            addOn.minimumQuantity = pMinimumQuantity;
            return this;
        }

        /**
         * Sets the monthly rate for the AddOn.
         *
         * @param pMonthlyRate The monthly rate to set.
         * @return The builder instance.
         */
        public Builder monthlyRate(final Double pMonthlyRate) {
            addOn.monthlyRate = pMonthlyRate;
            return this;
        }

        /**
         * Sets the annual rate for the AddOn.
         *
         * @param pAnnualRate The annual rate to set.
         * @return The builder instance.
         */
        public Builder annualRate(final Double pAnnualRate) {
            addOn.annualRate = pAnnualRate;
            return this;
        }

        /**
         * Sets the setup fee for the AddOn.
         *
         * @param pSetupFee The setup fee to set.
         * @return The builder instance.
         */
        public Builder setupFee(final Double pSetupFee) {
            addOn.setupFee = pSetupFee;
            return this;
        }

        /**
         * Sets the unit of measure for the AddOn.
         *
         * @param pUnitOfMeasure The unit of measure to set.
         * @return The builder instance.
         */
        public Builder unitOfMeasure(final String pUnitOfMeasure) {
            addOn.unitOfMeasure = pUnitOfMeasure;
            return this;
        }

        /**
         * Sets whether the AddOn is taxable.
         *
         * @param pIsTaxable True if taxable, false otherwise.
         * @return The builder instance.
         */
        public Builder taxable(final Boolean pIsTaxable) {
            addOn.isTaxable = pIsTaxable;
            return this;
        }

        /**
         * Sets whether the AddOn is billed during the trial.
         *
         * @param pIsBilledDuringTrial True if billed during the trial,
         *                             false otherwise.
         * @return The builder instance.
         */
        public Builder billedDuringTrial(
                final Boolean pIsBilledDuringTrial) {
            addOn.isBilledDuringTrial = pIsBilledDuringTrial;
            return this;
        }

        /**
         * Sets the Stripe tax code ID for the AddOn.
         *
         * @param pStripeTaxCodeId The Stripe tax code ID to set.
         * @return The builder instance.
         */
        public Builder stripeTaxCodeId(final String pStripeTaxCodeId) {
            addOn.stripeTaxCodeId = pStripeTaxCodeId;
            return this;
        }

        /**
         * Sets the list of plan add-ons associated with the AddOn.
         *
         * @param pPlanAddOns The list of plan add-ons to set.
         * @return The builder instance.
         */
        public Builder planAddOns(final List<PlanAddOn> pPlanAddOns) {
            addOn.planAddOns = pPlanAddOns;
            return this;
        }

        /**
         * Sets the list of content groups associated with the AddOn.
         *
         * @param pContentGroups The list of content groups to set.
         * @return The builder instance.
         */
        public Builder contentGroups(final List<String> pContentGroups) {
            addOn.contentGroups = pContentGroups;
            return this;
        }

        /**
         * Sets the subscription count for the AddOn.
         *
         * @param pSubscriptionCount The subscription count to set.
         * @return The builder instance.
         */
        public Builder subscriptionCount(final Integer pSubscriptionCount) {
            addOn.subscriptionCount = pSubscriptionCount;
            return this;
        }

        /**
         * Sets the quantity of the AddOn.
         *
         * @param pQuantity The quantity to set.
         * @return The builder instance.
         */
        public Builder quantity(final Integer pQuantity) {
            addOn.quantity = pQuantity;
            return this;
        }

        /**
         * Sets additional activity event data for the AddOn.
         *
         * @param pActivityEventData The activity event data to set.
         * @return The builder instance.
         */
        public Builder activityEventData(final String pActivityEventData) {
            addOn.activityEventData = pActivityEventData;
            return this;
        }

        /**
         * Sets the unique identifier for the AddOn.
         *
         * @param pUid The unique identifier to set.
         * @return The builder instance.
         */
        public Builder uid(final String pUid) {
            addOn.uid = pUid;
            return this;
        }

        /**
         * Sets the date when the AddOn was created.
         *
         * @param pCreated The creation date to set.
         * @return The builder instance.
         */
        public Builder created(final Date pCreated) {
            addOn.created = pCreated;
            return this;
        }

        /**
         * Sets the date when the AddOn was last updated.
         *
         * @param pUpdated The last updated date to set.
         * @return The builder instance.
         */
        public Builder updated(final Date pUpdated) {
            addOn.updated = pUpdated;
            return this;
        }

        /**
         * Builds an instance of the AddOn.
         *
         * @return The built AddOn instance.
         */
        public AddOn build() {
            return addOn;
        }
    }

    /**
     * The name of the AddOn.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * The billing add-on type.
     */
    @JsonProperty("BillingAddOnType")
    private Integer billingAddOnType;

    /**
     * Indicates if the quantity is editable.
     */
    @JsonProperty("IsQuantityEditable")
    private Boolean isQuantityEditable;

    /**
     * The minimum quantity allowed.
     */
    @JsonProperty("MinimumQuantity")
    private Integer minimumQuantity;

    /**
     * The monthly rate for the AddOn.
     */
    @JsonProperty("MonthlyRate")
    private Double monthlyRate;

    /**
     * The annual rate for the AddOn.
     */
    @JsonProperty("AnnualRate")
    private Double annualRate;

    /**
     * The setup fee for the AddOn.
     */
    @JsonProperty("SetupFee")
    private Double setupFee;

    /**
     * The unit of measure for the AddOn.
     */
    @JsonProperty("UnitOfMeasure")
    private String unitOfMeasure;

    /**
     * Indicates if the AddOn is taxable.
     */
    @JsonProperty("IsTaxable")
    private Boolean isTaxable;

    /**
     * Indicates if the AddOn is billed during the trial.
     */
    @JsonProperty("IsBilledDuringTrial")
    private Boolean isBilledDuringTrial;

    /**
     * The Stripe tax code ID for the AddOn.
     */
    @JsonProperty("StripeTaxCodeId")
    private String stripeTaxCodeId;

    /**
     * The list of plan add-ons associated with the AddOn.
     */
    @JsonProperty("PlanAddOns")
    private List<PlanAddOn> planAddOns;

    /**
     * The list of content groups associated with the AddOn.
     */
    @JsonProperty("ContentGroups")
    private List<String> contentGroups;

    /**
     * The subscription count for the AddOn.
     */
    @JsonProperty("SubscriptionCount")
    private Integer subscriptionCount;

    /**
     * The quantity of the AddOn.
     */
    @JsonProperty("Quantity")
    private Integer quantity;

    /**
     * Additional activity event data for the AddOn.
     */
    @JsonProperty("ActivityEventData")
    private String activityEventData;

    /**
     * The unique identifier for the AddOn.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * The date when the AddOn was created.
     */
    @JsonProperty("Created")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * The date when the AddOn was last updated.
     */
    @JsonProperty("Updated")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updated;

    /**
     * Returns a builder that can be used to create an AddOn instance.
     * @return The builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The default constructor for the AddOn.
     */
    public AddOn() {

    }

    /**
     * Gets the name of the AddOn.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the AddOn.
     *
     * @param pName The name to set.
     */
    public void setName(final String pName) {
        this.name = pName;
    }

    /**
     * Gets the billing add-on type.
     *
     * @return The billing add-on type.
     */
    public Integer getBillingAddOnType() {
        return billingAddOnType;
    }

    /**
     * Sets the billing add-on type.
     *
     * @param pBillingAddOnType The billing add-on type to set.
     */
    public void setBillingAddOnType(final Integer pBillingAddOnType) {
        this.billingAddOnType = pBillingAddOnType;
    }

    /**
     * Indicates if the quantity is editable.
     *
     * @return True if the quantity is editable, false otherwise.
     */
    public Boolean isQuantityEditable() {
        return isQuantityEditable;
    }

    /**
     * Sets whether the quantity is editable.
     *
     * @param pIsQuantityEditable True if the quantity is editable,
     *                           false otherwise.
     */
    public void setQuantityEditable(final Boolean pIsQuantityEditable) {
        this.isQuantityEditable = pIsQuantityEditable;
    }

    /**
     * Gets the minimum quantity allowed.
     *
     * @return The minimum quantity.
     */
    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    /**
     * Sets the minimum quantity allowed.
     *
     * @param pMinimumQuantity The minimum quantity to set.
     */
    public void setMinimumQuantity(final Integer pMinimumQuantity) {
        this.minimumQuantity = pMinimumQuantity;
    }

    /**
     * Gets the monthly rate for the AddOn.
     *
     * @return The monthly rate.
     */
    public Double getMonthlyRate() {
        return monthlyRate;
    }

    /**
     * Sets the monthly rate for the AddOn.
     *
     * @param pMonthlyRate The monthly rate to set.
     */
    public void setMonthlyRate(final Double pMonthlyRate) {
        this.monthlyRate = pMonthlyRate;
    }

    /**
     * Gets the annual rate for the AddOn.
     *
     * @return The annual rate.
     */
    public Double getAnnualRate() {
        return annualRate;
    }

    /**
     * Sets the annual rate for the AddOn.
     *
     * @param pAnnualRate The annual rate to set.
     */
    public void setAnnualRate(final Double pAnnualRate) {
        this.annualRate = pAnnualRate;
    }

    /**
     * Gets the setup fee for the AddOn.
     *
     * @return The setup fee.
     */
    public Double getSetupFee() {
        return setupFee;
    }

    /**
     * Sets the setup fee for the AddOn.
     *
     * @param pSetupFee The setup fee to set.
     */
    public void setSetupFee(final Double pSetupFee) {
        this.setupFee = pSetupFee;
    }

    /**
     * Gets the unit of measure for the AddOn.
     *
     * @return The unit of measure.
     */
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Sets the unit of measure for the AddOn.
     *
     * @param pUnitOfMeasure The unit of measure to set.
     */
    public void setUnitOfMeasure(final String pUnitOfMeasure) {
        this.unitOfMeasure = pUnitOfMeasure;
    }

    /**
     * Indicates if the AddOn is taxable.
     *
     * @return True if taxable, false otherwise.
     */
    public Boolean isTaxable() {
        return isTaxable;
    }

    /**
     * Sets whether the AddOn is taxable.
     *
     * @param pIsTaxable True if taxable, false otherwise.
     */
    public void setTaxable(final Boolean pIsTaxable) {
        this.isTaxable = pIsTaxable;
    }

    /**
     * Indicates if the AddOn is billed during the trial.
     *
     * @return True if billed during the trial, false otherwise.
     */
    public Boolean isBilledDuringTrial() {
        return isBilledDuringTrial;
    }

    /**
     * Sets whether the AddOn is billed during the trial.
     *
     * @param pIsBilledDuringTrial True if billed during the trial,
     *                             false otherwise.
     */
    public void setBilledDuringTrial(final Boolean pIsBilledDuringTrial) {
        this.isBilledDuringTrial = pIsBilledDuringTrial;
    }

    /**
     * Gets the Stripe tax code ID for the AddOn.
     *
     * @return The Stripe tax code ID.
     */
    public String getStripeTaxCodeId() {
        return stripeTaxCodeId;
    }

    /**
     * Sets the Stripe tax code ID for the AddOn.
     *
     * @param pStripeTaxCodeId The Stripe tax code ID to set.
     */
    public void setStripeTaxCodeId(final String pStripeTaxCodeId) {
        this.stripeTaxCodeId = pStripeTaxCodeId;
    }

    /**
     * Gets the list of plan add-ons associated with the AddOn.
     *
     * @return The list of plan add-ons.
     */
    public List<PlanAddOn> getPlanAddOns() {
        return planAddOns;
    }

    /**
     * Sets the list of plan add-ons associated with the AddOn.
     *
     * @param pPlanAddOns The list of plan add-ons to set.
     */
    public void setPlanAddOns(final List<PlanAddOn> pPlanAddOns) {
        this.planAddOns = pPlanAddOns;
    }

    /**
     * Gets the list of content groups associated with the AddOn.
     *
     * @return The list of content groups.
     */
    public List<String> getContentGroups() {
        return contentGroups;
    }

    /**
     * Sets the list of content groups associated with the AddOn.
     *
     * @param pContentGroups The list of content groups to set.
     */
    public void setContentGroups(final List<String> pContentGroups) {
        this.contentGroups = pContentGroups;
    }

    /**
     * Gets the subscription count for the AddOn.
     *
     * @return The subscription count.
     */
    public Integer getSubscriptionCount() {
        return subscriptionCount;
    }

    /**
     * Sets the subscription count for the AddOn.
     *
     * @param pSubscriptionCount The subscription count to set.
     */
    public void setSubscriptionCount(final Integer pSubscriptionCount) {
        this.subscriptionCount = pSubscriptionCount;
    }

    /**
     * Gets the quantity of the AddOn.
     *
     * @return The quantity.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the AddOn.
     *
     * @param pQuantity The quantity to set.
     */
    public void setQuantity(final Integer pQuantity) {
        this.quantity = pQuantity;
    }

    /**
     * Gets additional activity event data for the AddOn.
     *
     * @return The activity event data.
     */
    public String getActivityEventData() {
        return activityEventData;
    }

    /**
     * Sets additional activity event data for the AddOn.
     *
     * @param pActivityEventData The activity event data to set.
     */
    public void setActivityEventData(final String pActivityEventData) {
        this.activityEventData = pActivityEventData;
    }

    /**
     * Gets the unique identifier for the AddOn.
     *
     * @return The unique identifier.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the unique identifier for the AddOn.
     *
     * @param pUid The unique identifier to set.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Gets the date when the AddOn was created.
     *
     * @return The creation date.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the date when the AddOn was created.
     *
     * @param pCreated The creation date to set.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Gets the date when the AddOn was last updated.
     *
     * @return The last updated date.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the date when the AddOn was last updated.
     *
     * @param pUpdated The last updated date to set.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * This method compares two AddOn objects for equality.
     * @param other The other object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof AddOn)) {
            return false;
        }

        AddOn otherAddOn = (AddOn) other;

        return Objects.equals(this.uid, otherAddOn.uid);
    }

    /**
     * This method returns the hash code for the AddOn object.
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
