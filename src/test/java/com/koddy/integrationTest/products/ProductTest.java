package com.koddy.integrationTest.products;

import com.koddy.constants.HttpMethod;
import com.koddy.factoryRequest.FactoryRequest;
import com.koddy.factoryRequest.RequestInfo;
import com.koddy.integrationTest.clients.dto.ClientDto;
import com.koddy.integrationTest.clients.supplier.ClientSupplier;
import com.koddy.integrationTest.products.dto.ProductDto;
import com.koddy.integrationTest.products.supplier.ProductSupplier;
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
import static com.koddy.util.ApiConfiguration.CLIENT_STORE;

public class ProductTest {
    protected Response response;

    RequestInfo requestInfo = new RequestInfo();

    @Test
    public void shouldVerifyProductList() throws Exception {
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
        ProductDto productDto = ProductSupplier.get();

        // CREATE
        requestInfo.setUrl(PRODUCT_STORE);
        requestInfo.setBody(JsonUtil.toJson(productDto));

        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);

        ProductDto resultCreate = new ProductDto();
        resultCreate.setName(
                response.jsonPath().getString("product.name")
        );
        resultCreate.setProductTypeId(
                response.jsonPath().getInt("product.product_type_id")
        );
        resultCreate.setDescription(
                response.jsonPath().getString("product.description")
        );
        Integer id = response.jsonPath().getInt("product.id");
        Assertions.assertTrue(productDto.equals(resultCreate));

        // GET
        requestInfo.setUrl(String.format(PRODUCT_GET, id));
        response =
                FactoryRequest.make(HttpMethod.GET)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);
        ProductDto resultGet = new ProductDto();
        resultGet.setName(
                response.jsonPath().getString("product.name")
        );
        resultGet.setProductTypeId(
                response.jsonPath().getInt("product.product_type_id")
        );
        resultGet.setDescription(
                response.jsonPath().getString("product.description")
        );

        Assertions.assertTrue(productDto.equals(resultGet));

        // UPDATE ITEM
        requestInfo.setUrl(PRODUCT_UPDATE);
        productDto.setDescription(RequestUtil.generateDescription());
        productDto.setId(id);
        requestInfo.setBody(JsonUtil.toJson(productDto));
        response =
                FactoryRequest.make(HttpMethod.POST)
                        .send(requestInfo);
        response.then()
                .statusCode(HttpURLConnection.HTTP_OK);
        ProductDto resultUpdate = new ProductDto();
        resultUpdate.setName(
                response.jsonPath().getString("product.name")
        );
        resultUpdate.setProductTypeId(
                response.jsonPath().getInt("product.product_type_id")
        );
        resultUpdate.setDescription(
                response.jsonPath().getString("product.description")
        );
        Assertions.assertTrue(productDto.equals(resultUpdate));

    }
}
