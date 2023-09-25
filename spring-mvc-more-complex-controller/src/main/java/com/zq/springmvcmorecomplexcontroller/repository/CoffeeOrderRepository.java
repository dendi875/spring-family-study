package com.zq.springmvcmorecomplexcontroller.repository;

import com.zq.springmvcmorecomplexcontroller.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

