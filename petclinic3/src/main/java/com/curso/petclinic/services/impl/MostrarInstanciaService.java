package com.curso.petclinic.services.impl;

import com.curso.petclinic.entity.Bill;
import com.curso.petclinic.entity.Owner;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class MostrarInstanciaService {
    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    public List<InstanceInfo> getInstancesClient(String name){
        return eurekaClient.getApplication(name).getInstances();
    }

    public ResponseEntity<Bill> callService(String s, String id){
        List<InstanceInfo> info = eurekaClient.getApplication(s).getInstances();

        String fooResourceUrl = info.get(0).getHomePageUrl();
        System.out.println(fooResourceUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Bill> response = restTemplate.getForEntity(fooResourceUrl + "/bills/" + id, Bill.class);

        return response;
    }

    public Bill saveBill(String s){
        Bill b = new Bill();
        b.setIdNumber(25);
        b.setMoney(99.9);
        Date d = new Date();
        d.setDate(2020-11-24);
        b.setPaymentDate(d);

        List<InstanceInfo> instancesInfo = this.eurekaClient.getApplication(s).getInstances();
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = instancesInfo.get(0).getHomePageUrl();
        HttpEntity<Bill> request = new HttpEntity<>(b);

        Bill response = restTemplate.postForObject(fooResourceUrl + "/bills/insert/", request, Bill.class);

        return response;
    }
}
