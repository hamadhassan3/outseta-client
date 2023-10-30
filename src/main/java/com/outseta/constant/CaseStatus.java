package com.outseta.constant;

/**
 * This enum represents the case status.
 */
public enum CaseStatus {

    /**
     * This enum value is used to indicate that the case status
     * is open.
     */
    OPEN(1),

    /**
     * This enum value is used to indicate that the case status
     * is closed.
     */
    CLOSED(2);

    /**
     * The integer value associated with the enum constant.
     */
    private final int value;

    /**
     * Constructor for CaseStatus enum.
     *
     * @param pValue The integer value associated with the enum constant.
     */
    CaseStatus(final int pValue) {
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
