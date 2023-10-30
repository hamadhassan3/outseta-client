package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.constant.CaseSource;
import com.outseta.constant.CaseStatus;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Represents a case history.
 */
public final class Case implements BaseInput, BaseResult {

    /**
     * A builder class for Case.
     */
    public static class Builder {

        /**
         * The Case object to be built.
         */
        private final Case caseObject;

        /**
         * Constructs a new CaseHistoryBuilder.
         */
        public Builder() {
            this.caseObject = new Case();
        }

        /**
         * Sets the date and time when the case was submitted.
         *
         * @param submittedDateTime The date and time when the case was
         *                          submitted.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder submittedDateTime(final Date submittedDateTime) {
            caseObject.setSubmittedDateTime(submittedDateTime);
            return this;
        }

        /**
         * Sets the person who submitted the case.
         *
         * @param fromPerson The person who submitted the case.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder fromPerson(final Person fromPerson) {
            caseObject.setFromPerson(fromPerson);
            return this;
        }

        /**
         * Sets the client identifier of the person to whom the case is
         * assigned.
         *
         * @param assignedToPersonClientIdentifier The client identifier of
         *                                         the person to whom the case
         *                                         is assigned.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder assignedToPersonClientIdentifier(
                final String assignedToPersonClientIdentifier) {
            caseObject.setAssignedToPersonClientIdentifier(
                    assignedToPersonClientIdentifier);
            return this;
        }

        /**
         * Sets the subject of the case.
         *
         * @param subject The subject of the case.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder subject(final String subject) {
            caseObject.setSubject(subject);
            return this;
        }

        /**
         * Sets the body of the case.
         *
         * @param body The body of the case.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder body(final String body) {
            caseObject.setBody(body);
            return this;
        }

        /**
         * Sets the user agent information.
         *
         * @param userAgent The user agent information.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder userAgent(final String userAgent) {
            caseObject.setUserAgent(userAgent);
            return this;
        }

        /**
         * Sets the status of the case.
         *
         * @param status The status of the case.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder status(final Integer status) {
            caseObject.setStatus(status);
            return this;
        }

        /**
         * Sets the status of the case.
         *
         * @param status The status of the case.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder status(final CaseStatus status) {
            caseObject.setStatus(status.getValue());
            return this;
        }

        /**
         * Sets the source of the case.
         *
         * @param source The source of the case.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder source(final Integer source) {
            caseObject.setSource(source);
            return this;
        }

        /**
         * Sets the source of the case.
         *
         * @param source The source of the case.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder source(final CaseSource source) {
            caseObject.setSource(source.getValue());
            return this;
        }

        /**
         * Sets the list of case histories.
         *
         * @param caseHistories The list of case histories.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder caseHistories(final List<CaseHistory> caseHistories) {
            caseObject.setCaseHistories(caseHistories);
            return this;
        }

        /**
         * Sets the unique identifier for the case.
         *
         * @param uid The unique identifier for the case.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder uid(final String uid) {
            caseObject.setUid(uid);
            return this;
        }

        /**
         * Sets the date and time when the case was created.
         *
         * @param created The date and time when the case was created.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder created(final Date created) {
            caseObject.setCreated(created);
            return this;
        }

        /**
         * Sets the date and time when the case was last updated.
         *
         * @param updated The date and time when the case was last updated.
         * @return The CaseHistoryBuilder for method chaining.
         */
        public Builder updated(final Date updated) {
            caseObject.setUpdated(updated);
            return this;
        }

        /**
         * Builds the Case instance.
         *
         * @return The constructed CaseHistory.
         */
        public Case build() {
            return caseObject;
        }
    }

