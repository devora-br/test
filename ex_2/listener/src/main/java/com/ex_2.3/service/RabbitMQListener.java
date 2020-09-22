package com.service;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RabbitMQListener implements MessageListener {

    @Autowired
    private RestTemplate restTemplate;

    public void onMessage(Message message) {

        URI uri = UriComponentsBuilder
                .fromHttpUrl("localhost:54788")
                .path("/employees")
                .build().encode().toUri();

        HttpEntity<Object> entity = new HttpEntity<>(message.toString(),null );
        restTemplate.exchange(uri, HttpMethod.POST, entity, Object.class);

    }

}
