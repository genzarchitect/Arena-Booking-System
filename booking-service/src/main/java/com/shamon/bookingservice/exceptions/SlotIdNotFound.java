package com.shamon.bookingservice.exceptions;

public class SlotIdNotFound extends RuntimeException{
    public SlotIdNotFound(String s) {
    super(s);
}
}
