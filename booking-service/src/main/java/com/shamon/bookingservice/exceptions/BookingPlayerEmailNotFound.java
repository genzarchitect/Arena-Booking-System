package com.shamon.bookingservice.exceptions;

public class BookingPlayerEmailNotFound extends RuntimeException {
    public BookingPlayerEmailNotFound(String message) {
        super(message);
    }
}
