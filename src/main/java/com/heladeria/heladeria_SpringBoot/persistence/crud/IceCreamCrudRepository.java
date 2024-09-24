package com.heladeria.heladeria_SpringBoot.persistence.crud;

import com.heladeria.heladeria_SpringBoot.persistence.entity.IceCream;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IceCreamCrudRepository extends CrudRepository<IceCream, Integer> {
    //Query Methods
    // Buscar helados por nombre
    List<IceCream> findByName(String name);

    // Buscar helados con un stock menor a un valor específico
    List<IceCream> findByStockLessThan(Integer stock);
}
