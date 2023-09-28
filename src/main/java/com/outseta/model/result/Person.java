package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * This class is used to represent the data returned from the api
 * in the form of a Person object.
 * It is also used as input for the apis that require a Person object.
 */
public class Person implements BaseResult, BaseInput {

    /**
     * This class implements the builder for the Person class.
     */
    public static class Builder {

        /**
         * The Person object that is being built.
         */
        private Person person;

        /**
         * This constructor initializes the Person object that is being built.
         */
        public Builder() {
            person = new Person();
        }

        /**
         * This method sets the email of the Person object that is being built.
         *
         * @param pEmail The email to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder email(final String pEmail) {
            person.email = pEmail;
            return this;
        }

        /**
         * This method sets the first name of the Person object that is being
         * built.
         *
         * @param pFirstName The first name to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder firstName(final String pFirstName) {
            person.firstName = pFirstName;
            return this;
        }

        /**
         * This method sets the last name of the Person object that is being
         * built.
         *
         * @param pLastName The last name to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder lastName(final String pLastName) {
            person.lastName = pLastName;
            return this;
        }

        /**
         * This method sets the mailing address of the Person object that is
         * being built.
         *
         * @param pMailingAddress The mailing address to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder mailingAddress(final MailingAddress pMailingAddress) {
            person.mailingAddress = pMailingAddress;
            return this;
        }

        /**
         * This method sets the password last updated of the Person object that
         * is being built.
         *
         * @param pPasswordLastUpdated The password last updated to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder passwordLastUpdated(final Date pPasswordLastUpdated) {
            person.passwordLastUpdated = pPasswordLastUpdated;
            return this;
        }

        /**
         * This method sets the password must change of the Person object that
         * is being built.
         *
         * @param pPasswordMustChange The password must change to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder passwordMustChange(final Boolean pPasswordMustChange) {
            person.passwordMustChange = pPasswordMustChange;
            return this;
        }

        /**
         * This method sets the mobile phone of the Person object that is being
         * built.
         *
         * @param pPhoneMobile The mobile phone to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder phoneMobile(final String pPhoneMobile) {
            person.phoneMobile = pPhoneMobile;
            return this;
        }

        /**
         * This method sets the work phone of the Person object that is being
         * built.
         *
         * @param pPhoneWork The work phone to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder phoneWork(final String pPhoneWork) {
            person.phoneWork = pPhoneWork;
            return this;
        }

        /**
         * This method sets the profile image S3 url of the Person object that
         * is being built.
         *
         * @param pProfileImageS3Url The profile image S3 url to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder profileImageS3Url(final String pProfileImageS3Url) {
            person.profileImageS3Url = pProfileImageS3Url;
            return this;
        }

        /**
         * This method sets the title of the Person object that is being built.
         *
         * @param pTitle The title to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder title(final String pTitle) {
            person.title = pTitle;
            return this;
        }

        /**
         * This method sets the timezone of the Person object that is being
         * built.
         *
         * @param pTimezone The timezone to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder timezone(final String pTimezone) {
            person.timezone = pTimezone;
            return this;
        }

        /**
         * This method sets the language of the Person object that is being
         * built.
         *
         * @param pLanguage The language to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder language(final String pLanguage) {
            person.language = pLanguage;
            return this;
        }

        /**
         * This method sets the ip address of the Person object that is being
         * built.
         *
         * @param pIpAddress The ip address to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder ipAddress(final String pIpAddress) {
            person.ipAddress = pIpAddress;
            return this;
        }

        /**
         * This method sets the referer of the Person object that is being
         * built.
         *
         * @param pReferer The referer to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder referer(final String pReferer) {
            person.referer = pReferer;
            return this;
        }

        /**
         * This method sets the user agent of the Person object that is being
         * built.
         *
         * @param pUserAgent The user agent to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder userAgent(final String pUserAgent) {
            person.userAgent = pUserAgent;
            return this;
        }

        /**
         * This method sets the last login date time of the Person object that
         * is being built.
         *
         * @param pLastLoginDateTime The last login date time to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder lastLoginDateTime(final Date pLastLoginDateTime) {
            person.lastLoginDateTime = pLastLoginDateTime;
            return this;
        }

        /**
         * This method sets the OAuth google profile id of the Person object
         * that is being built.
         *
         * @param pOAuthGoogleProfileId The OAuth google profile id to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder oAuthGoogleProfileId(
                final String pOAuthGoogleProfileId) {
            person.oAuthGoogleProfileId = pOAuthGoogleProfileId;
            return this;
        }

        /**
         * This method sets the person account of the Person object that is
         * being built.
         *
         * @param pPersonAccount The person account to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder personAccount(final List<PersonAccount> pPersonAccount) {
            person.personAccount = pPersonAccount;
            return this;
        }

        /**
         * This method sets the email bounce date time of the Person object
         * that is being built.
         *
         * @param pEmailBounceDateTime The email bounce date time to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder emailBounceDateTime(final Date pEmailBounceDateTime) {
            person.emailBounceDateTime = pEmailBounceDateTime;
            return this;
        }

        /**
         * This method sets the email spam date time of the Person object that
         * is being built.
         *
         * @param pEmailSpamDateTime The email spam date time to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder emailSpamDateTime(final Date pEmailSpamDateTime) {
            person.emailSpamDateTime = pEmailSpamDateTime;
            return this;
        }

        /**
         * This method sets the email unsubscribe date time of the Person
         * object that is being built.
         *
         * @param pEmailUnsubscribeDateTime The email unsubscribe date time to
         *                                  set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder emailUnsubscribeDateTime(
                final Date pEmailUnsubscribeDateTime) {
            person.emailUnsubscribeDateTime = pEmailUnsubscribeDateTime;
            return this;
        }

        /**
         * This method sets the email last delivered date time of the Person
         * object that is being built.
         *
         * @param pEmailLastDeliveredDateTime The email last delivered date
         *                                    time to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder emailLastDeliveredDateTime(
                final Date pEmailLastDeliveredDateTime) {
            person.emailLastDeliveredDateTime = pEmailLastDeliveredDateTime;
            return this;
        }

        /**
         * This method sets the full name of the Person object that is being
         * built.
         *
         * @param pFullName The full name to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder fullName(final String pFullName) {
            person.fullName = pFullName;
            return this;
        }

        /**
         * This method sets the uid of the Person object that is being built.
         *
         * @param pUid The uid to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder uid(final String pUid) {
            person.uid = pUid;
            return this;
        }

        /**
         * This method sets the created date of the Person object that is being
         * built.
         *
         * @param pCreated The created date to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder created(final Date pCreated) {
            person.created = pCreated;
            return this;
        }

        /**
         * This method sets the updated date of the Person object that is being
         * built.
         *
         * @param pUpdated The updated date to set.
         * @return The Builder object so that methods can be chained.
         */
        public Builder updated(final Date pUpdated) {
            person.updated = pUpdated;
            return this;
        }

