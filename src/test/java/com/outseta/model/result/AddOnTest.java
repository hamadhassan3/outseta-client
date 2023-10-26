package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class is used to test the AddOn class.
 */
@ExtendWith(MockitoExtension.class)
public class AddOnTest {

    /**
     * The add-on object to be tested.
     */
    private AddOn addOn;

    /**
     * A random timestamp to be used in the tests.
     */
    private static final long TIMESTAMP = 1234567890L;

    /**
     * The billing add-on type to be used in the tests.
     */
    private static final int BILLING_ADD_ON_TYPE = 1;

    /**
     * The minimum quantity to be used in the tests.
     */
    private static final int MINIMUM_QUANTITY = 2;

    /**
     * The monthly rate to be used in the tests.
     */
    private static final double MONTHLY_RATE = 3.3;

    /**
     * The annual rate to be used in the tests.
     */
    private static final double ANNUAL_RATE = 4.4;

    /**
     * The setup fee to be used in the tests.
     */
    private static final double SETUP_FEE = 5.5;

    /**
     * The subscription count to be used in the tests.
     */
    private static final int SUBSCRIPTION_COUNT = 6;

    /**
     * The quantity to be used in the tests.
     */
    private static final int QUANTITY = 7;

    /**
     * The plan add-on to be used in the tests.
     */
    @Mock
    private PlanAddOn planAddOn;

    /**
     * Sets up before each test.
     */
    @BeforeEach
    public void setup() {
        addOn = AddOn.builder()
                .name("name")
                .billingAddOnType(BILLING_ADD_ON_TYPE)
                .quantityEditable(false)
                .minimumQuantity(MINIMUM_QUANTITY)
                .monthlyRate(MONTHLY_RATE)
                .annualRate(ANNUAL_RATE)
                .setupFee(SETUP_FEE)
                .unitOfMeasure("unitOfMeasure")
                .taxable(false)
                .billedDuringTrial(false)
                .stripeTaxCodeId("stripeTaxCodeId")
                .planAddOns(List.of(planAddOn))
                .contentGroups(List.of("contentGroups"))
                .subscriptionCount(SUBSCRIPTION_COUNT)
                .quantity(QUANTITY)
                .activityEventData("activityEventData")
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
    }

    /**
     * This method tests that builder values are correctly set.
     */
    @Test
    public void testBuilderValues() {
        assertEquals("name", addOn.getName());
        assertEquals(BILLING_ADD_ON_TYPE, addOn.getBillingAddOnType());
        assertFalse(addOn.isQuantityEditable());
        assertEquals(MINIMUM_QUANTITY, addOn.getMinimumQuantity());
        assertEquals(MONTHLY_RATE, addOn.getMonthlyRate());
        assertEquals(ANNUAL_RATE, addOn.getAnnualRate());
        assertEquals(SETUP_FEE, addOn.getSetupFee());
        assertEquals("unitOfMeasure", addOn.getUnitOfMeasure());
        assertFalse(addOn.isTaxable());
        assertFalse(addOn.isBilledDuringTrial());
        assertEquals("stripeTaxCodeId", addOn.getStripeTaxCodeId());
        assertEquals(List.of(planAddOn), addOn.getPlanAddOns());
        assertEquals(List.of("contentGroups"), addOn.getContentGroups());
        assertEquals(SUBSCRIPTION_COUNT, addOn.getSubscriptionCount());
        assertEquals(QUANTITY, addOn.getQuantity());
        assertEquals("activityEventData", addOn.getActivityEventData());
        assertEquals("uid", addOn.getUid());
        assertEquals(new Date(TIMESTAMP), addOn.getCreated());
        assertEquals(new Date(TIMESTAMP), addOn.getUpdated());
    }

