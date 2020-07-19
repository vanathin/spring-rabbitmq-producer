package com.example.learning.springrabbitproducer.controller;

import com.example.learning.springrabbitproducer.bean.Employee;
import com.example.learning.springrabbitproducer.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @PostMapping(value = "/employees")
    public boolean saveEmployee(@RequestBody Employee employee){
        rabbitMQSender.send(employee);
        return true;
    }


}
