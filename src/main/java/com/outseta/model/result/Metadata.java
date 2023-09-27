package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseResult;

/**
 * This class is used to represent the data returned from the api
 * in the form of a page.
 * It represents the metadata for such a request and holds information
 * about the page.
 */
public class Metadata implements BaseResult {

    /**
     * The limit of the page.
     */
    @JsonProperty("limit")
    private int limit;

    /**
     * The offset of the page.
     */
    @JsonProperty("offset")
    private int offset;

    /**
     * The total number of items in the page.
     */
    @JsonProperty("total")
    private int total;

    /**
     * Default constructor for the creation of a Metadata object.
     */
    public Metadata() {
    }

    /**
     * Returns the limit of the page.
     * @return The limit of the page.
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the limit of the page.
     * @param pLimit The limit of the page.
     */
    public void setLimit(final int pLimit) {
        this.limit = pLimit;
    }

    /**
     * Returns the offset of the page.
     * @return The offset of the page.
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Sets the offset of the page.
     * @param pOffset The offset of the page.
     */
    public void setOffset(final int pOffset) {
        this.offset = pOffset;
    }

    /**
     * Returns the total number of items in the page.
     * @return The total number of items in the page.
     */
    public int getTotal() {
        return total;
    }

    /**
     * Sets the total number of items in the page.
     * @param pTotal The total number of items in the page.
     */
    public void setTotal(final int pTotal) {
        this.total = pTotal;
    }
}
