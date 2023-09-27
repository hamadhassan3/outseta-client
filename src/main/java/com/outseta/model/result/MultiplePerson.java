package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseResult;

import java.util.List;

/**
 * This class is used to represent the data returned from an api in
 * the form of a list of Person objects.
 */
public class MultiplePerson implements BaseResult {

    /**
     * The metadata of the page.
     */
    @JsonProperty("metadata")
    private Metadata metadata;

    /**
     * The list of Person objects.
     */
    @JsonProperty("items")
    private List<Person> items;

    /**
     * Default constructor for the creation of a MultiplePerson object.
     */
    public MultiplePerson() {
    }

    /**
     * Returns the metadata of the page.
     * @return The metadata of the page.
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * Sets the metadata of the page.
     * @param pMetadata The metadata of the page.
     */
    public void setMetadata(final Metadata pMetadata) {
        this.metadata = pMetadata;
    }

    /**
     * Returns the list of Person objects.
     * @return The list of Person objects.
     */
    public List<Person> getItems() {
        return items;
    }

    /**
     * Sets the list of Person objects.
     * @param pItems The list of Person objects.
     */
    public void setItems(final List<Person> pItems) {
        this.items = pItems;
    }
}
