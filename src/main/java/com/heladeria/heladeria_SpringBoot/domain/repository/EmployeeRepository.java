package com.heladeria.heladeria_SpringBoot.domain.repository;

import com.heladeria.heladeria_SpringBoot.persistence.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> getAll();
    Optional<Employee> findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
    List<Employee> findByName(String name);
    List<Employee> findByPosition(String position);
}
