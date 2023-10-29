package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the MarketingSubscriber model.
 */
@ExtendWith(MockitoExtension.class)
public class MarketingSubscriptionTest {

    /**
     * The MarketingSubscriber object to test.
     */
    private MarketingSubscription marketingSubscription;

    /**
     * A mock EmailList object to be used in testing.
     */
    @Mock
    private EmailList emailList1;

    /**
     * A mock EmailList object to be used in testing.
     */
    @Mock
    private EmailList emailList2;

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
     * A random timestamp for creating date objects.
     */
    private static final long TIMESTAMP = 1612137600;

    /**
     * Set up the MarketingSubscriber object to test.
     */
    @BeforeEach
    public void setup() {
        marketingSubscription = MarketingSubscription.builder()
                .emailList(emailList1)
                .person(person1)
                .emailListSubscriberStatus(1)
                .subscribedDate(new Date(TIMESTAMP))
                .confirmedDate(new Date(TIMESTAMP))
                .unsubscribedDate(new Date(TIMESTAMP))
                .cleanedDate(new Date(TIMESTAMP))
                .welcomeEmailDeliverDateTime(new Date(TIMESTAMP))
                .welcomeEmailOpenDateTime(new Date(TIMESTAMP))
                .unsubscribeReason("unsubscribeReason")
                .unsubscribeReasonOther("unsubscribeReasonOther")
                .sendWelcomeEmail(true)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
    }

    /**
     * This method tests the actual values set by the MarketingSubscriber
     * builder.
     */
    @Test
    public void testMarketingSubscriberBuilder() {
        assertEquals(emailList1, marketingSubscription.getEmailList());
        assertEquals(person1, marketingSubscription.getPerson());
        assertEquals(1,
                marketingSubscription.getEmailListSubscriberStatus());
        assertEquals(new Date(TIMESTAMP),
                marketingSubscription.getSubscribedDate());
        assertEquals(new Date(TIMESTAMP),
                marketingSubscription.getConfirmedDate());
        assertEquals(new Date(TIMESTAMP),
                marketingSubscription.getUnsubscribedDate());
        assertEquals(new Date(TIMESTAMP),
                marketingSubscription.getCleanedDate());
        assertEquals(new Date(TIMESTAMP),
                marketingSubscription.getWelcomeEmailDeliverDateTime());
        assertEquals(new Date(TIMESTAMP),
                marketingSubscription.getWelcomeEmailOpenDateTime());
        assertEquals("unsubscribeReason",
                marketingSubscription.getUnsubscribeReason());
        assertEquals("unsubscribeReasonOther",
                marketingSubscription.getUnsubscribeReasonOther());
        assertTrue(marketingSubscription.getSendWelcomeEmail());
        assertEquals("uid", marketingSubscription.getUid());
        assertEquals(new Date(TIMESTAMP), marketingSubscription.getCreated());
        assertEquals(new Date(TIMESTAMP), marketingSubscription.getUpdated());
    }

    /**
     * This method tests the default values set by the MarketingSubscriber
     * builder.
     */
    @Test
    public void testMarketingSubscriberBuilderDefaults() {
        marketingSubscription = MarketingSubscription.builder()
                .build();
        assertNull(marketingSubscription.getEmailList());
        assertNull(marketingSubscription.getPerson());
        assertNull(marketingSubscription.getEmailListSubscriberStatus());
        assertNull(marketingSubscription.getSubscribedDate());
        assertNull(marketingSubscription.getConfirmedDate());
        assertNull(marketingSubscription.getUnsubscribedDate());
        assertNull(marketingSubscription.getCleanedDate());
        assertNull(marketingSubscription.getWelcomeEmailDeliverDateTime());
        assertNull(marketingSubscription.getWelcomeEmailOpenDateTime());
        assertNull(marketingSubscription.getUnsubscribeReason());
        assertNull(marketingSubscription.getUnsubscribeReasonOther());
        assertNull(marketingSubscription.getSendWelcomeEmail());
        assertNull(marketingSubscription.getCreated());
        assertNull(marketingSubscription.getUpdated());
    }

    /**
     * This method tests the get and set methods for the emailList field.
     */
    @Test
    public void testGetSetEmailList() {
        marketingSubscription.setEmailList(emailList2);
        assertEquals(emailList2, marketingSubscription.getEmailList());
    }

    /**
     * This method tests the get and set methods for the person field.
     */
    @Test
    public void testGetSetPerson() {
        marketingSubscription.setPerson(person2);
        assertEquals(person2, marketingSubscription.getPerson());
    }

    /**
     * This method tests the get and set methods for the
     * emailListSubscriberStatus field.
     */
    @Test
    public void testGetSetEmailListSubscriberStatus() {
        marketingSubscription.setEmailListSubscriberStatus(2);
        assertEquals(2,
                marketingSubscription.getEmailListSubscriberStatus());
    }

