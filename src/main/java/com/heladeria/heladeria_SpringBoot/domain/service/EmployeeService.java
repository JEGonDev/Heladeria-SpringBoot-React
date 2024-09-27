package com.heladeria.heladeria_SpringBoot.domain.service;

import com.heladeria.heladeria_SpringBoot.domain.EmployeeDomain;
import com.heladeria.heladeria_SpringBoot.domain.repository.EmployeeDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDomainRepository employeeDomainRepository;

    // Obtener todos los empleados
    public List<EmployeeDomain> getAll() {
        return employeeDomainRepository.getAll();
    }

    // Buscar empleado por id
    public Optional<EmployeeDomain> getEmployeeById(int id) {
        return employeeDomainRepository.findById(id);
    }

    // Guardar empleado
    public EmployeeDomain save(EmployeeDomain employeeDomain) {
        return employeeDomainRepository.save(employeeDomain);
    }

    // Eliminar empleado por id
    public boolean deleteById(int id) {
        return getEmployeeById(id).map(employee -> {
            employeeDomainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    // Buscar empleados por nombre
    public Optional<List<EmployeeDomain>> getEmployeesByName(String name) {
        return employeeDomainRepository.findByName(name);
    }

    // Buscar empleados por posición
    public Optional<List<EmployeeDomain>> getEmployeesByPosition(String position) {
        return employeeDomainRepository.findByPosition(position);
    }
}
