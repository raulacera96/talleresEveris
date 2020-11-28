package com.everis.serviciofactura.services.imp;

import com.everis.serviciofactura.domains.Factura;
import com.everis.serviciofactura.repositories.FacturaRepository;
import com.everis.serviciofactura.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class FacturaServiceImp implements FacturaService {
    @Autowired
    FacturaRepository facturaRepository;

    public Mono<Factura> getFacturaId(Integer id){
        return  facturaRepository.findById(id);
    }

    public Flux<Factura> getAllFacturas(){
        return facturaRepository.findAll();
    }

    public Mono<Factura> saveFactura(Factura nuevaFactura) {
        return facturaRepository.save(nuevaFactura);
    }

    public Mono<Void> deleteFactura(Factura factura){
        return this.facturaRepository.delete(factura);
    }

    public Mono<Void> deleteFacturaById(Integer facturaId){
        return this.facturaRepository.deleteById(facturaId);
    }

    public Flux<Factura> getFacturaByClienteId(Integer clienteId){ return facturaRepository.findByClienteId(clienteId); }

    public Flux<Factura> getFacturaByEstado(String estado){ return facturaRepository.findByEstadoFactura(estado); }

    public Flux<Factura> getFacturaByImporte(double importe){ return facturaRepository.findByImporte(importe); }
}
