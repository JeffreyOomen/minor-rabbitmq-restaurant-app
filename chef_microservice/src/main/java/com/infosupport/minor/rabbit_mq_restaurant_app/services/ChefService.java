package com.infosupport.minor.rabbit_mq_restaurant_app.services;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order4RabbitMq;
import com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq.ChefRabbitMqSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChefService {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private ChefRabbitMqSender chefRabbitMqSender;

  public void cookFood(Order4RabbitMq order4RabbitMq) {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    logger.info("food cooked! dishesId:{} orderId:{}", order4RabbitMq.getDishIds(), order4RabbitMq.getOrderId());

    chefRabbitMqSender.foodFinished(order4RabbitMq.getOrderId());
  }

}
