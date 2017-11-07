package com.infosupport.minor.rabbit_mq_restaurant_app.controller;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DishController {

    @Autowired
    private RestTemplate restTemplate;
    private List<Dish> dishes;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getDishes() {
        // MS2 getDishes()
        ResponseEntity<List<Dish>> dishReponse = restTemplate.exchange("http://127.0.0.1:8081/dishes", HttpMethod.GET, null, new ParameterizedTypeReference<List<Dish>>() {});
        System.out.println(dishReponse.getBody());

        return "dish/dish_overview";
    }
}
