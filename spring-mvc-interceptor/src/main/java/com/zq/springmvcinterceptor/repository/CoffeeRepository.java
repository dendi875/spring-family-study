package com.zq.springmvcinterceptor.repository;

import com.zq.springmvcinterceptor.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

	List<Coffee> findByNameInOrderById(List<String> list);

	Coffee findByName(String name);

}
