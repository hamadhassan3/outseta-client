package com.outseta.model.result;

import com.outseta.constant.CaseSource;
import com.outseta.constant.CaseStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This method tests the Case class.
 */
@ExtendWith(MockitoExtension.class)
public class CaseTest {

    /**
     * The Case object to be used in the tests.
     */
    private Case caseObject;

    /**
     * The CaseHistory object to be used in the tests.
     */
    @Mock
    private CaseHistory caseHistory1;

    /**
     * The CaseHistory object to be used in the tests.
     */
    @Mock
    private CaseHistory caseHistory2;

    /**
     * The Person object to be used in the tests.
     */
    @Mock
    private Person person1;

    /**
     * The Person object to be used in the tests.
     */
    @Mock
    private Person person2;

    /**
     * A random timestamp used to create dates.
     */
    private static final long TIMESTAMP = 1612137600000L;

    /**
     * This method is used to set up the tests.
     */
    @BeforeEach
    public void setup() {
        this.caseObject = Case.builder()
                .submittedDateTime(new Date(TIMESTAMP))
                .fromPerson(person1)
                .assignedToPersonClientIdentifier(
                        "assignedToPersonClientIdentifier")
                .subject("subject")
                .body("body")
                .userAgent("userAgent")
                .status(CaseStatus.OPEN)
                .status(1)
                .source(CaseSource.EMAIL)
                .source(2)
                .caseHistories(Arrays.asList(caseHistory1, caseHistory2))
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
        assertEquals(new Date(TIMESTAMP), this.caseObject
                .getSubmittedDateTime());
        assertEquals(person1, this.caseObject.getFromPerson());
        assertEquals("assignedToPersonClientIdentifier",
                this.caseObject.getAssignedToPersonClientIdentifier());
        assertEquals("subject", this.caseObject.getSubject());
        assertEquals("body", this.caseObject.getBody());
        assertEquals("userAgent", this.caseObject.getUserAgent());
        assertEquals(1, this.caseObject.getStatus());
        assertEquals(2, this.caseObject.getSource());
        assertEquals(Arrays.asList(caseHistory1, caseHistory2), this.caseObject
                .getCaseHistories());
        assertEquals("uid", this.caseObject.getUid());
        assertEquals(new Date(TIMESTAMP), this.caseObject.getCreated());
        assertEquals(new Date(TIMESTAMP), this.caseObject.getUpdated());
    }

    /**
     * This method tests the default values set by builder.
     */
    @Test
    public void testBuilderDefaults() {
        this.caseObject = Case.builder().build();
        assertNull(this.caseObject.getSubmittedDateTime());
        assertNull(this.caseObject.getFromPerson());
        assertNull(this.caseObject.getAssignedToPersonClientIdentifier());
        assertNull(this.caseObject.getSubject());
        assertNull(this.caseObject.getBody());
        assertNull(this.caseObject.getUserAgent());
        assertNull(this.caseObject.getStatus());
        assertNull(this.caseObject.getSource());
        assertNull(this.caseObject.getCaseHistories());
        assertNull(this.caseObject.getUid());
        assertNull(this.caseObject.getCreated());
        assertNull(this.caseObject.getUpdated());
    }

    /**
     * This method tests the get and set methods for the submittedDateTime.
     */
    @Test
    public void testGetSetSubmittedDateTime() {
        this.caseObject.setSubmittedDateTime(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), this.caseObject
                .getSubmittedDateTime());
    }

    /**
     * This method tests the get and set methods for the fromPerson.
     */
    @Test
    public void testGetSetFromPerson() {
        this.caseObject.setFromPerson(person2);
        assertEquals(person2, this.caseObject.getFromPerson());
    }

    /**
     * This method tests the get and set methods for the
     * assignedToPersonClientIdentifier.
     */
    @Test
    public void testGetSetAssignedToPersonClientIdentifier() {
        this.caseObject.setAssignedToPersonClientIdentifier(
                "assignedToPersonClientIdentifier2");
        assertEquals("assignedToPersonClientIdentifier2", this.caseObject
                .getAssignedToPersonClientIdentifier());
    }

    /**
     * This method tests the get and set methods for the subject.
     */
    @Test
    public void testGetSetSubject() {
        this.caseObject.setSubject("subject2");
        assertEquals("subject2", this.caseObject.getSubject());
    }

    /**
     * This method tests the get and set methods for the body.
     */
    @Test
    public void testGetSetBody() {
        this.caseObject.setBody("body2");
        assertEquals("body2", this.caseObject.getBody());
    }

    /**
     * This method tests the get and set methods for the userAgent.
     */
    @Test
    public void testGetSetUserAgent() {
        this.caseObject.setUserAgent("userAgent2");
        assertEquals("userAgent2", this.caseObject.getUserAgent());
    }

    /**
     * This method tests the get and set methods for the status.
     */
    @Test
    public void testGetSetStatus() {
        this.caseObject.setStatus(2);
        assertEquals(2, this.caseObject.getStatus());
    }

    /**
     * This method tests the get and set methods for the source.
     */
    @Test
    public void testGetSetSource() {
        this.caseObject.setSource(1);
        assertEquals(1, this.caseObject.getSource());
    }

    /**
     * This method tests the get and set methods for the caseHistories.
     */
    @Test
    public void testGetSetCaseHistories() {
        this.caseObject.setCaseHistories(Arrays.asList(caseHistory2));
        assertEquals(Arrays.asList(caseHistory2), this.caseObject
                .getCaseHistories());
    }

    /**
     * This method tests the get and set methods for the uid.
     */
    @Test
    public void testGetSetUid() {
        this.caseObject.setUid("uid2");
        assertEquals("uid2", this.caseObject.getUid());
    }

    /**
     * This method tests the get and set methods for the created.
     */
    @Test
    public void testGetSetCreated() {
        this.caseObject.setCreated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), this.caseObject
                .getCreated());
    }

    /**
     * This method tests the get and set methods for the updated.
     */
    @Test
    public void testGetSetUpdated() {
        this.caseObject.setUpdated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), this.caseObject
                .getUpdated());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {
        Case caseObject2 = Case.builder()
                .submittedDateTime(new Date(TIMESTAMP))
                .fromPerson(person1)
                .assignedToPersonClientIdentifier(
                        "assignedToPersonClientIdentifier")
                .subject("subject")
                .body("body")
                .userAgent("userAgent")
                .status(1)
                .source(2)
                .caseHistories(Arrays.asList(caseHistory1, caseHistory2))
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
        assertEquals(caseObject2, this.caseObject);
        assertEquals(caseObject, caseObject);

        assertNotEquals(caseObject, null);
        assertNotEquals(caseObject, new Object());
        assertNotEquals(caseObject, Case.builder().build());
    }

    /**
     * This method tests the hashCode method.
     */
    @Test
    public void testHashCode() {
        Case caseObject2 = Case.builder()
                .submittedDateTime(new Date(TIMESTAMP))
                .fromPerson(person1)
                .assignedToPersonClientIdentifier(
                        "assignedToPersonClientIdentifier")
                .subject("subject")
                .body("body")
                .userAgent("userAgent")
                .status(1)
                .source(2)
                .caseHistories(Arrays.asList(caseHistory1, caseHistory2))
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
        assertEquals(caseObject2.hashCode(), this.caseObject.hashCode());
    }
}
