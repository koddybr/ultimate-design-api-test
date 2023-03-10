package com.koddy.integrationTest.inventory.dto;

public class ObservationDto {
    /**
     * TEMPLATE
     * {
     *     "name": "demo1",
     *     "description": "demo 1 description"
     * }
     */
    public Integer id;
    public String name;
    public String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
