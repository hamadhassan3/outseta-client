package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.constant.BillingTransactionType;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a transaction.
 */
public final class Transaction implements BaseResult {

    /**
     * Builder class for the Transaction class.
     */
    public static class Builder {

        /**
         * The Transaction object to be built.
         */
        private Transaction transaction;

        /**
         * Constructor for the Builder class.
         */
        public Builder() {
            transaction = new Transaction();
        }

        /**
         * Set the date of the transaction.
         *
         * @param transactionDate The transaction date.
         * @return The builder instance.
         */
        public Builder transactionDate(final Date transactionDate) {
            this.transaction.transactionDate = transactionDate;
            return this;
        }

        /**
         * Set the billing transaction type.
         *
         * @param billingTransactionType The billing transaction type.
         * @return The builder instance.
         */
        public Builder billingTransactionType(
                final Integer billingTransactionType) {
            this.transaction.billingTransactionType = billingTransactionType;
            return this;
        }

        /**
         * Set the billing transaction type.
         *
         * @param billingTransactionType The billing transaction type.
         * @return The builder instance.
         */
        public Builder billingTransactionType(
                final BillingTransactionType billingTransactionType) {
            this.transaction.billingTransactionType =
                    billingTransactionType.getValue();
            return this;
        }

        /**
         * Set the associated account information.
         *
         * @param account The account information.
         * @return The builder instance.
         */
        public Builder account(final Account account) {
            this.transaction.account = account;
            return this;
        }

        /**
         * Set the associated invoice information.
         *
         * @param invoice The invoice information.
         * @return The builder instance.
         */
        public Builder invoice(final Invoice invoice) {
            this.transaction.invoice = invoice;
            return this;
        }

        /**
         * Set the transaction amount.
         *
         * @param amount The transaction amount.
         * @return The builder instance.
         */
        public Builder amount(final Double amount) {
            this.transaction.amount = amount;
            return this;
        }

        /**
         * Set the unique identifier for the transaction.
         *
         * @param uid The unique identifier.
         * @return The builder instance.
         */
        public Builder uid(final String uid) {
            this.transaction.uid = uid;
            return this;
        }

        /**
         * Set the date and time when the transaction was created.
         *
         * @param created The creation date and time.
         * @return The builder instance.
         */
        public Builder created(final Date created) {
            this.transaction.created = created;
            return this;
        }

        /**
         * Set the date and time when the transaction was last updated.
         *
         * @param updated The last update date and time.
         * @return The builder instance.
         */
        public Builder updated(final Date updated) {
            this.transaction.updated = updated;
            return this;
        }

        /**
         * Build the Transaction instance.
         *
         * @return The Transaction instance.
         */
        public Transaction build() {
            return transaction;
        }
    }

    /**
     * The date of the transaction.
     */
    @JsonProperty("TransactionDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date transactionDate;

    /**
     * The billing transaction type.
     */
    @JsonProperty("BillingTransactionType")
    private Integer billingTransactionType;

    /**
     * The associated account information.
     */
    @JsonProperty("Account")
    private Account account;

    /**
     * The associated invoice information.
     */
    @JsonProperty("Invoice")
    private Invoice invoice;

    /**
     * The transaction amount.
     */
    @JsonProperty("Amount")
    private Double amount;

    /**
     * The unique identifier for the transaction.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * The date and time when the transaction was created.
     */
    @JsonProperty("Created")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * The date and time when the transaction was last updated.
     */
    @JsonProperty("Updated")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updated;

    /**
     * Returns a new builder for creating transaction.
     * @return The builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Get the date of the transaction.
     *
     * @return The transaction date.
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * Set the date of the transaction.
     *
     * @param pTransactionDate The transaction date.
     */
    public void setTransactionDate(final Date pTransactionDate) {
        this.transactionDate = pTransactionDate;
    }

    /**
     * Get the billing transaction type.
     *
     * @return The billing transaction type.
     */
    public Integer getBillingTransactionType() {
        return billingTransactionType;
    }

    /**
     * Set the billing transaction type.
     *
     * @param pBillingTransactionType The billing transaction type.
     */
    public void setBillingTransactionType(
            final Integer pBillingTransactionType) {
        this.billingTransactionType = pBillingTransactionType;
    }

    /**
     * Get the associated account information.
     *
     * @return The account information.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Set the associated account information.
     *
     * @param pAccount The account information.
     */
    public void setAccount(final Account pAccount) {
        this.account = pAccount;
    }

    /**
     * Get the associated invoice information.
     *
     * @return The invoice information.
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * Set the associated invoice information.
     *
     * @param pInvoice The invoice information.
     */
    public void setInvoice(final Invoice pInvoice) {
        this.invoice = pInvoice;
    }

    /**
     * Get the transaction amount.
     *
     * @return The transaction amount.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Set the transaction amount.
     *
     * @param pAmount The transaction amount.
     */
    public void setAmount(final Double pAmount) {
        this.amount = pAmount;
    }

    /**
     * Get the unique identifier for the transaction.
     *
     * @return The unique identifier.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Set the unique identifier for the transaction.
     *
     * @param pUid The unique identifier.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Get the date and time when the transaction was created.
     *
     * @return The creation date and time.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Set the date and time when the transaction was created.
     *
     * @param pCreated The creation date and time.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Get the date and time when the transaction was last updated.
     *
     * @return The last update date and time.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Set the date and time when the transaction was last updated.
     *
     * @param pUpdated The last update date and time.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * Compares the Transaction instance with another object.
     *
     * @param other The other object.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Transaction)) {
            return false;
        }

        Transaction transaction = (Transaction) other;

        return Objects.equals(this.uid, transaction.uid);
    }

    /**
     * Get the hash code for the Transaction instance.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
