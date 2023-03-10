package com.koddy.factoryRequest;

import com.koddy.util.Enviroment;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class RequestGET implements IRequest{
    @Override
    public Response send(RequestInfo info) throws Exception{
        String token = RequestAuth.getToken();
        Response response =given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(info.getUrl());
        response.then().log().all();
        return response;
    }
}
