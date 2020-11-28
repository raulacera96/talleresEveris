package com.everis.serviciocliente.controllers;

//import com.everis.entidadesmysql.domains.Cliente;
import com.everis.serviciocliente.domains.Cliente;

import com.everis.serviciocliente.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/api/cliente")
    public Collection<Cliente> getAllClientes(){
        return this.clienteService.findAll();
    }

    @GetMapping("/api/cliente/{id}")
    public Cliente getCliente(@PathVariable("id") Integer clienteId){
        return this.clienteService.findById(clienteId);
    }

    @PostMapping(value="/api/cliente/insert")
    public List<Cliente> saveClientes(@RequestBody List<Cliente> nuevosClientes) {
        if(nuevosClientes != null)
            return this.clienteService.save(nuevosClientes);
        return null;
    }

    @PostMapping(value="/api/cliente/insert-one")
    public Cliente saveCliente(@RequestBody Cliente nuevoCliente) {
        if(nuevoCliente != null)
            return this.clienteService.save(nuevoCliente);
        return null;
    }

    @DeleteMapping(value="/api/cliente/delete/{id}")
    public void deleteCliente(@PathVariable("id") Integer id) {
        if(id != null)
            this.clienteService.deleteById(id);
    }
}
