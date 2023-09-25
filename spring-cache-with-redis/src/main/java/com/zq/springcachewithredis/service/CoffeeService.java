package com.zq.springcachewithredis.service;

import com.zq.springcachewithredis.model.Coffee;
import com.zq.springcachewithredis.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@CacheConfig(cacheNames = "coffee")
@Slf4j
@Service
public class CoffeeService {
	@Autowired
	private CoffeeRepository coffeeRepository;

	public Optional<Coffee> findOneCoffee(String name) {
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("name", exact().ignoreCase());
		Optional<Coffee> coffee = coffeeRepository.findOne(
				Example.of(Coffee.builder().name(name).build(), matcher));
		log.info("Coffee Found: {}", coffee);
		return coffee;
	}

	@CacheEvict
	public void reloadCoffee() {
	}

	@Cacheable
	public List<Coffee> findAllCoffee() {
		return coffeeRepository.findAll();
	}
}