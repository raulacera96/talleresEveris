package com.everis.serviciofactura.controllers;

import com.everis.serviciofactura.domains.Visita;
import com.everis.serviciofactura.services.ComVisitaService;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ComVisitaController {
    @Autowired
    ComVisitaService comVisitaService;

    /*@RequestMapping(value="/instances/{name}", method= RequestMethod.GET)
    public List<InstanceInfo> getInstancesClient(@PathVariable("name") String name) {
        if(name != null)
            return this.comVisitaService.getInstancesClient(name);
        return null;
    }*/

    @RequestMapping(value="/instances/{name}/visitaFactura/{id}", method=RequestMethod.GET)
    public List<Visita> callService(@PathVariable("name") String name, @PathVariable("id") Integer facturaId) {
        if(name != null)
            return this.comVisitaService.getVisitaFactura(name, facturaId);
        return null;
    }
}
