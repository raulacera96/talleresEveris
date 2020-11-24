package com.curso.petclinic.services.impl;

import com.curso.petclinic.entity.Pet;
import com.curso.petclinic.repositories.PetRepository;
import com.curso.petclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
@Autowired
PetRepository pets;


	@Override
	@Transactional
	public List<Pet> findByBirthDateOrderByBirthDate(int d) {
		// TODO Auto-generated method stub
		return pets.findByBirthDateOrderByBirthDateAsc(d);
	}



}
