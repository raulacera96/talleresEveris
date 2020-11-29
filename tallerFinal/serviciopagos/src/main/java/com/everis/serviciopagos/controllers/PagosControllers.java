package com.everis.serviciopagos.controllers;

import com.everis.serviciopagos.domains.DTOPago;
import com.everis.serviciopagos.domains.Pago;
import com.everis.serviciopagos.services.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/servicio-pagos")
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
    public DTOPago getPagoByClienteId(@PathVariable("id") Integer clienteId){
        Flux<Pago> pagos = this.pagosService.getPagoByClienteId(clienteId);
        DTOPago dtoPago = new DTOPago();
        dtoPago.setListaPagos((ArrayList<Pago>) pagos.collectList().block());

        return dtoPago;
    }

    @GetMapping("/api/pagos/factura/{id}")
    public DTOPago getPagoByFacturaId(@PathVariable("id") Integer facturaId){
        Flux<Pago> pagos = this.pagosService.getPagoByFacturaId(facturaId);
        DTOPago dtoPago = new DTOPago();
        dtoPago.setListaPagos((ArrayList<Pago>) pagos.collectList().block());

        return dtoPago;
    }

    @GetMapping("/api/pagos/estado/{estado}")
    public DTOPago getPagoByEstado(@PathVariable("estado") String estadoPago){
        Flux<Pago> pagos = this.pagosService.getPagoByEstado(estadoPago);
        DTOPago dtoPago = new DTOPago();
        dtoPago.setListaPagos((ArrayList<Pago>) pagos.collectList().block());

        return dtoPago;
    }

    @GetMapping("/api/pagos/clienteEstado/{id}")
    public List<String> getEstadoCliente(@PathVariable("id") Integer clienteId){
        List<Pago> pagos = this.pagosService.getPagoByClienteId(clienteId).collectList().block();
        List<String> estadosPagosCliente = new ArrayList<>();
        estadosPagosCliente.add("Pagos del cliente: "+clienteId);

        for (int i=0; i<pagos.size(); i++){
            estadosPagosCliente.add("Pago "+pagos.get(i).getId().toString());
            estadosPagosCliente.add("Estado: "+pagos.get(i).getEstadoPago());
        }

        return estadosPagosCliente;
    }

    @GetMapping("/api/pagos/facturaEstado/{id}")
    public List<String> getEstadoFactura(@PathVariable("id") Integer facturaId){
        List<Pago> pagos = this.pagosService.getPagoByFacturaId(facturaId).collectList().block();
        List<String> estadosPagosFactura = new ArrayList<>();
        estadosPagosFactura.add("Pagos de la factura: "+facturaId);

        for (int i=0; i<pagos.size(); i++){
            estadosPagosFactura.add("Pago "+pagos.get(i).getId().toString());
            estadosPagosFactura.add("Estado: "+pagos.get(i).getEstadoPago());
        }

        return estadosPagosFactura;
    }
}