        /**
         * This method builds the Person object.
         *
         * @return The Person object.
         */
        public Person build() {
            // Add any validation logic here if needed
            return person;
        }
    }

    /**
     * This method returns a new Builder object that is used to build a Person
     * object.
     *
     * @return The new Builder object.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The email of the Person object.
     */
    @JsonProperty("Email")
    private String email;

    /**
     * The first name of the Person object.
     */
    @JsonProperty("FirstName")
    private String firstName;

    /**
     * The last name of the Person object.
     */
    @JsonProperty("LastName")
    private String lastName;

    /**
     * The mailing address of the Person object.
     */
    @JsonProperty("MailingAddress")
    private MailingAddress mailingAddress;

    /**
     * The password last updated of the Person object.
     */
    @JsonProperty("PasswordLastUpdated")
    private Date passwordLastUpdated;

    /**
     * The password must change of the Person object.
     */
    @JsonProperty("PasswordMustChange")
    private Boolean passwordMustChange;

    /**
     * The mobile phone of the Person object.
     */
    @JsonProperty("PhoneMobile")
    private String phoneMobile;

    /**
     * The work phone of the Person object.
     */
    @JsonProperty("PhoneWork")
    private String phoneWork;

    /**
     * The profile image S3 url of the Person object.
     */
    @JsonProperty("ProfileImageS3Url")
    private String profileImageS3Url;

    /**
     * The title of the Person object.
     */
    @JsonProperty("Title")
    private String title;

    /**
     * The timezone of the Person object.
     */
    @JsonProperty("Timezone")
    private String timezone;

    /**
     * The language of the Person object.
     */
    @JsonProperty("Language")
    private String language;

