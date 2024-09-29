package com.heladeria.heladeria_SpringBoot.persistence;

import com.heladeria.heladeria_SpringBoot.domain.InvoiceDomain;
import com.heladeria.heladeria_SpringBoot.domain.repository.InvoiceDomainRepository;
import com.heladeria.heladeria_SpringBoot.persistence.crud.InvoiceCrudRepository;
import com.heladeria.heladeria_SpringBoot.persistence.entity.Invoice;
import com.heladeria.heladeria_SpringBoot.persistence.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InvoiceRepository implements InvoiceDomainRepository {
    @Autowired
    private InvoiceCrudRepository invoiceCrudRepository;
    @Autowired
    private InvoiceMapper invoiceMapper;

    //Metodos propios de la clase CrudRepository
    @Override
    public List<InvoiceDomain> getAll(){
        List<Invoice> invoices = (List<Invoice>) invoiceCrudRepository.findAll();
        return invoiceMapper.toInvoice(invoices);
    }

    @Override
    public InvoiceDomain save(InvoiceDomain invoiceDomain){
        Invoice invoice = invoiceMapper.toInvoiceDomain(invoiceDomain);
        return invoiceMapper.toInvoice(invoiceCrudRepository.save(invoice));
    }

    @Override
    public Optional<InvoiceDomain> findById(int id){
        return invoiceCrudRepository.findById(id).map(invoice -> invoiceMapper.toInvoice(invoice));
    }

    @Override
    public void deleteById(int id){
        invoiceCrudRepository.deleteById(id);
    }

    //Query Methods
    @Override
    public Optional<List<InvoiceDomain>> findByDate(String date){
        List<Invoice> invoices = invoiceCrudRepository.findByDate(date);
        return Optional.of(invoiceMapper.toInvoice(invoices));
    }

    @Override
    public Optional<List<InvoiceDomain>> findByTotalGreaterThan(Double total){
        List<Invoice> invoices = invoiceCrudRepository.findByTotalGreaterThan(total);
        return Optional.of(invoiceMapper.toInvoice(invoices));
    }
}
