package com.infosupport.minor.rabbit_mq_restaurant_app.controller;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class OrderController {

  @Autowired
  private RestTemplate restTemplate;

  private Logger logger = LoggerFactory.getLogger(getClass());

  @PostMapping(value = "/order")
  public String placeOrder(@RequestParam("selectedDishes") Integer[] selectedDishesArray) {
    List<Integer> selectedDishes = Arrays.asList(selectedDishesArray);
    logger.info("placeOrder: {}", selectedDishes);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    // only sending first dish always
    HttpEntity<List<Integer>> request = new HttpEntity<>(selectedDishes, headers);
    restTemplate.postForLocation("http://127.0.0.1:8082/order", request);

    return "redirect:/";
  }

  @GetMapping(value = "/order/{id}")
  public String getOrder(@PathVariable("id") int orderId, Model model) {
    logger.info("getOrder: {}", orderId);

    Order order = restTemplate.getForObject("http://127.0.0.1:8082/order/" + orderId, Order.class);
    model.addAttribute("order", order);

    return "dish/order";
  }

}
