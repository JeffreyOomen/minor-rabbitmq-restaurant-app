package com.infosupport.minor.rabbit_mq_restaurant_app.services;

import com.infosupport.minor.rabbit_mq_restaurant_app.dao.DishRepository;
import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Dish;
import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order4RabbitMq;
import com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq.RabbitMqSender;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService {

  private DishRepository dishRepository;

  @Autowired
  public void setCursusDao(DishRepository dishRepository) {
    this.dishRepository = dishRepository;
  }

  @Autowired
  private RabbitMqSender rabbitMqSender;

  public List<Dish> findDishes() {
    return this.dishRepository.findAll();
  }

  public void approveDishes(Order4RabbitMq order4RabbitMq) {
    boolean isApproved = true;
    for (int dishId : order4RabbitMq.getDishIds()) {
      Dish dish = dishRepository.findOne(dishId);
      if (dish.getStockAmount() <= 0) {
        isApproved = false;
      }
    }

    rabbitMqSender.dishesStatus(order4RabbitMq, isApproved);
  }
}
