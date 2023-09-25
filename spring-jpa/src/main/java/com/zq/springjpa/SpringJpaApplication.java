package com.zq.springjpa;

import com.zq.springjpa.model.Coffee;
import com.zq.springjpa.model.CoffeeOrder;
import com.zq.springjpa.repository.CoffeeOrderRepository;
import com.zq.springjpa.repository.CoffeeRepository;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@EnableJpaRepositories
public class SpringJpaApplication implements ApplicationRunner {

	@Autowired
	private CoffeeRepository coffeeRepository;

	@Autowired
	private CoffeeOrderRepository coffeeOrderRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		insertOrder();
	}

	private void insertOrder() {
		Coffee rx = Coffee.builder().name("瑞幸")
				.price(Money.of(CurrencyUnit.of("CNY"), 20.0))
				.build();
		coffeeRepository.save(rx);

		Coffee nt = Coffee.builder().name("拿铁")
				.price(Money.of(CurrencyUnit.of("CNY"), 30.0))
				.build();
		coffeeRepository.save(nt);

		CoffeeOrder order = CoffeeOrder.builder()
				.customer("张三")
				.items(Collections.singletonList(rx))
				.state(0)
				.build();
		coffeeOrderRepository.save(order);

		order = CoffeeOrder.builder()
				.customer("李四")
				.items(Arrays.asList(rx, nt))
				.state(0)
				.build();
		coffeeOrderRepository.save(order);
	}
}
