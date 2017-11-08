package com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order4RabbitMq;
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
  public void orderApproved(Order4RabbitMq order4RabbitMq) {
    this.orderService.orderApprovedEvent(order4RabbitMq);
  }

  @RabbitListener(queues = "#{autoDeleteQueue2.name}")
  public void orderNotApproved(Order4RabbitMq order4RabbitMq) {
    this.orderService.orderNotApprovedEvent(order4RabbitMq);
  }

  @RabbitListener(queues = "#{autoDeleteQueue3.name}")
  public void orderFinished(int orderId) {
    this.orderService.orderFinished(orderId);
  }
}