    /**
     * This method tests the builder default values set.
     */
    @Test
    public void testBuilderDefaults() {
        AddOn test = AddOn.builder()
                .build();

        assertNull(test.getName());
        assertNull(test.getBillingAddOnType());
        assertNull(test.isQuantityEditable());
        assertNull(test.getMinimumQuantity());
        assertNull(test.getMonthlyRate());
        assertNull(test.getAnnualRate());
        assertNull(test.getSetupFee());
        assertNull(test.getUnitOfMeasure());
        assertNull(test.isTaxable());
        assertNull(test.isBilledDuringTrial());
        assertNull(test.getStripeTaxCodeId());
        assertNull(test.getPlanAddOns());
        assertNull(test.getContentGroups());
        assertNull(test.getSubscriptionCount());
        assertNull(test.getQuantity());
        assertNull(test.getActivityEventData());
        assertNull(test.getUid());
        assertNull(test.getCreated());
        assertNull(test.getUpdated());
    }

    /**
     * This method tests the get and set methods of the name field.
     */
    @Test
    public void testGetAndSetName() {
        addOn.setName("newName");
        assertEquals("newName", addOn.getName());
    }

    /**
     * This method tests the get and set methods of the billingAddOnType field.
     */
    @Test
    public void testGetAndSetBillingAddOnType() {
        addOn.setBillingAddOnType(BILLING_ADD_ON_TYPE + 1);
        assertEquals(BILLING_ADD_ON_TYPE + 1, addOn.getBillingAddOnType());
    }

    /**
     * This method tests the get and set methods of the quantityEditable field.
     */
    @Test
    public void testGetAndSetQuantityEditable() {
        addOn.setQuantityEditable(true);
        assertTrue(addOn.isQuantityEditable());
    }

    /**
     * This method tests the get and set methods of the minimumQuantity field.
     */
    @Test
    public void testGetAndSetMinimumQuantity() {
        addOn.setMinimumQuantity(MINIMUM_QUANTITY + 1);
        assertEquals(MINIMUM_QUANTITY + 1, addOn.getMinimumQuantity());
    }

    /**
     * This method tests the get and set methods of the monthlyRate field.
     */
    @Test
    public void testGetAndSetMonthlyRate() {
        addOn.setMonthlyRate(MONTHLY_RATE + 1);
        assertEquals(MONTHLY_RATE + 1, addOn.getMonthlyRate());
    }

    /**
     * This method tests the get and set methods of the annualRate field.
     */
    @Test
    public void testGetAndSetAnnualRate() {
        addOn.setAnnualRate(ANNUAL_RATE + 1);
        assertEquals(ANNUAL_RATE + 1, addOn.getAnnualRate());
    }

    /**
     * This method tests the get and set methods of the setupFee field.
     */
    @Test
    public void testGetAndSetSetupFee() {
        addOn.setSetupFee(SETUP_FEE + 1);
        assertEquals(SETUP_FEE + 1, addOn.getSetupFee());
    }

    /**
     * This method tests the get and set methods of the unitOfMeasure field.
     */
    @Test
    public void testGetAndSetUnitOfMeasure() {
        addOn.setUnitOfMeasure("newUnitOfMeasure");
        assertEquals("newUnitOfMeasure", addOn.getUnitOfMeasure());
    }

    /**
     * This method tests the get and set methods of the taxable field.
     */
    @Test
    public void testGetAndSetTaxable() {
        addOn.setTaxable(true);
        assertTrue(addOn.isTaxable());
    }

    /**
     * This method tests the get and set methods of the billedDuringTrial field.
     */
    @Test
    public void testGetAndSetBilledDuringTrial() {
        addOn.setBilledDuringTrial(true);
        assertTrue(addOn.isBilledDuringTrial());
    }

    /**
     * This method tests the get and set methods of the stripeTaxCodeId field.
     */
    @Test
    public void testGetAndSetStripeTaxCodeId() {
        addOn.setStripeTaxCodeId("newStripeTaxCodeId");
        assertEquals("newStripeTaxCodeId", addOn.getStripeTaxCodeId());
    }

