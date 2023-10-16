package com.outseta.constant;

/**
 * Enum representing the constants for AccountStage.
 */
public enum AccountStage {

    /**
     * The account is in trialing stage.
     */
    Trialing(2),

    /**
     * The account is in subscribing stage.
     */
    Subscribing(3),

    /**
     * The account is in cancelling stage.
     */
    Cancelling(4),

    /**
     * The account is in expired stage.
     */
    Expired(5),

    /**
     * The account is in trial expired stage.
     */
    TrialExpired(6),

    /**
     * The account is in past due stage.
     */
    PastDue(7);

    /**
     * The integer value associated with the enum constant.
     */
    private final int value;

    /**
     * Constructor for AccountStatus enum.
     *
     * @param pValue The integer value associated with the enum constant.
     */
    AccountStage(final int pValue) {
        this.value = pValue;
    }

    /**
     * Get the integer value associated with the enum constant.
     *
     * @return The integer value.
     */
    public int getValue() {
        return value;
    }
}
