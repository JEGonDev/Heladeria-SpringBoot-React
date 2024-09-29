package com.heladeria.heladeria_SpringBoot.web.controller;

import com.heladeria.heladeria_SpringBoot.domain.IceCreamDomain;
import com.heladeria.heladeria_SpringBoot.domain.service.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ice-creams")
public class IceCreamController {

    @Autowired
    private IceCreamService iceCreamService;

    // Obtener todos los helados
    @GetMapping("/getAll")
    public List<IceCreamDomain> getAll() {
        return iceCreamService.getAll();
    }

    // Obtener helado por id
    @GetMapping("/getById/{id}")
    public Optional<IceCreamDomain> getById(@PathVariable("id") int id) {
        return iceCreamService.getIceCreamById(id);
    }

    // Guardar un nuevo helado
    @PostMapping("/save")
    public IceCreamDomain save(@RequestBody IceCreamDomain iceCreamDomain) {
        return iceCreamService.save(iceCreamDomain);
    }

    // Eliminar helado por id
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return iceCreamService.deleteById(id);
    }

    // Obtener helados por nombre
    @GetMapping("/getByName/{name}")
    public Optional<List<IceCreamDomain>> getByName(@PathVariable("name") String name) {
        return iceCreamService.getIceCreamsByName(name);
    }

    // Obtener helados con stock menor que un valor
    @GetMapping("/getByStockLessThan/{stock}")
    public Optional<List<IceCreamDomain>> getByStockLessThan(@PathVariable("stock") int stock) {
        return iceCreamService.getIceCreamsByStockLessThan(stock);
    }
}
