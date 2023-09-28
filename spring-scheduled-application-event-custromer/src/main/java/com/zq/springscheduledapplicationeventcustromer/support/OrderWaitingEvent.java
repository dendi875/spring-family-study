package com.zq.springscheduledapplicationeventcustromer.support;

import com.zq.springscheduledapplicationeventcustromer.model.CoffeeOrder;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class OrderWaitingEvent extends ApplicationEvent {

	private CoffeeOrder order;

	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param order the object on which the event initially occurred (never {@code null})
	 */
	public OrderWaitingEvent(CoffeeOrder order) {
		super(order);
		this.order = order;
	}
}
