package com.outseta.client.endpoint_client.billing.integration;

import com.outseta.client.endpoint_client.billing.InvoiceClient;
import com.outseta.client.endpoint_client.billing.PlanClient;
import com.outseta.client.endpoint_client.billing.SubscriptionClient;
import com.outseta.client.endpoint_client.crm.AccountClient;
import com.outseta.client.endpoint_client.crm.PeopleClient;
import com.outseta.constant.AccountStage;
import com.outseta.constant.BillingRenewalTerm;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.OutsetaPageBuildException;
import com.outseta.exception.OutsetaParseException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.model.request.CreateOrChangeSubscriptionRequest;
import com.outseta.model.request.PageRequest;
import com.outseta.model.request.TransactionPageRequest;
import com.outseta.model.result.Account;
import com.outseta.model.result.Invoice;
import com.outseta.model.result.InvoiceLineItem;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Person;
import com.outseta.model.result.PersonAccount;
import com.outseta.model.result.Plan;
import com.outseta.model.result.Subscription;
import com.outseta.model.result.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class is used to test the InvoiceClient class.
 * It has integration tests because it makes calls to the Outseta API.
 */
@ExtendWith(MockitoExtension.class)
@Tag("integration")
public class InvoiceClientIntegrationTest {

    /**
     * The Outseta API Key.
     */
    private static String outsetaKey = System.getenv("OUTSETA_KEY");

    /**
     * The Outseta URL.
     */
    private static String outsetaUrl = System.getenv("OUTSETA_URL");

    /**
     * The InvoiceClient object to use for testing.
     */
    private InvoiceClient invoiceClient;

    /**
     * The person object to use for testing.
     */
    private Person person;

    /**
     * The account object to use for testing.
     */
    private Account createdAccount;

    /**
     * The account client object to use for testing.
     */
    private AccountClient accountClient;

    /**
     * The people client object to use for testing.
     */
    private PeopleClient peopleClient;

    /**
     * The plan object to use for testing.
     */
    private Plan createdPlan;

    /**
     * This method is used to set up the tests.
     */
    @BeforeEach
    public void setup() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException,
            OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
            OutsetaAPIBadRequestException, OutsetaParseException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException, OutsetaPageBuildException {
        invoiceClient = InvoiceClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build();

        accountClient = AccountClient.builder(outsetaUrl)
                .defaultRequestMaker()
                .defaultParser()
                .apiKey(outsetaKey)
                .build();
        peopleClient = PeopleClient.builder(outsetaUrl)
                .defaultRequestMaker()
                .defaultParser()
                .apiKey(outsetaKey)
                .build();

        person = peopleClient.createPerson(Person.builder()
                .fullName("Hammad Hassan sdk test")
                .email("hammadinvoice3@dummy.com")
                .build());

        Account account = Account.builder()
                .name("Hammad sdk test invoice")
                .build();

        account.setPersonAccount(List.of(PersonAccount.builder()
                .person(Person.builder().uid(person.getUid()).build())
                .primary(true)
                .build()));

        account.setAccountStage(AccountStage.Trialing.getValue());
        createdAccount = accountClient
                .createAccountWithExistingPerson(
                        account
                );

        PlanClient.builder(outsetaUrl)
                .apiKey(outsetaKey)
                .defaultParser()
                .defaultRequestMaker()
                .build()
                .getPlanPage(PageRequest.builder()
                        .page(0)
                        .pageSize(1)
                        .build())
                .getItems()
                .stream()
                .findFirst()
                .ifPresent(plan -> createdPlan = plan);
    }

