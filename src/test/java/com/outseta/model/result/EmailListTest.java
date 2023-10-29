package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class is used to test the EmailList class.
 */
@ExtendWith(MockitoExtension.class)
public class EmailListTest {

    /**
     * The EmailList object to test.
     */
    private EmailList emailList;

    /**
     * A mock person object for testing.
     */
    @Mock
    private Person person1;

    /**
     * A mock person object for testing.
     */
    @Mock
    private Person person2;

    /**
     * A random timestamp used for creating dates.
     */
    private static final long TIMESTAMP = 1612137600L;

    /**
     * The count for active subscriptions.
     */
    private static final int COUNT_SUBSCRIPTIONS_ACTIVE = 1;

    /**
     * The count for bounced subscriptions.
     */
    private static final int COUNT_SUBSCRIPTIONS_BOUNCE = 2;

    /**
     * The count for spam subscriptions.
     */
    private static final int COUNT_SUBSCRIPTIONS_SPAM = 3;

    /**
     * The count for unsubscribed subscriptions.
     */
    private static final int COUNT_SUBSCRIPTIONS_UNSUBSCRIBED = 4;

    /**
     * This method sets up the test environment before each test.
     */
    @BeforeEach
    public void setup() {
        emailList = EmailList.builder()
                .name("name")
                .welcomeSubject("welcomeSubject")
                .welcomeBody("welcomeBody")
                .welcomeFromName("welcomeFromName")
                .welcomeFromEmail("welcomeFromEmail")
                .emailListPerson(List.of(person1))
                .countSubscriptionsActive(COUNT_SUBSCRIPTIONS_ACTIVE)
                .countSubscriptionsBounce(COUNT_SUBSCRIPTIONS_BOUNCE)
                .countSubscriptionsSpam(COUNT_SUBSCRIPTIONS_SPAM)
                .countSubscriptionsUnsubscribed(
                        COUNT_SUBSCRIPTIONS_UNSUBSCRIBED)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
    }

    /**
     * This method tests the values set by builder.
     */
    @Test
    public void testBuilder() {
        assertEquals("name", emailList.getName());
        assertEquals("welcomeSubject", emailList.getWelcomeSubject());
        assertEquals("welcomeBody", emailList.getWelcomeBody());
        assertEquals("welcomeFromName", emailList.getWelcomeFromName());
        assertEquals("welcomeFromEmail", emailList.getWelcomeFromEmail());
        assertEquals(List.of(person1), emailList.getEmailListPerson());
        assertEquals(COUNT_SUBSCRIPTIONS_ACTIVE,
                emailList.getCountSubscriptionsActive());
        assertEquals(COUNT_SUBSCRIPTIONS_BOUNCE,
                emailList.getCountSubscriptionsBounce());
        assertEquals(COUNT_SUBSCRIPTIONS_SPAM,
                emailList.getCountSubscriptionsSpam());
        assertEquals(COUNT_SUBSCRIPTIONS_UNSUBSCRIBED,
                emailList.getCountSubscriptionsUnsubscribed());
        assertEquals("uid", emailList.getUid());
        assertEquals(new Date(TIMESTAMP), emailList.getCreated());
        assertEquals(new Date(TIMESTAMP), emailList.getUpdated());
    }

    /**
     * This method tests the default values set by builder.
     */
    @Test
    public void testBuilderDefaults() {
        emailList = EmailList.builder().build();
        assertNull(emailList.getName());
        assertNull(emailList.getWelcomeSubject());
        assertNull(emailList.getWelcomeBody());
        assertNull(emailList.getWelcomeFromName());
        assertNull(emailList.getWelcomeFromEmail());
        assertNull(emailList.getEmailListPerson());
        assertNull(emailList.getCountSubscriptionsActive());
        assertNull(emailList.getCountSubscriptionsBounce());
        assertNull(emailList.getCountSubscriptionsSpam());
        assertNull(emailList.getCountSubscriptionsUnsubscribed());
        assertNull(emailList.getUid());
        assertNull(emailList.getCreated());
        assertNull(emailList.getUpdated());
    }

    /**
     * This method tests the get and set methods for name.
     */
    @Test
    public void testGetSetName() {
        emailList.setName("newName");
        assertEquals("newName", emailList.getName());
    }

    /**
     * This method tests the get and set methods for welcomeSubject.
     */
    @Test
    public void testGetSetWelcomeSubject() {
        emailList.setWelcomeSubject("newWelcomeSubject");
        assertEquals("newWelcomeSubject", emailList.getWelcomeSubject());
    }

    /**
     * This method tests the get and set methods for welcomeBody.
     */
    @Test
    public void testGetSetWelcomeBody() {
        emailList.setWelcomeBody("newWelcomeBody");
        assertEquals("newWelcomeBody", emailList.getWelcomeBody());
    }

    /**
     * This method tests the get and set methods for welcomeFromName.
     */
    @Test
    public void testGetSetWelcomeFromName() {
        emailList.setWelcomeFromName("newWelcomeFromName");
        assertEquals("newWelcomeFromName", emailList.getWelcomeFromName());
    }

