package com.zq.springcloudstreamrabbitmqwaiterservice.repository;

import com.zq.springcloudstreamrabbitmqwaiterservice.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

