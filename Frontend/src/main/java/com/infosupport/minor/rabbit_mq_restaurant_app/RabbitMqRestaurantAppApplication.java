package com.infosupport.minor.rabbit_mq_restaurant_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.cloud.CloudAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {RabbitAutoConfiguration.class, CloudAutoConfiguration.class})
// if we get future issues with configuration remove rabitMQ dependency from parent pom.
// this pom doesn't need it, but Spring Boot is configuring it for us.
public class RabbitMqRestaurantAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqRestaurantAppApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
