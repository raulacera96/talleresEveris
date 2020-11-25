package com.everis.factura.services;

import com.everis.factura.domain.Factura;
import com.everis.factura.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {
    @Autowired
    FacturaRepository facturaRepository;

    public List<Factura> getAllFacturas(){

        return this.facturaRepository.findAll();
    }

    public Optional<Factura> getFacturaId(String id){

        return this.facturaRepository.findById(id);
    }

    public Factura saveFactura(Factura newFactura) {
        return this.facturaRepository.save(newFactura);
    }

    public void deleteFactura(Factura f){
        this.facturaRepository.delete(f);
    }
}
