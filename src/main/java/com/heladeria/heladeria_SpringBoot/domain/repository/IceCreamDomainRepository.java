package com.heladeria.heladeria_SpringBoot.domain.repository;

import com.heladeria.heladeria_SpringBoot.domain.IceCreamDomain;
import com.heladeria.heladeria_SpringBoot.persistence.entity.IceCream;

import java.util.List;
import java.util.Optional;

public interface IceCreamDomainRepository {
    List<IceCreamDomain> getAll();
    IceCreamDomain save(IceCreamDomain iceCreamDomain);
    Optional<IceCreamDomain> findById(int id);
    void deleteById(int id);
    List<IceCreamDomain> findByName(String name);
    List<IceCreamDomain> findByStockLessThan(Integer stock);
}
