package com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order4RabbitMq;
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

  private final String[] keys = {"place_order_event", "order_approved_event"};

  public void placeOrder(List<Integer> dishIds, int orderId) {
    int[] dishIdsArray = dishIds
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();

    Order4RabbitMq order4RabbitMq = new Order4RabbitMq(dishIdsArray, orderId);
    template.convertAndSend(topic.getName(), keys[0], order4RabbitMq);
  }

  public void isApproved(int orderId) {
    template.convertAndSend(topic.getName(), keys[1], orderId);
  }
}
