package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseResult;

public class Person extends BaseResult {

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Email2")
    private String email2;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("MailingAddress")
    private MailingAddress mailingAddress;

    public Person() {
    }

    public Person(String email, String email2, String firstName, String lastName, MailingAddress mailingAddress) {
        this.email = email;
        this.email2 = email2;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailingAddress = mailingAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
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
}
