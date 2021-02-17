package com.github.fnsousa.orderprocessmicroservice.bank.controller;

import com.github.fnsousa.orderprocessmicroservice.bank.domain.request.AddCardRequest;
import com.github.fnsousa.orderprocessmicroservice.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/cards", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity create(@RequestBody AddCardRequest addCardRequest) {
        cardService.create(addCardRequest);
        return ResponseEntity.ok().build();
    }


}
