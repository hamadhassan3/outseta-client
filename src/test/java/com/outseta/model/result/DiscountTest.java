package com.outseta.model.result;

import com.outseta.constant.DiscountDuration;
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
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class is used to test the Discount class.
 */
@ExtendWith(MockitoExtension.class)
public class DiscountTest {

    /**
     * The Discount object to test.
     */
    private Discount discount;

    /**
     * A mocked plan object for testing.
     */
    @Mock
    private Plan plan1;

    /**
     * A mocked plan object for testing.
     */
    @Mock
    private Plan plan2;

    /**
     * A random timestamp to create date objects.
     */
    private static final long TIMESTAMP = 1612137600;

    /**
     * The amount off for testing.
     */
    private static final double AMOUNT_OFF = 1.1;

    /**
     * The percent off for testing.
     */
    private static final int PERCENT_OFF = 2;

    /**
     * The duration for testing.
     */
    private static final int DURATION = 3;

    /**
     * The duration in months for testing.
     */
    private static final int DURATION_IN_MONTHS = 4;

    /**
     * The max redemptions for testing.
     */
    private static final int MAX_REDEMPTIONS = 5;

    /**
     * This method is run before each test to set up the Discount object.
     */
    @BeforeEach
    public void setUp() {
        // Sets all attributes using the builder of discount class.
        discount = Discount.builder()
                .uniqueIdentifier("1")
                .name("name")
                .amountOff(AMOUNT_OFF)
                .percentOff(PERCENT_OFF)
                .duration(DURATION)
                .duration(DiscountDuration.FOREVER)
                .durationInMonths(DURATION_IN_MONTHS)
                .maxRedemptions(MAX_REDEMPTIONS)
                .redeemBy(new Date(TIMESTAMP))
                .discountCouponPlans(Arrays.asList(plan1))
                .active(false)
                .uid("uid")
                .build();
    }

    /**
     * This method tests the Discount class's builder.
     */
    @Test
    public void testBuilder() {
        // Tests the builder.
        assertEquals("1", discount.getUniqueIdentifier());
        assertEquals("name", discount.getName());
        assertEquals(AMOUNT_OFF, discount.getAmountOff());
        assertEquals(PERCENT_OFF, discount.getPercentOff());
        assertEquals(DiscountDuration.FOREVER.getValue(),
                discount.getDuration());
        assertEquals(DURATION_IN_MONTHS, discount.getDurationInMonths());
        assertEquals(MAX_REDEMPTIONS, discount.getMaxRedemptions());
        assertEquals(new Date(TIMESTAMP), discount.getRedeemBy());
        assertEquals(Arrays.asList(plan1), discount.getDiscountCouponPlans());
        assertEquals("uid", discount.getUid());
    }

    /**
     * This method tests the Discount class's builder with defaults.
     */
    @Test
    public void testBuilderWithDefaults() {
        // Tests the builder with defaults.
        Discount test = Discount.builder()
                .build();

        assertNull(test.getUniqueIdentifier());
        assertNull(test.getName());
        assertNull(test.getAmountOff());
        assertNull(test.getPercentOff());
        assertNull(test.getDuration());
        assertNull(test.getDurationInMonths());
        assertNull(test.getMaxRedemptions());
        assertNull(test.getRedeemBy());
        assertNull(test.getDiscountCouponPlans());
        assertNull(test.getUid());
    }

    /**
     * This method tests the Discount class's setter and getter for the unique
     * identifier.
     */
    @Test
    public void testSetAndGetUniqueIdentifier() {
        // Tests the setter and getter for the unique identifier.
        discount.setUniqueIdentifier("2");
        assertEquals("2", discount.getUniqueIdentifier());
    }

    /**
     * This method tests the Discount class's setter and getter for the name.
     */
    @Test
    public void testSetAndGetName() {
        // Tests the setter and getter for the name.
        discount.setName("name2");
        assertEquals("name2", discount.getName());
    }

    /**
     * This method tests the Discount class's setter and getter for the amount
     * off.
     */
    @Test
    public void testSetAndGetAmountOff() {
        // Tests the setter and getter for the amount off.
        discount.setAmountOff(AMOUNT_OFF + 1.0);
        assertEquals(AMOUNT_OFF + 1, discount.getAmountOff());
    }

