package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Represents the EmailList information.
 */
public class EmailList implements BaseInput, BaseResult {

    /**
     * A customized builder for the email list.
     */
    public static class Builder {

        /**
         * The email list object to build.
         */
        private final EmailList emailList;

        /**
         * Constructs a new EmailListBuilder.
         */
        public Builder() {
            this.emailList = new EmailList();
        }

        /**
         * Sets the name of the email list.
         *
         * @param name The name of the email list.
         * @return The EmailListBuilder for method chaining.
         */
        public Builder name(final String name) {
            emailList.setName(name);
            return this;
        }

        /**
         * Sets the subject of the welcome email.
         *
         * @param welcomeSubject The subject of the welcome email.
         * @return The EmailListBuilder for method chaining.
         */
        public Builder welcomeSubject(final String welcomeSubject) {
            emailList.setWelcomeSubject(welcomeSubject);
            return this;
        }

        /**
         * Sets the body of the welcome email.
         *
         * @param welcomeBody The body of the welcome email.
         * @return The EmailListBuilder for method chaining.
         */
        public Builder welcomeBody(final String welcomeBody) {
            emailList.setWelcomeBody(welcomeBody);
            return this;
        }

        /**
         * Sets the sender's name for the welcome email.
         *
         * @param welcomeFromName The sender's name for the welcome email.
         * @return The EmailListBuilder for method chaining.
         */
        public Builder welcomeFromName(final String welcomeFromName) {
            emailList.setWelcomeFromName(welcomeFromName);
            return this;
        }

        /**
         * Sets the sender's email for the welcome email.
         *
         * @param welcomeFromEmail The sender's email for the welcome email.
         * @return The EmailListBuilder for method chaining.
         */
        public Builder welcomeFromEmail(final String welcomeFromEmail) {
            emailList.setWelcomeFromEmail(welcomeFromEmail);
            return this;
        }

        /**
         * Sets the list of people subscribed to the email list.
         *
         * @param emailListPerson The list of people subscribed to the email
         *                        list.
         * @return The EmailListBuilder for method chaining.
         */
        public Builder emailListPerson(final List<Person> emailListPerson) {
            emailList.setEmailListPerson(emailListPerson);
            return this;
        }

        /**
         * Sets the count of people subscribed to the email list.
         *
         * @param countSubscriptionsActive The count of people subscribed to
         *                                 the email list.
         * @return The EmailListBuilder for method chaining.
         */
        public Builder countSubscriptionsActive(
                final Integer countSubscriptionsActive) {
            emailList.setCountSubscriptionsActive(countSubscriptionsActive);
            return this;
        }

        /**
         * Sets the count of people subscribed to the email list.
         *
         * @param countSubscriptionsBounce The count of people subscribed to
         *                                 the email list.
         * @return The EmailListBuilder for method chaining.
         */
        public Builder countSubscriptionsBounce(
                final Integer countSubscriptionsBounce) {
            emailList.setCountSubscriptionsBounce(countSubscriptionsBounce);
            return this;
        }

        /**
         * Sets the count of people subscribed to the email list.
         *
         * @param countSubscriptionsSpam The count of people subscribed to
         *                               the email list.
         * @return The EmailListBuilder for method chaining.
         */
        public Builder countSubscriptionsSpam(
                final Integer countSubscriptionsSpam) {
            emailList.setCountSubscriptionsSpam(countSubscriptionsSpam);
            return this;
        }

        /**
         * Sets the count of people subscribed to the email list.
         *
         * @param countSubscriptionsUnsubscribed The count of people subscribed
         *                                       to the email list.
         * @return The EmailListBuilder for method chaining.
         */
        public Builder countSubscriptionsUnsubscribed(
                final Integer countSubscriptionsUnsubscribed) {
            emailList.setCountSubscriptionsUnsubscribed(
                    countSubscriptionsUnsubscribed);
            return this;
        }

        /**
         * Sets the unique identifier for the email list.
         *
         * @param uid The unique identifier for the email list.
         * @return The EmailListBuilder for method chaining.
         */
        public Builder uid(final String uid) {
            emailList.setUid(uid);
            return this;
        }

