package com.pizza.ordergenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class OrderGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderGeneratorApplication.class, args);
	}

}
