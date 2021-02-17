package com.github.fnsousa.orderprocessmicroservice.bank.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable ex) {
        super(message, ex);
    }

    public BusinessException(Throwable ex) {
        super(ex);
    }

}
