package com.heladeria.heladeria_SpringBoot.domain;

import lombok.Data;

@Data
public class InvoiceDetailDomain {
    private Integer id; // Corresponde a invoice_detail_id
    private Integer quantity;
    private Double subtotal;

    // Relations
    private InvoiceDomain invoiceDomain;
    private IceCreamDomain iceCreamDomain;
}
