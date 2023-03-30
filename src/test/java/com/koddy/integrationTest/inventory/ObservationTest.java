package com.koddy.integrationTest.inventory;

import com.koddy.constants.HttpMethod;
import com.koddy.factoryRequest.FactoryRequest;
import com.koddy.factoryRequest.RequestInfo;
import com.koddy.integrationTest.inventory.dto.ObservationDto;
import com.koddy.integrationTest.inventory.supplier.ObservationSupplier;
import com.koddy.request.ApiConfiguration;
import com.koddy.util.JsonUtil;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

public class ObservationTest {
    protected Response response;

    RequestInfo requestInfo = new RequestInfo();
    @Test
    public void shouldVerifyObseervationsList() throws Exception{
        requestInfo.setUrl(ApiConfiguration.INVENTORY_OBSERVATION_ALL);
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response
                .then()
                .statusCode(HttpURLConnection.HTTP_OK);
        JSONArray jsonArray = new JSONArray(response.body().asString());
        JSONObject firstElement = jsonArray.getJSONObject(0);

        ObservationDto observationDto = ObservationSupplier.getFirstRow();
        String name = firstElement.getString("name");
        Assertions.assertEquals(observationDto.getName(), name);

        String description = firstElement.getString("description");
        Assertions.assertEquals(observationDto.getDescription(), description);
    }

    @Test
    public void shouldVerifyCreateAndUpdate() throws Exception {
        ObservationDto observationDto = ObservationSupplier.get();

        // CREATE
        requestInfo
                .setUrl(ApiConfiguration.INVENTORY_OBSERVATION_STORE);
        requestInfo
                .setBody(JsonUtil.toJson(observationDto));

        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        ObservationDto observationCreate = new ObservationDto();
        observationCreate.setName(
                response.jsonPath().getString("name")
        );
        observationCreate.setDescription(
                response.jsonPath().getString("description")
        );
        Assertions.assertTrue(observationDto.equals(observationCreate));
//        Integer id = response.jsonPath().getInt("id");

//        // GET
//        requestInfo
//                .setUrl(String.format(ApiConfiguration.INVENTORY_OBSERVATION_GET, id));
//        response =
//                FactoryRequest.make(HttpMethod.GET)
//                        .send(requestInfo);
//        response
//                .then()
//                .statusCode(HttpURLConnection.HTTP_OK);
//        ObservationDto observationGet = new ObservationDto();
//        observationGet.setName(
//                response.jsonPath().getString("name")
//        );
//        observationGet.setDescription(
//                response.jsonPath().getString("description")
//        );
//        Assertions.assertTrue(observationDto.equals(observationGet));
//
//        // UPDATE
//        requestInfo
//                .setUrl(ApiConfiguration.INVENTORY_OBSERVATION_UPDATE);
//        observationDto.setId(id);
//        observationDto.setDescription("Description: "+ RequestUtil.generateCode());
//        requestInfo.setBody(JsonUtil.toJson(observationDto));
//
//        response =
//                FactoryRequest.make(HttpMethod.POST)
//                        .send(requestInfo);
//        response
//                .then()
//                .statusCode(HttpURLConnection.HTTP_OK);
//        ObservationDto observationUpdate = new ObservationDto();
//        observationUpdate.setName(
//                response.jsonPath().getString("name")
//        );
//        observationUpdate.setDescription(
//                response.jsonPath().getString("description")
//        );
//        Assertions.assertTrue(observationDto.equals(observationUpdate));
    }
}
