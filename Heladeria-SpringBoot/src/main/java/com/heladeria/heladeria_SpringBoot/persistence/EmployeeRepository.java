package com.heladeria.heladeria_SpringBoot.persistence;

import com.heladeria.heladeria_SpringBoot.domain.EmployeeDomain;
import com.heladeria.heladeria_SpringBoot.domain.repository.EmployeeDomainRepository;
import com.heladeria.heladeria_SpringBoot.persistence.crud.EmployeeCrudRepository;
import com.heladeria.heladeria_SpringBoot.persistence.entity.Employee;
import com.heladeria.heladeria_SpringBoot.persistence.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository implements EmployeeDomainRepository {
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    //Metodos de la clase CrudRepository
    @Override
    public List<EmployeeDomain> getAll() {
        List<Employee> employees = (List<Employee>) employeeCrudRepository.findAll();
        return employeeMapper.toEmployee(employees);
    }

    @Override
    public Optional<EmployeeDomain> findById(int id) {
        return employeeCrudRepository.findById(id).map(employee -> employeeMapper.toEmployee(employee));
    }

    @Override
    public EmployeeDomain save(EmployeeDomain employeeDomain) {
        Employee employee = employeeMapper.toEmployeeDomain(employeeDomain);
        return employeeMapper.toEmployee(employeeCrudRepository.save(employee));
    }

    @Override
    public void deleteById(int id) {
        employeeCrudRepository.deleteById(id);
    }

    //Query Methods
    @Override
    public Optional<List<EmployeeDomain>> findByName(String name) {
        List<Employee> employees = employeeCrudRepository.findByName(name);
        return Optional.of(employeeMapper.toEmployee(employees));
    }

    @Override
    public Optional<List<EmployeeDomain>> findByPosition(String position) {
        List<Employee> employees = employeeCrudRepository.findByPosition(position);
        return Optional.of(employeeMapper.toEmployee(employees));
    }
}
