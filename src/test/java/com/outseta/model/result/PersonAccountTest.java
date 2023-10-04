package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class tests the PersonAccount class.
 */
@ExtendWith(MockitoExtension.class)
public class PersonAccountTest {

    /**
     * The PersonAccount object used for testing.
     */
    private PersonAccount personAccount;

    /**
     * Creating a random timestamp for date creation.
     */
    private static final long TIMESTAMP = 123456789L;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    public void setUp() {
        // Creating a PersonAccount object for testing
        personAccount = new PersonAccount();
    }

    /**
     * This method tests the PersonAccount class's constructor.
     */
    @Test
    public void testConstructor() {
        // Testing the constructor
        assertNull(personAccount.getPerson());
        assertNull(personAccount.getAccount());
        assertNull(personAccount.getUid());
        assertNull(personAccount.getCreated());
        assertNull(personAccount.getUpdated());
        assertNull(personAccount.getPrimary());
        assertNull(personAccount.getReceiveInvoices());
        assertNull(personAccount.getActivityEventData());
    }

    /**
     * This method tests the PersonAccount class's getPerson method.
     */
    @Test
    public void testGetPerson() {
        assertNull(personAccount.getPerson());
    }

    /**
     * This method tests the PersonAccount class's setPerson method.
     */
    @Test
    public void testSetPerson() {
        Person newPerson = new Person();
        personAccount.setPerson(newPerson);
        assertEquals(newPerson, personAccount.getPerson());
    }

    /**
     * This method tests the PersonAccount class's getAccount method.
     */
    @Test
    public void testGetAccount() {
        assertNull(personAccount.getAccount());
    }

    /**
     * This method tests the PersonAccount class's setAccount method.
     */
    @Test
    public void testSetAccount() {
        PersonAccount newAccount = new PersonAccount();
        personAccount.setAccount(newAccount);
        assertEquals(newAccount, personAccount.getAccount());
    }

    /**
     * This method tests the PersonAccount class's getUid method.
     */
    @Test
    public void testGetUid() {
        assertNull(personAccount.getUid());
    }

    /**
     * This method tests the PersonAccount class's setUid method.
     */
    @Test
    public void testSetUid() {
        String newUid = "newUid";
        personAccount.setUid(newUid);
        assertEquals(newUid, personAccount.getUid());
    }

    /**
     * This method tests the PersonAccount class's getCreated method.
     */
    @Test
    public void testGetCreated() {
        assertNull(personAccount.getCreated());
    }

    /**
     * This method tests the PersonAccount class's setCreated method.
     */
    @Test
    public void testSetCreated() {
        personAccount.setCreated(new Date(TIMESTAMP));
        assertEquals(new Date(TIMESTAMP), personAccount.getCreated());
    }

    /**
     * This method tests the PersonAccount class's getUpdated method.
     */
    @Test
    public void testGetUpdated() {
        assertNull(personAccount.getUpdated());
    }

    /**
     * This method tests the PersonAccount class's setUpdated method.
     */
    @Test
    public void testSetUpdated() {
        personAccount.setUpdated(new Date(TIMESTAMP));
        assertEquals(new Date(TIMESTAMP), personAccount.getUpdated());
    }

    /**
     * This method tests the PersonAccount class's getPrimary method.
     */
    @Test
    public void testGetPrimary() {
        assertNull(personAccount.getPrimary());
    }

    /**
     * This method tests the PersonAccount class's setPrimary method.
     */
    @Test
    public void testSetPrimary() {
        personAccount.setPrimary(true);
        assertEquals(true, personAccount.getPrimary());
    }

    /**
     * This method tests the PersonAccount class's getReceiveInvoices method.
     */
    @Test
    public void testGetReceiveInvoices() {
        assertNull(personAccount.getReceiveInvoices());
    }

    /**
     * This method tests the PersonAccount class's setReceiveInvoices method.
     */
    @Test
    public void testSetReceiveInvoices() {
        personAccount.setReceiveInvoices(true);
        assertEquals(true, personAccount.getReceiveInvoices());
    }

    /**
     * This method tests the PersonAccount class's getActivityEventData method.
     */
    @Test
    public void testGetActivityEventData() {
        assertNull(personAccount.getActivityEventData());
    }

    /**
     * This method tests the PersonAccount class's setActivityEventData method.
     */
    @Test
    public void testSetActivityEventData() {
        personAccount.setActivityEventData("activityEventData");
        assertEquals("activityEventData",
                personAccount.getActivityEventData());
    }

