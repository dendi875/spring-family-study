package com.zq.faq.druid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
public class FaqDruidApplication implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private FooService fooService;

	public static void main(String[] args) {
		SpringApplication.run(FaqDruidApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("datasource: {}", dataSource.toString());

		new Thread(() -> fooService.selectForUpdate()).start();
		new Thread(() -> fooService.selectForUpdate()).start();
	}
}
