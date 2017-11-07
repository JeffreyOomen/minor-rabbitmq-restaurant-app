package com.infosupport.minor.rabbit_mq_restaurant_app.controller;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order;
import com.infosupport.minor.rabbit_mq_restaurant_app.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/order")
    public void placeOrder(@RequestBody String dishIds) {// receiving 1 order id
        logger.info("placeOrder: {}", dishIds);

        Order order = new Order();
        order.setDishId(1);
        order.setDishId(Integer.parseInt(dishIds));

        // TODO: you don't get an Object of Order here, but a String array of the dish ids,
        // TODO a Order object should be constructed here and placed (or in service?).
        // Yoshua: I think in the service; the controller does the least possible amount of work. (just doing it here now cuz qck nd drty
        orderService.placeOrder(order);
    }

}
