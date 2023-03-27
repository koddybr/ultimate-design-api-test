package com.koddy.integrationTest.inventory;

import com.koddy.constants.HttpMethod;
import com.koddy.factoryRequest.FactoryRequest;
import com.koddy.factoryRequest.RequestInfo;
import com.koddy.integrationTest.inventory.dto.MovmentDto;
import com.koddy.integrationTest.inventory.supplier.MovmentSupplier;
import com.koddy.util.JsonUtil;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.koddy.util.ApiConfiguration.INVENTORY_MOVMENT;

public class MovmentTest {
    protected Response response;

    RequestInfo requestInfo = new RequestInfo();
    @Test
    public void shouldVerifyInventoryMovment() throws Exception{
        MovmentDto movmentDto = MovmentSupplier.get();
        requestInfo.setUrl(INVENTORY_MOVMENT);
        requestInfo.setBody(JsonUtil.toJson(movmentDto));

        response =
                FactoryRequest
                        .make(HttpMethod.POST)
                        .send(requestInfo);
        response
                .then()
                .statusCode(200);

        String message = response.jsonPath().getString("result");
        Assertions.assertEquals("ok", message);
    }
}
