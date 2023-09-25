package com.zq.springbootcommandline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootCommandLineApplication {

	public static void main(String[] args) {
		// 根据 application.properties 里的配置来决定 WebApplicationType
		// SpringApplication.run(SpringBootCommandLineApplication.class, args);

		new SpringApplicationBuilder(SpringBootCommandLineApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
	}
}
