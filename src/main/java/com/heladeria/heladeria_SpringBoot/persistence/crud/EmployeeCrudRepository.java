package com.heladeria.heladeria_SpringBoot.persistence.crud;

import com.heladeria.heladeria_SpringBoot.persistence.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {
    //Query Methods
    // Buscar empleados por nombre
    List<Employee> findByName(String name);

    // Buscar empleados por cargo
    List<Employee> findByPosition(String position);
}
