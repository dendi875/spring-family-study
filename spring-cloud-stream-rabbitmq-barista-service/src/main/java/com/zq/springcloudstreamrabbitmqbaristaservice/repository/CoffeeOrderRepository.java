package com.zq.springcloudstreamrabbitmqbaristaservice.repository;

import com.zq.springcloudstreamrabbitmqbaristaservice.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
