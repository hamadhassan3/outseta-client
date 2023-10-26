package com.outseta.constant;

/**
 * Enum representing the constants for DiscountDuration.
 */
public enum DiscountDuration {

    /**
     * This enum value is used to indicate that the discount duration
     * is forever.
     */
    FOREVER(1),

    /**
     * This enum value is used to indicate that the discount duration
     * is once.
     */
    ONCE(2),

    /**
     * This enum value is used to indicate that the discount duration
     * is repeating. Duration in months must be specified.
     */
    REPEATING(3);

    /**
     * The integer value associated with the enum constant.
     */
    private final int value;

    /**
     * Constructor for ActivityType enum.
     *
     * @param pValue The integer value associated with the enum constant.
     */
    DiscountDuration(final int pValue) {
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