    /**
     * This method tests the get and set methods of the planAddOns field.
     */
    @Test
    public void testGetAndSetPlanAddOns() {
        addOn.setPlanAddOns(List.of(planAddOn));
        assertEquals(List.of(planAddOn), addOn.getPlanAddOns());
    }

    /**
     * This method tests the get and set methods of the contentGroups field.
     */
    @Test
    public void testGetAndSetContentGroups() {
        addOn.setContentGroups(List.of("newContentGroups"));
        assertEquals(List.of("newContentGroups"), addOn.getContentGroups());
    }

    /**
     * This method tests the get and set methods of the subscriptionCount field.
     */
    @Test
    public void testGetAndSetSubscriptionCount() {
        addOn.setSubscriptionCount(SUBSCRIPTION_COUNT + 1);
        assertEquals(SUBSCRIPTION_COUNT + 1, addOn.getSubscriptionCount());
    }

    /**
     * This method tests the get and set methods of the quantity field.
     */
    @Test
    public void testGetAndSetQuantity() {
        addOn.setQuantity(QUANTITY + 1);
        assertEquals(QUANTITY + 1, addOn.getQuantity());
    }

    /**
     * This method tests the get and set methods of the activityEventData field.
     */
    @Test
    public void testGetAndSetActivityEventData() {
        addOn.setActivityEventData("newActivityEventData");
        assertEquals("newActivityEventData", addOn.getActivityEventData());
    }

    /**
     * This method tests the get and set methods of the uid field.
     */
    @Test
    public void testGetAndSetUid() {
        addOn.setUid("newUid");
        assertEquals("newUid", addOn.getUid());
    }

    /**
     * This method tests the get and set methods of the created field.
     */
    @Test
    public void testGetAndSetCreated() {
        addOn.setCreated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), addOn.getCreated());
    }

    /**
     * This method tests the get and set methods of the updated field.
     */
    @Test
    public void testGetAndSetUpdated() {
        addOn.setUpdated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), addOn.getUpdated());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {
        AddOn test = AddOn.builder()
                .name("name")
                .billingAddOnType(BILLING_ADD_ON_TYPE)
                .quantityEditable(false)
                .minimumQuantity(MINIMUM_QUANTITY)
                .monthlyRate(MONTHLY_RATE)
                .annualRate(ANNUAL_RATE)
                .setupFee(SETUP_FEE)
                .unitOfMeasure("unitOfMeasure")
                .taxable(false)
                .billedDuringTrial(false)
                .stripeTaxCodeId("stripeTaxCodeId")
                .planAddOns(List.of(planAddOn))
                .contentGroups(List.of("contentGroups"))
                .subscriptionCount(SUBSCRIPTION_COUNT)
                .quantity(QUANTITY)
                .activityEventData("activityEventData")
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();

        assertEquals(addOn, test);
        assertNotEquals(addOn, null);
        assertNotEquals(addOn, new Object());
        assertEquals(addOn, addOn);

        test.setUid("newUid");
        assertNotEquals(addOn, test);
    }

    /**
     * This method tests the hash code method.
     */
    @Test
    public void testHashCode() {
        AddOn test = AddOn.builder()
                .name("name")
                .billingAddOnType(BILLING_ADD_ON_TYPE)
                .quantityEditable(false)
                .minimumQuantity(MINIMUM_QUANTITY)
                .monthlyRate(MONTHLY_RATE)
                .annualRate(ANNUAL_RATE)
                .setupFee(SETUP_FEE)
                .unitOfMeasure("unitOfMeasure")
                .taxable(false)
                .billedDuringTrial(false)
                .stripeTaxCodeId("stripeTaxCodeId")
                .planAddOns(List.of(planAddOn))
                .contentGroups(List.of("contentGroups"))
                .subscriptionCount(SUBSCRIPTION_COUNT)
                .quantity(QUANTITY)
                .activityEventData("activityEventData")
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();

        assertEquals(addOn.hashCode(), test.hashCode());
    }
}
