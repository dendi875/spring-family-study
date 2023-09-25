package com.zq.springcloudeurekaclientprovider.repository;

import com.zq.springcloudeurekaclientprovider.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

