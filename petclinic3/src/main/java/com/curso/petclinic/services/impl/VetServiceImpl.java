package com.curso.petclinic.services.impl;

import com.curso.petclinic.entity.Vet;
import com.curso.petclinic.repositories.VetRepository;
import com.curso.petclinic.services.VetService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VetServiceImpl implements VetService {



@Autowired
private VetRepository vets;
	@Override
	@Transactional
	public List<Vet> findByLastName(String string) {
		// TODO Auto-generated method stub
		List<Vet> vets1 = vets.findByLastName(string);
		getEspecialidades(vets1);
		return vets1;
	}

	@Override
	@Transactional
	public List<Vet> findByLastNameAndFirstName(String string, String string2) {
		List<Vet> vets1 = vets.findByLastNameAndFirstName(string ,string2);
		getEspecialidades(vets1);
		return vets1;
	}

	@Override
	@Transactional
	public List<Vet> findByLastNameOrFirstName(String string, String string2) {
		List<Vet> vets1 = vets.findByLastNameOrFirstName(string ,string2);
		getEspecialidades(vets1);
		return vets1;
	}

	private void getEspecialidades(List<Vet> vets1) {
		for(Vet v : vets1) {
			v.getSpecialties();
		}
	}
}
