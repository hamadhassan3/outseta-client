package com.outseta.constant;

/**
 * Enum representing different case sources.
 */
public enum CaseSource {

    /**
     * The case source of a website.
     */
    WEBSITE(1),

    /**
     * The case source of an email.
     */
    EMAIL(2),

    /**
     * The case source of a Facebook post.
     */
    FACEBOOK(3),

    /**
     * The case source of a Twitter post.
     */
    TWITTER(4);

    /**
     * The integer value associated with the enum constant.
     */
    private final int value;

    /**
     * Constructor for CaseSource enum.
     *
     * @param pValue The integer value associated with the enum constant.
     */
    CaseSource(final int pValue) {
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
