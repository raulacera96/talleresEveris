package com.curso.petclinic.services.impl;

import com.curso.petclinic.entity.Owner;
import com.curso.petclinic.repositories.OwnerRepository;
import com.curso.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    OwnerRepository owners;


    @Override
    @Transactional
    public Owner findById(int i) {
        // TODO Auto-generated method stub
        return owners.findById(i);
    }



}
