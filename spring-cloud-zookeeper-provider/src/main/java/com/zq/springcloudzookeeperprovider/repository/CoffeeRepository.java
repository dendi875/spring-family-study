package com.zq.springcloudzookeeperprovider.repository;

import com.zq.springcloudzookeeperprovider.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

	List<Coffee> findByNameInOrderById(List<String> list);

	Coffee findByName(String name);

}
