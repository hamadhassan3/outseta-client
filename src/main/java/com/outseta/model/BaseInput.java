package com.outseta.model;

/**
 * This interface is used to represent the data sent to the API.
 * <p>
 *     The input models are used to represent the data sent to the API.
 *     For example,
 *     the {@link com.outseta.model.request.TemporaryPasswordRequest} class
 *     is used to represent the data sent to the set temporary password
 *     endpoint of the
 *     {@link com.outseta.client.endpoint_client.crm.PeopleClient} class.
 *     <b>
 *          It is highly recommended to add a builder class in a class that
 *          implements this interface. This is because the builder pattern
 *          simplifies the creation of input models.
 *     </b>
 * </p>
 */
public interface BaseInput extends DataComponent {
}
