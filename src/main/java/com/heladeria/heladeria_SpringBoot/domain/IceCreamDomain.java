package com.heladeria.heladeria_SpringBoot.domain;

import lombok.Data;

import java.util.List;

@Data
public class IceCreamDomain {
    private Integer id; // Corresponde a id
    private String name;
    private Double price;
    private Integer stock;
}
