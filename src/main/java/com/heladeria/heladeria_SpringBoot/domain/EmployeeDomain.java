package com.heladeria.heladeria_SpringBoot.domain;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeDomain {
    private Integer id; // Corresponde a employeeID
    private String name;
    private String position;
    private Double salary;
}
