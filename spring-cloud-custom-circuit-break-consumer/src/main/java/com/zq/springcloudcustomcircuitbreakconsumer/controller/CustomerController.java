package com.zq.springcloudcustomcircuitbreakconsumer.controller;

import com.zq.springcloudcustomcircuitbreakconsumer.integration.CoffeeOrderService;
import com.zq.springcloudcustomcircuitbreakconsumer.integration.CoffeeService;
import com.zq.springcloudcustomcircuitbreakconsumer.model.Coffee;
import com.zq.springcloudcustomcircuitbreakconsumer.model.CoffeeOrder;
import com.zq.springcloudcustomcircuitbreakconsumer.model.NewOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
	@Autowired
	private CoffeeService coffeeService;
	@Autowired
	private CoffeeOrderService coffeeOrderService;

	@GetMapping("/menu")
	public List<Coffee> readMenu() {
		List<Coffee> list = coffeeService.getAll();
		return list == null ? Collections.emptyList() : list;
	}

	@PostMapping("/order")
	public CoffeeOrder createOrder() {
		NewOrderRequest orderRequest = NewOrderRequest.builder()
				.customer("Li Lei")
				.items(Arrays.asList("capuccino"))
				.build();
		CoffeeOrder order = coffeeOrderService.create(orderRequest);
		log.info("Order ID: {}", order != null ? order.getId() : "-");
		return order;
	}
}