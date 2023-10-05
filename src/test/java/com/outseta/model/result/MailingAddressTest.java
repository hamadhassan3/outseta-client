package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class tests the MailingAddress class.
 */
@ExtendWith(MockitoExtension.class)
public class MailingAddressTest {

    /**
     * The MailingAddress object used for testing.
     */
    private MailingAddress mailingAddress;

    /**
     * A random timestamp to create dates.
     */
    private final long timestamp = 123456789L;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    public void setUp() {
        // Creating a MailingAddress object for testing using the builder
        mailingAddress = MailingAddress.builder()
                .addressLine1("address1")
                .addressLine2("address2")
                .addressLine3("address3")
                .city("city")
                .state("state")
                .postalCode("postalCode")
                .country("country")
                .activityEventData("activityEventData")
                .geoLocation("geoLocation")
                .created(new Date(timestamp))
                .updated(new Date(timestamp))
                .uid("uid")
                .build();
    }

    /**
     * This method tests the MailingAddress class's builder's constructor.
     */
    @Test
    public void testBuilderConstructor() {

        // Testing the builder constructor
        MailingAddress.Builder builder = new MailingAddress.Builder();
        assertNotNull(builder);
    }

    /**
     * This method tests the MailingAddress class's builder method.
     */
    @Test
    public void testBuilder() {

        // Testing the builder method
        MailingAddress.Builder builder = MailingAddress.builder();
        assertNotNull(builder);

        // Creating a MailingAddress object using the builder
        MailingAddress m1 = builder.build();
        assertNotNull(m1);
        assertNull(m1.getAddressLine1());
        assertNull(m1.getAddressLine2());
        assertNull(m1.getAddressLine3());
        assertNull(m1.getCity());
        assertNull(m1.getState());
        assertNull(m1.getPostalCode());
        assertNull(m1.getCountry());
        assertNull(m1.getActivityEventData());
        assertNull(m1.getGeoLocation());
        assertNull(m1.getCreated());
        assertNull(m1.getUpdated());
        assertNull(m1.getUid());

        // Testing the builder's setters
        assertEquals(builder, builder.addressLine1("address1"));
        assertEquals(builder, builder.addressLine2("address2"));
        assertEquals(builder, builder.addressLine3("address3"));
        assertEquals(builder, builder.city("city"));
        assertEquals(builder, builder.state("state"));
        assertEquals(builder, builder.postalCode("postalCode"));
        assertEquals(builder, builder.country("country"));
        assertEquals(builder, builder.activityEventData("activityEventData"));
        assertEquals(builder, builder.geoLocation("geoLocation"));
        assertEquals(builder, builder.created(new Date(timestamp)));
        assertEquals(builder, builder.updated(new Date(timestamp)));
        assertEquals(builder, builder.uid("uid"));

        // Creating a MailingAddress object using the builder
        MailingAddress m2 = builder.build();
        assertNotNull(m2);
        assertEquals("address1", m2.getAddressLine1());
        assertEquals("address2", m2.getAddressLine2());
        assertEquals("address3", m2.getAddressLine3());
        assertEquals("city", m2.getCity());
        assertEquals("state", m2.getState());
        assertEquals("postalCode", m2.getPostalCode());
        assertEquals("country", m2.getCountry());
        assertEquals("activityEventData", m2.getActivityEventData());
        assertEquals("geoLocation", m2.getGeoLocation());
        assertEquals(new Date(timestamp), m2.getCreated());
        assertEquals(new Date(timestamp), m2.getUpdated());
        assertEquals("uid", m2.getUid());
    }

    /**
     * This method tests the MailingAddress class's getAddressLine1 method.
     */
    @Test
    public void testGetAddressLine1() {

        // Testing the getAddressLine1 method
        assertEquals("address1", mailingAddress.getAddressLine1());
    }

    /**
     * This method tests the MailingAddress class's setAddressLine1 method.
     */
    @Test
    public void testSetAddressLine1() {

        // Testing the setAddressLine1 method
        mailingAddress.setAddressLine1("newAddress1");
        assertEquals("newAddress1", mailingAddress.getAddressLine1());
    }

    /**
     * This method tests the MailingAddress class's getAddressLine2 method.
     */
    @Test
    public void testGetAddressLine2() {

        // Testing the getAddressLine2 method
        assertEquals("address2", mailingAddress.getAddressLine2());
    }

