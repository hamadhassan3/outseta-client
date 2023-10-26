package com.outseta.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.result.Account;
import com.outseta.model.result.Invoice;

/**
 * Represents a request to add an invoice payment.
 */
public final class AddInvoicePaymentRequest implements BaseInput {

    /**
     * Builder class for the AddInvoicePaymentRequest class.
     */
    public static class Builder {

        /**
         * The AddInvoicePaymentRequest object to be built.
         */
        private AddInvoicePaymentRequest addInvoicePaymentRequest;

        /**
         * The default constructor for Builder.
         */
        public Builder() {
            addInvoicePaymentRequest = new AddInvoicePaymentRequest();
        }

        /**
         * Set the account of the payment.
         * @param account The account.
         * @return The builder instance.
         */
        public Builder account(final Account account) {
            addInvoicePaymentRequest.account = account;
            return this;
        }

        /**
         * Set the invoice for the payment.
         * @param invoice The invoice.
         * @return The builder instance.
         */
        public Builder invoice(final Invoice invoice) {
            addInvoicePaymentRequest.invoice = invoice;
            return this;
        }

        /**
         * Set the amount of the payment.
         * @param amount The amount.
         * @return The builder instance.
         */
        public Builder amount(final Double amount) {
            addInvoicePaymentRequest.amount = amount;
            return this;
        }

        /**
         * Build the AddInvoicePaymentRequest object.
         * @return The AddInvoicePaymentRequest object.
         */
        public AddInvoicePaymentRequest build() {
            return addInvoicePaymentRequest;
        }
    }

    /**
     * The account of the payment.
     */
    @JsonProperty("Account")
    private Account account;

    /**
     * The invoice for the payment.
     */
    @JsonProperty("Invoice")
    private Invoice invoice;

    /**
     * The amount of the payment.
     */
    @JsonProperty("Amount")
    private Double amount;

    /**
     * Create a new builder instance.
     * @return The builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The constructor is intentionally private to enforce use of builder.
     */
    private AddInvoicePaymentRequest() {

    }

    /**
     * Getter for account.
     * @return The account.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Setter for account.
     * @param pAccount The account.
     */
    public void setAccount(final Account pAccount) {
        this.account = pAccount;
    }

    /**
     * Getter for invoice.
     * @return The invoice.
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * Setter for invoice.
     * @param pInvoice The invoice.
     */
    public void setInvoice(final Invoice pInvoice) {
        this.invoice = pInvoice;
    }

    /**
     * Getter for amount.
     * @return The amount.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Setter for amount.
     * @param pAmount The amount.
     */
    public void setAmount(final Double pAmount) {
        this.amount = pAmount;
    }
}
