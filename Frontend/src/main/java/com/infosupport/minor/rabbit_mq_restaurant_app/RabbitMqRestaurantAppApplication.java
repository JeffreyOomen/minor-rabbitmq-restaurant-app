package com.infosupport.minor.rabbit_mq_restaurant_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RabbitMqRestaurantAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqRestaurantAppApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
