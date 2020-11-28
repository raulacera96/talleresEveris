package com.everis.serviciopagos.services;

import com.everis.serviciopagos.domains.Pago;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PagosService {
    public Mono<Pago> getPagoId(Integer id);

    public Flux<Pago> getAllPagos();

    public Mono<Pago> savePago(Pago nuevoPago);

    public Mono<Void> deletePago(Pago pago);

    public Mono<Void> deletePago(Integer id);

    public Flux<Pago> getPagoByClienteId(Integer clienteId);

    public Flux<Pago> getPagoByFacturaId(Integer facturaId);

    public Flux<Pago> getPagoByEstado(String estado);
}
