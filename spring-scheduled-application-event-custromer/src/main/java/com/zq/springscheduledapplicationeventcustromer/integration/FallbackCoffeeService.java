package com.zq.springscheduledapplicationeventcustromer.integration;

import com.zq.springscheduledapplicationeventcustromer.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class FallbackCoffeeService implements CoffeeService {
	@Override
	public List<Coffee> getAll() {
		log.warn("Fallback to EMPTY menu.");
		return Collections.emptyList();
	}

	@Override
	public Coffee getById(Long id) {
		return null;
	}

	@Override
	public Coffee getByName(String name) {
		return null;
	}
}