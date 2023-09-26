package com.zq.springcloudresilience4jratelimiterprovider.repository;

import com.zq.springcloudresilience4jratelimiterprovider.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

