package com.heladeria.heladeria_SpringBoot.persistence.mapper;

import com.heladeria.heladeria_SpringBoot.domain.InvoiceDomain;
import com.heladeria.heladeria_SpringBoot.persistence.entity.Invoice;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface InvoiceMapper {
    @Mappings({
            @Mapping(source = "invoiceID", target = "id"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "employee", target = "employeeDomain")
    })
    InvoiceDomain toInvoiceDomain(Invoice invoice);

    @InheritInverseConfiguration
    @Mapping(target = "invoiceDetails" , ignore = true)
    Invoice toInvoice(InvoiceDomain invoiceDomain);
}
