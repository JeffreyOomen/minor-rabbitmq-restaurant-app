package com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq;

import java.util.List;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMqSender {

  @Autowired
  private RabbitTemplate template;

  @Autowired
  private TopicExchange topic;

  private final String[] keys = {"place_order_event"};

  public void placeOrder(List<Integer> dishIds) {
    int[] dishIdsArray = dishIds
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();
    template.convertAndSend(topic.getName(), keys[0], dishIdsArray);
  }
}
