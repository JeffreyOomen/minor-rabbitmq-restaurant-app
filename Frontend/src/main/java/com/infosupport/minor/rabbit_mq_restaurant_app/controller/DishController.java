package com.infosupport.minor.rabbit_mq_restaurant_app.controller;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Dish;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class DishController {

  @Autowired
  private RestTemplate restTemplate;
  private List<Dish> dishes;

  @GetMapping(value = "/")
  public String getDishes(Model model) {
    // MS2 getDishes()
    ResponseEntity<List<Dish>> dishReponse = restTemplate
        .exchange("http://127.0.0.1:8081/dishes", HttpMethod.GET, null,
            new ParameterizedTypeReference<List<Dish>>() {
            });
    System.out.println(dishReponse.getBody());
    model.addAttribute("dishes", dishReponse.getBody());

    return "dish/dish_overview";
  }

}
