package com.everis.serviciofactura.services.imp;

import com.everis.serviciofactura.domains.DTOPago;
import com.everis.serviciofactura.domains.DTOVisita;
import com.everis.serviciofactura.domains.Pago;
import com.everis.serviciofactura.domains.Visita;
import com.everis.serviciofactura.services.ComVisitaService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@Service
public class ComVisitaServiceImp implements ComVisitaService {
    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    /*public List<InstanceInfo> getInstancesClient(String name){
        return eurekaClient.getApplication(name).getInstances();
    }*/

    public List<Visita> getVisitaFactura(String s, Integer facturaId){
        List<InstanceInfo> info = eurekaClient.getApplication(s).getInstances();

        String fooResourceUrl = info.get(0).getHomePageUrl();
        System.out.println(fooResourceUrl);

        RestTemplate restTemplate = new RestTemplate();
        DTOVisita response = restTemplate.getForObject(fooResourceUrl + "/servicio-visita/api/visita/factura/" + facturaId, DTOVisita.class);
        List<Visita> visitas = response.getListaVisitas();

        return visitas;
    }
}
