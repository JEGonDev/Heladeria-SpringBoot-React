package com.heladeria.heladeria_SpringBoot.persistence;

import com.heladeria.heladeria_SpringBoot.persistence.crud.EmployeeCrudRepository;
import com.heladeria.heladeria_SpringBoot.persistence.entity.Employee;

import java.util.List;

public class EmployeeRepository {
    private EmployeeCrudRepository employeeCrudRepository;

    public List<Employee> getAll() {
        return (List<Employee>) employeeCrudRepository.findAll();
    }
}
