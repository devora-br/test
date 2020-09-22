package com.example.demo.controller;

import com.example.demo.model.Employee;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    ProducerTemplate producerTemplate;

    @PostMapping (value = "/employees", consumes = "application/json")
    public void insertEmployee(@RequestBody Employee emp) {
        producerTemplate.requestBody("direct:insert", emp, Employee.class);
    }
}
