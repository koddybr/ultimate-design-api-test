package com.koddy.integrationTest.inventory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovmentDto {
    /**
     * TEMPLATE
     * {
     *     "from_area_id": 1,
     *     "to_area_id": 2,
     *     "account_id": 38,
     *     "inventories": [
     *         {
     *             "id": 61,
     *             "name": "Multilaminado Cedro 8`6 Mm",
     *             "type": "Material Directo",
     *             "out_quantity": "2",
     *             "out_cost": "20.720000"
     *         }
     *     ]
     * }
     */
    private Integer fromAreaId;
    private Integer toAreaId;
    private Integer accountId;
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

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public List<InventoryDto> getInventories() {
        return inventories;
    }

    public void setInventories(List<InventoryDto> inventories) {
        this.inventories = inventories;
    }
}
