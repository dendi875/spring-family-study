package com.zq.springcloudresilience4jratelimiterprovider.repository;

import com.zq.springcloudresilience4jratelimiterprovider.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

	List<Coffee> findByNameInOrderById(List<String> list);

	Coffee findByName(String name);

}
