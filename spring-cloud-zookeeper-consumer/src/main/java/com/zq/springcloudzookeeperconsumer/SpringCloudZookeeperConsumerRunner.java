package com.zq.springcloudzookeeperconsumer;

import com.zq.springcloudzookeeperconsumer.model.Coffee;
import com.zq.springcloudzookeeperconsumer.model.CoffeeOrder;
import com.zq.springcloudzookeeperconsumer.model.NewOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class SpringCloudZookeeperConsumerRunner implements ApplicationRunner {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		showServiceInstances();
		readMenu();
		Long id = orderCoffee();
		queryOrder(id);
	}

	private void showServiceInstances() {
		log.info("DiscoveryClient: {}", discoveryClient.getClass().getName());
		discoveryClient.getInstances("spring-cloud-zookeeper-provider").forEach(s -> {
			log.info("Provider Host: {}, Port: {}", s.getHost(), s.getPort());
		});
	}

	private void readMenu() {
		ParameterizedTypeReference<List<Coffee>> ptr =
				new ParameterizedTypeReference<List<Coffee>>() {};
		ResponseEntity<List<Coffee>> list = restTemplate
				.exchange("http://spring-cloud-zookeeper-provider/coffee/", HttpMethod.GET, null, ptr);
		list.getBody().forEach(c -> log.info("Coffee: {}", c));
	}

	private Long orderCoffee() {
		NewOrderRequest orderRequest = NewOrderRequest.builder()
				.customer("Li Lei")
				.items(Arrays.asList("capuccino"))
				.build();
		RequestEntity<NewOrderRequest> request = RequestEntity
				.post(UriComponentsBuilder.fromUriString("http://spring-cloud-zookeeper-provider/order/").build().toUri())
				.body(orderRequest);
		ResponseEntity<CoffeeOrder> response = restTemplate.exchange(request, CoffeeOrder.class);
		log.info("Order Request Status Code: {}", response.getStatusCode());
		Long id = response.getBody().getId();
		log.info("Order ID: {}", id);
		return id;
	}

	private void queryOrder(Long id) {
		CoffeeOrder order = restTemplate
				.getForObject("http://spring-cloud-zookeeper-provider/order/{id}", CoffeeOrder.class, id);
		log.info("Order: {}", order);
	}

}
