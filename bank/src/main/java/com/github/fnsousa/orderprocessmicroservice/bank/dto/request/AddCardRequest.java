package com.github.fnsousa.orderprocessmicroservice.bank.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AddCardRequest {

    private String cardNumber;
    private String securityNumberCode;
    private BigDecimal creditValue;
}
