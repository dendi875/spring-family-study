package com.zq.sleuthcustomerservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class OrderStateRequest {
	private OrderState state;
}

