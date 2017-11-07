package com.infosupport.minor.rabbit_mq_restaurant_app;


import com.infosupport.minor.rabbit_mq_restaurant_app.dao.DishRepository;
import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DishApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DishApplication.class);
    }

    @Autowired
    private DishRepository dishRepository;

    @Override
    public void run(String... args) throws Exception {
        Dish dish1 = new Dish(1, "dish1", 31, 5);
        Dish dish2 = new Dish(2, "dish2", 40, 5);
        dishRepository.save(dish1);
        dishRepository.save(dish2);
    }
}
