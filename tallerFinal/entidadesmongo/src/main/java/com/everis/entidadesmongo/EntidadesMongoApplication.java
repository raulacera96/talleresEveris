package com.everis.entidadesmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EntidadesMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntidadesMongoApplication.class, args);
	}

}
