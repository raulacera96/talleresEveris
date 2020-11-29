package com.everis.serviciofactura.services;

import com.everis.serviciofactura.domains.Visita;
import com.netflix.appinfo.InstanceInfo;

import java.util.Collection;
import java.util.List;

public interface ComVisitaService {
    //public List<InstanceInfo> getInstancesClient(String name);

    public List<Visita> getVisitaFactura(String s, Integer facturaId);
}
