package com.github.fnsousa.orderprocessmicroservice.bank.service;

import com.github.fnsousa.orderprocessmicroservice.bank.domain.entity.Payment;
import com.github.fnsousa.orderprocessmicroservice.bank.domain.repository.PaymentRepository;
import com.github.fnsousa.orderprocessmicroservice.bank.dto.request.AddPaymentRequest;
import com.github.fnsousa.orderprocessmicroservice.bank.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private CardService cardService;

    public void pay(AddPaymentRequest addPaymentRequest) {
        validatePay(addPaymentRequest);

        Payment payment = new Payment();
        payment.setValue(addPaymentRequest.getOrderValue());
        payment.setCard(cardService.findCard(addPaymentRequest.getCardNumber(), addPaymentRequest.getSecurityNumberCode()));

        repository.save(payment);

        cardService.updateCredit(addPaymentRequest.getCardNumber(), addPaymentRequest.getSecurityNumberCode(), addPaymentRequest.getOrderValue());
    }

    private void validatePay(AddPaymentRequest addPaymentRequest) {

        if (!cardService.isValid(addPaymentRequest.getCardNumber(), addPaymentRequest.getSecurityNumberCode())) {
            throw new BusinessException("Cartão inválido!");
        }

        if (!cardService.isEnoughCredit(addPaymentRequest.getCardNumber(), addPaymentRequest.getSecurityNumberCode(), addPaymentRequest.getOrderValue())) {
            throw new BusinessException("Saldo insuficiente!");
        }

    }
}
