package com.example.apache.kafka.services;

import com.example.apache.kafka.models.Product;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyProducer {

    @Autowired public NewTopic topic;
    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    public void sendMessage(Product product){
        //create a message from the provided MessageBuilder
        Message<Product> productMessage = MessageBuilder
                .withPayload(product)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(productMessage);
    }

}
