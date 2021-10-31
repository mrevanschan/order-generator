package com.pizza.ordergenerator.client;

import com.pizza.ordergenerator.model.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "orderClient", url = "${serviceHost}")
public interface OrderClient {
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity postOrder(@RequestBody OrderRequest order);
}
