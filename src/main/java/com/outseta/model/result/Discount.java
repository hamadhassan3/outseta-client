package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.constant.DiscountDuration;
import com.outseta.model.BaseInput;
import com.outseta.model.BaseResult;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * This class is used to represent a discount.
 */
public final class Discount implements BaseInput, BaseResult {

    /**
     * Builder class for constructing an instance of DiscountCoupon.
     */
    public static class Builder {

        /**
         * The DiscountCoupon instance to be built.
         */
        private final Discount discount;

        /**
         * Constructor for Builder class.
         */
        public Builder() {
            discount = new Discount();
        }

        /**
         * Sets the unique identifier of the discount coupon.
         *
         * @param pUniqueIdentifier The unique identifier to set.
         * @return The builder instance.
         */
        public Builder uniqueIdentifier(final String pUniqueIdentifier) {
            discount.uniqueIdentifier = pUniqueIdentifier;
            return this;
        }

        /**
         * Sets the name of the discount coupon.
         *
         * @param pName The name to set.
         * @return The builder instance.
         */
        public Builder name(final String pName) {
            discount.name = pName;
            return this;
        }

        /**
         * Sets whether the discount coupon is active.
         *
         * @param pIsActive True if active, false otherwise.
         * @return The builder instance.
         */
        public Builder active(final Boolean pIsActive) {
            discount.isActive = pIsActive;
            return this;
        }

        /**
         * Sets the amount off for the discount coupon.
         *
         * @param pAmountOff The amount off to set.
         * @return The builder instance.
         */
        public Builder amountOff(final Double pAmountOff) {
            discount.amountOff = pAmountOff;
            return this;
        }

        /**
         * Sets the percentage off for the discount coupon.
         *
         * @param pPercentOff The percentage off to set.
         * @return The builder instance.
         */
        public Builder percentOff(final Integer pPercentOff) {
            discount.percentOff = pPercentOff;
            return this;
        }

        /**
         * Sets the duration of the discount coupon.
         *
         * @param pDuration The duration to set.
         * @return The builder instance.
         */
        public Builder duration(final Integer pDuration) {
            discount.duration = pDuration;
            return this;
        }

        /**
         * Sets the duration of the discount coupon.
         *
         * @param pDuration The duration to set.
         * @return The builder instance.
         */
        public Builder duration(final DiscountDuration pDuration) {
            discount.duration = pDuration.getValue();
            return this;
        }

        /**
         * Sets the duration in months for the discount coupon.
         *
         * @param pDurationInMonths The duration in months to set.
         * @return The builder instance.
         */
        public Builder durationInMonths(final Integer pDurationInMonths) {
            discount.durationInMonths = pDurationInMonths;
            return this;
        }

        /**
         * Sets the maximum redemptions allowed for the discount coupon.
         *
         * @param pMaxRedemptions The maximum redemptions to set.
         * @return The builder instance.
         */
        public Builder maxRedemptions(final Integer pMaxRedemptions) {
            discount.maxRedemptions = pMaxRedemptions;
            return this;
        }

        /**
         * Sets the date by which the discount coupon must be redeemed.
         *
         * @param pRedeemBy The redeem by date to set.
         * @return The builder instance.
         */
        public Builder redeemBy(final Date pRedeemBy) {
            discount.redeemBy = pRedeemBy;
            return this;
        }

        /**
         * Sets the list of plans associated with the discount coupon.
         *
         * @param pDiscountCouponPlans The list of plans to set.
         * @return The builder instance.
         */
        public Builder discountCouponPlans(
                final List<Plan> pDiscountCouponPlans) {
            discount.discountCouponPlans = pDiscountCouponPlans;
            return this;
        }

        /**
         * Sets the uid of the discount coupon.
         *
         * @param pUid The uid to set.
         * @return The builder instance.
         */
        public Builder uid(final String pUid) {
            discount.uid = pUid;
            return this;
        }

        /**
         * Builds an instance of the DiscountCoupon.
         *
         * @return The built DiscountCoupon instance.
         */
        public Discount build() {
            return discount;
        }
    }

    /**
     * The unique identifier of the discount coupon.
     */
    @JsonProperty("UniqueIdentifier")
    private String uniqueIdentifier;

    /**
     * The name of the discount coupon.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Indicates whether the discount coupon is active.
     */
    @JsonProperty("IsActive")
    private Boolean isActive;

    /**
     * The amount off for the discount coupon.
     */
    @JsonProperty("AmountOff")
    private Double amountOff;

    /**
     * The percentage off for the discount coupon.
     */
    @JsonProperty("PercentOff")
    private Integer percentOff;

    /**
     * The duration of the discount coupon.
     */
    @JsonProperty("Duration")
    private Integer duration;

    /**
     * The duration in months for the discount coupon.
     */
    @JsonProperty("DurationInMonths")
    private Integer durationInMonths;

    /**
     * The maximum redemptions allowed for the discount coupon.
     */
    @JsonProperty("MaxRedemptions")
    private Integer maxRedemptions;

