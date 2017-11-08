package com.infosupport.minor.rabbit_mq_restaurant_app.services;

import com.infosupport.minor.rabbit_mq_restaurant_app.dao.DishRepository;
import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Dish;
import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order4RabbitMq;
import com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq.RabbitMqSender;
import java.util.ArrayList;
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
    List<Dish> dishes = new ArrayList<>();
    for (int dishId : order4RabbitMq.getDishIds()) {
      Dish dish = dishRepository.findOne(dishId);
      dishes.add(dish);
      if (dish.getStockAmount() <= 0) {
        isApproved = false;
      }
    }

    if (isApproved) {
      for (Dish dish : dishes) {
        dish.setStockAmount(dish.getStockAmount() - 1);
        this.dishRepository.save(dish);
      }
    }

    rabbitMqSender.dishesStatus(order4RabbitMq, isApproved);
  }
}
