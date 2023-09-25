package com.zq.springmvccomplexcontroller.repository;

import com.zq.springmvccomplexcontroller.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

