package com.koddy.integrationTest.buyout;

import com.koddy.constants.HttpMethod;
import com.koddy.factoryRequest.FactoryRequest;
import com.koddy.factoryRequest.RequestInfo;
import com.koddy.integrationTest.buyout.dto.BuyoutDto;
import com.koddy.integrationTest.buyout.supplier.BuyoutSupplier;
import com.koddy.integrationTest.inventory.dto.InventoryDto;
import com.koddy.integrationTest.inventory.supplier.InventorySupplier;
import com.koddy.request.ApiConfiguration;
import com.koddy.util.JsonUtil;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyoutTest {
    protected Response response;

    RequestInfo requestInfo = new RequestInfo();

    @Test
    public void shouldVerifyBuyout() throws  Exception{
        BuyoutDto buyoutDto = BuyoutSupplier.get();
        InventoryDto inventoryDto = InventorySupplier.getPuerta();
        List<InventoryDto> inventories = new ArrayList<>();
        inventories.add(inventoryDto);
        Map<String, Object>  buyoutWrapper = new HashMap<>();
        buyoutWrapper.put("buyout", buyoutDto);
        buyoutWrapper.put("inventories", inventories);

        requestInfo.setUrl(ApiConfiguration.BUYOUT);
        requestInfo.setBody(JsonUtil.toJson(buyoutWrapper));

        response =
                FactoryRequest
                        .make(HttpMethod.PUT)
                        .send(requestInfo);

        response
                .then()
                .statusCode(HttpURLConnection.HTTP_OK);

        Integer id = response.jsonPath().getInt("id");
        Assertions.assertNotNull(id);
    }
}
