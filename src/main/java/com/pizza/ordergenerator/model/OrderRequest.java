package com.pizza.ordergenerator.model;

import lombok.Data;

import java.math.BigDecimal;

@Data

public class OrderRequest {
    String name;
    Integer quantity;
    BigDecimal price;

    public OrderRequest(String name, Integer quantity, BigDecimal price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
