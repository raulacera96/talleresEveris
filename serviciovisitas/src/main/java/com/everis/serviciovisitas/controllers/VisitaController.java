package com.everis.serviciovisitas.controllers;

import com.everis.serviciovisitas.domains.Visita;
import com.everis.serviciovisitas.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class VisitaController {
    @Autowired
    VisitaService visitaService;

    @GetMapping("/api/visita")
    public Collection<Visita> getAllVisitas(){
        return this.visitaService.findAll();
    }

    @GetMapping("/api/visita/cliente/{id}")
    public Collection<Visita> getVisitaCliente(@PathVariable("id") Integer clienteId){
        return this.visitaService.getVisitasCliente(clienteId);
    }

    @PostMapping(value="/api/visita/insert")
    public List<Visita> saveVisitas(@RequestBody List<Visita> nuevasVisitas) {
        if(nuevasVisitas != null)
            return this.visitaService.save(nuevasVisitas);
        return null;
    }

    @PostMapping(value="/api/visita/insert-one")
    public Visita saveVisita(@RequestBody Visita nuevaVisita) {
        if(nuevaVisita != null)
            return this.visitaService.save(nuevaVisita);
        return null;
    }

    @DeleteMapping(value="/api/visita/delete/{id}")
    public void deleteVisita(@PathVariable("id") Integer visitaId) {
        if(visitaId != null)
            this.visitaService.deleteById(visitaId);
    }
}
