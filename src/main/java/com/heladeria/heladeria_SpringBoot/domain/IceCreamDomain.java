package com.heladeria.heladeria_SpringBoot.domain;

// import lombok.Data;

import java.util.List;

// @Data
public class IceCreamDomain {
    private Integer id; // Corresponde a id
    private String name;
    private Double price;
    private Integer stock;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
