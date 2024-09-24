package com.heladeria.heladeria_SpringBoot.persistence.crud;

import com.heladeria.heladeria_SpringBoot.persistence.entity.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceCrudRepository extends CrudRepository<Invoice, Integer> {
}
