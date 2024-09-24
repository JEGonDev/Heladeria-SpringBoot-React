package com.heladeria.heladeria_SpringBoot.persistence;

import com.heladeria.heladeria_SpringBoot.persistence.crud.EmployeeCrudRepository;
import com.heladeria.heladeria_SpringBoot.persistence.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {
    private EmployeeCrudRepository employeeCrudRepository;

    //Metodos de la clase CrudRepository
    public List<Employee> getAll() {
        return (List<Employee>) employeeCrudRepository.findAll();
    }

    public Optional<Employee> findById(int id) {
        return employeeCrudRepository.findById(id);
    }

    public Employee save(Employee employee) {
        return employeeCrudRepository.save(employee);
    }

    public void deleteById(int id) {
        employeeCrudRepository.deleteById(id);
    }

    //Query Methods
    public List<Employee> findByName(String name) {
        return employeeCrudRepository.findByName(name);
    }

    public List<Employee> findByPosition(String position) {
        return employeeCrudRepository.findByPosition(position);
    }
}
