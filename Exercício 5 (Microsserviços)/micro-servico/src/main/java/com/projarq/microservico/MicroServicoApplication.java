package com.projarq.microservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroServicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicoApplication.class, args);
	}

}
