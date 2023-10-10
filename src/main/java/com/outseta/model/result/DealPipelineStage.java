package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

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
}
