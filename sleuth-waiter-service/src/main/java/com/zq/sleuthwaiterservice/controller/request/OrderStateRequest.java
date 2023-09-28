package com.zq.sleuthwaiterservice.controller.request;

import com.zq.sleuthwaiterservice.model.OrderState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderStateRequest {
	private OrderState state;
}