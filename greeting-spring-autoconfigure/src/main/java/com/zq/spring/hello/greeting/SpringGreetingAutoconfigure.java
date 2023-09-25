package com.zq.spring.hello.greeting;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * `@ConditionalOnClass(SpringGreetingApplicationRunner.class)`
 * 当我的 classpath 中存在 SpringGreetingApplicationRunner 时才会生效，（我们在pom.xml中引入了依赖）
 *
 * `@ConditionalOnMissingBean(SpringGreetingApplicationRunner.class)`
 * 在我的 Spring 上下文时不存在 springGreetingApplicationRunner 这个 Bean 时才会生效，
 * 同时要判断一个 zq.enabled 这个属性为 true 时才生效
 */
@Configuration
@ConditionalOnClass(SpringGreetingApplicationRunner.class)
public class SpringGreetingAutoconfigure {

	@Bean
	@ConditionalOnMissingBean(SpringGreetingApplicationRunner.class)
	@ConditionalOnProperty(name = "zq.enabled", havingValue = "true", matchIfMissing = true)
	public SpringGreetingApplicationRunner springGreetingApplicationRunner() {
		return new SpringGreetingApplicationRunner();
	}
}