    /**
     * The date by which the discount coupon must be redeemed.
     */
    @JsonProperty("RedeemBy")
    @JsonFormat(shape =
            JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date redeemBy;

    /**
     * The list of plans associated with the discount coupon.
     */
    @JsonProperty("DiscountCouponPlans")
    private List<Plan> discountCouponPlans;

    /**
     * The uid of the discount coupon.
     */
    @JsonProperty("Uid")
    private String uid;

    /**
     * Constructor for DiscountCoupon class.
     */
    public Discount() {

    }

    /**
     * Builder class for constructing an instance of DiscountCoupon.
     *
     * @return The builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Gets the unique identifier of the discount coupon.
     *
     * @return The unique identifier.
     */
    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    /**
     * Sets the unique identifier of the discount coupon.
     *
     * @param pUniqueIdentifier The unique identifier to set.
     */
    public void setUniqueIdentifier(final String pUniqueIdentifier) {
        this.uniqueIdentifier = pUniqueIdentifier;
    }

    /**
     * Gets the name of the discount coupon.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the discount coupon.
     *
     * @param pName The name to set.
     */
    public void setName(final String pName) {
        this.name = pName;
    }

    /**
     * Indicates whether the discount coupon is active.
     *
     * @return True if active, false otherwise.
     */
    public Boolean isActive() {
        return isActive;
    }

    /**
     * Sets whether the discount coupon is active.
     *
     * @param pIsActive True if active, false otherwise.
     */
    public void setActive(final Boolean pIsActive) {
        this.isActive = pIsActive;
    }

    /**
     * Gets the amount off for the discount coupon.
     *
     * @return The amount off.
     */
    public Double getAmountOff() {
        return amountOff;
    }

    /**
     * Sets the amount off for the discount coupon.
     *
     * @param pAmountOff The amount off to set.
     */
    public void setAmountOff(final Double pAmountOff) {
        this.amountOff = pAmountOff;
    }

    /**
     * Gets the percentage off for the discount coupon.
     *
     * @return The percentage off.
     */
    public Integer getPercentOff() {
        return percentOff;
    }

    /**
     * Sets the percentage off for the discount coupon.
     *
     * @param pPercentOff The percentage off to set.
     */
    public void setPercentOff(final Integer pPercentOff) {
        this.percentOff = pPercentOff;
    }

    /**
     * Gets the duration of the discount coupon.
     *
     * @return The duration.
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the discount coupon.
     *
     * @param pDuration The duration to set.
     */
    public void setDuration(final Integer pDuration) {
        this.duration = pDuration;
    }

    /**
     * Gets the duration in months for the discount coupon.
     *
     * @return The duration in months.
     */
    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    /**
     * Sets the duration in months for the discount coupon.
     *
     * @param pDurationInMonths The duration in months to set.
     */
    public void setDurationInMonths(final Integer pDurationInMonths) {
        this.durationInMonths = pDurationInMonths;
    }

    /**
     * Gets the maximum redemptions allowed for the discount coupon.
     *
     * @return The maximum redemptions.
     */
    public Integer getMaxRedemptions() {
        return maxRedemptions;
    }

    /**
     * Sets the maximum redemptions allowed for the discount coupon.
     *
     * @param pMaxRedemptions The maximum redemptions to set.
     */
    public void setMaxRedemptions(final Integer pMaxRedemptions) {
        this.maxRedemptions = pMaxRedemptions;
    }

    /**
     * Gets the date by which the discount coupon must be redeemed.
     *
     * @return The redeem by date.
     */
    public Date getRedeemBy() {
        return redeemBy;
    }

    /**
     * Sets the date by which the discount coupon must be redeemed.
     *
     * @param pRedeemBy The redeem by date to set.
     */
    public void setRedeemBy(final Date pRedeemBy) {
        this.redeemBy = pRedeemBy;
    }

    /**
     * Gets the list of plans associated with the discount coupon.
     *
     * @return The list of plans.
     */
    public List<Plan> getDiscountCouponPlans() {
        return discountCouponPlans;
    }

    /**
     * Sets the list of plans associated with the discount coupon.
     *
     * @param pDiscountCouponPlans The list of plans to set.
     */
    public void setDiscountCouponPlans(final List<Plan> pDiscountCouponPlans) {
        this.discountCouponPlans = pDiscountCouponPlans;
    }

    /**
     * Gets the uid of the discount coupon.
     *
     * @return The uid.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the uid of the discount coupon.
     *
     * @param pUid The uid to set.
     */
    public void setUid(final String pUid) {
        this.uid = pUid;
    }

    /**
     * Compares this DiscountCoupon instance with another for equality.
     * @param other The other DiscountCoupon instance to compare with.
     * @return True if equal, false otherwise.
     */
    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Discount)) {
            return false;
        }

        final Discount that = (Discount) other;

        return Objects.equals(uniqueIdentifier, that.uniqueIdentifier)
                && Objects.equals(uid, that.uid);
    }

    /**
     * Returns the hash code for this DiscountCoupon instance.
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(uniqueIdentifier);
    }
}
