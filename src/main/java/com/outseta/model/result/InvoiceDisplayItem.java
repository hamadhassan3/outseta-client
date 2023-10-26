package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.Objects;

/**
 * This class represents an invoice display item.
 */
public class InvoiceDisplayItem implements BaseResult {

    /**
     * The date of the billing line item.
     */
    @JsonProperty("Date")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date date;

    /**
     * The start date of the billing line item.
     */
    @JsonProperty("StartDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date startDate;

    /**
     * The end date of the billing line item.
     */
    @JsonProperty("EndDate")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date endDate;

    /**
     * The type of the billing line item.
     */
    @JsonProperty("Type")
    private String type;

    /**
     * The description of the billing line item.
     */
    @JsonProperty("Description")
    private String description;

    /**
     * The original description of the billing line item.
     */
    @JsonProperty("OriginalDescription")
    private String originalDescription;

    /**
     * The amount of the billing line item.
     */
    @JsonProperty("Amount")
    private Double amount;

    /**
     * The tax amount of the billing line item.
     */
    @JsonProperty("Tax")
    private Double tax;

    /**
     * The total amount of the billing line item.
     */
    @JsonProperty("Total")
    private Double total;

    /**
     * The quantity of the billing line item.
     */
    @JsonProperty("Quantity")
    private Integer quantity;

    /**
     * The units associated with the billing line item.
     */
    @JsonProperty("Units")
    private String units;

    /**
     * The quantity and units combined.
     */
    @JsonProperty("QuantityAndUnits")
    private String quantityAndUnits;

    /**
     * The line item type.
     */
    @JsonProperty("LineItemType")
    private Integer lineItemType;

    /**
     * The unique identifier of the line item entity.
     */
    @JsonProperty("LineItemEntityUid")
    private String lineItemEntityUid;

    /**
     * Default constructor.
     */
    public InvoiceDisplayItem() {
        // Default constructor
    }

    /**
     * Gets the date of the billing line item.
     *
     * @return The date of the billing line item.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the billing line item.
     *
     * @param pDate The date of the billing line item.
     */
    public void setDate(final Date pDate) {
        this.date = pDate;
    }

    /**
     * Gets the start date of the billing line item.
     *
     * @return The start date of the billing line item.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the billing line item.
     *
     * @param pStartDate The start date of the billing line item.
     */
    public void setStartDate(final Date pStartDate) {
        this.startDate = pStartDate;
    }

    /**
     * Gets the end date of the billing line item.
     *
     * @return The end date of the billing line item.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of the billing line item.
     *
     * @param pEndDate The end date of the billing line item.
     */
    public void setEndDate(final Date pEndDate) {
        this.endDate = pEndDate;
    }

    /**
     * Gets the type of the billing line item.
     *
     * @return The type of the billing line item.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the billing line item.
     *
     * @param pType The type of the billing line item.
     */
    public void setType(final String pType) {
        this.type = pType;
    }

    /**
     * Gets the description of the billing line item.
     *
     * @return The description of the billing line item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the billing line item.
     *
     * @param pDescription The description of the billing line item.
     */
    public void setDescription(final String pDescription) {
        this.description = pDescription;
    }

    /**
     * Gets the original description of the billing line item.
     *
     * @return The original description of the billing line item.
     */
    public String getOriginalDescription() {
        return originalDescription;
    }

    /**
     * Sets the original description of the billing line item.
     *
     * @param pOriginalDescription The original description of the billing
     *                             line item.
     */
    public void setOriginalDescription(final String pOriginalDescription) {
        this.originalDescription = pOriginalDescription;
    }

    /**
     * Gets the amount of the billing line item.
     *
     * @return The amount of the billing line item.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the billing line item.
     *
     * @param pAmount The amount of the billing line item.
     */
    public void setAmount(final Double pAmount) {
        this.amount = pAmount;
    }

    /**
     * Gets the tax amount of the billing line item.
     *
     * @return The tax amount of the billing line item.
     */
    public Double getTax() {
        return tax;
    }

    /**
     * Sets the tax amount of the billing line item.
     *
     * @param pTax The tax amount of the billing line item.
     */
    public void setTax(final Double pTax) {
        this.tax = pTax;
    }

    /**
     * Gets the total amount of the billing line item.
     *
     * @return The total amount of the billing line item.
     */
    public Double getTotal() {
        return total;
    }

    /**
     * Sets the total amount of the billing line item.
     *
     * @param pTotal The total amount of the billing line item.
     */
    public void setTotal(final Double pTotal) {
        this.total = pTotal;
    }

    /**
     * Gets the quantity of the billing line item.
     *
     * @return The quantity of the billing line item.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the billing line item.
     *
     * @param pQuantity The quantity of the billing line item.
     */
    public void setQuantity(final Integer pQuantity) {
        this.quantity = pQuantity;
    }

    /**
     * Gets the units associated with the billing line item.
     *
     * @return The units associated with the billing line item.
     */
    public String getUnits() {
        return units;
    }

    /**
     * Sets the units associated with the billing line item.
     *
     * @param pUnits The units associated with the billing line item.
     */
    public void setUnits(final String pUnits) {
        this.units = pUnits;
    }

    /**
     * Gets the quantity and units combined.
     *
     * @return The quantity and units combined.
     */
    public String getQuantityAndUnits() {
        return quantityAndUnits;
    }

    /**
     * Sets the quantity and units combined.
     *
     * @param pQuantityAndUnits The quantity and units combined.
     */
    public void setQuantityAndUnits(final String pQuantityAndUnits) {
        this.quantityAndUnits = pQuantityAndUnits;
    }

    /**
     * Gets the line item type.
     *
     * @return The line item type.
     */
    public Integer getLineItemType() {
        return lineItemType;
    }

    /**
     * Sets the line item type.
     *
     * @param pLineItemType The line item type.
     */
    public void setLineItemType(final Integer pLineItemType) {
        this.lineItemType = pLineItemType;
    }

    /**
     * Gets the unique identifier of the line item entity.
     *
     * @return The unique identifier of the line item entity.
     */
    public String getLineItemEntityUid() {
        return lineItemEntityUid;
    }

    /**
     * Sets the unique identifier of the line item entity.
     *
     * @param pLineItemEntityUid The unique identifier of the line item entity.
     */
    public void setLineItemEntityUid(final String pLineItemEntityUid) {
        this.lineItemEntityUid = pLineItemEntityUid;
    }

    /**
     * This method is used to compare two Subscription objects.
     *
     * @param other The other Subscription object.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof InvoiceDisplayItem)) {
            return false;
        }

        InvoiceDisplayItem invoiceDisplayItem = (InvoiceDisplayItem) other;

        return Objects.equals(this.date, invoiceDisplayItem.date);
    }

    /**
     * This method is used to get the hash code of the Subscription object.
     *
     * @return The hash code of the Subscription object.
     */
    public int hashCode() {
        return Objects.hash(this.date);
    }
}
