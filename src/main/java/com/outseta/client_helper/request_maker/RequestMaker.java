package com.outseta.client_helper.request_maker;

import com.outseta.exception.OutsetaInvalidURLException;
import com.outseta.exception.api_exception.OutsetaAPIFailedException;
import com.outseta.exception.api_exception.OutsetaAPIBadRequestException;
import com.outseta.exception.api_exception.OutsetaInvalidResponseCodeException;
import com.outseta.exception.api_exception.OutsetaAPIUnknownException;

import java.util.Map;

/**
 * This interface is used to make requests to the Outseta API.
 * <p>
 *     The default implementation of this interface is
 *     {@link com.outseta.client_helper.request_maker.RequestMakerHttpClient}.
 * </p>
 */
public interface RequestMaker {
    /**
     * This method is used to make a GET request to the Outseta API.
     * @param url The url to make the request to.
     * @param parameters The parameters to be added to the request.
     * @param headers The headers to be added to the request.
     * @return The response from the API.
     * @throws OutsetaAPIBadRequestException If the request is bad.
     * @throws OutsetaAPIFailedException If the request fails.
     * @throws OutsetaInvalidResponseCodeException If the response code is
     *      invalid.
     * @throws OutsetaAPIUnknownException If the request fails for an unknown
     *      reason.
     * @throws OutsetaInvalidURLException If the url is invalid.
     */
    String get(String url, Map<String, Object> parameters,
               Map<String, String> headers) throws
                    OutsetaAPIBadRequestException,
                    OutsetaAPIFailedException,
                    OutsetaInvalidResponseCodeException,
                    OutsetaAPIUnknownException,
                    OutsetaInvalidURLException;

    /**
     * This method is used to make a PUT request to the Outseta API.
     * @param url The url to make the request to.
     * @param parameters The parameters to be added to the request.
     * @param payload The payload to be added to the request.
     * @param headers The headers to be added to the request.
     * @return The response from the API.
     * @throws OutsetaAPIBadRequestException If the request is bad.
     * @throws OutsetaAPIFailedException If the request fails.
     * @throws OutsetaInvalidResponseCodeException If the response code is
     *      invalid.
     * @throws OutsetaAPIUnknownException If the request fails for an unknown
     *      reason.
     * @throws OutsetaInvalidURLException If the url is invalid.
     */
    String put(String url, Map<String, Object> parameters, String payload,
               Map<String, String> headers) throws
                    OutsetaAPIBadRequestException,
                    OutsetaAPIFailedException,
                    OutsetaInvalidResponseCodeException,
                    OutsetaAPIUnknownException,
                    OutsetaInvalidURLException;

    /**
     * This method is used to make a POST request to the Outseta API.
     * @param url The url to make the request to.
     * @param parameters The parameters to be added to the request.
     * @param payload The payload to be added to the request.
     * @param headers The headers to be added to the request.
     * @return The response from the API.
     * @throws OutsetaAPIBadRequestException If the request is bad.
     * @throws OutsetaAPIFailedException If the request fails.
     * @throws OutsetaInvalidResponseCodeException If the response code is
     *      invalid.
     * @throws OutsetaAPIUnknownException If the request fails for an unknown
     *      reason.
     * @throws OutsetaInvalidURLException If the url is invalid.
     */
    String post(String url, Map<String, Object> parameters, String payload,
                Map<String, String> headers) throws
                    OutsetaAPIBadRequestException,
                    OutsetaAPIFailedException,
                    OutsetaInvalidResponseCodeException,
                    OutsetaAPIUnknownException,
                    OutsetaInvalidURLException;

    /**
     * This method is used to make a DELETE request to the Outseta API.
     * @param url The url to make the request to.
     * @param parameters The parameters to be added to the request.
     * @param headers The headers to be added to the request.
     * @return The response from the API.
     * @throws OutsetaAPIBadRequestException If the request is bad.
     * @throws OutsetaAPIFailedException If the request fails.
     * @throws OutsetaInvalidResponseCodeException If the response code is
     *      invalid.
     * @throws OutsetaAPIUnknownException If the request fails for an unknown
     *      reason.
     * @throws OutsetaInvalidURLException If the url is invalid.
     */
    String delete(String url, Map<String, Object> parameters,
                  Map<String, String> headers) throws
                    OutsetaAPIBadRequestException,
                    OutsetaAPIFailedException,
                    OutsetaInvalidResponseCodeException,
                    OutsetaAPIUnknownException,
                    OutsetaInvalidURLException;

    /**
     * This method is used to url encode a payload attribute.
     * @param value The value to be encoded.
     * @return The encoded value.
     */
    String urlEncodePayloadAttribute(String value);
}
