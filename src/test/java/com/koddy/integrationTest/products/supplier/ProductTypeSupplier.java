package com.koddy.integrationTest.products.supplier;

import com.koddy.integrationTest.inventory.dto.ObservationDto;
import com.koddy.integrationTest.products.dto.ProductTypeDto;
import com.koddy.util.RequestUtil;

public class ProductTypeSupplier {
    public static ProductTypeDto get() {
        ProductTypeDto productTypeDto = new ProductTypeDto();
        productTypeDto.setName("ProductType: "+ RequestUtil.generateCode());
        productTypeDto.setDescription("QA description");
        return productTypeDto;
    }

    public static ProductTypeDto getFirstRow() {
        ProductTypeDto productTypeDto = new ProductTypeDto();
        productTypeDto.setName("Finger");
        productTypeDto.setDescription("Madera procesada en planta");
        return productTypeDto;
    }
}
