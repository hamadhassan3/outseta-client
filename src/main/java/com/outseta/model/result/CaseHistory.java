package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a case history.
 */
public class CaseHistory implements BaseInput, BaseResult {

    /**
     * The builder class for CaseHistory.
     */
    public static class Builder {

        /**
         * The CaseHistory object to be created.
         */
        private final CaseHistory caseHistory;

        /**
         * Constructs a new Builder.
         */
        public Builder() {
            this.caseHistory = new CaseHistory();
        }

        /**
         * Sets the date and time of the case history detail.
         *
         * @param historyDateTime The date and time of the case history detail.
         * @return The CaseHistoryDetailBuilder for method chaining.
         */
        public Builder historyDateTime(final Date historyDateTime) {
            caseHistory.setHistoryDateTime(historyDateTime);
            return this;
        }

        /**
         * Sets the associated case for the history detail.
         *
         * @param caseObject The associated case for the history detail.
         * @return The CaseHistoryDetailBuilder for method chaining.
         */
        public Builder caseObject(final Case caseObject) {
            caseHistory.setCaseObject(caseObject);
            return this;
        }

        /**
         * Sets the name of the agent associated with the history detail.
         *
         * @param agentName The name of the agent associated with the history
         *                  detail.
         * @return The CaseHistoryDetailBuilder for method chaining.
         */
        public Builder agentName(final String agentName) {
            caseHistory.setAgentName(agentName);
            return this;
        }

        /**
         * Sets the comment related to the history detail.
         *
         * @param comment The comment related to the history detail.
         * @return The CaseHistoryDetailBuilder for method chaining.
         */
        public Builder comment(final String comment) {
            caseHistory.setComment(comment);
            return this;
        }

        /**
         * Sets the type of the history detail.
         *
         * @param type The type of the history detail.
         * @return The CaseHistoryDetailBuilder for method chaining.
         */
        public Builder type(final Integer type) {
            caseHistory.setType(type);
            return this;
        }

        /**
         * Sets the date and time when the history detail was seen.
         *
         * @param seenDateTime The date and time when the history detail
         *                     was seen.
         * @return The CaseHistoryDetailBuilder for method chaining.
         */
        public Builder seenDateTime(final Date seenDateTime) {
            caseHistory.setSeenDateTime(seenDateTime);
            return this;
        }

        /**
         * Sets the date and time when the history detail was clicked.
         *
         * @param clickDateTime The date and time when the history detail
         *                      was clicked.
         * @return The CaseHistoryDetailBuilder for method chaining.
         */
        public Builder clickDateTime(final Date clickDateTime) {
            caseHistory.setClickDateTime(clickDateTime);
            return this;
        }

        /**
         * Sets the unique identifier for the history detail.
         *
         * @param uid The unique identifier for the history detail.
         * @return The CaseHistoryDetailBuilder for method chaining.
         */
        public Builder uid(final String uid) {
            caseHistory.setUid(uid);
            return this;
        }

        /**
         * Sets the date and time when the history detail was created.
         *
         * @param created The date and time when the history detail was created.
         * @return The CaseHistoryDetailBuilder for method chaining.
         */
        public Builder created(final Date created) {
            caseHistory.setCreated(created);
            return this;
        }

        /**
         * Sets the date and time when the history detail was last updated.
         *
         * @param updated The date and time when the history detail was
         *                last updated.
         * @return The CaseHistoryDetailBuilder for method chaining.
         */
        public Builder updated(final Date updated) {
            caseHistory.setUpdated(updated);
            return this;
        }

        /**
         * Builds the CaseHistory instance.
         *
         * @return The constructed CaseHistoryDetail.
         */
        public CaseHistory build() {
            return caseHistory;
        }
    }

