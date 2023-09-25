package com.zq.springbootwebservertomcat.repository;

import com.zq.springbootwebservertomcat.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

