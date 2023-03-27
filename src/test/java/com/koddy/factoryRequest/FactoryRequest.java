package com.koddy.factoryRequest;

import com.koddy.constants.HttpMethod;

public class FactoryRequest {
    public static IRequest make (HttpMethod method){
        IRequest request;

        switch (method){
            case POST:
                request = new RequestPOST();
                break;
            case PUT:
                request = new RequestPUT();
                break;
            case DELETE:
                request= new RequestDELETE();
                break;
            default:
                request= new RequestGET();
                break;
        }
        return request;
    }
}
