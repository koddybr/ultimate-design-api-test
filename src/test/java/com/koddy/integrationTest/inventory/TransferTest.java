package com.koddy.integrationTest.inventory;

import com.koddy.constants.HttpMethod;
import com.koddy.factoryRequest.FactoryRequest;
import com.koddy.factoryRequest.RequestInfo;
import com.koddy.integrationTest.inventory.dto.TransferDto;
import com.koddy.integrationTest.inventory.supplier.TransferSupplier;
import com.koddy.util.ApiConfiguration;
import com.koddy.util.JsonUtil;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

public class TransferTest {

    protected Response response;

    RequestInfo requestInfo = new RequestInfo();
    @Test
    public void shouldVerifyTransfer() throws Exception{
        TransferDto transferDto = TransferSupplier.get();

        requestInfo.setUrl(ApiConfiguration.INVENTORY_TRANSFER);
        requestInfo.setBody(JsonUtil.toJson(transferDto));

        response =
                FactoryRequest
                        .make(HttpMethod.POST)
                        .send(requestInfo);

        response
                .then()
                .statusCode(HttpURLConnection.HTTP_OK);

        String message = response.jsonPath().getString("result");
        Assertions.assertEquals("ok", message);
    }
}
