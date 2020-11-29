package com.everis.serviciovisitas.repositories;

import com.everis.serviciovisitas.domains.Visita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface VisitaRepository extends JpaRepository<Visita, Integer> {
    List<Visita> findAll();

    List<Visita> save(List<Visita> visitas);

    Visita save(Visita visita);

    void deleteById(Integer visitaId);

    List<Visita> findByFacturaId(Integer factura_id);

    List<Visita> findByEstado(String estado);
}
