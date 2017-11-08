package com.infosupport.minor.rabbit_mq_restaurant_app.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Status status;

  @ElementCollection()
  private List<Integer> dishIds;

  public Order() {
  }

  public Order(Long id, Status status) {
    this.id = id;
    this.status = status;
    this.dishIds = new ArrayList<>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public List<Integer> getDishIds() {
    return dishIds;
  }

  public void setDishIds(List<Integer> dishIds) {
    this.dishIds = dishIds;
  }

  public enum Status {
    REQUESTED,
    PROCESSING,
    COMPLETED,
    CANCELLED
  }
}
