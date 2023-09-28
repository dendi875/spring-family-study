package com.zq.springcloudstreamkafkabaristaservice.repository;

import com.zq.springcloudstreamkafkabaristaservice.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
