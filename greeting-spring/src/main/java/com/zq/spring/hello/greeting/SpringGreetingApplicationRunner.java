package com.zq.spring.hello.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * 并没有加 @Componnet 注解，所以并不会自己变成一个 Spring 的 Bean,
 * 需要在 Configuration 或XML 文件里去做一个定义
 */
@Slf4j
public class SpringGreetingApplicationRunner implements ApplicationRunner {

	private String name;

	/**
	 * 手动配置时输出
	 */
	public SpringGreetingApplicationRunner(String name) {
		this.name = name;
		log.info("Initializing SpringGreetingApplicationRunner for {}.", name);

	}

	/**
	 * 自动配置时输出
	 */
	public SpringGreetingApplicationRunner() {
		this("zhangquan");
	}

	public void run(ApplicationArguments args) throws Exception {
		log.info("Hello everyone! We all like Spring! ");
	}
}
