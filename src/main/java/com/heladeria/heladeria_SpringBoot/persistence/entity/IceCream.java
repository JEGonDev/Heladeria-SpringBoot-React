package com.heladeria.heladeria_SpringBoot.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "IceCream")
@Data
public class IceCream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ice_cream_id")
    private Integer iceCreamID;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock")
    private Integer stock;

    // Relation
    @OneToMany(mappedBy = "iceCream")
    private List<InvoiceDetail> invoiceDetails;
}
