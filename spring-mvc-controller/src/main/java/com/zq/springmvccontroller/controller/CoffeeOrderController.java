package com.zq.springmvccontroller.controller;

import com.zq.springmvccontroller.controller.request.NewOrderRequest;
import com.zq.springmvccontroller.model.Coffee;
import com.zq.springmvccontroller.model.CoffeeOrder;
import com.zq.springmvccontroller.service.CoffeeOrderService;
import com.zq.springmvccontroller.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class CoffeeOrderController {

	@Autowired
	private CoffeeService coffeeService;

	@Autowired
	private CoffeeOrderService orderService;

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public CoffeeOrder create(@RequestBody NewOrderRequest newOrder) {
		log.info("Receive new Order {}", newOrder);
		Coffee[] coffeeList = coffeeService.getCoffeeByName(newOrder.getItems())
				.toArray(new Coffee[] {});
		return orderService.createOrder(newOrder.getCustomer(), coffeeList);
	}
}
