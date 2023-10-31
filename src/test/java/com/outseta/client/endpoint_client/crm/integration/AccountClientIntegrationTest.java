package com.outseta.client.endpoint_client.crm.integration;

import com.outseta.client.endpoint_client.crm.AccountClient;
import com.outseta.client.endpoint_client.crm.PeopleClient;
import com.outseta.constant.AccountStage;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.CancelAccountRequest;
import com.outseta.model.request.PageRequest;
import com.outseta.model.result.Account;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Person;
import com.outseta.model.result.PersonAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class is used to test the AccountClient class.
 * It is an integration test because it uses the actual API.
 */
@ExtendWith(MockitoExtension.class)
@Tag("integration")
public class AccountClientIntegrationTest {
    /**
     * The Outseta API Key.
     */
    private static String outsetaKey = System.getenv("OUTSETA_KEY");

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");

    /**
     * The AccountClient to test.
     */
    private AccountClient accountClient;

    /**
     * The PeopleClient to test.
     */
    private PeopleClient peopleClient;

    /**
     * The Account to test.
     */
    private Account account;

    /**
     * This method is run before each test.
     * @throws OutsetaClientBuildException if the client cannot be built.
     */
    @BeforeEach
    public void setUp() throws
            OutsetaClientBuildException, OutsetaInvalidRequestMakerException {
        accountClient = AccountClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();

        peopleClient = PeopleClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();

        account = Account.builder()
                .name("Hammad sdk test")
                .build();
    }

    /**
     * This method tests the createAccountWithNewPerson, getAccount
     * and deleteAccount methods.
     */
    @Test
    public void testGetAccountPage() {
        final int page = 0;
        final int pageSize = 25;

        List<Account> allAccounts = new ArrayList<>();

        assertDoesNotThrow(() -> {
            PageRequest request = PageRequest.builder()
                    .page(page)
                    .pageSize(pageSize)
                    .build();

            int total = 0;
            ItemPage<Account> itemPage = null;
            final int maxSize = 100;
            do {
                // Keep making requests as long as there are more pages
                itemPage = accountClient.getAccountPage(request);
                total = itemPage.getMetadata().getTotal();

                assertNotNull(itemPage);

                // The current page's items are aggregated
                allAccounts.addAll(itemPage.getItems());

                assertEquals(
                        (request.getPageSize() * request.getPageNum())
                                + itemPage.getItems().size(),
                        allAccounts.size());

                request = request.nextPageRequest();

            }
            while (allAccounts.size() < total
                    && allAccounts.size() < maxSize);

        });
    }

    /**
     * This method tests the createAccountWithExistingPerson.
     */
    @Test
    public void testCreateWithExisting() {

        assertDoesNotThrow(() -> {
            Person person = peopleClient.createPerson(Person.builder()
                    .fullName("Hammad Hassan sdk test")
                    .email("hammadCreateWithExisting@dummy.com")
                    .build());

            account.setPersonAccount(Arrays.asList(PersonAccount.builder()
                    .person(Person.builder().uid(person.getUid()).build())
                    .primary(true)
                    .build()));
            account.setAccountStage(AccountStage.Trialing.getValue());
            Account createdAccount = accountClient
                    .createAccountWithExistingPerson(
                        account
                    );
            Account result = accountClient.getAccount(createdAccount.getUid());

            assertEquals(createdAccount.getUid(), result.getUid());
            assertEquals(createdAccount.getAccountStage(),
                    result.getAccountStage());
            assertEquals(createdAccount.getName(),
                    result.getName());

            // Cleaning up;
            accountClient.deleteAccount(createdAccount.getUid());
            peopleClient.deletePerson(person.getUid());
        });
    }

    /**
     * This method tests the get method.
     */
    @Test
    public void testGetAccount() {

        account.setPersonAccount(Arrays.asList(PersonAccount.builder()
                .person(Person.builder()
                        .fullName("Hammad Hassan sdk test")
                        .email("hammad@dummy.com")
                        .build())
                .primary(true)
                .build()));
        account.setAccountStage(AccountStage.Trialing.getValue());
        assertDoesNotThrow(() -> {
            Account createdAccount = accountClient.createAccountWithNewPerson(
                    false,
                    account
            );
            Account result = accountClient.getAccount(createdAccount.getUid());

            assertEquals(createdAccount.getUid(), result.getUid());
            assertEquals(createdAccount.getAccountStage(),
                    result.getAccountStage());
            assertEquals(createdAccount.getName(),
                    result.getName());

            // Cleaning up;
            accountClient.deleteAccount(createdAccount.getUid());
            // Delete the person as well (Doing manually for now)
        });
    }

