package com.koddy.integrationTest.products;

import com.koddy.constants.HttpMethod;
import com.koddy.factoryRequest.FactoryRequest;
import com.koddy.factoryRequest.RequestInfo;
import com.koddy.integrationTest.products.dto.ProductDto;
import com.koddy.integrationTest.products.dto.ProductTypeDto;
import com.koddy.integrationTest.products.supplier.ProductSupplier;
import com.koddy.integrationTest.products.supplier.ProductTypeSupplier;
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
import static com.koddy.util.ApiConfiguration.PRODUCT_UPDATE;

public class ProductTypeTest {
    protected Response response;

    RequestInfo requestInfo = new RequestInfo();

    @Test
    public void shouldVerifyProducTypetList() throws Exception {
        CreateRequest data = new CreateRequest();

        // set current URL
        requestInfo.setUrl(PRODUCT_ALL);
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);

        JSONArray jsonArray = new JSONArray(response.body().asString());
        JSONObject firstElement = jsonArray.getJSONObject(0);

        ProductDto firstRow = ProductSupplier.getFirstRow();
        // Verify the 'ProductTypeId' field
        int actualId = firstElement.getInt("product_type_id");
        Assertions.assertEquals(firstRow.getProductTypeId(), actualId);

        // Verify the 'name' field
        String actualName = firstElement.getString("name");
        Assertions.assertEquals(firstRow.getName(), actualName);

        // Verify the 'description' field
        String actualDescription = firstElement.getString("description");
        Assertions.assertEquals(firstRow.getDescription(), actualDescription);

    }

    @Test
    public void shouldVerifyCreateAndUpdate() throws Exception{
        ProductTypeDto productTypeDto = ProductTypeSupplier.get();

        // CREATE
        requestInfo.setUrl(PRODUCT_TYPE_STORE);
        requestInfo.setBody(JsonUtil.toJson(productTypeDto));

        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_CREATED);

        ProductTypeDto resultCreate = new ProductTypeDto();
        resultCreate.setName(
                response.jsonPath().getString("name")
        );
        resultCreate.setDescription(
                response.jsonPath().getString("description")
        );
        Integer id = response.jsonPath().getInt("id");
        Assertions.assertTrue(productTypeDto.equals(resultCreate));

        // GET
        requestInfo.setUrl(String.format(PRODUCT_TYPE_GET, id));
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);
        ProductTypeDto resultGet = new ProductTypeDto();
        resultGet.setName(
                response.jsonPath().getString("name")
        );
        resultGet.setDescription(
                response.jsonPath().getString("description")
        );

        Assertions.assertTrue(productTypeDto.equals(resultGet));

        // UPDATE ITEM
        requestInfo.setUrl(PRODUCT_TYPE_UPDATE);
        productTypeDto.setDescription(RequestUtil.generateDescription());
        productTypeDto.setId(id);
        requestInfo.setBody(JsonUtil.toJson(productTypeDto));
        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);
        ProductTypeDto resultUpdate = new ProductTypeDto();
        resultUpdate.setName(
                response.jsonPath().getString("name")
        );
        resultUpdate.setDescription(
                response.jsonPath().getString("description")
        );
        Assertions.assertTrue(productTypeDto.equals(resultUpdate));

    }
}
