package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Person implements BaseResult, BaseInput {

    public static class Builder {
        private Person person = new Person();

        public Builder email(String email) {
            person.email = email;
            return this;
        }

        public Builder firstName(String firstName) {
            person.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            person.lastName = lastName;
            return this;
        }

        public Builder mailingAddress(MailingAddress mailingAddress) {
            person.mailingAddress = mailingAddress;
            return this;
        }

        public Builder passwordLastUpdated(Date passwordLastUpdated) {
            person.passwordLastUpdated = passwordLastUpdated;
            return this;
        }

        public Builder passwordMustChange(Boolean passwordMustChange) {
            person.passwordMustChange = passwordMustChange;
            return this;
        }

        public Builder phoneMobile(String phoneMobile) {
            person.phoneMobile = phoneMobile;
            return this;
        }

        public Builder phoneWork(String phoneWork) {
            person.phoneWork = phoneWork;
            return this;
        }

        public Builder profileImageS3Url(String profileImageS3Url) {
            person.profileImageS3Url = profileImageS3Url;
            return this;
        }

        public Builder title(String title) {
            person.title = title;
            return this;
        }

        public Builder timezone(String timezone) {
            person.timezone = timezone;
            return this;
        }

        public Builder language(String language) {
            person.language = language;
            return this;
        }

        public Builder ipAddress(String ipAddress) {
            person.ipAddress = ipAddress;
            return this;
        }

        public Builder referer(String referer) {
            person.referer = referer;
            return this;
        }

        public Builder userAgent(String userAgent) {
            person.userAgent = userAgent;
            return this;
        }

        public Builder lastLoginDateTime(Date lastLoginDateTime) {
            person.lastLoginDateTime = lastLoginDateTime;
            return this;
        }

        public Builder oAuthGoogleProfileId(String oAuthGoogleProfileId) {
            person.oAuthGoogleProfileId = oAuthGoogleProfileId;
            return this;
        }

        public Builder personAccount(List<PersonAccount> personAccount) {
            person.personAccount = personAccount;
            return this;
        }

        public Builder emailBounceDateTime(Date emailBounceDateTime) {
            person.emailBounceDateTime = emailBounceDateTime;
            return this;
        }

        public Builder emailSpamDateTime(Date emailSpamDateTime) {
            person.emailSpamDateTime = emailSpamDateTime;
            return this;
        }

        public Builder emailUnsubscribeDateTime(Date emailUnsubscribeDateTime) {
            person.emailUnsubscribeDateTime = emailUnsubscribeDateTime;
            return this;
        }

        public Builder emailLastDeliveredDateTime(Date emailLastDeliveredDateTime) {
            person.emailLastDeliveredDateTime = emailLastDeliveredDateTime;
            return this;
        }

        public Builder fullName(String fullName) {
            person.fullName = fullName;
            return this;
        }

        public Builder uid(String uid) {
            person.uid = uid;
            return this;
        }

        public Builder created(Date created) {
            person.created = created;
            return this;
        }

        public Builder updated(Date updated) {
            person.updated = updated;
            return this;
        }

        public Person build() {
            // Add any validation logic here if needed
            return person;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonProperty("Email")
    private String email;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("MailingAddress")
    private MailingAddress mailingAddress;

    @JsonProperty("PasswordLastUpdated")
    private Date passwordLastUpdated;

    @JsonProperty("PasswordMustChange")
    private Boolean passwordMustChange;

    @JsonProperty("PhoneMobile")
    private String phoneMobile;

    @JsonProperty("PhoneWork")
    private String phoneWork;

    @JsonProperty("ProfileImageS3Url")
    private String profileImageS3Url;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Timezone")
    private String timezone;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("IPAddress")
    private String ipAddress;

    @JsonProperty("Referer")
    private String referer;

    @JsonProperty("UserAgent")
    private String userAgent;

    @JsonProperty("LastLoginDateTime")
    private Date lastLoginDateTime;

    @JsonProperty("OAuthGoogleProfileId")
    private String oAuthGoogleProfileId;

    @JsonProperty("PersonAccount")
    private List<PersonAccount> personAccount;

    @JsonProperty("EmailBounceDateTime")
    private Date emailBounceDateTime;

    @JsonProperty("EmailSpamDateTime")
    private Date emailSpamDateTime;

    @JsonProperty("EmailUnsubscribeDateTime")
    private Date emailUnsubscribeDateTime;

    @JsonProperty("EmailLastDeliveredDateTime")
    private Date emailLastDeliveredDateTime;

    @JsonProperty("FullName")
    private String fullName;

    @JsonProperty("Uid")
    private String uid;

    @JsonProperty("Created")
    private Date created;

    @JsonProperty("Updated")
    private Date updated;

    public Person() {
    }

    /**
     * This class implements the builder for the Person class.
     */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MailingAddress getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(MailingAddress mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public Date getPasswordLastUpdated() {
        return passwordLastUpdated;
    }

    public void setPasswordLastUpdated(Date passwordLastUpdated) {
        this.passwordLastUpdated = passwordLastUpdated;
    }

    public Boolean getPasswordMustChange() {
        return passwordMustChange;
    }

    public void setPasswordMustChange(Boolean passwordMustChange) {
        this.passwordMustChange = passwordMustChange;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getPhoneWork() {
        return phoneWork;
    }

    public void setPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
    }

    public String getProfileImageS3Url() {
        return profileImageS3Url;
    }

    public void setProfileImageS3Url(String profileImageS3Url) {
        this.profileImageS3Url = profileImageS3Url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Date getLastLoginDateTime() {
        return lastLoginDateTime;
    }

    public void setLastLoginDateTime(Date lastLoginDateTime) {
        this.lastLoginDateTime = lastLoginDateTime;
    }

    public String getoAuthGoogleProfileId() {
        return oAuthGoogleProfileId;
    }

    public void setoAuthGoogleProfileId(String oAuthGoogleProfileId) {
        this.oAuthGoogleProfileId = oAuthGoogleProfileId;
    }

    public List<PersonAccount> getPersonAccount() {
        return personAccount;
    }

    public void setPersonAccount(List<PersonAccount> personAccount) {
        this.personAccount = personAccount;
    }

    public Date getEmailBounceDateTime() {
        return emailBounceDateTime;
    }

    public void setEmailBounceDateTime(Date emailBounceDateTime) {
        this.emailBounceDateTime = emailBounceDateTime;
    }

    public Date getEmailSpamDateTime() {
        return emailSpamDateTime;
    }

    public void setEmailSpamDateTime(Date emailSpamDateTime) {
        this.emailSpamDateTime = emailSpamDateTime;
    }

    public Date getEmailUnsubscribeDateTime() {
        return emailUnsubscribeDateTime;
    }

    public void setEmailUnsubscribeDateTime(Date emailUnsubscribeDateTime) {
        this.emailUnsubscribeDateTime = emailUnsubscribeDateTime;
    }

    public Date getEmailLastDeliveredDateTime() {
        return emailLastDeliveredDateTime;
    }

    public void setEmailLastDeliveredDateTime(Date emailLastDeliveredDateTime) {
        this.emailLastDeliveredDateTime = emailLastDeliveredDateTime;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(email, person.email) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(mailingAddress, person.mailingAddress) &&
                Objects.equals(passwordLastUpdated, person.passwordLastUpdated) &&
                Objects.equals(passwordMustChange, person.passwordMustChange) &&
                Objects.equals(phoneMobile, person.phoneMobile) &&
                Objects.equals(phoneWork, person.phoneWork) &&
                Objects.equals(profileImageS3Url, person.profileImageS3Url) &&
                Objects.equals(title, person.title) &&
                Objects.equals(timezone, person.timezone) &&
                Objects.equals(language, person.language) &&
                Objects.equals(ipAddress, person.ipAddress) &&
                Objects.equals(referer, person.referer) &&
                Objects.equals(userAgent, person.userAgent) &&
                Objects.equals(lastLoginDateTime, person.lastLoginDateTime) &&
                Objects.equals(oAuthGoogleProfileId, person.oAuthGoogleProfileId) &&
                Objects.equals(personAccount, person.personAccount) &&
                Objects.equals(emailBounceDateTime, person.emailBounceDateTime) &&
                Objects.equals(emailSpamDateTime, person.emailSpamDateTime) &&
                Objects.equals(emailUnsubscribeDateTime, person.emailUnsubscribeDateTime) &&
                Objects.equals(emailLastDeliveredDateTime, person.emailLastDeliveredDateTime) &&
                Objects.equals(fullName, person.fullName) &&
                Objects.equals(uid, person.uid) &&
                Objects.equals(created, person.created) &&
                Objects.equals(updated, person.updated);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
