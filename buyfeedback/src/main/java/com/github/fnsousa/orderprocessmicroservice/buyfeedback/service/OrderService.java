package com.github.fnsousa.orderprocessmicroservice.buyfeedback.service;

import com.github.fnsousa.orderprocessmicroservice.buyfeedback.domain.entity.OrderRedis;
import com.github.fnsousa.orderprocessmicroservice.buyfeedback.domain.repository.OrderRedisRepository;
import com.github.fnsousa.orderprocessmicroservice.buyfeedback.dto.request.OrderFinishedRequest;
import com.github.fnsousa.orderprocessmicroservice.buyfeedback.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRedisRepository repository;

    public void save(OrderFinishedRequest orderFinished) {

        OrderRedis buyRedis = new OrderRedis();
        buyRedis.setId(orderFinished.getBuyTripKey().getKey());
        buyRedis.setMessage(orderFinished.getMessage());
        buyRedis.setCardNumber(orderFinished.getBuyTripKey().getBuyTripRequest().getCardNumber());
        buyRedis.setTicketCode(orderFinished.getBuyTripKey().getBuyTripRequest().getTicketCode());
        buyRedis.setTicketValue(orderFinished.getBuyTripKey().getBuyTripRequest().getTicketValue());
        buyRedis.setApproved(orderFinished.isApproved());

        repository.save(buyRedis);

    }

    public OrderRedis findById(String key) {
        return repository.findById(key).orElseThrow(() -> new NotFoundException("Pedido não finalizado!"));
    }
}
