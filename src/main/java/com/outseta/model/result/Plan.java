package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a plan.
 */
public class Plan implements BaseResult {

    /**
     * This class implements the builder pattern for the Plan
     * class.
     */
    public static class Builder {

        /**
         * The plan object that is being built.
         */
        private Plan plan;

        /**
         * The constructor creates a new builder object.
         */
        public Builder() {
            plan = new Plan();
        }

        /**
         * This method is used to set the plan name.
         *
         * @param name The plan name.
         * @return The builder.
         */
        public Builder name(final String name) {
            plan.name = name;
            return this;
        }

        /**
         * This method is used to set the plan description.
         *
         * @param description The plan description.
         * @return The builder.
         */
        public Builder description(final String description) {
            plan.description = description;
            return this;
        }

        /**
         * This method is used to set the plan family.
         *
         * @param planFamily The plan family.
         * @return The builder.
         */
        public Builder planFamily(final PlanFamily planFamily) {
            plan.planFamily = planFamily;
            return this;
        }

        /**
         * This method is used to set the account registration mode.
         *
         * @param accountRegistrationMode The account registration mode.
         * @return The builder.
         */
        public Builder accountRegistrationMode(
                final Integer accountRegistrationMode) {
            plan.accountRegistrationMode = accountRegistrationMode;
            return this;
        }

        /**
         * This method is used to set whether the quantity is editable.
         *
         * @param isQuantityEditable Whether the quantity is editable.
         * @return The builder.
         */
        public Builder quantityEditable(final Boolean isQuantityEditable) {
            plan.isQuantityEditable = isQuantityEditable;
            return this;
        }

        /**
         * This method is used to set the minimum quantity.
         *
         * @param minimumQuantity The minimum quantity.
         * @return The builder.
         */
        public Builder minimumQuantity(final Integer minimumQuantity) {
            plan.minimumQuantity = minimumQuantity;
            return this;
        }

        /**
         * This method is used to set the maximum people.
         *
         * @param maximumPeople The maximum people.
         * @return The builder.
         */
        public Builder maximumPeople(final Integer maximumPeople) {
            plan.maximumPeople = maximumPeople;
            return this;
        }

        /**
         * This method is used to set the monthly rate.
         *
         * @param monthlyRate The monthly rate.
         * @return The builder.
         */
        public Builder monthlyRate(final Double monthlyRate) {
            plan.monthlyRate = monthlyRate;
            return this;
        }

        /**
         * This method is used to set the annual rate.
         *
         * @param annualRate The annual rate.
         * @return The builder.
         */
        public Builder annualRate(final Double annualRate) {
            plan.annualRate = annualRate;
            return this;
        }

        /**
         * This method is used to set the quarterly rate.
         *
         * @param quarterlyRate The quarterly rate.
         * @return The builder.
         */
        public Builder quarterlyRate(final Double quarterlyRate) {
            plan.quarterlyRate = quarterlyRate;
            return this;
        }

        /**
         * This method is used to set the one time rate.
         *
         * @param oneTimeRate The one time rate.
         * @return The builder.
         */
        public Builder oneTimeRate(final Double oneTimeRate) {
            plan.oneTimeRate = oneTimeRate;
            return this;
        }

        /**
         * This method is used to set the setup fee.
         *
         * @param setupFee The setup fee.
         * @return The builder.
         */
        public Builder setupFee(final Double setupFee) {
            plan.setupFee = setupFee;
            return this;
        }

        /**
         * This method is used to set whether the plan is taxable.
         *
         * @param isTaxable Whether the plan is taxable.
         * @return The builder.
         */
        public Builder taxable(final Boolean isTaxable) {
            plan.isTaxable = isTaxable;
            return this;
        }

        /**
         * This method is used to set whether the plan is active.
         *
         * @param isActive Whether the plan is active.
         * @return The builder.
         */
        public Builder active(final Boolean isActive) {
            plan.isActive = isActive;
            return this;
        }

