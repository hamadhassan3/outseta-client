package com.outseta.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;

/**
 * This class is used to represent the data required to set a
 * temporary password.
 */
public final class TemporaryPasswordRequest implements BaseInput {

    /**
     * This class is used to build a TemporaryPasswordRequest object.
     */
    public static class Builder {

        /**
         * The temporary password to set.
         */
        private String temporaryPassword;

        /**
         * This constructor is used to create a new Builder object.
         * @param pTemporaryPassword The temporary password to set.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder temporaryPassword(final String pTemporaryPassword) {
            this.temporaryPassword = pTemporaryPassword;
            return this;
        }

        /**
         * This method is used to create a new TemporaryPasswordRequest object.
         * @return A new TemporaryPasswordRequest object.
         */
        public TemporaryPasswordRequest build() {
            TemporaryPasswordRequest request = new TemporaryPasswordRequest();
            request.temporaryPassword = this.temporaryPassword;
            return request;
        }
    }

    /**
     * This method is used to create a new builder object.
     * @return A new builder object.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The temporary password to set.
     */
    @JsonProperty("temporaryPassword")
    private String temporaryPassword;

    /**
     * This constructor is used to create a new TemporaryPasswordRequest object.
     */
    private TemporaryPasswordRequest() {
        // Private constructor for the builder
    }

    /**
     * Returns the temporary password to set.
     * @return The temporary password to set.
     */
    public String getTemporaryPassword() {
        return temporaryPassword;
    }

    /**
     * Sets the temporary password to set.
     * @param pTemporaryPassword The temporary password to set.
     */
    public void setTemporaryPassword(final String pTemporaryPassword) {
        this.temporaryPassword = pTemporaryPassword;
    }

}

