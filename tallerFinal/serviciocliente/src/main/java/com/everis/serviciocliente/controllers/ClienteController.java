package com.everis.serviciocliente.controllers;

//import com.everis.entidadesmysql.domains.Cliente;
import com.everis.serviciocliente.domains.Cliente;

import com.everis.serviciocliente.domains.Direccion;
import com.everis.serviciocliente.services.ClienteService;
import com.everis.serviciocliente.services.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/servicio-cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    DireccionService direccionService;

    @GetMapping("/api/cliente")
    public Collection<Cliente> getAllClientes(){
        return this.clienteService.findAll();
    }

    @GetMapping("/api/cliente/id/{id}")
    public Cliente getCliente(@PathVariable("id") Integer clienteId){
        return this.clienteService.findById(clienteId);
    }

    @GetMapping("/api/cliente/provincia/{provincia}")
    public List<Object> getClienteByProvincia(@PathVariable("provincia") String provinciaCliente){
        List<Direccion> direcciones = this.direccionService.getDireccionesProvincia(provinciaCliente);
        List<Object> lista = new ArrayList<>();

        List<Cliente> clientes = new ArrayList<Cliente>();
        for(int i=0; i<direcciones.size(); i++){
            clientes.add(this.clienteService.findById(direcciones.get(i).getClienteId()));

            if(!lista.contains(clientes.get(i))){
                lista.add(clientes.get(i));
                lista.add(this.direccionService.getDireccionesCliente(clientes.get(i).getId()));
            }
        }

        return lista;
    }

    @GetMapping("/api/cliente/nombre/{name}")
    public List<Object> getClienteByNombre(@PathVariable("name") String nombreCliente){
        List<Cliente> clientes = this.clienteService.findByFirstName(nombreCliente);
        List<Object> lista = new ArrayList<>();

        for (int i=0; i<clientes.size();i++){
            if(!lista.contains(clientes.get(i))){
                lista.add(clientes.get(i));
                lista.add(this.direccionService.getDireccionesCliente(clientes.get(i).getId()));
            }
        }

        return lista;
    }

    @GetMapping("/api/cliente/apellido/{lastname}")
    public List<Cliente> getClienteByApellido(@PathVariable("lastname") String apellidoCliente){
        return this.clienteService.findByLastName(apellidoCliente);
    }

    @GetMapping("/api/cliente/nombrecompleto/{firstname}/{lastname}")
    public List<Cliente> getClienteByApellido(@PathVariable("firstname") String nombreCliente, @PathVariable("lastname") String apellidoCliente){
        return this.clienteService.findByFirstNameAndLastName(nombreCliente, apellidoCliente);
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