        /**
         * This method is used to set whether the plan is a per-user plan.
         *
         * @param isPerUser Whether the plan is a per-user plan.
         * @return The builder.
         */
        public Builder perUser(final Boolean isPerUser) {
            plan.isPerUser = isPerUser;
            return this;
        }

        /**
         * This method is used to set whether the plan requires payment
         * information.
         *
         * @param requirePaymentInformation Whether the plan requires payment
         *                                  information.
         * @return The builder.
         */
        public Builder requirePaymentInformation(
                final Boolean requirePaymentInformation) {
            plan.requirePaymentInformation = requirePaymentInformation;
            return this;
        }

        /**
         * This method is used to set the trial period days.
         *
         * @param trialPeriodDays The trial period days.
         * @return The builder.
         */
        public Builder trialPeriodDays(final Integer trialPeriodDays) {
            plan.trialPeriodDays = trialPeriodDays;
            return this;
        }

        /**
         * This method is used to set the trial until date.
         *
         * @param trialUntilDate The trial until date.
         * @return The builder.
         */
        public Builder trialUntilDate(final Date trialUntilDate) {
            plan.trialUntilDate = trialUntilDate;
            return this;
        }

        /**
         * This method is used to set the number of months after which the plan
         * expires.
         *
         * @param expiresAfterMonths The number of months after which the plan
         *                           expires.
         * @return The builder.
         */
        public Builder expiresAfterMonths(final Integer expiresAfterMonths) {
            plan.expiresAfterMonths = expiresAfterMonths;
            return this;
        }

        /**
         * This method is used to set the expiration date.
         *
         * @param expirationDate The expiration date.
         * @return The builder.
         */
        public Builder expirationDate(final Date expirationDate) {
            plan.expirationDate = expirationDate;
            return this;
        }

        /**
         * This method is used to set the path after login.
         *
         * @param postLoginPath The path after login.
         * @return The builder.
         */
        public Builder postLoginPath(final String postLoginPath) {
            plan.postLoginPath = postLoginPath;
            return this;
        }

        /**
         * This method is used to set the string tax code id.
         *
         * @param stripeTaxCodeId The string tax code id.
         * @return The builder.
         */
        public Builder stripeTaxCodeId(final String stripeTaxCodeId) {
            plan.stripeTaxCodeId = stripeTaxCodeId;
            return this;
        }

        /**
         * This method is used to set the unit of measure.
         *
         * @param unitOfMeasure The unit of measure.
         * @return The builder.
         */
        public Builder unitOfMeasure(final String unitOfMeasure) {
            plan.unitOfMeasure = unitOfMeasure;
            return this;
        }

        /**
         * This method is used to set the plan add-ons.
         *
         * @param planAddOns The plan add-ons.
         * @return The builder.
         */
        public Builder planAddOns(final List<PlanAddOn> planAddOns) {
            plan.planAddOns = planAddOns;
            return this;
        }

        /**
         * This method is used to set the content groups.
         *
         * @param contentGroups The content groups.
         * @return The builder.
         */
        public Builder contentGroups(final List<String> contentGroups) {
            plan.contentGroups = contentGroups;
            return this;
        }

        /**
         * This method is used to set the number of subscriptions.
         *
         * @param numberOfSubscriptions The number of subscriptions.
         * @return The builder.
         */
        public Builder numberOfSubscriptions(
                final Integer numberOfSubscriptions) {
            plan.numberOfSubscriptions = numberOfSubscriptions;
            return this;
        }

        /**
         * This method is used to set the activity event data.
         *
         * @param activityEventData The activity event data.
         * @return The builder.
         */
        public Builder activityEventData(final String activityEventData) {
            plan.activityEventData = activityEventData;
            return this;
        }

        /**
         * This method is used to set the unique identifier.
         *
         * @param uid The unique identifier.
         * @return The builder.
         */
        public Builder uid(final String uid) {
            plan.uid = uid;
            return this;
        }

