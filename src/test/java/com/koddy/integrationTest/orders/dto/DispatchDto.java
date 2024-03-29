package com.koddy.integrationTest.orders.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.koddy.integrationTest.products.dto.ProductDto;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DispatchDto {
    /**
     * TEMPLATE
     * {
     *     "products": [
     *         {
     *             "order": "0384-Z",
     *             "modified": "ACABADO",
     *             "id": 72,
     *             "name": "Viga",
     *             "type": "Techo y Rejilla",
     *             "unit": "Pieza",
     *             "pivot": {
     *                 "order_id": 22,
     *                 "product_id": 53,
     *                 "density": "0.00",
     *                 "high": "5000.00",
     *                 "width": "0.00",
     *                 "quantity": "1.00",
     *                 "dispatched": "1",
     *                 "dispatch": 0,
     *                 "description": "1 piece"
     *             }
     *         }
     *     ],
     *     "date": "2023-03-03",
     *     "construction_id": 19,
     *     "[object Object]": [
     *         {
     *             "order": "0384-Z",
     *             "modified": "ACABADO",
     *             "id": 72,
     *             "name": "Viga",
     *             "type": "Techo y Rejilla",
     *             "unit": "Pieza",
     *             "pivot": {
     *                 "order_id": 22,
     *                 "product_id": 53,
     *                 "density": "0.00",
     *                 "high": "5000.00",
     *                 "width": "0.00",
     *                 "quantity": "1.00",
     *                 "dispatched": "1",
     *                 "dispatch": 0,
     *                 "description": "1 piece"
     *             }
     *         }
     *     ],
     *     "description": "all done"
     * }
     */
    private Integer id;
    private Integer constructionId;
    private String description;
    private String date;

    private List<ProductDto> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConstructionId() {
        return constructionId;
    }

    public void setConstructionId(Integer constructionId) {
        this.constructionId = constructionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DispatchDto that = (DispatchDto) o;
        return Objects.equals(constructionId, that.constructionId) && Objects.equals(description, that.description) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constructionId, description, date);
    }
}
