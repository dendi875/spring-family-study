package com.zq.rabbitbaristaservice.repository;

import com.zq.rabbitbaristaservice.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
