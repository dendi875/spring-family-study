package com.zq.springdataresethateoasprovider.repository;

import com.zq.springdataresethateoasprovider.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
