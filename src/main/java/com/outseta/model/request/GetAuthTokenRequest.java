package com.outseta.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;

/**
 * This class is used to represent the data required to get an auth token.
 */
public final class GetAuthTokenRequest implements BaseInput {

    /**
     * This class is used to build a GetAuthTokenRequest object.
     */
    public static class Builder {

        /**
         * The username of the user to get an auth token for.
         */
        private String username;

        /**
         * The password of the user to get an auth token for.
         */
        private String password;

        /**
         * Returns the username of the user to get an auth token for.
         * @param pUsername The username of the user to get an auth token for.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder username(final String pUsername) {
            this.username = pUsername;
            return this;
        }

        /**
         * Returns the password of the user to get an auth token for.
         * @param pPassword The password of the user to get an auth token for.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder password(final String pPassword) {
            this.password = pPassword;
            return this;
        }

        /**
         * This method is used to create a new GetAuthTokenRequest object.
         * @return A new GetAuthTokenRequest object.
         */
        public GetAuthTokenRequest build() {
            GetAuthTokenRequest request = new GetAuthTokenRequest();
            request.username = this.username;
            request.password = this.password;
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
     * The username of the user to get an auth token for.
     */
    @JsonProperty("username")
    private String username;

    /**
     * The password of the user to get an auth token for.
     */
    @JsonProperty("password")
    private String password;

    /**
     * The default constructor is used to create a new GetAuthTokenRequest.
     */
    private GetAuthTokenRequest() { }

    /**
     * Returns the username of the user to get an auth token for.
     * @return The username of the user to get an auth token for.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user to get an auth token for.
     * @param pUsername The username of the user to get an auth token for.
     */
    public void setUsername(final String pUsername) {
        this.username = pUsername;
    }

    /**
     * Returns the password of the user to get an auth token for.
     * @return The password of the user to get an auth token for.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user to get an auth token for.
     * @param pPassword The password of the user to get an auth token for.
     */
    public void setPassword(final String pPassword) {
        this.password = pPassword;
    }
}
