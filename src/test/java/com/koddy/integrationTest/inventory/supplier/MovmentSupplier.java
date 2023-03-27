package com.koddy.integrationTest.inventory.supplier;

import com.koddy.integrationTest.inventory.dto.InventoryDto;
import com.koddy.integrationTest.inventory.dto.MovmentDto;

import java.util.ArrayList;
import java.util.List;

public class MovmentSupplier {
    public static MovmentDto get(){
        MovmentDto movmentDto = new MovmentDto();
        movmentDto.setFromAreaId(1);
        movmentDto.setToAreaId(2);
        movmentDto.setAccountId(38);
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setId(61);
        inventoryDto.setTransferId(0);
        inventoryDto.setOrderId(69);
        inventoryDto.setOutQuantity("1");
        inventoryDto.setAreaId(8);
        inventoryDto.setExternal(false);
        inventoryDto.setDate("2023-03-19");
        List<InventoryDto> inventoryList = new ArrayList<>();
        inventoryList.add(inventoryDto);
        movmentDto.setInventories(inventoryList);
        return movmentDto;
    }
}
