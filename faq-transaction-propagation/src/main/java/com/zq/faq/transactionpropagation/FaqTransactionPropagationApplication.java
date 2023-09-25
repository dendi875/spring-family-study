package com.zq.faq.transactionpropagation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootApplication
public class FaqTransactionPropagationApplication implements ApplicationRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private FooService fooService;

	public static void main(String[] args) {
		SpringApplication.run(FaqTransactionPropagationApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			fooService.invokeInsertThenRollback();
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("AAA {}", jdbcTemplate.queryForObject("select count(*) from foo where bar='AAA'", Long.class));
		log.info("BBB {}", jdbcTemplate.queryForObject("select count(*) from foo where bar='BBB'", Long.class));
	}
}
