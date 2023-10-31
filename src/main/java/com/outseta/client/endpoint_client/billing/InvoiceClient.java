package com.outseta.client.endpoint_client.billing;

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
import com.outseta.model.result.Invoice;
import com.outseta.model.result.ItemPage;
import com.outseta.model.result.Transaction;

import java.util.HashMap;

/**
 * This class is used to make calls to the Invoice endpoints of the
 * Outseta API.
 * <p>
 *     The Invoice endpoints are used to manage Invoices.
 *     The class provides a builder to make it easier to construct the client.
 * </p>
 */
public final class InvoiceClient extends BaseClient {

    /**
     * This method is used to get a builder that can be used to build an
     * InvoiceClient object.
     *
     * @param baseUrl The base url for the api.
     * @return The builder that can be used to build an InvoiceClient object.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    public static ClientBuilder<InvoiceClient> builder(final String baseUrl)
            throws OutsetaClientBuildException {
        return new ClientBuilder<>(new InvoiceClient(baseUrl));
    }

    /**
     * The constructor creates a new Invoice client with the base url.
     * It is intentionally private to force the use of the builder.
     *
     * @param pBaseUrl The base url for the client to use.
     * @throws OutsetaClientBuildException Thrown if the client cannot be
     *                                     built.
     */
    private InvoiceClient(final String pBaseUrl)
            throws OutsetaClientBuildException {
        super(pBaseUrl);
    }

    /**
     * This method is used to create a new invoice.
     *
     * @param invoiceRequest The invoice to create.
     * @return The created invoice.
     * @throws OutsetaInvalidArgumentException Thrown if the invoice request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the invoice cannot be
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
     * DisountClient client = DisountClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Invoice invoiceRequest = new Invoice();
     * Invoice invoice = client.createInvoice(invoiceRequest);
     * }</pre>
     */
    public Invoice createInvoice(final Invoice invoiceRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (invoiceRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Invoice request cannot be null.");
        }

        String req = this.getParserFacade().objectToJsonString(invoiceRequest);
        String result = this.post("/billing/invoices",
                new HashMap<>(),
                req);

        return this.getParserFacade()
                .jsonStringToObject(result, Invoice.class);
    }

    /**
     * This method is used to get a page of Transaction objects. Transactions
     * are mapped against accounts.
     *
     * @param accountId The id of the account to get transactions for.
     * @param transactionPageRequest The page request to use.
     * @return The list of transactions.
     * @throws OutsetaInvalidResponseCodeException Thrown if the response code
     *                                             is invalid.
     * @throws OutsetaAPIBadRequestException       Thrown if the request is bad.
     * @throws OutsetaAPIFailedException           Thrown if the request fails.
     * @throws OutsetaAPIUnknownException          Thrown if the request fails
     *                                             for an unknown reason.
     * @throws OutsetaInvalidURLException          Thrown if the url is invalid.
     * @throws OutsetaParseException               Thrown if the transaction
     *                                              be parsed.
     * @throws OutsetaInvalidArgumentException    Thrown if the page request
     *                                            is null.
     *
     * Example usage:
     * <pre>{@code
     * InvoiceClient client = InvoiceClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * TransactionPageRequest request = TransactionPageRequest.builder()
     *      .page(page)
     *      .pageSize(pageSize)
     *      .billingTransactionType(BillingTransactionType.CREDIT)
     *      .build();
     * String accountId = "1";
     *
     * int total = 0;
     * ItemPage<Transaction> transactionPage = null;
     *
     * do {
     *      // Keep making requests as long as there are more pages
     *      transactionPage = client.getTransactionPage(accountId, request);
     *      total = transactionPage.getMetadata().getTotal();
     *
     *      // The current page's items are aggregated
     *      allTransactions.addAll(transactionPage.getItems());
     *      request = request.nextPageRequest();
     * }
     * while (allTransactions.size() < total);
     * }</pre>
     */
    public ItemPage<Transaction> getTransactionPage(
            final String accountId,
            final PageRequest transactionPageRequest)
                throws OutsetaInvalidArgumentException,
                OutsetaInvalidResponseCodeException, OutsetaInvalidURLException,
                OutsetaAPIBadRequestException, OutsetaAPIFailedException,
                OutsetaAPIUnknownException, OutsetaParseException {

        if (transactionPageRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Page request cannot be null.");
        }

        if (accountId == null || accountId.trim().isEmpty()) {
            throw new OutsetaInvalidArgumentException(
                    "Account id cannot be null or blank.");
        }

        String result = this.get("/billing/transactions/" + accountId,
                transactionPageRequest.buildParams());

        return this.getParserFacade()
                .jsonStringToPage(result,
                        Transaction.class);
    }

    /**
     * Adds a payment to an invoice. If the amount matches the outstanding
     * amount of the invoice, the invoice will be marked as Paid.
     *
     * @param transactionRequest The transaction to create.
     * @return The created transaction.
     * @throws OutsetaInvalidArgumentException Thrown if the request is
     *                                          null.
     * @throws OutsetaParseException            Thrown if the request cannot be
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
     * InvoiceClient client = InvoiceClient.builder(outsetaUrl)
     *      .apiKey(outsetaKey)
     *      .defaultParser()
     *      .defaultRequestMaker()
     *      .build();
     * Transaction transactionRequest = new Transaction();
     * Transaction transaction = client.addInvoicePayment(transactionRequest);
     * }</pre>
     */
    public Transaction addInvoicePayment(final Transaction transactionRequest)
            throws OutsetaParseException, OutsetaInvalidResponseCodeException,
            OutsetaInvalidURLException, OutsetaAPIBadRequestException,
            OutsetaAPIFailedException, OutsetaAPIUnknownException,
            OutsetaInvalidArgumentException {

        if (transactionRequest == null) {
            throw new OutsetaInvalidArgumentException(
                    "Transaction request cannot be null.");
        }

        String result = this.post("/billing/transactions/payment",
                new HashMap<>(),
                this.getParserFacade().objectToJsonString(transactionRequest));

        return this.getParserFacade()
                .jsonStringToObject(result, Transaction.class);
    }
}
