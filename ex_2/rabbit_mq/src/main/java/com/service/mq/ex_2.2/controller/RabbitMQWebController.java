package com.service.mq.controller;

import com.service.mq.model.Employee;

import com.service.mq.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/rabbit-mq")
public class RabbitMQWebController  {

    @Autowired
    RabbitMQSender rabbitMQSender;


    @PostMapping (value = "/employees", consumes = "application/json")
    public void insertEmployee(@RequestBody Employee emp) {
      rabbitMQSender.send(emp);
    }
}
