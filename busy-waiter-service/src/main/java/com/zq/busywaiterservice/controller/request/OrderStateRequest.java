package com.zq.busywaiterservice.controller.request;

import com.zq.busywaiterservice.model.OrderState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderStateRequest {
	private OrderState state;
}