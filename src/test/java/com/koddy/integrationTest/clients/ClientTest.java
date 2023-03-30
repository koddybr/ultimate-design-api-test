package com.koddy.integrationTest.clients;

import com.koddy.constants.HttpMethod;
import com.koddy.factoryRequest.FactoryRequest;
import com.koddy.factoryRequest.RequestInfo;
import com.koddy.integrationTest.clients.dto.ClientDto;
import com.koddy.integrationTest.clients.supplier.ClientSupplier;
import com.koddy.request.CreateRequest;
import com.koddy.util.JsonUtil;
import com.koddy.util.RequestUtil;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static com.koddy.util.ApiConfiguration.*;
import static com.koddy.util.ApiConfiguration.INVENTORY_STORE;

public class ClientTest {

    protected Response response;

    RequestInfo requestInfo = new RequestInfo();

    @Test
    public void shouldVerifyClientList() throws Exception {
        CreateRequest data = new CreateRequest();

        // set current URL
        requestInfo.setUrl(CLIENT_ALL);
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);

        JSONArray jsonArray = new JSONArray(response.body().asString());
        JSONObject firstElement = jsonArray.getJSONObject(0);

        ClientDto firstRow = ClientSupplier.getFirstRow();
        // Verify the 'id' field
        int actualId = firstElement.getInt("id");
        Assertions.assertEquals(firstRow.getId(), actualId);

        // Verify the 'name' field
        String actualName = firstElement.getString("name");
        Assertions.assertEquals(firstRow.getName(), actualName);

        // Verify the 'description' field
        String actualDescription = firstElement.getString("description");
        Assertions.assertEquals(firstRow.getDescription(), actualDescription);

        // Verify the 'nit' field
        String actualNit = firstElement.getString("nit");
        Assertions.assertEquals(firstRow.getNit(), actualNit);

    }

    @Test
    public void shouldVerifyCreateAndUpdate() throws Exception{
        ClientDto clientDto = ClientSupplier.get();

        // CREATE
        requestInfo.setUrl(CLIENT_STORE);
        requestInfo.setBody(JsonUtil.toJson(clientDto));

        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);

        ClientDto resultCreate = new ClientDto();
        resultCreate.setName(
                response.jsonPath().getString("client.name")
        );
        resultCreate.setNit(
                response.jsonPath().getString("client.nit")
        );
        resultCreate.setDescription(
                response.jsonPath().getString("client.description")
        );
        Integer id = response.jsonPath().getInt("client.id");
        Assertions.assertTrue(clientDto.equals(resultCreate));

        // GET
        requestInfo.setUrl(String.format(CLIENT_GET, id));
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);
        ClientDto resultGet = new ClientDto();
        resultCreate.setName(
                response.jsonPath().getString("client.name")
        );
        resultCreate.setNit(
                response.jsonPath().getString("client.nit")
        );
        resultCreate.setDescription(
                response.jsonPath().getString("client.description")
        );

        Assertions.assertTrue(clientDto.equals(resultCreate));

        // UPDATE ITEM
        requestInfo.setUrl(CLIENT_STORE);
        clientDto.setDescription(RequestUtil.generateDescription());
        clientDto.setId(id);
        requestInfo.setBody(JsonUtil.toJson(clientDto));
        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);
        ClientDto resultUpdate = new ClientDto();
        resultUpdate.setName(
                response.jsonPath().getString("client.name")
        );
        resultUpdate.setNit(
                response.jsonPath().getString("client.nit")
        );
        resultUpdate.setDescription(
                response.jsonPath().getString("client.description")
        );
        Assertions.assertTrue(clientDto.equals(resultUpdate));

    }
}
