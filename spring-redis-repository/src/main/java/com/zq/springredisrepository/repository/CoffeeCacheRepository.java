package com.zq.springredisrepository.repository;

import com.zq.springredisrepository.model.CoffeeCache;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoffeeCacheRepository extends CrudRepository<CoffeeCache, Long> {
	Optional<CoffeeCache> findOneByName(String name);
}
