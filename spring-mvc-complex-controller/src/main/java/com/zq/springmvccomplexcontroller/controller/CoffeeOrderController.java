package com.zq.springmvccomplexcontroller.controller;

import com.zq.springmvccomplexcontroller.controller.request.NewOrderRequest;
import com.zq.springmvccomplexcontroller.model.Coffee;
import com.zq.springmvccomplexcontroller.model.CoffeeOrder;
import com.zq.springmvccomplexcontroller.service.CoffeeOrderService;
import com.zq.springmvccomplexcontroller.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public CoffeeOrder create(@RequestBody NewOrderRequest newOrder) {
		log.info("Receive new Order {}", newOrder);
		Coffee[] coffeeList = coffeeService.getCoffeeByName(newOrder.getItems())
				.toArray(new Coffee[] {});
		return orderService.createOrder(newOrder.getCustomer(), coffeeList);
	}

	@GetMapping("/{id}")
	public CoffeeOrder getOrder(@PathVariable("id") Long id) {
		return orderService.get(id);
	}
}
