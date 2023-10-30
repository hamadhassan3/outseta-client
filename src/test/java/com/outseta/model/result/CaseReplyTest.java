package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * This class is used to test the CaseReply class.
 */
@ExtendWith(MockitoExtension.class)
public class CaseReplyTest {

    /**
     * The CaseReply object to be used in the tests.
     */
    private CaseReply caseReply;

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
     * This method is used to set up the tests.
     */
    @BeforeEach
    public void setup() {
        this.caseReply = CaseReply.builder()
                .agentName("agentName")
                .caseObject(this.caseObject1)
                .comment("comment")
                .build();
    }

    /**
     * This method tests the values set by builder.
     */
    @Test
    public void testBuilder() {
        assertEquals("agentName", this.caseReply.getAgentName());
        assertEquals(this.caseObject1, this.caseReply.getCaseObject());
        assertEquals("comment", this.caseReply.getComment());
    }

    /**
     * This method tests the default values set by builder.
     */
    @Test
    public void testBuilderDefaults() {
        CaseReply test = CaseReply.builder().build();
        assertNull(test.getAgentName());
        assertNull(test.getCaseObject());
        assertNull(test.getComment());
    }

    /**
     * This method tests the get and set methods for agentName.
     */
    @Test
    public void testGetSetAgentName() {
        this.caseReply.setAgentName("agentName2");
        assertEquals("agentName2", this.caseReply.getAgentName());
    }

    /**
     * This method tests the get and set methods for caseObject.
     */
    @Test
    public void testGetSetCaseObject() {
        this.caseReply.setCaseObject(this.caseObject2);
        assertEquals(this.caseObject2, this.caseReply.getCaseObject());
    }

    /**
     * This method tests the get and set methods for comment.
     */
    @Test
    public void testGetSetComment() {
        this.caseReply.setComment("comment2");
        assertEquals("comment2", this.caseReply.getComment());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {
        CaseReply test = CaseReply.builder()
                .agentName("agentName")
                .caseObject(this.caseObject1)
                .comment("comment")
                .build();
        assertEquals(this.caseReply, test);
        assertEquals(caseReply, caseReply);

        assertNotEquals(this.caseReply, null);
        assertNotEquals(this.caseReply, new Object());

        test.setAgentName("agentName2");
        assertNotEquals(this.caseReply, test);
        test.setAgentName("agentName");

        test.setCaseObject(this.caseObject2);
        assertNotEquals(this.caseReply, test);
        test.setCaseObject(this.caseObject1);

        test.setComment("comment2");
        assertNotEquals(this.caseReply, test);
    }

    /**
     * This method tests the hashcode method.
     */
    @Test
    public void testHashCode() {
        CaseReply test = CaseReply.builder()
                .agentName("agentName")
                .caseObject(this.caseObject1)
                .comment("comment")
                .build();
        assertEquals(this.caseReply.hashCode(), test.hashCode());
    }

}
