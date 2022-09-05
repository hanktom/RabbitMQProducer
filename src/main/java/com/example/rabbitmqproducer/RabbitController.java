package com.example.rabbitmqproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/rabbit")
public class RabbitController {
    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping("/producer")
    public String producer(@RequestParam("name") String name, @RequestParam("id") String id) {
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        rabbitMQSender.send(emp);
        return "Message sent to the RabbitMQ Successfully";
    }
}
