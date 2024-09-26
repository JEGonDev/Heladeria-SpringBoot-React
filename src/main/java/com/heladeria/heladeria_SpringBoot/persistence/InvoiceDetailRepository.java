package com.heladeria.heladeria_SpringBoot.persistence;

import com.heladeria.heladeria_SpringBoot.domain.InvoiceDetailDomain;
import com.heladeria.heladeria_SpringBoot.domain.repository.InvoiceDetailDomainRepository;
import com.heladeria.heladeria_SpringBoot.persistence.crud.InvoiceDetailCrudRepository;
import com.heladeria.heladeria_SpringBoot.persistence.entity.InvoiceDetail;
import com.heladeria.heladeria_SpringBoot.persistence.mapper.InvoiceDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InvoiceDetailRepository implements InvoiceDetailDomainRepository{
    @Autowired
    private InvoiceDetailCrudRepository invoiceDetailCrudRepository;
    @Autowired
    private InvoiceDetailMapper invoiceDetailMapper;

    @Override
    public List<InvoiceDetailDomain> getAll() {
        List<InvoiceDetail> invoiceDetails = (List<InvoiceDetail>) invoiceDetailCrudRepository.findAll();
        return invoiceDetailMapper.toInvoiceDetail(invoiceDetails);
    }

    @Override
    public Optional<InvoiceDetailDomain> findById(int id) {
        return invoiceDetailCrudRepository.findById(id).map(invoiceDetail -> invoiceDetailMapper.toInvoiceDetail(invoiceDetail));
    }

    @Override
    public InvoiceDetailDomain save(InvoiceDetailDomain invoiceDetailDomain) {
        InvoiceDetail invoiceDetail = invoiceDetailMapper.toInvoiceDetailDomain(invoiceDetailDomain);
        return invoiceDetailMapper.toInvoiceDetail(invoiceDetailCrudRepository.save(invoiceDetail));
    }

    @Override
    public void deleteById (int id) {
        invoiceDetailCrudRepository.deleteById(id);
    }
}
