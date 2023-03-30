package com.koddy.integrationTest.orders;

import com.koddy.constants.HttpMethod;
import com.koddy.factoryRequest.FactoryRequest;
import com.koddy.factoryRequest.RequestInfo;
import com.koddy.integrationTest.inventory.dto.InventoryDto;
import com.koddy.integrationTest.inventory.supplier.InventorySupplier;
import com.koddy.integrationTest.orders.dto.OrderDto;
import com.koddy.integrationTest.orders.supplier.OrderSupplier;
import com.koddy.request.CreateRequest;
import com.koddy.util.JsonUtil;
import com.koddy.util.RequestUtil;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static com.koddy.util.ApiConfiguration.*;
import static com.koddy.util.ApiConfiguration.INVENTORY_STORE;

public class OrderTest {
    protected Response response;

    RequestInfo requestInfo = new RequestInfo();

    @Test
    public void shouldVerifyOrderGet() throws Exception {
        CreateRequest data = new CreateRequest();

        // set current URL
        requestInfo.setUrl(ORDER_ALL);
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);

        JSONArray jsonArray = new JSONArray(response.body().asString());
        JSONObject firstElement = jsonArray.getJSONObject(0);

        OrderDto firstRow = OrderSupplier.getFirstRow();
        // Verify the 'id' field
        int actualId = firstElement.getInt("id");
        Assertions.assertEquals(firstRow.getId(), actualId);

        // Verify the 'name' field
        String actualName = firstElement.getString("name");
        Assertions.assertEquals(firstRow.getName(), actualName);

        // Verify the 'description' field
        String actualStartDate = firstElement.getString("start_date");
        Assertions.assertEquals(firstRow.getStartDate(), actualStartDate);

        // Verify the 'construction.name' field
        String actualConstructionName = firstElement.getJSONObject("construction").getString("name");
        Assertions.assertEquals(firstRow.getConstructionDto().getName(), actualConstructionName);

        // Verify the 'type.name' field
        Integer actualStatus = firstElement.getInt("status_id");
        Assertions.assertEquals(firstRow.getStatusId(), actualStatus);
    }

    @Test
    public void shouldVerifyTheCreateandUpdateInventory() throws Exception{
        OrderDto orderDto = OrderSupplier.get();

        // CREATE
        requestInfo.setUrl(ORDER_STORE);
        requestInfo.setBody(JsonUtil.toJson(orderDto));

        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);

        OrderDto resultCreate = new OrderDto();
        resultCreate.setName(
                response.jsonPath().getString("order.name")
        );
        resultCreate.setDescription(
                response.jsonPath().getString("order.description")
        );
        resultCreate.setStatusId(
                response.jsonPath().getInt("order.status_id")
        );
        resultCreate.setContractTypeId(
                response.jsonPath().getInt("order.contract_type_id")
        );
        resultCreate.setConstructionId(
                response.jsonPath().getInt("order.construction_id")
        );
        resultCreate.setOrderTypeId(
                response.jsonPath().getInt("order.order_type_id")
        );
        Integer id = response.jsonPath().getInt("order.id");
        Assertions.assertTrue(orderDto.equals(resultCreate));

        // GET ITEM
        requestInfo.setUrl(String.format(ORDER_GET, id));
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);
        OrderDto resultGet = new OrderDto();
        resultGet.setName(
                response.jsonPath().getString("name")
        );
        resultGet.setDescription(
                response.jsonPath().getString("description")
        );
        resultGet.setStatusId(
                response.jsonPath().getInt("status_id")
        );
        resultGet.setContractTypeId(
                response.jsonPath().getInt("contract_type_id")
        );
        resultGet.setConstructionId(
                response.jsonPath().getInt("construction_id")
        );
        resultGet.setOrderTypeId(
                response.jsonPath().getInt("order_type_id")
        );
        Assertions.assertTrue(orderDto.equals(resultGet));

        // UPDATE ITEM
        requestInfo.setUrl(ORDER_UPDATE);
        orderDto.setDescription(RequestUtil.generateDescription());
        orderDto.setId(id);
        requestInfo.setBody(JsonUtil.toJson(orderDto));
        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(200);
        OrderDto resultUpdate = new OrderDto();
        resultUpdate.setName(
                response.jsonPath().getString("order.name")
        );
        resultUpdate.setDescription(
                response.jsonPath().getString("order.description")
        );
        resultUpdate.setStatusId(
                response.jsonPath().getInt("order.status_id")
        );
        resultUpdate.setContractTypeId(
                response.jsonPath().getInt("order.contract_type_id")
        );
        resultUpdate.setConstructionId(
                response.jsonPath().getInt("order.construction_id")
        );
        resultUpdate.setOrderTypeId(
                response.jsonPath().getInt("order.order_type_id")
        );
        Assertions.assertTrue(orderDto.equals(resultUpdate));

    }
}