    /**
     * This method tests the get and set methods for welcomeFromEmail.
     */
    @Test
    public void testGetSetWelcomeFromEmail() {
        emailList.setWelcomeFromEmail("newWelcomeFromEmail");
        assertEquals("newWelcomeFromEmail", emailList.getWelcomeFromEmail());
    }

    /**
     * This method tests the get and set methods for emailListPerson.
     */
    @Test
    public void testGetSetEmailListPerson() {
        emailList.setEmailListPerson(List.of(person2));
        assertEquals(List.of(person2), emailList.getEmailListPerson());
    }

    /**
     * This method tests the get and set methods for countSubscriptionsActive.
     */
    @Test
    public void testGetSetCountSubscriptionsActive() {
        emailList.setCountSubscriptionsActive(COUNT_SUBSCRIPTIONS_ACTIVE + 1);
        assertEquals(COUNT_SUBSCRIPTIONS_ACTIVE + 1,
                emailList.getCountSubscriptionsActive());
    }

    /**
     * This method tests the get and set methods for countSubscriptionsBounce.
     */
    @Test
    public void testGetSetCountSubscriptionsBounce() {
        emailList.setCountSubscriptionsBounce(COUNT_SUBSCRIPTIONS_BOUNCE + 1);
        assertEquals(COUNT_SUBSCRIPTIONS_BOUNCE + 1,
                emailList.getCountSubscriptionsBounce());
    }

    /**
     * This method tests the get and set methods for countSubscriptionsSpam.
     */
    @Test
    public void testGetSetCountSubscriptionsSpam() {
        emailList.setCountSubscriptionsSpam(COUNT_SUBSCRIPTIONS_SPAM + 1);
        assertEquals(COUNT_SUBSCRIPTIONS_SPAM + 1,
                emailList.getCountSubscriptionsSpam());
    }

    /**
     * This method tests the get and set methods for
     * countSubscriptionsUnsubscribed.
     */
    @Test
    public void testGetSetCountSubscriptionsUnsubscribed() {
        emailList.setCountSubscriptionsUnsubscribed(
                COUNT_SUBSCRIPTIONS_UNSUBSCRIBED + 1);
        assertEquals(COUNT_SUBSCRIPTIONS_UNSUBSCRIBED + 1,
                emailList.getCountSubscriptionsUnsubscribed());
    }

    /**
     * This method tests the get and set methods for uid.
     */
    @Test
    public void testGetSetUid() {
        emailList.setUid("newUid");
        assertEquals("newUid", emailList.getUid());
    }

    /**
     * This method tests the get and set methods for created.
     */
    @Test
    public void testGetSetCreated() {
        emailList.setCreated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), emailList.getCreated());
    }

    /**
     * This method tests the get and set methods for updated.
     */
    @Test
    public void testGetSetUpdated() {
        emailList.setUpdated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), emailList.getUpdated());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {
        EmailList emailList2 = EmailList.builder()
                .name("name")
                .welcomeSubject("welcomeSubject")
                .welcomeBody("welcomeBody")
                .welcomeFromName("welcomeFromName")
                .welcomeFromEmail("welcomeFromEmail")
                .emailListPerson(List.of(person1))
                .countSubscriptionsActive(COUNT_SUBSCRIPTIONS_ACTIVE)
                .countSubscriptionsBounce(COUNT_SUBSCRIPTIONS_BOUNCE)
                .countSubscriptionsSpam(COUNT_SUBSCRIPTIONS_SPAM)
                .countSubscriptionsUnsubscribed(
                        COUNT_SUBSCRIPTIONS_UNSUBSCRIBED)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .build();
        assertEquals(emailList, emailList2);
        assertEquals(emailList, emailList);

        assertNotEquals(emailList, null);
        assertNotEquals(emailList, new Object());
        assertNotEquals(emailList, EmailList.builder().build());
    }

    /**
     * This method tests the hashcode method.
     */
    @Test
    public void testHashCode() {
        EmailList emailList2 = EmailList.builder()
                .name("name")
                .welcomeSubject("welcomeSubject")
                .welcomeBody("welcomeBody")
                .welcomeFromName("welcomeFromName")
                .welcomeFromEmail("welcomeFromEmail")
                .emailListPerson(List.of(person1))
                .countSubscriptionsActive(COUNT_SUBSCRIPTIONS_ACTIVE)
                .countSubscriptionsBounce(COUNT_SUBSCRIPTIONS_BOUNCE)
                .countSubscriptionsSpam(COUNT_SUBSCRIPTIONS_SPAM)
                .countSubscriptionsUnsubscribed(
                        COUNT_SUBSCRIPTIONS_UNSUBSCRIBED)
                .uid("uid")
                .created(new Date(TIMESTAMP + 1))
                .build();
        assertEquals(emailList.hashCode(), emailList2.hashCode());
    }
}