    /**
     * This method tests the addNewPersonToExistingAccount method.
     */
    @Test
    public void testAddNewPersonToExistingAccount() {

        assertDoesNotThrow(() -> {

            account.setAccountStage(AccountStage.Trialing.getValue());
            account.setPersonAccount(Arrays.asList(PersonAccount.builder()
                    .person(Person.builder()
                            .fullName("Primary Hammad Hassan sdk test")
                            .email("hammad4@dummy.com")
                            .build())
                    .primary(true)
                    .build()));
            Account createdAccount = accountClient
                    .createAccountWithExistingPerson(
                            account
                    );
            createdAccount = accountClient.getAccount(createdAccount.getUid());

            Person person = Person.builder()
                    .fullName("Primary Hammad Hassan sdk test")
                    .email("hammad5@dummy.com")
                    .build();
            PersonAccount result = accountClient
                    .addNewPersonToExistingAccount(
                            false,
                            createdAccount.getUid(),
                            PersonAccount.builder()
                                    .account(createdAccount)
                                    .person(person)
                                    .primary(false)
                                    .build()
                    );

            assertEquals(createdAccount.getUid(), result.getAccount().getUid());
            assertFalse(result.getPrimary());

            // Cleaning up;
            accountClient.deleteAccount(createdAccount.getUid());
            peopleClient.deletePerson(result.getPerson().getUid());
        });
    }

    /**
     * This method tests the addExistingPersonToExistingAccount method.
     */
    @Test
    public void testAddExistingPersonToExistingAccount() {

        assertDoesNotThrow(() -> {

            account.setAccountStage(AccountStage.Trialing.getValue());
            account.setPersonAccount(Arrays.asList(PersonAccount.builder()
                    .person(Person.builder()
                            .fullName("Primary Hammad Hassan sdk test")
                            .email("hammad5@dummy.com")
                            .build())
                    .primary(true)
                    .build()));
            Account createdAccount = accountClient
                    .createAccountWithExistingPerson(
                            account
                    );
            createdAccount = accountClient.getAccount(createdAccount.getUid());

            Person person = peopleClient.createPerson(Person.builder()
                    .fullName("Hammad Hassan sdk test")
                    .email("hammad6@dummy.com")
                    .build());
            PersonAccount result = accountClient
                    .addExistingPersonToExistingAccount(
                            createdAccount.getUid(),
                            PersonAccount.builder()
                                    .account(createdAccount)
                                    .person(person)
                                    .primary(false)
                                    .build()
                    );

            assertEquals(createdAccount.getUid(), result.getAccount().getUid());
            assertFalse(result.getPrimary());
            assertEquals(person.getUid(), result.getPerson().getUid());

            // Cleaning up;
            accountClient.deleteAccount(createdAccount.getUid());
            peopleClient.deletePerson(result.getPerson().getUid());
        });
    }

    /**
     * This method tests the registerAccount method.
     */
    @Test
    public void testRegisterAccount() {

        assertDoesNotThrow(() -> {

            account.setAccountStage(AccountStage.Trialing.getValue());
            account.setPersonAccount(Arrays.asList(PersonAccount.builder()
                    .person(Person.builder()
                            .fullName("Primary Hammad Hassan sdk test")
                            .email("hammad5@dummy.com")
                            .build())
                    .primary(true)
                    .build()));
            Account result = accountClient
                    .registerAccount(
                            account
                    );

            assertFalse(result.getUid().trim().isEmpty());
            assertFalse(result.getUid().isEmpty());
            assertEquals(account.getName(), result.getName());
            assertEquals(account.getAccountStage(), result.getAccountStage());

            // Cleaning up;
            accountClient.deleteAccount(result.getUid());
        });
    }

