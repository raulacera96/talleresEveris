package com.everis.serviciovisitas.services.imp;

import com.everis.serviciovisitas.domains.DTOFactura;
import com.everis.serviciovisitas.domains.DTOVisita;
import com.everis.serviciovisitas.domains.Factura;
import com.everis.serviciovisitas.services.ComFacturaService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComFacturaServiceImp implements ComFacturaService {
    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    public List<InstanceInfo> getInstancesClient(String name){
        return eurekaClient.getApplication(name).getInstances();
    }

    public List<Factura> getFacturaCliente(String s, Integer clienteId){
        List<InstanceInfo> info = eurekaClient.getApplication(s).getInstances();

        String fooResourceUrl = info.get(0).getHomePageUrl();
        System.out.println(fooResourceUrl);

        RestTemplate restTemplate = new RestTemplate();
        DTOFactura response = restTemplate.getForObject(fooResourceUrl + "/servicio-factura/api/soloFactura/cliente/" + clienteId, DTOFactura.class);
        List<Factura> facturas = new ArrayList<>();
        facturas.addAll(response.getListaFacturas());

        return facturas;
    }
}
