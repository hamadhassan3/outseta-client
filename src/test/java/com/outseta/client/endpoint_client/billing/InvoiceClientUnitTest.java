package com.outseta.client.endpoint_client.billing;

import com.outseta.client_helper.parser.json.JsonParser;
import com.outseta.client_helper.parser.json.ParserFacade;
import com.outseta.client_helper.request_maker.RequestMaker;
import com.outseta.constant.BillingTransactionType;
import com.outseta.exception.OutsetaClientBuildException;
import com.outseta.exception.OutsetaInvalidArgumentException;
import com.outseta.exception.OutsetaInvalidRequestMakerException;
import com.outseta.model.request.TransactionPageRequest;
import com.outseta.model.result.Invoice;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Metadata;
import com.outseta.model.result.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the InvoiceClient class.
 */
@ExtendWith(MockitoExtension.class)
public class InvoiceClientUnitTest {

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
     * The InvoiceClient object used for testing.
     */
    private InvoiceClient invoiceClient;

    /**
     * The Invoice object used for testing.
     */
    @Mock
    private Invoice invoice;

    /**
     * The Invoice object string used for testing.
     */
    private String invoiceStr;

    /**
     * The Transaction object used for testing.
     */
    @Mock
    private Transaction transaction;

    /**
     * The Transaction object string used for testing.
     */
    private String transactionStr;

    /**
     * This method initializes the InvoiceClient object and the model
     * objects used for testing.
     */
    @BeforeEach
    public void setUp() throws OutsetaClientBuildException,
            OutsetaInvalidRequestMakerException {

        when(parserFacade.getJsonParser()).thenReturn(jsonParser);
        invoiceClient = InvoiceClient.builder(OUTSETA_URL)
                .apiKey(OUTSETA_KEY)
                .parser(parserFacade)
                .requestMaker(requestMaker)
                .build();
        invoiceStr = "invoiceDummy";
        transactionStr = "transactionDummy";
    }

    /**
     * This method tests the getTransactionPage method.
     */
    @Test
    public void testGetTransactionPage() {
        assertDoesNotThrow(() -> {

            Map<String, Object> params = new HashMap<>();

            params.put("offset", "0");
            params.put("limit", "1");
            params.put("BillingTransactionType",
                    BillingTransactionType.INVOICE.getValue());

            ItemPage<Transaction> itemPage = new ItemPage<>(
                    new Metadata(1, 0, 1),
                    List.of(transaction)
            );

            when(requestMaker.get(OUTSETA_URL
                            + "/billing/transactions/accountId",
                    params, invoiceClient.getHeaders()))
                    .thenReturn("result");

            // Mocking parser facade's jsonStringToPage method to return
            // an ItemPage of Transaction.
            when(parserFacade
                    .jsonStringToPage("result", Transaction.class))
                    .thenReturn(itemPage);

            // Making the request.
            ItemPage<Transaction> result1 = invoiceClient
                    .getTransactionPage("accountId",
                            TransactionPageRequest
                                .builder()
                                .page(0)
                                .pageSize(1)
                                    .billingTransactionType(
                                            BillingTransactionType.INVOICE)
                                .build()
                    );

            params.remove("offset");

            when(requestMaker.get(OUTSETA_URL
                            + "/billing/transactions/accountId",
                    params, invoiceClient.getHeaders()))
                    .thenReturn("result");

            ItemPage<Transaction> result2 = invoiceClient
                    .getTransactionPage("accountId",
                            TransactionPageRequest
                            .builder()
                            .pageSize(1)
                            .billingTransactionType(
                                    BillingTransactionType.INVOICE)
                            .build()
                    );

            params.put("offset", "0");
            params.remove("limit");

            when(requestMaker.get(OUTSETA_URL
                            + "/billing/transactions/accountId",
                    params, invoiceClient.getHeaders()))
                    .thenReturn("result");

            ItemPage<Transaction> result3 = invoiceClient
                    .getTransactionPage("accountId",
                            TransactionPageRequest
                            .builder()
                            .page(0)
                            .billingTransactionType(
                                    BillingTransactionType.INVOICE)
                            .build()
                    );

            params.remove("offset");

            when(requestMaker.get(OUTSETA_URL
                            + "/billing/transactions/accountId",
                    params, invoiceClient.getHeaders()))
                    .thenReturn("result");

            ItemPage<Transaction> result4 = invoiceClient
                    .getTransactionPage("accountId",
                            TransactionPageRequest
                            .builder()
                                    .billingTransactionType(
                                            BillingTransactionType.INVOICE)
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
     * This method tests the getInvoice method with null request.
     */
    @Test
    public void testGetTransactionPageNullRequest() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            invoiceClient.getTransactionPage(
                    "accountId", null);
        });
    }

    /**
     * This method tests the getInvoice method with null accountId.
     */
    @Test
    public void testGetTransactionPageNullAccountId() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            invoiceClient.getTransactionPage(
                    null,
                    TransactionPageRequest
                            .builder()
                            .page(0)
                            .pageSize(1)
                            .billingTransactionType(
                                    BillingTransactionType.INVOICE)
                            .build()
            );
        });
    }

    /**
     * This method tests the getInvoice method with empty accountId.
     */
    @Test
    public void testGetTransactionPageEmptyAccountId() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            invoiceClient.getTransactionPage(
                    "",
                    TransactionPageRequest
                            .builder()
                            .page(0)
                            .pageSize(1)
                            .billingTransactionType(
                                    BillingTransactionType.INVOICE)
                            .build()
            );
        });
    }

    /**
     * This method tests the createInvoice method.
     */
    @Test
    public void testCreateInvoice() {

        assertDoesNotThrow(() -> {

            when(requestMaker.post(
                    OUTSETA_URL + "/billing/invoices",
                    new HashMap<>(),
                    invoiceStr,
                    invoiceClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(invoice))
                    .thenReturn(invoiceStr);

            when(parserFacade.jsonStringToObject("result",
                    Invoice.class))
                    .thenReturn(invoice);

            Invoice result = invoiceClient.createInvoice(invoice);

            assertNotNull(result);
            assertEquals(result, invoice);
        });
    }

    /**
     * This method tests the createInvoice method with null request.
     */
    @Test
    public void testCreateInvoiceNullRequest() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            invoiceClient.createInvoice(null);
        });
    }

    /**
     * This method tests the addInvoicePayment method.
     */
    @Test
    public void testAddInvoicePayment() {

        assertDoesNotThrow(() -> {

            when(requestMaker.post(
                    OUTSETA_URL + "/billing/transactions/payment",
                    new HashMap<>(),
                    transactionStr,
                    invoiceClient.getHeaders()))
                    .thenReturn("result");

            when(parserFacade.objectToJsonString(transaction))
                    .thenReturn(transactionStr);

            when(parserFacade.jsonStringToObject("result",
                    Transaction.class))
                    .thenReturn(transaction);

            Transaction result = invoiceClient.addInvoicePayment(transaction);

            assertEquals(result, transaction);
        });
    }

    /**
     * This method tests the addInvoicePayment method with null request.
     */
    @Test
    public void testAddInvoicePaymentNullRequest() {

        assertThrows(OutsetaInvalidArgumentException.class, () -> {
            invoiceClient.addInvoicePayment(null);
        });
    }
}
