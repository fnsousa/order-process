package com.github.fnsousa.orderprocessmicroservice.bank.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue
    private Long id;
    private String cardNumber;
    private String securityNumberCode;
    private BigDecimal creditValue;
}
