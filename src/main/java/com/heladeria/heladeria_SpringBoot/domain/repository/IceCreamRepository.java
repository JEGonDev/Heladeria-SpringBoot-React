package com.heladeria.heladeria_SpringBoot.domain.repository;

import com.heladeria.heladeria_SpringBoot.persistence.entity.IceCream;

import java.util.List;
import java.util.Optional;

public interface IceCreamRepository {
    List<IceCream> getAll();
    IceCream save(IceCream iceCream);
    Optional<IceCream> findById(int id);
    void deleteById(int id);
    List<IceCream> findByName(String name);
    List<IceCream> findByStockLessThan(Integer stock);
}
