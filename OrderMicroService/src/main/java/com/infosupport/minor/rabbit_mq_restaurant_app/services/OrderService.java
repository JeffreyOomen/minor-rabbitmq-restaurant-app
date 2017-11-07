package com.infosupport.minor.rabbit_mq_restaurant_app.services;

import com.infosupport.minor.rabbit_mq_restaurant_app.dao.OrderRepository;
import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order;
import com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    private RabbitMqSender rabbitMqSender;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(Order order) {
        this.orderRepository.save(order);

        // TODO: send PLACE_ORDER_EVENT here
        //this.rabbitMqSender.send(order.getId());
    }
}
