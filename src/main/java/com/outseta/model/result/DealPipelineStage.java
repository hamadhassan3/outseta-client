package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Objects;

/**
 * This class represents a Deal Pipeline Stage.
 */
public class DealPipelineStage implements BaseInput, BaseResult {

    /**
     * The name of the Deal Pipeline Stage.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * The constructor creates an empty object.
     */
    public DealPipelineStage() {

    }

    /**
     * The constructor creates an object using uid of the Deal Pipeline Stage.
     * @param pUid The uid of the Deal Pipeline Stage.
     */
    public DealPipelineStage(final String pUid) {
        this.uid = pUid;
    }

    /**
     * This method returns the uid of the Deal Pipeline Stage.
     * @return The uid of the Deal Pipeline Stage.
     */
    public String getUid() {
        return uid;
    }

    /**
     * This method sets the uid of the Deal Pipeline Stage.
     * @param pUid The uid of the Deal Pipeline Stage.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * This method compares this object to another object.
     * @param other The other object.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (other instanceof DealPipelineStage) {
            return Objects.equals(uid, ((DealPipelineStage) other).uid);
        }
        return false;
    }

    /**
     * This method returns the hash code for this object.
     * @return The hash code for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
