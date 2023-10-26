package com.outseta.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.result.Account;

/**
 * Represents a request to update payment information.
 */
public class UpdatePaymentInfoRequest implements BaseInput {

    /**
     * Builder class for the UpdatePaymentInfoRequest class.
     */
    public static class Builder {

        /**
         * The UpdatePaymentInfoRequest object to be built.
         */
        private UpdatePaymentInfoRequest updatePaymentInfoRequest;

        /**
         * The default constructor for Builder.
         */
        public Builder() {
            updatePaymentInfoRequest = new UpdatePaymentInfoRequest();
        }

        /**
         * Set the account for the payment info.
         *
         * @param account The account.
         * @return The builder instance.
         */
        public Builder account(final Account account) {
            updatePaymentInfoRequest.account = account;
            return this;
        }

        /**
         * Set the customer token for the payment info.
         *
         * @param customerToken The customer token.
         * @return The builder instance.
         */
        public Builder customerToken(final String customerToken) {
            updatePaymentInfoRequest.customerToken = customerToken;
            return this;
        }

        /**
         * Set the name on card of the customer.
         *
         * @param nameOnCard The name on card.
         * @return The builder instance.
         */
        public Builder nameOnCard(final String nameOnCard) {
            updatePaymentInfoRequest.nameOnCard = nameOnCard;
            return this;
        }

        /**
         * Set the payment token for the updated payment info.
         *
         * @param paymentToken The payment token.
         * @return The builder instance.
         */
        public Builder paymentToken(final String paymentToken) {
            updatePaymentInfoRequest.paymentToken = paymentToken;
            return this;
        }

        /**
         * Build the UpdatePaymentInfoRequest object.
         *
         * @return The UpdatePaymentInfoRequest object.
         */
        public UpdatePaymentInfoRequest build() {
            return updatePaymentInfoRequest;
        }
    }

    /**
     * The account for which the payment info needs to be updated.
     */
    @JsonProperty("Account")
    private Account account;

    /**
     * The customer token for the payment info.
     */
    @JsonProperty("CustomerToken")
    private String customerToken;

    /**
     * The name on card of the customer.
     */
    @JsonProperty("NameOnCard")
    private String nameOnCard;

    /**
     * The payment token for the updated payment info.
     */
    @JsonProperty("PaymentToken")
    private String paymentToken;

    /**
     * Returns the builder object for the UpdatePaymentInfoRequest class.
     * @return The builder object.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Getter for the account.
     * @return The account.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Setter for the account.
     * @param pAccount The account.
     */
    public void setAccount(final Account pAccount) {
        this.account = pAccount;
    }

    /**
     * Getter for the customer token.
     * @return The customer token.
     */
    public String getCustomerToken() {
        return customerToken;
    }

    /**
     * Setter for the customer token.
     * @param pCustomerToken The customer token.
     */
    public void setCustomerToken(final String pCustomerToken) {
        this.customerToken = pCustomerToken;
    }

    /**
     * Getter for the name on card.
     * @return The name on card.
     */
    public String getNameOnCard() {
        return nameOnCard;
    }

    /**
     * Setter for the name on card.
     * @param pNameOnCard The name on card.
     */
    public void setNameOnCard(final String pNameOnCard) {
        this.nameOnCard = pNameOnCard;
    }

    /**
     * Getter for the payment token.
     * @return The payment token.
     */
    public String getPaymentToken() {
        return paymentToken;
    }

    /**
     * Setter for the payment token.
     * @param pPaymentToken The payment token.
     */
    public void setPaymentToken(final String pPaymentToken) {
        this.paymentToken = pPaymentToken;
    }
}
