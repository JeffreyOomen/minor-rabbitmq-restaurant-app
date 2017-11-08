package com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order4RabbitMq;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMqSender {

  @Autowired
  private RabbitTemplate template;

  @Autowired
  private TopicExchange topic;

  private final String[] keys = {"dish_approved_event", "dish_not_approved_event"};

  public void dishesStatus(Order4RabbitMq order4RabbitMq, boolean isApproved) {
    String key = keys[1];
    if (isApproved) {
      key = keys[0];
    }

    template.convertAndSend(topic.getName(), key, order4RabbitMq);
  }
}
