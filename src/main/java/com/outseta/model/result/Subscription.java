package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * This class is used to represent a Subscription object from the API.
 */
public class Subscription implements BaseResult, BaseInput {

    /**
     * This class is used to build a Subscription instance.
     */
    public static class Builder {

        /**
         * The Subscription instance to be built.
         */
        private final Subscription subscription;

        /**
         * Constructs a new SubscriptionBuilder.
         */
        public Builder() {
            this.subscription = new Subscription();
        }

        /**
         * Set the billing renewal term.
         *
         * @param billingRenewalTerm The billing renewal term.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder billingRenewalTerm(final Integer billingRenewalTerm) {
            subscription.setBillingRenewalTerm(billingRenewalTerm);
            return this;
        }

        /**
         * Set the associated account for the subscription.
         *
         * @param account The associated account for the subscription.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder account(final Account account) {
            subscription.setAccount(account);
            return this;
        }

        /**
         * Set the plan details for the subscription.
         *
         * @param plan The plan details for the subscription.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder plan(final Plan plan) {
            subscription.setPlan(plan);
            return this;
        }

        /**
         * Set the quantity of the subscription.
         *
         * @param quantity The quantity of the subscription.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder quantity(final Integer quantity) {
            subscription.setQuantity(quantity);
            return this;
        }

        /**
         * Set the start date of the subscription.
         *
         * @param startDate The start date of the subscription.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder startDate(final Date startDate) {
            subscription.setStartDate(startDate);
            return this;
        }

        /**
         * Set the end date of the subscription.
         *
         * @param endDate The end date of the subscription.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder endDate(final Date endDate) {
            subscription.setEndDate(endDate);
            return this;
        }

        /**
         * Set the renewal date of the subscription.
         *
         * @param renewalDate The renewal date of the subscription.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder renewalDate(final Date renewalDate) {
            subscription.setRenewalDate(renewalDate);
            return this;
        }

        /**
         * Set the new required quantity for the subscription.
         *
         * @param newRequiredQuantity The new required quantity for the
         *                            subscription.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder newRequiredQuantity(final Integer newRequiredQuantity) {
            subscription.setNewRequiredQuantity(newRequiredQuantity);
            return this;
        }

        /**
         * Set whether a plan upgrade is required.
         *
         * @param isPlanUpgradeRequired True if a plan upgrade is required,
         *                              otherwise false.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder planUpgradeRequired(
                final Boolean isPlanUpgradeRequired) {
            subscription.setPlanUpgradeRequired(isPlanUpgradeRequired);
            return this;
        }

        /**
         * Set the message for plan upgrade requirement.
         *
         * @param planUpgradeRequiredMessage The message for plan upgrade
         *                                   requirement.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder planUpgradeRequiredMessage(
                final String planUpgradeRequiredMessage) {
            subscription.setPlanUpgradeRequiredMessage(
                    planUpgradeRequiredMessage);
            return this;
        }

        /**
         * Set the list of add-ons associated with the subscription.
         *
         * @param subscriptionAddOns The list of add-ons.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder subscriptionAddOns(
                final List<SubscriptionAddOn> subscriptionAddOns) {
            subscription.setSubscriptionAddOns(subscriptionAddOns);
            return this;
        }

        /**
         * Set the unique identifier for the subscription.
         *
         * @param uid The unique identifier for the subscription.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder uid(final String uid) {
            subscription.setUid(uid);
            return this;
        }

        /**
         * Set the creation timestamp for the subscription.
         *
         * @param created The creation timestamp for the subscription.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder created(final Date created) {
            subscription.setCreated(created);
            return this;
        }

        /**
         * Set the last update timestamp for the subscription.
         *
         * @param updated The last update timestamp for the subscription.
         * @return The SubscriptionBuilder instance for method chaining.
         */
        public Builder updated(final Date updated) {
            subscription.setUpdated(updated);
            return this;
        }

        /**
         * Builds the {@link Subscription} instance.
         *
         * @return The constructed Subscription instance.
         */
        public Subscription build() {
            return subscription;
        }
    }

    /**
     * The renewal term for billing.
     */
    @JsonProperty("BillingRenewalTerm")
    private Integer billingRenewalTerm;

    /**
     * The associated account for the subscription.
     */
    @JsonProperty("Account")
    private Account account;

    /**
     * The plan details for the subscription.
     */
    @JsonProperty("Plan")
    private Plan plan;

    /**
     * The quantity of the subscription.
     */
    @JsonProperty("Quantity")
    private Integer quantity;

