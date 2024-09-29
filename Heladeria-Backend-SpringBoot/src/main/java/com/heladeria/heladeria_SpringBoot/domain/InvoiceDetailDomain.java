package com.heladeria.heladeria_SpringBoot.domain;

// import lombok.Data;

// @Data
public class InvoiceDetailDomain {
    private Integer id; // Corresponde a invoice_detail_id
    private Integer quantity;
    private Double subtotal;

    // Relations
    private InvoiceDomain invoiceDomain;
    private IceCreamDomain iceCreamDomain;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public InvoiceDomain getInvoiceDomain() {
        return invoiceDomain;
    }

    public void setInvoiceDomain(InvoiceDomain invoiceDomain) {
        this.invoiceDomain = invoiceDomain;
    }

    public IceCreamDomain getIceCreamDomain() {
        return iceCreamDomain;
    }

    public void setIceCreamDomain(IceCreamDomain iceCreamDomain) {
        this.iceCreamDomain = iceCreamDomain;
    }
}
