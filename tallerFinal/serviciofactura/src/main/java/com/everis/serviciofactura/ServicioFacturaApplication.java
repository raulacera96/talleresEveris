package com.everis.serviciofactura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServicioFacturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioFacturaApplication.class, args);
	}

}
