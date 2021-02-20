package com.github.fnsousa.orderprocessmicroservice.buyfeedback.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;

@RedisHash("buy")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRedis {

	@Id
	private String id;
	private String message;
	
	private String ticketCode;
	private String cardNumber;
	private BigDecimal ticketValue;
	
	private boolean approved;

	
	
}