    /**
     * The ip address of the Person object.
     */
    @JsonProperty("IPAddress")
    private String ipAddress;

    /**
     * The referer of the Person object.
     */
    @JsonProperty("Referer")
    private String referer;

    /**
     * The user agent of the Person object.
     */
    @JsonProperty("UserAgent")
    private String userAgent;

    /**
     * The last login date time of the Person object.
     */
    @JsonProperty("LastLoginDateTime")
    private Date lastLoginDateTime;

    /**
     * The OAuth google profile id of the Person object.
     */
    @JsonProperty("OAuthGoogleProfileId")
    private String oAuthGoogleProfileId;

    /**
     * The person account of the Person object.
     */
    @JsonProperty("PersonAccount")
    private List<PersonAccount> personAccount;

    /**
     * The email bounce date time of the Person object.
     */
    @JsonProperty("EmailBounceDateTime")
    private Date emailBounceDateTime;

    /**
     * The email spam date time of the Person object.
     */
    @JsonProperty("EmailSpamDateTime")
    private Date emailSpamDateTime;

    /**
     * The email unsubscribe date time of the Person object.
     */
    @JsonProperty("EmailUnsubscribeDateTime")
    private Date emailUnsubscribeDateTime;

    /**
     * The email last delivered date time of the Person object.
     */
    @JsonProperty("EmailLastDeliveredDateTime")
    private Date emailLastDeliveredDateTime;

    /**
     * The full name of the Person object.
     */
    @JsonProperty("FullName")
    private String fullName;

    /**
     * The uid of the Person object.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * The created date of the Person object.
     */
    @JsonProperty("Created")
    private Date created;

    /**
     * The updated date of the Person object.
     */
    @JsonProperty("Updated")
    private Date updated;

    /**
     * This constructor initializes the Person object.
     */
    public Person() {
    }

    /**
     * Returns the email of the Person object.
     * @return The email of the Person object.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the Person object.
     * @param pEmail The email to set.
     */
    public void setEmail(final String pEmail) {
        this.email = pEmail;
    }

    /**
     * Returns the first name of the Person object.
     * @return The first name of the Person object.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the Person object.
     * @param pFirstName The first name to set.
     */
    public void setFirstName(final String pFirstName) {
        this.firstName = pFirstName;
    }

    /**
     * Returns the last name of the Person object.
     * @return The last name of the Person object.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the Person object.
     * @param pLastName The last name to set.
     */
    public void setLastName(final String pLastName) {
        this.lastName = pLastName;
    }

    /**
     * Returns the mailing address of the Person object.
     * @return The mailing address of the Person object.
     */
    public MailingAddress getMailingAddress() {
        return mailingAddress;
    }

    /**
     * Sets the mailing address of the Person object.
     * @param pMailingAddress The mailing address to set.
     */
    public void setMailingAddress(final MailingAddress pMailingAddress) {
        this.mailingAddress = pMailingAddress;
    }

    /**
     * Returns the password last updated of the Person object.
     * @return The password last updated of the Person object.
     */
    public Date getPasswordLastUpdated() {
        return passwordLastUpdated;
    }

    /**
     * Sets the password last updated of the Person object.
     * @param pPasswordLastUpdated The password last updated to set.
     */
    public void setPasswordLastUpdated(final Date pPasswordLastUpdated) {
        this.passwordLastUpdated = pPasswordLastUpdated;
    }

    /**
     * Returns the password must change of the Person object.
     * @return The password must change of the Person object.
     */
    public Boolean getPasswordMustChange() {
        return passwordMustChange;
    }

    /**
     * Sets the password must change of the Person object.
     * @param pPasswordMustChange The password must change to set.
     */
    public void setPasswordMustChange(final Boolean pPasswordMustChange) {
        this.passwordMustChange = pPasswordMustChange;
    }

    /**
     * Returns the mobile phone of the Person object.
     * @return The mobile phone of the Person object.
     */
    public String getPhoneMobile() {
        return phoneMobile;
    }

    /**
     * Sets the mobile phone of the Person object.
     * @param pPhoneMobile The mobile phone to set.
     */
    public void setPhoneMobile(final String pPhoneMobile) {
        this.phoneMobile = pPhoneMobile;
    }

    /**
     * Returns the work phone of the Person object.
     * @return The work phone of the Person object.
     */
    public String getPhoneWork() {
        return phoneWork;
    }

