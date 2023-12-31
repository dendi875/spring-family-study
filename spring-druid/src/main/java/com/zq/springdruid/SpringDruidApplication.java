package com.zq.springdruid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@Slf4j
@SpringBootApplication
public class SpringDruidApplication implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(SpringDruidApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("datasource: {}", dataSource.toString());
	}
}
