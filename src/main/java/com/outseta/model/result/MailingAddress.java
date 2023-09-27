package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.Objects;

/**
 * This class is used to represent the data returned from APIs
 * inside the {@link com.outseta.model.result.Person} object.
 *
 * It is also used to represent the data sent to APIs that
 * expect a MailingAddress object.
 */
public class MailingAddress implements BaseResult, BaseInput {

    /**
     * This class is used to build a MailingAddress object.
     */
    public static class Builder {

        /**
         * The MailingAddress object that is being built.
         */
        private final MailingAddress mailingAddress;

        /**
         * Constructor for the Builder class.
         */
        public Builder() {
            mailingAddress = new MailingAddress();
        }

        /**
         * Sets the addressLine1 field of the MailingAddress object.
         * @param addressLine1 The addressLine1 field of the MailingAddress
         *                     object.
         * @return The Builder object so that methods can be chained.
         */
        public Builder addressLine1(final String addressLine1) {
            mailingAddress.addressLine1 = addressLine1;
            return this;
        }

        /**
         * Sets the addressLine2 field of the MailingAddress object.
         * @param addressLine2 The addressLine2 field of the MailingAddress
         *                     object.
         * @return The Builder object so that methods can be chained.
         */
        public Builder addressLine2(final String addressLine2) {
            mailingAddress.addressLine2 = addressLine2;
            return this;
        }

        /**
         * Sets the addressLine3 field of the MailingAddress object.
         * @param addressLine3 The addressLine3 field of the MailingAddress
         *                     object.
         * @return The Builder object so that methods can be chained.
         */
        public Builder addressLine3(final String addressLine3) {
            mailingAddress.addressLine3 = addressLine3;
            return this;
        }

        /**
         * Sets the city field of the MailingAddress object.
         * @param city The city field of the MailingAddress object.
         * @return The Builder object so that methods can be chained.
         */
        public Builder city(final String city) {
            mailingAddress.city = city;
            return this;
        }

        /**
         * Sets the state field of the MailingAddress object.
         * @param state The state field of the MailingAddress object.
         * @return The Builder object so that methods can be chained.
         */
        public Builder state(final String state) {
            mailingAddress.state = state;
            return this;
        }

        /**
         * Sets the postalCode field of the MailingAddress object.
         * @param postalCode The postalCode field of the MailingAddress
         *                   object.
         * @return The Builder object so that methods can be chained.
         */
        public Builder postalCode(final String postalCode) {
            mailingAddress.postalCode = postalCode;
            return this;
        }

        /**
         * Sets the country field of the MailingAddress object.
         * @param country The country field of the MailingAddress object.
         * @return The Builder object so that methods can be chained.
         */
        public Builder country(final String country) {
            mailingAddress.country = country;
            return this;
        }

        /**
         * Sets the geoLocation field of the MailingAddress object.
         * @param geoLocation The geoLocation field of the MailingAddress
         *                    object.
         * @return The Builder object so that methods can be chained.
         */
        public Builder geoLocation(final Object geoLocation) {
            mailingAddress.geoLocation = geoLocation;
            return this;
        }

        /**
         * Sets the activityEventData field of the MailingAddress object.
         * @param activityEventData The activityEventData field of the
         *                          MailingAddress object.
         * @return The Builder object so that methods can be chained.
         */
        public Builder activityEventData(final Object activityEventData) {
            mailingAddress.activityEventData = activityEventData;
            return this;
        }

        /**
         * Sets the uid field of the MailingAddress object.
         * @param uid The uid field of the MailingAddress object.
         * @return The Builder object so that methods can be chained.
         */
        public Builder uid(final String uid) {
            mailingAddress.uid = uid;
            return this;
        }

        /**
         * Sets the created field of the MailingAddress object.
         * @param created The created field of the MailingAddress object.
         * @return The Builder object so that methods can be chained.
         */
        public Builder created(final Date created) {
            mailingAddress.created = created;
            return this;
        }

        /**
         * Sets the updated field of the MailingAddress object.
         * @param updated The updated field of the MailingAddress object.
         * @return The Builder object so that methods can be chained.
         */
        public Builder updated(final Date updated) {
            mailingAddress.updated = updated;
            return this;
        }

        /**
         * Builds the MailingAddress object.
         * @return The MailingAddress object once its completely built.
         */
        public MailingAddress build() {
            return mailingAddress;
        }
    }

    /**
     * Returns a Builder object to build a MailingAddress object.
     * @return A Builder object to build a MailingAddress object.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Compares this MailingAddress object to another object.
     * @param o The object to compare this MailingAddress object to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MailingAddress that = (MailingAddress) o;

        // Using Objects for comparison because these fields can also be null
        return Objects.equals(addressLine1, that.addressLine1)
                && Objects.equals(addressLine2, that.addressLine2)
                && Objects.equals(addressLine3, that.addressLine3)
                && Objects.equals(city, that.city)
                && Objects.equals(state, that.state)
                && Objects.equals(postalCode, that.postalCode)
                && Objects.equals(country, that.country)
                && Objects.equals(geoLocation, that.geoLocation)
                && Objects.equals(activityEventData, that.activityEventData)
                && Objects.equals(uid, that.uid)
                && Objects.equals(created, that.created)
                && Objects.equals(updated, that.updated);
    }

    /**
     * Returns the hash code of this MailingAddress object.
     * @return The hash code of this MailingAddress object.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * The first address line in MailingAddress.
     */
    @JsonProperty("AddressLine1")
    private String addressLine1;

