package com.heladeria.heladeria_SpringBoot.persistence.mapper;

import com.heladeria.heladeria_SpringBoot.domain.IceCreamDomain;
import com.heladeria.heladeria_SpringBoot.persistence.entity.IceCream;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IceCreamMapper {
    @Mappings({
            @Mapping(source = "iceCreamID", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock")
    })
    IceCreamDomain toIceCreamDomain(IceCream iceCream);

    @InheritInverseConfiguration
    @Mapping(target = "invoiceDetails", ignore = true)
    IceCream toIceCream(IceCreamDomain iceCreamDomain);
}
