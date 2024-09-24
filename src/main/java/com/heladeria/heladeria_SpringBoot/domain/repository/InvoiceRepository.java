package com.heladeria.heladeria_SpringBoot.domain.repository;

import com.heladeria.heladeria_SpringBoot.persistence.entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository {
    List<Invoice> getAll();
    Invoice save(Invoice invoice);
    Optional<Invoice> findById(int id);
    void deleteById(int id);
    List<Invoice> findByEmployeeId(Integer employeeId);
    List<Invoice> findByDate(String date);
    List<Invoice> findByTotalGreaterThan(Double total);
}
