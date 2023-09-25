package com.zq.springbootactuatormetrics;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.zq.springbootactuatormetrics.controller.PerformanceInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.TimeZone;

@EnableJpaRepositories
@EnableCaching
@SpringBootApplication
public class SpringBootActuatorMetricsApplication implements WebMvcConfigurer {


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new PerformanceInterceptor())
				.addPathPatterns("/coffee/**")
				.addPathPatterns("/order/**");
	}

	@Bean
	public Hibernate5Module hibernate5Module() {
		return new Hibernate5Module();
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jacksonBuilderCustomizer() {
		return builder -> {
			builder.indentOutput(true);
			builder.timeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActuatorMetricsApplication.class, args);
	}

}
