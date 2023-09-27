package com.zq.springcloudstreamrabbitmqwaiterservice.controller.request;

import com.zq.springcloudstreamrabbitmqwaiterservice.model.OrderState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderStateRequest {
	private OrderState state;
}