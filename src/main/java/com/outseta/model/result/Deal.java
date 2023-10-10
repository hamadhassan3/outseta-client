package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.List;

/**
 * This class represents a Deal.
 */
public final class Deal implements BaseInput, BaseResult {

    /**
     * This class is used to build a Deal object.
     */
    public static class Builder {

        /**
         * The Deal object.
         */
        private Deal deal;

        /**
         * This constructor is used to initialize the Deal object.
         */
        public Builder() {
            this.deal = new Deal();
        }

        /**
         * This method sets the name of the Deal.
         * @param pName The name of the Deal.
         * @return The Builder object.
         */
        public Builder name(final String pName) {
            this.deal.name = pName;
            return this;
        }

        /**
         * This method sets the Deal Pipeline Stage.
         * @param pDealPipelineStage The Deal Pipeline Stage.
         * @return The Builder object.
         */
        public Builder dealPipelineStage(
                final DealPipelineStage pDealPipelineStage) {
            this.deal.dealPipelineStage = pDealPipelineStage;
            return this;
        }

        /**
         * This method sets the amount of the Deal.
         * @param pAmount The amount of the Deal.
         * @return The Builder object.
         */
        public Builder amount(final double pAmount) {
            this.deal.amount = pAmount;
            return this;
        }

        /**
         * This method sets the currency of the Deal.
         * @param pAssignedToPersonClientIdentifier The currency of the Deal.
         * @return The Builder object.
         */
        public Builder assignedToPersonClientIdentifier(
                final String pAssignedToPersonClientIdentifier) {
            this.deal.assignedToPersonClientIdentifier =
                    pAssignedToPersonClientIdentifier;
            return this;
        }

        /**
         * This method sets the Account associated with the Deal.
         * @param pAccount The Account associated with the Deal.
         * @return The Builder object.
         */
        public Builder account(final PersonAccount pAccount) {
            this.deal.account = pAccount;
            return this;
        }

        /**
         * This method sets the Deal People associated with the Deal.
         * @param pDealPeople The Deal People associated with the Deal.
         * @return The Builder object.
         */
        public Builder dealPeople(final List<DealPerson> pDealPeople) {
            this.deal.dealPeople = pDealPeople;
            return this;
        }

        /**
         * This method returns the Deal object.
         * @return The Deal object.
         */
        public Deal build() {
            return this.deal;
        }
    }

    /**
     * The name of the Deal.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * The Deal Pipeline Stage.
     */
    @JsonProperty("DealPipelineStage")
    private DealPipelineStage dealPipelineStage;

    /**
     * The amount of the Deal.
     */
    @JsonProperty("Amount")
    private double amount;

    /**
     * The currency of the Deal.
     */
    @JsonProperty("AssignedToPersonClientIdentifier")
    private String assignedToPersonClientIdentifier;

    /**
     * The Account associated with the Deal.
     */
    @JsonProperty("Account")
    private PersonAccount account;

    /**
     * The Deal People associated with the Deal.
     */
    @JsonProperty("DealPeople")
    private List<DealPerson> dealPeople;

    /**
     * The constructor is intentionally private to force the
     * use of the Builder.
     */
    private Deal() {
    }

    /**
     * Returns the name of the Deal.
     * @return The name of the Deal.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Deal.
     * @param pName The name of the Deal.
     */
    public void setName(final String pName) {
        this.name = pName;
    }

    /**
     * Returns the Deal Pipeline Stage.
     * @return The Deal Pipeline Stage.
     */
    public DealPipelineStage getDealPipelineStage() {
        return dealPipelineStage;
    }

    /**
     * Sets the Deal Pipeline Stage.
     * @param pDealPipelineStage The Deal Pipeline Stage.
     */
    public void setDealPipelineStage(
            final DealPipelineStage pDealPipelineStage) {
        this.dealPipelineStage = pDealPipelineStage;
    }

    /**
     * Returns the amount of the Deal.
     * @return The amount of the Deal.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the Deal.
     * @param pAmount The amount of the Deal.
     */
    public void setAmount(final double pAmount) {
        this.amount = pAmount;
    }

    /**
     * Returns the currency of the Deal.
     * @return The currency of the Deal.
     */
    public String getAssignedToPersonClientIdentifier() {
        return assignedToPersonClientIdentifier;
    }

    /**
     * Sets the currency of the Deal.
     * @param pAssignedToPersonClientIdentifier The currency of the Deal.
     */
    public void setAssignedToPersonClientIdentifier(
            final String pAssignedToPersonClientIdentifier) {
        this.assignedToPersonClientIdentifier =
                pAssignedToPersonClientIdentifier;
    }

    /**
     * Returns the Account associated with the Deal.
     * @return The Account associated with the Deal.
     */
    public PersonAccount getAccount() {
        return account;
    }

    /**
     * Sets the Account associated with the Deal.
     * @param pAccount The Account associated with the Deal.
     */
    public void setAccount(final PersonAccount pAccount) {
        this.account = pAccount;
    }

    /**
     * Returns the Deal People associated with the Deal.
     * @return The Deal People associated with the Deal.
     */
    public List<DealPerson> getDealPeople() {
        return dealPeople;
    }

    /**
     * Sets the Deal People associated with the Deal.
     * @param pDealPeople The Deal People associated with the Deal.
     */
    public void setDealPeople(
            final List<DealPerson> pDealPeople) {
        this.dealPeople = pDealPeople;
    }
}
