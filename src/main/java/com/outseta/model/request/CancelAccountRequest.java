package com.outseta.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.result.Account;

/**
 * This class is used to represent a Cancel Account Request object to the API.
 */
public final class CancelAccountRequest implements BaseInput {

    /**
     * The reason for canceling the account.
     */
    @JsonProperty("CancelationReason")
    private String cancellationReason;

    /**
     * A comment for canceling the account.
     */
    @JsonProperty("Comment")
    private String comment;

    /**
     * The account to cancel.
     */
    @JsonProperty("Account")
    private Account account;

    /**
     * Private constructor to enforce the use of the builder.
     */
    private CancelAccountRequest() {
    }

    /**
     * This class is used to build a Cancel Account Request object.
     */
    public static class Builder {

        /**
         * The Cancel Account Request object to build.
         */
        private final CancelAccountRequest cancelAccountRequest;

        /**
         * The constructor creates an empty object.
         */
        public Builder() {
            this.cancelAccountRequest = new CancelAccountRequest();
        }

        /**
         * This method sets the reason for canceling the account.
         * @param cancellationReason The reason for canceling the account.
         * @return The builder.
         */
        public Builder cancellationReason(final String cancellationReason) {
            this.cancelAccountRequest.cancellationReason = cancellationReason;
            return this;
        }

        /**
         * This method sets the comment for canceling the account.
         * @param comment The comment for canceling the account.
         * @return The builder.
         */
        public Builder comment(final String comment) {
            this.cancelAccountRequest.comment = comment;
            return this;
        }

        /**
         * This method sets the account to cancel.
         * @param account The account to cancel.
         * @return The builder.
         */
        public Builder account(final Account account) {
            this.cancelAccountRequest.account = account;
            return this;
        }

        /**
         * This method builds the Cancel Account Request object.
         * @return The Cancel Account Request object.
         */
        public CancelAccountRequest build() {
            return this.cancelAccountRequest;
        }
    }

    /**
     * This method returns a builder to build a Cancel Account Request object.
     * @return A builder to build a Cancel Account Request object.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * This method returns the reason for canceling the account.
     * @return The reason for canceling the account.
     */
    public String getCancelationReason() {
        return cancellationReason;
    }

    /**
     * This method sets the reason for canceling the account.
     * @param pCancellationReason The reason for canceling the account.
     */
    public void setCancellationReason(final String pCancellationReason) {
        this.cancellationReason = pCancellationReason;
    }

    /**
     * This method returns the comment for canceling the account.
     * @return The comment for canceling the account.
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method sets the comment for canceling the account.
     * @param pComment The comment for canceling the account.
     */
    public void setComment(final String pComment) {
        this.comment = pComment;
    }

    /**
     * This method returns the account to cancel.
     * @return The account to cancel.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * This method sets the account to cancel.
     * @param pAccount The account to cancel.
     */
    public void setAccount(final Account pAccount) {
        this.account = pAccount;
    }
}
