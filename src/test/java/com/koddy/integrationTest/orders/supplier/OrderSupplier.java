package com.koddy.integrationTest.orders.supplier;

import com.koddy.integrationTest.clients.dto.ConstructionDto;
import com.koddy.integrationTest.orders.dto.OrderDto;
import com.koddy.integrationTest.products.dto.ProductDto;
import com.koddy.util.RequestUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class OrderSupplier {
    public static OrderDto get(){
        List<ProductDto> products = new ArrayList<>();
        ProductDto productDto = new ProductDto();
        productDto.setId(7);
        productDto.setDensity("40");
        productDto.setHigh("2064");
        productDto.setWidth("834");
        productDto.setUnitId(20);
        productDto.setStimatedPlaywood("2");
        productDto.setStimatedLumber("17");
        productDto.setDescription("Product demo qa");
        productDto.setQuantity(new BigDecimal("3"));
        productDto.setArrayType("type");
        productDto.setProductOrderId(0);
        products.add(productDto);

        OrderDto orderDto = new OrderDto();
        orderDto.setStatusId(1);
        orderDto.setName("order: "+ RequestUtil.generateCode());
        orderDto.setContractTypeId(7);
        orderDto.setEmployeeId(29);
        orderDto.setConstructionId(3);
        orderDto.setModified("ACABADO");
        orderDto.setModifiedTypeId(2);
        orderDto.setOrderTypeId(3);
        orderDto.setStartDate("2023-03-01");
        orderDto.setEstimatedDate("2023-06-08");
        orderDto.setSpeccieId(4);
        orderDto.setVenesta("None");
        orderDto.setDescription("QA description");
        orderDto.setProducts(products);
        orderDto.setAmount(new BigDecimal("0"));

        return orderDto;
    }

    public static OrderDto getFirstRow(){
        ConstructionDto constructionDto = new ConstructionDto();
        constructionDto.setName("Edificio Remodelacion");


        OrderDto orderDto = new OrderDto();
        orderDto.setId(69);
        orderDto.setName("0425-1");
        orderDto.setStartDate("2019-12-12");
        orderDto.setConstructionDto(constructionDto);
        orderDto.setConstructionId(27);
        orderDto.setStatusId(1);
        return orderDto;
    }
}
