package com.zq.springredistemplate.repository;

import com.zq.springredistemplate.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}

