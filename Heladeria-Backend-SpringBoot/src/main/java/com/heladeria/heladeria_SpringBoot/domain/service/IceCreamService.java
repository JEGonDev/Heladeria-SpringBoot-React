package com.heladeria.heladeria_SpringBoot.domain.service;

import com.heladeria.heladeria_SpringBoot.domain.IceCreamDomain;
import com.heladeria.heladeria_SpringBoot.domain.repository.IceCreamDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IceCreamService {

    @Autowired
    private IceCreamDomainRepository iceCreamDomainRepository;

    // Obtener todos los helados
    public List<IceCreamDomain> getAll() {
        return iceCreamDomainRepository.getAll();
    }

    // Guardar o actualizar un helado
    public IceCreamDomain save(IceCreamDomain iceCreamDomain) {
        return iceCreamDomainRepository.save(iceCreamDomain);
    }

    // Buscar un helado por ID
    public Optional<IceCreamDomain> getIceCreamById(int id) {
        return iceCreamDomainRepository.findById(id);
    }

    // Eliminar un helado por ID
    public boolean deleteById(int id) {
        return getIceCreamById(id).map(iceCream -> {
            iceCreamDomainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    // Buscar helados por nombre
    public Optional<List<IceCreamDomain>> getIceCreamsByName(String name) {
        return iceCreamDomainRepository.findByName(name);
    }

    // Buscar helados cuyo stock sea menor a un valor dado
    public Optional<List<IceCreamDomain>> getIceCreamsByStockLessThan(Integer stock) {
        return iceCreamDomainRepository.findByStockLessThan(stock);
    }
}
