package com.everis.serviciopagos.services.imp;

import com.everis.serviciopagos.domains.Pago;
import com.everis.serviciopagos.repositories.PagosRepository;
import com.everis.serviciopagos.services.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PagosServiceImp implements PagosService {
    @Autowired
    PagosRepository pagosRepository;

    public Mono<Pago> getPagoId(Integer id){
        return  pagosRepository.findById(id);
    }

    public Flux<Pago> getAllPagos(){
        return pagosRepository.findAll();
    }

    public Mono<Pago> savePago(Pago nuevoPago) {
        return pagosRepository.save(nuevoPago);
    }

    public Mono<Void> deletePago(Pago pago){
        return this.pagosRepository.delete(pago);
    }

    public Mono<Void> deletePago(Integer id){
        return this.pagosRepository.deleteById(id);
    }

    public Flux<Pago> getPagoByClienteId(Integer clienteId){ return pagosRepository.findByClienteId(clienteId); }

    public Flux<Pago> getPagoByFacturaId(Integer facturaId){ return pagosRepository.findByFacturaId(facturaId); }

    public Flux<Pago> getPagoByEstado(String estado){ return pagosRepository.findByEstadoPago(estado); }
}
