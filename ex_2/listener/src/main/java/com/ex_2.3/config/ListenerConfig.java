package com.config;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.RabbitMQListener;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ListenerConfig {
    @Value("${javainuse.rabbitmq.queue}")
    String queueName;

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


    //create MessageListenerContainer using default connection factory
    @Bean
    MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory ) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueues(queue());
        simpleMessageListenerContainer.setMessageListener(new RabbitMQListener());
        return simpleMessageListenerContainer;

    }

}
