package com.everis.serviciopagos.controllers;

import com.everis.serviciopagos.domains.Pago;
import com.everis.serviciopagos.services.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PagosControllers {
    @Autowired
    PagosService pagosService;

    @GetMapping("/api/pagos")
    public Flux<Pago> getAllPagos(){
        return this.pagosService.getAllPagos();
    }

    @GetMapping("/api/pagos/{id}")
    public Mono<Pago> getPago(@PathVariable("id") Integer pagoId){
        return this.pagosService.getPagoId(pagoId);
    }

    @PostMapping(value="/api/pagos/insert")
    public Mono<Pago> savePago(@RequestBody Pago nuevoPago) {
        if(nuevoPago != null)
            return this.pagosService.savePago(nuevoPago);
        return null;
    }

    @DeleteMapping(value="/api/pagos/delete")
    public Mono<Void> deletePago(@RequestBody Pago pago) {
            return this.pagosService.deletePago(pago);
    }

    @DeleteMapping(value="/api/pagos/delete/{id}")
    public Mono<Void> deletePago(@PathVariable("id") Integer pagoId) {
            return this.pagosService.deletePago(pagoId);
    }

    @GetMapping("/api/pagos/cliente/{id}")
    public Flux<Pago> getPagoByClienteId(@PathVariable("id") Integer clienteId){
        return this.pagosService.getPagoByClienteId(clienteId);
    }

    @GetMapping("/api/pagos/factura/{id}")
    public Flux<Pago> getPagoByFacturaId(@PathVariable("id") Integer facturaId){
        return this.pagosService.getPagoByFacturaId(facturaId);
    }

    @GetMapping("/api/pagos/estado/{estado}")
    public Flux<Pago> getPagoByEstado(@PathVariable("estado") String estadoPago){
        return this.pagosService.getPagoByEstado(estadoPago);
    }
}
