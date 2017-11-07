package com.infosupport.minor.rabbit_mq_restaurant_app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dish {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int price;

    private int stockAmount;

    public Dish() {}

    public Dish(int id, String name, int price, int stockAmount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockAmount = stockAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
