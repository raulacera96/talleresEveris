package com.everis.serviciocliente.services.imp;

import com.everis.serviciocliente.domains.DTOFacturas;
import com.everis.serviciocliente.domains.Factura;
import com.everis.serviciocliente.services.ComFacturaService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ComFacturaServiceImp implements ComFacturaService {
    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    public List<InstanceInfo> getInstancesClient(String name){
        return eurekaClient.getApplication(name).getInstances();
    }

    public List<Factura> callService(String s, Integer clienteId){
        List<InstanceInfo> info = eurekaClient.getApplication(s).getInstances();

        String fooResourceUrl = info.get(0).getHomePageUrl();
        System.out.println(fooResourceUrl);

        RestTemplate restTemplate = new RestTemplate();
        DTOFacturas response = restTemplate.getForObject(fooResourceUrl + "/api/factura/cliente/" + clienteId, DTOFacturas.class);
        List<Factura> facturas = response.getListaFacturas();

        return facturas;
    }

    public Factura saveFactura(String name, Factura factura){

        List<InstanceInfo> instancesInfo = this.eurekaClient.getApplication(name).getInstances();
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = instancesInfo.get(0).getHomePageUrl();
        HttpEntity<Factura> request = new HttpEntity<>(factura);

        Factura response = restTemplate.postForObject(fooResourceUrl + "/api/factura/insert", request, Factura.class);

        return response;
    }
}
