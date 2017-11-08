package com.infosupport.minor.rabbit_mq_restaurant_app.dao;

import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order;
import com.infosupport.minor.rabbit_mq_restaurant_app.domain.Order.Status;
import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jeffreyoomen on 08/11/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderRepositoryTest {

  @Autowired
  private OrderRepository orderRepository;

  @PersistenceContext
  private EntityManager em;

  @Test
  public void asd() {
    Order order = new Order();
    order.setStatus(Status.REQUESTED);
    order.setDishIds(Arrays.asList(1, 2));

    orderRepository.save(order);
    em.flush();
    em.clear();

    Order managedOrder = em.find(Order.class, 1L);
    System.out.println(managedOrder);
  }
}
