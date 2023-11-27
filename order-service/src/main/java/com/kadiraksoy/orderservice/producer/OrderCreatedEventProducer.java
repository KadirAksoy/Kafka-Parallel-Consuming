package com.kadiraksoy.orderservice.producer;


import com.kadiraksoy.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedEventProducer {

    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public OrderCreatedEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(Order order){
        this.kafkaTemplate.send("order-created-event",order);
    }
}
