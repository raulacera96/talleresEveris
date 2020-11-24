package com.curso.petclinic.controllers;

import com.curso.petclinic.entity.Bill;
import com.curso.petclinic.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BillController {
    @Autowired
    private BillService billService;

    @RequestMapping(value = "/bills", method = RequestMethod.GET)
    public Collection<Bill> findAll() {
        return this.billService.findAll();
    }

    @RequestMapping(value="/bills/insert", method=RequestMethod.POST)
    public Bill saveBill(@RequestBody Bill b) {
        if(b != null)
            return billService.save(b);
        return null;
    }


    @RequestMapping(value = "/bills/{idBill}", method = RequestMethod.GET)
    public Bill findById(@PathVariable("idBill") Integer id) {
        Bill b = this.billService.findById(id);

        if(b != null)
            return b;
        return null;

    }

    @RequestMapping(value="/bills/{idBill}", method=RequestMethod.DELETE)
    public ResponseEntity<Bill> deleteBill(@PathVariable("idBill") Integer id) {
        Bill fromDB = this.billService.findById(id);
        if(fromDB != null) {
            this.billService.deleteBill(fromDB);
            return ResponseEntity.status(HttpStatus.OK).body(fromDB);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @RequestMapping(value="/bills", method=RequestMethod.DELETE)
    public void deleteAllBills() {
        this.billService.deleteAll();
    }

    @RequestMapping(value="/bills/{idBill}", method=RequestMethod.PUT)
    public Bill updateBill(@PathVariable("idBill") Integer id, @RequestBody Bill b) {
        Bill fromDB = this.billService.findById(id);
        if(fromDB != null) {
            b.setId(fromDB.getId());
            return this.billService.save(b);
        }
        return null;
    }

}
