package com.heladeria.heladeria_SpringBoot.domain.service;

import com.heladeria.heladeria_SpringBoot.domain.InvoiceDetailDomain;
import com.heladeria.heladeria_SpringBoot.domain.repository.InvoiceDetailDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailService {

    @Autowired
    private InvoiceDetailDomainRepository invoiceDetailDomainRepository;

    // Obtener todos los detalles de factura
    public List<InvoiceDetailDomain> getAll() {
        return invoiceDetailDomainRepository.getAll();
    }

    // Buscar un detalle de factura por ID
    public Optional<InvoiceDetailDomain> getInvoiceDetailById(int id) {
        return invoiceDetailDomainRepository.findById(id);
    }

    // Guardar o actualizar un detalle de factura
    public InvoiceDetailDomain save(InvoiceDetailDomain invoiceDetailDomain) {
        return invoiceDetailDomainRepository.save(invoiceDetailDomain);
    }

    // Eliminar un detalle de factura por ID
    public boolean deleteById(int id) {
        return getInvoiceDetailById(id).map(invoiceDetail -> {
            invoiceDetailDomainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
