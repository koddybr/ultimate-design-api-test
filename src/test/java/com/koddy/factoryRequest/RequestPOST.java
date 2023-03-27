package com.koddy.factoryRequest;

import com.koddy.constants.HttpHeader;
import com.koddy.util.Enviroment;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class RequestPOST implements IRequest{

    @Override
    public Response send(RequestInfo info) throws Exception{
        String token = RequestAuth.getToken();
        Response response =given()
                .header(HttpHeader.AUTHORIZATION.name, token)
                .contentType(ContentType.JSON)
                .body(info.getBody())
                .log()
                .all()
                .when()
                .post(info.getUrl());
        response.then().log().all();
        return response;
    }
}
