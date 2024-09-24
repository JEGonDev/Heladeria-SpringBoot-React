package com.heladeria.heladeria_SpringBoot.domain.repository;

import com.heladeria.heladeria_SpringBoot.persistence.entity.InvoiceDetail;

import java.util.List;
import java.util.Optional;

public interface InvoiceDetailRepository {
    List<InvoiceDetail> getAll();
    Optional<InvoiceDetail> findById(int id);
    InvoiceDetail save(InvoiceDetail invoiceDetail);
    void deleteById (int id);
}
