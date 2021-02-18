package com.github.fnsousa.orderprocessmicroservice.bank.service;

import com.github.fnsousa.orderprocessmicroservice.bank.domain.entity.Card;
import com.github.fnsousa.orderprocessmicroservice.bank.domain.repository.CardRepository;
import com.github.fnsousa.orderprocessmicroservice.bank.controller.request.AddCardRequest;
import com.github.fnsousa.orderprocessmicroservice.bank.exception.BusinessException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;

    public void create(AddCardRequest addCardRequest) {
        ModelMapper modelMapper = new ModelMapper();
        Card card = modelMapper.map(addCardRequest, Card.class);
        repository.save(card);
    }


    public boolean isValid(String cardNumber, String securityNumberCode) {
        return repository.existsByCardNumberAndSecurityNumberCode(cardNumber, securityNumberCode);
    }

    public boolean isEnoughCredit(String cardNumber, String securityNumberCode, BigDecimal orderValue) {
        return repository.existsByCardNumberAndSecurityNumberCodeAndCreditValueGreaterThanEqual(cardNumber, securityNumberCode, orderValue);
    }

    public Card findCard(String cardNumber, String securityNumberCode) {
        Card card = repository.findByCardNumberAndSecurityNumberCode(cardNumber, securityNumberCode);

        if(card == null) {
            throw new BusinessException("Cartão inválido!");
        }

        return card;
    }

    public void updateCredit(String cardNumber, String securityNumberCode, BigDecimal orderValue) {
        Card card = findCard(cardNumber, securityNumberCode);
        card.setCreditValue(card.getCreditValue().subtract(orderValue));
        repository.save(card);
    }
}