    /**
     * Date and time when the case was submitted.
     */
    @JsonProperty("SubmittedDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date submittedDateTime;

    /**
     * Person who submitted the case.
     */
    @JsonProperty("FromPerson")
    private Person fromPerson;

    /**
     * Client identifier of the person to whom the case is assigned.
     */
    @JsonProperty("AssignedToPersonClientIdentifier")
    private String assignedToPersonClientIdentifier;

    /**
     * Subject of the case.
     */
    @JsonProperty("Subject")
    private String subject;

    /**
     * Body of the case.
     */
    @JsonProperty("Body")
    private String body;

    /**
     * User agent information.
     */
    @JsonProperty("UserAgent")
    private String userAgent;

    /**
     * Status of the case.
     */
    @JsonProperty("Status")
    private Integer status;

    /**
     * Source of the case.
     */
    @JsonProperty("Source")
    private Integer source;

    /**
     * List of case histories.
     */
    @JsonProperty("CaseHistories")
    private List<CaseHistory> caseHistories;

    /**
     * Unique identifier for the case.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * Date and time when the case was created.
     */
    @JsonProperty("Created")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * Date and time when the case was last updated.
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
     * Gets the date and time when the case was submitted.
     *
     * @return The date and time when the case was submitted.
     */
    public Date getSubmittedDateTime() {
        return submittedDateTime;
    }

    /**
     * Sets the date and time when the case was submitted.
     *
     * @param pSubmittedDateTime The date and time when the case was submitted.
     */
    public void setSubmittedDateTime(final Date pSubmittedDateTime) {
        this.submittedDateTime = pSubmittedDateTime;
    }

    /**
     * Gets the person who submitted the case.
     *
     * @return The person who submitted the case.
     */
    public Person getFromPerson() {
        return fromPerson;
    }

    /**
     * Sets the person who submitted the case.
     *
     * @param pFromPerson The person who submitted the case.
     */
    public void setFromPerson(final Person pFromPerson) {
        this.fromPerson = pFromPerson;
    }

    /**
     * Gets the client identifier of the person to whom the case is assigned.
     *
     * @return The client identifier of the person to whom the case is assigned.
     */
    public String getAssignedToPersonClientIdentifier() {
        return assignedToPersonClientIdentifier;
    }

    /**
     * Sets the client identifier of the person to whom the case is assigned.
     *
     * @param pAssignedToPersonClientIdentifier The client identifier of the
     *                                          person to whom the case
     *                                          is assigned.
     */
    public void setAssignedToPersonClientIdentifier(
            final String pAssignedToPersonClientIdentifier) {
        this.assignedToPersonClientIdentifier =
                pAssignedToPersonClientIdentifier;
    }

    /**
     * Gets the subject of the case.
     *
     * @return The subject of the case.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the subject of the case.
     *
     * @param pSubject The subject of the case.
     */
    public void setSubject(final String pSubject) {
        this.subject = pSubject;
    }

    /**
     * Gets the body of the case.
     *
     * @return The body of the case.
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the body of the case.
     *
     * @param pBody The body of the case.
     */
    public void setBody(final String pBody) {
        this.body = pBody;
    }

    /**
     * Gets the user agent information.
     *
     * @return The user agent information.
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Sets the user agent information.
     *
     * @param pUserAgent The user agent information.
     */
    public void setUserAgent(final String pUserAgent) {
        this.userAgent = pUserAgent;
    }

    /**
     * Gets the status of the case.
     *
     * @return The status of the case.
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets the status of the case.
     *
     * @param pStatus The status of the case.
     */
    public void setStatus(final Integer pStatus) {
        this.status = pStatus;
    }

    /**
     * Gets the source of the case.
     *
     * @return The source of the case.
     */
    public Integer getSource() {
        return source;
    }

    /**
     * Sets the source of the case.
     *
     * @param pSource The source of the case.
     */
    public void setSource(final Integer pSource) {
        this.source = pSource;
    }

    /**
     * Gets the list of case histories.
     *
     * @return The list of case histories.
     */
    public List<CaseHistory> getCaseHistories() {
        return caseHistories;
    }

    /**
     * Sets the list of case histories.
     *
     * @param pCaseHistories The list of case histories.
     */
    public void setCaseHistories(final List<CaseHistory> pCaseHistories) {
        this.caseHistories = pCaseHistories;
    }

    /**
     * Gets the unique identifier for the case.
     *
     * @return The unique identifier for the case.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the unique identifier for the case.
     *
     * @param pUid The unique identifier for the case.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Gets the date and time when the case was created.
     *
     * @return The date and time when the case was created.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets the date and time when the case was created.
     *
     * @param pCreated The date and time when the case was created.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Gets the date and time when the case was last updated.
     *
     * @return The date and time when the case was last updated.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Sets the date and time when the case was last updated.
     *
     * @param pUpdated The date and time when the case was last updated.
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
        if (other instanceof Case) {
            return Objects.equals(uid, ((Case) other).uid);
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