    /**
     * This method tests the update, cancel, removecancellation and
     * update account membership methods.
     */
    @Test
    public void testPutRequests() {

        assertDoesNotThrow(() -> {

            Person person1 = peopleClient.createPerson(Person.builder()
                    .fullName("Hammad Hassan sdk test1")
                    .email("hammad16@dummy.com")
                    .build());
            account.setAccountStage(AccountStage.Trialing.getValue());
            account.setPersonAccount(Arrays.asList(PersonAccount.builder()
                    .person(person1)
                    .primary(true)
                    .build()));
            Account createdAccount = accountClient
                    .createAccountWithExistingPerson(
                            account
                    );

            createdAccount.setName("Updated Name");
            createdAccount.setPersonAccount(Arrays.asList(PersonAccount
                    .builder()
                    .person(person1)
                    .primary(true)
                    .build()));

            // Testing update
            Account updatedAccount = accountClient
                    .updateAccount(createdAccount.getUid(), createdAccount);

            assertFalse(updatedAccount.getUid().trim().isEmpty());
            assertFalse(updatedAccount.getUid().isEmpty());
            assertEquals(createdAccount.getName(), updatedAccount.getName());

            // Testing cancel
            accountClient
                    .cancelAccount(createdAccount.getUid(),
                            CancelAccountRequest.builder()
                                    .cancellationReason("My Reason")
                                    .account(updatedAccount)
                                    .comment("My Comment")
                                    .build());

            Account cancelledAccount = accountClient
                    .getAccount(updatedAccount.getUid());

            // Testing remove cancellation
            accountClient
                    .removeCancellation(createdAccount.getUid());

            Account unCancelledAccount = accountClient
                    .getAccount(updatedAccount.getUid());

            assertEquals(createdAccount.getAccountStage(),
                    unCancelledAccount.getAccountStage());

            // Testing update account membership
            Person person2 = peopleClient.createPerson(Person.builder()
                    .fullName("Hammad Hassan sdk test2")
                    .email("hammad17@dummy.com")
                    .build());
            Person person3 = peopleClient.createPerson(Person.builder()
                    .fullName("Hammad Hassan sdk test3")
                    .email("hammad18@dummy.com")
                    .build());
            PersonAccount personAccount = accountClient
                    .addExistingPersonToExistingAccount(
                            createdAccount.getUid(),
                            PersonAccount.builder()
                                    .account(unCancelledAccount)
                                    .person(person3)
                                    .primary(false)
                                    .build()
                    );

            assertEquals(personAccount.getPerson().getFullName(),
                    person3.getFullName());

            personAccount.setPerson(person2);
            accountClient
                    .updateAccountMembership(createdAccount.getUid(),
                            personAccount.getUid(),
                            personAccount);

            // Cleaning up;
            accountClient.deleteAccount(createdAccount.getUid());
            peopleClient.deletePerson(person1.getUid());
            peopleClient.deletePerson(person2.getUid());
            peopleClient.deletePerson(person3.getUid());
        });
    }

    /**
     * This method tests the removePersonFromAccount.
     */
    @Test
    public void testRemovePersonFromAccount() {

        assertDoesNotThrow(() -> {

            Person person1 = peopleClient.createPerson(Person.builder()
                    .fullName("Hammad Hassan sdk test1")
                    .email("hammad19@dummy.com")
                    .build());
            Person person2 = peopleClient.createPerson(Person.builder()
                    .fullName("Hammad Hassan sdk test1")
                    .email("hammad20@dummy.com")
                    .build());
            account.setAccountStage(AccountStage.Trialing.getValue());
            account.setPersonAccount(Arrays.asList(PersonAccount.builder()
                        .person(person1)
                        .primary(true)
                        .build(), PersonAccount.builder()
                        .person(person2)
                        .primary(false)
                        .build()
                    )
            );
            Account createdAccount = accountClient
                    .createAccountWithExistingPerson(
                            account
                    );

            assertEquals(2, createdAccount.getPersonAccount().size());

            String memId = createdAccount.getPersonAccount()
                    .stream()
                    .filter((pa -> !pa.getPrimary()))
                    .collect(Collectors.toList())
                    .get(0).getUid();

            accountClient.removePersonFromAccount(createdAccount.getUid(),
                    memId);

            Account result = accountClient.getAccount(createdAccount.getUid());

            assertEquals(1, result.getPersonAccount().size());

            // Cleaning up;
            accountClient.deleteAccount(createdAccount.getUid());
            peopleClient.deletePerson(person1.getUid());
            peopleClient.deletePerson(person2.getUid());
        });
    }
}
