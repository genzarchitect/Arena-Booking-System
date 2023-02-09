package com.shamon.paymentservice.exception;

public class OrderCreationFailedException extends RuntimeException {
    public OrderCreationFailedException(String message){
        super(message);
    }
}