        /**
         * Sets the date and time when the email list was created.
         *
         * @param created The date and time when the email list was created.
         * @return The EmailListBuilder for method chaining.
         */
        public Builder created(final Date created) {
            emailList.setCreated(created);
            return this;
        }

        /**
         * Sets the date and time when the email list was last updated.
         *
         * @param updated The date and time when the email list was last
         *               updated.
         * @return The EmailListBuilder for method chaining.
         */
        public Builder updated(final Date updated) {
            emailList.setUpdated(updated);
            return this;
        }

        /**
         * Builds the {@link EmailList} instance.
         *
         * @return The constructed EmailList.
         */
        public EmailList build() {
            return emailList;
        }
    }

    /**
     * Name of the email list.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Subject of the welcome email.
     */
    @JsonProperty("WelcomeSubject")
    private String welcomeSubject;

    /**
     * Body of the welcome email.
     */
    @JsonProperty("WelcomeBody")
    private String welcomeBody;

    /**
     * Sender's name for the welcome email.
     */
    @JsonProperty("WelcomeFromName")
    private String welcomeFromName;

    /**
     * Sender's email for the welcome email.
     */
    @JsonProperty("WelcomeFromEmail")
    private String welcomeFromEmail;

    /**
     * List of people subscribed to the email list.
     */
    @JsonProperty("EmailListPerson")
    private List<Person> emailListPerson;

    /**
     * Count of people subscribed to the email list.
     */
    @JsonProperty("CountSubscriptionsActive")
    private Integer countSubscriptionsActive;

    /**
     * Count of people subscribed to the email list.
     */
    @JsonProperty("CountSubscriptionsBounce")
    private Integer countSubscriptionsBounce;

    /**
     * Count of people subscribed to the email list.
     */
    @JsonProperty("CountSubscriptionsSpam")
    private Integer countSubscriptionsSpam;

    /**
     * Count of people subscribed to the email list.
     */
    @JsonProperty("CountSubscriptionsUnsubscribed")
    private Integer countSubscriptionsUnsubscribed;

    /**
     * Unique identifier for the email list.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * Date and time when the email list was created.
     */
    @JsonProperty("Created")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * Date and time when the email list was last updated.
     */
    @JsonProperty("Updated")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updated;

    /**
     * Creates and returns a new Builder.
     * @return The new Builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Gets the name of the email list.
     *
     * @return The name of the email list.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the email list.
     *
     * @param pName The name of the email list.
     */
    public void setName(final String pName) {
        this.name = pName;
    }

    /**
     * Gets the subject of the welcome email.
     *
     * @return The subject of the welcome email.
     */
    public String getWelcomeSubject() {
        return welcomeSubject;
    }

    /**
     * Sets the subject of the welcome email.
     *
     * @param pWelcomeSubject The subject of the welcome email.
     */
    public void setWelcomeSubject(final String pWelcomeSubject) {
        this.welcomeSubject = pWelcomeSubject;
    }

    /**
     * Gets the body of the welcome email.
     *
     * @return The body of the welcome email.
     */
    public String getWelcomeBody() {
        return welcomeBody;
    }

    /**
     * Sets the body of the welcome email.
     *
     * @param pWelcomeBody The body of the welcome email.
     */
    public void setWelcomeBody(final String pWelcomeBody) {
        this.welcomeBody = pWelcomeBody;
    }

    /**
     * Gets the sender's name for the welcome email.
     *
     * @return The sender's name for the welcome email.
     */
    public String getWelcomeFromName() {
        return welcomeFromName;
    }

    /**
     * Sets the sender's name for the welcome email.
     *
     * @param pWelcomeFromName The sender's name for the welcome email.
     */
    public void setWelcomeFromName(final String pWelcomeFromName) {
        this.welcomeFromName = pWelcomeFromName;
    }

    /**
     * Gets the sender's email for the welcome email.
     *
     * @return The sender's email for the welcome email.
     */
    public String getWelcomeFromEmail() {
        return welcomeFromEmail;
    }

