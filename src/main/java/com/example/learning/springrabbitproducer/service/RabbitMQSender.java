package com.example.learning.springrabbitproducer.service;

import com.example.learning.springrabbitproducer.bean.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${employee.rabbitmq..exchange}")
    private String exchange;

    @Value("${employee.rabbitmq..routingkey}")
    private String routingQueue;

    public void send(Employee employee){
        amqpTemplate.convertAndSend(exchange, routingQueue, employee);
    }
}
