package com.heladeria.heladeria_SpringBoot.domain;

// import lombok.Data;

import java.util.List;

// @Data
public class EmployeeDomain {
    private Integer id; // Corresponde a employeeID
    private String name;
    private String position;
    private Double salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
