package com.zq.springcloudnacosprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableCaching
@SpringBootApplication
public class SpringMvcMoreComplexControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcMoreComplexControllerApplication.class, args);
	}

}