        /**
         * This method is used to set the created date.
         *
         * @param created The created date.
         * @return The builder.
         */
        public Builder created(final Date created) {
            plan.created = created;
            return this;
        }

        /**
         * This method is used to set the updated date.
         *
         * @param updated The updated date.
         * @return The builder.
         */
        public Builder updated(final Date updated) {
            plan.updated = updated;
            return this;
        }

        /**
         * This method is used to build the plan object.
         *
         * @return The plan object.
         */
        public Plan build() {
            return plan;
        }
    }

    /**
     * The name of the plan.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * The description of the plan.
     */
    @JsonProperty("Description")
    private String description;

    /**
     * The Family to which this plan belongs.
     */
    @JsonProperty("PlanFamily")
    private PlanFamily planFamily;

    /**
     * The account registration mode.
     */
    @JsonProperty("AccountRegistrationMode")
    private Integer accountRegistrationMode;

    /**
     * Whether the quantity is editable or not.
     */
    @JsonProperty("IsQuantityEditable")
    private Boolean isQuantityEditable;

    /**
     * The minimum quantity.
     */
    @JsonProperty("MinimumQuantity")
    private Integer minimumQuantity;

    /**
     * The maximum allowed people.
     */
    @JsonProperty("MaximumPeople")
    private Integer maximumPeople;

    /**
     * The monthly rate.
     */
    @JsonProperty("MonthlyRate")
    private Double monthlyRate;

    /**
     * The annual rate.
     */
    @JsonProperty("AnnualRate")
    private Double annualRate;

    /**
     * The quarterly rate.
     */
    @JsonProperty("QuarterlyRate")
    private Double quarterlyRate;

    /**
     * The one time rate.
     */
    @JsonProperty("OneTimeRate")
    private Double oneTimeRate;

    /**
     * The setup fee.
     */
    @JsonProperty("SetupFee")
    private Double setupFee;

    /**
     * Whether the plan is taxable.
     */
    @JsonProperty("IsTaxable")
    private Boolean isTaxable;

    /**
     * Whether the plan is active.
     */
    @JsonProperty("IsActive")
    private Boolean isActive;

    /**
     * Whether the plan is a per-user plan.
     */
    @JsonProperty("IsPerUser")
    private Boolean isPerUser;

    /**
     * Whether the plan requires payment info.
     */
    @JsonProperty("RequirePaymentInformation")
    private Boolean requirePaymentInformation;

    /**
     * The trial period days.
     */
    @JsonProperty("TrialPeriodDays")
    private Integer trialPeriodDays;

