package com.zq.springbootexecutablejar.repository;

import com.zq.springbootexecutablejar.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

