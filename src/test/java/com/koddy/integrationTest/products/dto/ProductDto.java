package com.koddy.integrationTest.products.dto;

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
    private String name;
    private Integer unitId;
    private String density;
    private String width;
    private String high;
    private String stimatedLumber;
    private String stimatedPlaywood;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
