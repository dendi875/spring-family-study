package com.zq.springscheduledapplicationeventcustromer.integration;

import com.zq.springscheduledapplicationeventcustromer.model.Coffee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "waiter-service:8888", contextId = "coffee", path = "/coffee",
		qualifier = "coffeeService", fallback = FallbackCoffeeService.class
)
public interface CoffeeService {
	@GetMapping(path = "/", params = "!name")
	List<Coffee> getAll();

	@GetMapping("/{id}")
	Coffee getById(@PathVariable Long id);

	@GetMapping(path = "/", params = "name")
	Coffee getByName(@RequestParam String name);
}

