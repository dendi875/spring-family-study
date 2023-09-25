package com.zq.springmvcjsonview.repository;

import com.zq.springmvcjsonview.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

