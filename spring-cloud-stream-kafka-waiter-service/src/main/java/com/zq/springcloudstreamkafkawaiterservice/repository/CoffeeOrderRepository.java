package com.zq.springcloudstreamkafkawaiterservice.repository;

import com.zq.springcloudstreamkafkawaiterservice.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

