package com.everis.serviciofactura.controllers;

import com.everis.serviciofactura.domains.DTOPago;
import com.everis.serviciofactura.domains.Pago;
import com.everis.serviciofactura.services.ComPagosService;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComPagosController {
    @Autowired
    ComPagosService comPagosService;

    @RequestMapping(value="/instances/{name}", method= RequestMethod.GET)
    public List<InstanceInfo> getInstancesClient(@PathVariable("name") String name) {
        if(name != null)
            return this.comPagosService.getInstancesClient(name);
        return null;
    }

    @RequestMapping(value="/instances/{name}/{id}", method=RequestMethod.GET)
    public List<Pago> callService(@PathVariable("name") String name, @PathVariable("id") Integer facturaId) {
        if(name != null)
            return this.comPagosService.getPagosFactura(name, facturaId);
        return null;
    }

    @RequestMapping(value="/instances/insert/{name}", method=RequestMethod.GET)
    public Pago savePago(@PathVariable("name") String name, @RequestBody Pago pago) {
        return this.comPagosService.savePago(name, pago);
    }
}
