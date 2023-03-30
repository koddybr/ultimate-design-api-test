package com.koddy.integrationTest.orders.supplier;

import com.koddy.integrationTest.orders.dto.DispatchDto;
import com.koddy.integrationTest.products.dto.PivotDto;
import com.koddy.integrationTest.products.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

public class DispatchSupplier {

    public static DispatchDto get(){
        List<ProductDto> products = new ArrayList<>();
        DispatchDto dispatchDto = new DispatchDto();
        dispatchDto.setDate("2023-03-04");
        dispatchDto.setDescription("QA Dispatch");
        dispatchDto.setConstructionId(2);
        products.add(getProductDispatched());
        dispatchDto.setProducts(products);
        return dispatchDto;
    }

    public static DispatchDto getFirstRow(){
        DispatchDto dispatchDto = new DispatchDto();
        dispatchDto.setId(365);
        dispatchDto.setConstructionId(2);
        dispatchDto.setDescription(null);
        return dispatchDto;
    }

    public static ProductDto getProductDispatched () {
        ProductDto productDto = new ProductDto();
        productDto.setId(23);
        PivotDto pivotDto = new PivotDto();
        pivotDto.setDispatched("1");
        pivotDto.setDescription("Product dispatched QA");
        productDto.setPivot(pivotDto);
        return productDto;
    }
}
