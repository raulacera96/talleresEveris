package com.everis.serviciovisitas.services;

import com.everis.serviciovisitas.domains.Visita;

import java.util.Collection;
import java.util.List;

public interface VisitaService {
    public Collection<Visita> findAll();

    public List<Visita> save(List<Visita> visitas);

    public Visita save(Visita visita);

    public void deleteById(Integer visitaId);

    public Collection<Visita> getVisitasCliente(int cliente_id);
}
