package com.everis.cliente.controllers;

import com.everis.cliente.domain.Cliente;
import com.everis.cliente.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteService ComFacturaService;

    @GetMapping("/api/cliente")
    public Flux<Cliente> getAllClientes(){
        return this.clienteService.getAllClientes();
    }

    @GetMapping("/api/cliente/{id}")
    public Mono<Cliente> getCliente(@PathVariable("id") String clienteId){
        return this.clienteService.getClienteId(clienteId);
    }

    @PostMapping(value="/api/cliente/insert")
    public Mono<Cliente> saveCliente(@RequestBody Cliente newCliente) {
        if(newCliente != null)
            return this.clienteService.saveCliente(newCliente);
        return null;
    }

    @DeleteMapping(value="/api/cliente/delete")
    public void deleteCliente(@RequestBody Cliente c) {
        if(c != null)
            this.clienteService.deleteCliente(c);
    }


}
