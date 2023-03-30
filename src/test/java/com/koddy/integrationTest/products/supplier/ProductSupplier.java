package com.koddy.integrationTest.products.supplier;

import com.koddy.integrationTest.products.dto.ProductDto;
import com.koddy.util.RequestUtil;

public class ProductSupplier {
    public static ProductDto get(){
        ProductDto productDto = new ProductDto();
        productDto.setName("Demo product: "+ RequestUtil.generateCode());
        productDto.setProductTypeId(3);
        productDto.setDensity("12");
        productDto.setWidth("34");
        productDto.setHigh("33");
        productDto.setStimatedLumber("12");
        productDto.setStimatedPlaywood("3");
        productDto.setDescription("QA product");
        return productDto;
    }

    public static ProductDto getFirstRow(){
        ProductDto productDto = new ProductDto();
        productDto.setName("Madera");
        productDto.setProductTypeId(3);
        productDto.setDescription("Madera cepillada 3 caras de varias especies.");
        return productDto;
    }
}
