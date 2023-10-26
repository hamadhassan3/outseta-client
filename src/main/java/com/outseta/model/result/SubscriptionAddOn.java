package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.constant.BillingRenewalTerm;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a subscription add-on.
 */
public class SubscriptionAddOn implements BaseInput, BaseResult {

    /**
     * A builder for the SubscriptionAddOn class.
     */
    public static class Builder {

        /**
         * The SubscriptionAddOn object to be built.
         */
        private SubscriptionAddOn subscriptionAddOn;

        /**
         * The default constructor for Builder.
         */
        public Builder() {
            this.subscriptionAddOn = new SubscriptionAddOn();
        }

        /**
         * Set the billingRenewalTerm for the add-on.
         *
         * @param billingRenewalTerm The billing renewal term.
         * @return The builder instance.
         */
        public Builder billingRenewalTerm(final Integer billingRenewalTerm) {
            subscriptionAddOn.setBillingRenewalTerm(billingRenewalTerm);
            return this;
        }

        /**
         * Set the billingRenewalTerm for the add-on.
         *
         * @param billingRenewalTerm The billing renewal term.
         * @return The builder instance.
         */
        public Builder billingRenewalTerm(
                final BillingRenewalTerm billingRenewalTerm) {
            subscriptionAddOn.setBillingRenewalTerm(
                    billingRenewalTerm.getValue());
            return this;
        }

        /**
         * Set the subscription for the add-on.
         *
         * @param subscription The subscription.
         * @return The builder instance.
         */
        public Builder subscription(final Subscription subscription) {
            subscriptionAddOn.setSubscription(subscription);
            return this;
        }

        /**
         * Set the add-on for the add-on.
         *
         * @param addOn The add-on.
         * @return The builder instance.
         */
        public Builder addOn(final AddOn addOn) {
            subscriptionAddOn.setAddOn(addOn);
            return this;
        }

        /**
         * Set the quantity for the add-on.
         *
         * @param quantity The quantity.
         * @return The builder instance.
         */
        public Builder quantity(final Integer quantity) {
            subscriptionAddOn.setQuantity(quantity);
            return this;
        }

        /**
         * Set the startDate for the add-on.
         *
         * @param startDate The start date.
         * @return The builder instance.
         */
        public Builder startDate(final Date startDate) {
            subscriptionAddOn.setStartDate(startDate);
            return this;
        }

        /**
         * Set the endDate for the add-on.
         *
         * @param endDate The end date.
         * @return The builder instance.
         */
        public Builder endDate(final Date endDate) {
            subscriptionAddOn.setEndDate(endDate);
            return this;
        }

        /**
         * Set the renewalDate for the add-on.
         *
         * @param renewalDate The renewal date.
         * @return The builder instance.
         */
        public Builder renewalDate(final Date renewalDate) {
            subscriptionAddOn.setRenewalDate(renewalDate);
            return this;
        }

        /**
         * Set the newRequiredQuantity for the add-on.
         *
         * @param newRequiredQuantity The new required quantity.
         * @return The builder instance.
         */
        public Builder newRequiredQuantity(final Integer newRequiredQuantity) {
            subscriptionAddOn.setNewRequiredQuantity(newRequiredQuantity);
            return this;
        }

        /**
         * Set the uid for the add-on.
         *
         * @param uid The uid.
         * @return The builder instance.
         */
        public Builder uid(final String uid) {
            subscriptionAddOn.setUid(uid);
            return this;
        }

        /**
         * Set the created date for the add-on.
         *
         * @param created The created date.
         * @return The builder instance.
         */
        public Builder created(final Date created) {
            subscriptionAddOn.setCreated(created);
            return this;
        }

        /**
         * Set the updated date for the add-on.
         *
         * @param updated The updated date.
         * @return The builder instance.
         */
        public Builder updated(final Date updated) {
            subscriptionAddOn.setUpdated(updated);
            return this;
        }

        /**
         * Builds the object and returns it.
         * @return The built object.
         */
        public SubscriptionAddOn build() {
            return subscriptionAddOn;
        }
    }

    /**
     * The billing renewal term.
     */
    @JsonProperty("BillingRenewalTerm")
    private Integer billingRenewalTerm;

