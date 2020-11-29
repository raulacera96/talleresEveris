package com.everis.serviciovisitas.controllers;

import com.everis.serviciovisitas.domains.DTOVisita;
import com.everis.serviciovisitas.domains.Factura;
import com.everis.serviciovisitas.domains.Visita;
import com.everis.serviciovisitas.services.ComFacturaService;
import com.everis.serviciovisitas.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/servicio-visita")
public class VisitaController {
    @Autowired
    VisitaService visitaService;

    @Autowired
    ComFacturaService comFacturaService;

    @GetMapping("/api/visita")
    public Collection<Visita> getAllVisitas(){
        return this.visitaService.findAll();
    }

    @GetMapping("/api/visita/factura/{id}")
    public DTOVisita getVisitaFactura(@PathVariable("id") Integer facturaId){
        Collection<Visita> visitas =this.visitaService.getVisitasFactura(facturaId);
        DTOVisita dtoVisita = new DTOVisita();
        dtoVisita.getListaVisitas().addAll(visitas);

        return dtoVisita;
    }

    @GetMapping("/api/visita/cliente/{id}")
    public List<Visita> getVisitaCliente(@PathVariable("id") Integer clienteId){
        List<Factura> facturasCliente = this.comFacturaService.getFacturaCliente("servicio-factura",clienteId);
        List<Visita> visitasCliente = new ArrayList<>();

        for (int i=0; i<facturasCliente.size(); i++){
            visitasCliente.addAll(this.visitaService.getVisitasFactura(facturasCliente.get(i).getClienteId()));
        }

        return visitasCliente;
        //return facturasCliente.size();
    }

    @GetMapping("/api/visita/estado/{estado}")
    public Collection<Visita> getVisitaEstado(@PathVariable("estado") String estado){
        Collection<Visita> visitas =this.visitaService.getVisitasEstado(estado);

        return visitas;
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
