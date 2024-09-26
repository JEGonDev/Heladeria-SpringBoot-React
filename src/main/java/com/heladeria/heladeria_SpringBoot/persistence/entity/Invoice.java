package com.heladeria.heladeria_SpringBoot.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Invoice")
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Integer invoiceID;

    @Column(name = "date")
    private String date;

    @Column(name = "total")
    private Double total;

    // Relation
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> invoiceDetails;
}
