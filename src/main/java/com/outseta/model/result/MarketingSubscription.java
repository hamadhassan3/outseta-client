package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.Objects;

/**
 * This class is used to represent a marketing subscriber.
 */
public class MarketingSubscription implements BaseInput, BaseResult {

    /**
     * This class is used to build a MarketingSubscriber instance.
     */
    public static class Builder {

        /**
         * The MarketingSubscriber instance to build.
         */
        private final MarketingSubscription marketingSubscription;

        /**
         * Constructs a new MarketingSubscriberBuilder.
         */
        public Builder() {
            this.marketingSubscription = new MarketingSubscription();
        }

        /**
         * Sets the person information.
         *
         * @param person The person information.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder person(final Person person) {
            marketingSubscription.setPerson(person);
            return this;
        }

        /**
         * Sets the email list information.
         *
         * @param emailList The email list information.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder emailList(final EmailList emailList) {
            marketingSubscription.setEmailList(emailList);
            return this;
        }

        /**
         * Sets the email list subscriber status.
         *
         * @param emailListSubscriberStatus The email list subscriber status.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder emailListSubscriberStatus(
                final Integer emailListSubscriberStatus) {
            marketingSubscription
                    .setEmailListSubscriberStatus(emailListSubscriberStatus);
            return this;
        }

        /**
         * Sets the date when the subscriber subscribed.
         *
         * @param subscribedDate The date when the subscriber subscribed.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder subscribedDate(final Date subscribedDate) {
            marketingSubscription.setSubscribedDate(subscribedDate);
            return this;
        }

        // Other builder methods...

        /**
         * Sets the date when the subscriber was confirmed.
         *
         * @param confirmedDate The date when the subscriber was confirmed.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder confirmedDate(final Date confirmedDate) {
            marketingSubscription.setConfirmedDate(confirmedDate);
            return this;
        }

        /**
         * Sets the date when the subscriber unsubscribed.
         *
         * @param unsubscribedDate The date when the subscriber unsubscribed.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder unsubscribedDate(final Date unsubscribedDate) {
            marketingSubscription.setUnsubscribedDate(unsubscribedDate);
            return this;
        }

        /**
         * Sets the date when the subscriber was cleaned.
         *
         * @param cleanedDate The date when the subscriber was cleaned.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder cleanedDate(final Date cleanedDate) {
            marketingSubscription.setCleanedDate(cleanedDate);
            return this;
        }

        /**
         * Sets the date and time when the welcome email was delivered.
         *
         * @param welcomeEmailDeliverDateTime The date and time when the
         *                                    welcome email was delivered.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder welcomeEmailDeliverDateTime(
                final Date welcomeEmailDeliverDateTime) {
            marketingSubscription.setWelcomeEmailDeliverDateTime(
                    welcomeEmailDeliverDateTime);
            return this;
        }

        /**
         * Sets the date and time when the welcome email was opened.
         *
         * @param welcomeEmailOpenDateTime The date and time when the welcome
         *                                 email was opened.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder welcomeEmailOpenDateTime(
                final Date welcomeEmailOpenDateTime) {
            marketingSubscription.setWelcomeEmailOpenDateTime(
                    welcomeEmailOpenDateTime);
            return this;
        }

        /**
         * Sets the reason for unsubscribing.
         *
         * @param unsubscribeReason The reason for unsubscribing.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder unsubscribeReason(final String unsubscribeReason) {
            marketingSubscription.setUnsubscribeReason(unsubscribeReason);
            return this;
        }

        /**
         * Sets the other reason for unsubscribing.
         *
         * @param unsubscribeReasonOther The other reason for unsubscribing.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder unsubscribeReasonOther(
                final String unsubscribeReasonOther) {
            marketingSubscription.setUnsubscribeReasonOther(
                    unsubscribeReasonOther);
            return this;
        }

        /**
         * Sets whether to send a welcome email.
         *
         * @param sendWelcomeEmail True if a welcome email should be sent,
         *                         false otherwise.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder sendWelcomeEmail(final Boolean sendWelcomeEmail) {
            marketingSubscription.setSendWelcomeEmail(sendWelcomeEmail);
            return this;
        }

        /**
         * Sets the unique identifier for the marketing subscriber.
         *
         * @param uid The unique identifier for the marketing subscriber.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder uid(final String uid) {
            marketingSubscription.setUid(uid);
            return this;
        }

        /**
         * Sets the date and time when the marketing subscriber was created.
         *
         * @param created The date and time when the marketing subscriber was
         *               created.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder created(final Date created) {
            marketingSubscription.setCreated(created);
            return this;
        }

        /**
         * Sets the date and time when the marketing subscriber was last
         * updated.
         *
         * @param updated The date and time when the marketing subscriber was
         *                last updated.
         * @return The MarketingSubscriberBuilder for method chaining.
         */
        public Builder updated(final Date updated) {
            marketingSubscription.setUpdated(updated);
            return this;
        }

