package com.juicyCore.eCatalog.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Table(name = "PRODUCTS")
public class ProductModel {

    public ProductModel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;
    @Column(name = "PRODUCT_COST")
    private Double cost;
    @Column(name = "PRODUCT_QUANTITY")
    private Integer quantity;
    @Column(name = "PRODUCT_NAME")
    private String name;

   @ManyToOne
   @OnDelete(action = OnDeleteAction.CASCADE)
   @JoinColumn (name = "category_id",referencedColumnName = "CATEGORY_ID")
   private CategoryModel category;

    public ProductModel(Long id,
                        @JsonProperty("cost") Double cost,
                        @JsonProperty("quantity") Integer quantity,
                        @JsonProperty("name") String name,
                        @JsonProperty("category") CategoryModel category

    ) {
        this.id = id;
        this.cost = cost;
        this.quantity = quantity;
        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
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

    public CategoryModel getCategory() {
        return category;
    }
    public void setCategory(CategoryModel category) {
        this.category = category;
    }
}
