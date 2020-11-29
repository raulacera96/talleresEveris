package com.everis.serviciovisitas.controllers;

import com.everis.serviciovisitas.domains.Factura;
import com.everis.serviciovisitas.services.ComFacturaService;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value="/instances/{name}/cliente/{id}", method= RequestMethod.GET)
    public List<Factura> callService(@PathVariable("name") String name, @PathVariable("id") Integer clienteId) {
        if(name != null)
            return this.comFacturaService.getFacturaCliente(name, clienteId);
        return null;
    }
}
