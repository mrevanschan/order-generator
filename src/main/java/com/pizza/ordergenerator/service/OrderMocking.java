package com.pizza.ordergenerator.service;

import com.pizza.ordergenerator.model.OrderRequest;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@ConfigurationProperties(prefix = "pizza")
public class OrderMocking {
    private Map<String, BigDecimal> menu;
    private ArrayList<String> pizzaList;
    Random random = new Random();

    @PostConstruct
    private void init(){
        menu = new HashMap<>();
        pizzaList = new ArrayList<>();
        pizzaList.add("Veggie Pizza");
        pizzaList.add("Pepperoni Pizza");
        pizzaList.add("Meat Pizza");
        pizzaList.add("Margherita Pizza");
        pizzaList.add("Hawaiian Pizza");
        menu.put("Veggie Pizza",new BigDecimal(100));
        menu.put("Pepperoni Pizza",new BigDecimal(120));
        menu.put("Meat Pizza",new BigDecimal(150));
        menu.put("Margherita Pizza",new BigDecimal(105));
        menu.put("Hawaiian Pizza",new BigDecimal(160));
    }

    public OrderRequest generateRandomOrder(){
        int quantity = random.nextInt(10)+1;
        return generateOrder(pizzaList.get(random.nextInt(pizzaList.size())),quantity);
    }

    public OrderRequest generateOrder(String name,int quantity){
        return new OrderRequest(name,quantity,menu.get(name).multiply(BigDecimal.valueOf(quantity)));
    }

}
