package com.juicyCore.eCatalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {

    public ProductDTO() {
    }

    private Double cost;
    private Integer quantity;
    private String name;
    private Long category;

    public ProductDTO(
                        @JsonProperty("cost") Double cost,
                        @JsonProperty("quantity") Integer quantity,
                        @JsonProperty("name") String name,
                        @JsonProperty("category") Long category

    ) {
        this.cost = cost;
        this.quantity = quantity;
        this.name = name;
        this.category = category;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}
