package com.outseta.model.request;

import com.outseta.constant.BillingTransactionType;
import com.outseta.constant.Sort;
import com.outseta.exception.OutsetaPageBuildException;

import java.util.Map;

/**
 * This class represents a transaction page request.
 */
public final class TransactionPageRequest extends PageRequest {

    /**
     * The billing transaction type.
     */
    private BillingTransactionType billingTransactionType;

    /**
     * This class is used to build an transaction page request.
     */
    public static class Builder extends PageRequest.Builder {

        /**
         * The billing transaction type.
         */
        private BillingTransactionType billingTransactionType;

        /**
         * The default constructor for Builder.
         */
        public Builder() {
            super(new TransactionPageRequest());
        }

        /**
         * Sets the page.
         * @param pPage The page.
         * @return The Builder object so that method chaining can be used.
         */
        @Override
        public Builder page(final Integer pPage) {
            super.page(pPage);
            return this;
        }

        /**
         * Sets the page size.
         * @param pPageSize The page size.
         * @return The Builder object so that method chaining can be used.
         */
        @Override
        public Builder pageSize(final Integer pPageSize) {
            super.pageSize(pPageSize);
            return this;
        }

        /**
         * Sets the custom parameters.
         * @param pCustomParams The custom parameters.
         * @return The Builder object so that method chaining can be used.
         */
        @Override
        public Builder customParams(
                final Map<String, Object> pCustomParams) {
            super.customParams(pCustomParams);
            return this;
        }

        /**
         * Sets the field to order by.
         * @param pOrderBy The field to order by.
         * @return The Builder object so that method chaining can be used.
         */
        @Override
        public Builder orderBy(final String pOrderBy) {
            super.orderBy(pOrderBy);
            return this;
        }

        /**
         * Sets the direction to order by.
         * @param pOrderByDirection The direction to order by.
         * @return The Builder object so that method chaining can be used.
         */
        @Override
        public Builder orderByDirection(
                final Sort pOrderByDirection) {
            super.orderByDirection(pOrderByDirection);
            return this;
        }

        /**
         * Sets the billing transaction type.
         * @param pBillingTransactionType The billing transaction type.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder billingTransactionType(
                final BillingTransactionType pBillingTransactionType) {
            this.billingTransactionType = pBillingTransactionType;
            return this;
        }

        /**
         * This method is used to create a new TransactionPageRequest object.
         * @return A new TransactionPageRequest object.
         */
        public TransactionPageRequest build() throws OutsetaPageBuildException {
            TransactionPageRequest request =
                    (TransactionPageRequest) super.build();
            request.billingTransactionType = this.billingTransactionType;
            return request;
        }
    }

    private TransactionPageRequest() {
        super();
    }

    /**
     * This method is used to create a new builder object.
     * @return A new builder object.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Gets the billing transaction type.
     * @return The billing transaction type.
     */
    public BillingTransactionType getBillingTransactionType() {
        return billingTransactionType;
    }

    /**
     * Sets the billing transaction type.
     * @param pBillingTransactionType The billing transaction type.
     */
    public void setBillingTransactionType(
            final BillingTransactionType pBillingTransactionType) {
        this.billingTransactionType = pBillingTransactionType;
    }

    @Override
    public TransactionPageRequest nextPageRequest()
            throws OutsetaPageBuildException {
        return TransactionPageRequest.builder()
                .page(this.getPageNum() + 1)
                .pageSize(this.getPageSize())
                .billingTransactionType(this.getBillingTransactionType())
                .build();
    }

    @Override
    public Map<String, Object> buildParams() {
        Map<String, Object> params = super.buildParams();

        if (billingTransactionType != null) {
            params.put("BillingTransactionType",
                    billingTransactionType.getValue());
        }
        return params;
    }
}
