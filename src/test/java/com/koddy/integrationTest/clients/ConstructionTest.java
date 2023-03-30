package com.koddy.integrationTest.clients;

import com.koddy.constants.HttpMethod;
import com.koddy.factoryRequest.FactoryRequest;
import com.koddy.factoryRequest.RequestInfo;
import com.koddy.integrationTest.clients.dto.ConstructionDto;
import com.koddy.integrationTest.clients.supplier.ConstructionSupplier;
import com.koddy.request.CreateRequest;
import com.koddy.util.JsonUtil;
import com.koddy.util.RequestUtil;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static com.koddy.request.ApiConfiguration.*;

public class ConstructionTest {

    protected Response response;

    RequestInfo requestInfo = new RequestInfo();

    @Test
    public void shouldVerifyClientList() throws Exception {
        CreateRequest data = new CreateRequest();

        // set current URL
        requestInfo.setUrl(CONSTRUCTION_ALL);
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);

        JSONArray jsonArray = new JSONArray(response.body().asString());
        JSONObject firstElement = jsonArray.getJSONObject(0);

        ConstructionDto firstRow = ConstructionSupplier.getFirstRow();

        // Verify the 'name' field
        String actualName = firstElement.getString("name");
        Assertions.assertEquals(firstRow.getName(), actualName);

        // Verify the 'description' field
        String actualDescription = firstElement.getString("description");
        Assertions.assertEquals(firstRow.getDescription(), actualDescription);

        // Verify the 'amount' field
        String actualAmount = firstElement.getString("amount");
        Assertions.assertEquals(firstRow.getAmount(), actualAmount);

    }

    @Test
    public void shouldVerifyCreateAndUpdate() throws Exception{
        ConstructionDto constructionDto = ConstructionSupplier.get();

        // CREATE
        requestInfo.setUrl(CONSTRUCTION_STORE);
        requestInfo.setBody(JsonUtil.toJson(constructionDto));

        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);

        ConstructionDto resultCreate = new ConstructionDto();
        resultCreate.setName(
                response.jsonPath().getString("construction.name")
        );
        resultCreate.setAmount(
                response.jsonPath().getString("construction.amount")
        );
        resultCreate.setDescription(
                response.jsonPath().getString("construction.description")
        );
        Integer id = response.jsonPath().getInt("construction.id");
        Assertions.assertTrue(constructionDto.equals(resultCreate));

        // GET
        requestInfo.setUrl(String.format(CONSTRUCTION_GET, id));
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);
        ConstructionDto resultGet = new ConstructionDto();
        resultGet.setName(
                response.jsonPath().getString("construction.name")
        );
        resultGet.setAmount(
                response.jsonPath().getString("construction.amount")
        );
        resultGet.setDescription(
                response.jsonPath().getString("construction.description")
        );

        Assertions.assertTrue(constructionDto.equals(resultGet));

        // UPDATE ITEM
        requestInfo.setUrl(CONSTRUCTION_UPDATE);
        constructionDto.setDescription(RequestUtil.generateDescription());
        constructionDto.setId(id);
        requestInfo.setBody(JsonUtil.toJson(constructionDto));
        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);
        ConstructionDto resultUpdate = new ConstructionDto();
        resultUpdate.setName(
                response.jsonPath().getString("construction.name")
        );
        resultUpdate.setAmount(
                response.jsonPath().getString("construction.amount")
        );
        resultUpdate.setDescription(
                response.jsonPath().getString("construction.description")
        );
        Assertions.assertTrue(constructionDto.equals(resultUpdate));

    }
}
