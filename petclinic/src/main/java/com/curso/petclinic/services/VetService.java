package com.curso.petclinic.services;

import com.curso.petclinic.entity.Vet;

import java.util.List;

public interface VetService {

	
	List<Vet> findByLastName(String string);
	 

	
	List<Vet> findByLastNameAndFirstName(String string,String string2);
	 

	
	List<Vet> findByLastNameOrFirstName(String string,String string2);
}
