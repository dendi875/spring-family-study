package com.zq.spring.hello;

import com.zq.spring.hello.greeting.SpringGreetingApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringGreetingBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGreetingBootApplication.class, args);
	}

	// 手动配置
	//@Bean
	//public SpringGreetingApplicationRunner springGreetingApplicationRunner() {
	//	return new SpringGreetingApplicationRunner("Spring");
	//}
}
