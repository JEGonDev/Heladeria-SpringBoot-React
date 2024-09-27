package com.heladeria.heladeria_SpringBoot.persistence.entity;

import jakarta.persistence.*;
// import lombok.Data;

import java.util.List;

@Entity
@Table(name = "IceCream")
// @Data
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

    public Integer getIceCreamID() {
        return iceCreamID;
    }

    public void setIceCreamID(Integer iceCreamID) {
        this.iceCreamID = iceCreamID;
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

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }
}
