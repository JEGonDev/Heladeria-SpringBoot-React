package com.heladeria.heladeria_SpringBoot.persistence;

import com.heladeria.heladeria_SpringBoot.persistence.crud.IceCreamCrudRepository;
import com.heladeria.heladeria_SpringBoot.persistence.entity.IceCream;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IceCreamRepository {
    private IceCreamCrudRepository iceCreamCrudRepository;

    //Metodos propios de la clase CrudRepository
    public List<IceCream> getAll() {
        return (List<IceCream>) iceCreamCrudRepository.findAll();
    }

    public IceCream save(IceCream iceCream){
        return iceCreamCrudRepository.save(iceCream);
    }

    public Optional<IceCream> findById(int id) {
        return iceCreamCrudRepository.findById(id);
    }

    public void deleteById(int id){
        iceCreamCrudRepository.deleteById(id);
    }

    //Query Methods
    public List<IceCream> findByName(String name){
        return iceCreamCrudRepository.findByName(name);
    }

    public List<IceCream> findByStockLessThan(Integer stock){
        return iceCreamCrudRepository.findByStockLessThan(stock);
    }
}
