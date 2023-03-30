package com.koddy.factoryRequest;

import com.koddy.factoryRequest.dto.LoginDto;
import com.koddy.request.ApiConfiguration;
import com.koddy.util.Enviroment;
import com.koddy.util.JsonUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestAuth {

    public static String getToken() throws Exception{
//        System.out.println();
        LoginDto loginDto = new LoginDto();
        loginDto.setPassword(Enviroment.getInstance().getPassword());
        loginDto.setUsername(Enviroment.getInstance().getUsername());
        Response response =given()
                .body(JsonUtil.toJson(loginDto))
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .post(ApiConfiguration.LOGIN);
        response.then().log().all();
//        System.out.println(response);
        return "Bearer " + response.then().extract().path("token");
    }

}
