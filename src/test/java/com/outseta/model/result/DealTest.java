package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * This class is used to test the Deal class.
 */
@ExtendWith(MockitoExtension.class)
public class DealTest {

    /**
     * The Deal object to test.
     */
    private Deal deal;

    /**
     * The mock DealPipelineStage object.
     */
    @Mock
    private DealPipelineStage dealPipelineStage1;

    /**
     * The mock DealPipelineStage object.
     */
    @Mock
    private DealPipelineStage dealPipelineStage2;

    /**
     * The mock DealPerson object.
     */
    @Mock
    private DealPerson dealPerson1;

    /**
     * The mock DealPerson object.
     */
    @Mock
    private DealPerson dealPerson2;

    /**
     * The mock PersonAccount object.
     */
    @Mock
    private PersonAccount account1;

    /**
     * The mock PersonAccount object.
     */
    @Mock
    private PersonAccount account2;

    /**
     * This method initializes the Deal object to test.
     */
    @BeforeEach
    public void setup() {
        deal = Deal.builder()
                .uid("uid")
                .name("name")
                .account(account1)
                .dealPeople(List.of(dealPerson1))
                .dealPipelineStage(dealPipelineStage1)
                .assignedToPersonClientIdentifier(
                        "assignedToPersonClientIdentifier")
                .amount(1.0)
                .build();
    }

    /**
     * This method tests the setName method.
     */
    @Test
    public void testSetName() {
        assertEquals("name", deal.getName());
        deal.setName("name2");
        assertEquals("name2", deal.getName());
    }

    /**
     * This method tests the setAccount method.
     */
    @Test
    public void testSetAccount() {
        assertEquals(account1, deal.getAccount());
        deal.setAccount(account2);
        assertEquals(account2, deal.getAccount());
    }

    /**
     * This method tests the setDealPeople method.
     */
    @Test
    public void testSetDealPeople() {
        assertEquals(List.of(dealPerson1), deal.getDealPeople());
        deal.setDealPeople(List.of(dealPerson2));
        assertEquals(List.of(dealPerson2), deal.getDealPeople());
    }

    /**
     * This method tests the setDealPipelineStage method.
     */
    @Test
    public void testSetDealPipelineStage() {
        assertEquals(dealPipelineStage1, deal.getDealPipelineStage());
        deal.setDealPipelineStage(dealPipelineStage2);
        assertEquals(dealPipelineStage2, deal.getDealPipelineStage());
    }

    /**
     * This method tests the setAssignedToPersonClientIdentifier method.
     */
    @Test
    public void testSetAssignedToPersonClientIdentifier() {
        assertEquals("assignedToPersonClientIdentifier",
                deal.getAssignedToPersonClientIdentifier());
        deal.setAssignedToPersonClientIdentifier(
                "assignedToPersonClientIdentifier2");
        assertEquals("assignedToPersonClientIdentifier2",
                deal.getAssignedToPersonClientIdentifier());
    }

    /**
     * This method tests the setAmount method.
     */
    @Test
    public void testSetAmount() {
        assertEquals(1.0, deal.getAmount());
        deal.setAmount(2.0);
        assertEquals(2.0, deal.getAmount());
    }

    /**
     * This method tests the setUid method.
     */
    @Test
    public void testSetUid() {
        assertEquals("uid", deal.getUid());
        deal.setUid("uid2");
        assertEquals("uid2", deal.getUid());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {

        Deal deal2 = Deal.builder()
                .uid("uid")
                .name("name")
                .account(account1)
                .dealPeople(List.of(dealPerson1))
                .dealPipelineStage(dealPipelineStage1)
                .assignedToPersonClientIdentifier(
                        "assignedToPersonClientIdentifier")
                .amount(1.0)
                .build();

        assertEquals(deal2, deal);
        assertNotEquals(deal2, new Object());
    }

    /**
     * This method tests the hashCode method.
     */
    @Test
    public void testHashCode() {
        assertEquals(deal.hashCode(), Deal.builder()
                .uid("uid")
                .name("name")
                .account(account1)
                .dealPeople(List.of(dealPerson1))
                .dealPipelineStage(dealPipelineStage1)
                .assignedToPersonClientIdentifier(
                        "assignedToPersonClientIdentifier")
                .amount(1.0)
                .build().hashCode());
    }
}
