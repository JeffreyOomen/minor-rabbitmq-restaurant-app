package com.infosupport.minor.rabbit_mq_restaurant_app.services;

import com.infosupport.minor.rabbit_mq_restaurant_app.dao.DishRepository;
import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    private DishRepository dishRepository;

    @Autowired
    public void setCursusDao(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }


    public List<Dish> findDishes() {
        return this.dishRepository.findAll();
    }
}
