package com.heladeria.heladeria_SpringBoot.web.controller;

import com.heladeria.heladeria_SpringBoot.domain.InvoiceDomain;
import com.heladeria.heladeria_SpringBoot.domain.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    // Obtener todas las facturas
    @GetMapping("/getAll")
    public List<InvoiceDomain> getAll() {
        return invoiceService.getAll();
    }

    // Obtener factura por id
    @GetMapping("/getById/{id}")
    public ResponseEntity<InvoiceDomain> getById(@PathVariable("id") int id) {
        return invoiceService.getInvoiceById(id)
                .map(invoice -> new ResponseEntity<>(invoice, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Guardar una nueva factura
    @PostMapping("/save")
    public ResponseEntity<InvoiceDomain> save(@RequestBody InvoiceDomain invoiceDomain) {
        return new ResponseEntity<>(invoiceService.save(invoiceDomain), HttpStatus.CREATED);
    }

    // Eliminar factura por id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        if (invoiceService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener facturas por fecha
    @GetMapping("/getByDate/{date}")
    public ResponseEntity<List<InvoiceDomain>> getByDate(@PathVariable("date") String date) {
        return invoiceService.getInvoicesByDate(date)
                .map(invoices -> new ResponseEntity<>(invoices, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Obtener facturas con un total mayor que un valor
    @GetMapping("/getByTotalGreaterThan/{total}")
    public ResponseEntity<List<InvoiceDomain>> getByTotalGreaterThan(@PathVariable("total") Double total) {
        return invoiceService.getInvoicesByTotalGreaterThan(total)
                .map(invoices -> new ResponseEntity<>(invoices, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
