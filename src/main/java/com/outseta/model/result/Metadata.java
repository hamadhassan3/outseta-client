package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseResult;

import java.util.Objects;

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
    private Integer limit;

    /**
     * The offset of the page.
     */
    @JsonProperty("offset")
    private Integer offset;

    /**
     * The total number of items in the page.
     */
    @JsonProperty("total")
    private Integer total;

    /**
     * Default constructor for the creation of a Metadata object.
     */
    public Metadata() {
    }

    /**
     * Constructor for the creation of a Metadata object.
     * @param pLimit The limit of the page.
     * @param pOffset The offset of the page.
     * @param pTotal The total number of items in the page.
     */
    public Metadata(final Integer pLimit, final Integer pOffset,
                    final Integer pTotal) {
        this.limit = pLimit;
        this.offset = pOffset;
        this.total = pTotal;
    }

    /**
     * Returns the limit of the page.
     * @return The limit of the page.
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Sets the limit of the page.
     * @param pLimit The limit of the page.
     */
    public void setLimit(final Integer pLimit) {
        this.limit = pLimit;
    }

    /**
     * Returns the offset of the page.
     * @return The offset of the page.
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Sets the offset of the page.
     * @param pOffset The offset of the page.
     */
    public void setOffset(final Integer pOffset) {
        this.offset = pOffset;
    }

    /**
     * Returns the total number of items in the page.
     * @return The total number of items in the page.
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Sets the total number of items in the page.
     * @param pTotal The total number of items in the page.
     */
    public void setTotal(final Integer pTotal) {
        this.total = pTotal;
    }

    /**
     * This method overrides the equals method.
     */
    @Override
    public boolean equals(final Object other) {

        if (other == this) {
            return true;
        }
        if (other instanceof Metadata) {

            Metadata otherMetadata = (Metadata) other;

            return Objects.equals(this.limit, otherMetadata.limit)
                    && Objects.equals(this.offset, otherMetadata.offset)
                    && Objects.equals(this.total, otherMetadata.total);
        }

        return false;
    }

    /**
     * This method overrides the hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(limit, offset, total);
    }
}
