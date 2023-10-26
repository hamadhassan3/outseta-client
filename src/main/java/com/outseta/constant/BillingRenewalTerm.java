package com.outseta.constant;

/**
 * Represents the billing renewal term.
 */
public enum BillingRenewalTerm {

    /**
     * The billing renewal term for monthly.
     */
    Monthly(1),

    /**
     * The billing renewal term for yearly.
     */
    Yearly(2),

    /**
     * The billing renewal term for quarterly.
     */
    Quarterly(3),

    /**
     * The billing renewal term for one time.
     */
    OneTime(4);

    /**
     * The value associated with the billing renewal term.
     */
    private int value;

    /**
     * Constructor for the billing renewal term.
     *
     * @param pValue The value associated with the billing renewal term.
     */
    BillingRenewalTerm(final int pValue) {
        this.value = pValue;
    }

    /**
     * Get the value associated with the billing renewal term.
     *
     * @return The value.
     */
    public int getValue() {
        return value;
    }
}
