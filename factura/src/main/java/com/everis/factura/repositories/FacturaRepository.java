package com.everis.factura.repositories;

import com.everis.factura.domain.Factura;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FacturaRepository extends MongoRepository<Factura, String> {
    List<Factura> findAll();

    Optional<Factura> findById(String id);

    Factura save(Factura f);

    void delete(Factura f);

}
