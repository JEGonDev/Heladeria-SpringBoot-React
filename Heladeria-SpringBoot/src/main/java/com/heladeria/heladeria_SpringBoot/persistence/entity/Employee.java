package com.heladeria.heladeria_SpringBoot.persistence.entity;

import jakarta.persistence.*;
// import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Employee")
// @Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeID;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private Double salary;

    // Relation
    @OneToMany(mappedBy = "employee")
    private List<Invoice> invoices;

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
