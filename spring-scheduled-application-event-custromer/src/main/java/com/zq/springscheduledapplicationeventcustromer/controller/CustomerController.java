package com.zq.springscheduledapplicationeventcustromer.controller;

import com.zq.springscheduledapplicationeventcustromer.integration.CoffeeOrderService;
import com.zq.springscheduledapplicationeventcustromer.integration.CoffeeService;
import com.zq.springscheduledapplicationeventcustromer.model.Coffee;
import com.zq.springscheduledapplicationeventcustromer.model.CoffeeOrder;
import com.zq.springscheduledapplicationeventcustromer.model.NewOrderRequest;
import com.zq.springscheduledapplicationeventcustromer.model.OrderState;
import com.zq.springscheduledapplicationeventcustromer.model.OrderStateRequest;
import com.zq.springscheduledapplicationeventcustromer.support.OrderWaitingEvent;
import io.github.resilience4j.circuitbreaker.CircuitBreakerOpenException;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
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
public class CustomerController implements ApplicationEventPublisherAware {
	@Autowired
	private CoffeeService coffeeService;
	@Autowired
	private CoffeeOrderService coffeeOrderService;

	private CircuitBreaker circuitBreaker;

	private ApplicationEventPublisher applicationEventPublisher;

	public CustomerController(CircuitBreakerRegistry registry) {
		circuitBreaker = registry.circuitBreaker("menu");
	}

	@GetMapping("/menu")
	public List<Coffee> readMenu() {
		return Try.ofSupplier(CircuitBreaker.decorateSupplier(circuitBreaker, () -> coffeeService.getAll()))
				.recover(CircuitBreakerOpenException.class, Collections.emptyList())
				.get();
	}

	@PostMapping("/order")
	@io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "order")
	public CoffeeOrder createAndPayOrder() {
		NewOrderRequest orderRequest = NewOrderRequest.builder()
				.customer("Li Lei")
				.items(Arrays.asList("capuccino"))
				.build();
		CoffeeOrder order = coffeeOrderService.create(orderRequest);
		log.info("Create order: {}", order != null ? order.getId() : "-");
		order = coffeeOrderService.updateState(order.getId(),
				OrderStateRequest.builder().state(OrderState.PAID).build());
		log.info("Order is PAID: {}", order);
		applicationEventPublisher.publishEvent(new OrderWaitingEvent(order));
		return order;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
}