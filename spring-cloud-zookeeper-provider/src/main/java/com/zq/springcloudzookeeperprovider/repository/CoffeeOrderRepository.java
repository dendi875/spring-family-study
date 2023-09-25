package com.zq.springcloudzookeeperprovider.repository;

import com.zq.springcloudzookeeperprovider.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

