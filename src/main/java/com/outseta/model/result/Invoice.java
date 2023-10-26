package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * This class represents an Invoice.
 */
public final class Invoice implements BaseInput, BaseResult {

    /**
     * Builder class for the Invoice class.
     */
    public static class Builder {

        /**
         * The invoice object to build.
         */
        private final Invoice invoice;

        /**
         * Default constructor for the builder.
         */
        public Builder() {
            invoice = new Invoice();
        }

        /**
         * Set the invoice date.
         *
         * @param invoiceDate The invoice date.
         * @return The builder instance.
         */
        public Builder invoiceDate(final Date invoiceDate) {
            this.invoice.invoiceDate = invoiceDate;
            return this;
        }

        /**
         * Set the invoice number.
         *
         * @param number The invoice number.
         * @return The builder instance.
         */
        public Builder number(final Integer number) {
            this.invoice.number = number;
            return this;
        }

        /**
         * Set the billing invoice status.
         *
         * @param billingInvoiceStatus The billing invoice status.
         * @return The builder instance.
         */
        public Builder billingInvoiceStatus(
                final Integer billingInvoiceStatus) {
            this.invoice.billingInvoiceStatus = billingInvoiceStatus;
            return this;
        }

        /**
         * Set the subscription details.
         *
         * @param subscription The subscription details.
         * @return The builder instance.
         */
        public Builder subscription(final Subscription subscription) {
            this.invoice.subscription = subscription;
            return this;
        }

        /**
         * Set the total amount of the invoice.
         *
         * @param amount The invoice amount.
         * @return The builder instance.
         */
        public Builder amount(final Double amount) {
            this.invoice.amount = amount;
            return this;
        }

        /**
         * Set the amount outstanding for the invoice.
         *
         * @param amountOutstanding The amount outstanding.
         * @return The builder instance.
         */
        public Builder amountOutstanding(final Double amountOutstanding) {
            this.invoice.amountOutstanding = amountOutstanding;
            return this;
        }

        /**
         * Set the line items included in the invoice.
         *
         * @param invoiceLineItems The invoice line items.
         * @return The builder instance.
         */
        public Builder invoiceLineItems(
                final List<InvoiceLineItem> invoiceLineItems) {
            this.invoice.invoiceLineItems = invoiceLineItems;
            return this;
        }

        /**
         * Set whether the invoice is user-generated.
         *
         * @param isUserGenerated True if the invoice is user-generated,
         *                        false otherwise.
         * @return The builder instance.
         */
        public Builder isUserGenerated(final Boolean isUserGenerated) {
            this.invoice.isUserGenerated = isUserGenerated;
            return this;
        }

        /**
         * Set the unique identifier for the invoice.
         *
         * @param uid The unique identifier.
         * @return The builder instance.
         */
        public Builder uid(final String uid) {
            this.invoice.uid = uid;
            return this;
        }

        /**
         * Set the date and time when the invoice was created.
         *
         * @param created The creation date and time.
         * @return The builder instance.
         */
        public Builder created(final Date created) {
            this.invoice.created = created;
            return this;
        }

        /**
         * Set the date and time when the invoice was last updated.
         *
         * @param updated The last update date and time.
         * @return The builder instance.
         */
        public Builder updated(final Date updated) {
            this.invoice.updated = updated;
            return this;
        }

        /**
         * Set the subtotal value.
         *
         * @param subtotal The subtotal value.
         * @return The builder instance.
         */
        public Builder subtotal(final Double subtotal) {
            this.invoice.subtotal = subtotal;
            return this;
        }

        /**
         * Set the tax value.
         *
         * @param tax The tax value.
         * @return The builder instance.
         */
        public Builder tax(final Double tax) {
            this.invoice.tax = tax;
            return this;
        }

        /**
         * Set the tax behaviour.
         *
         * @param taxBehaviour The tax behaviour.
         * @return The builder instance.
         */
        public Builder taxBehaviour(final String taxBehaviour) {
            this.invoice.taxBehaviour = taxBehaviour;
            return this;
        }

        /**
         * Set the paid amount.
         *
         * @param paid The paid amount.
         * @return The builder instance.
         */
        public Builder paid(final Double paid) {
            this.invoice.paid = paid;
            return this;
        }

        /**
         * Set the invoice display items.
         *
         * @param invoiceDisplayItems The invoice display items.
         * @return The builder instance.
         */
        public Builder invoiceDisplayItems(
                final List<InvoiceDisplayItem> invoiceDisplayItems) {
            this.invoice.invoiceDisplayItems = invoiceDisplayItems;
            return this;
        }

