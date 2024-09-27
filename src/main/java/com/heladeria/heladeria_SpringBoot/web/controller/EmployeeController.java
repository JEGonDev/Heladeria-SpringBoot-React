package com.heladeria.heladeria_SpringBoot.web.controller;

import com.heladeria.heladeria_SpringBoot.domain.EmployeeDomain;
import com.heladeria.heladeria_SpringBoot.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EmployeeDomain> getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id)
                .map(employee -> new ResponseEntity<>(employee, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Guardar un nuevo empleado
    @PostMapping("/save")
    public ResponseEntity<EmployeeDomain> save(@RequestBody EmployeeDomain employeeDomain) {
        return new ResponseEntity<>(employeeService.save(employeeDomain), HttpStatus.CREATED);
    }

    // Eliminar empleado por id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        if (employeeService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener empleados por nombre
    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<EmployeeDomain>> getByName(@PathVariable("name") String name) {
        return employeeService.getEmployeesByName(name)
                .map(employees -> new ResponseEntity<>(employees, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Obtener empleados por posición
    @GetMapping("/getByPosition/{position}")
    public ResponseEntity<List<EmployeeDomain>> getByPosition(@PathVariable("position") String position) {
        return employeeService.getEmployeesByPosition(position)
                .map(employees -> new ResponseEntity<>(employees, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
