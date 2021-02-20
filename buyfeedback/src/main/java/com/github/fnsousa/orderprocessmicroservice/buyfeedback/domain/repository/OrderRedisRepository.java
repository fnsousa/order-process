package com.github.fnsousa.orderprocessmicroservice.buyfeedback.domain.repository;

import com.github.fnsousa.orderprocessmicroservice.buyfeedback.domain.entity.OrderRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRedisRepository extends CrudRepository<OrderRedis, String> {
}
