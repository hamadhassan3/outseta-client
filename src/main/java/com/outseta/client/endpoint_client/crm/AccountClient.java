package com.outseta.client.endpoint_client.crm;

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
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.Account;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.PersonAccount;

import java.util.HashMap;

/**
 * This class is used to make calls to the Account endpoints of the
 * Outseta API.
 * <p>
 *     The Account endpoints are used to manage accounts. The class
 *     provides a builder to make it easier to construct the client.
 * </p>
 */
public final class AccountClient extends BaseClient {

    /**
     * This method is used to get a builder that can be used to build an
     * AccountClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build an AccountClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static ClientBuilder<AccountClient> builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new ClientBuilder<>(new AccountClient(baseUrl));
    }

    /**
     * The constructor creates a new Account client with the base url.
     * It is intentionally private to force the use of the builder.
     *
     * @param pBaseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    private AccountClient(final String pBaseUrl)
            throws OutsetaClientBuildException {
        super(pBaseUrl);
    }

    /**
     * This method is used to get an account by id.
     *
     * @param accountId The id of the account to get.
     * @return The account.
     * @throws OutsetaInvalidArgumentException Thrown if the account id is null.
     * @throws OutsetaParseException            Thrown if the account cannot be
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
     * AccountClient client = AccountClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * String accountId = "accountId";
     * Account account = client.getAccount(accountId);
     * }</pre>
     */
    public Account getAccount(final String accountId)
            throws OutsetaInvalidArgumentException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaAPIFailedException,
            OutsetaAPIUnknownException, OutsetaParseException {

        if (accountId == null || accountId.isBlank()) {
            throw new OutsetaInvalidArgumentException(
                    "Account id cannot be null.");
        }

        String result = this.get("/crm/accounts/" + accountId,
                new HashMap<>());

        return this.getParserFacade().jsonStringToObject(result, Account.class);
    }

    /**
     * This method is used to get a page of Account objects.
     *
     * @param accountPageRequest The page request to use.
     * @return The list of accounts.
     * @throws OutsetaInvalidResponseCodeException Thrown if the response code
     *                                             is invalid.
     * @throws OutsetaAPIBadRequestException       Thrown if the request is bad.
     * @throws OutsetaAPIFailedException           Thrown if the request fails.
     * @throws OutsetaAPIUnknownException          Thrown if the request fails
     *                                             for an unknown reason.
     * @throws OutsetaInvalidURLException          Thrown if the url is invalid.
     * @throws OutsetaParseException               Thrown if the account cannot
     *                                             be parsed.
     * @throws OutsetaInvalidArgumentException    Thrown if the page request
     *                                            is null.
     *
     * Example usage:
     * <pre>{@code
     * AccountClient client = AccountClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * AccountPageRequest request = AccountPageRequest.builder()
     *      .page(page)
     *      .pageSize(pageSize)
     *      .build();
     * int total = 0;
     * ItemPage<Account> accountPage = null;
     *
     * do {
     *      // Keep making requests as long as there are more pages
     *      accountPage = accountClient.getAccountPage(request);
     *      total = accountPage.getMetadata().getTotal();
     *
     *      // The current page's items are aggregated
     *      allAccounts.addAll(accountPage.getItems());
     *      request = request.nextPageRequest();
     * }
     * while (allAccounts.size() < total);
     * }</pre>
     */
    public ItemPage<Account> getAccountPage(
            final PageRequest accountPageRequest)
                throws OutsetaInvalidArgumentException,
                OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
                OutsetaAPIBadRequestException, OutsetaAPIFailedException,
                OutsetaAPIUnknownException, OutsetaParseException {

        if (accountPageRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Page request cannot be null.");
        }

        String result = this.get("/crm/accounts",
                accountPageRequest.buildParams());

        return this.getParserFacade()
                .jsonStringToPage(result,
                        Account.class);
    }

    /**
     * This method is used to create an account.
     *
     * @param accountRequest The account to create.
     * @return The created account.
     * @throws OutsetaInvalidArgumentException Thrown if the account request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the account cannot be
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
     * AccountClient client = AccountClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Account accountRequest = new Account();
     * Account account = client.createAccount(accountRequest);
     * }</pre>
     */
    public Account createAccount(final Account accountRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (accountRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Account request cannot be null.");
        }

        String result = this.post("/crm/accounts", new HashMap<>(),
                this.getParserFacade().objectToJsonString(accountRequest));

        return this.getParserFacade().jsonStringToObject(result, Account.class);
    }

    /**
     * This method is used to create an account with a new Person.
     *
     * @param accountRequest The account to create.
     * @param sendConfirmationEmail Whether to send a confirmation email.
     * @return The created account.
     * @throws OutsetaInvalidArgumentException Thrown if the account request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the account cannot be
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
     * AccountClient client = AccountClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Account accountRequest = new Account();
     * Account account = client.createAccountWithNewPerson(accountRequest);
     * }</pre>
     */
    public Account createAccountWithNewPerson(
            final boolean sendConfirmationEmail,
            final Account accountRequest)

                throws OutsetaParseException,
                OutsetaInvalidResponseCodeException,
                OutsetaInvalidURLException, OutsetaAPIBadRequestException,
                OutsetaAPIFailedException, OutsetaAPIUnknownException,
                OutsetaInvalidArgumentException {

        if (accountRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Account request cannot be null.");
        }

        String result = this.post(
                "/crm/accounts?sendConfirmationEmail="
                        + sendConfirmationEmail,
                        new HashMap<>(),
                this.getParserFacade().objectToJsonString(accountRequest));

        return this.getParserFacade().jsonStringToObject(result, Account.class);
    }

    /**
     * This method is used to add a new person to an existing account.
     *
     * @param accountPerson The account and person to associate.
     * @param sendWelcomeEmail Whether to send a welcome email.
     * @return The created account/person mapping.
     * @throws OutsetaInvalidArgumentException Thrown if the account request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the account cannot be
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
     * AccountClient client = AccountClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Account accountRequest = new Account();
     * Account account = client.addNewPersonToExistingAccount(accountRequest);
     * }</pre>
     */
    public PersonAccount addNewPersonToExistingAccount(
            final boolean sendWelcomeEmail,
            final PersonAccount accountPerson)

            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (accountPerson == null) {
            throw new OutsetaInvalidArgumentException(
                    "Account request cannot be null.");
        }

        String result = this.post(
                "/crm/accounts/" + accountPerson.getAccount().getUid()
                        + "/memberships?sendWelcomeEmail="
                        + sendWelcomeEmail,
                new HashMap<>(),
                this.getParserFacade()
                        .objectToJsonString(accountPerson));

        return this.getParserFacade().jsonStringToObject(result,
                PersonAccount.class);
    }

    /**
     * This method is used to add a new person to an existing account.
     *
     * @param accountRequest The account to create.
     * @return The created account/person mapping.
     * @throws OutsetaInvalidArgumentException Thrown if the account request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the account cannot be
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
     * AccountClient client = AccountClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Account accountRequest = new Account();
     * Account account = client.addNewPersonToExistingAccount(accountRequest);
     * }</pre>
     */
    public PersonAccount addExistingPersonToExistingAccount(
            final PersonAccount accountRequest)

            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (accountRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Account request cannot be null.");
        }

        String result = this.post(
                "/crm/accounts/" + accountRequest.getAccount().getUid()
                        + "/memberships",
                new HashMap<>(),
                this.getParserFacade().objectToJsonString(accountRequest));

        return this.getParserFacade().jsonStringToObject(result,
                PersonAccount.class);
    }
}
