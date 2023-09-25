package com.zq.springdeclarativetransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FooServiceImpl implements FooService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public void insertRecord() {
		jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('AAA')");
	}

	@Transactional(rollbackFor = RollbackException.class)
	@Override
	public void insertThenRollback() throws RollbackException {
		jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB')");
		throw new RollbackException();
	}

	@Override
	public void invokeInsertThenRollback() throws RollbackException {
		insertThenRollback();
	}
}
