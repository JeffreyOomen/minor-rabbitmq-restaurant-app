package com.infosupport.minor.rabbit_mq_restaurant_app.services;

import com.infosupport.minor.rabbit_mq_restaurant_app.dao.OrderRepository;
import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order;
import com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RabbitMqSender rabbitMqSender;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(Order order) {
//        orderRepository.save(order);
        // commented because of this: org.h2.jdbc.JdbcSQLException: Syntax error in SQL statement "INSERT INTO ORDER[*] (ID, DISH_ID, STATUS) VALUES (NULL, ?, ?) "; expected "identifier"; SQL statement:
//        insert into order (id, dish_id, status) values (null, ?, ?) [42001-196]

        // TODO: send PLACE_ORDER_EVENT here
        rabbitMqSender.send(order.getDishId());
    }
}
