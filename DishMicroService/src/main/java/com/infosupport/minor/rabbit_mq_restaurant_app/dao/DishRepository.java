package com.infosupport.minor.rabbit_mq_restaurant_app.dao;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {

}
