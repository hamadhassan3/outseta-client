package com.outseta.constant;

/**
 * Enum representing the constants for ActivityType.
 */
public enum ActivityType {
    /**
     * Custom activity type.
     */
    CUSTOM(10),

    /**
     * Note activity type.
     */
    NOTE(50),

    /**
     * Email activity type.
     */
    EMAIL(51),

    /**
     * Phone call activity type.
     */
    PHONE_CALL(52),

    /**
     * Meeting activity type.
     */
    MEETING(53),

    /**
     * Account created activity type.
     */
    ACCOUNT_CREATED(100),

    /**
     * Account updated activity type.
     */
    ACCOUNT_UPDATED(101),

    /**
     * Account add person activity type.
     */
    ACCOUNT_ADD_PERSON(102),

    /**
     * Account stage updated activity type.
     */
    ACCOUNT_STAGE_UPDATED(103),

    /**
     * Account deleted activity type.
     */
    ACCOUNT_DELETED(104),

    /**
     * Account billing information updated activity type.
     */
    ACCOUNT_BILLING_INFORMATION_UPDATED(105),

    /**
     * Person created activity type.
     */
    PERSON_CREATED(200),

    /**
     * Person updated activity type.
     */
    PERSON_UPDATED(201),

    /**
     * Person deleted activity type.
     */
    PERSON_DELETED(202),

    /**
     * Person login activity type.
     */
    PERSON_LOGIN(203),

    /**
     * Person list subscribed activity type.
     */
    PERSON_LIST_SUBSCRIBED(204),

    /**
     * Person list unsubscribed activity type.
     */
    PERSON_LIST_UNSUBSCRIBED(205),

    /**
     * Person segment added activity type.
     */
    PERSON_SEGMENT_ADDED(206),

    /**
     * Person segment removed activity type.
     */
    PERSON_SEGMENT_REMOVED(207),

    /**
     * Person email opened activity type.
     */
    PERSON_EMAIL_OPENED(208),

    /**
     * Person email clicked activity type.
     */
    PERSON_EMAIL_CLICKED(209),

    /**
     * Person email bounce activity type.
     */
    PERSON_EMAIL_BOUNCE(210),

    /**
     * Person email spam activity type.
     */
    PERSON_EMAIL_SPAM(211),

    /**
     * Person support ticket created activity type.
     */
    PERSON_SUPPORT_TICKET_CREATED(212),

    /**
     * Person support ticket updated activity type.
     */
    PERSON_SUPPORT_TICKET_UPDATED(213),

    /**
     * Deal created activity type.
     */
    DEAL_CREATED(300),

    /**
     * Deal updated activity type.
     */
    DEAL_UPDATED(301),

    /**
     * Deal add person activity type.
     */
    DEAL_ADD_PERSON(302),

    /**
     * Deal add account activity type.
     */
    DEAL_ADD_ACCOUNT(303);

    /**
     * The integer value associated with the enum constant.
     */
    private final int value;

    /**
     * Constructor for ActivityType enum.
     *
     * @param pValue The integer value associated with the enum constant.
     */
    ActivityType(final int pValue) {
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
