package com.zq.springcloudstreamkafkabaristaservice;

import com.zq.springcloudstreamkafkabaristaservice.integration.Waiter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableBinding(Waiter.class)
@EnableJpaRepositories
@SpringBootApplication
public class SpringCloudStreamKafkaBaristaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamKafkaBaristaServiceApplication.class, args);
	}

}
