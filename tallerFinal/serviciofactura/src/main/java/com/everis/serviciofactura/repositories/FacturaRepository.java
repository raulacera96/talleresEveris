package com.everis.serviciofactura.repositories;

import com.everis.serviciofactura.domains.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface FacturaRepository extends ReactiveMongoRepository<Factura, Integer> {
    Flux<Factura> findAll();

    Mono<Factura> findById(Integer id);

    Mono<Factura> save(Factura factura);

    Mono<Void> deleteById(Integer id);

    Mono<Void> delete(Factura pago);

    Flux<Factura> findByClienteId(Integer clienteId);

    Flux<Factura> findByEstadoFactura(String estadoFactura);

    Flux<Factura> findByImporte(double importe);
}
