package com.everis.serviciocliente.repositories;

//import com.everis.entidadesmysql.domains.Direccion;
import com.everis.serviciocliente.domains.Direccion;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
    List<Direccion> findAll();

    List<Direccion> save(List<Direccion> direcciones);

    Direccion save(Direccion direccion);

    void deleteById(Integer direccionId);

    Collection<Direccion> findByClienteId(Integer cliente_id);

    List<Direccion> findByProvinciaOrderByClienteId(String provincia);
}