        /**
         * Set the total value.
         *
         * @param total The total value.
         * @return The builder instance.
         */
        public Builder total(final Double total) {
            this.invoice.total = total;
            return this;
        }

        /**
         * Set the balance value.
         *
         * @param balance The balance value.
         * @return The builder instance.
         */
        public Builder balance(final Double balance) {
            this.invoice.balance = balance;
            return this;
        }

        /**
         * Build the Invoice instance.
         *
         * @return The Invoice instance.
         */
        public Invoice build() {
            return invoice;
        }
    }

    /**
     * The date when the invoice was generated.
     */
    @JsonProperty("InvoiceDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date invoiceDate;

    /**
     * The invoice number.
     */
    @JsonProperty("Number")
    private Integer number;

    /**
     * The billing invoice status.
     */
    @JsonProperty("BillingInvoiceStatus")
    private Integer billingInvoiceStatus;

    /**
     * The subscription details associated with the invoice.
     */
    @JsonProperty("Subscription")
    private Subscription subscription;

    /**
     * The total amount of the invoice.
     */
    @JsonProperty("Amount")
    private Double amount;

    /**
     * The amount outstanding for the invoice.
     */
    @JsonProperty("AmountOutstanding")
    private Double amountOutstanding;

    /**
     * The line items included in the invoice.
     */
    @JsonProperty("InvoiceLineItems")
    private List<InvoiceLineItem> invoiceLineItems;

    /**
     * Indicates whether the invoice is user-generated.
     */
    @JsonProperty("IsUserGenerated")
    private Boolean isUserGenerated;

    /**
     * The unique identifier for the invoice.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * The date and time when the invoice was created.
     */
    @JsonProperty("Created")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * The date and time when the invoice was last updated.
     */
    @JsonProperty("Updated")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updated;

    /**
     * The subtotal value.
     */
    @JsonProperty("Subtotal")
    private Double subtotal;

    /**
     * The tax value.
     */
    @JsonProperty("Tax")
    private Double tax;

    /**
     * The tax behaviour.
     */
    @JsonProperty("TaxBehaviour")
    private String taxBehaviour;

    /**
     * The paid amount.
     */
    @JsonProperty("Paid")
    private Double paid;

    /**
     * The invoice display items.
     */
    @JsonProperty("InvoiceDisplayItems")
    private List<InvoiceDisplayItem> invoiceDisplayItems;

    /**
     * The total value.
     */
    @JsonProperty("Total")
    private Double total;

    /**
     * The balance value.
     */
    @JsonProperty("Balance")
    private Double balance;

    /**
     * Returns a new builder for creating invoice.
     * @return The builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Get the date when the invoice was generated.
     *
     * @return The invoice date.
     */
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * Set the date when the invoice was generated.
     *
     * @param pInvoiceDate The invoice date.
     */
    public void setInvoiceDate(final Date pInvoiceDate) {
        this.invoiceDate = pInvoiceDate;
    }

    /**
     * Get the invoice number.
     *
     * @return The invoice number.
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Set the invoice number.
     *
     * @param pNumber The invoice number.
     */
    public void setNumber(final Integer pNumber) {
        this.number = pNumber;
    }

    /**
     * Get the billing invoice status.
     *
     * @return The billing invoice status.
     */
    public Integer getBillingInvoiceStatus() {
        return billingInvoiceStatus;
    }

    /**
     * Set the billing invoice status.
     *
     * @param pBillingInvoiceStatus The billing invoice status.
     */
    public void setBillingInvoiceStatus(final Integer pBillingInvoiceStatus) {
        this.billingInvoiceStatus = pBillingInvoiceStatus;
    }

    /**
     * Get the subscription details associated with the invoice.
     *
     * @return The subscription details.
     */
    public Subscription getSubscription() {
        return subscription;
    }

    /**
     * Set the subscription details.
     *
     * @param pSubscription The subscription details.
     */
    public void setSubscription(final Subscription pSubscription) {
        this.subscription = pSubscription;
    }

    /**
     * Get the total amount of the invoice.
     *
     * @return The invoice amount.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Set the total amount of the invoice.
     *
     * @param pAmount The invoice amount.
     */
    public void setAmount(final Double pAmount) {
        this.amount = pAmount;
    }

    /**
     * Get the amount outstanding for the invoice.
     *
     * @return The amount outstanding.
     */
    public Double getAmountOutstanding() {
        return amountOutstanding;
    }

    /**
     * Set the amount outstanding for the invoice.
     *
     * @param pAmountOutstanding The amount outstanding.
     */
    public void setAmountOutstanding(final Double pAmountOutstanding) {
        this.amountOutstanding = pAmountOutstanding;
    }

    /**
     * Get the line items included in the invoice.
     *
     * @return The invoice line items.
     */
    public List<InvoiceLineItem> getInvoiceLineItems() {
        return invoiceLineItems;
    }

    /**
     * Set the line items included in the invoice.
     *
     * @param pInvoiceLineItems The invoice line items.
     */
    public void setInvoiceLineItems(
            final List<InvoiceLineItem> pInvoiceLineItems) {
        this.invoiceLineItems = pInvoiceLineItems;
    }

    /**
     * Check if the invoice is user-generated.
     *
     * @return True if the invoice is user-generated, false otherwise.
     */
    public Boolean isUserGenerated() {
        return isUserGenerated;
    }

    /**
     * Set whether the invoice is user-generated.
     *
     * @param pIsUserGenerated True if the invoice is user-generated,
     *                        false otherwise.
     */
    public void setUserGenerated(final Boolean pIsUserGenerated) {
        this.isUserGenerated = pIsUserGenerated;
    }

    /**
     * Get the unique identifier for the invoice.
     *
     * @return The unique identifier.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Set the unique identifier for the invoice.
     *
     * @param pUid The unique identifier.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Get the date and time when the invoice was created.
     *
     * @return The creation date and time.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Set the date and time when the invoice was created.
     *
     * @param pCreated The creation date and time.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Get the date and time when the invoice was last updated.
     *
     * @return The last update date and time.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Get the subtotal value.
     *
     * @return The subtotal value.
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /**
     * Set the subtotal value.
     *
     * @param pSubtotal The subtotal value.
     */
    public void setSubtotal(final Double pSubtotal) {
        this.subtotal = pSubtotal;
    }

    /**
     * Get the tax value.
     *
     * @return The tax value.
     */
    public Double getTax() {
        return tax;
    }

    /**
     * Set the tax value.
     *
     * @param pTax The tax value.
     */
    public void setTax(final Double pTax) {
        this.tax = pTax;
    }

    /**
     * Get the tax behaviour.
     *
     * @return The tax behaviour.
     */
    public String getTaxBehaviour() {
        return taxBehaviour;
    }

    /**
     * Set the tax behaviour.
     *
     * @param pTaxBehaviour The tax behaviour.
     */
    public void setTaxBehaviour(final String pTaxBehaviour) {
        this.taxBehaviour = pTaxBehaviour;
    }

    /**
     * Get the paid amount.
     *
     * @return The paid amount.
     */
    public Double getPaid() {
        return paid;
    }

    /**
     * Set the paid amount.
     *
     * @param pPaid The paid amount.
     */
    public void setPaid(final Double pPaid) {
        this.paid = pPaid;
    }

    /**
     * Get the invoice display items.
     *
     * @return The invoice display items.
     */
    public List<InvoiceDisplayItem> getInvoiceDisplayItems() {
        return invoiceDisplayItems;
    }

    /**
     * Set the invoice display items.
     *
     * @param pInvoiceDisplayItems The invoice display items.
     */
    public void setInvoiceDisplayItems(
            final List<InvoiceDisplayItem> pInvoiceDisplayItems) {
        this.invoiceDisplayItems = pInvoiceDisplayItems;
    }

    /**
     * Get the total value.
     *
     * @return The total value.
     */
    public Double getTotal() {
        return total;
    }

    /**
     * Set the total value.
     *
     * @param pTotal The total value.
     */
    public void setTotal(final Double pTotal) {
        this.total = pTotal;
    }

    /**
     * Get the balance value.
     *
     * @return The balance value.
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * Set the balance value.
     *
     * @param pBalance The balance value.
     */
    public void setBalance(final Double pBalance) {
        this.balance = pBalance;
    }

    /**
     * Set the date and time when the invoice was last updated.
     *
     * @param pUpdated The last update date and time.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * Compares the Invoice instance with another object.
     *
     * @param other The other object.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Invoice)) {
            return false;
        }

        Invoice otherInvoice = (Invoice) other;

        return Objects.equals(this.uid, otherInvoice.uid);
    }

    /**
     * Returns the hash code for the Invoice instance.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
