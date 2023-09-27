package com.outseta.model;

/**
 * This interface is used to represent the data returned from the API.
 * <p>
 *     The result models are used to represent the data returned from the API.
 *     For example, the {@link com.outseta.model.result.AuthToken} class
 *     is used to represent the data returned from the get auth token
 *     endpoint of the
 *     {@link com.outseta.client.endpoint_client.AuthenticationClient} class.
 *     <b>
 *        It is highly recommended to implement the equals and hashcode
 *        methods of all classes that implement this interface. This ensures
 *        that the result objects can be compared easily.
 *     </b>
 * </p>
 */
public interface BaseResult extends DataComponent {
}