    /**
     * Sets the work phone of the Person object.
     * @param pPhoneWork The work phone to set.
     */
    public void setPhoneWork(final String pPhoneWork) {
        this.phoneWork = pPhoneWork;
    }

    /**
     * Returns the profile image S3 url of the Person object.
     * @return The profile image S3 url of the Person object.
     */
    public String getProfileImageS3Url() {
        return profileImageS3Url;
    }

    /**
     * Sets the profile image S3 url of the Person object.
     * @param pProfileImageS3Url The profile image S3 url to set.
     */
    public void setProfileImageS3Url(final String pProfileImageS3Url) {
        this.profileImageS3Url = pProfileImageS3Url;
    }

    /**
     * Returns the title of the Person object.
     * @return The title of the Person object.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the Person object.
     * @param pTitle The title to set.
     */
    public void setTitle(final String pTitle) {
        this.title = pTitle;
    }

    /**
     * Returns the timezone of the Person object.
     * @return The timezone of the Person object.
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Sets the timezone of the Person object.
     * @param pTimezone The timezone to set.
     */
    public void setTimezone(final String pTimezone) {
        this.timezone = pTimezone;
    }

    /**
     * Returns the language of the Person object.
     * @return The language of the Person object.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the language of the Person object.
     * @param pLanguage The language to set.
     */
    public void setLanguage(final String pLanguage) {
        this.language = pLanguage;
    }

    /**
     * Returns the ip address of the Person object.
     * @return The ip address of the Person object.
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Sets the ip address of the Person object.
     * @param pIpAddress The ip address to set.
     */
    public void setIpAddress(final String pIpAddress) {
        this.ipAddress = pIpAddress;
    }

    /**
     * Returns the referer of the Person object.
     * @return The referer of the Person object.
     */
    public String getReferer() {
        return referer;
    }

    /**
     * Sets the referer of the Person object.
     * @param pReferer The referer to set.
     */
    public void setReferer(final String pReferer) {
        this.referer = pReferer;
    }

    /**
     * Returns the user agent of the Person object.
     * @return The user agent of the Person object.
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Sets the user agent of the Person object.
     * @param pUserAgent The user agent to set.
     */
    public void setUserAgent(final String pUserAgent) {
        this.userAgent = pUserAgent;
    }

    /**
     * Returns the last login date time of the Person object.
     * @return The last login date time of the Person object.
     */
    public Date getLastLoginDateTime() {
        return lastLoginDateTime;
    }

    /**
     * Sets the last login date time of the Person object.
     * @param pLastLoginDateTime The last login date time to set.
     */
    public void setLastLoginDateTime(final Date pLastLoginDateTime) {
        this.lastLoginDateTime = pLastLoginDateTime;
    }

    /**
     * Returns the OAuth google profile id of the Person object.
     * @return The OAuth google profile id of the Person object.
     */
    public String getoAuthGoogleProfileId() {
        return oAuthGoogleProfileId;
    }

    /**
     * Sets the OAuth google profile id of the Person object.
     * @param pOAuthGoogleProfileId The OAuth google profile id to set.
     */
    public void setoAuthGoogleProfileId(final String pOAuthGoogleProfileId) {
        this.oAuthGoogleProfileId = pOAuthGoogleProfileId;
    }

    /**
     * Returns the person account of the Person object.
     * @return The person account of the Person object.
     */
    public List<PersonAccount> getPersonAccount() {
        return personAccount;
    }

    /**
     * Sets the person account of the Person object.
     * @param pPersonAccount The person account to set.
     */
    public void setPersonAccount(final List<PersonAccount> pPersonAccount) {
        this.personAccount = pPersonAccount;
    }

    /**
     * Returns the email bounce date time of the Person object.
     * @return The email bounce date time of the Person object.
     */
    public Date getEmailBounceDateTime() {
        return emailBounceDateTime;
    }

    /**
     * Sets the email bounce date time of the Person object.
     * @param pEmailBounceDateTime The email bounce date time to set.
     */
    public void setEmailBounceDateTime(final Date pEmailBounceDateTime) {
        this.emailBounceDateTime = pEmailBounceDateTime;
    }

    /**
     * Returns the email spam date time of the Person object.
     * @return The email spam date time of the Person object.
     */
    public Date getEmailSpamDateTime() {
        return emailSpamDateTime;
    }

