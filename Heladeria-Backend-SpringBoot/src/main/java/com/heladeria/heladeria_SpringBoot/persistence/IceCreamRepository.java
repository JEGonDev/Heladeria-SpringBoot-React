package com.heladeria.heladeria_SpringBoot.persistence;

import com.heladeria.heladeria_SpringBoot.domain.IceCreamDomain;
import com.heladeria.heladeria_SpringBoot.domain.repository.IceCreamDomainRepository;
import com.heladeria.heladeria_SpringBoot.persistence.crud.IceCreamCrudRepository;
import com.heladeria.heladeria_SpringBoot.persistence.entity.IceCream;
import com.heladeria.heladeria_SpringBoot.persistence.mapper.IceCreamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IceCreamRepository implements IceCreamDomainRepository {
    @Autowired
    private IceCreamCrudRepository iceCreamCrudRepository;
    @Autowired
    private IceCreamMapper iceCreamMapper;

    //Metodos propios de la clase CrudRepository
    @Override
    public List<IceCreamDomain> getAll() {
        List<IceCream> iceCreams = (List<IceCream>) iceCreamCrudRepository.findAll();
        return iceCreamMapper.toIceCream(iceCreams);
    }

    @Override
    public IceCreamDomain save(IceCreamDomain iceCreamDomain){
        IceCream iceCream = iceCreamMapper.toIceCreamDomain(iceCreamDomain);
        return iceCreamMapper.toIceCream(iceCreamCrudRepository.save(iceCream));
    }

    @Override
    public Optional<IceCreamDomain> findById(int id) {
        return iceCreamCrudRepository.findById(id).map(iceCream -> iceCreamMapper.toIceCream(iceCream));
    }

    @Override
    public void deleteById(int id){
        iceCreamCrudRepository.deleteById(id);
    }

    //Query Methods
    @Override
    public Optional<List<IceCreamDomain>> findByName(String name){
        List<IceCream> iceCreams = iceCreamCrudRepository.findByName(name);
        return Optional.of(iceCreamMapper.toIceCream(iceCreams));
    }

    @Override
    public Optional<List<IceCreamDomain>> findByStockLessThan(Integer stock){
        List<IceCream> iceCreams = iceCreamCrudRepository.findByStockLessThan(stock);
        return Optional.of(iceCreamMapper.toIceCream(iceCreams));
    }
}
