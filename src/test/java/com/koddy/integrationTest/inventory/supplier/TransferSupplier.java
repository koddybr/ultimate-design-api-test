package com.koddy.integrationTest.inventory.supplier;

import com.koddy.integrationTest.inventory.dto.InventoryDto;
import com.koddy.integrationTest.inventory.dto.TransferDto;

import java.util.ArrayList;
import java.util.List;

public class TransferSupplier {

    public static TransferDto get(){
        TransferDto transferDto = new TransferDto();
        transferDto.setFromAreaId(1);
        transferDto.setToAreaId(20);

        List<InventoryDto> inventories = new ArrayList<>();
        InventoryDto inventory = new InventoryDto();
        inventory.setId(58);
        inventory.setDate("2023-03-19");
        inventory.setOutQuantity("1");
        inventories.add(inventory);

        transferDto.setInventories(inventories);
        return transferDto;
    }
}
