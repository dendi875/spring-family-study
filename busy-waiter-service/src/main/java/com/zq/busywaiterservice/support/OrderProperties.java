package com.zq.busywaiterservice.support;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@ConfigurationProperties("order")
@Data
@Component
public class OrderProperties {
	private Integer discount = 100;
	private String waiterPrefix = "springbucks-";
}
