package com.everis.serviciofactura.services.imp;

import com.everis.serviciofactura.domains.DTOPago;
import com.everis.serviciofactura.domains.Pago;
import com.everis.serviciofactura.services.ComPagosService;
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
public class ComPagosServiceImp implements ComPagosService {
    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    public List<InstanceInfo> getInstancesClient(String name){
        return eurekaClient.getApplication(name).getInstances();
    }

    public List<Pago> getPagosFactura(String s, Integer facturaId){
        List<InstanceInfo> info = eurekaClient.getApplication(s).getInstances();

        String fooResourceUrl = info.get(0).getHomePageUrl();
        System.out.println(fooResourceUrl);

        RestTemplate restTemplate = new RestTemplate();
        DTOPago response = restTemplate.getForObject(fooResourceUrl + "/servicio-pagos/api/pagos/factura/" + facturaId, DTOPago.class);
        List<Pago> pagos = response.getListaPagos();

        return pagos;
    }

    public Pago savePago(String name, Pago pago){

        List<InstanceInfo> instancesInfo = this.eurekaClient.getApplication(name).getInstances();
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = instancesInfo.get(0).getHomePageUrl();
        HttpEntity<Pago> request = new HttpEntity<>(pago);

        Pago response = restTemplate.postForObject(fooResourceUrl + "/api/pagos/insert", request, Pago.class);

        return response;
    }
}