    /**
     * Sets the email spam date time of the Person object.
     * @param pEmailSpamDateTime The email spam date time to set.
     */
    public void setEmailSpamDateTime(final Date pEmailSpamDateTime) {
        this.emailSpamDateTime = pEmailSpamDateTime;
    }

    /**
     * Returns the email unsubscribe date time of the Person object.
     * @return The email unsubscribe date time of the Person object.
     */
    public Date getEmailUnsubscribeDateTime() {
        return emailUnsubscribeDateTime;
    }

    /**
     * Sets the email unsubscribe date time of the Person object.
     * @param pEmailUnsubscribeDateTime The email unsubscribe date time to set.
     */
    public void setEmailUnsubscribeDateTime(
            final Date pEmailUnsubscribeDateTime) {
        this.emailUnsubscribeDateTime = pEmailUnsubscribeDateTime;
    }

    /**
     * Returns the email last delivered date time of the Person object.
     * @return The email last delivered date time of the Person object.
     */
    public Date getEmailLastDeliveredDateTime() {
        return emailLastDeliveredDateTime;
    }

    /**
     * Sets the email last delivered date time of the Person object.
     * @param pEmailLastDeliveredDateTime The email last delivered date time to
     *                                    set.
     */
    public void setEmailLastDeliveredDateTime(
            final Date pEmailLastDeliveredDateTime) {
        this.emailLastDeliveredDateTime = pEmailLastDeliveredDateTime;
    }

    /**
     * Returns the full name of the Person object.
     * @return The full name of the Person object.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the Person object.
     * @param pFullName The full name to set.
     */
    public void setFullName(final String pFullName) {
        this.fullName = pFullName;
    }

    /**
     * Returns the uid of the Person object.
     * @return The uid of the Person object.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the uid of the Person object.
     * @param pUid The uid to set.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Returns the created date of the Person object.
     * @return The created date of the Person object.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the created date of the Person object.
     * @param pCreated The created date to set.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Returns the updated date of the Person object.
     * @return The updated date of the Person object.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the updated date of the Person object.
     * @param pUpdated The updated date to set.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * This method compares this Person object to the specified object.
     * @param o The object to compare this Person object against.
     * @return True if the given object represents a Person equivalent to this,
     *          false otherwise.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(email, person.email)
                && Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName)
                && Objects.equals(mailingAddress, person.mailingAddress)
                && Objects.equals(passwordLastUpdated,
                    person.passwordLastUpdated)
                && Objects.equals(passwordMustChange, person.passwordMustChange)
                && Objects.equals(phoneMobile, person.phoneMobile)
                && Objects.equals(phoneWork, person.phoneWork)
                && Objects.equals(profileImageS3Url, person.profileImageS3Url)
                && Objects.equals(title, person.title)
                && Objects.equals(timezone, person.timezone)
                && Objects.equals(language, person.language)
                && Objects.equals(ipAddress, person.ipAddress)
                && Objects.equals(referer, person.referer)
                && Objects.equals(userAgent, person.userAgent)
                && Objects.equals(lastLoginDateTime, person.lastLoginDateTime)
                && Objects.equals(oAuthGoogleProfileId,
                    person.oAuthGoogleProfileId)
                && Objects.equals(personAccount, person.personAccount)
                && Objects.equals(emailBounceDateTime,
                    person.emailBounceDateTime)
                && Objects.equals(emailSpamDateTime, person.emailSpamDateTime)
                && Objects.equals(emailUnsubscribeDateTime,
                    person.emailUnsubscribeDateTime)
                && Objects.equals(emailLastDeliveredDateTime,
                    person.emailLastDeliveredDateTime)
                && Objects.equals(fullName, person.fullName)
                && Objects.equals(uid, person.uid)
                && Objects.equals(created, person.created)
                && Objects.equals(updated, person.updated);
    }

    /**
     * This method returns the hash code for this Person object.
     * @return The hash code for this Person object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, mailingAddress,
                passwordLastUpdated, passwordMustChange, phoneMobile,
                phoneWork, profileImageS3Url, title, timezone, language,
                ipAddress, referer, userAgent, lastLoginDateTime,
                oAuthGoogleProfileId, personAccount, emailBounceDateTime,
                emailSpamDateTime, emailUnsubscribeDateTime,
                emailLastDeliveredDateTime, fullName, uid, created, updated);
    }
}
