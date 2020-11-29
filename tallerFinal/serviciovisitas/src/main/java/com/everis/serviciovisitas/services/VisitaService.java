package com.everis.serviciovisitas.services;

import com.everis.serviciovisitas.domains.Visita;

import java.util.Collection;
import java.util.List;

public interface VisitaService {
    public Collection<Visita> findAll();

    public List<Visita> save(List<Visita> visitas);

    public Visita save(Visita visita);

    public void deleteById(Integer visitaId);

    public List<Visita> getVisitasFactura(int factura_id);

    public List<Visita> getVisitasEstado(String estado);
}
