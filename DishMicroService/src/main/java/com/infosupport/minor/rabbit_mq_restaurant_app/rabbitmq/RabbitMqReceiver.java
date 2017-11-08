package com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RabbitMqReceiver {

  Logger logger = LoggerFactory.getLogger(getClass());

  @RabbitListener(queues = "#{autoDeleteQueue1.name}")
  public void receiving(int[] in) {
    for (int i : in) {
      logger.info("i: {}", i);
    }
    logger.info("receiving: {}", in);

    // TODO: 1. check if products are still available and send dish approved or not approved to order
    // TODO: 2. Order than changes status and sends event for le chef.
  }
}
