package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

/**
 * This class represents a Person in a Deal.
 */
public class DealPerson implements BaseResult, BaseInput {

    /**
     * The person object.
     */
    @JsonProperty("Person")
    private Person person;

    /**
     * This constructor is used to initialize the person object.
     * @param pPerson The person object.
     */
    public DealPerson(final Person pPerson) {
        this.person = pPerson;
    }

    /**
     * This method returns the person object.
     * @return The person object.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * This method sets the person object.
     * @param pPerson The person object.
     */
    public void setPerson(final Person pPerson) {
        this.person = pPerson;
    }
}
