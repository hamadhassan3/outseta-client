package com.outseta.model.request;

import com.outseta.constant.Sort;
import com.outseta.exception.OutsetaPageBuildException;
import com.outseta.model.BaseInput;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a page request.
 */
public class PageRequest implements BaseInput {

    /**
     * The maximum page size.
     */
    public static final  Integer MAX_PAGE_SIZE = 25;

    /**
     * This class is used to build a page request.
     */
    public static class Builder {

        /**
         * The PageRequest to be built.
         */
        private final PageRequest request;

        /**
         * The default constructor for Builder.
         */
        public Builder() {
            request = new PageRequest();
        }

        /**
         * The constructor for Builder.
         * @param pageRequest The PageRequest to be built.
         */
        protected Builder(final PageRequest pageRequest) {
            request = pageRequest;
        }

        /**
         * Sets the page number.
         * @param pPage The page number.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder page(final Integer pPage) {
            this.request.pageNum = pPage;
            return this;
        }

        /**
         * Sets the page size.
         * @param pPageSize The page size.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder pageSize(final Integer pPageSize) {
            this.request.pageSize = pPageSize;
            return this;
        }

        /**
         * Sets the custom parameters.
         * @param pCustomParams The custom parameters.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder customParams(
                final Map<String, Object> pCustomParams) {
            this.request.customParams = pCustomParams;
            return this;
        }

        /**
         * Sets the field to order by.
         * @param pOrderBy The field to order by.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder orderBy(final String pOrderBy) {
            this.request.orderBy = pOrderBy;
            return this;
        }

        /**
         * Sets the sort direction.
         * @param pOrderByDirection The sort direction.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder orderByDirection(final Sort pOrderByDirection) {
            this.request.orderByDirection = pOrderByDirection;
            return this;
        }

        /**
         * This method is used to create a new PageRequest object.
         * @return A new PageRequest object.
         * @throws OutsetaPageBuildException Thrown when the page builder
         *      fails to build a page.
         */
        public PageRequest build() throws OutsetaPageBuildException {

            if (this.request.pageNum != null && this.request.pageNum < 0) {
                throw new OutsetaPageBuildException(
                        "Page number must be greater than or equal to 0");
            }
            if (this.request.pageSize != null && (
                    this.request.pageSize <= 0
                            || this.request.pageSize > MAX_PAGE_SIZE)) {
                throw new OutsetaPageBuildException(
                        "Page size must be greater than 0 and "
                                + "less than or equal to " + MAX_PAGE_SIZE);
            }

            return this.request;
        }
    }

    /**
     * The page number (greater than or equal to zero).
     */
    private Integer pageNum;

    /**
     * The page size.
     */
    private Integer pageSize;

    /**
     * The custom parameters.
     */
    private Map<String, Object> customParams;

    /**
     * The field to order by.
     */
    private String orderBy;

    /**
     * The sort direction.
     */
    private Sort orderByDirection;

    /**
     * The default constructor for PageRequest.
     * It is intentionally private to force the use of the builder.
     */
    protected PageRequest() {
        customParams = new HashMap<>();
    }

    /**
     * The constructor for PageRequest.
     * It is intentionally private to force the use of the builder.
     * @param pPage The page number.
     * @param pPageSize The page size.
     * @param pCustomParams The custom parameters.
     */
    private PageRequest(final Integer pPage, final Integer pPageSize,
                        final Map<String, Object> pCustomParams) {
        this.pageNum = pPage;
        this.pageSize = pPageSize;
        this.customParams = pCustomParams;
    }

    /**
     * This method is used to create a new builder object.
     * @return A new builder object.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns the next page.
     * @return The next page.
     * @throws OutsetaPageBuildException Thrown when the page builder
     *     fails to build a page.
     */
    public PageRequest nextPageRequest() throws OutsetaPageBuildException {
        return new PageRequest(pageNum + 1, pageSize, customParams);
    }

    /**
     * This method is used to build the parameters for the page request.
     * @return The parameters for the page request.
     */
    public Map<String, Object> buildParams() {

        HashMap<String, Object> params = new HashMap<>();

        params.putAll(customParams);

        if (pageNum != null) {
            params.put("offset", pageNum.toString());
        }

        if (pageSize != null) {
            params.put("limit", pageSize.toString());
        }

        if (orderBy != null && !orderBy.isBlank()) {

            String orderByWithDir = orderBy;
            if (orderByDirection != null) {
                orderByWithDir += "+" + orderByDirection.
                        toString().toUpperCase();
            } else {
                orderByWithDir += "+ASC";
            }

            params.put("orderBy", orderByWithDir);
        }

        return params;
    }

    /**
     * Returns the page number.
     * @return The page number.
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * Returns the page size.
     * @return The page size.
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets the page number.
     * @param pPage The page number.
     */
    public void setPageNum(final Integer pPage) {
        this.pageNum = pPage;
    }

    /**
     * Sets the page size.
     * @param pPageSize The page size.
     */
    public void setPageSize(final Integer pPageSize) {
        this.pageSize = pPageSize;
    }

    /**
     * Returns the custom parameters.
     * @return The custom parameters.
     */
    public Map<String, Object> getCustomParams() {
        return customParams;
    }

    /**
     * Sets the custom parameters.
     * @param pCustomParams The custom parameters.
     */
    public void setCustomParams(
            final Map<String, Object> pCustomParams) {
        this.customParams = pCustomParams;
    }

    /**
     * Returns the field to order by.
     * @return The field to order by.
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * Sets the field to order by.
     * @param pOrderBy The field to order by.
     */
    public void setOrderBy(final String pOrderBy) {
        this.orderBy = pOrderBy;
    }

    /**
     * Returns the sort direction.
     * @return The sort direction.
     */
    public Sort getOrderByDirection() {
        return orderByDirection;
    }

    /**
     * Sets the sort direction.
     * @param pOrderByDirection The sort direction.
     */
    public void setOrderByDirection(final Sort pOrderByDirection) {
        this.orderByDirection = pOrderByDirection;
    }
}
