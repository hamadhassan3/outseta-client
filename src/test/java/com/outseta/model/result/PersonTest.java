package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class tests the Person class.
 */
@ExtendWith(MockitoExtension.class)
public class PersonTest {

    /**
     * The Person object used for testing.
     */
    private Person person;

    /**
     * Creating a random timestamp for date creation.
     */
    private static final long TIMESTAMP = 123456789L;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    public void setUp() {
        // Creating a Person object using builder for testing
        person = Person.builder()
                .uid("123")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .email("email")
                .firstName("firstName")
                .lastName("lastName")
                .language("language")
                .emailBounceDateTime(new Date(TIMESTAMP))
                .emailSpamDateTime(new Date(TIMESTAMP))
                .fullName("fullName")
                .ipAddress("ipAddress")
                .lastLoginDateTime(new Date(TIMESTAMP))
                .oAuthGoogleProfileId("oAuthGoogleProfileId")
                .phoneWork("phoneWork")
                .profileImageS3Url("profileImageS3Url")
                .referer("referer")
                .timezone("timezone")
                .emailLastDeliveredDateTime(new Date(TIMESTAMP))
                .emailUnsubscribeDateTime(new Date(TIMESTAMP))
                .passwordLastUpdated(new Date(TIMESTAMP))
                .passwordMustChange(true)
                .phoneMobile("phoneMobile")
                .personAccount(null)
                .mailingAddress(null)
                .title("title")
                .userAgent("userAgent")
                .build();
    }

    /**
     * This method tests the Person class's constructor.
     */
    @Test
    public void testConstructor() {

        Person p = new Person();
        assertNull(p.getCreated());
        assertNull(p.getUpdated());
        assertNull(p.getEmail());
        assertNull(p.getFirstName());
        assertNull(p.getLastName());
        assertNull(p.getLanguage());
        assertNull(p.getEmailBounceDateTime());
        assertNull(p.getEmailSpamDateTime());
        assertNull(p.getFullName());
        assertNull(p.getIpAddress());
        assertNull(p.getLastLoginDateTime());
        assertNull(p.getoAuthGoogleProfileId());
        assertNull(p.getPhoneWork());
        assertNull(p.getProfileImageS3Url());
        assertNull(p.getReferer());
        assertNull(p.getTimezone());
        assertNull(p.getEmailLastDeliveredDateTime());
        assertNull(p.getEmailUnsubscribeDateTime());
        assertNull(p.getPasswordLastUpdated());
        assertNull(p.getPasswordMustChange());
        assertNull(p.getPhoneMobile());
        assertNull(p.getPersonAccount());
        assertNull(p.getAddress());
        assertNull(p.getTitle());
        assertNull(p.getUserAgent());

        // Testing the constructor
        assertEquals(new Date(TIMESTAMP), person.getCreated());
        assertEquals(new Date(TIMESTAMP), person.getUpdated());
        assertEquals("email", person.getEmail());
        assertEquals("firstName", person.getFirstName());
        assertEquals("lastName", person.getLastName());
        assertEquals("language", person.getLanguage());
        assertEquals(new Date(TIMESTAMP), person.getEmailBounceDateTime());
        assertEquals(new Date(TIMESTAMP), person.getEmailSpamDateTime());
        assertEquals("fullName", person.getFullName());
        assertEquals("ipAddress", person.getIpAddress());
        assertEquals(new Date(TIMESTAMP), person.getLastLoginDateTime());
        assertEquals("oAuthGoogleProfileId",
                person.getoAuthGoogleProfileId());
        assertEquals("phoneWork", person.getPhoneWork());
        assertEquals("profileImageS3Url",
                person.getProfileImageS3Url());
        assertEquals("referer", person.getReferer());
        assertEquals("timezone", person.getTimezone());
        assertEquals(new Date(TIMESTAMP),
                person.getEmailLastDeliveredDateTime());
        assertEquals(new Date(TIMESTAMP), person.getEmailUnsubscribeDateTime());
        assertEquals(new Date(TIMESTAMP), person.getPasswordLastUpdated());
        assertEquals(true, person.getPasswordMustChange());
        assertEquals("phoneMobile", person.getPhoneMobile());
        assertNull(person.getPersonAccount());
        assertNull(person.getAddress());
        assertEquals("title", person.getTitle());
        assertEquals("userAgent", person.getUserAgent());
    }

