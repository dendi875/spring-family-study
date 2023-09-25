package com.zq.springmvcinterceptor.repository;

import com.zq.springmvcinterceptor.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

