package com.zq.springcloudstreamkafkawaiterservice.controller.request;

import com.zq.springcloudstreamkafkawaiterservice.model.OrderState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderStateRequest {
	private OrderState state;
}