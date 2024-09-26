package com.heladeria.heladeria_SpringBoot.domain.repository;

import com.heladeria.heladeria_SpringBoot.domain.InvoiceDetailDomain;
import com.heladeria.heladeria_SpringBoot.persistence.entity.InvoiceDetail;

import java.util.List;
import java.util.Optional;

public interface invoiceDetailDomainRepository {
    List<InvoiceDetailDomain> getAll();
    Optional<InvoiceDetailDomain> findById(int id);
    InvoiceDetailDomain save(InvoiceDetailDomain invoiceDetailDomain);
    void deleteById (int id);
}
