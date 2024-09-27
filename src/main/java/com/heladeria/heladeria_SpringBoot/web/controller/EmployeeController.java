package com.heladeria.heladeria_SpringBoot.web.controller;

import com.heladeria.heladeria_SpringBoot.domain.EmployeeDomain;
import com.heladeria.heladeria_SpringBoot.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Obtener todos los empleados
    @GetMapping("/getAll")
    public List<EmployeeDomain> getAll() {
        return employeeService.getAll();
    }

    // Obtener empleado por id
    @GetMapping("/getById/{id}")
    public Optional<EmployeeDomain> getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    // Guardar un nuevo empleado
    @PostMapping("/save")
    public EmployeeDomain save(@RequestBody EmployeeDomain employeeDomain) {
        return employeeService.save(employeeDomain);
    }

    // Eliminar empleado por id
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return employeeService.deleteById(id);
    }

    // Obtener empleados por nombre
    @GetMapping("/getByName/{name}")
    public Optional<List<EmployeeDomain>> getByName(@PathVariable("name") String name) {
        return employeeService.getEmployeesByName(name);
    }

    // Obtener empleados por posición
    @GetMapping("/getByPosition/{position}")
    public Optional<List<EmployeeDomain>> getByPosition(@PathVariable("position") String position) {
        return employeeService.getEmployeesByPosition(position);
    }
}
