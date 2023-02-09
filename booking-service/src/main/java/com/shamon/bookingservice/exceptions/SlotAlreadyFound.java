package com.shamon.bookingservice.exceptions;

public class SlotAlreadyFound extends RuntimeException{
    public SlotAlreadyFound(String message) {
        super(message);
    }
}
