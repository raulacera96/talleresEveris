package com.everis.serviciopagos.repositories;

import com.everis.serviciopagos.domains.Pago;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PagosRepository extends ReactiveMongoRepository<Pago, Integer> {
    Flux<Pago> findAll();

    Mono<Pago> findById(Integer id);

    Mono<Pago> save(Pago pago);

    Mono<Void> deleteById(Integer id);

    Mono<Void> delete(Pago pago);

    Flux<Pago> findByClienteId(Integer clienteId);

    Flux<Pago> findByFacturaId(Integer facturaId);

    Flux<Pago> findByEstadoPago(String estado);
}
