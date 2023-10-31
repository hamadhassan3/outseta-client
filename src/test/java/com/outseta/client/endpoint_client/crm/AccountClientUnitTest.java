package com.outseta.client.endpoint_client.crm;

import com.outseta.client.ClientBuilder;
import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.CancelAccountRequest;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.Account;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Metadata;
import com.outseta.model.result.PersonAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class test the AccountClient class.
 */
@ExtendWith(MockitoExtension.class)
public class AccountClientUnitTest {

    /**
     * The Outseta URL used for testing.
     */
    private static final String OUTSETA_URL = "https://dummy.com";

    /**
     * The Outseta Key used for testing.
     */
    private static final String OUTSETA_KEY = "dummyKey";

    /**
     * The ParserFacade object used for testing.
     */
    @Mock
    private ParserFacade parserFacade;

    /**
     * The JsonParser object used for testing.
     */
    @Mock
    private JsonParser jsonParser;

    /**
     * The RequestMaker object used for testing.
     */
    @Mock
    private RequestMaker requestMaker;

    /**
     * The account client object used for testing.
     */
    private AccountClient accountClient;

    /**
     * The account object used for testing.
     */
    @Mock
    private Account account;

    /**
     * The person account object used for testing.
     */
    @Mock
    private PersonAccount personAccount;

    /**
     * The account json used for testing.
     */
    private String accountJson;

    /**
     * The cancel account request used for testing.
     */
    @Mock
    private CancelAccountRequest cancelAccountRequest;

    /**
     * This method is called before each test.
     */
    @BeforeEach
    public void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {
        when(parserFacade.getJsonParser()).thenReturn(jsonParser);

        accountClient = AccountClient.builder(OUTSETA_URL)
                .apiKey(OUTSETA_KEY)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .build();

        accountJson = "AccountJsonDummy";
    }

    /**
     * This method tests the AccountClient's builder.
     */
    @Test
    public void testBuilder() {

        assertDoesNotThrow(() -> {
            ClientBuilder<AccountClient> test =
                    AccountClient.builder(OUTSETA_URL);
            assertEquals(test, test.apiKey(OUTSETA_KEY));
            assertEquals(test, test.defaultParser());
            assertEquals(test, test.defaultRequestMaker());

            AccountClient accountClient1 = test.build();

            assertNotNull(accountClient1);
        });

        assertDoesNotThrow(() -> {

            when(parserFacade.getJsonParser()).thenReturn(jsonParser);

            ClientBuilder<AccountClient> test =
                    AccountClient.builder(OUTSETA_URL);

            Map<String, String> m = new HashMap<>();
            m.put("Authorization", "dummy");

            assertEquals(test, test.apiKey(OUTSETA_KEY));
            assertEquals(test, test.accessKey(OUTSETA_KEY));
            assertEquals(test, test.parser(parserFacade));
            assertEquals(test, test.baseUrl(OUTSETA_URL));
            assertEquals(test, test.requestMaker("DEFAULT"));
            assertEquals(test, test.headers(
                    m));
            assertEquals(test, test.requestMaker(RequestMakerType.DEFAULT));

            AccountClient accountClient1 = test.build();

            assertNotNull(accountClient1);
        });
    }

    /**
     * This method tests the failure scenario of the builder method
     * of the AccountClient class.
     */
    @Test
    public void testBuilderFailure() {

        // Testing empty object
        assertThrows(OutsetaClientBuildException.class, () ->
                AccountClient.builder(null)
        );
        assertThrows(OutsetaClientBuildException.class, () ->
                AccountClient.builder("")
        );

        // Testing null outsetaUrl but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AccountClient.builder(null)
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing empty outsetaUrl but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AccountClient.builder("")
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing null Outseta Key but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AccountClient.builder(OUTSETA_URL)
                        .apiKey(null)
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing empty Outseta Key but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AccountClient.builder(OUTSETA_URL)
                        .apiKey("")
                        .defaultParser()
                        .defaultRequestMaker()
                        .build()
        );

