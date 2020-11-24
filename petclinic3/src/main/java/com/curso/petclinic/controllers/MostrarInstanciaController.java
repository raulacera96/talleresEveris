package com.curso.petclinic.controllers;

import com.curso.petclinic.entity.Bill;
import com.curso.petclinic.services.impl.MostrarInstanciaService;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MostrarInstanciaController {

    @Autowired
    MostrarInstanciaService mostrarInstanciaService;

    @RequestMapping(value="/instances/{name}", method=RequestMethod.GET)
    public List<InstanceInfo> getInstancesClient(@PathVariable("name") String name) {
        if(name != null)
            return this.mostrarInstanciaService.getInstancesClient(name);
        return null;
    }

    @RequestMapping(value="/instances/{name}/{id}", method=RequestMethod.GET)
    public ResponseEntity<Bill> callService(@PathVariable("name") String name, @PathVariable("id") String id) {
        if(name != null)
            return this.mostrarInstanciaService.callService(name, id);
        return null;
    }

    @RequestMapping(value="/instances/insert/{name}", method=RequestMethod.POST)
    public Bill saveBill(@PathVariable("name") String name) {
        if(name != null)
            return this.mostrarInstanciaService.saveBill(name);
        return null;
    }
}
