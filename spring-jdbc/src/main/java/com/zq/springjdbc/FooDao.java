package com.zq.springjdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class FooDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SimpleJdbcInsert simpleJdbcInsert;

	public void insertData() {
		Arrays.asList("b", "c").forEach((bar) -> {
			jdbcTemplate.update("INSERT INTO FOO (BAR) VALUES (?)", bar);
		});

		Map<String, String> map = new HashMap<>(); // 字段 => 值
		map.put("BAR", "d");
		Number number = simpleJdbcInsert.executeAndReturnKey(map);
		log.info("ID of d: {}", number.longValue());
	}

	public void listData() {
		log.info("Count: {}",
				jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO", Long.class));

		List<String> list = jdbcTemplate.queryForList("SELECT BAR FROM FOO", String.class);
		list.forEach((s) -> log.info("Bar: {}", s));

		List<Foo> footList = jdbcTemplate.query("SELECT * FROM FOO", new RowMapper<Foo>() {
			@Override
			public Foo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Foo.builder()
						.id(rs.getLong(1))
						.bar(rs.getString(2))
						.build();
			}
		});

		footList.forEach(f -> log.info("Foo: {}", f));
	}
}
