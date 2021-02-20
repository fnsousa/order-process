package com.github.fnsousa.orderprocessmicroservice.buyfeedback.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fnsousa.orderprocessmicroservice.buyfeedback.domain.entity.OrderRedis;
import com.github.fnsousa.orderprocessmicroservice.buyfeedback.domain.repository.OrderRedisRepository;
import com.github.fnsousa.orderprocessmicroservice.buyfeedback.dto.request.OrderFinishedRequest;
import com.github.fnsousa.orderprocessmicroservice.buyfeedback.service.OrderService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class FinishedBuyListener {

    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = "${queue.buyfinished}")
    public void onMessage(Message message) throws UnsupportedEncodingException, JsonProcessingException {

        String json = new String(message.getBody(), "UTF-8");

        System.out.println("Mensagem recebida: " + json);

        ObjectMapper mapper = new ObjectMapper();
        OrderFinishedRequest orderFinished = mapper.readValue(json, OrderFinishedRequest.class);

        System.out.println("Gravando no Redis...");
        orderService.save(orderFinished);

    }

}
