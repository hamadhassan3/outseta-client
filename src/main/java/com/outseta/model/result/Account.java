package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.constant.AccountStage;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * This class is used to represent the data returned for the Account entity.
 */
public final class Account implements BaseResult, BaseInput {

    /**
     * This class is used to build an Account object.
     */
    public static class Builder {

        /**
         * The Account object to be created.
         */
        private Account account;

        /**
         * The constructor initializes the Account object.
         */
        public Builder() {
            account = new Account();
        }

        /**
         * Sets the uid of the account.
         * @param pUid The uid of the account.
         * @return The builder.
         */
        public Builder uid(final String pUid) {
            account.setUid(pUid);
            return this;
        }

        /**
         * Sets the name of the account.
         * @param pName The name of the account.
         * @return The builder.
         */
        public Builder name(final String pName) {
            account.setName(pName);
            return this;
        }

        /**
         * Sets the client identifier of the account.
         * @param pClientIdentifier The client identifier of the account.
         * @return The builder.
         */
        public Builder clientIdentifier(final String pClientIdentifier) {
            account.setClientIdentifier(pClientIdentifier);
            return this;
        }

        /**
         * Sets the billing address of the account.
         * @param pBillingAddress The billing address of the account.
         * @return The builder.
         */
        public Builder billingAddress(final Address pBillingAddress) {
            account.setBillingAddress(pBillingAddress);
            return this;
        }

        /**
         * Sets the mailing address of the account.
         * @param pMailingAddress The mailing address of the account.
         * @return The builder.
         */
        public Builder mailingAddress(final Address pMailingAddress) {
            account.setMailingAddress(pMailingAddress);
            return this;
        }

        /**
         * Sets the account stage of the account.
         * @param pAccountStage The account stage of the account.
         * @return The builder.
         */
        public Builder accountStage(final AccountStage pAccountStage) {
            account.setAccountStage(pAccountStage.getValue());
            return this;
        }

        /**
         * Sets the payment information of the account.
         * @param pPaymentInformation The payment information of the account.
         * @return The builder.
         */
        public Builder paymentInformation(final String pPaymentInformation) {
            account.setPaymentInformation(pPaymentInformation);
            return this;
        }

        /**
         * Sets the PersonAccounts associated with the account.
         * @param pPersonAccount The PersonAccounts associated with the account.
         * @return The builder.
         */
        public Builder personAccount(final List<PersonAccount> pPersonAccount) {
            account.setPersonAccount(pPersonAccount);
            return this;
        }

        /**
         * Sets the date the account was created.
         * @param pCreated The date the account was created.
         * @return The builder.
         */
        public Builder created(final Date pCreated) {
            account.setCreated(pCreated);
            return this;
        }

        /**
         * Sets the date the account was last updated.
         * @param pUpdated The date the account was last updated.
         * @return The builder.
         */
        public Builder updated(final Date pUpdated) {
            account.setUpdated(pUpdated);
            return this;
        }

        /**
         * Sets the Subscriptions associated with this account.
         * @param subscriptions The Subscriptions associated with this account.
         * @return The builder.
         */
        public Builder subscriptions(final List<Subscription> subscriptions) {
            account.setSubscriptions(subscriptions);
            return this;
        }

        /**
         * Returns the Account object.
         * @return The Account object.
         */
        public Account build() {
            return account;
        }
    }

    /**
     * The unique identifier for the account.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * The name of the account.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * The account's client identifier.
     */
    @JsonProperty("ClientIdentifier")
    private String clientIdentifier;

    /**
     * The account's billing address.
     */
    @JsonProperty("BillingAddress")
    private Address billingAddress;

    /**
     * The account's mailing address.
     */
    @JsonProperty("MailingAddress")
    private Address mailingAddress;

    /**
     * The account's stage.
     */
    @JsonProperty("AccountStage")
    private Integer accountStage;

    /**
     * The account's phone number.
     */
    @JsonProperty("PaymentInformation")
    private String paymentInformation;

    /**
     * The PersonAccounts associated with this account.
     */
    @JsonProperty("PersonAccount")
    private List<PersonAccount> personAccount;

    /**
     * The Subscriptions associated with this account.
     */
    @JsonProperty("Subscriptions")
    private List<Subscription> subscriptions;

