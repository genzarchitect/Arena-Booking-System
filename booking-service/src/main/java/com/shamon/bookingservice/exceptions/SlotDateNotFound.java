package com.shamon.bookingservice.exceptions;

public class SlotDateNotFound extends RuntimeException{
    public SlotDateNotFound(String s) {
        super(s);
    }
}