package com.zq.springbootactuatorindicator.repository;

import com.zq.springbootactuatorindicator.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

