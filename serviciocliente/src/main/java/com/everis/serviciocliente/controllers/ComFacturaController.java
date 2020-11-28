package com.everis.serviciocliente.controllers;

import com.everis.serviciocliente.domains.Factura;
import com.everis.serviciocliente.services.ComFacturaService;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComFacturaController {
    @Autowired
    ComFacturaService comFacturaService;

    @RequestMapping(value="/instances/{name}", method= RequestMethod.GET)
    public List<InstanceInfo> getInstancesClient(@PathVariable("name") String name) {
        if(name != null)
            return this.comFacturaService.getInstancesClient(name);
        return null;
    }

    @RequestMapping(value="/instances/{name}/{id}", method=RequestMethod.GET)
    public List<Factura> callService(@PathVariable("name") String name, @PathVariable("id") Integer clienteId) {
        if(name != null)
            return this.comFacturaService.callService(name, clienteId);
        return null;
    }

    @RequestMapping(value="/instances/insert/{name}", method=RequestMethod.GET)
    public Factura saveBill(@PathVariable("name") String name, @RequestBody Factura factura) {
            return this.comFacturaService.saveFactura(name, factura);
    }
}
