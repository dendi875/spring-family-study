package com.zq.springcloudconfigconsul.repository;

import com.zq.springcloudconfigconsul.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

