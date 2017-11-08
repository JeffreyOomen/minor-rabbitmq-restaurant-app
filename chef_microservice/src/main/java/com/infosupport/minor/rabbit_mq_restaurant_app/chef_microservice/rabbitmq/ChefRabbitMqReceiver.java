package com.infosupport.minor.rabbit_mq_restaurant_app.chef_microservice.rabbitmq;

import com.infosupport.minor.rabbit_mq_restaurant_app.chef_microservice.domain.Order4RabbitMq;
import com.infosupport.minor.rabbit_mq_restaurant_app.chef_microservice.services.ChefService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class ChefRabbitMqReceiver {

  Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private ChefService chefService;

  @RabbitListener(queues = "#{autoDeleteQueue1.name}")
  public void receiving(Order4RabbitMq order4RabbitMq) {
    logger.info("receiving chef stuff: {}", order4RabbitMq.getOrderId());

    // add food in here
    chefService.cookFood(order4RabbitMq);
  }
}