    /**
     * Date and time of the case history detail.
     */
    @JsonProperty("HistoryDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date historyDateTime;

    /**
     * Associated case for the history detail.
     */
    @JsonProperty("Case")
    private Case caseObject;

    /**
     * Name of the agent associated with the history detail.
     */
    @JsonProperty("AgentName")
    private String agentName;

    /**
     * Comment related to the history detail.
     */
    @JsonProperty("Comment")
    private String comment;

    /**
     * Type of the history detail.
     */
    @JsonProperty("Type")
    private Integer type;

    /**
     * Date and time when the history detail was seen.
     */
    @JsonProperty("SeenDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date seenDateTime;

    /**
     * Date and time when the history detail was clicked.
     */
    @JsonProperty("ClickDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date clickDateTime;

    /**
     * Unique identifier for the history detail.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * Date and time when the history detail was created.
     */
    @JsonProperty("Created")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * Date and time when the history detail was last updated.
     */
    @JsonProperty("Updated")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updated;

    /**
     * This method is used to create a Builder object.
     * @return The Builder object.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Gets the date and time of the case history detail.
     *
     * @return The date and time of the case history detail.
     */
    public Date getHistoryDateTime() {
        return historyDateTime;
    }

    /**
     * Sets the date and time of the case history detail.
     *
     * @param pHistoryDateTime The date and time of the case history detail.
     */
    public void setHistoryDateTime(final Date pHistoryDateTime) {
        this.historyDateTime = pHistoryDateTime;
    }

    /**
     * Gets the associated case for the history detail.
     *
     * @return The associated case for the history detail.
     */
    public Case getCaseObject() {
        return caseObject;
    }

    /**
     * Sets the associated case for the history detail.
     *
     * @param pCase The associated case for the history detail.
     */
    public void setCaseObject(final Case pCase) {
        this.caseObject = pCase;
    }

    /**
     * Gets the name of the agent associated with the history detail.
     *
     * @return The name of the agent associated with the history detail.
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * Sets the name of the agent associated with the history detail.
     *
     * @param pAgentName The name of the agent associated with the history
     *                   detail.
     */
    public void setAgentName(final String pAgentName) {
        this.agentName = pAgentName;
    }

    /**
     * Gets the comment related to the history detail.
     *
     * @return The comment related to the history detail.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment related to the history detail.
     *
     * @param pComment The comment related to the history detail.
     */
    public void setComment(final String pComment) {
        this.comment = pComment;
    }

    /**
     * Gets the type of the history detail.
     *
     * @return The type of the history detail.
     */
    public Integer getType() {
        return type;
    }

    /**
     * Sets the type of the history detail.
     *
     * @param pType The type of the history detail.
     */
    public void setType(final Integer pType) {
        this.type = pType;
    }

    /**
     * Gets the date and time when the history detail was seen.
     *
     * @return The date and time when the history detail was seen.
     */
    public Date getSeenDateTime() {
        return seenDateTime;
    }

    /**
     * Sets the date and time when the history detail was seen.
     *
     * @param pSeenDateTime The date and time when the history detail was seen.
     */
    public void setSeenDateTime(final Date pSeenDateTime) {
        this.seenDateTime = pSeenDateTime;
    }

    /**
     * Gets the date and time when the history detail was clicked.
     *
     * @return The date and time when the history detail was clicked.
     */
    public Date getClickDateTime() {
        return clickDateTime;
    }

    /**
     * Sets the date and time when the history detail was clicked.
     *
     * @param pClickDateTime The date and time when the history detail was
     *                       clicked.
     */
    public void setClickDateTime(final Date pClickDateTime) {
        this.clickDateTime = pClickDateTime;
    }

    /**
     * Gets the unique identifier for the history detail.
     *
     * @return The unique identifier for the history detail.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the unique identifier for the history detail.
     *
     * @param pUid The unique identifier for the history detail.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Gets the date and time when the history detail was created.
     *
     * @return The date and time when the history detail was created.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the date and time when the history detail was created.
     *
     * @param pCreated The date and time when the history detail was created.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Gets the date and time when the history detail was last updated.
     *
     * @return The date and time when the history detail was last updated.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the date and time when the history detail was last updated.
     *
     * @param pUpdated The date and time when the history detail was last
     *                 updated.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * This method compares this object to another object.
     * @param other The other object.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (other instanceof CaseHistory) {
            return Objects.equals(uid, ((CaseHistory) other).uid);
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