    /**
     * This method tests the builder's constructor.
     */
    @Test
    public void testBuilderConstructor() {
        // Testing the builder's constructor
        Person.Builder builder = new Person.Builder();

        Person p = builder.build();

        assertNull(p.getCreated());
        assertNull(p.getUpdated());
        assertNull(p.getEmail());
        assertNull(p.getFirstName());
        assertNull(p.getLastName());
        assertNull(p.getLanguage());
        assertNull(p.getEmailBounceDateTime());
        assertNull(p.getEmailSpamDateTime());
        assertNull(p.getFullName());
        assertNull(p.getIpAddress());
        assertNull(p.getLastLoginDateTime());
        assertNull(p.getoAuthGoogleProfileId());
        assertNull(p.getPhoneWork());
        assertNull(p.getProfileImageS3Url());
        assertNull(p.getReferer());
        assertNull(p.getTimezone());
        assertNull(p.getEmailLastDeliveredDateTime());
        assertNull(p.getEmailUnsubscribeDateTime());
        assertNull(p.getPasswordLastUpdated());
        assertNull(p.getPasswordMustChange());
        assertNull(p.getPhoneMobile());
        assertNull(p.getPersonAccount());
        assertNull(p.getAddress());
        assertNull(p.getTitle());
        assertNull(p.getUserAgent());
    }

    /**
     * This method tests the Person class's builder method.
     */
    @Test
    public void testBuilder() {
        // Testing the builder method
        Person p = Person.builder()
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .email("email")
                .firstName("firstName")
                .lastName("lastName")
                .language("language")
                .emailBounceDateTime(new Date(TIMESTAMP))
                .emailSpamDateTime(new Date(TIMESTAMP))
                .fullName("fullName")
                .ipAddress("ipAddress")
                .lastLoginDateTime(new Date(TIMESTAMP))
                .oAuthGoogleProfileId("oAuthGoogleProfileId")
                .phoneWork("phoneWork")
                .profileImageS3Url("profileImageS3Url")
                .referer("referer")
                .timezone("timezone")
                .emailLastDeliveredDateTime(new Date(TIMESTAMP))
                .emailUnsubscribeDateTime(new Date(TIMESTAMP))
                .passwordLastUpdated(new Date(TIMESTAMP))
                .passwordMustChange(true)
                .phoneMobile("phoneMobile")
                .personAccount(null)
                .mailingAddress(null)
                .title("title")
                .userAgent("userAgent")
                .build();

        assertEquals(new Date(TIMESTAMP), p.getCreated());
        assertEquals(new Date(TIMESTAMP), p.getUpdated());
        assertEquals("email", p.getEmail());
        assertEquals("firstName", p.getFirstName());
        assertEquals("lastName", p.getLastName());
        assertEquals("language", p.getLanguage());
        assertEquals(new Date(TIMESTAMP), p.getEmailBounceDateTime());
        assertEquals(new Date(TIMESTAMP), p.getEmailSpamDateTime());
        assertEquals("fullName", p.getFullName());
        assertEquals("ipAddress", p.getIpAddress());
        assertEquals(new Date(TIMESTAMP), p.getLastLoginDateTime());
        assertEquals("oAuthGoogleProfileId",
                p.getoAuthGoogleProfileId());
        assertEquals("phoneWork", p.getPhoneWork());
        assertEquals("profileImageS3Url",
                p.getProfileImageS3Url());
        assertEquals("referer", p.getReferer());
        assertEquals("timezone", p.getTimezone());
        assertEquals(new Date(TIMESTAMP),
                p.getEmailLastDeliveredDateTime());
        assertEquals(new Date(TIMESTAMP), p.getEmailUnsubscribeDateTime());
        assertEquals(new Date(TIMESTAMP), p.getPasswordLastUpdated());
        assertEquals(true, p.getPasswordMustChange());
        assertEquals("phoneMobile", p.getPhoneMobile());
        assertNull(p.getPersonAccount());
        assertNull(p.getAddress());
        assertEquals("title", p.getTitle());
        assertEquals("userAgent", p.getUserAgent());
    }

    /**
     * This method tests the Person class's getCreated method.
     */
    @Test
    public void testGetCreated() {
        assertEquals(new Date(TIMESTAMP), person.getCreated());
    }

    /**
     * This method tests the Person class's setCreated method.
     */
    @Test
    public void testSetCreated() {
        person.setCreated(new Date(TIMESTAMP));
        assertEquals(new Date(TIMESTAMP), person.getCreated());
    }

    /**
     * This method tests the Person class's getUpdated method.
     */
    @Test
    public void testGetUpdated() {
        assertEquals(new Date(TIMESTAMP), person.getUpdated());
    }

    /**
     * This method tests the Person class's setUpdated method.
     */
    @Test
    public void testSetUpdated() {
        person.setUpdated(new Date(TIMESTAMP));
        assertEquals(new Date(TIMESTAMP), person.getUpdated());
    }

