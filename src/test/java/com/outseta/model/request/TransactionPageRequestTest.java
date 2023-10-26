package com.outseta.model.request;

import com.outseta.constant.BillingTransactionType;
import com.outseta.constant.Sort;
import com.outseta.exception.OutsetaPageBuildException;
import com.outseta.model.BaseInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class tests the TransactionPageRequest class.
 */
@ExtendWith(MockitoExtension.class)
public class TransactionPageRequestTest implements BaseInput {

    /**
     * The TransactionPageRequest object to test.
     */
    private TransactionPageRequest transactionPageRequest;

    /**
     * The page number to test.
     */
    private static final int PAGE = 1;

    /**
     * The page size to test.
     */
    private static final int PAGE_SIZE = 10;

    /**
     * The billing transaction type to test.
     */
    private static final BillingTransactionType BILLING_TRANSACTION_TYPE
            = BillingTransactionType.CREDIT;

    /**
     * This method is called before each test.
     */
    @BeforeEach
    public void setUp() throws OutsetaPageBuildException {

        transactionPageRequest = TransactionPageRequest.builder()
                .page(PAGE)
                .pageSize(PAGE_SIZE)
                .orderBy("id")
                .orderByDirection(Sort.ASC)
                .customParams(new HashMap<>())
                .billingTransactionType(BILLING_TRANSACTION_TYPE)
                .build();
    }

    /**
     * This method tests the TransactionPageRequest's builder's constructor.
     */
    @Test
    public void testBuilderConstructor() throws OutsetaPageBuildException {

        final TransactionPageRequest.Builder builder =
                new TransactionPageRequest.Builder();

        assertNull(builder.build().getPageNum());
        assertNull(builder.build().getPageSize());
        assertNull(builder.build().getBillingTransactionType());

        assertEquals(builder.page(PAGE).build().getPageNum(), PAGE);
        assertEquals(builder
                .pageSize(PAGE_SIZE).build().getPageSize(), PAGE_SIZE);
        assertEquals(builder
                        .billingTransactionType(BillingTransactionType.CREDIT)
                        .build().getBillingTransactionType(),
                BILLING_TRANSACTION_TYPE);
    }

    /**
     * This method tests the buildParams method.
     */
    @Test
    public void testBuildParams() {

        assertEquals(transactionPageRequest.buildParams().get("offset"),
                Integer.toString(PAGE));
        assertEquals(transactionPageRequest.buildParams().get("limit"),
                Integer.toString(PAGE_SIZE));
        assertEquals(transactionPageRequest.buildParams()
                        .get("BillingTransactionType"),
                BILLING_TRANSACTION_TYPE.getValue());

        // Testing with null in the billingTransactionType param.
        transactionPageRequest.setBillingTransactionType(null);
        assertFalse(transactionPageRequest.buildParams()
                .containsKey("BillingTransactionType"));
    }

    /**
     * This method tests the setter for the billing transaction type.
     */
    @Test
    public void testSetBillingTransactionType() {

        transactionPageRequest.setBillingTransactionType(
                BillingTransactionType.INVOICE);
        assertEquals(transactionPageRequest.getBillingTransactionType(),
                BillingTransactionType.INVOICE);
    }

    /**
     * This method tests the getNextPage method of TransactionPageRequest.
     */
    @Test
    public void testTransactionPageRequestGetNextPage() {

        assertDoesNotThrow(() -> {

            TransactionPageRequest nextPageRequest = transactionPageRequest
                    .nextPageRequest();

            assertNotNull(nextPageRequest);
            assertEquals(nextPageRequest.getPageNum(), PAGE + 1);
            assertEquals(nextPageRequest.getPageSize(), PAGE_SIZE);
            assertEquals(nextPageRequest.getBillingTransactionType(),
                    BILLING_TRANSACTION_TYPE);
        });
    }
}
