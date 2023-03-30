package com.koddy.integrationTest.inventory;

import com.koddy.constants.HttpMethod;
import com.koddy.factoryRequest.FactoryRequest;
import com.koddy.factoryRequest.RequestInfo;
import com.koddy.integrationTest.inventory.dto.InventoryDto;
import com.koddy.integrationTest.inventory.supplier.InventorySupplier;
import com.koddy.request.CreateRequest;
import com.koddy.util.JsonUtil;
import com.koddy.util.RequestUtil;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.net.HttpURLConnection;

import static com.koddy.request.ApiConfiguration.*;

public class InventoryTest {
    protected Response response;

    RequestInfo requestInfo = new RequestInfo();

    @Test
    public void shouldVerifyInventoryGet() throws Exception {
        CreateRequest data = new CreateRequest();

        // set current URL
        requestInfo.setUrl(INVENTORY_ALL);
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);

        JSONArray jsonArray = new JSONArray(response.body().asString());
        JSONObject firstElement = jsonArray.getJSONObject(0);

        InventoryDto firstRow = InventorySupplier.getFirstRow();
        // Verify the 'id' field
        int actualId = firstElement.getInt("id");
        Assertions.assertEquals(firstRow.getId(), actualId);

        // Verify the 'code' field
        String actualCode = firstElement.getString("code");
        Assertions.assertEquals(firstRow.getCode(), actualCode);

        // Verify the 'description' field
        String actualDescription = firstElement.getString("description");
        Assertions.assertEquals(firstRow.getDescription(), actualDescription);

        // Verify the 'family.name' field
        String expectedFamilyName = "Puerta Contraplacada";
        String actualFamilyName = firstElement.getJSONObject("family").getString("name");
        Assertions.assertEquals(expectedFamilyName, actualFamilyName);

        // Verify the 'type.name' field
        String expectedTypeName = "Producto Terminado";
        String actualTypeName = firstElement.getJSONObject("type").getString("name");
        Assertions.assertEquals(expectedTypeName, actualTypeName);
    }

    @Test
    public void shouldVerifyTheCreateandUpdateInventory() throws Exception{
        InventoryDto inventoryDto = InventorySupplier.get();

        // CREATE
        requestInfo.setUrl(INVENTORY_STORE);
        requestInfo.setBody(JsonUtil.toJson(inventoryDto));

        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(200);

        InventoryDto resultCreate = new InventoryDto();
        resultCreate.setCode(
                response.jsonPath().getString("inventory.code")
        );
        resultCreate.setDescription(
                response.jsonPath().getString("inventory.description")
        );
        Integer id = response.jsonPath().getInt("inventory.id");
        Assertions.assertTrue(inventoryDto.equals(resultCreate));

        // GET ITEM
        requestInfo.setUrl(String.format(INVENTORY_GET, id));
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response.then()
                .statusCode(200);
        InventoryDto resultGet = new InventoryDto();
        resultGet.setCode(
                response.jsonPath().getString("inventory.code")
        );
        resultGet.setDescription(
                response.jsonPath().getString("inventory.description")
        );
        Assertions.assertTrue(inventoryDto.equals(resultGet));

        // UPDATE ITEM
        requestInfo.setUrl(INVENTORY_STORE);
        inventoryDto.setCode(RequestUtil.generateDescription());
        inventoryDto.setId(id);
        requestInfo.setBody(JsonUtil.toJson(inventoryDto));
        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(200);
        InventoryDto resultUpdate = new InventoryDto();
        resultUpdate.setCode(
                response.jsonPath().getString("inventory.code")
        );
        resultUpdate.setDescription(
                response.jsonPath().getString("inventory.description")
        );
        Assertions.assertTrue(inventoryDto.equals(resultUpdate));

    }
}
