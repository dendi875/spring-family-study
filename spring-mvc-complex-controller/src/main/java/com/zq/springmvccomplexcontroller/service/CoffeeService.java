package com.zq.springmvccomplexcontroller.service;


import com.zq.springmvccomplexcontroller.model.Coffee;
import com.zq.springmvccomplexcontroller.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@CacheConfig(cacheNames = "CoffeeCache")
public class CoffeeService {
	@Autowired
	private CoffeeRepository coffeeRepository;

	@Cacheable
	public List<Coffee> getAllCoffee() {
		return coffeeRepository.findAll(Sort.by("id"));
	}


	public Coffee getCoffee(Long id) {
		return coffeeRepository.getOne(id);
	}

	public Coffee getCoffee(String name) {
		return coffeeRepository.findByName(name);
	}

	public List<Coffee> getCoffeeByName(List<String> names) {
		return coffeeRepository.findByNameInOrderById(names);
	}
}