    /**
     * This method tests the MailingAddress class's setAddressLine2 method.
     */
    @Test
    public void testSetAddressLine2() {

        // Testing the setAddressLine2 method
        mailingAddress.setAddressLine2("newAddress2");
        assertEquals("newAddress2", mailingAddress.getAddressLine2());
    }

    /**
     * This method tests the MailingAddress class's getAddressLine3 method.
     */
    @Test
    public void testGetAddressLine3() {

        // Testing the getAddressLine3 method
        assertEquals("address3", mailingAddress.getAddressLine3());
    }

    /**
     * This method tests the MailingAddress class's setAddressLine3 method.
     */
    @Test
    public void testSetAddressLine3() {

        // Testing the setAddressLine3 method
        mailingAddress.setAddressLine3("newAddress3");
        assertEquals("newAddress3", mailingAddress.getAddressLine3());
    }

    /**
     * This method tests the MailingAddress class's getCity method.
     */
    @Test
    public void testGetCity() {

        // Testing the getCity method
        assertEquals("city", mailingAddress.getCity());
    }

    /**
     * This method tests the MailingAddress class's setCity method.
     */
    @Test
    public void testSetCity() {

        // Testing the setCity method
        mailingAddress.setCity("newCity");
        assertEquals("newCity", mailingAddress.getCity());
    }

    /**
     * This method tests the MailingAddress class's getState method.
     */
    @Test
    public void testGetState() {

        // Testing the getState method
        assertEquals("state", mailingAddress.getState());
    }

    /**
     * This method tests the MailingAddress class's setState method.
     */
    @Test
    public void testSetState() {

        // Testing the setState method
        mailingAddress.setState("newState");
        assertEquals("newState", mailingAddress.getState());
    }

    /**
     * This method tests the MailingAddress class's getPostalCode method.
     */
    @Test
    public void testGetPostalCode() {

        // Testing the getPostalCode method
        assertEquals("postalCode", mailingAddress.getPostalCode());
    }

    /**
     * This method tests the MailingAddress class's setPostalCode method.
     */
    @Test
    public void testSetPostalCode() {

        // Testing the setPostalCode method
        mailingAddress.setPostalCode("newPostalCode");
        assertEquals("newPostalCode", mailingAddress.getPostalCode());
    }

    /**
     * This method tests the MailingAddress class's getCountry method.
     */
    @Test
    public void testGetCountry() {

        // Testing the getCountry method
        assertEquals("country", mailingAddress.getCountry());
    }

    /**
     * This method tests the MailingAddress class's setCountry method.
     */
    @Test
    public void testSetCountry() {

        // Testing the setCountry method
        mailingAddress.setCountry("newCountry");
        assertEquals("newCountry", mailingAddress.getCountry());
    }

    /**
     * This method tests the MailingAddress class's getActivityEventData method.
     */
    @Test
    public void testGetActivityEventData() {

        // Testing the getActivityEventData method
        assertEquals("activityEventData",
                mailingAddress.getActivityEventData());
    }

    /**
     * This method tests the MailingAddress class's setActivityEventData method.
     */
    @Test
    public void testSetActivityEventData() {

        // Testing the setActivityEventData method
        mailingAddress.setActivityEventData("newActivityEventData");
        assertEquals("newActivityEventData",
                mailingAddress.getActivityEventData());
    }

    /**
     * This method tests the MailingAddress class's getGeoLocation method.
     */
    @Test
    public void testGetGeoLocation() {

        // Testing the getGeoLocation method
        assertEquals("geoLocation", mailingAddress.getGeoLocation());
    }

    /**
     * This method tests the MailingAddress class's setGeoLocation method.
     */
    @Test
    public void testSetGeoLocation() {

        // Testing the setGeoLocation method
        mailingAddress.setGeoLocation("newGeoLocation");
        assertEquals("newGeoLocation", mailingAddress.getGeoLocation());
    }

    /**
     * This method tests the MailingAddress class's getCreated method.
     */
    @Test
    public void testGetCreated() {

        // Testing the getCreated method
        assertEquals(new Date(timestamp), mailingAddress.getCreated());
    }

    /**
     * This method tests the MailingAddress class's setCreated method.
     */
    @Test
    public void testSetCreated() {

        // Testing the setCreated method
        mailingAddress.setCreated(new Date(timestamp + 1));
        assertEquals(new Date(timestamp + 1), mailingAddress.getCreated());
    }

