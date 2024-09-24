package com.heladeria.heladeria_SpringBoot.persistence.crud;

import com.heladeria.heladeria_SpringBoot.persistence.entity.IceCream;
import org.springframework.data.repository.CrudRepository;

public interface IceCreamCrudRepository extends CrudRepository<IceCream, Integer> {
}
