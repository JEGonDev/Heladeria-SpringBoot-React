package com.heladeria.heladeria_SpringBoot.persistence.entity;

import jakarta.persistence.*;
// import lombok.Data;

@Entity
@Table(name = "InvoiceDetail")
// @Data
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_detail_id")
    private Integer invoiceDetailID;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "subtotal")
    private Double subtotal;

    //Relations
    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "ice_cream_id", nullable = false)
    private IceCream iceCream;

    public Integer getInvoiceDetailID() {
        return invoiceDetailID;
    }

    public void setInvoiceDetailID(Integer invoiceDetailID) {
        this.invoiceDetailID = invoiceDetailID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }
}
