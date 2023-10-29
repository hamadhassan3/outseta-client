package com.outseta.client.endpoint_client;

import com.outseta.client.BaseClient;
import com.outseta.client.ClientBuilder;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.OutsetaParseException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.model.request.UpdatePasswordRequest;
import com.outseta.model.result.Person;

import java.util.HashMap;

/**
 * This class is used to make calls to the Profile endpoints of the
 * Outseta API.
 * <p>
 *     The Profile endpoints are used to manage profiles of
 *     users. The class provides a builder to make it easier to construct
 *     the client.
 * </p>
 */
public final class ProfileClient extends BaseClient {

    /**
     * A customized builder for the client.
     */
    public static final class Builder
            extends ClientBuilder<ProfileClient> {

        /**
         * The constructor to create an object of ProfileClient.Builder.
         *
         * @param client The client to build.
         * @throws OutsetaClientBuildException Thrown if the client cannot be
         *                                     built.
         */
        public Builder(final ProfileClient client)
                throws OutsetaClientBuildException {
            super(client);
        }

        @Override
        public ClientBuilder<ProfileClient> apiKey(final String apiKey)
                throws OutsetaClientBuildException {

            // This is overridden so that the client cannot be built with an
            // api key. Profile endpoints are only executable with an access
            // token.
            throw new OutsetaClientBuildException(
                    "The ProfileClient cannot be built with an api key.");
        }
    }

    /**
     * This method is used to get a builder that can be used to build a
     * ProfileClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build an ProfileClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static Builder builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new Builder(new ProfileClient(baseUrl));
    }

    /**
     * The constructor creates a new Profile client with the base url.
     * It is intentionally private to force the use of the builder.
     *
     * @param pBaseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    private ProfileClient(final String pBaseUrl)
            throws OutsetaClientBuildException {
        super(pBaseUrl);
    }

    /**
     * Use this method to retrieve the profile information of a user. Please
     * note that you can not call this method with the API keys. You'll need to
     * call it with the auth token generated from the Get Auth token method.
     * Make sure to construct the auth token as described in the Getting started
     * >> Client Side section.
     *
     * Reference:
     * https://documenter.getpostman.com/view/3613332/outseta-rest-api-v1/
     * 7TNfr6k
     *
     * @return The profile.
     * @throws OutsetaParseException            Thrown if the profile cannot be
     *                                          parsed.
     * @throws OutsetaInvalidResponseCodeException Thrown if the response code
     *                                          is invalid.
     * @throws OutsetaAPIBadRequestException    Thrown if the request is bad.
     * @throws OutsetaAPIFailedException        Thrown if the request fails.
     * @throws OutsetaAPIUnknownException       Thrown if the request fails for
     *                                          an unknown reason.
     * @throws OutsetaInvalidURLException       Thrown if the url is invalid.
     *
     * Example usage:
     * <pre>{@code
     * // Get the auth token before calling the profile api.
     * AuthenticationClient authClient = AuthenticationClient
     *      .builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * GetAuthTokenRequest request = GetAuthTokenRequest.builder().build();
     * AuthToken token = authClient.getAuthToken(request);
     *
     * ProfileClient client = ProfileClient.builder(outsetaUrl)
     *      .accessToken(token.getAccessToken())    // Use access token instead
     *                                              // of api key.
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Profile profile = client.getProfile();
     * }</pre>
     */
    public Person getProfile()
            throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaParseException {

        String result = this.get("/profile",
                new HashMap<>());

        return this.getParserFacade().jsonStringToObject(result, Person.class);
    }

