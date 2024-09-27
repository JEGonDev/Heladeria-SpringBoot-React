package com.heladeria.heladeria_SpringBoot.domain.service;

import com.heladeria.heladeria_SpringBoot.domain.InvoiceDomain;
import com.heladeria.heladeria_SpringBoot.domain.repository.InvoiceDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceDomainRepository invoiceDomainRepository;

    // Obtener todas las facturas
    public List<InvoiceDomain> getAll() {
        return invoiceDomainRepository.getAll();
    }

    // Buscar una factura por ID
    public Optional<InvoiceDomain> getInvoiceById(int id) {
        return invoiceDomainRepository.findById(id);
    }

    // Guardar o actualizar una factura
    public InvoiceDomain save(InvoiceDomain invoiceDomain) {
        return invoiceDomainRepository.save(invoiceDomain);
    }

    // Eliminar una factura por ID
    public boolean deleteById(int id) {
        return getInvoiceById(id).map(invoice -> {
            invoiceDomainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    // Buscar facturas por fecha
    public Optional<List<InvoiceDomain>> getInvoicesByDate(String date) {
        return invoiceDomainRepository.findByDate(date);
    }

    // Buscar facturas por total mayor a un valor específico
    public Optional<List<InvoiceDomain>> getInvoicesByTotalGreaterThan(Double total) {
        return invoiceDomainRepository.findByTotalGreaterThan(total);
    }
}