    /**
     * This method tests the MailingAddress class's getUpdated method.
     */
    @Test
    public void testGetUpdated() {

        // Testing the getUpdated method
        assertEquals(new Date(timestamp), mailingAddress.getUpdated());
    }

    /**
     * This method tests the MailingAddress class's setUpdated method.
     */
    @Test
    public void testSetUpdated() {

        // Testing the setUpdated method
        mailingAddress.setUpdated(new Date(timestamp + 1));
        assertEquals(new Date(timestamp + 1), mailingAddress.getUpdated());
    }

    /**
     * This method tests the MailingAddress class's getUid method.
     */
    @Test
    public void testGetUid() {

        // Testing the getUid method
        assertEquals("uid", mailingAddress.getUid());
    }

    /**
     * This method tests the MailingAddress class's setUid method.
     */
    @Test
    public void testSetUid() {

        // Testing the setUid method
        mailingAddress.setUid("newUid");
        assertEquals("newUid", mailingAddress.getUid());
    }

    /**
     * This method tests the MailingAddress class's equals method.
     */
    @Test
    public void testEquals() {

        // Creating an object to compare with
        MailingAddress m1 = new MailingAddress();
        MailingAddress m2 = MailingAddress.builder()
                .addressLine1("address1")
                .addressLine2("address2")
                .addressLine3("address3")
                .city("city")
                .state("state")
                .postalCode("postalCode")
                .country("country")
                .activityEventData("activityEventData")
                .geoLocation("geoLocation")
                .created(new Date(timestamp))
                .updated(new Date(timestamp))
                .uid("uid")
                .build();

        // Testing the equals method
        assertEquals(mailingAddress, mailingAddress);
        assertEquals(mailingAddress, m2);
        assertNotEquals(mailingAddress, null);
        assertNotEquals(mailingAddress, new Object());
        assertNotEquals(mailingAddress, m1);

        m2.setAddressLine1("rand");
        assertNotEquals(mailingAddress, m2);
        m2.setAddressLine1(mailingAddress.getAddressLine1());

        m2.setAddressLine2("rand");
        assertNotEquals(mailingAddress, m2);
        m2.setAddressLine2(mailingAddress.getAddressLine2());

        m2.setAddressLine3("rand");
        assertNotEquals(mailingAddress, m2);
        m2.setAddressLine3(mailingAddress.getAddressLine3());

        m2.setCity("rand");
        assertNotEquals(mailingAddress, m2);
        m2.setCity(mailingAddress.getCity());

        m2.setState("rand");
        assertNotEquals(mailingAddress, m2);
        m2.setState(mailingAddress.getState());

        m2.setPostalCode("rand");
        assertNotEquals(mailingAddress, m2);
        m2.setPostalCode(mailingAddress.getPostalCode());

        m2.setCountry("rand");
        assertNotEquals(mailingAddress, m2);
        m2.setCountry(mailingAddress.getCountry());

        m2.setActivityEventData("rand");
        assertNotEquals(mailingAddress, m2);
        m2.setActivityEventData(mailingAddress.getActivityEventData());

        m2.setGeoLocation("rand");
        assertNotEquals(mailingAddress, m2);
        m2.setGeoLocation(mailingAddress.getGeoLocation());

        m2.setCreated(new Date(timestamp - 1));
        assertNotEquals(mailingAddress, m2);
        m2.setCreated(mailingAddress.getCreated());

        m2.setUpdated(new Date(timestamp - 1));
        assertNotEquals(mailingAddress, m2);
        m2.setUpdated(mailingAddress.getUpdated());

        m2.setUid("rand");
        assertNotEquals(mailingAddress, m2);
        m2.setUid(mailingAddress.getUid());

    }

    /**
     * This method tests the MailingAddress class's hashCode method.
     */
    @Test
    public void testHashCode() {

        // Creating an object to compare with
        MailingAddress m1 = new MailingAddress();

        // Testing the hashCode method
        assertEquals(mailingAddress.hashCode(), mailingAddress.hashCode());
        assertEquals(mailingAddress.hashCode(), MailingAddress.builder()
                .addressLine1("address1")
                .addressLine2("address2")
                .addressLine3("address3")
                .city("city")
                .state("state")
                .postalCode("postalCode")
                .country("country")
                .activityEventData("activityEventData")
                .geoLocation("geoLocation")
                .created(new Date(timestamp))
                .updated(new Date(timestamp))
                .uid("uid")
                .build().hashCode());
        assertNotEquals(mailingAddress.hashCode(), m1.hashCode());
    }
}