    /**
     * This method tests the get and set methods for the subscribedDate field.
     */
    @Test
    public void testGetSetSubscribedDate() {
        marketingSubscription.setSubscribedDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1),
                marketingSubscription.getSubscribedDate());
    }

    /**
     * This method tests the get and set methods for the confirmedDate field.
     */
    @Test
    public void testGetSetConfirmedDate() {
        marketingSubscription.setConfirmedDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1),
                marketingSubscription.getConfirmedDate());
    }

    /**
     * This method tests the get and set methods for the unsubscribedDate
     * field.
     */
    @Test
    public void testGetSetUnsubscribedDate() {
        marketingSubscription.setUnsubscribedDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1),
                marketingSubscription.getUnsubscribedDate());
    }

    /**
     * This method tests the get and set methods for the cleanedDate field.
     */
    @Test
    public void testGetSetCleanedDate() {
        marketingSubscription.setCleanedDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1),
                marketingSubscription.getCleanedDate());
    }

    /**
     * This method tests the get and set methods for the
     * welcomeEmailDeliverDateTime field.
     */
    @Test
    public void testGetSetWelcomeEmailDeliverDateTime() {
        marketingSubscription.setWelcomeEmailDeliverDateTime(
                new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1),
                marketingSubscription.getWelcomeEmailDeliverDateTime());
    }

    /**
     * This method tests the get and set methods for the
     * welcomeEmailOpenDateTime field.
     */
    @Test
    public void testGetSetWelcomeEmailOpenDateTime() {
        marketingSubscription.setWelcomeEmailOpenDateTime(
                new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1),
                marketingSubscription.getWelcomeEmailOpenDateTime());
    }

    /**
     * This method tests the get and set methods for the unsubscribeReason
     * field.
     */
    @Test
    public void testGetSetUnsubscribeReason() {
        marketingSubscription.setUnsubscribeReason("unsubscribeReason2");
        assertEquals("unsubscribeReason2",
                marketingSubscription.getUnsubscribeReason());
    }

    /**
     * This method tests the get and set methods for the unsubscribeReasonOther
     * field.
     */
    @Test
    public void testGetSetUnsubscribeReasonOther() {
        marketingSubscription.setUnsubscribeReasonOther(
                "unsubscribeReasonOther2");
        assertEquals("unsubscribeReasonOther2",
                marketingSubscription.getUnsubscribeReasonOther());
    }

    /**
     * This method tests the get and set methods for the sendWelcomeEmail
     * field.
     */
    @Test
    public void testGetSetSendWelcomeEmail() {
        marketingSubscription.setSendWelcomeEmail(false);
        assertEquals(false, marketingSubscription.getSendWelcomeEmail());
    }

    /**
     * This method tests the get and set methods for the uid field.
     */
    @Test
    public void testGetSetUid() {
        marketingSubscription.setUid("uid2");
        assertEquals("uid2", marketingSubscription.getUid());
    }

    /**
     * This method tests the get and set methods for the created field.
     */
    @Test
    public void testGetSetCreated() {
        marketingSubscription.setCreated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1),
                marketingSubscription.getCreated());
    }

    /**
     * This method tests the get and set methods for the updated field.
     */
    @Test
    public void testGetSetUpdated() {
        marketingSubscription.setUpdated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1),
                marketingSubscription.getUpdated());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {
        MarketingSubscription marketingSubscription2 =
                MarketingSubscription.builder()
                .emailList(emailList1)
                .person(person1)
                .emailListSubscriberStatus(1)
                .subscribedDate(new Date(TIMESTAMP))
                .confirmedDate(new Date(TIMESTAMP))
                .unsubscribedDate(new Date(TIMESTAMP))
                .cleanedDate(new Date(TIMESTAMP))
                .welcomeEmailDeliverDateTime(new Date(TIMESTAMP))
                .welcomeEmailOpenDateTime(new Date(TIMESTAMP))
                .unsubscribeReason("unsubscribeReason")
                .unsubscribeReasonOther("unsubscribeReasonOther")
                .sendWelcomeEmail(true)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
        assertEquals(marketingSubscription, marketingSubscription2);
        assertEquals(marketingSubscription, marketingSubscription);

        assertNotEquals(marketingSubscription, null);
        assertNotEquals(marketingSubscription, new Object());
        assertNotEquals(marketingSubscription, MarketingSubscription.builder()
                .uid("newUid")
                .build());
    }

    /**
     * This method tests the hashCode method.
     */
    @Test
    public void testHashCode() {
        MarketingSubscription marketingSubscription2 = MarketingSubscription
                .builder()
                .emailList(emailList1)
                .person(person1)
                .emailListSubscriberStatus(1)
                .subscribedDate(new Date(TIMESTAMP))
                .confirmedDate(new Date(TIMESTAMP))
                .unsubscribedDate(new Date(TIMESTAMP))
                .cleanedDate(new Date(TIMESTAMP))
                .welcomeEmailDeliverDateTime(new Date(TIMESTAMP))
                .welcomeEmailOpenDateTime(new Date(TIMESTAMP))
                .unsubscribeReason("unsubscribeReason")
                .unsubscribeReasonOther("unsubscribeReasonOther")
                .sendWelcomeEmail(true)
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
        assertEquals(marketingSubscription.hashCode(),
                marketingSubscription2.hashCode());
    }

}
