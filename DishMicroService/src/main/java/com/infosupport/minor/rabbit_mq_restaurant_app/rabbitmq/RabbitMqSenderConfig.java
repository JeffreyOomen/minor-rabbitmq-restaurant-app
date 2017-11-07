package com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqSenderConfig {

    @Bean
    public Queue placeOrder() {
        return new Queue("restaurant.app");
    }

    @Bean
    public RabbitMqSender sender() {
        return new RabbitMqSender();
    }
}
