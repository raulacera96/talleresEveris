package com.everis.serviciofactura.controllers;

import com.everis.serviciofactura.domains.DTOFacturas;
import com.everis.serviciofactura.domains.Factura;
import com.everis.serviciofactura.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class FacturaController {
    @Autowired
    FacturaService facturaService;

    @GetMapping("/api/factura")
    public Flux<Factura> getAllFacturas(){
        return this.facturaService.getAllFacturas();
    }

    @GetMapping("/api/factura/{id}")
    public Mono<Factura> getFactura(@PathVariable("id") Integer facturaId){
        return this.facturaService.getFacturaId(facturaId);
    }

    @PostMapping(value="/api/factura/insert")
    public Mono<Factura> saveFactura(@RequestBody Factura nuevaFactura) {
        if(nuevaFactura != null)
            return this.facturaService.saveFactura(nuevaFactura);
        return null;
    }

    @PostMapping(value="/api/factura/update/{id}")
    public Mono<Factura> updateFactura(@PathVariable("id") Integer facturaId, @RequestBody Factura nuevaFactura) {
        Mono<Factura> f = this.facturaService.getFacturaId(facturaId);
        if(f.block().getEstadoFactura() == "Pendiente pago"){
            if(nuevaFactura != null)
                return this.facturaService.saveFactura(nuevaFactura);
            return null;
        } else { return null; }
    }

    @DeleteMapping(value="/api/factura/delete")
    public Mono<Void> deleteFactura(@RequestBody Factura factura) {
            return this.facturaService.deleteFactura(factura);
    }

    @DeleteMapping(value="/api/factura/delete/{id}")
    public Mono<Void> deleteFacturaId(@PathVariable("id") Integer facturaId) {
            return this.facturaService.deleteFacturaById(facturaId);
    }

    @GetMapping("/api/factura/cliente/{id}")
    public DTOFacturas getFacturaByClienteId(@PathVariable("id") Integer clienteId){
        //return this.facturaService.getFacturaByClienteId(clienteId);
        Flux<Factura> facturas=this.facturaService.getFacturaByClienteId(clienteId);

        DTOFacturas dtoFacturas = new DTOFacturas();
        dtoFacturas.setListaFacturas((ArrayList<Factura>) facturas.collectList().block());
        return dtoFacturas;
    }

    @GetMapping("/api/factura/estado/{estado}")
    public Flux<Factura> getFacturaByEstado(@PathVariable("estado") String estadoFactura){
        return this.facturaService.getFacturaByEstado(estadoFactura);
    }

    @GetMapping("/api/factura/importe/{importe}")
    public Flux<Factura> getFacturaByImporte(@PathVariable("importe") double importeFactura){
        return this.facturaService.getFacturaByImporte(importeFactura);
    }
}
