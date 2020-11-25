package com.everis.cliente.repositories;

import com.everis.cliente.domain.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {
    Flux<Cliente> findAll();

    Mono<Cliente> findById(String id);

    Mono<Cliente> save(Cliente c);

    Mono<Void> delete(Cliente c);
}
