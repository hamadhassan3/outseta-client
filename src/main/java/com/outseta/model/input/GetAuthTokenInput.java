package com.outseta.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;

public class GetAuthTokenInput extends BaseInput {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    public GetAuthTokenInput(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
