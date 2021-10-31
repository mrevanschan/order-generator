package com.pizza.ordergenerator.service;

import com.pizza.ordergenerator.client.OrderClient;
import com.pizza.ordergenerator.model.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderGeneratingScheduler {

    @Autowired
    OrderMocking orderMockingService;
    @Autowired
    OrderClient orderClient;

    @Scheduled(fixedRate = 5000)
    private void orderGenerating(){
        OrderRequest order = orderMockingService.generateRandomOrder();
        try{
            orderClient.postOrder(order);
            log.info("Order message delivered - "+ order);
        }catch(Exception e){
            log.error("Order message failed - " + order +" : "+ e.getMessage());
        }
    }
}