        /**
         * Builds the {@link MarketingSubscription} instance.
         *
         * @return The constructed MarketingSubscriber.
         */
        public MarketingSubscription build() {
            return marketingSubscription;
        }
    }

    /**
     * Person information.
     */
    @JsonProperty("Person")
    private Person person;

    /**
     * EmailList information.
     */
    @JsonProperty("EmailList")
    private EmailList emailList;

    /**
     * Email list subscriber status.
     */
    @JsonProperty("EmailListSubscriberStatus")
    private Integer emailListSubscriberStatus;

    /**
     * Date when the subscriber subscribed.
     */
    @JsonProperty("SubscribedDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date subscribedDate;

    /**
     * Date when the subscriber was confirmed.
     */
    @JsonProperty("ConfirmedDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date confirmedDate;

    /**
     * Date when the subscriber unsubscribed.
     */
    @JsonProperty("UnsubscribedDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date unsubscribedDate;

    /**
     * Date when the subscriber was cleaned.
     */
    @JsonProperty("CleanedDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date cleanedDate;

    /**
     * Date and time when the welcome email was delivered.
     */
    @JsonProperty("WelcomeEmailDeliverDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date welcomeEmailDeliverDateTime;

    /**
     * Date and time when the welcome email was opened.
     */
    @JsonProperty("WelcomeEmailOpenDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date welcomeEmailOpenDateTime;

    /**
     * Reason for unsubscribing.
     */
    @JsonProperty("UnsubscribeReason")
    private String unsubscribeReason;

    /**
     * Other reason for unsubscribing.
     */
    @JsonProperty("UnsubscribeReasonOther")
    private String unsubscribeReasonOther;

    /**
     * Flag indicating whether to send a welcome email.
     */
    @JsonProperty("SendWelcomeEmail")
    private Boolean sendWelcomeEmail;

    /**
     * Unique identifier for the marketing subscriber.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * Date and time when the marketing subscriber was created.
     */
    @JsonProperty("Created")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * Date and time when the marketing subscriber was last updated.
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
     * Gets the person information.
     *
     * @return The person information.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the person information.
     *
     * @param pPerson The person information.
     */
    public void setPerson(final Person pPerson) {
        this.person = pPerson;
    }

    /**
     * Gets the email list information.
     *
     * @return The email list information.
     */
    public EmailList getEmailList() {
        return emailList;
    }

    /**
     * Sets the email list information.
     *
     * @param pEmailList The email list information.
     */
    public void setEmailList(final EmailList pEmailList) {
        this.emailList = pEmailList;
    }

    /**
     * Gets the email list subscriber status.
     *
     * @return The email list subscriber status.
     */
    public Integer getEmailListSubscriberStatus() {
        return emailListSubscriberStatus;
    }

    /**
     * Sets the email list subscriber status.
     *
     * @param pEmailListSubscriberStatus The email list subscriber status.
     */
    public void setEmailListSubscriberStatus(
            final Integer pEmailListSubscriberStatus) {
        this.emailListSubscriberStatus = pEmailListSubscriberStatus;
    }

    /**
     * Gets the date when the subscriber subscribed.
     *
     * @return The date when the subscriber subscribed.
     */
    public Date getSubscribedDate() {
        return subscribedDate;
    }

    /**
     * Sets the date when the subscriber subscribed.
     *
     * @param pSubscribedDate The date when the subscriber subscribed.
     */
    public void setSubscribedDate(final Date pSubscribedDate) {
        this.subscribedDate = pSubscribedDate;
    }

    /**
     * Gets the date when the subscriber was confirmed.
     *
     * @return The date when the subscriber was confirmed.
     */
    public Date getConfirmedDate() {
        return confirmedDate;
    }

    /**
     * Sets the date when the subscriber was confirmed.
     *
     * @param pConfirmedDate The date when the subscriber was confirmed.
     */
    public void setConfirmedDate(final Date pConfirmedDate) {
        this.confirmedDate = pConfirmedDate;
    }

    /**
     * Gets the date when the subscriber unsubscribed.
     *
     * @return The date when the subscriber unsubscribed.
     */
    public Date getUnsubscribedDate() {
        return unsubscribedDate;
    }

    /**
     * Sets the date when the subscriber unsubscribed.
     *
     * @param pUnsubscribedDate The date when the subscriber unsubscribed.
     */
    public void setUnsubscribedDate(final Date pUnsubscribedDate) {
        this.unsubscribedDate = pUnsubscribedDate;
    }

    /**
     * Gets the date when the subscriber was cleaned.
     *
     * @return The date when the subscriber was cleaned.
     */
    public Date getCleanedDate() {
        return cleanedDate;
    }

    /**
     * Sets the date when the subscriber was cleaned.
     *
     * @param pCleanedDate The date when the subscriber was cleaned.
     */
    public void setCleanedDate(final Date pCleanedDate) {
        this.cleanedDate = pCleanedDate;
    }

    /**
     * Gets the date and time when the welcome email was delivered.
     *
     * @return The date and time when the welcome email was delivered.
     */
    public Date getWelcomeEmailDeliverDateTime() {
        return welcomeEmailDeliverDateTime;
    }

    /**
     * Sets the date and time when the welcome email was delivered.
     *
     * @param pWelcomeEmailDeliverDateTime The date and time when the welcome
     *                                     email was delivered.
     */
    public void setWelcomeEmailDeliverDateTime(
            final Date pWelcomeEmailDeliverDateTime) {
        this.welcomeEmailDeliverDateTime = pWelcomeEmailDeliverDateTime;
    }

    /**
     * Gets the date and time when the welcome email was opened.
     *
     * @return The date and time when the welcome email was opened.
     */
    public Date getWelcomeEmailOpenDateTime() {
        return welcomeEmailOpenDateTime;
    }

    /**
     * Sets the date and time when the welcome email was opened.
     *
     * @param pWelcomeEmailOpenDateTime The date and time when the
     *                                  welcome email was opened.
     */
    public void setWelcomeEmailOpenDateTime(
            final Date pWelcomeEmailOpenDateTime) {
        this.welcomeEmailOpenDateTime = pWelcomeEmailOpenDateTime;
    }

    /**
     * Gets the reason for unsubscribing.
     *
     * @return The reason for unsubscribing.
     */
    public String getUnsubscribeReason() {
        return unsubscribeReason;
    }

    /**
     * Sets the reason for unsubscribing.
     *
     * @param pUnsubscribeReason The reason for unsubscribing.
     */
    public void setUnsubscribeReason(final String pUnsubscribeReason) {
        this.unsubscribeReason = pUnsubscribeReason;
    }

    /**
     * Gets the other reason for unsubscribing.
     *
     * @return The other reason for unsubscribing.
     */
    public String getUnsubscribeReasonOther() {
        return unsubscribeReasonOther;
    }

    /**
     * Sets the other reason for unsubscribing.
     *
     * @param pUnsubscribeReasonOther The other reason for unsubscribing.
     */
    public void setUnsubscribeReasonOther(
            final String pUnsubscribeReasonOther) {
        this.unsubscribeReasonOther = pUnsubscribeReasonOther;
    }

    /**
     * Gets whether to send a welcome email.
     *
     * @return True if a welcome email should be sent, false otherwise.
     */
    public Boolean getSendWelcomeEmail() {
        return sendWelcomeEmail;
    }

    /**
     * Sets whether to send a welcome email.
     *
     * @param pSendWelcomeEmail True if a welcome email should be sent,
     *                          false otherwise.
     */
    public void setSendWelcomeEmail(final Boolean pSendWelcomeEmail) {
        this.sendWelcomeEmail = pSendWelcomeEmail;
    }

    /**
     * Gets the unique identifier for the marketing subscriber.
     *
     * @return The unique identifier for the marketing subscriber.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the unique identifier for the marketing subscriber.
     *
     * @param pUid The unique identifier for the marketing subscriber.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Gets the date and time when the marketing subscriber was created.
     *
     * @return The date and time when the marketing subscriber was created.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the date and time when the marketing subscriber was created.
     *
     * @param pCreated The date and time when the marketing subscriber was
     *                 created.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Gets the date and time when the marketing subscriber was last updated.
     *
     * @return The date and time when the marketing subscriber was last updated.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the date and time when the marketing subscriber was last updated.
     *
     * @param pUpdated The date and time when the marketing subscriber was last
     *                updated.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * Compares the MarketingSubscriber instance with another object.
     *
     * @param other The other object.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof MarketingSubscription)) {
            return false;
        }

        MarketingSubscription otherMarketingSubscription =
                (MarketingSubscription) other;

        return Objects.equals(this.uid, otherMarketingSubscription.uid);
    }

    /**
     * Returns the hash code for the MarketingSubscriber instance.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
