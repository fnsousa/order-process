package com.github.fnsousa.orderprocessmicroservice.buyfeedback.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable ex) {
        super(message, ex);
    }

    public NotFoundException(Throwable ex) {
        super(ex);
    }

}
