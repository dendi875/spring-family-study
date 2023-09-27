package com.zq.springcloudstreamrabbitmqbaristaservice;

import com.zq.springcloudstreamrabbitmqbaristaservice.integration.Waiter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableBinding(Waiter.class)
@EnableJpaRepositories
@SpringBootApplication
public class SpringCloudStreamRabbitmqBaristaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamRabbitmqBaristaServiceApplication.class, args);
	}

}
