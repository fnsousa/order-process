package com.github.fnsousa.orderprocessmicroservice.buytrip.controller;

import com.github.fnsousa.orderprocessmicroservice.buytrip.controller.request.BuyTripKeyRequest;
import com.github.fnsousa.orderprocessmicroservice.buytrip.controller.request.BuyTripRequest;
import com.github.fnsousa.orderprocessmicroservice.buytrip.controller.request.BuyTripResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.io.IOException;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/buys", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class BuyController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queue.buyprocess}")
    private String queueBuyprocess;

    @PostMapping
    public ResponseEntity<BuyTripResponse> buy(@Valid @NotNull @RequestBody BuyTripRequest buyTripRequest) throws IOException {

        BuyTripKeyRequest buyTripKey = new BuyTripKeyRequest();
        buyTripKey.setBuyTripRequest(buyTripRequest);
        buyTripKey.setKey(UUID.randomUUID().toString());

        ObjectMapper obj = new ObjectMapper();

        String json = obj.writeValueAsString(buyTripKey);

        rabbitTemplate.convertAndSend(queueBuyprocess, json);

        BuyTripResponse retorno = new BuyTripResponse();
        retorno.setMessage("Compra registrada com sucesso. Aguarda a confirmação do pagamento.");
        retorno.setKeySearch(buyTripKey.getKey());

        return new ResponseEntity<BuyTripResponse>(retorno, HttpStatus.OK);
    }


}
