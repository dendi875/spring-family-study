package com.zq.springscheduledapplicationeventcustromer.integration;

import com.zq.springscheduledapplicationeventcustromer.model.CoffeeOrder;
import com.zq.springscheduledapplicationeventcustromer.model.NewOrderRequest;
import com.zq.springscheduledapplicationeventcustromer.model.OrderStateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "waiter-service:8888", contextId = "coffeeOrder")
public interface CoffeeOrderService {
	@GetMapping("/order/{id}")
	CoffeeOrder getOrder(@PathVariable("id") Long id);

	@PostMapping(path = "/order/", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	CoffeeOrder create(@RequestBody NewOrderRequest newOrder);

	@PutMapping("/order/{id}")
	CoffeeOrder updateState(@PathVariable("id") Long id,
							@RequestBody OrderStateRequest orderState);
}