package com.heladeria.heladeria_SpringBoot.domain;

// import lombok.Data;

import java.util.List;

// @Data
public class InvoiceDomain {
    private Integer id; // Corresponde a id
    private String date;
    private Double total;

    // Relation
    private EmployeeDomain employeeDomain;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public EmployeeDomain getEmployeeDomain() {
        return employeeDomain;
    }

    public void setEmployeeDomain(EmployeeDomain employeeDomain) {
        this.employeeDomain = employeeDomain;
    }
}
