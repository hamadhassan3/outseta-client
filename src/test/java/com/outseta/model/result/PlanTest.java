package com.outseta.model.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class is used to test the Plan class.
 */
@ExtendWith(MockitoExtension.class)
public class PlanTest {

    /**
     * The Plan object to be tested.
     */
    private Plan plan;

    /**
     * The mock planfamily object used or testing.
     */
    @Mock
    private PlanFamily planFamily;

    /**
     * The mock addOn object used for testing.
     */
    @Mock
    private PlanAddOn addOn1;

    /**
     * The mock addOn object used for testing.
     */
    @Mock
    private PlanAddOn addOn2;

    /**
     * A random timestamp to be used for creating date objects.
     */
    private static final long TIMESTAMP = 1234567890;

    /**
     * The account registration mode used for testing.
     */
    private static final int ACCOUNT_REGISTRATION_MODE = 8;

    /**
     * The minimum quantity used for testing.
     */
    private static final int MINIMUM_QUANTITY = 1;

    /**
     * The maximum people used for testing.
     */
    private static final int MAXIMUM_PEOPLE = 2;

    /**
     * The monthly rate used for testing.
     */
    private static final double MONTHLY_RATE = 3.3;

    /**
     * The annual rate used for testing.
     */
    private static final double ANNUAL_RATE = 4.4;

    /**
     * The quarterly rate used for testing.
     */
    private static final double QUARTERLY_RATE = 5.5;

    /**
     * The one time rate used for testing.
     */
    private static final double ONE_TIME_RATE = 6.6;

    /**
     * The setup fee used for testing.
     */
    private static final double SETUP_FEE = 7.7;

    /**
     * The trial period days used for testing.
     */
    private static final int TRIAL_PERIOD_DAYS = 9;

    /**
     * The expires after months used for testing.
     */
    private static final int EXPIRES_AFTER_MONTHS = 10;

    /**
     * The number of subscriptions used for testing.
     */
    private static final int NUMBER_OF_SUBSCRIPTIONS = 11;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    void setUp() {
        plan = Plan.builder()
                .name("name")
                .description("description")
                .planFamily(planFamily)
                .accountRegistrationMode(ACCOUNT_REGISTRATION_MODE)
                .quantityEditable(false)
                .minimumQuantity(MINIMUM_QUANTITY)
                .maximumPeople(MAXIMUM_PEOPLE)
                .monthlyRate(MONTHLY_RATE)
                .annualRate(ANNUAL_RATE)
                .quarterlyRate(QUARTERLY_RATE)
                .oneTimeRate(ONE_TIME_RATE)
                .setupFee(SETUP_FEE)
                .taxable(false)
                .active(false)
                .perUser(false)
                .requirePaymentInformation(false)
                .trialPeriodDays(TRIAL_PERIOD_DAYS)
                .trialUntilDate(new Date(TIMESTAMP))
                .expiresAfterMonths(EXPIRES_AFTER_MONTHS)
                .expirationDate(new Date(TIMESTAMP))
                .postLoginPath("postLoginPath")
                .stripeTaxCodeId("stripeTaxCodeId")
                .unitOfMeasure("unitOfMeasure")
                .planAddOns(Arrays.asList(addOn1, addOn2))
                .contentGroups(Arrays.asList("contentGroup1", "contentGroup2"))
                .numberOfSubscriptions(NUMBER_OF_SUBSCRIPTIONS)
                .activityEventData("activityEventData")
                .uid("uid")
                .created(new Date(TIMESTAMP))
                .updated(new Date(TIMESTAMP))
                .build();
    }