    /**
     * Sets the sender's email for the welcome email.
     *
     * @param pWelcomeFromEmail The sender's email for the welcome email.
     */
    public void setWelcomeFromEmail(final String pWelcomeFromEmail) {
        this.welcomeFromEmail = pWelcomeFromEmail;
    }

    /**
     * Gets the list of people subscribed to the email list.
     *
     * @return The list of people subscribed to the email list.
     */
    public List<Person> getEmailListPerson() {
        return emailListPerson;
    }

    /**
     * Sets the list of people subscribed to the email list.
     *
     * @param pEmailListPerson The list of people subscribed to the email list.
     */
    public void setEmailListPerson(final List<Person> pEmailListPerson) {
        this.emailListPerson = pEmailListPerson;
    }

    /**
     * Gets the count of people subscribed to the email list.
     *
     * @return The count of people subscribed to the email list.
     */
    public Integer getCountSubscriptionsActive() {
        return countSubscriptionsActive;
    }

    /**
     * Sets the count of people subscribed to the email list.
     *
     * @param pCountSubscriptionsActive The count of people subscribed to
     *                                  the email list.
     */
    public void setCountSubscriptionsActive(
            final Integer pCountSubscriptionsActive) {
        this.countSubscriptionsActive = pCountSubscriptionsActive;
    }

    /**
     * Gets the count of people subscribed to the email list.
     *
     * @return The count of people subscribed to the email list.
     */
    public Integer getCountSubscriptionsBounce() {
        return countSubscriptionsBounce;
    }

    /**
     * Sets the count of people subscribed to the email list.
     *
     * @param pCountSubscriptionsBounce The count of people subscribed
     *                                 to the email list.
     */
    public void setCountSubscriptionsBounce(
            final Integer pCountSubscriptionsBounce) {
        this.countSubscriptionsBounce = pCountSubscriptionsBounce;
    }

    /**
     * Gets the count of people subscribed to the email list.
     *
     * @return The count of people subscribed to the email list.
     */
    public Integer getCountSubscriptionsSpam() {
        return countSubscriptionsSpam;
    }

    /**
     * Sets the count of people subscribed to the email list.
     *
     * @param pCountSubscriptionsSpam The count of people subscribed to
     *                                the email list.
     */
    public void setCountSubscriptionsSpam(
            final Integer pCountSubscriptionsSpam) {
        this.countSubscriptionsSpam = pCountSubscriptionsSpam;
    }

    /**
     * Gets the count of people subscribed to the email list.
     *
     * @return The count of people subscribed to the email list.
     */
    public Integer getCountSubscriptionsUnsubscribed() {
        return countSubscriptionsUnsubscribed;
    }

    /**
     * Sets the count of people subscribed to the email list.
     *
     * @param pCountSubscriptionsUnsubscribed The count of people subscribed
     *                                       to the email list.
     */
    public void setCountSubscriptionsUnsubscribed(
            final Integer pCountSubscriptionsUnsubscribed) {
        this.countSubscriptionsUnsubscribed = pCountSubscriptionsUnsubscribed;
    }

    /**
     * Gets the unique identifier for the email list.
     *
     * @return The unique identifier for the email list.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the unique identifier for the email list.
     *
     * @param pUid The unique identifier for the email list.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Gets the date and time when the email list was created.
     *
     * @return The date and time when the email list was created.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the date and time when the email list was created.
     *
     * @param pCreated The date and time when the email list was created.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Gets the date and time when the email list was last updated.
     *
     * @return The date and time when the email list was last updated.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the date and time when the email list was last updated.
     *
     * @param pUpdated The date and time when the email list was last updated.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * Compares the EmailList instance with another object.
     *
     * @param other The other object.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof EmailList)) {
            return false;
        }

        EmailList otherEmailList = (EmailList) other;

        return Objects.equals(this.uid, otherEmailList.uid);
    }

    /**
     * Returns the hash code for the EmailList instance.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
