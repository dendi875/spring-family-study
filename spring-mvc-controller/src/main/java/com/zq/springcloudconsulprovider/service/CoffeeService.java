package com.zq.springcloudconsulprovider.service;


import com.zq.springcloudconsulprovider.model.Coffee;
import com.zq.springcloudconsulprovider.repository.CoffeeRepository;
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

	public List<Coffee> getCoffeeByName(List<String> names) {
		return coffeeRepository.findByNameInOrderById(names);
	}
}
