package com.zq.springcloudstreamkafkabaristaservice.integration;


import com.zq.springcloudstreamkafkabaristaservice.model.CoffeeOrder;
import com.zq.springcloudstreamkafkabaristaservice.model.OrderState;
import com.zq.springcloudstreamkafkabaristaservice.repository.CoffeeOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@Transactional
public class OrderListener {
    @Autowired
    private CoffeeOrderRepository orderRepository;

    @Autowired
    @Qualifier(Waiter.FINISHED_ORDERS)
    private MessageChannel finishedOrdersMessageChannel;

    @Value("${order.barista-prefix}${random.uuid}")
    private String barista;

    @StreamListener(Waiter.NEW_ORDERS)
    @SendTo(Waiter.FINISHED_ORDERS)
    public Long processNewOrder(Long id) {
        CoffeeOrder o = orderRepository.getOne(id);
        if (o == null) {
            log.warn("Order id {} is NOT valid.", id);
            throw new IllegalArgumentException("Order ID is INVAILD!");
        }
        log.info("Receive a new Order {}. Waiter: {}. Customer: {}",
                id, o.getWaiter(), o.getCustomer());
        o.setState(OrderState.BREWED);
        o.setBarista(barista);
        orderRepository.save(o);
        log.info("Order {} is READY.", id);
        return id;
    }

}
