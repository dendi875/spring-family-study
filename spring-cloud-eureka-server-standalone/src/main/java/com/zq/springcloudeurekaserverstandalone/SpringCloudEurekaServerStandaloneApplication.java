package com.zq.springcloudeurekaserverstandalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // EnableEurekaServer 来标识该服务为Eureka Server。
@SpringBootApplication
public class SpringCloudEurekaServerStandaloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaServerStandaloneApplication.class, args);
	}

}
