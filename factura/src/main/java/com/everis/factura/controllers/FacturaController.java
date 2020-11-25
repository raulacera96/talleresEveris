package com.everis.factura.controllers;

import com.everis.factura.domain.Factura;
import com.everis.factura.services.FacturaService;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
public class FacturaController {
    @Autowired
    FacturaService facturaService;

    @GetMapping("/api/factura")
    public List<Factura> getAllFacturas(){
        return this.facturaService.getAllFacturas();
    }

    @GetMapping("/api/factura/{id}")
    public Optional<Factura> getFactura(@PathVariable("id") String facturaId){
        return this.facturaService.getFacturaId(facturaId);
    }

    @PostMapping(value="/api/factura/insert")
    public Factura saveFactura(@RequestBody Factura newFactura) {
        if(newFactura != null)
            return this.facturaService.saveFactura(newFactura);
        return null;
    }

    @DeleteMapping(value="/api/factura/delete")
    public void deleteFactura(@RequestBody Factura f) {
        if(f != null)
            this.facturaService.deleteFactura(f);
    }
}
