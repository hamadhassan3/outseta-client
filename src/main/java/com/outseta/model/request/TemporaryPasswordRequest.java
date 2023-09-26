package com.outseta.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;

public class TemporaryPasswordRequest implements BaseInput {
    @JsonProperty("temporaryPassword")
    private String temporaryPassword;

    private TemporaryPasswordRequest() {
        // Private constructor for the builder
    }

    // Getter for temporaryPassword (no setters because it's a one-time value)

    public String getTemporaryPassword() {
        return temporaryPassword;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String temporaryPassword;

        public Builder temporaryPassword(String temporaryPassword) {
            this.temporaryPassword = temporaryPassword;
            return this;
        }

        public TemporaryPasswordRequest build() {
            TemporaryPasswordRequest request = new TemporaryPasswordRequest();
            request.temporaryPassword = this.temporaryPassword;
            return request;
        }
    }
}

