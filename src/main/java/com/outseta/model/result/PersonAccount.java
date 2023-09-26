package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseResult;

import java.util.Date;

public class PersonAccount implements BaseResult {

    @JsonProperty("Person")
    private Person person;
    @JsonProperty("Account")
    private Object account;
    @JsonProperty("IsPrimary")
    private Boolean isPrimary;
    @JsonProperty("ReceiveInvoices")
    private Boolean receiveInvoices;
    @JsonProperty("ActivityEventData")
    private Object activityEventData;
    @JsonProperty("Uid")
    private String uid;
    @JsonProperty("Created")
    private Date created;
    @JsonProperty("Updated")
    private Date updated;

    public PersonAccount() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }

    public Boolean getReceiveInvoices() {
        return receiveInvoices;
    }

    public void setReceiveInvoices(Boolean receiveInvoices) {
        this.receiveInvoices = receiveInvoices;
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
