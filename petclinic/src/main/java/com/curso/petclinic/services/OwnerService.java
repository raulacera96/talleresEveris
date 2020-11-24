package com.curso.petclinic.services;

import com.curso.petclinic.entity.Owner;
import com.curso.petclinic.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface OwnerService {
	
	public Owner findById(int id);
	
}
