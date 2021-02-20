package com.github.fnsousa.orderprocessmicroservice.buyfeedback.controller;

import com.github.fnsousa.orderprocessmicroservice.buyfeedback.domain.entity.OrderRedis;
import com.github.fnsousa.orderprocessmicroservice.buyfeedback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/orders", produces = APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/{key}")
    public ResponseEntity<OrderRedis> findOrder(@PathVariable("key") String key) {
        OrderRedis orderRedis = orderService.findById(key);
        return ResponseEntity.ok(orderRedis);
    }

}
