package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Objects;

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
     * The constructor creates an empty object.
     */
    public DealPerson() {

    }

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

    /**
     * This method compares this object to another object.
     * @param other The other object.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (other instanceof DealPerson) {
            return Objects.equals(person, ((DealPerson) other).person);
        }
        return false;
    }

    /**
     * This method returns the hash code for this object.
     * @return The hash code for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(person);
    }
}
