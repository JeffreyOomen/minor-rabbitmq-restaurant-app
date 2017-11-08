package com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ChefRabbitMqSender {
  
  @Autowired
  private RabbitTemplate template;

  @Autowired
  private TopicExchange topic;

  private final String[] keys = {"dish_finished_event"};

  public void foodFinished(int orderId) {
    template.convertAndSend(topic.getName(), keys[0], orderId);
  }
}
