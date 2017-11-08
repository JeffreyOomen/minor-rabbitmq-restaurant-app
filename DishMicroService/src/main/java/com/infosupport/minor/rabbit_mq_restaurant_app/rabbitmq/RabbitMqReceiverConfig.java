package com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqReceiverConfig {

  //Create a springBean of type TopicExchange and name topic
  @Bean
  public TopicExchange topic() {
    return new TopicExchange("com.infosupport.minor.restaurant");
  }

  @Bean
  public Queue autoDeleteQueue1() {
    return new AnonymousQueue();
  }

  @Bean
  public Binding binding1a(TopicExchange topic, Queue autoDeleteQueue1) {
    return BindingBuilder.bind(autoDeleteQueue1)
        .to(topic).with("place_order_event");
  }

  @Bean
  public RabbitMqReceiver receiver() {
    return new RabbitMqReceiver();
  }
}
