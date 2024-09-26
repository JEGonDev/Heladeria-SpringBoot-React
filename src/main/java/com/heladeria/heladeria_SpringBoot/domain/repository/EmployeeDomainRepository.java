package com.heladeria.heladeria_SpringBoot.domain.repository;

import com.heladeria.heladeria_SpringBoot.domain.EmployeeDomain;

import java.util.List;
import java.util.Optional;

public interface EmployeeDomainRepository {
    List<EmployeeDomain> getAll();
    Optional<EmployeeDomain> findById(int id);
    EmployeeDomain save(EmployeeDomain employeeDomain);
    void deleteById(int id);
    Optional<List<EmployeeDomain>> findByName(String name);
    Optional<List<EmployeeDomain>> findByPosition(String position);
}
