package com.example.apache.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Bean
    public NewTopic topicConfiguration(){
        return TopicBuilder.name("${spring.kafka.topic.name}").build();
    }

}
