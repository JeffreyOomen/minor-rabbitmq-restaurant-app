package com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Dish;
import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order4RabbitMq;
import com.infosupport.minor.rabbit_mq_restaurant_app.services.DishService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMqReceiver {

  Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private DishService dishService;

  @RabbitListener(queues = "#{autoDeleteQueue1.name}")
  public void isApproved(Order4RabbitMq order4RabbitMq) {
    this.dishService.approveDishes(order4RabbitMq);
  }
}
