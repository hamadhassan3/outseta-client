package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseResult;

import java.util.Objects;

/**
 * This class is used to represent the data returned from the
 * {@link com.outseta.client.endpoint_client.AuthenticationClient} class.
 */
public class AuthToken implements BaseResult {

    /**
     * The access token returned from the API.
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * The token type returned from the API.
     */
    @JsonProperty("token_type")
    private String tokenType;

    /**
     * The number of seconds until the token expires.
     */
    @JsonProperty("expires_in")
    private Long expiresIn;

    /**
     * Default constructor for the creation of an AuthToken object.
     */
    public AuthToken() { }

    /**
     * Constructor for the creation of an AuthToken object.
     * @param pAccessToken The access token returned by API.
     * @param pTokenType The token type returned by API.
     * @param pExpiresIn The number of seconds until the token expires.
     */
    public AuthToken(final String pAccessToken, final String pTokenType,
                     final Long pExpiresIn) {
        this.accessToken = pAccessToken;
        this.tokenType = pTokenType;
        this.expiresIn = pExpiresIn;
    }

    /**
     * Returns the access token.
     * @return The access token.
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets the access token.
     * @param pAccessToken The access token.
     */
    public void setAccessToken(final String pAccessToken) {
        this.accessToken = pAccessToken;
    }

    /**
     * Returns the token type.
     * @return The token type.
     */
    public String getTokenType() {
        return tokenType;
    }

    /**
     * Sets the token type.
     * @param pTokenType The token type.
     */
    public void setTokenType(final String pTokenType) {
        this.tokenType = pTokenType;
    }

    /**
     * Returns the number of seconds until the token expires.
     * @return The number of seconds until the token expires.
     */
    public Long getExpiresIn() {
        return expiresIn;
    }

    /**
     * Sets the number of seconds until the token expires.
     * @param pExpiresIn The number of seconds until the token expires.
     */
    public void setExpiresIn(final Long pExpiresIn) {
        this.expiresIn = pExpiresIn;
    }

    /**
     * This method overrides the equals method.
     */
    @Override
    public boolean equals(final Object pObject) {
        if (this == pObject) {
            return true;
        }
        if (pObject == null || getClass() != pObject.getClass()) {
            return false;
        }

        final AuthToken authToken = (AuthToken) pObject;

        return Objects.equals(accessToken, authToken.accessToken)
                && Objects.equals(tokenType, authToken.tokenType)
                && Objects.equals(expiresIn, authToken.expiresIn);
    }

    /**
     * This method overrides the hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(accessToken, tokenType, expiresIn);
    }
}
