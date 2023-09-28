package com.zq.springscheduledapplicationeventcustromer;

import com.zq.springscheduledapplicationeventcustromer.support.CustomConnectionKeepAliveStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.TimeUnit;

@EnableScheduling
@EnableAspectJAutoProxy
@EnableFeignClients
@EnableDiscoveryClient
@Slf4j
@SpringBootApplication
public class SpringScheduledApplicationEventCustromerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringScheduledApplicationEventCustromerApplication.class, args);
	}

	@Bean
	public CloseableHttpClient httpClient() {
		return HttpClients.custom()
				.setConnectionTimeToLive(30, TimeUnit.SECONDS)
				.evictIdleConnections(30, TimeUnit.SECONDS)
				.setMaxConnTotal(200)
				.setMaxConnPerRoute(20)
				.disableAutomaticRetries()
				.setKeepAliveStrategy(new CustomConnectionKeepAliveStrategy())
				.build();
	}
}
