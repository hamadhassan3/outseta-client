package com.outseta.model.result;

import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Objects;

/**
 * This class represents a CaseReply.
 */
public class CaseReply implements BaseInput, BaseResult {

    /**
     * This class is used to build a CaseReply object.
     */
    public static class Builder {

        /**
         * The CaseReply object to be built.
         */
        private CaseReply caseReply;

        /**
         * This constructor is used to initialize the CaseReply object.
         */
        public Builder() {
            this.caseReply = new CaseReply();
        }

        /**
         * This method sets the agent name.
         * @param pAgentName The agent name.
         * @return The Builder object.
         */
        public Builder agentName(final String pAgentName) {
            this.caseReply.agentName = pAgentName;
            return this;
        }

        /**
         * This method sets the case object.
         * @param pCaseObject The case object.
         * @return The Builder object.
         */
        public Builder caseObject(final Case pCaseObject) {
            this.caseReply.caseObject = pCaseObject;
            return this;
        }

        /**
         * This method sets the comment.
         * @param pComment The comment.
         * @return The Builder object.
         */
        public Builder comment(final String pComment) {
            this.caseReply.comment = pComment;
            return this;
        }

        /**
         * This method builds the CaseReply object.
         * @return The CaseReply object.
         */
        public CaseReply build() {
            return this.caseReply;
        }
    }

    /**
     * The agent name.
     */
    private String agentName;

    /**
     * The case object.
     */
    private Case caseObject;

    /**
     * The comment.
     */
    private String comment;

    /**
     * This method is used to create a Builder object.
     * @return The Builder object.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Gets the agent name.
     * @return The agent name.
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * Sets the agent name.
     * @param pAgentName The agent name.
     */
    public void setAgentName(final String pAgentName) {
        this.agentName = pAgentName;
    }

    /**
     * Gets the case object.
     * @return The case object.
     */
    public Case getCaseObject() {
        return caseObject;
    }

    /**
     * Sets the case object.
     * @param pCaseObject The case object.
     */
    public void setCaseObject(final Case pCaseObject) {
        this.caseObject = pCaseObject;
    }

    /**
     * Gets the comment.
     * @return The comment.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment.
     * @param pComment The comment.
     */
    public void setComment(final String pComment) {
        this.comment = pComment;
    }

    /**
     * This method compares this object to another object.
     * @param other The other object.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (other instanceof CaseReply) {
            CaseReply otherCaseReply = (CaseReply) other;
            return Objects.equals(agentName, (otherCaseReply.agentName))
                    && Objects.equals(caseObject, otherCaseReply.caseObject)
                    && Objects.equals(comment, otherCaseReply.comment);
        }
        return false;
    }

    /**
     * This method returns the hash code for this object.
     * @return The hash code for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(agentName, caseObject, comment);
    }
}
