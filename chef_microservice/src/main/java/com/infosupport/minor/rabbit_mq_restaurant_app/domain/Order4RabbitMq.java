package com.infosupport.minor.rabbit_mq_restaurant_app.domain;

import java.io.Serializable;

public class Order4RabbitMq implements Serializable {

  private int[] dishIds;
  private int orderId;

  public Order4RabbitMq() {
  }

  public Order4RabbitMq(int[] dishIds, int orderId) {
    this.dishIds = dishIds;
    this.orderId = orderId;
  }

  public int[] getDishIds() {
    return dishIds;
  }

  public void setDishIds(int[] dishIds) {
    this.dishIds = dishIds;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }
}
