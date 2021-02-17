package com.github.fnsousa.orderprocessmicroservice.bank.domain.repository;

import com.github.fnsousa.orderprocessmicroservice.bank.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
