package com.everis.serviciovisitas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServicioVisitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioVisitasApplication.class, args);
	}

}
