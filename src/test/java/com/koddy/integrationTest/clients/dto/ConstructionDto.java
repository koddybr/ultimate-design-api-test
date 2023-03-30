package com.koddy.integrationTest.clients.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConstructionDto {

    /**
     * TEMPLATE
     * {
     *     "name": "demo construction",
     *     "client_id": 3,
     *     "status_id": 1,
     *     "amount": "1000000",
     *     "start_date": "2022-10-04",
     *     "end_date": "2023-08-12",
     *     "address": "address demo",
     *     "description": "a description "
     * }
     */
    private Integer id;
    private String name;
    private Integer statusId;
    private Integer clientId;
    private String amount;
    private String startDate;
    private String endDate;
    private String address;
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

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstructionDto that = (ConstructionDto) o;
        return Objects.equals(name, that.name) && Objects.equals(amount, that.amount) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, description);
    }
}