    /**
     * The date this account was created.
     */
    @JsonProperty("Created")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * The date this account was last updated.
     */
    @JsonProperty("Updated")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updated;

    /**
     * This method is used to create a new Builder object.
     * @return The Builder object.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The constructor is intentionally private to force the use
     * of builder.
     */
    private Account() {

    }

    /**
     * Returnst the uid of the account.
     * @return The uid of the account.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the uid of the account.
     * @param pUid The uid of the account.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Returns the name of the account.
     * @return The name of the account.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the account.
     * @param pName The name of the account.
     */
    public void setName(final String pName) {
        this.name = pName;
    }

    /**
     * Returns the client identifier of the account.
     * @return The client identifier of the account.
     */
    public String getClientIdentifier() {
        return clientIdentifier;
    }

    /**
     * Sets the client identifier of the account.
     * @param pClientIdentifier The client identifier of the account.
     */
    public void setClientIdentifier(final String pClientIdentifier) {
        this.clientIdentifier = pClientIdentifier;
    }

    /**
     * Returns the billing address of the account.
     * @return The billing address of the account.
     */
    public Address getBillingAddress() {
        return billingAddress;
    }

    /**
     * Sets the billing address of the account.
     * @param pBillingAddress The billing address of the account.
     */
    public void setBillingAddress(final Address pBillingAddress) {
        this.billingAddress = pBillingAddress;
    }

    /**
     * Returns the mailing address of the account.
     * @return The mailing address of the account.
     */
    public Address getMailingAddress() {
        return mailingAddress;
    }

    /**
     * Sets the mailing address of the account.
     * @param pMailingAddress The mailing address of the account.
     */
    public void setMailingAddress(final Address pMailingAddress) {
        this.mailingAddress = pMailingAddress;
    }

    /**
     * Returns the account stage of the account.
     * @return The account stage of the account.
     */
    public Integer getAccountStage() {
        return accountStage;
    }

    /**
     * Sets the account stage of the account.
     * @param pAccountStage The account stage of the account.
     */
    public void setAccountStage(final Integer pAccountStage) {
        this.accountStage = pAccountStage;
    }

    /**
     * Returns the payment information of the account.
     * @return The payment information of the account.
     */
    public String getPaymentInformation() {
        return paymentInformation;
    }

    /**
     * Sets the payment information of the account.
     * @param pPaymentInformation The payment information of the account.
     */
    public void setPaymentInformation(final String pPaymentInformation) {
        this.paymentInformation = pPaymentInformation;
    }

    /**
     * Returns the PersonAccounts associated with the account.
     * @return The PersonAccounts associated with the account.
     */
    public List<PersonAccount> getPersonAccount() {
        return personAccount;
    }

    /**
     * Sets the PersonAccounts associated with the account.
     * @param pPersonAccount The PersonAccounts associated with the account.
     */
    public void setPersonAccount(
            final List<PersonAccount> pPersonAccount) {
        this.personAccount = pPersonAccount;
    }

    /**
     * Returns the date the account was created.
     * @return The date the account was created.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the date the account was created.
     * @param pCreated The date the account was created.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Returns the date the account was last updated.
     * @return The date the account was last updated.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the date the account was last updated.
     * @param pUpdated The date the account was last updated.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * Returns the Subscriptions associated with this account.
     * @return The Subscriptions associated with this account.
     */
    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    /**
     * Sets the Subscriptions associated with this account.
     * @param pSubscriptions The Subscriptions associated with this account.
     */
    public void setSubscriptions(final List<Subscription> pSubscriptions) {
        this.subscriptions = pSubscriptions;
    }

    /**
     * Compares this Account to the specified object.
     *
     * @param other The object to compare this Account against.
     * @return True if the objects are equal and false otherwise.
     */
    @Override
    public boolean equals(final Object other) {

            if (this == other) {
                return true;
            }

            if (!(other instanceof Account)) {
                return false;
            }

            Account otherAccount = (Account) other;

            return Objects.equals(this.uid, otherAccount.uid);
    }

    /**
     * Returns the hash code of this Account.
     *
     * @return The hash code of this Account.
     */
    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