    /**
     * This method is used to test the all methods.
     */
    @Test
    public void testAllMethods() {

        final int page = 0;
        final int pageSize = 25;

        List<Transaction> allTransactions = new ArrayList<>();

        assertDoesNotThrow(() -> {

            TransactionPageRequest request = TransactionPageRequest.builder()
                    .page(page)
                    .pageSize(pageSize)
                    .build();

            int total = 0;
            ItemPage<Transaction> itemPage = null;
            final int maxSize = 100;
            do {
                // Keep making requests as long as there are more pages
                itemPage = invoiceClient.getTransactionPage(
                        createdAccount.getUid(), request);
                total = itemPage.getMetadata().getTotal();

                assertNotNull(itemPage);

                // The current page's items are aggregated
                allTransactions.addAll(itemPage.getItems());

                assertEquals(
                        (request.getPageSize() * request.getPageNum())
                                + itemPage.getItems().size(),
                        allTransactions.size());

                request = request.nextPageRequest();

            }
            while (allTransactions.size() < total
                    && allTransactions.size() < maxSize);

        });
    }

    /**
     * This method tests the createInvoice method.
     */
    @Test
    public void testCreateInvoice() {

        assertDoesNotThrow(() -> {

            Subscription sub = SubscriptionClient.builder(outsetaUrl)
                    .apiKey(outsetaKey)
                    .defaultParser()
                    .defaultRequestMaker()
                    .build().addFirstTimeSubscription(
                            CreateOrChangeSubscriptionRequest.builder()
                                    .account(createdAccount)
                                    .plan(createdPlan)
                                    .billingRenewalTerm(
                                            BillingRenewalTerm
                                                    .Monthly.getValue())
                                    .build()
                    );

            final double amount = 10.1;
            Invoice invoice = Invoice.builder()
                    .subscription(sub)
                    .invoiceLineItems(List.of(InvoiceLineItem.builder()
                                    .amount(amount)
                                    .description("test")
                            .build()))
                    .invoiceDate(new Date())
                    .build();

            Invoice result = invoiceClient.createInvoice(invoice);

            assertNotNull(result);
            assertEquals(amount, result.getAmount());
            assertEquals(sub, result.getSubscription());
            assertEquals(1, result.getInvoiceLineItems().size());
        });
    }

    /**
     * This method tests the addInvoicePayment method.
     */
    @Test
    public void testAddInvoicePayment() {
        assertDoesNotThrow(() -> {

            Subscription sub = SubscriptionClient.builder(outsetaUrl)
                    .apiKey(outsetaKey)
                    .defaultParser()
                    .defaultRequestMaker()
                    .build().addFirstTimeSubscription(
                            CreateOrChangeSubscriptionRequest.builder()
                                    .account(createdAccount)
                                    .plan(createdPlan)
                                    .billingRenewalTerm(
                                            BillingRenewalTerm
                                                    .Monthly.getValue())
                                    .build()
                    );

            final double amount = 10.1;
            Invoice invoice = Invoice.builder()
                    .subscription(sub)
                    .invoiceLineItems(List.of(InvoiceLineItem.builder()
                            .amount(amount)
                            .description("test")
                            .build()))
                    .invoiceDate(new Date())
                    .build();

            Invoice invRes = invoiceClient.createInvoice(invoice);

            assertNotNull(invRes);
            assertEquals(amount, invRes.getAmount());
            assertEquals(sub, invRes.getSubscription());
            assertEquals(1, invRes.getInvoiceLineItems().size());

            final double paymentAmount = -9.3;
            Transaction result = invoiceClient
                    .addInvoicePayment(Transaction.builder()
                            .invoice(invRes)
                            .account(createdAccount)
                            .amount(paymentAmount)
                            .transactionDate(new Date())
                    .build());

            assertNotNull(result);
            assertEquals(paymentAmount, result.getAmount());
            assertEquals(createdAccount, result.getAccount());
            assertEquals(invRes, result.getInvoice());

            // After this transaction the account cannot be deleted, so
            // the teardown method will give error. Delete manually.
        });
    }

    /**
     * This method is used to clean up after the tests.
     */
    @AfterEach
    public void cleanup() throws OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {
        accountClient.deleteAccount(createdAccount.getUid());
        peopleClient.deletePerson(person.getUid());
    }
}
