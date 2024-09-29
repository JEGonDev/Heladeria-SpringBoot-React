package com.heladeria.heladeria_SpringBoot.persistence.crud;

import com.heladeria.heladeria_SpringBoot.persistence.entity.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceCrudRepository extends CrudRepository<Invoice, Integer> {
    //Query methods

    // Buscar facturas por fecha
    List<Invoice> findByDate(String date);

    // Buscar facturas con un total mayor a un valor específico
    List<Invoice> findByTotalGreaterThan(Double total);
}
