package com.zq.springcloudconsulprovider.repository;

import com.zq.springcloudconsulprovider.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

