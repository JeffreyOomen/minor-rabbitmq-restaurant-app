package com.infosupport.minor.rabbit_mq_restaurant_app.dao;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
