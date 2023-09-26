package com.zq.springcloudresilience4jcircuitbreakconsumer.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class NewOrderRequest {
	private String customer;
	private List<String> items;
}
