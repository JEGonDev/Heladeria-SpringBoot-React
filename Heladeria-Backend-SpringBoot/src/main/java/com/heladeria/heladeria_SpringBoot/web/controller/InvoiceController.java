package com.heladeria.heladeria_SpringBoot.web.controller;

import com.heladeria.heladeria_SpringBoot.domain.InvoiceDomain;
import com.heladeria.heladeria_SpringBoot.domain.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<InvoiceDomain> getById(@PathVariable("id") int id) {
        return invoiceService.getInvoiceById(id);
    }

    // Guardar una nueva factura
    @PostMapping("/save")
    public InvoiceDomain save(@RequestBody InvoiceDomain invoiceDomain) {
        return invoiceService.save(invoiceDomain);
    }

    // Eliminar factura por id
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return invoiceService.deleteById(id);
    }

    // Obtener facturas por fecha
    @GetMapping("/getByDate/{date}")
    public Optional<List<InvoiceDomain>> getByDate(@PathVariable("date") String date) {
        return invoiceService.getInvoicesByDate(date);
    }

    // Obtener facturas con un total mayor que un valor
    @GetMapping("/getByTotalGreaterThan/{total}")
    public Optional<List<InvoiceDomain>> getByTotalGreaterThan(@PathVariable("total") Double total) {
        return invoiceService.getInvoicesByTotalGreaterThan(total);
    }
}
