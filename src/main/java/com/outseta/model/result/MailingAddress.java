package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseResult;

public class MailingAddress extends BaseResult {

    @JsonProperty("Uid")
    private String uid;

    @JsonProperty("AddressLine1")
    private String addressLine1;

    @JsonProperty("AddressLine2")
    private String addressLine2;

    public MailingAddress() {
    }

    public MailingAddress(String uid, String addressLine1, String addressLine2) {
        this.uid = uid;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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
}