    /**
     * The second address line in MailingAddress.
     */
    @JsonProperty("AddressLine2")
    private String addressLine2;

    /**
     * The third address line in MailingAddress.
     */
    @JsonProperty("AddressLine3")
    private String addressLine3;

    /**
     * The city in MailingAddress.
     */
    @JsonProperty("City")
    private String city;

    /**
     * The state in MailingAddress.
     */
    @JsonProperty("State")
    private String state;

    /**
     * The postal code in MailingAddress.
     */
    @JsonProperty("PostalCode")
    private String postalCode;

    /**
     * The country in MailingAddress.
     */
    @JsonProperty("Country")
    private String country;

    /**
     * The geolocation in MailingAddress.
     * TODO: Replace with GeoLocation class once its created.
     */
    @JsonProperty("GeoLocation")
    private Object geoLocation;

    /**
     * The activity event data in MailingAddress.
     * TODO: Replace with ActivityEventData class once its created.
     */
    @JsonProperty("ActivityEventData")
    private Object activityEventData;

    /**
     * The uid in MailingAddress.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * The created date in MailingAddress.
     */
    @JsonProperty("Created")
    private Date created;

    /**
     * The updated date in MailingAddress.
     */
    @JsonProperty("Updated")
    private Date updated;

    /**
     * Default constructor for the creation of a MailingAddress object.
     */
    public MailingAddress() {
    }

    /**
     * Returns the first address line in MailingAddress.
     * @return The first address line in MailingAddress.
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the first address line in MailingAddress.
     * @param pAddressLine1 The first address line in MailingAddress.
     */
    public void setAddressLine1(final String pAddressLine1) {
        this.addressLine1 = pAddressLine1;
    }

    /**
     * Returns the second address line in MailingAddress.
     * @return The second address line in MailingAddress.
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the second address line in MailingAddress.
     * @param pAddressLine2 The second address line in MailingAddress.
     */
    public void setAddressLine2(final String pAddressLine2) {
        this.addressLine2 = pAddressLine2;
    }

    /**
     * Returns the third address line in MailingAddress.
     * @return The third address line in MailingAddress.
     */
    public String getAddressLine3() {
        return addressLine3;
    }

    /**
     * Sets the third address line in MailingAddress.
     * @param pAddressLine3 The third address line in MailingAddress.
     */
    public void setAddressLine3(final String pAddressLine3) {
        this.addressLine3 = pAddressLine3;
    }

    /**
     * Returns the city in MailingAddress.
     * @return The city in MailingAddress.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city in MailingAddress.
     * @param pCity The city in MailingAddress.
     */
    public void setCity(final String pCity) {
        this.city = pCity;
    }

    /**
     * Returns the state in MailingAddress.
     * @return The state in MailingAddress.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state in MailingAddress.
     * @param pState The state in MailingAddress.
     */
    public void setState(final String pState) {
        this.state = pState;
    }

    /**
     * Returns the postal code in MailingAddress.
     * @return The postal code in MailingAddress.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code in MailingAddress.
     * @param pPostalCode The postal code in MailingAddress.
     */
    public void setPostalCode(final String pPostalCode) {
        this.postalCode = pPostalCode;
    }

    /**
     * Returns the country in MailingAddress.
     * @return The country in MailingAddress.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country in MailingAddress.
     * @param pCountry The country in MailingAddress.
     */
    public void setCountry(final String pCountry) {
        this.country = pCountry;
    }

    /**
     * Returns the geolocation in MailingAddress.
     * @return The geolocation in MailingAddress.
     */
    public Object getGeoLocation() {
        return geoLocation;
    }

    /**
     * Sets the geolocation in MailingAddress.
     * @param pGeoLocation The geolocation in MailingAddress.
     */
    public void setGeoLocation(final Object pGeoLocation) {
        this.geoLocation = pGeoLocation;
    }

    /**
     * Returns the activity event data in MailingAddress.
     * @return The activity event data in MailingAddress.
     */
    public Object getActivityEventData() {
        return activityEventData;
    }

    /**
     * Sets the activity event data in MailingAddress.
     * @param pActivityEventData The activity event data in MailingAddress.
     */
    public void setActivityEventData(final Object pActivityEventData) {
        this.activityEventData = pActivityEventData;
    }

    /**
     * Returns the uid in MailingAddress.
     * @return The uid in MailingAddress.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the uid in MailingAddress.
     * @param pUid The uid in MailingAddress.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Returns the created date in MailingAddress.
     * @return The created date in MailingAddress.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the created date in MailingAddress.
     * @param pCreated The created date in MailingAddress.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Returns the updated date in MailingAddress.
     * @return The updated date in MailingAddress.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the updated date in MailingAddress.
     * @param pUpdated The updated date in MailingAddress.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

}
