package com.koddy.integrationTest.clients.supplier;

import com.koddy.integrationTest.clients.dto.ConstructionDto;
import com.koddy.util.RequestUtil;

public class ConstructionSupplier {

    public static ConstructionDto get() {
        ConstructionDto constructionDto = new ConstructionDto();
        constructionDto.setName("Demo: "+ RequestUtil.generateCode());
        constructionDto.setClientId(3);
        constructionDto.setAmount("100000.00");
        constructionDto.setStartDate("2022-10-04");
        constructionDto.setEndDate("2023-08-12");
        constructionDto.setAddress("qa address");
        constructionDto.setDescription("Construction demo");
        constructionDto.setStatusId(1);
        return constructionDto;
    }

    public static ConstructionDto getFirstRow() {
        ConstructionDto constructionDto = new ConstructionDto();
        constructionDto.setName("Sin Obra");
        constructionDto.setAmount("0.00");
        constructionDto.setDescription("0");
        return constructionDto;
    }
}
