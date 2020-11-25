package com.everis.cliente.services;

import com.everis.cliente.domain.Factura;
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
public class ComFacturaService {
    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    public List<InstanceInfo> getInstancesClient(String name){
        return eurekaClient.getApplication(name).getInstances();
    }

    public ResponseEntity<Factura> callService(String s, String id){
        List<InstanceInfo> info = eurekaClient.getApplication(s).getInstances();

        String fooResourceUrl = info.get(0).getHomePageUrl();
        System.out.println(fooResourceUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Factura> response = restTemplate.getForEntity(fooResourceUrl + "/api/factura/" + id, Factura.class);

        return response;
    }

    public Factura saveFactura(String s){
        Factura f = new Factura();
        f.setId("11");

        List<InstanceInfo> instancesInfo = this.eurekaClient.getApplication(s).getInstances();
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = instancesInfo.get(0).getHomePageUrl();
        HttpEntity<Factura> request = new HttpEntity<>(f);

        Factura response = restTemplate.postForObject(fooResourceUrl + "/api/factura/insert", request, Factura.class);

        return response;
    }
}
