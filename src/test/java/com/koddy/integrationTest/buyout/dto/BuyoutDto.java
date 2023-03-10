package com.koddy.integrationTest.buyout.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BuyoutDto {
    /**
     * TEMPLATE
     * {
     *     "buyout": {
     *         "provider_id": 44,
     *         "date": "2023-03-01",
     *         "description": "compra test",
     *         "amount": 10,
     *         "employee_id": 24,
     *         "paid": "0",
     *         "file": "0"
     *     }
     * }
     */
    private Integer id;
    private Integer providerId;
    private String date;
    private String description;
    private BigDecimal amount;
    private Integer employeeId;
    private String file;
    private String paid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }
}
