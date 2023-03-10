package com.koddy.integrationTest.orders.dto;

public class OrderDto {


    /**
     *
     * TEMPLATE
     * products:
     * [object Object],[object Object]
     * status_id:
     * 1
     * name:
     * demo order 1
     * contract_type_id:
     * 7
     * employee_id:
     * 29
     * modified:
     * ACABADO
     * modified_type_id:
     * 2
     * construction_id:
     * 3
     * order_type_id:
     * 3
     * start_date:
     * 2023-03-01
     * estimated_date:
     * 2023-06-08
     * specie_id:
     * 4
     * venesta:
     * none
     * description:
     * description
     * contract:
     * function Object() { [native code] }
     * file:
     * products[0][id]:
     * 0
     * products[0][density]:
     * 40.00
     * products[0][high]:
     * 2064.00
     * products[0][width]:
     * 834.00
     * products[0][unit_id]:
     * 20
     * products[0][stimated_lumber]:
     * 17.00
     * products[0][stimated_plywood]:
     * 2.00
     * products[0][area1]:
     * 0
     * products[0][area2]:
     * 0
     * products[0][area3]:
     * 0
     * products[0][area4]:
     * 0
     * products[0][area5]:
     * 0
     * products[0][area6]:
     * 0
     * products[0][area7]:
     * 0
     * products[0][dispatched]:
     * 0
     * products[0][description]:
     * door
     * products[0][array_type]:
     * 2
     * products[0][quantity]:
     * 10
     * products[0][id]:
     * 8
     * products[0][product_order_id]:
     * 0
     * products[1][id]:
     * 0
     * products[1][density]:
     * 95.00
     * products[1][high]:
     * 2100.00
     * products[1][width]:
     * 800.00
     * products[1][unit_id]:
     * 20
     * products[1][stimated_lumber]:
     * 12.00
     * products[1][stimated_plywood]:
     * 0.00
     * products[1][area1]:
     * 0
     * products[1][area2]:
     * 0
     * products[1][area3]:
     * 0
     * products[1][area4]:
     * 0
     * products[1][area5]:
     * 0
     * products[1][area6]:
     * 0
     * products[1][area7]:
     * 0
     * products[1][dispatched]:
     * 0
     * products[1][description]:
     * square
     * products[1][array_type]:
     * 3
     * products[1][quantity]:
     * 23
     * products[1][id]:
     * 16
     * products[1][product_order_id]:
     * 0
     */

    private Integer id;
    private Integer statusId;
    private String name;
    private Integer contractTypeId;
    private Integer constructionId;
    private Integer orderTypeId;
    private String startDate;
    private String estimatedDate;
    private Integer speccieId;
    private String venesta;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContractTypeId() {
        return contractTypeId;
    }

    public void setContractTypeId(Integer contractTypeId) {
        this.contractTypeId = contractTypeId;
    }

    public Integer getConstructionId() {
        return constructionId;
    }

    public void setConstructionId(Integer constructionId) {
        this.constructionId = constructionId;
    }

    public Integer getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(Integer orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(String estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    public Integer getSpeccieId() {
        return speccieId;
    }

    public void setSpeccieId(Integer speccieId) {
        this.speccieId = speccieId;
    }

    public String getVenesta() {
        return venesta;
    }

    public void setVenesta(String venesta) {
        this.venesta = venesta;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
