package com.koddy.integrationTest.products.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    /**
     * TEMPLATE
     * {
     *     "name": "This is a demo product",
     *     "product_type_id": 3,
     *     "unit_id": 3,
     *     "density": "12",
     *     "width": "34",
     *     "high": "33",
     *     "stimated_lumber": "12",
     *     "stimated_plywood": "3",
     *     "description": "demo product"
     * }
     */
    private Integer id;
    private Integer productTypeId;
    private String name;
    private Integer unitId;
    private String density;
    private String width;
    private String high;
    private String stimatedLumber;
    private String stimatedPlaywood;
    private String description;

    private String arrayType;
    private BigDecimal dispatched;
    private Integer productOrderId;
    private BigDecimal quantity;

    private PivotDto pivot;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getStimatedLumber() {
        return stimatedLumber;
    }

    public void setStimatedLumber(String stimatedLumber) {
        this.stimatedLumber = stimatedLumber;
    }

    public String getStimatedPlaywood() {
        return stimatedPlaywood;
    }

    public void setStimatedPlaywood(String stimatedPlaywood) {
        this.stimatedPlaywood = stimatedPlaywood;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArrayType() {
        return arrayType;
    }

    public void setArrayType(String arrayType) {
        this.arrayType = arrayType;
    }

    public BigDecimal getDispatched() {
        return dispatched;
    }

    public void setDispatched(BigDecimal dispatched) {
        this.dispatched = dispatched;
    }

    public Integer getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(Integer productOrderId) {
        this.productOrderId = productOrderId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public PivotDto getPivot() {
        return pivot;
    }

    public void setPivot(PivotDto pivot) {
        this.pivot = pivot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(productTypeId, that.productTypeId) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productTypeId, name, description);
    }
}
