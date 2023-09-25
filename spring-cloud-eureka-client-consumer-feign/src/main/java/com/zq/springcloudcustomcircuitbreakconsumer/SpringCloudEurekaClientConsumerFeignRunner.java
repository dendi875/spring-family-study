package com.zq.springcloudcustomcircuitbreakconsumer;

import com.zq.springcloudcustomcircuitbreakconsumer.integration.CoffeeOrderService;
import com.zq.springcloudcustomcircuitbreakconsumer.integration.CoffeeService;
import com.zq.springcloudcustomcircuitbreakconsumer.model.Coffee;
import com.zq.springcloudcustomcircuitbreakconsumer.model.CoffeeOrder;
import com.zq.springcloudcustomcircuitbreakconsumer.model.NewOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class SpringCloudEurekaClientConsumerFeignRunner implements ApplicationRunner {

	@Autowired
	private CoffeeService coffeeService;
	@Autowired
	private CoffeeOrderService coffeeOrderService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		readMenu();
		Long id = orderCoffee();
		queryOrder(id);
	}

	private void readMenu() {
		List<Coffee> coffees = coffeeService.getAll();
		coffees.forEach(c -> log.info("Coffee: {}", c));
	}

	private Long orderCoffee() {
		NewOrderRequest orderRequest = NewOrderRequest.builder()
				.customer("Li Lei")
				.items(Arrays.asList("capuccino"))
				.build();
		CoffeeOrder order = coffeeOrderService.create(orderRequest);
		log.info("Order ID: {}", order.getId());
		return order.getId();
	}

	private void queryOrder(Long id) {
		CoffeeOrder order = coffeeOrderService.getOrder(id);
		log.info("Order: {}", order);
	}

}
