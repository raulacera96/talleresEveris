package com.curso.petclinic.repositories;

import com.curso.petclinic.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

    Collection<Bill> save(Collection<Bill> bills);

    Bill save(Bill bill);

    void delete(Bill bill);

    void deleteAll();

    List<Bill> findAll();

    Bill findById(int bill_id);

}