package com.zq.springcloudhystrixcircuitbreakconsumer.integration;

import com.zq.springcloudhystrixcircuitbreakconsumer.model.CoffeeOrder;
import com.zq.springcloudhystrixcircuitbreakconsumer.model.NewOrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "spring-cloud-consul-provider", contextId = "coffeeOrder")
public interface CoffeeOrderService {
	@GetMapping("/order/{id}")
	CoffeeOrder getOrder(@PathVariable("id") Long id);

	@PostMapping(path = "/order/", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	CoffeeOrder create(@RequestBody NewOrderRequest newOrder);
}