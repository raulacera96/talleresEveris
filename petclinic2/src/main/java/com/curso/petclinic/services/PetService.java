package com.curso.petclinic.services;

import com.curso.petclinic.entity.Pet;

import java.util.List;

public interface PetService {

	List<Pet> findByBirthDateOrderByBirthDate(int string);

	

}
