package com.github.fnsousa.orderprocessmicroservice.bank.domain.repository;

import com.github.fnsousa.orderprocessmicroservice.bank.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    boolean existsByCardNumberAndSecurityNumberCode(String cardNumber, String securityNumberCode);

    boolean existsByCardNumberAndSecurityNumberCodeAndCreditValueGreaterThanEqual(String cardNumber, String securityNumberCode, BigDecimal orderValue);

    Card findByCardNumberAndSecurityNumberCode(String cardNumber, String securityNumberCode);
}
