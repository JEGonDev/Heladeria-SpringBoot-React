package com.heladeria.heladeria_SpringBoot.persistence.crud;

import com.heladeria.heladeria_SpringBoot.persistence.entity.InvoiceDetail;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceDetailCrudRepository extends CrudRepository<InvoiceDetail, Integer> {
}
