package com.infosupport.minor.rabbit_mq_restaurant_app.domain;

public class Dish {

    private int id;

    private String name;

    private int stockAmount;

    public Dish() {
    }

    public Dish(int id, String name, int stockAmount) {
        this.id = id;
        this.name = name;
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

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
