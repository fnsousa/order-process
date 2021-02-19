package com.github.fnsousa.orderprocessmicroservice.bank.exception.handler;

import com.github.fnsousa.orderprocessmicroservice.bank.dto.response.PaymentResponse;
import com.github.fnsousa.orderprocessmicroservice.bank.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class BusinessExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity handleAccessDeniedException(Exception ex, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new PaymentResponse(ex.getMessage()));
    }

}
