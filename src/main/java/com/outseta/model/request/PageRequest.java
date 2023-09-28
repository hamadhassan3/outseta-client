package com.outseta.model.request;

import com.outseta.exception.OutsetaPageBuildException;
import com.outseta.model.BaseInput;

/**
 * This class represents a page request.
 */
public final class PageRequest implements BaseInput {

    /**
     * The maximum page size.
     */
    public static final  int MAX_PAGE_SIZE = 25;

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
         * Returns the page number.
         * @param pPage The page number.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder page(final Integer pPage) {
            this.request.pageNum = pPage;
            return this;
        }

        /**
         * Returns the page size.
         * @param pPageSize The page size.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder pageSize(final Integer pPageSize) {
            this.request.pageSize = pPageSize;
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
     * The default constructor for PageRequest.
     * It is intentionally private to force the use of the builder.
     */
    private PageRequest() {
    }

    /**
     * The constructor for PageRequest.
     * It is intentionally private to force the use of the builder.
     * @param pPage The page number.
     * @param pPageSize The page size.
     */
    private PageRequest(final Integer pPage, final Integer pPageSize) {
        this.pageNum = pPage;
        this.pageSize = pPageSize;
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
     */
    public PageRequest nextPageRequest() {
        return new PageRequest(pageNum + 1, pageSize);
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
}
