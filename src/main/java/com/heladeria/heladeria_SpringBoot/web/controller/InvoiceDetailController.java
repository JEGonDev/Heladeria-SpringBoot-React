package com.heladeria.heladeria_SpringBoot.web.controller;

import com.heladeria.heladeria_SpringBoot.domain.InvoiceDetailDomain;
import com.heladeria.heladeria_SpringBoot.domain.service.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoice-details")
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    // Obtener todos los detalles de factura
    @GetMapping("/getAll")
    public List<InvoiceDetailDomain> getAll() {
        return invoiceDetailService.getAll();
    }

    // Obtener detalle de factura por id
    @GetMapping("/getById/{id}")
    public ResponseEntity<InvoiceDetailDomain> getById(@PathVariable("id") int id) {
        return invoiceDetailService.getInvoiceDetailById(id)
                .map(detail -> new ResponseEntity<>(detail, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Guardar un nuevo detalle de factura
    @PostMapping("/save")
    public ResponseEntity<InvoiceDetailDomain> save(@RequestBody InvoiceDetailDomain invoiceDetailDomain) {
        return new ResponseEntity<>(invoiceDetailService.save(invoiceDetailDomain), HttpStatus.CREATED);
    }

    // Eliminar detalle de factura por id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        if (invoiceDetailService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
