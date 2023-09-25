package com.zq.springcachewithredis.repository;

import com.zq.springcachewithredis.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}

