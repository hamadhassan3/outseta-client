package com.outseta.client.endpoint_client.crm;

import com.outseta.client.BaseClient;
import com.outseta.exception.OutsetaClientBuildException;

/**
 * This class is used to make calls to the Deal endpoints of the
 * Outseta API.
 * <p>
 *     The Deal endpoints are used to manage deals. The class
 *     provides a builder to make it easier to construct the client.
 * </p>
 */
public final class DealClient extends BaseClient {

    /**
     * The constructor is intentionally made private so that
     * the builder must be used to create a DealClient object.
     * @param pBaseUrl The base url of the Outseta API.
     * @throws OutsetaClientBuildException If the client cannot be built.
     */
    private DealClient(final String pBaseUrl) throws
            OutsetaClientBuildException {
        super(pBaseUrl);
    }
}