    /**
     * This method tests the Discount class's setter and getter for the percent
     * off.
     */
    @Test
    public void testSetAndGetPercentOff() {
        // Tests the setter and getter for the percent off.
        discount.setPercentOff(PERCENT_OFF + 1);
        assertEquals(PERCENT_OFF + 1, discount.getPercentOff());
    }

    /**
     * This method tests the Discount class's setter and getter for the
     * duration.
     */
    @Test
    public void testSetAndGetDuration() {
        // Tests the setter and getter for the duration.
        discount.setDuration(DURATION + 1);
        assertEquals(DURATION + 1, discount.getDuration());
    }

    /**
     * This method tests the Discount class's setter and getter for the
     * duration in months.
     */
    @Test
    public void testSetAndGetDurationInMonths() {
        // Tests the setter and getter for the duration in months.
        discount.setDurationInMonths(DURATION_IN_MONTHS + 1);
        assertEquals(DURATION_IN_MONTHS + 1,
                discount.getDurationInMonths());
    }

    /**
     * This method tests the Discount class's setter and getter for the max
     * redemptions.
     */
    @Test
    public void testSetAndGetMaxRedemptions() {
        // Tests the setter and getter for the max redemptions.
        discount.setMaxRedemptions(MAX_REDEMPTIONS + 1);
        assertEquals(MAX_REDEMPTIONS + 1, discount.getMaxRedemptions());
    }

    /**
     * This method tests the Discount class's setter and getter for the redeem
     * by date.
     */
    @Test
    public void testSetAndGetRedeemBy() {
        // Tests the setter and getter for the redeem by date.
        discount.setRedeemBy(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), discount.getRedeemBy());
    }

    /**
     * This method tests the Discount class's setter and getter for the
     * discount coupon plans.
     */
    @Test
    public void testSetAndGetDiscountCouponPlans() {
        // Tests the setter and getter for the discount coupon plans.
        discount.setDiscountCouponPlans(Arrays.asList(plan2));
        assertEquals(Arrays.asList(plan2), discount.getDiscountCouponPlans());
    }

    /**
     * This method tests the Discount class's setter and getter for the
     * active field.
     */
    @Test
    public void testSetAndGetActive() {
        // Tests the setter and getter for the active field.
        discount.setActive(true);
        assertTrue(discount.isActive());
    }

    /**
     * This method tests get and set of uid.
     */
    @Test
    public void testSetAndGetUid() {
        // Tests the setter and getter for the uid.
        discount.setUid("uid2");
        assertEquals("uid2", discount.getUid());
    }

    /**
     * This method tests the Discount class's equals method.
     */
    @Test
    public void testEquals() {
        // Creates an equal object.
        Discount d2 = Discount.builder()
                .uniqueIdentifier("1")
                .name("name")
                .amountOff(AMOUNT_OFF)
                .percentOff(PERCENT_OFF)
                .duration(DURATION)
                .duration(DiscountDuration.FOREVER)
                .durationInMonths(DURATION_IN_MONTHS)
                .maxRedemptions(MAX_REDEMPTIONS)
                .redeemBy(new Date(TIMESTAMP))
                .discountCouponPlans(Arrays.asList(plan1))
                .active(false)
                .uid("uid")
                .build();

        // Tests the equals method.
        assertEquals(discount, discount);
        assertEquals(discount, d2);
        assertNotEquals(discount, new Object());
        assertNotEquals(discount, null);
        assertNotEquals(discount, Discount
                .builder().uniqueIdentifier("2").build());

        assertNotEquals(discount, Discount
                .builder().uniqueIdentifier("1")
                .uid("uid2").build());
    }

    /**
     * This method tests the Discount class's hashCode method.
     */
    @Test
    public void testHashCode() {
        // Tests the hashCode method.
        assertEquals(discount.hashCode(), Discount.builder()
                .uniqueIdentifier("1")
                .name("name")
                .amountOff(AMOUNT_OFF)
                .percentOff(PERCENT_OFF)
                .duration(DURATION)
                .duration(DiscountDuration.FOREVER)
                .durationInMonths(DURATION_IN_MONTHS)
                .maxRedemptions(MAX_REDEMPTIONS)
                .redeemBy(new Date(TIMESTAMP))
                .discountCouponPlans(Arrays.asList(plan1))
                .active(false)
                .uid("uid")
                .build().hashCode());
    }
}