    /**
     * This method tests the builder values.
     */
    @Test
    public void testBuilderValues() {
        assertEquals("name", plan.getName());
        assertEquals("description", plan.getDescription());
        assertEquals(planFamily, plan.getPlanFamily());
        assertEquals(ACCOUNT_REGISTRATION_MODE,
                plan.getAccountRegistrationMode());
        assertFalse(plan.isQuantityEditable());
        assertEquals(MINIMUM_QUANTITY, plan.getMinimumQuantity());
        assertEquals(MAXIMUM_PEOPLE, plan.getMaximumPeople());
        assertEquals(MONTHLY_RATE, plan.getMonthlyRate());
        assertEquals(ANNUAL_RATE, plan.getAnnualRate());
        assertEquals(QUARTERLY_RATE, plan.getQuarterlyRate());
        assertEquals(ONE_TIME_RATE, plan.getOneTimeRate());
        assertEquals(SETUP_FEE, plan.getSetupFee());
        assertFalse(plan.isTaxable());
        assertFalse(plan.isActive());
        assertFalse(plan.isPerUser());
        assertFalse(plan.isRequirePaymentInformation());
        assertEquals(TRIAL_PERIOD_DAYS, plan.getTrialPeriodDays());
        assertEquals(new Date(TIMESTAMP), plan.getTrialUntilDate());
        assertEquals(EXPIRES_AFTER_MONTHS, plan.getExpiresAfterMonths());
        assertEquals(new Date(TIMESTAMP), plan.getExpirationDate());
        assertEquals("postLoginPath", plan.getPostLoginPath());
        assertEquals("stripeTaxCodeId", plan.getStripeTaxCodeId());
        assertEquals("unitOfMeasure", plan.getUnitOfMeasure());
        assertEquals(Arrays.asList(addOn1, addOn2), plan.getPlanAddOns());
        assertEquals(Arrays.asList("contentGroup1", "contentGroup2"),
                plan.getContentGroups());
        assertEquals(NUMBER_OF_SUBSCRIPTIONS, plan.getNumberOfSubscriptions());
        assertEquals("activityEventData", plan.getActivityEventData());
        assertEquals("uid", plan.getUid());
        assertEquals(new Date(TIMESTAMP), plan.getCreated());
        assertEquals(new Date(TIMESTAMP), plan.getUpdated());
    }

    /**
     * This method tests the default values set by the builder.
     */
    @Test
    public void testBuilderDefaults() {
        plan = Plan.builder().build();
        assertNull(plan.getName());
        assertNull(plan.getDescription());
        assertNull(plan.getPlanFamily());
        assertNull(plan.getAccountRegistrationMode());
        assertNull(plan.isQuantityEditable());
        assertNull(plan.getMinimumQuantity());
        assertNull(plan.getMaximumPeople());
        assertNull(plan.getMonthlyRate());
        assertNull(plan.getAnnualRate());
        assertNull(plan.getQuarterlyRate());
        assertNull(plan.getOneTimeRate());
        assertNull(plan.getSetupFee());
        assertNull(plan.isTaxable());
        assertNull(plan.isActive());
        assertNull(plan.isPerUser());
        assertNull(plan.isRequirePaymentInformation());
        assertNull(plan.getTrialPeriodDays());
        assertNull(plan.getTrialUntilDate());
        assertNull(plan.getExpiresAfterMonths());
        assertNull(plan.getExpirationDate());
        assertNull(plan.getPostLoginPath());
        assertNull(plan.getStripeTaxCodeId());
        assertNull(plan.getUnitOfMeasure());
        assertNull(plan.getPlanAddOns());
        assertNull(plan.getContentGroups());
        assertNull(plan.getNumberOfSubscriptions());
        assertNull(plan.getActivityEventData());
        assertNull(plan.getUid());
        assertNull(plan.getCreated());
        assertNull(plan.getUpdated());
    }

    /**
     * This method tests the get and set methods for the name field.
     */
    @Test
    public void testGetAndSetName() {
        plan.setName("newName");
        assertEquals("newName", plan.getName());
    }

    /**
     * This method tests the get and set methods for the description field.
     */
    @Test
    public void testGetAndSetDescription() {
        plan.setDescription("newDescription");
        assertEquals("newDescription", plan.getDescription());
    }

    /**
     * This method tests the get and set methods for the planFamily field.
     */
    @Test
    public void testGetAndSetPlanFamily() {
        plan.setPlanFamily(planFamily);
        assertEquals(planFamily, plan.getPlanFamily());
    }

