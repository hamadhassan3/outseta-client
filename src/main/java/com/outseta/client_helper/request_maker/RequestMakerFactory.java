package com.outseta.client_helper.request_maker;

import com.outseta.constant.RequestMakerType;
import com.outseta.exception.OutsetaInvalidRequestMakerException;

/**
 * This class is used to get the relevant implementation of the request maker.
 */
public final class RequestMakerFactory {
    private RequestMakerFactory() { }

    /**
     * This method is used to get the relevant implementation of the request
     * maker.
     * @param requestMakerType The type of request maker to get.
     * @return The relevant implementation of the request maker.
     * @throws OutsetaInvalidRequestMakerException Thrown if the request maker
     *      type is invalid.
     */
    public static RequestMaker getRequestMaker(final RequestMakerType
                                                       requestMakerType)
            throws OutsetaInvalidRequestMakerException {

        if (requestMakerType == null) {
            throw new OutsetaInvalidRequestMakerException(
                    "Request maker type cannot be null.");
        }

        RequestMaker requestMaker = null;
        switch (requestMakerType) {
            case DEFAULT:
            case HTTP_CLIENT:
                requestMaker = new RequestMakerHttpClient();
                break;
            default:
                throw new OutsetaInvalidRequestMakerException(
                        "Invalid request maker type.");
        }

        return requestMaker;
    }
}
