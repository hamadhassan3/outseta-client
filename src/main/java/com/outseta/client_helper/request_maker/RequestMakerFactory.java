package com.outseta.client_helper.request_maker;

import com.outseta.constant.RequestMakerType;

public class RequestMakerFactory {

    public static RequestMaker getRequestMaker(RequestMakerType requestMakerType) {

        RequestMaker requestMaker = null;
        switch (requestMakerType) {
            case DEFAULT:
            case HTTP_CLIENT:
                requestMaker = new RequestMakerHttpClient();
                break;
        }

        return requestMaker;
    }
}
