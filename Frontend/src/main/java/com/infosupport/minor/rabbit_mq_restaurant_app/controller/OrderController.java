package com.infosupport.minor.rabbit_mq_restaurant_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class OrderController {

  @Autowired
  private RestTemplate restTemplate;

  private Logger logger = LoggerFactory.getLogger(getClass());

  @PostMapping(value = "/order")
  public String placeOrder(@RequestParam("selectedDishes") String[] selectedDishes) {
    logger.info("placeOrder: {}", selectedDishes);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    // only sending first dish always
    HttpEntity<String> request = new HttpEntity<>(selectedDishes[0], headers);
    restTemplate.postForLocation("http://127.0.0.1:8082/order", request);

    return "redirect:/";
  }

}
