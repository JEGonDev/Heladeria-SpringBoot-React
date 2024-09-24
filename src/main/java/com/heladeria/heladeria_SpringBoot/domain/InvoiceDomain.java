package com.heladeria.heladeria_SpringBoot.domain;

import lombok.Data;

import java.util.List;

@Data
public class InvoiceDomain {
    private Integer id; // Corresponde a id
    private String date;
    private Double total;

    // Relation
    private EmployeeDomain employee;
    private List<InvoiceDetailDomain> invoiceDetails;
}