    /**
     * The trial until date.
     */
    @JsonProperty("TrialUntilDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date trialUntilDate;

    /**
     * The number of months after which the plan expires.
     */
    @JsonProperty("ExpiresAfterMonths")
    private Integer expiresAfterMonths;

    /**
     * The expiration date.
     */
    @JsonProperty("ExpirationDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date expirationDate;

    /**
     * The path after login.
     */
    @JsonProperty("PostLoginPath")
    private String postLoginPath;

    /**
     * The string tax code id.
     */
    @JsonProperty("StripeTaxCodeId")
    private String stripeTaxCodeId;

    /**
     * The unit of measure.
     */
    @JsonProperty("UnitOfMeasure")
    private String unitOfMeasure;

    /**
     * The plan add-ons.
     */
    @JsonProperty("PlanAddOns")
    private List<PlanAddOn> planAddOns;

    /**
     * The content groups.
     */
    @JsonProperty("ContentGroups")
    private List<String> contentGroups;

    /**
     * The number of subscriptions.
     */
    @JsonProperty("NumberOfSubscriptions")
    private Integer numberOfSubscriptions;

    /**
     * The activity event data.
     */
    @JsonProperty("ActivityEventData")
    private String activityEventData;

    /**
     * The unique identifier of the plan.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * The date the plan was created.
     */
    @JsonProperty("Created")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * The date the plan was last updated.
     */
    @JsonProperty("Updated")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updated;

    /**
     * Default constructor for the creation of a Plan object.
     */
    public Plan() {
    }

    /**
     * This method is used to get a new builder for the plan.
     *
     * @return The builder for the plan.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * This method is used to get the name of the plan.
     *
     * @return The name of the plan.
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used to set the name of the plan.
     *
     * @param pName The name of the plan.
     */
    public void setName(final String pName) {
        this.name = pName;
    }

    /**
     * This method is used to get the description of the plan.
     *
     * @return The description of the plan.
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method is used to set the description of the plan.
     *
     * @param pDescription The description of the plan.
     */
    public void setDescription(final String pDescription) {
        this.description = pDescription;
    }

    /**
     * This method is used to get the plan family.
     *
     * @return The plan family.
     */
    public PlanFamily getPlanFamily() {
        return planFamily;
    }

    /**
     * This method is used to set the plan family.
     *
     * @param pPlanFamily The plan family.
     */
    public void setPlanFamily(final PlanFamily pPlanFamily) {
        this.planFamily = pPlanFamily;
    }

    /**
     * This method is used to get the account registration mode.
     *
     * @return The account registration mode.
     */
    public Integer getAccountRegistrationMode() {
        return accountRegistrationMode;
    }

    /**
     * This method is used to set the account registration mode.
     *
     * @param pAccountRegistrationMode The account registration mode.
     */
    public void setAccountRegistrationMode(
            final Integer pAccountRegistrationMode) {
        this.accountRegistrationMode = pAccountRegistrationMode;
    }

    /**
     * This method is used to get whether the quantity is editable.
     *
     * @return Whether the quantity is editable.
     */
    public Boolean isQuantityEditable() {
        return isQuantityEditable;
    }

    /**
     * This method is used to set whether the quantity is editable.
     *
     * @param pQuantityEditable Whether the quantity is editable.
     */
    public void setQuantityEditable(final Boolean pQuantityEditable) {
        isQuantityEditable = pQuantityEditable;
    }

    /**
     * This method is used to get the minimum quantity.
     *
     * @return The minimum quantity.
     */
    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    /**
     * This method is used to set the minimum quantity.
     *
     * @param pMinimumQuantity The minimum quantity.
     */
    public void setMinimumQuantity(final Integer pMinimumQuantity) {
        this.minimumQuantity = pMinimumQuantity;
    }

    /**
     * This method is used to get the maximum people.
     *
     * @return The maximum people.
     */
    public Integer getMaximumPeople() {
        return maximumPeople;
    }

    /**
     * This method is used to set the maximum people.
     *
     * @param pMaximumPeople The maximum people.
     */
    public void setMaximumPeople(final Integer pMaximumPeople) {
        this.maximumPeople = pMaximumPeople;
    }

    /**
     * This method is used to get the monthly rate.
     *
     * @return The monthly rate.
     */
    public Double getMonthlyRate() {
        return monthlyRate;
    }

    /**
     * This method is used to set the monthly rate.
     *
     * @param pMonthlyRate The monthly rate.
     */
    public void setMonthlyRate(final Double pMonthlyRate) {
        this.monthlyRate = pMonthlyRate;
    }

    /**
     * This method is used to get the annual rate.
     *
     * @return The annual rate.
     */
    public Double getAnnualRate() {
        return annualRate;
    }

    /**
     * This method is used to set the annual rate.
     *
     * @param pAnnualRate The annual rate.
     */
    public void setAnnualRate(final Double pAnnualRate) {
        this.annualRate = pAnnualRate;
    }

    /**
     * This method is used to get the quarterly rate.
     *
     * @return The quarterly rate.
     */
    public Double getQuarterlyRate() {
        return quarterlyRate;
    }

    /**
     * This method is used to set the quarterly rate.
     *
     * @param pQuarterlyRate The quarterly rate.
     */
    public void setQuarterlyRate(final Double pQuarterlyRate) {
        this.quarterlyRate = pQuarterlyRate;
    }

    /**
     * This method is used to get the one time rate.
     *
     * @return The one time rate.
     */
    public Double getOneTimeRate() {
        return oneTimeRate;
    }

    /**
     * This method is used to set the one time rate.
     *
     * @param pOneTimeRate The one time rate.
     */
    public void setOneTimeRate(final Double pOneTimeRate) {
        this.oneTimeRate = pOneTimeRate;
    }

    /**
     * This method is used to get the setup fee.
     *
     * @return The setup fee.
     */
    public Double getSetupFee() {
        return setupFee;
    }

    /**
     * This method is used to set the setup fee.
     *
     * @param pSetupFee The setup fee.
     */
    public void setSetupFee(final Double pSetupFee) {
        this.setupFee = pSetupFee;
    }

    /**
     * This method is used to get whether the plan is taxable.
     *
     * @return Whether the plan is taxable.
     */
    public Boolean isTaxable() {
        return isTaxable;
    }

    /**
     * This method is used to set whether the plan is taxable.
     *
     * @param pTaxable Whether the plan is taxable.
     */
    public void setTaxable(final Boolean pTaxable) {
        isTaxable = pTaxable;
    }

    /**
     * This method is used to get whether the plan is active.
     *
     * @return Whether the plan is active.
     */
    public Boolean isActive() {
        return isActive;
    }

    /**
     * This method is used to set whether the plan is active.
     *
     * @param pActive Whether the plan is active.
     */
    public void setActive(final Boolean pActive) {
        isActive = pActive;
    }

    /**
     * This method is used to get whether the plan is a per-user plan.
     *
     * @return Whether the plan is a per-user plan.
     */
    public Boolean isPerUser() {
        return isPerUser;
    }

    /**
     * This method is used to set whether the plan is a per-user plan.
     *
     * @param pPerUser Whether the plan is a per-user plan.
     */
    public void setPerUser(final Boolean pPerUser) {
        isPerUser = pPerUser;
    }

    /**
     * This method is used to get whether the plan requires payment
     * information.
     *
     * @return Whether the plan requires payment information.
     */
    public Boolean isRequirePaymentInformation() {
        return requirePaymentInformation;
    }

    /**
     * This method is used to set whether the plan requires payment
     * information.
     *
     * @param pRequirePaymentInformation Whether the plan requires payment
     *                                   information.
     */
    public void setRequirePaymentInformation(
            final Boolean pRequirePaymentInformation) {
        this.requirePaymentInformation = pRequirePaymentInformation;
    }

    /**
     * This method is used to get the trial period days.
     *
     * @return The trial period days.
     */
    public Integer getTrialPeriodDays() {
        return trialPeriodDays;
    }

    /**
     * This method is used to set the trial period days.
     *
     * @param pTrialPeriodDays The trial period days.
     */
    public void setTrialPeriodDays(final Integer pTrialPeriodDays) {
        this.trialPeriodDays = pTrialPeriodDays;
    }

    /**
     * This method is used to get the trial until date.
     *
     * @return The trial until date.
     */
    public Date getTrialUntilDate() {
        return trialUntilDate;
    }

    /**
     * This method is used to set the trial until date.
     *
     * @param pTrialUntilDate The trial until date.
     */
    public void setTrialUntilDate(final Date pTrialUntilDate) {
        this.trialUntilDate = pTrialUntilDate;
    }

    /**
     * This method is used to get the number of months after which the plan
     * expires.
     *
     * @return The number of months after which the plan expires.
     */
    public Integer getExpiresAfterMonths() {
        return expiresAfterMonths;
    }

    /**
     * This method is used to set the number of months after which the plan
     * expires.
     *
     * @param pExpiresAfterMonths The number of months after which the plan
     *                            expires.
     */
    public void setExpiresAfterMonths(final Integer pExpiresAfterMonths) {
        this.expiresAfterMonths = pExpiresAfterMonths;
    }

    /**
     * This method is used to get the expiration date.
     *
     * @return The expiration date.
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * This method is used to set the expiration date.
     *
     * @param pExpirationDate The expiration date.
     */
    public void setExpirationDate(final Date pExpirationDate) {
        this.expirationDate = pExpirationDate;
    }

    /**
     * This method is used to get the path after login.
     *
     * @return The path after login.
     */
    public String getPostLoginPath() {
        return postLoginPath;
    }

    /**
     * This method is used to set the path after login.
     *
     * @param pPostLoginPath The path after login.
     */
    public void setPostLoginPath(final String pPostLoginPath) {
        this.postLoginPath = pPostLoginPath;
    }

    /**
     * This method is used to get the string tax code id.
     *
     * @return The string tax code id.
     */
    public String getStripeTaxCodeId() {
        return stripeTaxCodeId;
    }

    /**
     * This method is used to set the string tax code id.
     *
     * @param pStripeTaxCodeId The string tax code id.
     */
    public void setStripeTaxCodeId(final String pStripeTaxCodeId) {
        this.stripeTaxCodeId = pStripeTaxCodeId;
    }

    /**
     * This method is used to get the unit of measure.
     *
     * @return The unit of measure.
     */
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * This method is used to set the unit of measure.
     *
     * @param pUnitOfMeasure The unit of measure.
     */
    public void setUnitOfMeasure(final String pUnitOfMeasure) {
        this.unitOfMeasure = pUnitOfMeasure;
    }

    /**
     * This method is used to get the plan add-ons.
     *
     * @return The plan add-ons.
     */
    public List<PlanAddOn> getPlanAddOns() {
        return planAddOns;
    }

    /**
     * This method is used to set the plan add-ons.
     *
     * @param pPlanAddOns The plan add-ons.
     */
    public void setPlanAddOns(final List<PlanAddOn> pPlanAddOns) {
        this.planAddOns = pPlanAddOns;
    }

    /**
     * This method is used to get the content groups.
     *
     * @return The content groups.
     */
    public List<String> getContentGroups() {
        return contentGroups;
    }

    /**
     * This method is used to set the content groups.
     *
     * @param pContentGroups The content groups.
     */
    public void setContentGroups(final List<String> pContentGroups) {
        this.contentGroups = pContentGroups;
    }

    /**
     * This method is used to get the number of subscriptions.
     *
     * @return The number of subscriptions.
     */
    public Integer getNumberOfSubscriptions() {
        return numberOfSubscriptions;
    }

    /**
     * This method is used to set the number of subscriptions.
     *
     * @param pNumberOfSubscriptions The number of subscriptions.
     */
    public void setNumberOfSubscriptions(final Integer pNumberOfSubscriptions) {
        this.numberOfSubscriptions = pNumberOfSubscriptions;
    }

    /**
     * This method is used to get the activity event data.
     *
     * @return The activity event data.
     */
    public String getActivityEventData() {
        return activityEventData;
    }

    /**
     * This method is used to set the activity event data.
     *
     * @param pActivityEventData The activity event data.
     */
    public void setActivityEventData(final String pActivityEventData) {
        this.activityEventData = pActivityEventData;
    }

    /**
     * This method is used to get the unique identifier.
     *
     * @return The unique identifier.
     */
    public String getUid() {
        return uid;
    }

    /**
     * This method is used to set the unique identifier.
     *
     * @param pUid The unique identifier.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * This method is used to get the created date.
     *
     * @return The created date.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method is used to set the created date.
     *
     * @param pCreated The created date.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * This method is used to get the updated date.
     *
     * @return The updated date.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method is used to set the updated date.
     *
     * @param pUpdated The updated date.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * This method overrides the equals method.
     *
     * @param other The other object.
     * @return Whether the two objects are equal.
     */
    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Plan)) {
            return false;
        }

        Plan otherPlan = (Plan) other;

        return Objects.equals(this.uid, otherPlan.uid);
    }

    /**
     * Computes and returns the hash of the object.
     * @return The hash of the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.uid);
    }
}
