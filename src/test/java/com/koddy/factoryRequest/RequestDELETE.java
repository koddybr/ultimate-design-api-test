package com.koddy.factoryRequest;

import com.koddy.util.Enviroment;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class RequestDELETE implements IRequest {
    @Override
    public Response send(RequestInfo info) {
        Response response =given()
                .auth()
                .preemptive()
                .basic(Enviroment.getInstance().getUsername(),
                        Enviroment.getInstance().getPassword())
                .log().all()
                .when()
                .delete(info.getUrl());
        response.then().log().all();
        return response;
    }
}