    /**
     * Use this method to update the profile information of a user.
     *
     * Please note that you can not call this method with the API keys. You'll
     * need to call it with the auth token generated from the Get Auth token
     * method. Make sure to construct the auth token as described in the
     * Getting started >> Client Side section.
     *
     * Also, the body of the request needs to include the UID property that
     * matches the person that you generated the token for.
     *
     * Reference:
     * https://documenter.getpostman.com/view/3613332/outseta-rest-api-v1/
     * 7TNfr6k
     *
     * @param profile The profile to update.
     * @return The profile.
     * @throws OutsetaInvalidArgumentException Thrown if the profile is null.
     * @throws OutsetaParseException            Thrown if the profile cannot be
     *                                          parsed.
     * @throws OutsetaInvalidResponseCodeException Thrown if the response code
     *                                          is invalid.
     * @throws OutsetaAPIBadRequestException    Thrown if the request is bad.
     * @throws OutsetaAPIFailedException        Thrown if the request fails.
     * @throws OutsetaAPIUnknownException       Thrown if the request fails for
     *                                          an unknown reason.
     * @throws OutsetaInvalidURLException       Thrown if the url is invalid.
     *
     * Example usage:
     * <pre>{@code
     * // Get the auth token before calling the profile api.
     * AuthenticationClient authClient = AuthenticationClient
     *      .builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * GetAuthTokenRequest request = GetAuthTokenRequest.builder().build();
     * AuthToken token = authClient.getAuthToken(request);
     *
     * ProfileClient client = ProfileClient.builder(outsetaUrl)
     *      .accessToken(token.getAccessToken())    // Use access token instead
     *                                              // of api key.
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Person profile = client.getProfile();
     * profile.setFirstName("John");
     * Profile profile = client.updateProfile(profile);
     * }</pre>
     */
    public Person updateProfile(final Person profile)
            throws OutsetaInvalidArgumentException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaParseException {

        if (profile == null) {
            throw new OutsetaInvalidArgumentException(
                    "The profile cannot be null.");
        }

        String result = this.put("/profile",
                new HashMap<>(),
                this.getParserFacade().objectToJsonString(profile));

        return this.getParserFacade().jsonStringToObject(result, Person.class);
    }

    /**
     * Use this method to update the password for a user. Please note that you
     * can not call this method with the API keys. You'll need to call it with
     * the auth token generated from the Get Auth token method. Make sure to
     * construct the auth token as described in the Getting started >> Client
     * Side section.
     *
     * Reference:
     * https://documenter.getpostman.com/view/3613332/outseta-rest-api-v1/
     * 7TNfr6k
     *
     * @param updatePasswordRequest The update password request.
     * @throws OutsetaInvalidArgumentException Thrown if the request is null.
     * @throws OutsetaParseException            Thrown if the profile cannot be
     *                                          parsed.
     * @throws OutsetaInvalidResponseCodeException Thrown if the response code
     *                                          is invalid.
     * @throws OutsetaAPIBadRequestException    Thrown if the request is bad.
     * @throws OutsetaAPIFailedException        Thrown if the request fails.
     * @throws OutsetaAPIUnknownException       Thrown if the request fails for
     *                                          an unknown reason.
     * @throws OutsetaInvalidURLException       Thrown if the url is invalid.
     *
     * Example usage:
     * <pre>{@code
     * // Get the auth token before calling the profile api.
     * AuthenticationClient authClient = AuthenticationClient
     *      .builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * GetAuthTokenRequest request = GetAuthTokenRequest.builder().build();
     * AuthToken token = authClient.getAuthToken(request);
     *
     * ProfileClient client = ProfileClient.builder(outsetaUrl)
     *      .accessToken(token.getAccessToken())    // Use access token instead
     *                                              // of api key.
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Profile profile = client.updateProfile();
     * }</pre>
     */
    public void updatePassword(
            final UpdatePasswordRequest updatePasswordRequest)
            throws OutsetaInvalidArgumentException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaParseException {

        if (updatePasswordRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "The UpdatePasswordRequest cannot be null.");
        }

        this.put("/profile/password",
                new HashMap<>(),
                this.getParserFacade()
                        .objectToJsonString(updatePasswordRequest));
    }
}
