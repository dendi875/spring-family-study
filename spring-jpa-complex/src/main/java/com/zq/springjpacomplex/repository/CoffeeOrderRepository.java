package com.zq.springjpacomplex.repository;

import com.zq.springjpacomplex.model.CoffeeOrder;

import java.util.List;

public interface CoffeeOrderRepository extends BaseRepository<CoffeeOrder, Long> {
	List<CoffeeOrder> findByCustomerOrderById(String customer);
	List<CoffeeOrder> findByItems_Name(String name);
}