    /**
     * The start date of the subscription.
     */
    @JsonProperty("StartDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date startDate;

    /**
     * The end date of the subscription.
     */
    @JsonProperty("EndDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date endDate;

    /**
     * The renewal date of the subscription.
     */
    @JsonProperty("RenewalDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date renewalDate;

    /**
     * The new required quantity for the subscription.
     */
    @JsonProperty("NewRequiredQuantity")
    private Integer newRequiredQuantity;

    /**
     * Flag indicating whether a plan upgrade is required.
     */
    @JsonProperty("IsPlanUpgradeRequired")
    private Boolean isPlanUpgradeRequired;

    /**
     * Message for plan upgrade requirement.
     */
    @JsonProperty("PlanUpgradeRequiredMessage")
    private String planUpgradeRequiredMessage;

    /**
     * List of add-ons associated with the subscription.
     */
    @JsonProperty("SubscriptionAddOns")
    private List<SubscriptionAddOn> subscriptionAddOns;

    /**
     * The unique identifier for the subscription.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * Creation timestamp for the subscription.
     */
    @JsonProperty("Created")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * Last update timestamp for the subscription.
     */
    @JsonProperty("Updated")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updated;

    /**
     * This method is used to create a new Builder.
     *
     * @return The Builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Default constructor.
     */
    public Subscription() {
    }

    /**
     * Gets the billing renewal term.
     *
     * @return The billing renewal term.
     */
    public Integer getBillingRenewalTerm() {
        return billingRenewalTerm;
    }

    /**
     * Sets the billing renewal term.
     *
     * @param pBillingRenewalTerm The billing renewal term.
     */
    public void setBillingRenewalTerm(final Integer pBillingRenewalTerm) {
        this.billingRenewalTerm = pBillingRenewalTerm;
    }

    /**
     * Gets the associated account for the subscription.
     *
     * @return The account for the subscription.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets the associated account for the subscription.
     *
     * @param pAccount The account for the subscription.
     */
    public void setAccount(final Account pAccount) {
        this.account = pAccount;
    }

    /**
     * Gets the plan details for the subscription.
     *
     * @return The plan for the subscription.
     */
    public Plan getPlan() {
        return plan;
    }

    /**
     * Sets the plan details for the subscription.
     *
     * @param pPlan The plan for the subscription.
     */
    public void setPlan(final Plan pPlan) {
        this.plan = pPlan;
    }

    /**
     * Gets the quantity of the subscription.
     *
     * @return The quantity of the subscription.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the subscription.
     *
     * @param pQuantity The quantity of the subscription.
     */
    public void setQuantity(final Integer pQuantity) {
        this.quantity = pQuantity;
    }

    /**
     * Gets the start date of the subscription.
     *
     * @return The start date of the subscription.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the subscription.
     *
     * @param pStartDate The start date of the subscription.
     */
    public void setStartDate(final Date pStartDate) {
        this.startDate = pStartDate;
    }

    /**
     * Gets the end date of the subscription.
     *
     * @return The end date of the subscription.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of the subscription.
     *
     * @param pEndDate The end date of the subscription.
     */
    public void setEndDate(final Date pEndDate) {
        this.endDate = pEndDate;
    }

    /**
     * Gets the renewal date of the subscription.
     *
     * @return The renewal date of the subscription.
     */
    public Date getRenewalDate() {
        return renewalDate;
    }

    /**
     * Sets the renewal date of the subscription.
     *
     * @param pRenewalDate The renewal date of the subscription.
     */
    public void setRenewalDate(final Date pRenewalDate) {
        this.renewalDate = pRenewalDate;
    }

    /**
     * Gets the new required quantity for the subscription.
     *
     * @return The new required quantity for the subscription.
     */
    public Integer getNewRequiredQuantity() {
        return newRequiredQuantity;
    }

    /**
     * Sets the new required quantity for the subscription.
     *
     * @param pNewRequiredQuantity The new required quantity for the
     *                             subscription.
     */
    public void setNewRequiredQuantity(final Integer pNewRequiredQuantity) {
        this.newRequiredQuantity = pNewRequiredQuantity;
    }

    /**
     * Checks if a plan upgrade is required.
     *
     * @return True if a plan upgrade is required, otherwise false.
     */
    public Boolean isPlanUpgradeRequired() {
        return isPlanUpgradeRequired;
    }

    /**
     * Sets whether a plan upgrade is required.
     *
     * @param pPlanUpgradeRequired True if a plan upgrade is required,
     *                             otherwise false.
     */
    public void setPlanUpgradeRequired(final Boolean pPlanUpgradeRequired) {
        this.isPlanUpgradeRequired = pPlanUpgradeRequired;
    }

    /**
     * Gets the message for plan upgrade requirement.
     *
     * @return The message for plan upgrade requirement.
     */
    public String getPlanUpgradeRequiredMessage() {
        return planUpgradeRequiredMessage;
    }

    /**
     * Sets the message for plan upgrade requirement.
     *
     * @param pPlanUpgradeRequiredMessage The message for plan upgrade
     *                                    requirement.
     */
    public void setPlanUpgradeRequiredMessage(
            final String pPlanUpgradeRequiredMessage) {
        this.planUpgradeRequiredMessage = pPlanUpgradeRequiredMessage;
    }

    /**
     * Gets the list of add-ons associated with the subscription.
     *
     * @return The list of add-ons.
     */
    public List<SubscriptionAddOn> getSubscriptionAddOns() {
        return subscriptionAddOns;
    }

    /**
     * Sets the list of add-ons associated with the subscription.
     *
     * @param pSubscriptionAddOns The list of add-ons.
     */
    public void setSubscriptionAddOns(
            final List<SubscriptionAddOn> pSubscriptionAddOns) {
        this.subscriptionAddOns = pSubscriptionAddOns;
    }

    /**
     * Gets the unique identifier for the subscription.
     *
     * @return The unique identifier for the subscription.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the unique identifier for the subscription.
     *
     * @param pUid The unique identifier for the subscription.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Gets the creation timestamp for the subscription.
     *
     * @return The creation timestamp for the subscription.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the creation timestamp for the subscription.
     *
     * @param pCreated The creation timestamp for the subscription.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Gets the last update timestamp for the subscription.
     *
     * @return The last update timestamp for the subscription.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the last update timestamp for the subscription.
     *
     * @param pUpdated The last update timestamp for the subscription.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * This method is used to compare two Subscription objects.
     *
     * @param other The other Subscription object.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Subscription)) {
            return false;
        }

        Subscription subscription = (Subscription) other;

        return Objects.equals(this.uid, subscription.uid);
    }

    /**
     * This method is used to get the hash code of the Subscription object.
     *
     * @return The hash code of the Subscription object.
     */
    public int hashCode() {
        return Objects.hash(uid);
    }
}
