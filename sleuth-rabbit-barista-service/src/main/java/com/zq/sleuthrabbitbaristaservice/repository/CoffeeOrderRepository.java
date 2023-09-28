package com.zq.sleuthrabbitbaristaservice.repository;

import com.zq.sleuthrabbitbaristaservice.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
