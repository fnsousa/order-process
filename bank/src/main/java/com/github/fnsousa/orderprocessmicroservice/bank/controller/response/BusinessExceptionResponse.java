package com.github.fnsousa.orderprocessmicroservice.bank.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessExceptionResponse {

    private String message;
    private LocalDateTime timestamp;

}
