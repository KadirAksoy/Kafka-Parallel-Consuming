package com.kadiraksoy.orderservice.controller;


import com.kadiraksoy.orderservice.model.Order;
import com.kadiraksoy.orderservice.producer.OrderCreatedEventProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderCreatedEventProducer orderCreatedEventProducer;

    public OrderController(OrderCreatedEventProducer orderCreatedEventProducer) {
        this.orderCreatedEventProducer = orderCreatedEventProducer;
    }

    @GetMapping(path = "")
    public String publishOrder() {
        var id = (int) (Math.random() * 100) + 1;
        var order = new Order(id, new Date());
        orderCreatedEventProducer.produce(order);

        return "Order creted";
    }
}
