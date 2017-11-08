package com.infosupport.minor.rabbit_mq_restaurant_app.chef_microservice.services;

import com.infosupport.minor.rabbit_mq_restaurant_app.chef_microservice.rabbitmq.ChefRabbitMqSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChefService {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private ChefRabbitMqSender chefRabbitMqSender;

  public void cookFood(int[] dishesId, int orderId) {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    logger.info("food cooked! dishesId:{} orderId:{}", dishesId, orderId);

    chefRabbitMqSender.foodFinished(orderId);
  }

}
