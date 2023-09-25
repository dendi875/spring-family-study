package com.zq.springmvcthymeleafview.repository;

import com.zq.springmvcthymeleafview.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

