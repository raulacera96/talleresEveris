package com.curso.petclinic.services;

import com.curso.petclinic.entity.Bill;
import com.curso.petclinic.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Collection<Bill> save(Collection<Bill> bills){
        return billRepository.save(bills);
    }

    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    public void deleteBill(Bill b) {
        this.billRepository.delete(b);;
    }

    public void deleteAll() {
        this.billRepository.deleteAll();
    }

    public Collection<Bill> findAll() {
        return billRepository.findAll();
    }

    public Bill findById(int bill_id) {
        return billRepository.findById(bill_id);
    }

}
