package com.outseta.constant;

/**
 * Enum representing the entity types.
 */
public enum EntityType {
    /**
     * Represents an account entity type.
     */
    ACCOUNT(1),

    /**
     * Represents a person entity type.
     */
    PERSON(2),

    /**
     * Represents a deal entity type.
     */
    DEAL(3);

    /**
     * The integer value associated with the enum constant.
     */
    private final int value;

    /**
     * Constructor for EntityType enum.
     *
     * @param pValue The integer value associated with the enum constant.
     */
    EntityType(final int pValue) {
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
