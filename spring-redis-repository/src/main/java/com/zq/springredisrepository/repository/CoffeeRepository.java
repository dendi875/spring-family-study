package com.zq.springredisrepository.repository;

import com.zq.springredisrepository.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}

