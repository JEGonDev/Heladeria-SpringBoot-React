package com.heladeria.heladeria_SpringBoot.persistence.mapper;

import com.heladeria.heladeria_SpringBoot.domain.InvoiceDetailDomain;
import com.heladeria.heladeria_SpringBoot.persistence.entity.InvoiceDetail;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface InvoiceDetailMapper {
    @Mappings({
            @Mapping(source = "invoiceDetailID", target = "id"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "subtotal", target = "subtotal"),
            @Mapping(source = "invoice", target = "invoiceDomain"),
            @Mapping(source = "iceCream", target = "iceCreamDomain"),
    })
    InvoiceDetailDomain toInvoiceDetail(InvoiceDetail invoiceDetail);
    List<InvoiceDetailDomain> toInvoiceDetail(List<InvoiceDetail> invoiceDetails);

    @InheritInverseConfiguration
    InvoiceDetail toInvoiceDetailDomain(InvoiceDetailDomain invoiceDetailDomain);
}
