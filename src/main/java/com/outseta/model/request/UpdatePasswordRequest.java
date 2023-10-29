package com.outseta.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;

/**
 * This class represent a request to update password.
 */
public final class UpdatePasswordRequest implements BaseInput {

    /**
     * A customized builder for the UpdatePasswordRequest.
     */
    public static class Builder {

        /**
         * The instance of UpdatePasswordRequest to be built.
         */
        private UpdatePasswordRequest updatePasswordRequest;

        /**
         * The constructor of the builder class.
         */
        public Builder() {
            updatePasswordRequest = new UpdatePasswordRequest();
        }

        /**
         * Sets the existing password.
         * @param pExistingPassword The existing password.
         * @return The UpdatePasswordRequest instance.
         */
        public Builder existingPassword(final String pExistingPassword) {
            updatePasswordRequest.existingPassword = pExistingPassword;
            return this;
        }

        /**
         * Sets the new password.
         * @param pNewPassword The new password.
         * @return The UpdatePasswordRequest instance.
         */
        public Builder newPassword(final String pNewPassword) {
            updatePasswordRequest.newPassword = pNewPassword;
            return this;
        }

        /**
         * Builds the UpdatePasswordRequest instance.
         * @return The UpdatePasswordRequest instance.
         */
        public UpdatePasswordRequest build() {
            return updatePasswordRequest;
        }

    }

    /**
     * The existing password.
     */
    @JsonProperty("ExistingPassword")
    private String existingPassword;

    /**
     * The new password.
     */
    @JsonProperty("NewPassword")
    private String newPassword;

    /**
     * Creates a new builder instance.
     * @return A new builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The constructor is intentionally private to enforce Builder usage.
     */
    private UpdatePasswordRequest() { }

    /**
     * Gets the existing password.
     * @return The existing password.
     */
    public String getExistingPassword() {
        return existingPassword;
    }

    /**
     * Sets the existing password.
     * @param pExistingPassword The existing password.
     */
    public void setExistingPassword(final String pExistingPassword) {
        this.existingPassword = pExistingPassword;
    }

    /**
     * Gets the new password.
     * @return The new password.
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Sets the new password.
     * @param pNewPassword The new password.
     */
    public void setNewPassword(final String pNewPassword) {
        this.newPassword = pNewPassword;
    }
}
