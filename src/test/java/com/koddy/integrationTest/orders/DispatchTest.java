package com.koddy.integrationTest.orders;

import com.koddy.constants.HttpMethod;
import com.koddy.factoryRequest.FactoryRequest;
import com.koddy.factoryRequest.RequestInfo;
import com.koddy.integrationTest.orders.dto.DispatchDto;
import com.koddy.integrationTest.orders.dto.OrderDto;
import com.koddy.integrationTest.orders.supplier.DispatchSupplier;
import com.koddy.integrationTest.orders.supplier.OrderSupplier;
import com.koddy.integrationTest.products.dto.ProductDto;
import com.koddy.request.CreateRequest;
import com.koddy.util.JsonUtil;
import com.koddy.util.RequestUtil;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.koddy.util.ApiConfiguration.*;
import static com.koddy.util.ApiConfiguration.ORDER_UPDATE;

public class DispatchTest {
    protected Response response;

    RequestInfo requestInfo = new RequestInfo();

    @Test
    public void shouldVerifyDispatchList() throws Exception {
        CreateRequest data = new CreateRequest();

        // set current URL
        requestInfo.setUrl(DISPATCH_ALL);
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);

        JSONArray jsonArray = new JSONArray(response.body().asString());
        JSONObject firstElement = jsonArray.getJSONObject(0);

        DispatchDto firstRow = DispatchSupplier.getFirstRow();
        // Verify the 'id' field
        int actualId = firstElement.getInt("id");
        Assertions.assertEquals(firstRow.getId(), actualId);

        // Verify the 'construction_id' field
        Integer actualConstructionId = firstElement.getInt("construction_id");
        Assertions.assertEquals(firstRow.getConstructionId(), actualConstructionId);

        // Verify the 'description' field
//        String actualDescription = firstElement.getString("description");
//        Assertions.assertEquals(firstRow.getDescription(), actualDescription);

    }

    @Test
    public void shouldVerifyTheCreateAndUpdateDipatch() throws Exception{
        DispatchDto dispatchDto = DispatchSupplier.get();

        // CREATE
        requestInfo.setUrl(DISPATCH_STORE);
        requestInfo.setBody(JsonUtil.toJson(dispatchDto));

        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);

        DispatchDto resultCreate = new DispatchDto();
        resultCreate.setConstructionId(
                response.jsonPath().getInt("construction_id")
        );
        resultCreate.setDate(
                response.jsonPath().getString("date")
        );
        resultCreate.setDescription(
                response.jsonPath().getString("description")
        );

        Integer id = response.jsonPath().getInt("id");
        Assertions.assertTrue(dispatchDto.equals(resultCreate));

        // GET ITEM
        requestInfo.setUrl(String.format(DISPATCH_GET, id));
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);
        DispatchDto resultGet = new DispatchDto();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        System.out.println(response.body().asString());
        JSONArray jsonArray = new JSONArray(response.body().asString());
        JSONObject firstGet = jsonArray.getJSONObject(0);

        resultGet.setConstructionId(
                firstGet.getInt("construction_id")
        );
        resultGet.setDate(
                firstGet.getString("date")
        );
        resultGet.setDescription(
                firstGet.getString("description")
        );
        Assertions.assertTrue(dispatchDto.equals(resultGet));

        // UPDATE ITEM
        requestInfo.setUrl(DISPATCH_UPDATE);
        dispatchDto.setDescription(RequestUtil.generateDescription());
        dispatchDto.setId(id);
        requestInfo.setBody(JsonUtil.toJson(dispatchDto));
        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);
        DispatchDto resultUpdate = new DispatchDto();
        resultUpdate.setConstructionId(
                response.jsonPath().getInt("construction_id")
        );
        resultUpdate.setDate(
                response.jsonPath().getString("date")
        );
        resultUpdate.setDescription(
                response.jsonPath().getString("description")
        );
        Assertions.assertTrue(dispatchDto.equals(resultUpdate));

    }
}