    /**
     * This method tests the get and set methods for the accountRegistrationMode
     * field.
     */
    @Test
    public void testGetAndSetAccountRegistrationMode() {
        plan.setAccountRegistrationMode(ACCOUNT_REGISTRATION_MODE + 1);
        assertEquals(ACCOUNT_REGISTRATION_MODE + 1,
                plan.getAccountRegistrationMode());
    }

    /**
     * This method tests the get and set methods for the quantityEditable field.
     */
    @Test
    public void testGetAndSetQuantityEditable() {
        plan.setQuantityEditable(true);
        assertTrue(plan.isQuantityEditable());
    }

    /**
     * This method tests the get and set methods for the minimumQuantity field.
     */
    @Test
    public void testGetAndSetMinimumQuantity() {
        plan.setMinimumQuantity(MINIMUM_QUANTITY + 1);
        assertEquals(MINIMUM_QUANTITY + 1, plan.getMinimumQuantity());
    }

    /**
     * This method tests the get and set methods for the maximumPeople field.
     */
    @Test
    public void testGetAndSetMaximumPeople() {
        plan.setMaximumPeople(MAXIMUM_PEOPLE + 1);
        assertEquals(MAXIMUM_PEOPLE + 1, plan.getMaximumPeople());
    }

    /**
     * This method tests the get and set methods for the monthlyRate field.
     */
    @Test
    public void testGetAndSetMonthlyRate() {
        plan.setMonthlyRate(MONTHLY_RATE + 1);
        assertEquals(MONTHLY_RATE + 1, plan.getMonthlyRate());
    }

    /**
     * This method tests the get and set methods for the annualRate field.
     */
    @Test
    public void testGetAndSetAnnualRate() {
        plan.setAnnualRate(ANNUAL_RATE + 1);
        assertEquals(ANNUAL_RATE + 1, plan.getAnnualRate());
    }

    /**
     * This method tests the get and set methods for the quarterlyRate field.
     */
    @Test
    public void testGetAndSetQuarterlyRate() {
        plan.setQuarterlyRate(QUARTERLY_RATE + 1);
        assertEquals(QUARTERLY_RATE + 1, plan.getQuarterlyRate());
    }

    /**
     * This method tests the get and set methods for the oneTimeRate field.
     */
    @Test
    public void testGetAndSetOneTimeRate() {
        plan.setOneTimeRate(ONE_TIME_RATE + 1);
        assertEquals(ONE_TIME_RATE + 1, plan.getOneTimeRate());
    }

    /**
     * This method tests the get and set methods for the setupFee field.
     */
    @Test
    public void testGetAndSetSetupFee() {
        plan.setSetupFee(SETUP_FEE + 1);
        assertEquals(SETUP_FEE + 1, plan.getSetupFee());
    }

    /**
     * This method tests the get and set methods for the taxable field.
     */
    @Test
    public void testGetAndSetTaxable() {
        plan.setTaxable(true);
        assertTrue(plan.isTaxable());
    }

    /**
     * This method tests the get and set methods for the active field.
     */
    @Test
    public void testGetAndSetActive() {
        plan.setActive(true);
        assertTrue(plan.isActive());
    }

    /**
     * This method tests the get and set methods for the perUser field.
     */
    @Test
    public void testGetAndSetPerUser() {
        plan.setPerUser(true);
        assertTrue(plan.isPerUser());
    }

    /**
     * This method tests the get and set methods for the
     * requirePaymentInformation
     * field.
     */
    @Test
    public void testGetAndSetRequirePaymentInformation() {
        plan.setRequirePaymentInformation(true);
        assertTrue(plan.isRequirePaymentInformation());
    }

    /**
     * This method tests the get and set methods for the trialPeriodDays field.
     */
    @Test
    public void testGetAndSetTrialPeriodDays() {
        plan.setTrialPeriodDays(TRIAL_PERIOD_DAYS + 1);
        assertEquals(TRIAL_PERIOD_DAYS + 1, plan.getTrialPeriodDays());
    }