    /**
     * This method tests the Person class's getEmail method.
     */
    @Test
    public void testGetEmail() {
        assertEquals("email", person.getEmail());
    }

    /**
     * This method tests the Person class's setEmail method.
     */
    @Test
    public void testSetEmail() {
        person.setEmail("newEmail");
        assertEquals("newEmail", person.getEmail());
    }

    /**
     * This method tests the Person class's getFirstName method.
     */
    @Test
    public void testGetFirstName() {
        assertEquals("firstName", person.getFirstName());
    }

    /**
     * This method tests the Person class's setFirstName method.
     */
    @Test
    public void testSetFirstName() {
        person.setFirstName("newFirstName");
        assertEquals("newFirstName", person.getFirstName());
    }

    /**
     * This method tests the Person class's getLastName method.
     */
    @Test
    public void testGetLastName() {
        assertEquals("lastName", person.getLastName());
    }

    /**
     * This method tests the Person class's setLastName method.
     */
    @Test
    public void testSetLastName() {
        person.setLastName("newLastName");
        assertEquals("newLastName", person.getLastName());
    }

    /**
     * This method tests the Person class's getLanguage method.
     */
    @Test
    public void testGetLanguage() {
        assertEquals("language", person.getLanguage());
    }

    /**
     * This method tests the Person class's setLanguage method.
     */
    @Test
    public void testSetLanguage() {
        person.setLanguage("newLanguage");
        assertEquals("newLanguage", person.getLanguage());
    }

    /**
     * This method tests the Person class's getEmailBounceDateTime method.
     */
    @Test
    public void testGetEmailBounceDateTime() {
        assertEquals(new Date(TIMESTAMP), person.getEmailBounceDateTime());
    }

    /**
     * This method tests the Person class's setEmailBounceDateTime method.
     */
    @Test
    public void testSetEmailBounceDateTime() {
        person.setEmailBounceDateTime(new Date(TIMESTAMP));
        assertEquals(new Date(TIMESTAMP), person.getEmailBounceDateTime());
    }

    /**
     * This method tests the Person class's getEmailSpamDateTime method.
     */
    @Test
    public void testGetEmailSpamDateTime() {
        assertEquals(new Date(TIMESTAMP), person.getEmailSpamDateTime());
    }

    /**
     * This method tests the Person class's setEmailSpamDateTime method.
     */
    @Test
    public void testSetEmailSpamDateTime() {
        person.setEmailSpamDateTime(new Date(TIMESTAMP));
        assertEquals(new Date(TIMESTAMP), person.getEmailSpamDateTime());
    }

    /**
     * This method tests the Person class's getFullName method.
     */
    @Test
    public void testGetFullName() {
        assertEquals("fullName", person.getFullName());
    }

    /**
     * This method tests the Person class's setFullName method.
     */
    @Test
    public void testSetFullName() {
        person.setFullName("newFullName");
        assertEquals("newFullName", person.getFullName());
    }

    /**
     * This method tests the Person class's getIpAddress method.
     */
    @Test
    public void testGetIpAddress() {
        assertEquals("ipAddress", person.getIpAddress());
    }

    /**
     * This method tests the Person class's setIpAddress method.
     */
    @Test
    public void testSetIpAddress() {
        person.setIpAddress("newIpAddress");
        assertEquals("newIpAddress", person.getIpAddress());
    }

    /**
     * This method tests the Person class's getLastLoginDateTime method.
     */
    @Test
    public void testGetLastLoginDateTime() {
        assertEquals(new Date(TIMESTAMP), person.getLastLoginDateTime());
    }

    /**
     * This method tests the Person class's setLastLoginDateTime method.
     */
    @Test
    public void testSetLastLoginDateTime() {
        person.setLastLoginDateTime(new Date(TIMESTAMP));
        assertEquals(new Date(TIMESTAMP), person.getLastLoginDateTime());
    }

    /**
     * This method tests the Person class's getoAuthGoogleProfileId method.
     */
    @Test
    public void testGetoAuthGoogleProfileId() {
        assertEquals("oAuthGoogleProfileId",
                person.getoAuthGoogleProfileId());
    }

    /**
     * This method tests the Person class's setoAuthGoogleProfileId method.
     */
    @Test
    public void testSetoAuthGoogleProfileId() {
        person.setoAuthGoogleProfileId("newOAuthGoogleProfileId");
        assertEquals("newOAuthGoogleProfileId",
                person.getoAuthGoogleProfileId());
    }

