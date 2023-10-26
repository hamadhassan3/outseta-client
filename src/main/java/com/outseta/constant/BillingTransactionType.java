package com.outseta.constant;

/**
 * Enum representing different billing transaction types.
 */
public enum BillingTransactionType {

    /**
     * The billing transaction type for an invoice.
     */
    INVOICE(1),

    /**
     * The billing transaction type for a payment.
     */
    PAYMENT(2),

    /**
     * The billing transaction type for a credit.
     */
    CREDIT(3),

    /**
     * The billing transaction type for a refund.
     */
    REFUND(4),

    /**
     * The billing transaction type for a chargeback.
     */
    CHARGEBACK(5);

    /**
     * The code associated with the billing transaction type.
     */
    private final int value;

    /**
     * Constructor for the billing transaction type.
     *
     * @param pCode The code associated with the billing transaction type.
     */
    BillingTransactionType(final int pCode) {
        this.value = pCode;
    }

    /**
     * Get the code associated with the billing transaction type.
     *
     * @return The code.
     */
    public int getValue() {
        return value;
    }
}