    /**
     * This method tests the get and set methods for the trialUntilDate field.
     */
    @Test
    public void testGetAndSetTrialUntilDate() {
        plan.setTrialUntilDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), plan.getTrialUntilDate());
    }

    /**
     * This method tests the get and set methods for the expiresAfterMonths
     * field.
     */
    @Test
    public void testGetAndSetExpiresAfterMonths() {
        plan.setExpiresAfterMonths(EXPIRES_AFTER_MONTHS + 1);
        assertEquals(EXPIRES_AFTER_MONTHS + 1, plan.getExpiresAfterMonths());
    }

    /**
     * This method tests the get and set methods for the expirationDate field.
     */
    @Test
    public void testGetAndSetExpirationDate() {
        plan.setExpirationDate(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), plan.getExpirationDate());
    }

    /**
     * This method tests the get and set methods for the postLoginPath field.
     */
    @Test
    public void testGetAndSetPostLoginPath() {
        plan.setPostLoginPath("newPostLoginPath");
        assertEquals("newPostLoginPath", plan.getPostLoginPath());
    }

    /**
     * This method tests the get and set methods for the stripeTaxCodeId field.
     */
    @Test
    public void testGetAndSetStripeTaxCodeId() {
        plan.setStripeTaxCodeId("newStripeTaxCodeId");
        assertEquals("newStripeTaxCodeId", plan.getStripeTaxCodeId());
    }

    /**
     * This method tests the get and set methods for the unitOfMeasure field.
     */
    @Test
    public void testGetAndSetUnitOfMeasure() {
        plan.setUnitOfMeasure("newUnitOfMeasure");
        assertEquals("newUnitOfMeasure", plan.getUnitOfMeasure());
    }

    /**
     * This method tests the get and set methods for the planAddOns field.
     */
    @Test
    public void testGetAndSetPlanAddOns() {
        plan.setPlanAddOns(Arrays.asList(addOn1));
        assertEquals(Arrays.asList(addOn1), plan.getPlanAddOns());
    }

    /**
     * This method tests the get and set methods for the contentGroups field.
     */
    @Test
    public void testGetAndSetContentGroups() {
        plan.setContentGroups(Arrays.asList("newContentGroup"));
        assertEquals(Arrays.asList("newContentGroup"), plan.getContentGroups());
    }

    /**
     * This method tests the get and set methods for the numberOfSubscriptions
     * field.
     */
    @Test
    public void testGetAndSetNumberOfSubscriptions() {
        plan.setNumberOfSubscriptions(NUMBER_OF_SUBSCRIPTIONS + 1);
        assertEquals(NUMBER_OF_SUBSCRIPTIONS + 1,
                plan.getNumberOfSubscriptions());
    }

    /**
     * This method tests the get and set methods for the activityEventData
     * field.
     */
    @Test
    public void testGetAndSetActivityEventData() {
        plan.setActivityEventData("newActivityEventData");
        assertEquals("newActivityEventData", plan.getActivityEventData());
    }

    /**
     * This method tests the get and set methods for the uid field.
     */
    @Test
    public void testGetAndSetUid() {
        plan.setUid("newUid");
        assertEquals("newUid", plan.getUid());
    }

    /**
     * This method tests the get and set methods for the created field.
     */
    @Test
    public void testGetAndSetCreated() {
        plan.setCreated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), plan.getCreated());
    }

    /**
     * This method tests the get and set methods for the updated field.
     */
    @Test
    public void testGetAndSetUpdated() {
        plan.setUpdated(new Date(TIMESTAMP + 1));
        assertEquals(new Date(TIMESTAMP + 1), plan.getUpdated());
    }

    /**
     * This method tests the equals method.
     */
    @Test
    public void testEquals() {

        Plan test = Plan.builder().uid("uid").build();

        assertEquals(plan, test);
        assertEquals(plan, plan);
        assertNotEquals(plan, null);
        assertNotEquals(plan, new Object());
        assertNotEquals(plan, Plan.builder().uid("uid2").build());
    }

    /**
     * This method tests the hashcode method.
     */
    @Test
    public void testHashCode() {
        assertEquals(plan.hashCode(),
                Plan.builder().uid("uid").build().hashCode());
        assertNotEquals(plan.hashCode(),
                Plan.builder().uid("uid2").build().hashCode());
    }

}