    /**
     * This method tests the Person class's getPhoneWork method.
     */
    @Test
    public void testGetPhoneWork() {
        assertEquals("phoneWork", person.getPhoneWork());
    }

    /**
     * This method tests the Person class's setPhoneWork method.
     */
    @Test
    public void testSetPhoneWork() {
        person.setPhoneWork("newPhoneWork");
        assertEquals("newPhoneWork", person.getPhoneWork());
    }

    /**
     * This method tests the Person class's getProfileImageS3Url method.
     */
    @Test
    public void testGetProfileImageS3Url() {
        assertEquals("profileImageS3Url",
                person.getProfileImageS3Url());
    }

    /**
     * This method tests the Person class's setProfileImageS3Url method.
     */
    @Test
    public void testSetProfileImageS3Url() {
        person.setProfileImageS3Url("newProfileImageS3Url");
        assertEquals("newProfileImageS3Url",
                person.getProfileImageS3Url());
    }

    /**
     * This method tests the Person class's getReferer method.
     */
    @Test
    public void testGetReferer() {
        assertEquals("referer", person.getReferer());
    }

    /**
     * This method tests the Person class's setReferer method.
     */
    @Test
    public void testSetReferer() {
        person.setReferer("newReferer");
        assertEquals("newReferer", person.getReferer());
    }

    /**
     * This method tests the Person class's getTimezone method.
     */
    @Test
    public void testGetTimezone() {
        assertEquals("timezone", person.getTimezone());
    }

    /**
     * This method tests the Person class's setTimezone method.
     */
    @Test
    public void testSetTimezone() {
        person.setTimezone("newTimezone");
        assertEquals("newTimezone", person.getTimezone());
    }

    /**
     * This method tests the Person class's getEmailLastDeliveredDateTime
     * method.
     */
    @Test
    public void testGetEmailLastDeliveredDateTime() {
        assertEquals(new Date(TIMESTAMP),
                person.getEmailLastDeliveredDateTime());
    }

    /**
     * This method tests the Person class's setEmailLastDeliveredDateTime
     * method.
     */
    @Test
    public void testSetEmailLastDeliveredDateTime() {
        person.setEmailLastDeliveredDateTime(new Date(TIMESTAMP));
        assertEquals(new Date(TIMESTAMP),
                person.getEmailLastDeliveredDateTime());
    }

    /**
     * This method tests the Person class's getEmailUnsubscribeDateTime method.
     */
    @Test
    public void testGetEmailUnsubscribeDateTime() {
        assertEquals(new Date(TIMESTAMP), person.getEmailUnsubscribeDateTime());
    }

    /**
     * This method tests the Person class's setEmailUnsubscribeDateTime method.
     */
    @Test
    public void testSetEmailUnsubscribeDateTime() {
        person.setEmailUnsubscribeDateTime(new Date(TIMESTAMP));
        assertEquals(new Date(TIMESTAMP), person.getEmailUnsubscribeDateTime());
    }

    /**
     * This method tests the Person class's getPasswordLastUpdated method.
     */
    @Test
    public void testGetPasswordLastUpdated() {
        assertEquals(new Date(TIMESTAMP), person.getPasswordLastUpdated());
    }

    /**
     * This method tests the Person class's setPasswordLastUpdated method.
     */
    @Test
    public void testSetPasswordLastUpdated() {
        person.setPasswordLastUpdated(new Date(TIMESTAMP));
        assertEquals(new Date(TIMESTAMP), person.getPasswordLastUpdated());
    }

    /**
     * This method tests the Person class's getPasswordMustChange method.
     */
    @Test
    public void testGetPasswordMustChange() {
        assertEquals(true, person.getPasswordMustChange());
    }

    /**
     * This method tests the Person class's setPasswordMustChange method.
     */
    @Test
    public void testSetPasswordMustChange() {
        person.setPasswordMustChange(true);
        assertEquals(true, person.getPasswordMustChange());
    }

    /**
     * This method tests the Person class's getPhoneMobile method.
     */
    @Test
    public void testGetPhoneMobile() {
        assertEquals("phoneMobile", person.getPhoneMobile());
    }

    /**
     * This method tests the Person class's setPhoneMobile method.
     */
    @Test
    public void testSetPhoneMobile() {
        person.setPhoneMobile("newPhoneMobile");
        assertEquals("newPhoneMobile", person.getPhoneMobile());
    }

    /**
     * This method tests the Person class's getPersonAccount method.
     */
    @Test
    public void testGetPersonAccount() {
        assertNull(person.getPersonAccount());
    }

