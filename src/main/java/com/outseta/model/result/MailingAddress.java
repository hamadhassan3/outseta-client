package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.Objects;

public class MailingAddress implements BaseResult, BaseInput {

    public static class Builder {
        private MailingAddress mailingAddress = new MailingAddress();

        public Builder addressLine1(String addressLine1) {
            mailingAddress.addressLine1 = addressLine1;
            return this;
        }

        public Builder addressLine2(String addressLine2) {
            mailingAddress.addressLine2 = addressLine2;
            return this;
        }

        public Builder addressLine3(String addressLine3) {
            mailingAddress.addressLine3 = addressLine3;
            return this;
        }

        public Builder city(String city) {
            mailingAddress.city = city;
            return this;
        }

        public Builder state(String state) {
            mailingAddress.state = state;
            return this;
        }

        public Builder postalCode(String postalCode) {
            mailingAddress.postalCode = postalCode;
            return this;
        }

        public Builder country(String country) {
            mailingAddress.country = country;
            return this;
        }

        public Builder geoLocation(Object geoLocation) {
            mailingAddress.geoLocation = geoLocation;
            return this;
        }

        public Builder activityEventData(Object activityEventData) {
            mailingAddress.activityEventData = activityEventData;
            return this;
        }

        public Builder uid(String uid) {
            mailingAddress.uid = uid;
            return this;
        }

        public Builder created(Date created) {
            mailingAddress.created = created;
            return this;
        }

        public Builder updated(Date updated) {
            mailingAddress.updated = updated;
            return this;
        }

        public MailingAddress build() {
            // Add any validation logic here if needed
            return mailingAddress;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @JsonProperty("AddressLine1")
    private String addressLine1;
    @JsonProperty("AddressLine2")
    private String addressLine2;
    @JsonProperty("AddressLine3")
    private String addressLine3;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("PostalCode")
    private String postalCode;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("GeoLocation")
    private Object geoLocation;
    @JsonProperty("ActivityEventData")
    private Object activityEventData;
    @JsonProperty("Uid")
    private String uid;
    @JsonProperty("Created")
    private Date created;
    @JsonProperty("Updated")
    private Date updated;

    public MailingAddress() {
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(Object geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Object getActivityEventData() {
        return activityEventData;
    }

    public void setActivityEventData(Object activityEventData) {
        this.activityEventData = activityEventData;
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

}
