package com.zq.springdeclarativetransaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootApplication
public class SpringDeclarativeTransactionApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	protected FooService fooService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDeclarativeTransactionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fooService.insertRecord();
		log.info("AAA {}",
				jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO BAR='AAA'", Long.class));

		try {
			fooService.insertThenRollback();
		} catch (RollbackException e) {
			log.info("BBB {}",
					jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO BAR='BBB'", Long.class));
		}

		try {
			fooService.invokeInsertThenRollback();
		} catch (RollbackException e) {
			log.info("BBB {}",
					jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO BAR='BBB'", Long.class));
		}
	}
}
