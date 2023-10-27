package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.Objects;

/**
 * This class is used to represent the data returned for the PersonAccount
 * entity inside the Person object or independently.
 */
public class PersonAccount implements BaseResult, BaseInput {

    /**
     * This class implements a Builder for the PersonAccount class.
     */
    public static class Builder {

        /**
         * The PersonAccount object that needs to be built.
         */
        private final PersonAccount personAccount;

        /**
         * Default constructor for the PersonAccountBuilder class.
         */
        public Builder() {
            personAccount = new PersonAccount();
        }

        /**
         * Sets the person object that this PersonAccount is associated with.
         * @param pPerson The person object that this PersonAccount is
         *               associated with.
         * @return The PersonAccountBuilder object with the person object that
         * this PersonAccount is associated with set.
         */
        public Builder person(final Person pPerson) {
            personAccount.setPerson(pPerson);
            return this;
        }

        /**
         * Sets the account object that this PersonAccount is associated with.
         * @param pAccount The account object that this PersonAccount is
         *                associated with.
         * @return The PersonAccountBuilder object with the account object that
         * this PersonAccount is associated with set.
         */
        public Builder account(final Account pAccount) {
            personAccount.setAccount(pAccount);
            return this;
        }

        /**
         * Sets whether this PersonAccount is the primary PersonAccount for the
         * Person.
         * @param pPrimary Whether this PersonAccount is the primary
         *                PersonAccount for the Person.
         * @return The PersonAccountBuilder object with whether this
         * PersonAccount is the primary PersonAccount for the Person set.
         */
        public Builder primary(final Boolean pPrimary) {
            personAccount.setPrimary(pPrimary);
            return this;
        }

        /**
         * Sets the uid of the PersonAccount object.
         * @param uid The uid of the PersonAccount object.
         * @return The PersonAccountBuilder object with the uid of the
         *       PersonAccount object set.
         */
        public Builder uid(final String uid) {
            personAccount.setUid(uid);
            return this;
        }

        /**
         * Sets the created date of the person account object.
         * @param created The created date of the person account object.
         * @return The PersonAccountBuilder object with the created date of the
         *     person account object set.
         */
        public Builder created(final Date created) {
            personAccount.setCreated(created);
            return this;
        }

        /**
         * Sets the updated date of the person account object.
         * @param updated The updated date of the person account object.
         * @return The PersonAccountBuilder object with the updated date of the
         *     person account object set.
         */
        public Builder updated(final Date updated) {
            personAccount.setUpdated(updated);
            return this;
        }

        /**
         * Builds and returns the PersonAccount object.
         * @return The PersonAccount object.
         */
        public PersonAccount build() {
            return personAccount;
        }
    }

    /**
     * The person object that this PersonAccount is associated with.
     */
    @JsonProperty("Person")
    private Person person;

    /**
     * The account object that this PersonAccount is associated with.
     */
    @JsonProperty("Account")
    private Account account;

    /**
     * Whether this PersonAccount is the primary PersonAccount for the
     * Person.
     */
    @JsonProperty("IsPrimary")
    private Boolean isPrimary;

    /**
     * Whether this PersonAccount should receive invoices.
     */
    @JsonProperty("ReceiveInvoices")
    private Boolean receiveInvoices;

    /**
     * The activity event data for this PersonAccount.
     */
    @JsonProperty("ActivityEventData")
    private Object activityEventData;

    /**
     * The unique identifier for this PersonAccount.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * The date this PersonAccount was created.
     */
    @JsonProperty("Created")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * The date this PersonAccount was last updated.
     */
    @JsonProperty("Updated")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updated;

    /**
     * Returns a new Builder object.
     * @return A new Builder object.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Default constructor for the creation of a PersonAccount object.
     */
    public PersonAccount() {
    }

    /**
     * Returns the person object that this PersonAccount is associated with.
     * @return The person object that this PersonAccount is associated with.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the person object that this PersonAccount is associated with.
     * @param pPerson The person object that this PersonAccount is associated
     *               with.
     */
    public void setPerson(final Person pPerson) {
        this.person = pPerson;
    }

    /**
     * Returns the account object that this PersonAccount is associated with.
     * @return The account object that this PersonAccount is associated with.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets the account object that this PersonAccount is associated with.
     * @param pAccount The account object that this PersonAccount is associated
     *                with.
     */
    public void setAccount(final Account pAccount) {
        this.account = pAccount;
    }

    /**
     * Returns whether this PersonAccount is the primary PersonAccount for the
     * Person.
     * @return Whether this PersonAccount is the primary PersonAccount for the
     * Person.
     */
    public Boolean getPrimary() {
        return isPrimary;
    }

    /**
     * Sets whether this PersonAccount is the primary PersonAccount for the
     * Person.
     * @param pPrimary Whether this PersonAccount is the primary PersonAccount
     *                for the Person.
     */
    public void setPrimary(final Boolean pPrimary) {
        isPrimary = pPrimary;
    }

    /**
     * Returns whether this PersonAccount should receive invoices.
     * @return Whether this PersonAccount should receive invoices.
     */
    public Boolean getReceiveInvoices() {
        return receiveInvoices;
    }

    /**
     * Sets whether this PersonAccount should receive invoices.
     * @param pReceiveInvoices Whether this PersonAccount should receive
     *                        invoices.
     */
    public void setReceiveInvoices(final Boolean pReceiveInvoices) {
        this.receiveInvoices = pReceiveInvoices;
    }

    /**
     * Returns the activity event data for this PersonAccount.
     * @return The activity event data for this PersonAccount.
     */
    public Object getActivityEventData() {
        return activityEventData;
    }

    /**
     * Sets the activity event data for this PersonAccount.
     * @param pActivityEventData The activity event data for this PersonAccount.
     */
    public void setActivityEventData(final Object pActivityEventData) {
        this.activityEventData = pActivityEventData;
    }

    /**
     * Returns the unique identifier for this PersonAccount.
     * @return The unique identifier for this PersonAccount.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the unique identifier for this PersonAccount.
     * @param pUid The unique identifier for this PersonAccount.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Returns the date this PersonAccount was created.
     * @return The date this PersonAccount was created.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the date this PersonAccount was created.
     * @param pCreated The date this PersonAccount was created.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Returns the date this PersonAccount was last updated.
     * @return The date this PersonAccount was last updated.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the date this PersonAccount was last updated.
     * @param pUpdated The date this PersonAccount was last updated.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * This method overrides the equals method.
     */
    @Override
    public boolean equals(final Object pObject) {

        if (this == pObject) {
            return true;
        }

        if (!(pObject instanceof PersonAccount)) {
            return false;
        }

        PersonAccount otherPersonAccount = (PersonAccount) pObject;

        return Objects.equals(this.uid, otherPersonAccount.uid);
    }

    /**
     * This method overrides the hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
