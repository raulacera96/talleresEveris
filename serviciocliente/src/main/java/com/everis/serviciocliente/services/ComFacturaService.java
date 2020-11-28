package com.everis.serviciocliente.services;

import com.everis.serviciocliente.domains.Factura;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComFacturaService {
    public List<InstanceInfo> getInstancesClient(String name);

    public List<Factura> callService(String s, Integer clienteId);

    public Factura saveFactura(String name, Factura factura);
}
