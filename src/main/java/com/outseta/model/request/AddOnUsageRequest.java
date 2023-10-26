package com.outseta.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.result.SubscriptionAddOn;

import java.util.Date;

/**
 * This class is used to represent an add-on usage request.
 */
public class AddOnUsageRequest implements BaseInput {

    /**
     * Builder class used to create an AddOnUsageRequest instance.
     */
    public static class Builder {

        /**
         * The AddOnUsageRequest instance that is being built.
         */
        private AddOnUsageRequest addOnUsageRequest;

        /**
         * The default constructor for the builder.
         */
        public Builder() {
            addOnUsageRequest = new AddOnUsageRequest();
        }

        /**
         * Set the date on which add-on was used.
         *
         * @param pUsageDate The date on which add-on was used.
         * @return The builder.
         */
        public Builder usageDate(final Date pUsageDate) {
            addOnUsageRequest.setUsageDate(pUsageDate);
            return this;
        }

        /**
         * Set the amount of add-on used.
         *
         * @param pAmount The amount of add-on used.
         * @return The builder.
         */
        public Builder amount(final Integer pAmount) {
            addOnUsageRequest.setAmount(pAmount);
            return this;
        }

        /**
         * Set the add-on associated with the usage.
         *
         * @param pSubscriptionAddOn The add-on associated with the usage.
         * @return The builder.
         */
        public Builder subscriptionAddOn(
                final SubscriptionAddOn pSubscriptionAddOn) {
            addOnUsageRequest.setSubscriptionAddOn(pSubscriptionAddOn);
            return this;
        }

        /**
         * Build the AddOnUsageRequest instance.
         *
         * @return The AddOnUsageRequest instance.
         */
        public AddOnUsageRequest build() {
            return addOnUsageRequest;
        }
    }

    /**
     * The date on which add-on was used.
     */
    @JsonProperty("UsageDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date usageDate;

    /**
     * The amount of add-on used.
     */
    @JsonProperty("Amount")
    private Integer amount;

    /**
     * The add-on associated with the usage.
     */
    @JsonProperty("SubscriptionAddOn")
    private SubscriptionAddOn subscriptionAddOn;

    /**
     * The default constructor for the AddOnUsageRequest.
     */
    public AddOnUsageRequest() {

    }

    /**
     * Returns a builder that can be used to create an
     * AddOnUsageRequest instance.
     *
     * @return The builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Get the date on which add-on was used.
     *
     * @return The date on which add-on was used.
     */
    public Date getUsageDate() {
        return usageDate;
    }

    /**
     * Set the date on which add-on was used.
     *
     * @param pUsageDate The date on which add-on was used.
     */
    public void setUsageDate(final Date pUsageDate) {
        this.usageDate = pUsageDate;
    }

    /**
     * Get the amount of add-on used.
     *
     * @return The amount of add-on used.
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Set the amount of add-on used.
     *
     * @param pAmount The amount of add-on used.
     */
    public void setAmount(final Integer pAmount) {
        this.amount = pAmount;
    }

    /**
     * Get the add-on associated with the usage.
     *
     * @return The add-on associated with the usage.
     */
    public SubscriptionAddOn getSubscriptionAddOn() {
        return subscriptionAddOn;
    }

    /**
     * Set the add-on associated with the usage.
     *
     * @param pSubscriptionAddOn The add-on associated with the usage.
     */
    public void setSubscriptionAddOn(
            final SubscriptionAddOn pSubscriptionAddOn) {
        this.subscriptionAddOn = pSubscriptionAddOn;
    }
}
