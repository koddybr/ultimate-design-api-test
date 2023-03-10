package com.koddy.integrationTest.inventory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventoryDto {
    /**
     * TEMPLATE
     * {
     *     "code": "DEMO001",
     *     "minimum": "10",
     *     "description": "this is a test item",
     *     "observation": null,
     *     "active": true,
     *     "inventory_type_id": 2,
     *     "family_id": 1,
     *     "unit_id": 3
     * }
     */
    private Integer id;
    private String code;
    private String minimum;
    private String description;
    private String observation;
    private Boolean active;
    private Integer inventoryTypeId;
    private Integer familyId;
    private Integer unitId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getInventoryTypeId() {
        return inventoryTypeId;
    }

    public void setInventoryTypeId(Integer inventoryTypeId) {
        this.inventoryTypeId = inventoryTypeId;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryDto that = (InventoryDto) o;
        return code.equals(that.code) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description);
    }
}
