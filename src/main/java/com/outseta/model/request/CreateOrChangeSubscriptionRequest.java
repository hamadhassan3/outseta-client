package com.outseta.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;
import com.outseta.model.result.Account;
import com.outseta.model.result.Plan;
import com.outseta.model.result.SubscriptionAddOn;

import java.util.List;

/**
 * This class represents a request to create a subscription.
 */
public final class CreateOrChangeSubscriptionRequest
        implements BaseInput, BaseResult {

    /**
     * This class is used to build a CreateSubscriptionRequest object.
     */
    public static class Builder {

        /**
         * The CreateSubscriptionRequest object to build.
         */
        private final CreateOrChangeSubscriptionRequest
                createOrChangeSubscriptionRequest;

        /**
         * The constructor creates a new builder with the base url.
         */
        public Builder() {
            createOrChangeSubscriptionRequest = new
                    CreateOrChangeSubscriptionRequest();
        }

        /**
         * This method is used to set the plan for which to create the
         * subscription.
         *
         * @param pPlan The plan for which to create the subscription.
         * @return The builder.
         */
        public Builder plan(final Plan pPlan) {
            createOrChangeSubscriptionRequest.setPlan(pPlan);
            return this;
        }

        /**
         * This method is used to set the billing renewal term.
         *
         * @param pBillingRenewalTerm The billing renewal term.
         * @return The builder.
         */
        public Builder billingRenewalTerm(final Integer pBillingRenewalTerm) {
            createOrChangeSubscriptionRequest.setBillingRenewalTerm(
                    pBillingRenewalTerm);
            return this;
        }

        /**
         * This method is used to set the account.
         *
         * @param pAccount The account.
         * @return The builder.
         */
        public Builder account(final Account pAccount) {
            createOrChangeSubscriptionRequest.setAccount(pAccount);
            return this;
        }

        /**
         * This method is used to set the subscription add-ons.
         *
         * @param pSubscriptionAddOns The subscription add-ons.
         * @return The builder.
         */
        public Builder subscriptionAddOns(
                final List<SubscriptionAddOn> pSubscriptionAddOns) {
            createOrChangeSubscriptionRequest.setSubscriptionAddOns(
                    pSubscriptionAddOns);
            return this;
        }

        /**
         * This method is used to build the CreateSubscriptionRequest object.
         *
         * @return The CreateSubscriptionRequest object.
         */
        public CreateOrChangeSubscriptionRequest build() {
            return createOrChangeSubscriptionRequest;
        }
    }

    /**
     * The plan for which to create the subscription.
     */
    @JsonProperty("Plan")
    private Plan plan;

    /**
     * The billing renewal term for this subscription.
     */
    @JsonProperty("BillingRenewalTerm")
    private Integer billingRenewalTerm;

    /**
     * The subscription add-ons for this subscription.
     */
    @JsonProperty("SubscriptionAddOns")
    private List<SubscriptionAddOn> subscriptionAddOns;

    /**
     * The account for which to create the subscription.
     */
    @JsonProperty("Account")
    private Account account;

    /**
     * This method is used to get a builder that can be used to build a
     * CreateSubscriptionRequest object.
     * @return The builder that can be used to build a
     * CreateSubscriptionRequest object;
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Intentionally private to enforce usage of builder.
     */
    private CreateOrChangeSubscriptionRequest() {
    }

    /**
     * Gets the plan for which to create the subscription.
     * @return The plan for which to create the subscription.
     */
    public Plan getPlan() {
        return plan;
    }

    /**
     * Sets the plan for which to create the subscription.
     * @param pPlan The plan for which to create the subscription.
     */
    public void setPlan(final Plan pPlan) {
        this.plan = pPlan;
    }

    /**
     * Gets the billing renewal term.
     * @return The billing renewal term.
     */
    public Integer getBillingRenewalTerm() {
        return billingRenewalTerm;
    }

    /**
     * Sets the billing renewal term.
     * @param pBillingRenewalTerm The billing renewal term.
     */
    public void setBillingRenewalTerm(final Integer pBillingRenewalTerm) {
        this.billingRenewalTerm = pBillingRenewalTerm;
    }

    /**
     * Gets the account.
     * @return The account.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets the account.
     * @param pAccount The account.
     */
    public void setAccount(final Account pAccount) {
        this.account = pAccount;
    }

    /**
     * Gets the subscription add-ons.
     * @return The subscription add-ons.
     */
    public List<SubscriptionAddOn> getSubscriptionAddOns() {
        return subscriptionAddOns;
    }

    /**
     * Sets the subscription add-ons.
     * @param pSubscriptionAddOns The subscription add-ons.
     */
    public void setSubscriptionAddOns(
            final List<SubscriptionAddOn> pSubscriptionAddOns) {
        this.subscriptionAddOns = pSubscriptionAddOns;
    }
}
