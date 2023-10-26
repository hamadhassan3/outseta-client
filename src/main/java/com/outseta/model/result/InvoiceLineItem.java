package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.Objects;

/**
 * Represents an invoice line item.
 */
public final class InvoiceLineItem implements BaseResult, BaseInput {

    /**
     * Builder class for the InvoiceLineItem class.
     */
    public static class Builder {

        /**
         * The object to be built.
         */
        private InvoiceLineItem invoiceLineItem;

        /**
         * Default constructor for the builder.
         */
        public Builder() {
            invoiceLineItem = new InvoiceLineItem();
        }

        /**
         * Set the start date of the line item.
         *
         * @param startDate The start date.
         * @return The builder instance.
         */
        public Builder startDate(final Date startDate) {
            this.invoiceLineItem.startDate = startDate;
            return this;
        }

        /**
         * Set the end date of the line item.
         *
         * @param endDate The end date.
         * @return The builder instance.
         */
        public Builder endDate(final Date endDate) {
            this.invoiceLineItem.endDate = endDate;
            return this;
        }

        /**
         * Set the description of the line item.
         *
         * @param description The description.
         * @return The builder instance.
         */
        public Builder description(final String description) {
            this.invoiceLineItem.description = description;
            return this;
        }

        /**
         * Set the unit of measure for the line item.
         *
         * @param unitOfMeasure The unit of measure.
         * @return The builder instance.
         */
        public Builder unitOfMeasure(final String unitOfMeasure) {
            this.invoiceLineItem.unitOfMeasure = unitOfMeasure;
            return this;
        }

        /**
         * Set the quantity of the line item.
         *
         * @param quantity The quantity.
         * @return The builder instance.
         */
        public Builder quantity(final Integer quantity) {
            this.invoiceLineItem.quantity = quantity;
            return this;
        }

        /**
         * Set the rate of the line item.
         *
         * @param rate The rate.
         * @return The builder instance.
         */
        public Builder rate(final Double rate) {
            this.invoiceLineItem.rate = rate;
            return this;
        }

        /**
         * Set the amount of the line item.
         *
         * @param amount The amount.
         * @return The builder instance.
         */
        public Builder amount(final Double amount) {
            this.invoiceLineItem.amount = amount;
            return this;
        }

        /**
         * Set the tax applied to the line item.
         *
         * @param tax The tax.
         * @return The builder instance.
         */
        public Builder tax(final Double tax) {
            this.invoiceLineItem.tax = tax;
            return this;
        }

        /**
         * Set the associated invoice.
         *
         * @param invoice The associated invoice.
         * @return The builder instance.
         */
        public Builder invoice(final Invoice invoice) {
            this.invoiceLineItem.invoice = invoice;
            return this;
        }

        /**
         * Set the unique identifier for the line item.
         *
         * @param uid The unique identifier.
         * @return The builder instance.
         */
        public Builder uid(final String uid) {
            this.invoiceLineItem.uid = uid;
            return this;
        }

        /**
         * Set the date and time when the line item was created.
         *
         * @param created The creation date and time.
         * @return The builder instance.
         */
        public Builder created(final Date created) {
            this.invoiceLineItem.created = created;
            return this;
        }

        /**
         * Set the date and time when the line item was last updated.
         *
         * @param updated The last update date and time.
         * @return The builder instance.
         */
        public Builder updated(final Date updated) {
            this.invoiceLineItem.updated = updated;
            return this;
        }

        /**
         * Build the InvoiceLineItem instance.
         *
         * @return The InvoiceLineItem instance.
         */
        public InvoiceLineItem build() {
            return invoiceLineItem;
        }
    }

