package com.pizza.ordergenerator;

import com.pizza.ordergenerator.model.OrderRequest;
import com.pizza.ordergenerator.service.OrderMocking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderGeneratorApplicationTests {
	@Autowired
	OrderMocking orderMocking;

	@Test
	void mockOrder_1() {
		OrderRequest order = orderMocking.generateOrder("Margherita Pizza",1);
		assertEquals("Margherita Pizza",order.getName());
		assertEquals(new BigDecimal(105),order.getPrice());
		assertEquals(1,order.getQuantity());
	}
	@Test
	void mockOrder_2() {
		OrderRequest order = orderMocking.generateOrder("Margherita Pizza",2);
		assertEquals("Margherita Pizza",order.getName());
		assertEquals(new BigDecimal(210),order.getPrice());
		assertEquals(2,order.getQuantity());
	}

}
