package com.zq.springcloudconfigzookeeper.repository;

import com.zq.springcloudconfigzookeeper.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

