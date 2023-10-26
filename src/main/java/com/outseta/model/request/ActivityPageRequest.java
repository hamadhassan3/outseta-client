package com.outseta.model.request;

import com.outseta.constant.ActivityType;
import com.outseta.constant.EntityType;
import com.outseta.constant.Sort;
import com.outseta.exception.OutsetaPageBuildException;

import java.util.Map;

/**
 * This class represents an activity page request.
 */
public final class ActivityPageRequest extends PageRequest {

    /**
     * This class is used to build an activity page request.
     */
    public static class Builder extends PageRequest.Builder {

        /**
         * The entity type.
         */
        private Integer entityType;

        /**
         * The activity type.
         */
        private Integer activityType;

        /**
         * The default constructor for Builder.
         */
        public Builder() {
            super(new ActivityPageRequest());
        }

        /**
         * Sets the entity type.
         * @param pEntityType The entity type.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder entityType(final EntityType pEntityType) {
            this.entityType = pEntityType.getValue();
            return this;
        }

        /**
         * Sets the entity type.
         * @param pEntityType The entity type.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder entityType(final Integer pEntityType) {
            this.entityType = pEntityType;
            return this;
        }

        /**
         * Sets the activity type.
         * @param pActivityType The activity type.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder activityType(final Integer pActivityType) {
            this.activityType = pActivityType;
            return this;
        }

        /**
         * Sets the activity type.
         * @param pActivityType The activity type.
         * @return A new Builder object so that method chaining can be used.
         */
        public Builder activityType(final ActivityType pActivityType) {
            this.activityType = pActivityType.getValue();
            return this;
        }

        /**
         * Sets the page number.
         * @param pPage The page number.
         * @return A new Builder object so that method chaining can be used.
         */
        @Override
        public Builder page(final Integer pPage) {
            super.page(pPage);
            return this;
        }

        /**
         * Sets the page size.
         * @param pPageSize The page size.
         * @return A new Builder object so that method chaining can be used.
         */
        @Override
        public Builder pageSize(final Integer pPageSize) {
            super.pageSize(pPageSize);
            return this;
        }

        /**
         * Sets the custom parameters.
         * @param pCustomParams The custom parameters.
         * @return A new Builder object so that method chaining can be used.
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
         * @return A new Builder object so that method chaining can be used.
         */
        @Override
        public Builder orderBy(final String pOrderBy) {
            super.orderBy(pOrderBy);
            return this;
        }

        /**
         * Sets the direction to order by.
         * @param pOrderByDirection The direction to order by.
         * @return A new Builder object so that method chaining can be used.
         */
        @Override
        public Builder orderByDirection(
                final Sort pOrderByDirection) {
            super.orderByDirection(pOrderByDirection);
            return this;
        }

        /**
         * This method is used to build the activity page request.
         * @return The activity page request.
         * @throws OutsetaPageBuildException If there is an error
         *      building the page request.
         */
        @Override
        public ActivityPageRequest build() throws OutsetaPageBuildException {
            ActivityPageRequest activityPageRequest =
                    (ActivityPageRequest) super.build();

            activityPageRequest.entityType = this.entityType;
            activityPageRequest.activityType = this.activityType;

            return activityPageRequest;
        }
    }

    /**
     * The entity type.
     */
    private Integer entityType;

    /**
     * The activity type.
     */
    private Integer activityType;

    /**
     * This method is used to get the builder.
     * @return The builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    private ActivityPageRequest() {
        super();
    }

    @Override
    public ActivityPageRequest nextPageRequest()
            throws OutsetaPageBuildException {
        return ActivityPageRequest.builder()
                .page(this.getPageNum() + 1)
                .pageSize(this.getPageSize())
                .activityType(this.getActivityType())
                .entityType(this.getEntityType())
                .build();
    }

    /**
     * This method is used to build the parameters for the page request.
     * @return The parameters for the page request.
     */
    @Override
    public Map<String, Object> buildParams() {
        Map<String, Object> params = super.buildParams();

        if (entityType != null) {
            params.put("EntityType", entityType);
        }

        if (activityType != null) {
            params.put("ActivityType", activityType);
        }

        return params;
    }

    /**
     * Returns the entity type.
     * @return The entity type.
     */
    public Integer getEntityType() {
        return entityType;
    }

    /**
     * Sets the entity type.
     * @param pEntityType The entity type.
     */
    public void setEntityType(final Integer pEntityType) {
        this.entityType = pEntityType;
    }

    /**
     * Returns the activity type.
     * @return The activity type.
     */
    public Integer getActivityType() {
        return activityType;
    }

    /**
     * Sets the activity type.
     * @param pActivityType The activity type.
     */
    public void setActivityType(final Integer pActivityType) {
        this.activityType = pActivityType;
    }
}
