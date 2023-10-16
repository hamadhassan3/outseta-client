package com.outseta.model.request;

import com.outseta.constant.AccountStage;
import com.outseta.constant.Sort;
import com.outseta.exception.OutsetaPageBuildException;

import java.util.Map;

/**
 * This class represents an account page request.
 */
public final class AccountPageRequest extends PageRequest {

    /**
     * The account stage.
     */
    private AccountStage accountStage;

    /**
     * This class is used to build an account page request.
     */
    public static class Builder extends PageRequest.Builder {

        /**
         * The account stage.
         */
        private AccountStage accountStage;

        /**
         * The default constructor for Builder.
         */
        public Builder() {
            super(new AccountPageRequest());
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
         * Sets the account stage.
         * @param pAccountStage The account stage.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder accountStage(final AccountStage pAccountStage) {
            this.accountStage = pAccountStage;
            return this;
        }

        /**
         * This method is used to create a new AccountPageRequest object.
         * @return A new AccountPageRequest object.
         */
        public AccountPageRequest build() throws OutsetaPageBuildException {
            AccountPageRequest request = (AccountPageRequest) super.build();
            request.accountStage = this.accountStage;
            return request;
        }
    }

    private AccountPageRequest() {
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
     * Sets the account stage.
     * @param pAccountStage The account stage.
     */
    public void setAccountStage(final AccountStage pAccountStage) {
        this.accountStage = pAccountStage;
    }

    /**
     * Gets the account stage.
     * @return The account stage.
     */
    public AccountStage getAccountStage() {
        return this.accountStage;
    }

    @Override
    public Map<String, Object> buildParams() {
        Map<String, Object> params = super.buildParams();

        params.put("AccountStage", accountStage.getValue());

        return params;
    }
}