    /**
     * This method tests the Person class's setPersonAccount method.
     */
    @Test
    public void testSetPersonAccount() {
        List<PersonAccount> personAccount = Arrays.asList(new PersonAccount(),
                new PersonAccount());
        person.setPersonAccount(personAccount);
        assertEquals(personAccount, person.getPersonAccount());
    }

    /**
     * This method tests the Person class's getTitle method.
     */
    @Test
    public void testGetTitle() {
        assertEquals("title", person.getTitle());
    }

    /**
     * This method tests the Person class's setTitle method.
     */
    @Test
    public void testSetTitle() {
        person.setTitle("newTitle");
        assertEquals("newTitle", person.getTitle());
    }

    /**
     * This method tests the Person class's getUserAgent method.
     */
    @Test
    public void testGetUserAgent() {
        assertEquals("userAgent", person.getUserAgent());
    }

    /**
     * This method tests the Person class's setUserAgent method.
     */
    @Test
    public void testSetUserAgent() {
        person.setUserAgent("newUserAgent");
        assertEquals("newUserAgent", person.getUserAgent());
    }

    /**
     * This method tests the Person class's getUid method.
     */
    @Test
    public void testGetUid() {
        assertEquals("123", person.getUid());
    }

    /**
     * This method tests the Person class's setUid method.
     */
    @Test
    public void testSetUid() {
        person.setUid("newUid");
        assertEquals("newUid", person.getUid());
    }

    /**
     * This mehtod tests the Person class's setAddress method.
     */
    @Test
    public void testSetAddress() {
        Address address = new Address();
        person.setAddress(address);
        assertEquals(address, person.getAddress());
    }

    /**
     * This method tests the Person class's equals method.
     */
    @Test
    public void testEquals() {
        // Creating an object to compare with
        Person p1 = Person.builder().email("email").build();
        Person p2 = Person.builder().fullName("fullname").build();
        Person p3 = Person.builder().email("email").build();

        // Creating a copy of this class's person
        Person p4 = Person.builder()
                .uid("123")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .email("email")
                .firstName("firstName")
                .lastName("lastName")
                .language("language")
                .emailBounceDateTime(new Date(TIMESTAMP))
                .emailSpamDateTime(new Date(TIMESTAMP))
                .fullName("fullName")
                .ipAddress("ipAddress")
                .lastLoginDateTime(new Date(TIMESTAMP))
                .oAuthGoogleProfileId("oAuthGoogleProfileId")
                .phoneWork("phoneWork")
                .profileImageS3Url("profileImageS3Url")
                .referer("referer")
                .timezone("timezone")
                .emailLastDeliveredDateTime(new Date(TIMESTAMP))
                .emailUnsubscribeDateTime(new Date(TIMESTAMP))
                .passwordLastUpdated(new Date(TIMESTAMP))
                .passwordMustChange(true)
                .phoneMobile("phoneMobile")
                .personAccount(null)
                .mailingAddress(null)
                .title("title")
                .userAgent("userAgent")
                .build();

        assertEquals(p1, p3);
        assertEquals(p1, p1);
        assertNotEquals(p1, null);
        assertNotEquals(p1, new Object());
        assertEquals(person, p4);
    }

    /**
     * This method tests the Person class's hashCode method.
     */
    @Test
    public void testHashcode() {
        // Creating an object to compare with
        Person p1 = Person.builder().email("email").build();
        Person p3 = Person.builder().email("email").build();

        // Creating a copy of this class's person
        Person p4 = Person.builder()
                .uid("123")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .email("email")
                .firstName("firstName")
                .lastName("lastName")
                .language("language")
                .emailBounceDateTime(new Date(TIMESTAMP))
                .emailSpamDateTime(new Date(TIMESTAMP))
                .fullName("fullName")
                .ipAddress("ipAddress")
                .lastLoginDateTime(new Date(TIMESTAMP))
                .oAuthGoogleProfileId("oAuthGoogleProfileId")
                .phoneWork("phoneWork")
                .profileImageS3Url("profileImageS3Url")
                .referer("referer")
                .timezone("timezone")
                .emailLastDeliveredDateTime(new Date(TIMESTAMP))
                .emailUnsubscribeDateTime(new Date(TIMESTAMP))
                .passwordLastUpdated(new Date(TIMESTAMP))
                .passwordMustChange(true)
                .phoneMobile("phoneMobile")
                .personAccount(null)
                .mailingAddress(null)
                .title("title")
                .userAgent("userAgent")
                .build();

        // Testing the hashCode method
        assertEquals(p1.hashCode(), p3.hashCode());
        assertEquals(person.hashCode(), p4.hashCode());
    }

}
