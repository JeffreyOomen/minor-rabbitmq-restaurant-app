package com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqSenderConfig {

  @Bean
  public TopicExchange topic() {
    return new TopicExchange("com.infosupport.minor.restaurant");
  }

  @Bean
  public RabbitMqSender sender() {
    return new RabbitMqSender();
  }
}
