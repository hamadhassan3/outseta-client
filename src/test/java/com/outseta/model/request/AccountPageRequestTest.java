package com.outseta.model.request;

import com.outseta.constant.AccountStage;
import com.outseta.constant.Sort;
import com.outseta.exception.OutsetaPageBuildException;
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
 * This class tests the AccountPageRequest class.
 */
@ExtendWith(MockitoExtension.class)
public class AccountPageRequestTest {

    /**
     * The AccountPageRequest object to test.
     */
    private AccountPageRequest accountPageRequest;

    /**
     * The page number to test.
     */
    private static final int PAGE = 1;

    /**
     * The page size to test.
     */
    private static final int PAGE_SIZE = 10;

    /**
     * The account stage to test.
     */
    private static final AccountStage ACCOUNT_STAGE = AccountStage.Expired;

    /**
     * This method is called before each test.
     */
    @BeforeEach
    public void setUp() throws OutsetaPageBuildException {

        accountPageRequest = AccountPageRequest.builder()
                .page(PAGE)
                .pageSize(PAGE_SIZE)
                .orderBy("id")
                .orderByDirection(Sort.ASC)
                .customParams(new HashMap<>())
                .accountStage(ACCOUNT_STAGE)
                .build();
    }

    /**
     * This method tests the AccountPageRequest's builder's constructor.
     */
    @Test
    public void testBuilderConstructor() throws OutsetaPageBuildException {

        final AccountPageRequest.Builder builder =
                new AccountPageRequest.Builder();

        assertNull(builder.build().getPageNum());
        assertNull(builder.build().getPageSize());
        assertNull(builder.build().getAccountStage());

        assertEquals(builder.page(PAGE).build().getPageNum(), PAGE);
        assertEquals(builder
                .pageSize(PAGE_SIZE).build().getPageSize(), PAGE_SIZE);
        assertEquals(builder
                        .accountStage(AccountStage.Expired)
                        .build().getAccountStage(),
                ACCOUNT_STAGE);
    }

    /**
     * This method tests the buildParams method.
     */
    @Test
    public void testBuildParams() {

        assertEquals(accountPageRequest.buildParams().get("offset"),
                Integer.toString(PAGE));
        assertEquals(accountPageRequest.buildParams().get("limit"),
                Integer.toString(PAGE_SIZE));
        assertEquals(accountPageRequest.buildParams()
                        .get("AccountStage"),
                ACCOUNT_STAGE.getValue());

        // Testing with null in the accountStage param.
        accountPageRequest.setAccountStage(null);
        assertFalse(accountPageRequest.buildParams()
                .containsKey("AccountStage"));
    }

    /**
     * This method tests the setter for the account stage.
     */
    @Test
    public void testSetAccountStage() {

        accountPageRequest.setAccountStage(AccountStage.Expired);
        assertEquals(accountPageRequest.getAccountStage(),
                AccountStage.Expired);
    }

    /**
     * This method tests the getNextPage method of AccountPageRequest.
     */
    @Test
    public void testTransactionPageRequestGetNextPage() {

        assertDoesNotThrow(() -> {

            AccountPageRequest nextPageRequest = accountPageRequest
                    .nextPageRequest();

            assertNotNull(nextPageRequest);
            assertEquals(nextPageRequest.getPageNum(), PAGE + 1);
            assertEquals(nextPageRequest.getPageSize(), PAGE_SIZE);
            assertEquals(nextPageRequest.getAccountStage(),
                    ACCOUNT_STAGE);
        });
    }
}
