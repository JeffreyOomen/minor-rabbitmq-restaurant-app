package com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqReceiverConfig {

  @Bean
  public Queue receive() {
    return new Queue("com.infosupport.minor.restaurant");
  }

  @Bean
  public RabbitMqReceiver receiver() {
    return new RabbitMqReceiver();
  }
}
