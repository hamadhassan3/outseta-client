package com.outseta.model.result;

import com.outseta.constant.AccountStage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * This class tests the Account class.
 */
@ExtendWith(MockitoExtension.class)
public class AccountTest {

    /**
     * Creating a random timestamp for date creation.
     */
    private static final long TIMESTAMP = 123456789L;

    /**
     * The Account object used for testing.
     */
    private Account account;

    /**
     * The Account object used for testing.
     */
    @Mock
    private Address mailingAddress1;

    /**
     * The Account object used for testing.
     */
    @Mock
    private Address mailingAddress2;

    /**
     * The Account object used for testing.
     */
    @Mock
    private Address billingAddress1;

    /**
     * The Account object used for testing.
     */
    @Mock
    private Address billingAddress2;

    /**
     * The Account object used for testing.
     */
    @Mock
    private PersonAccount personAccount1;

    /**
     * The Account object used for testing.
     */
    @Mock
    private PersonAccount personAccount2;

    /**
     * The Subscription object used for testing.
     */
    @Mock
    private Subscription subscription1;

    /**
     * The Subscription object used for testing.
     */
    @Mock
    private Subscription subscription2;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    public void setUp() {
        // Creating an Account object for testing
        account = Account.builder()
                .uid("uid")
                .name("name")
                .accountStage(AccountStage.Expired)
                .billingAddress(billingAddress1)
                .mailingAddress(mailingAddress1)
                .clientIdentifier("clientIdentifier")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .paymentInformation("paymentInformation")
                .personAccount(List.of(personAccount1))
                .subscriptions(List.of(subscription1))
                .build();
    }

    /**
     * This method tests the setter for uid.
     */
    @Test
    public void testSetUid() {
        // Setting the uid to a new value
        account.setUid("newUid");

        // Checking that the uid was set to the new value
        assertEquals("newUid", account.getUid());
    }

    /**
     * This method tests the setter for accountStage.
     */
    @Test
    public void testSetAccountStage() {
        // Setting the accountStage to a new value
        account.setAccountStage(AccountStage.PastDue.getValue());

        // Checking that the accountStage was set to the new value
        assertEquals(AccountStage.PastDue.getValue(),
                account.getAccountStage());
    }

    /**
     * This method tests the setter for billingAddress.
     */
    @Test
    public void testSetBillingAddress() {
        // Setting the billingAddress to a new value
        account.setBillingAddress(billingAddress2);

        // Checking that the billingAddress was set to the new value
        assertEquals(billingAddress2, account.getBillingAddress());

    }

    /**
     * This method tests the setter for mailingAddress.
     */
    @Test
    public void testSetMailingAddress() {
        // Setting the mailingAddress to a new value
        account.setMailingAddress(mailingAddress2);

        // Checking that the mailingAddress was set to the new value
        assertEquals(mailingAddress2, account.getMailingAddress());
    }

    /**
     * This method tests the setter for clientIdentifier.
     */
    @Test
    public void testSetClientIdentifier() {
        // Setting the clientIdentifier to a new value
        account.setClientIdentifier("newClientIdentifier");

        // Checking that the clientIdentifier was set to the new value
        assertEquals("newClientIdentifier", account.getClientIdentifier());
    }

    /**
     * This method tests the setter for created.
     */
    @Test
    public void testSetCreated() {
        // Setting the created to a new value
        account.setCreated(new Date(TIMESTAMP + 1));

        // Checking that the created was set to the new value
        assertEquals(new Date(TIMESTAMP + 1), account.getCreated());
    }

    /**
     * This method tests the setter for updated.
     */
    @Test
    public void testSetUpdated() {
        // Setting the updated to a new value
        account.setUpdated(new Date(TIMESTAMP + 1));

        // Checking that the updated was set to the new value
        assertEquals(new Date(TIMESTAMP + 1), account.getUpdated());
    }

    /**
     * This method tests the setter for paymentInformation.
     */
    @Test
    public void testSetPaymentInformation() {
        // Setting the paymentInformation to a new value
        account.setPaymentInformation("newPaymentInformation");

        // Checking that the paymentInformation was set to the new value
        assertEquals("newPaymentInformation", account.getPaymentInformation());
    }

    /**
     * This method tests the setter for personAccounts.
     */
    @Test
    public void testSetPersonAccounts() {
        // Setting the personAccounts to a new value
        account.setPersonAccount(List.of(personAccount1, personAccount2));

        // Checking that the personAccounts was set to the new value
        assertEquals(List.of(personAccount1, personAccount2),
                account.getPersonAccount());
    }

    /**
     * This method tests the setter for name.
     */
    @Test
    public void testSetName() {
        // Setting the name to a new value
        account.setName("newName");

        // Checking that the name was set to the new value
        assertEquals("newName", account.getName());
    }

    /**
     * This method tests the setter for subscriptions.
     */
    @Test
    public void testSetSubscriptions() {
        // Setting the subscriptions to a new value
        account.setSubscriptions(List.of(subscription1, subscription2));

        // Checking that the subscriptions was set to the new value
        assertEquals(List.of(subscription1, subscription2),
                account.getSubscriptions());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {
        // Creating an Account object with the same values as the original
        Account account2 = Account.builder()
                .uid("uid")
                .name("name")
                .accountStage(AccountStage.Expired)
                .billingAddress(billingAddress1)
                .mailingAddress(mailingAddress1)
                .clientIdentifier("clientIdentifier")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .paymentInformation("paymentInformation")
                .personAccount(List.of(personAccount1))
                .subscriptions(List.of(subscription1))
                .build();

        // Checking that the two objects are equal
        assertEquals(account, account2);

        account2.setUid("newUid");
        assertNotEquals(account, account2);
        account2.setUid(account.getUid());

        assertNotEquals(account, null);
        assertNotEquals(account, new Object());
        assertEquals(account, account);
    }

    /**
     * This method tests the hashCode method.
     */
    @Test
    public void testHashCode() {
        Account account2 = Account.builder()
                .uid("uid")
                .name("name")
                .accountStage(AccountStage.Expired)
                .billingAddress(billingAddress1)
                .mailingAddress(mailingAddress1)
                .clientIdentifier("clientIdentifier")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .paymentInformation("paymentInformation")
                .personAccount(List.of(personAccount1))
                .subscriptions(List.of(subscription1))
                .build();
        assertEquals(account.hashCode(), account2.hashCode());
    }
}