    /**
     * The start date of the line item.
     */
    @JsonProperty("StartDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date startDate;

    /**
     * The end date of the line item.
     */
    @JsonProperty("EndDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date endDate;

    /**
     * The description of the line item.
     */
    @JsonProperty("Description")
    private String description;

    /**
     * The unit of measure for the line item.
     */
    @JsonProperty("UnitOfMeasure")
    private String unitOfMeasure;

    /**
     * The quantity of the line item.
     */
    @JsonProperty("Quantity")
    private Integer quantity;

    /**
     * The rate of the line item.
     */
    @JsonProperty("Rate")
    private Double rate;

    /**
     * The amount of the line item.
     */
    @JsonProperty("Amount")
    private Double amount;

    /**
     * The tax applied to the line item.
     */
    @JsonProperty("Tax")
    private Double tax;

    /**
     * The associated invoice.
     */
    @JsonProperty("Invoice")
    private Invoice invoice;

    /**
     * The unique identifier for the line item.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * The date and time when the line item was created.
     */
    @JsonProperty("Created")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date created;

    /**
     * The date and time when the line item was last updated.
     */
    @JsonProperty("Updated")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updated;

    /**
     * Returns a new builder instance.
     * @return The builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Get the start date of the line item.
     *
     * @return The start date.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Set the start date of the line item.
     *
     * @param pStartDate The start date.
     */
    public void setStartDate(final Date pStartDate) {
        this.startDate = pStartDate;
    }

    /**
     * Get the end date of the line item.
     *
     * @return The end date.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Set the end date of the line item.
     *
     * @param pEndDate The end date.
     */
    public void setEndDate(final Date pEndDate) {
        this.endDate = pEndDate;
    }

    /**
     * Get the description of the line item.
     *
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the line item.
     *
     * @param pDescription The description.
     */
    public void setDescription(final String pDescription) {
        this.description = pDescription;
    }

    /**
     * Get the unit of measure for the line item.
     *
     * @return The unit of measure.
     */
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Set the unit of measure for the line item.
     *
     * @param pUnitOfMeasure The unit of measure.
     */
    public void setUnitOfMeasure(final String pUnitOfMeasure) {
        this.unitOfMeasure = pUnitOfMeasure;
    }

    /**
     * Get the quantity of the line item.
     *
     * @return The quantity.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the line item.
     *
     * @param pQuantity The quantity.
     */
    public void setQuantity(final Integer pQuantity) {
        this.quantity = pQuantity;
    }

    /**
     * Get the rate of the line item.
     *
     * @return The rate.
     */
    public Double getRate() {
        return rate;
    }

    /**
     * Set the rate of the line item.
     *
     * @param pRate The rate.
     */
    public void setRate(final Double pRate) {
        this.rate = pRate;
    }

    /**
     * Get the amount of the line item.
     *
     * @return The amount.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Set the amount of the line item.
     *
     * @param pAmount The amount.
     */
    public void setAmount(final Double pAmount) {
        this.amount = pAmount;
    }

    /**
     * Get the tax applied to the line item.
     *
     * @return The tax.
     */
    public Double getTax() {
        return tax;
    }

    /**
     * Set the tax applied to the line item.
     *
     * @param pTax The tax.
     */
    public void setTax(final Double pTax) {
        this.tax = pTax;
    }

    /**
     * Get the associated invoice.
     *
     * @return The associated invoice.
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * Set the associated invoice.
     *
     * @param pInvoice The associated invoice.
     */
    public void setInvoice(final Invoice pInvoice) {
        this.invoice = pInvoice;
    }

    /**
     * Get the unique identifier for the line item.
     *
     * @return The unique identifier.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Set the unique identifier for the line item.
     *
     * @param pUid The unique identifier.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Get the date and time when the line item was created.
     *
     * @return The creation date and time.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Set the date and time when the line item was created.
     *
     * @param pCreated The creation date and time.
     */
    public void setCreated(final Date pCreated) {
        this.created = pCreated;
    }

    /**
     * Get the date and time when the line item was last updated.
     *
     * @return The last update date and time.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Set the date and time when the line item was last updated.
     *
     * @param pUpdated The last update date and time.
     */
    public void setUpdated(final Date pUpdated) {
        this.updated = pUpdated;
    }

    /**
     * Compares this instance with the specified object and indicates if they
     * are equal.
     * @param other The object to compare this instance with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof InvoiceLineItem)) {
            return false;
        }

        InvoiceLineItem otherInvoiceLineItem = (InvoiceLineItem) other;

        return Objects.equals(this.uid, otherInvoiceLineItem.uid);
    }

    /**
     * Returns the hash code for this instance.
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(this.uid);
    }
}
