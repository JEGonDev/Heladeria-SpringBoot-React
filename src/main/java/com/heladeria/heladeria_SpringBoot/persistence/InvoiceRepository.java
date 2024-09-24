package com.heladeria.heladeria_SpringBoot.persistence;

import com.heladeria.heladeria_SpringBoot.persistence.crud.InvoiceCrudRepository;
import com.heladeria.heladeria_SpringBoot.persistence.entity.Invoice;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InvoiceRepository {
    private InvoiceCrudRepository invoiceCrudRepository;

    //Metodos propios de la clase CrudRepository
    public List<Invoice> getAll(){
        return (List<Invoice>) invoiceCrudRepository.findAll();
    }

    public Invoice save(Invoice invoice){
        return invoiceCrudRepository.save(invoice);
    }

    public Optional<Invoice> findById(int id){
        return invoiceCrudRepository.findById(id);
    }

    public void deleteById(int id){
        invoiceCrudRepository.deleteById(id);
    }

    //Query Methods
    public List<Invoice> findByEmployeeId(Integer employeeId){
        return invoiceCrudRepository.findByEmployeeId(employeeId);
    }

    public List<Invoice> findByDate(String date){
        return invoiceCrudRepository.findByDate(date);
    }

    public List<Invoice> findByTotalGreaterThan(Double total){
        return invoiceCrudRepository.findByTotalGreaterThan(total);
    }
}
