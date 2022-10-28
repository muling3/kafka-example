package com.example.apache.kafka.controller;

import com.example.apache.kafka.models.Product;
import com.example.apache.kafka.services.MyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class MessageController {

    @Autowired private MyProducer myProducer;

    @PostMapping()
    public ResponseEntity<Product> publishMessage(@RequestBody Product product){
        myProducer.sendMessage(product);
        return ResponseEntity.ok(product);
    }
}
