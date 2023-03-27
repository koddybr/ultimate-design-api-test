package com.koddy.integrationTest.inventory.supplier;

import com.koddy.integrationTest.inventory.dto.InventoryDto;
import com.koddy.util.RequestUtil;

import java.math.BigDecimal;

public class InventorySupplier {

    public static InventoryDto get(){
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setCode(RequestUtil.generateCode());
        inventoryDto.setMinimum("10");
        inventoryDto.setDescription(RequestUtil.generateDescription());
        inventoryDto.setActive(true);
        inventoryDto.setInventoryTypeId(2);
        inventoryDto.setFamilyId(1);
        inventoryDto.setUnitId(3);
        return inventoryDto;
    }

    public static InventoryDto getFirstRow(){
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setId(1);
        inventoryDto.setCode("1.01.001");
        inventoryDto.setDescription("Puerta Acabada De 40mm * 634mm * 2058mm Moya");
        return inventoryDto;
    }

    public static InventoryDto getPuerta(){
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setId(1);
        inventoryDto.setCode("1.01.001");
        inventoryDto.setDescription("Puerta Acabada De 40mm * 634mm * 2058mm Moya");
        inventoryDto.setQuantity("10");
        inventoryDto.setPrice(new BigDecimal("10"));
        return inventoryDto;
    }
}
