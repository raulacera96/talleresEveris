package com.everis.serviciovisitas.services.imp;


import com.everis.serviciovisitas.domains.Visita;
import com.everis.serviciovisitas.repositories.VisitaRepository;
import com.everis.serviciovisitas.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class VisitaServiceImp implements VisitaService {
    @Autowired
    VisitaRepository visitaRepository;

    public Collection<Visita> findAll() { return visitaRepository.findAll(); }

    public List<Visita> save(List<Visita> visitas){
        return visitaRepository.save(visitas);
    }

    public Visita save(Visita visita) {
        return visitaRepository.save(visita);
    }

    public void deleteById(Integer visitaId) { visitaRepository.deleteById(visitaId); }

    @Transactional(readOnly = true)
    public Collection<Visita> getVisitasCliente(int cliente_id) {
        return visitaRepository.findByClienteId(cliente_id);
    }
}
