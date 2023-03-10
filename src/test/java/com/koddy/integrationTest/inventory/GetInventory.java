package com.koddy.integrationTest.inventory;

import com.koddy.factoryRequest.FactoryRequest;
import com.koddy.factoryRequest.RequestAuth;
import com.koddy.factoryRequest.RequestInfo;
import com.koddy.integrationTest.inventory.dto.InventoryDto;
import com.koddy.request.CreateRequest;
import com.koddy.util.JsonUtil;
import com.koddy.util.RequestUtil;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static com.koddy.util.ApiConfiguration.*;
import static org.hamcrest.Matchers.equalTo;

public class GetInventory {
    protected Response response;

    RequestInfo requestInfo = new RequestInfo();

    @Test
    public void shouldVerifyInventoryGet() throws Exception {
        CreateRequest data = new CreateRequest();

        requestInfo.setUrl(INVENTORY_ALL);

        response =
                FactoryRequest.make("get")
                        .send(requestInfo);
        response.then()
                .statusCode(200);

        JSONArray jsonArray = new JSONArray(response.body().asString());
        JSONObject firstElement = jsonArray.getJSONObject(0);

// Verify the 'id' field
        int expectedId = 1;
        int actualId = firstElement.getInt("id");
        Assertions.assertEquals(expectedId, actualId);

// Verify the 'code' field
        String expectedCode = "1.01.001";
        String actualCode = firstElement.getString("code");
        Assertions.assertEquals(expectedCode, actualCode);

// Verify the 'description' field
        String expectedDescription = "Puerta Acabada De 40mm * 634mm * 2058mm Moya";
        String actualDescription = firstElement.getString("description");
        Assertions.assertEquals(expectedDescription, actualDescription);

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
    public void shouldVerifyTheCorrectCreationOfAInventory() throws Exception{
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setCode(RequestUtil.generateCode());
        inventoryDto.setMinimum("10");
        inventoryDto.setDescription(RequestUtil.generateDescription());
        inventoryDto.setActive(true);
        inventoryDto.setInventoryTypeId(2);
        inventoryDto.setFamilyId(1);
        inventoryDto.setUnitId(3);

        requestInfo.setUrl(INVENTORY_STORE);
        requestInfo.setBody(JsonUtil.toJson(inventoryDto));

        response =
                FactoryRequest.make("post")
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
                FactoryRequest.make("get")
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
                FactoryRequest.make("post")
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