    /**
     * This method tests the PersonAccount class's equals method.
     */
    @Test
    public void testEquals() {

        Person person = new Person();
        PersonAccount account = new PersonAccount();
        String uid = "uid";
        Date created = new Date(TIMESTAMP);
        Date updated = new Date(TIMESTAMP);
        Boolean primary = true;
        Boolean receiveInvoices = true;
        String activityEventData = "activityEventData";

        // Testing the equals method
        PersonAccount pa1 = new PersonAccount();
        PersonAccount pa2 = new PersonAccount();
        PersonAccount pa3 = new PersonAccount();
        pa3.setPerson(person);
        pa3.setAccount(account);
        pa3.setUid(uid);
        pa3.setCreated(created);
        pa3.setUpdated(updated);
        pa3.setPrimary(primary);
        pa3.setReceiveInvoices(receiveInvoices);
        pa3.setActivityEventData(activityEventData);

        personAccount.setPerson(person);
        personAccount.setAccount(account);
        personAccount.setUid(uid);
        personAccount.setCreated(created);
        personAccount.setUpdated(updated);
        personAccount.setPrimary(primary);
        personAccount.setReceiveInvoices(receiveInvoices);
        personAccount.setActivityEventData(activityEventData);

        assertEquals(pa1, pa2);
        assertEquals(pa1, pa1);
        assertNotEquals(pa1, null);
        assertNotEquals(pa1, new Object());
        assertNotEquals(pa1, pa3);
        assertEquals(personAccount, pa3);

        pa3.setUid("uid2");
        assertNotEquals(personAccount, pa3);
        pa3.setUid(personAccount.getUid());

        pa3.setCreated(new Date(TIMESTAMP + 1));
        assertNotEquals(personAccount, pa3);
        pa3.setCreated(personAccount.getCreated());

        pa3.setUpdated(new Date(TIMESTAMP + 1));
        assertNotEquals(personAccount, pa3);
        pa3.setUpdated(personAccount.getUpdated());

        pa3.setPrimary(false);
        assertNotEquals(personAccount, pa3);
        pa3.setPrimary(personAccount.getPrimary());

        pa3.setReceiveInvoices(false);
        assertNotEquals(personAccount, pa3);
        pa3.setReceiveInvoices(personAccount.getReceiveInvoices());

        pa3.setActivityEventData("activityEventData2");
        assertNotEquals(personAccount, pa3);
        pa3.setActivityEventData(personAccount.getActivityEventData());

        pa3.setPerson(null);
        assertNotEquals(personAccount, pa3);
        pa3.setPerson(personAccount.getPerson());

        pa3.setAccount(null);
        assertNotEquals(personAccount, pa3);
        pa3.setAccount(personAccount.getAccount());

    }

    /**
     * This method tests the hashCode method.
     */
    @Test
    public void testHashCode() {

        Person person = new Person();
        PersonAccount account = new PersonAccount();
        String uid = "uid";
        Date created = new Date(TIMESTAMP);
        Date updated = new Date(TIMESTAMP);
        Boolean primary = true;
        Boolean receiveInvoices = true;
        String activityEventData = "activityEventData";

        // Testing the hashCode method
        PersonAccount pa1 = new PersonAccount();
        PersonAccount pa2 = new PersonAccount();
        PersonAccount pa3 = new PersonAccount();
        pa3.setPerson(person);
        pa3.setAccount(account);
        pa3.setUid(uid);
        pa3.setCreated(created);
        pa3.setUpdated(updated);
        pa3.setPrimary(primary);
        pa3.setReceiveInvoices(receiveInvoices);
        pa3.setActivityEventData(activityEventData);

        personAccount.setPerson(person);
        personAccount.setAccount(account);
        personAccount.setUid(uid);
        personAccount.setCreated(created);
        personAccount.setUpdated(updated);
        personAccount.setPrimary(primary);
        personAccount.setReceiveInvoices(receiveInvoices);
        personAccount.setActivityEventData(activityEventData);

        assertEquals(pa1.hashCode(), pa2.hashCode());
        assertEquals(pa1.hashCode(), pa1.hashCode());
        assertNotEquals(pa1.hashCode(), pa3.hashCode());
        assertEquals(personAccount.hashCode(), pa3.hashCode());
    }
}
