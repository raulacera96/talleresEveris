package com.everis.serviciovisitas.services;

import com.everis.serviciovisitas.domains.Factura;
import com.netflix.appinfo.InstanceInfo;

import java.util.List;

public interface ComFacturaService {
    public List<InstanceInfo> getInstancesClient(String name);

    public List<Factura> getFacturaCliente(String s, Integer clienteId);
}
