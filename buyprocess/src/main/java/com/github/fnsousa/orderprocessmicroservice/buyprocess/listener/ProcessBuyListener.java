package com.github.fnsousa.orderprocessmicroservice.buyprocess.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fnsousa.orderprocessmicroservice.buyprocess.dto.request.BuyTripKeyRequest;
import com.github.fnsousa.orderprocessmicroservice.buyprocess.dto.request.OrderFinishedRequest;
import com.github.fnsousa.orderprocessmicroservice.buyprocess.dto.response.PaymentResponse;
import com.github.fnsousa.orderprocessmicroservice.buyprocess.service.BankService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Service
public class ProcessBuyListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queue.buyprocess}")
    private String queueBuyprocess;

    @Value("${queue.buyfinished}")
    private String queueBuyFinished;

    @Autowired
    private BankService bankService;

    @RabbitListener(queues = "${queue.buyprocess}")
    public void onMessage(Message message) throws IOException {

        String json = new String(message.getBody(), "UTF-8");

        System.out.println("Mensagem recebida: " + json);

        ObjectMapper mapper = new ObjectMapper();
        BuyTripKeyRequest buyTripKeyRequest = mapper.readValue(json, BuyTripKeyRequest.class);

        PaymentResponse paymentResponse = bankService.pay(buyTripKeyRequest);

        OrderFinishedRequest finishedRequest = new OrderFinishedRequest();
        finishedRequest.setApproved(paymentResponse.isApproved());
        finishedRequest.setMessage(paymentResponse.getMessage());
        finishedRequest.setBuyTripKey(buyTripKeyRequest);

        System.out.println("Pagamento procesado: " + paymentResponse.getMessage());
        String jsonFinished = mapper.writeValueAsString(finishedRequest);
        rabbitTemplate.convertAndSend(queueBuyFinished, jsonFinished);
    }

}
