package com.infosupport.minor.rabbit_mq_restaurant_app.rabbitmq;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMqSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send() {
        template.convertAndSend(queue.getName(), "");
    }
}
