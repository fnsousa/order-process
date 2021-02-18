package com.github.fnsousa.orderprocessmicroservice.bank.controller;

import com.github.fnsousa.orderprocessmicroservice.bank.controller.request.AddPaymentRequest;
import com.github.fnsousa.orderprocessmicroservice.bank.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/payments", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity pay(@Valid @NotNull @RequestBody AddPaymentRequest addPaymentRequest) {
        paymentService.pay(addPaymentRequest);
        return ResponseEntity.ok().build();
    }


}
