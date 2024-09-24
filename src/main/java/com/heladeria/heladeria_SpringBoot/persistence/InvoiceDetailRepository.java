package com.heladeria.heladeria_SpringBoot.persistence;

import com.heladeria.heladeria_SpringBoot.persistence.crud.InvoiceDetailCrudRepository;
import com.heladeria.heladeria_SpringBoot.persistence.entity.InvoiceDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InvoiceDetailRepository {
    public InvoiceDetailCrudRepository invoiceDetailCrudRepository;

    public List<InvoiceDetail> getAll() {
        return (List<InvoiceDetail>) invoiceDetailCrudRepository.findAll();
    }

    public Optional<InvoiceDetail> findById(int id) {
        return invoiceDetailCrudRepository.findById(id);
    }

    public InvoiceDetail save(InvoiceDetail invoiceDetail) {
        return invoiceDetailCrudRepository.save(invoiceDetail);
    }

    public void deleteById (int id) {
        invoiceDetailCrudRepository.deleteById(id);
    }
}
