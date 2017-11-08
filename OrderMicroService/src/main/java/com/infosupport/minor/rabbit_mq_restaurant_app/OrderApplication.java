package com.infosupport.minor.rabbit_mq_restaurant_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by jeffreyoomen on 07/11/2017.
 */
@SpringBootApplication
@EnableScheduling
public class OrderApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrderApplication.class);

  }
}
