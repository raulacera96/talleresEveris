package com.everis.serviciofactura.services;

import com.everis.serviciofactura.domains.Factura;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface FacturaService {
    public Mono<Factura> getFacturaId(Integer id);

    public Flux<Factura> getAllFacturas();

    public Mono<Factura> saveFactura(Factura nuevaFactura);

    public Mono<Void> deleteFactura(Factura factura);

    public Mono<Void> deleteFacturaById(Integer facturaId);

    public Flux<Factura> getFacturaByClienteId(Integer clienteId);

    public Flux<Factura> getFacturaByEstado(String estado);

    public Flux<Factura> getFacturaByImporte(double importe);
}
