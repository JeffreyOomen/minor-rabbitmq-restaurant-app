package com.infosupport.minor.rabbit_mq_restaurant_app.controller;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order;
import com.infosupport.minor.rabbit_mq_restaurant_app.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public void placeOrder(@RequestBody Order order) {
        // TODO: you don't get an Object of Order here, but a String array of the dish ids,
        // TODO a Order object should be constructed here and placed (or in service?).
        orderService.placeOrder(order);
    }
}
