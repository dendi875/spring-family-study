package com.zq.springcloudconfigzookeeper.service;

import com.zq.springcloudconfigzookeeper.model.Coffee;
import com.zq.springcloudconfigzookeeper.model.CoffeeOrder;
import com.zq.springcloudconfigzookeeper.model.OrderState;
import com.zq.springcloudconfigzookeeper.repository.CoffeeOrderRepository;
import com.zq.springcloudconfigzookeeper.support.OrderProperties;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@Transactional
public class CoffeeOrderService implements MeterBinder {
	@Autowired
	private CoffeeOrderRepository orderRepository;

	@Autowired
	private OrderProperties orderProperties;

	private String waiterId = UUID.randomUUID().toString();

	private Counter orderCounter = null;

	public CoffeeOrder get(Long id) {
		return orderRepository.getOne(id);
	}

	public CoffeeOrder createOrder(String customer, Coffee...coffee) {
		CoffeeOrder order = CoffeeOrder.builder()
				.customer(customer)
				.items(new ArrayList<>(Arrays.asList(coffee)))
				.state(OrderState.INIT)
				.discount(orderProperties.getDiscount())
				.total(calcTotal(coffee))
				.waiter(orderProperties.getWaiterPrefix() + waiterId)
				.build();
		CoffeeOrder saved = orderRepository.save(order);
		log.info("New Order: {}", saved);
		orderCounter.increment();
		return saved;
	}

	public boolean updateState(CoffeeOrder order, OrderState state) {
		if (state.compareTo(order.getState()) <= 0) {
			log.warn("Wrong State order: {}, {}", state, order.getState());
			return false;
		}
		order.setState(state);
		orderRepository.save(order);
		log.info("Updated Order: {}", order);
		return true;
	}

	@Override
	public void bindTo(MeterRegistry meterRegistry) {
		this.orderCounter = meterRegistry.counter("order.count");
	}

	private Money calcTotal(Coffee...coffee) {
		List<Money> items = Stream.of(coffee).map(c -> c.getPrice())
				.collect(Collectors.toList());
		return Money.total(items).multipliedBy(orderProperties.getDiscount())
				.dividedBy(100, RoundingMode.HALF_UP);
	}
}