    /**
     * The subscription.
     */
    @JsonProperty("Subscription")
    private Subscription subscription;

    /**
     * The add-on.
     */
    @JsonProperty("AddOn")
    private AddOn addOn;

    /**
     * The quantity.
     */
    @JsonProperty("Quantity")
    private Integer quantity;

    /**
     * The starting date for the add-on.
     */
    @JsonProperty("StartDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date startDate;

    /**
     * The end date for the add-on.
     */
    @JsonProperty("EndDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date endDate;

    /**
     * The renewal date for the add-on.
     */
    @JsonProperty("RenewalDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date renewalDate;

    /**
     * The new required quantity.
     */
    @JsonProperty("NewRequiredQuantity")
    private Integer newRequiredQuantity;

    /**
     * The uid.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * The created date.
     */
    @JsonProperty("Created")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * The updated date.
     */
    @JsonProperty("Updated")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updated;

    /**
     * Returns a builder that can be used to create a SubscriptionAddOn object.
     * @return The builder instance.
     */
    public static Builder builder() {
        return new Builder();
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
     * Gets the subscription.
     *
     * @return The subscription.
     */
    public Subscription getSubscription() {
        return subscription;
    }

    /**
     * Sets the subscription.
     *
     * @param pSubscription The subscription.
     */
    public void setSubscription(final Subscription pSubscription) {
        this.subscription = pSubscription;
    }

    /**
     * Gets the add-on.
     *
     * @return The add-on.
     */
    public AddOn getAddOn() {
        return addOn;
    }

    /**
     * Sets the add-on.
     *
     * @param pAddOn The add-on.
     */
    public void setAddOn(final AddOn pAddOn) {
        this.addOn = pAddOn;
    }

    /**
     * Gets the quantity.
     *
     * @return The quantity.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity.
     *
     * @param pQuantity The quantity.
     */
    public void setQuantity(final Integer pQuantity) {
        this.quantity = pQuantity;
    }

    /**
     * Gets the start date.
     *
     * @return The start date.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param pStartDate The start date.
     */
    public void setStartDate(final Date pStartDate) {
        this.startDate = pStartDate;
    }

    /**
     * Gets the end date.
     *
     * @return The end date.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date.
     *
     * @param pEndDate The end date.
     */
    public void setEndDate(final Date pEndDate) {
        this.endDate = pEndDate;
    }

    /**
     * Gets the renewal date.
     *
     * @return The renewal date.
     */
    public Date getRenewalDate() {
        return renewalDate;
    }

    /**
     * Sets the renewal date.
     *
     * @param pRenewalDate The renewal date.
     */
    public void setRenewalDate(final Date pRenewalDate) {
        this.renewalDate = pRenewalDate;
    }

    /**
     * Gets the new required quantity.
     *
     * @return The new required quantity.
     */
    public Integer getNewRequiredQuantity() {
        return newRequiredQuantity;
    }

    /**
     * Sets the new required quantity.
     *
     * @param pNewRequiredQuantity The new required quantity.
     */
    public void setNewRequiredQuantity(final Integer pNewRequiredQuantity) {
        this.newRequiredQuantity = pNewRequiredQuantity;
    }

    /**
     * Gets the uid.
     *
     * @return The uid.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the uid.
     *
     * @param pUid The uid.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Gets the created date.
     *
     * @return The created date.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the created date.
     *
     * @param pCreated The created date.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Gets the updated date.
     *
     * @return The updated date.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the updated date.
     *
     * @param pUpdated The updated date.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * This method is used to compare two SubscriptionAddOn objects.
     *
     * @param other The other SubscriptionAddOn object.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof SubscriptionAddOn)) {
            return false;
        }

        SubscriptionAddOn subscriptionAddOn = (SubscriptionAddOn) other;

        return Objects.equals(this.uid, subscriptionAddOn.uid);
    }

    /**
     * This method is used to get the hash code of the SubscriptionAddOn object.
     *
     * @return The hash code of the SubscriptionAddOn object.
     */
    public int hashCode() {
        return Objects.hash(uid);
    }
}
