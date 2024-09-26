package com.heladeria.heladeria_SpringBoot.persistence.mapper;

import com.heladeria.heladeria_SpringBoot.domain.EmployeeDomain;
import com.heladeria.heladeria_SpringBoot.persistence.entity.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mappings({
            @Mapping(source = "employeeID", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "position", target = "position"),
            @Mapping(source = "salary", target = "salary")
    })
    EmployeeDomain toEmployee(Employee employee);

    @InheritInverseConfiguration
    @Mapping(target = "invoices", ignore = true)
    Employee toEmployeeDomain(EmployeeDomain employeeDomain);
}
