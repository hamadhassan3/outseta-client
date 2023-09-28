package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseResult;
import com.outseta.model.DataComponent;

import java.util.List;
import java.util.Objects;

/**
 * This class is used to represent the data returned from an api in
 * the form of a list of Person objects.
 * @param <T> The type of the list of objects.
 */
public class ItemPage<T extends DataComponent> implements BaseResult {

    /**
     * The metadata of the page.
     */
    @JsonProperty("metadata")
    private Metadata metadata;

    /**
     * The list of Person objects.
     */
    @JsonProperty("items")
    private List<T> items;

    /**
     * Default constructor for the creation of a MultiplePerson object.
     */
    public ItemPage() {
    }

    /**
     * Constructor for the creation of a MultiplePerson object.
     * @param pMetadata The metadata of the page.
     * @param pItems The list of Person objects.
     */
    public ItemPage(final Metadata pMetadata, final List<T> pItems) {
        this.metadata = pMetadata;
        this.items = pItems;
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
    public List<T> getItems() {
        return items;
    }

    /**
     * Sets the list of Person objects.
     * @param pItems The list of Person objects.
     */
    public void setItems(final List<T> pItems) {
        this.items = pItems;
    }

    /**
     * This method overrides the equals method.
     */
    @Override
    public boolean equals(final Object other) {

        if (other == this) {
            return true;
        }

        if (!(other instanceof ItemPage otherPage)) {
            return false;
        }

        return otherPage.getMetadata().equals(this.metadata)
                && otherPage.getItems().equals(this.items);
    }

    /**
     * This method overrides the hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(metadata, items);
    }
}