        // Testing without parser but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AccountClient.builder(OUTSETA_URL)
                        .apiKey(OUTSETA_KEY)
                        .defaultRequestMaker()
                        .build()
        );

        // Testing without request maker but with all other attributes
        assertThrows(OutsetaClientBuildException.class, () ->
                AccountClient.builder(OUTSETA_URL)
                        .apiKey(OUTSETA_KEY)
                        .defaultParser()
                        .build()
        );
    }

    /**
     * This method tests the getAccount method.
     */
    @Test
    public void testGetAccount() {
        assertDoesNotThrow(() -> {

            when(requestMaker.get(OUTSETA_URL + "/crm/accounts/uid",
                    new HashMap<>(), accountClient.getHeaders()))
                    .thenReturn(accountJson);

            // Mocking parser facade's jsonStringToObject method to return
            // an account.
            when(parserFacade
                    .jsonStringToObject(accountJson, Account.class))
                    .thenReturn(account);

            // Making the request.
            Account result = accountClient.getAccount("uid");

            // Comparing against expected results
            assertNotNull(result);
            assertEquals(result, account);

        });
    }

    /**
     * This method tests the getAccount method with null uid.
     */
    @Test
    public void testGetAccountWithNullUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.getAccount(null)
        );
    }

    /**
     * This method tests the getAccount method with empty uid.
     */
    @Test
    public void testGetAccountWithEmptyUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.getAccount("")
        );
    }

    /**
     * This method tests the getAccountPage method.
     */
    @Test
    public void testGetAccountPage() {
        assertDoesNotThrow(() -> {

            Map<String, Object> params = new HashMap<>();

            params.put("offset", "0");
            params.put("limit", "1");

            ItemPage<Account> itemPage = new ItemPage<>(
                    new Metadata(1, 0, 1),
                    Arrays.asList(account)
            );

            when(requestMaker.get(OUTSETA_URL + "/crm/accounts",
                    params, accountClient.getHeaders()))
                    .thenReturn("result");

            // Mocking parser facade's jsonStringToPage method to return
            // an ItemPage of Account.
            when(parserFacade
                    .jsonStringToPage("result", Account.class))
                    .thenReturn(itemPage);

            // Making the request.
            ItemPage<Account> result1 = accountClient
                    .getAccountPage(PageRequest
                            .builder()
                            .page(0)
                            .pageSize(1)
                            .build()
                    );

            params.remove("offset");

            when(requestMaker.get(OUTSETA_URL + "/crm/accounts",
                    params, accountClient.getHeaders()))
                    .thenReturn("result");

            ItemPage<Account> result2 = accountClient
                    .getAccountPage(PageRequest
                            .builder()
                            .pageSize(1)
                            .build()
                    );

            params.put("offset", "0");
            params.remove("limit");

            when(requestMaker.get(OUTSETA_URL + "/crm/accounts",
                    params, accountClient.getHeaders()))
                    .thenReturn("result");

            ItemPage<Account> result3 = accountClient
                    .getAccountPage(PageRequest
                            .builder()
                            .page(0)
                            .build()
                    );

            params.remove("offset");

            when(requestMaker.get(OUTSETA_URL + "/crm/accounts",
                    params, accountClient.getHeaders()))
                    .thenReturn("result");

            ItemPage<Account> result4 = accountClient
                    .getAccountPage(PageRequest
                            .builder()
                            .build()
                    );

            // Comparing against expected results
            assertNotNull(result1);
            assertEquals(result1, itemPage);

            assertNotNull(result2);
            assertEquals(result2, itemPage);

            assertNotNull(result3);
            assertEquals(result2, itemPage);

            assertNotNull(result4);
            assertEquals(result2, itemPage);

        });
    }

    /**
     * This method tests the getAccountPage method with null page request.
     */
    @Test
    public void testGetAccountPageWithNullPageRequest() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.getAccountPage(null)
        );
    }

    /**
     * This method tests the createAccount method.
     */
    @Test
    public void testCreateAccount() {
        assertDoesNotThrow(() -> {

            when(requestMaker.post(
                    OUTSETA_URL + "/crm/accounts",
                    new HashMap<>(),
                    accountJson,
                    accountClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(account))
                    .thenReturn(accountJson);

            when(parserFacade.jsonStringToObject("result",
                        Account.class))
                    .thenReturn(account);

            Account result = accountClient
                    .createAccountWithExistingPerson(account);

            assertNotNull(result);
            assertEquals(result, account);
        });
    }

    /**
     * This method tests the createAccount method with null account.
     */
    @Test
    public void testCreateAccountWithNullAccount() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.createAccountWithExistingPerson(null)
        );
    }

    /**
     * This method tests the createAccountWithNewPerson method.
     */
    @Test
    public void testCreateAccountWithNewPerson() {
        assertDoesNotThrow(() -> {

            when(requestMaker.post(
                    OUTSETA_URL
                            + "/crm/accounts?sendConfirmationEmail=true",
                    new HashMap<>(),
                    accountJson,
                    accountClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(account))
                    .thenReturn(accountJson);

            when(parserFacade.jsonStringToObject("result",
                    Account.class))
                    .thenReturn(account);

            Account result1 = accountClient
                    .createAccountWithNewPerson(true, account);

            assertNotNull(result1);
            assertEquals(result1, account);
        });
    }

    /**
     * This method tests the createAccountWithNewPersonWithNullAccount
     * method with null account.
     */
    @Test
    public void testCreateAccountWithNewPersonWithNullAccount() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.createAccountWithNewPerson(
                        true, null)
        );
    }

    /**
     * This method tests the addNewPersonToExistingAccount method.
     */
    @Test
    public void addNewPersonToExistingAccount() {
        assertDoesNotThrow(() -> {

            when(requestMaker.post(
                    OUTSETA_URL
                            + "/crm/accounts/1"
                            + "/memberships?sendWelcomeEmail=true",
                    new HashMap<>(),
                    accountJson,
                    accountClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(personAccount))
                    .thenReturn(accountJson);

            when(parserFacade.jsonStringToObject("result",
                    PersonAccount.class))
                    .thenReturn(personAccount);

            PersonAccount result1 = accountClient
                    .addNewPersonToExistingAccount(
                            true, "1", personAccount);

            assertNotNull(result1);
            assertEquals(result1, personAccount);
        });
    }

    /**
     * This method tests the addNewPersonToExistingAccount
     * with null account.
     */
    @Test
    public void testAddNewPersonToExistingAccount() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.addNewPersonToExistingAccount(
                        true, "1",
                        null)
        );
    }

    /**
     * This method tests the addNewPersonToExistingAccount method
     * with null uid.
     */
    @Test
    public void testAddNewPersonToExistingAccountWithNullUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.addNewPersonToExistingAccount(
                        true, null,
                        personAccount)
        );
    }

    /**
     * This method tests the addNewPersonToExistingAccount method
     * with empty uid.
     */
    @Test
    public void testAddNewPersonToExistingAccountWithEmptyUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.addNewPersonToExistingAccount(
                        true, "",
                        personAccount)
        );
    }

    /**
     * This method tests the addExistingPersonToExistingAccount method.
     */
    @Test
    public void addExistingPersonToExistingAccount() {
        assertDoesNotThrow(() -> {

            when(requestMaker.post(
                    OUTSETA_URL
                            + "/crm/accounts/1"
                            + "/memberships",
                    new HashMap<>(),
                    accountJson,
                    accountClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(personAccount))
                    .thenReturn(accountJson);

            when(parserFacade.jsonStringToObject("result",
                    PersonAccount.class))
                    .thenReturn(personAccount);

            PersonAccount result1 = accountClient
                    .addExistingPersonToExistingAccount(
                            "1", personAccount);

            assertNotNull(result1);
            assertEquals(result1, personAccount);
        });
    }

    /**
     * This method tests the addExistingPersonToExistingAccount
     * with null account.
     */
    @Test
    public void testAddExistingPersonToExistingAccountWithNullAccount() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.addExistingPersonToExistingAccount(
                        "1",
                        null)
        );
    }

    /**
     * This method tests the addExistingPersonToExistingAccount method
     * with null uid.
     */
    @Test
    public void testAddExistingPersonToExistingAccountWithNullAccountId() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.addExistingPersonToExistingAccount(
                         null,
                        personAccount)
        );
    }

    /**
     * This method tests the addExistingPersonToExistingAccount method
     * with empty uid.
     */
    @Test
    public void testAddExistingPersonToExistingAccountWithBlankAccountId() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.addExistingPersonToExistingAccount(
                        "",
                        personAccount)
        );
    }

    /**
     * This method tests the registerAccount method.
     */
    @Test
    public void testRegisterAccount() {
        assertDoesNotThrow(() -> {

            when(requestMaker.post(
                    OUTSETA_URL
                            + "/crm/accounts",
                    new HashMap<>(),
                    accountJson,
                    accountClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(account))
                    .thenReturn(accountJson);

            when(parserFacade.jsonStringToObject("result",
                    Account.class))
                    .thenReturn(account);

            Account result1 = accountClient
                    .registerAccount(account);

            assertNotNull(result1);
            assertEquals(result1, account);
        });
    }

    /**
     * This method tests the registerAccount
     * with null account.
     */
    @Test
    public void testRegisterAccountWithNullAccountRequest() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.registerAccount(
                        null)
        );
    }

    /**
     * This method tests the updateAccount method.
     */
    @Test
    public void testUpdateAccount() {
        assertDoesNotThrow(() -> {

            when(requestMaker.put(OUTSETA_URL + "/crm/accounts/uid",
                    new HashMap<>(), accountJson, accountClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(account))
                    .thenReturn(accountJson);

            when(parserFacade.jsonStringToObject("result",
                    Account.class))
                    .thenReturn(account);

            Account result = accountClient.updateAccount(
                    "uid", account);

            assertNotNull(result);
            assertEquals(result, account);
        });
    }

    /**
     * This method tests updateAccount with null account.
     */
    @Test
    public void testUpdateAccountWithNullAccount() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.updateAccount(
                        "uid", null)
        );
    }

    /**
     * This method tests updateAccount with null uid.
     */
    @Test
    public void testUpdateAccountWithNullUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.updateAccount(
                        null, account)
        );
    }

    /**
     * This method tests updateAccount with empty uid.
     */
    @Test
    public void testUpdateAccountWithEmptyUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.updateAccount(
                        "", account)
        );
    }

    /**
     * This method tests the cancelAccount method.
     */
    @Test
    public void testCancelAccount() {
        assertDoesNotThrow(() -> {

            when(requestMaker.put(OUTSETA_URL + "/crm/accounts"
                            + "/cancellation/uid",
                    new HashMap<>(), accountJson, accountClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(cancelAccountRequest))
                    .thenReturn(accountJson);

            accountClient.cancelAccount(
                    "uid", cancelAccountRequest);

        });
    }

    /**
     * This method tests cancelAccount with null account.
     */
    @Test
    public void testCancelAccountWithNullAccount() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.cancelAccount(
                        "uid", null)
        );
    }

    /**
     * This method tests cancelAccount with null uid.
     */
    @Test
    public void testCancelAccountWithNullUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.cancelAccount(
                        null, cancelAccountRequest)
        );
    }

    /**
     * This method tests cancelAccount with empty uid.
     */
    @Test
    public void testCancelAccountWithEmptyUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.cancelAccount(
                        "", cancelAccountRequest)
        );
    }

    /**
     * This method tests the removeCancellation method.
     */
    @Test
    public void testRemoveCancellation() {
        assertDoesNotThrow(() -> {

            when(requestMaker.put(OUTSETA_URL + "/crm/accounts"
                            + "/removecancellation/uid",
                    new HashMap<>(), "", accountClient.getHeaders()))
                    .thenReturn("result");

            accountClient.removeCancellation(
                    "uid");

        });
    }

    /**
     * This method tests the removeCancellations method with null uid.
     */
    @Test
    public void testRemoveCancellationWithNullUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.removeCancellation(
                        null)
        );
    }

    /**
     * This method tests the removeCancellations method with empty uid.
     */
    @Test
    public void testRemoveCancellationWithEmptyUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.removeCancellation(
                        "")
        );
    }

    /**
     * This method tests the updateAccountMembership method.
     */
    @Test
    public void testUpdateAccountMembership() {
        assertDoesNotThrow(() -> {

            when(requestMaker.put(OUTSETA_URL + "/crm/accounts/uid"
                            + "/memberships/memuid",
                    new HashMap<>(), accountJson, accountClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(personAccount))
                    .thenReturn(accountJson);

            accountClient.updateAccountMembership(
                    "uid", "memuid", personAccount);

        });
    }

    /**
     * This method tests the updateAccountMembership with null account.
     */
    @Test
    public void testUpdateAccountMembershipWithNullAccount() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.updateAccountMembership(
                        "uid", "memuid", null)
        );
    }

    /**
     * This method tests the updateAccountMembership with null uid.
     */
    @Test
    public void testUpdateAccountMembershipWithNullUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.updateAccountMembership(
                        null, "memuid", personAccount)
        );
    }

    /**
     * This method tests the updateAccountMembership with empty uid.
     */
    @Test
    public void testUpdateAccountMembershipWithEmptyUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.updateAccountMembership(
                        "", "memuid", personAccount)
        );
    }

    /**
     * This method tests the updateAccountMembership with null membership uid.
     */
    @Test
    public void testUpdateAccountMembershipWithNullMembershipUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.updateAccountMembership(
                        "uid", null, personAccount)
        );
    }

    /**
     * This method tests the updateAccountMembership with empty membership uid.
     */
    @Test
    public void testUpdateAccountMembershipWithEmptyMembershipUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.updateAccountMembership(
                        "uid", "", personAccount)
        );
    }

    /**
     * This method tests the deleteAccount method.
     */
    @Test
    public void testDeleteAccount() {
        assertDoesNotThrow(() -> {

            when(requestMaker.delete(OUTSETA_URL + "/crm/accounts/uid",
                    new HashMap<>(), accountClient.getHeaders()))
                    .thenReturn("result");

            // Making the request.
            accountClient.deleteAccount("uid");

        });
    }

    /**
     * This method tests the deleteAccount method with null uid.
     */
    @Test
    public void testDeleteAccountWithNullUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.deleteAccount(null)
        );
    }

    /**
     * This method tests the deleteAccount method with empty uid.
     */
    @Test
    public void testDeleteAccountWithEmptyUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.deleteAccount("")
        );
    }

    /**
     * This method tests the removePersonFromAccount method.
     */
    @Test
    public void testRemovePersonFromAccount() {
        assertDoesNotThrow(() -> {

            when(requestMaker.delete(OUTSETA_URL + "/crm/accounts/uid"
                        + "/memberships/memuid",
                    new HashMap<>(), accountClient.getHeaders()))
                    .thenReturn("result");

            // Making the request.
            accountClient.removePersonFromAccount(
                    "uid", "memuid");

        });
    }

    /**
     * This method tests the removePersonFromAccount method with null uid.
     */
    @Test
    public void testRemovePersonFromAccountWithNullUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.removePersonFromAccount(
                        null, "memuid")
        );
    }

    /**
     * This method tests the removePersonFromAccount method with empty uid.
     */
    @Test
    public void testRemovePersonFromAccountWithEmptyUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.removePersonFromAccount(
                        "", "memuid")
        );
    }

    /**
     * This method tests the removePersonFromAccount method with null
     * membership uid.
     */
    @Test
    public void testRemovePersonFromAccountWithNullMembershipUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.removePersonFromAccount(
                        "uid", null)
        );
    }

    /**
     * This method tests the removePersonFromAccount method with empty
     * membership uid.
     */
    @Test
    public void testRemovePersonFromAccountWithEmptyMembershipUid() {
        assertThrows(OutsetaInvalidArgumentException.class, () ->
                accountClient.removePersonFromAccount(
                        "uid", "")
        );
    }
}
