package com.zq.springredisrepository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "springbucks-coffee", timeToLive = 60)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeCache {

	@Id
	private Long id;
	@Indexed
	private String name;
	private Money price;
}
