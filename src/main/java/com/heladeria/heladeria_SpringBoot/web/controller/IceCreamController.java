package com.heladeria.heladeria_SpringBoot.web.controller;

import com.heladeria.heladeria_SpringBoot.domain.IceCreamDomain;
import com.heladeria.heladeria_SpringBoot.domain.service.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<IceCreamDomain> getById(@PathVariable("id") int id) {
        return iceCreamService.getIceCreamById(id)
                .map(iceCream -> new ResponseEntity<>(iceCream, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Guardar un nuevo helado
    @PostMapping("/save")
    public ResponseEntity<IceCreamDomain> save(@RequestBody IceCreamDomain iceCreamDomain) {
        return new ResponseEntity<>(iceCreamService.save(iceCreamDomain), HttpStatus.CREATED);
    }

    // Eliminar helado por id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        if (iceCreamService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener helados por nombre
    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<IceCreamDomain>> getByName(@PathVariable("name") String name) {
        return iceCreamService.getIceCreamsByName(name)
                .map(iceCreams -> new ResponseEntity<>(iceCreams, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Obtener helados con stock menor que un valor
    @GetMapping("/getByStockLessThan/{stock}")
    public ResponseEntity<List<IceCreamDomain>> getByStockLessThan(@PathVariable("stock") int stock) {
        return iceCreamService.getIceCreamsByStockLessThan(stock)
                .map(iceCreams -> new ResponseEntity<>(iceCreams, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
