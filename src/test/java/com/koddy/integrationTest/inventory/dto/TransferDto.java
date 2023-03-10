package com.koddy.integrationTest.inventory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferDto {
    /**
     * TEMPLATE
     * {
     *     "from_area_id": 1,
     *     "to_area_id": 20,
     *     "inventories": [
     *         {
     *             "id": 58,
     *             "code": "4.03.008",
     *             "minimum": "0.00",
     *          }
     *     ],
     *     "id": 0
     * }
     */
    private Integer fromAreaId;
    private Integer toAreaId;
    private List<InventoryDto> inventories;

    public Integer getFromAreaId() {
        return fromAreaId;
    }

    public void setFromAreaId(Integer fromAreaId) {
        this.fromAreaId = fromAreaId;
    }

    public Integer getToAreaId() {
        return toAreaId;
    }

    public void setToAreaId(Integer toAreaId) {
        this.toAreaId = toAreaId;
    }

    public List<InventoryDto> getInventories() {
        return inventories;
    }

    public void setInventories(List<InventoryDto> inventories) {
        this.inventories = inventories;
    }
}
