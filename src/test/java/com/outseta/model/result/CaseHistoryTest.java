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

/**
 * This class is used to test the CaseHistory class.
 */
@ExtendWith(MockitoExtension.class)
public class CaseHistoryTest {

    /**
     * The CaseHistory object to be used in the tests.
     */
    private CaseHistory caseHistory;

    /**
     * The Case object to be used in the tests.
     */
    @Mock
    private Case caseObject1;

    /**
     * The Case object to be used in the tests.
     */
    @Mock
    private Case caseObject2;

    /**
     * A random timestamp used to create dates.
     */
    private static final long TIMESTAMP = 1612137600000L;

    /**
     * This method is used to set up the tests.
     */
    @BeforeEach
    public void setup() {
        this.caseHistory = CaseHistory.builder()
                .historyDateTime(new Date(TIMESTAMP))
                .caseObject(caseObject1)
                .agentName("agentName")
                .comment("comment")
                .type(1)
                .seenDateTime(new Date(TIMESTAMP))
                .clickDateTime(new Date(TIMESTAMP))
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
    }

    /**
     * This method tests the values set by the builder.
     */
    @Test
    public void testBuilder() {
        assertEquals(TIMESTAMP, this.caseHistory.getHistoryDateTime()
                .getTime());
        assertEquals(caseObject1, this.caseHistory.getCaseObject());
        assertEquals("agentName", this.caseHistory.getAgentName());
        assertEquals("comment", this.caseHistory.getComment());
        assertEquals(1, this.caseHistory.getType());
        assertEquals(TIMESTAMP, this.caseHistory.getSeenDateTime().getTime());
        assertEquals(TIMESTAMP, this.caseHistory.getClickDateTime().getTime());
        assertEquals("uid", this.caseHistory.getUid());
        assertEquals(TIMESTAMP, this.caseHistory.getCreated().getTime());
        assertEquals(TIMESTAMP, this.caseHistory.getUpdated().getTime());
    }

    /**
     * This method tests the default values set by the builder.
     */
    @Test
    public void testBuilderDefaults() {
        this.caseHistory = CaseHistory.builder().build();
        assertNull(this.caseHistory.getHistoryDateTime());
        assertNull(this.caseHistory.getCaseObject());
        assertNull(this.caseHistory.getAgentName());
        assertNull(this.caseHistory.getComment());
        assertNull(this.caseHistory.getType());
        assertNull(this.caseHistory.getSeenDateTime());
        assertNull(this.caseHistory.getClickDateTime());
        assertNull(this.caseHistory.getUid());
        assertNull(this.caseHistory.getCreated());
        assertNull(this.caseHistory.getUpdated());
    }

    /**
     * This method tests the get and set methods for the historyDateTime field.
     */
    @Test
    public void testGetSetHistoryDateTime() {
        this.caseHistory.setHistoryDateTime(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), this.caseHistory
                .getHistoryDateTime());
    }

    /**
     * This method tests the get and set methods for the caseObject field.
     */
    @Test
    public void testGetSetCaseObject() {
        this.caseHistory.setCaseObject(caseObject2);
        assertEquals(caseObject2, this.caseHistory.getCaseObject());
    }

    /**
     * This method tests the get and set methods for the agentName field.
     */
    @Test
    public void testGetSetAgentName() {
        this.caseHistory.setAgentName("agentName2");
        assertEquals("agentName2", this.caseHistory.getAgentName());
    }

    /**
     * This method tests the get and set methods for the comment field.
     */
    @Test
    public void testGetSetComment() {
        this.caseHistory.setComment("comment2");
        assertEquals("comment2", this.caseHistory.getComment());
    }

    /**
     * This method tests the get and set methods for the type field.
     */
    @Test
    public void testGetSetType() {
        this.caseHistory.setType(2);
        assertEquals(2, this.caseHistory.getType());
    }

    /**
     * This method tests the get and set methods for the seenDateTime field.
     */
    @Test
    public void testGetSetSeenDateTime() {
        this.caseHistory.setSeenDateTime(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), this.caseHistory
                .getSeenDateTime());
    }

    /**
     * This method tests the get and set methods for the clickDateTime field.
     */
    @Test
    public void testGetSetClickDateTime() {
        this.caseHistory.setClickDateTime(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), this.caseHistory
                .getClickDateTime());
    }

    /**
     * This method tests the get and set methods for the uid field.
     */
    @Test
    public void testGetSetUid() {
        this.caseHistory.setUid("uid2");
        assertEquals("uid2", this.caseHistory.getUid());
    }

    /**
     * This method tests the get and set methods for the created field.
     */
    @Test
    public void testGetSetCreated() {
        this.caseHistory.setCreated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), this.caseHistory
                .getCreated());
    }

    /**
     * This method tests the get and set methods for the updated field.
     */
    @Test
    public void testGetSetUpdated() {
        this.caseHistory.setUpdated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), this.caseHistory
                .getUpdated());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {
        CaseHistory caseHistory2 = CaseHistory.builder()
                .historyDateTime(new Date(TIMESTAMP))
                .caseObject(caseObject1)
                .agentName("agentName")
                .comment("comment")
                .type(1)
                .seenDateTime(new Date(TIMESTAMP))
                .clickDateTime(new Date(TIMESTAMP))
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
        assertEquals(this.caseHistory, caseHistory2);
        assertEquals(this.caseHistory, this.caseHistory);

        assertNotEquals(this.caseHistory, null);
        assertNotEquals(this.caseHistory, new Object());
        assertNotEquals(this.caseHistory, CaseHistory.builder().build());
    }

    /**
     * This method tests the hashCode method.
     */
    @Test
    public void testHashCode() {
        CaseHistory caseHistory2 = CaseHistory.builder()
                .historyDateTime(new Date(TIMESTAMP))
                .caseObject(caseObject1)
                .agentName("agentName")
                .comment("comment")
                .type(1)
                .seenDateTime(new Date(TIMESTAMP))
                .clickDateTime(new Date(TIMESTAMP))
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
        assertEquals(this.caseHistory.hashCode(), caseHistory2.hashCode());
    }
}
