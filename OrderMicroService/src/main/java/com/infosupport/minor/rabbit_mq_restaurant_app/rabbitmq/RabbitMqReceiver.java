package com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq;

import com.infosupport.minor.rabbit_mq_restaurant_app.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMqReceiver {

  Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private OrderService orderService;

  @RabbitListener(queues = "#{autoDeleteQueue1.name}")
  public void orderApproved(int orderId) {
    this.orderService.orderApprovedEvent(orderId);
  }

  @RabbitListener(queues = "#{autoDeleteQueue2.name}")
  public void orderNotApproved(int orderId) {
    this.orderService.orderNotApprovedEvent(orderId);
  }
}
