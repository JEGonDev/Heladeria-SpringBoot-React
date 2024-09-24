package com.heladeria.heladeria_SpringBoot.persistence.crud;

import com.heladeria.heladeria_SpringBoot.persistence.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {
}
