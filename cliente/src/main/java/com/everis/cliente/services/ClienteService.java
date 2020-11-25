package com.everis.cliente.services;

import com.everis.cliente.domain.Cliente;
import com.everis.cliente.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Mono<Cliente> getClienteId(String id){
        return  clienteRepository.findById(id);
    }

    public Flux<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    public Mono<Cliente> saveCliente(Cliente newCliente) {
        return clienteRepository.save(newCliente);
    }

    public Mono<Void> deleteCliente(Cliente c){

        return this.clienteRepository.delete(c);
    }
}
