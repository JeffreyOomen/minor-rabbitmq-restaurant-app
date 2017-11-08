package com.infosupport.minor.rabbit_mq_restaurant_app.controller;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order;
import com.infosupport.minor.rabbit_mq_restaurant_app.services.OrderService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;

  private Logger logger = LoggerFactory.getLogger(getClass());

  @PostMapping("/order")
  public void placeOrder(@RequestBody List<Integer> dishIds) {
    logger.info("placeOrder: {}", dishIds);

    orderService.placeOrder(dishIds);
  }

  @GetMapping("/order/{id}")
  public Order getOrder(@PathVariable("id") int orderId) {
    logger.info("getOrder: {}", orderId);

    return orderService.getOrderById(orderId);
  }

}
