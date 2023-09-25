package com.zq.springbootactuatormetrics.repository;

import com.zq.springbootactuatormetrics.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

