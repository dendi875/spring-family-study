package com.zq.springcloudstreamkafkawaiterservice.controller;

import com.zq.springcloudstreamkafkawaiterservice.controller.request.NewOrderRequest;
import com.zq.springcloudstreamkafkawaiterservice.controller.request.OrderStateRequest;
import com.zq.springcloudstreamkafkawaiterservice.model.Coffee;
import com.zq.springcloudstreamkafkawaiterservice.model.CoffeeOrder;
import com.zq.springcloudstreamkafkawaiterservice.service.CoffeeOrderService;
import com.zq.springcloudstreamkafkawaiterservice.service.CoffeeService;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
@Slf4j
public class CoffeeOrderController {
	@Autowired
	private CoffeeOrderService orderService;
	@Autowired
	private CoffeeService coffeeService;

	private RateLimiter rateLimiter;

	public CoffeeOrderController(RateLimiterRegistry rateLimiterRegistry) {
		rateLimiter = rateLimiterRegistry.rateLimiter("order");
	}

	@GetMapping("/{id}")
	public CoffeeOrder getOrder(@PathVariable("id") Long id) {
		CoffeeOrder order = null;
		try {
			order = rateLimiter.executeSupplier(() -> orderService.get(id));
			log.info("Get Order: {}", order);
		} catch(RequestNotPermitted e) {
			log.warn("Request Not Permitted! {}", e.getMessage());
		}
		return order;
	}

	@io.github.resilience4j.ratelimiter.annotation.RateLimiter(name = "order")
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public CoffeeOrder create(@RequestBody NewOrderRequest newOrder) {
		log.info("Receive new Order {}", newOrder);
		Coffee[] coffeeList = coffeeService.getCoffeeByName(newOrder.getItems())
				.toArray(new Coffee[] {});
		return orderService.createOrder(newOrder.getCustomer(), coffeeList);
	}

	@PutMapping("/{id}")
	public CoffeeOrder updateState(@PathVariable("id") Long id,
								   @RequestBody OrderStateRequest orderState) {
		log.info("Update order state: {}", orderState);
		CoffeeOrder order = orderService.get(id);
		orderService.updateState(order, orderState.getState());
		return order;
	}
}
