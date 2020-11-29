package com.everis.serviciofactura.services;

import com.everis.serviciofactura.domains.Pago;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComPagosService {
    public List<InstanceInfo> getInstancesClient(String name);

    public List<Pago> getPagosFactura(String s, Integer facturaId);

    public Pago savePago(String name, Pago pago);
}
