package com.everis.serviciocliente.controllers;

import com.everis.serviciocliente.domains.Direccion;
import com.everis.serviciocliente.services.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/servicio-cliente")
public class DireccionController {
    @Autowired
    DireccionService direccionService;

    @GetMapping("/api/direccion")
    public Collection<Direccion> getAllDirecciones(){
        return this.direccionService.findAll();
    }

    @GetMapping("/api/direccion/cliente/{id}")
    public Collection<Direccion> getDireccionCliente(@PathVariable("id") Integer clienteId){
        return this.direccionService.getDireccionesCliente(clienteId);
    }

    @PostMapping(value="/api/direccion/insert")
    public List<Direccion> saveDirecciones(@RequestBody List<Direccion> nuevasDirecciones) {
        if(nuevasDirecciones != null)
            return this.direccionService.save(nuevasDirecciones);
        return null;
    }

    @PostMapping(value="/api/direccion/insert-one")
    public Direccion saveDireccion(@RequestBody Direccion nuevaDireccion) {
        if(nuevaDireccion != null)
            return this.direccionService.save(nuevaDireccion);
        return null;
    }

    @DeleteMapping(value="/api/direccion/delete/{id}")
    public void deleteDireccion(@PathVariable("id") Integer direccionId) {
        if(direccionId != null)
            this.direccionService.deleteById(direccionId);
    }
}
