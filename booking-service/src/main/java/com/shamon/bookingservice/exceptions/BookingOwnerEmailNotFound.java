package com.shamon.bookingservice.exceptions;

public class BookingOwnerEmailNotFound extends RuntimeException {
    public BookingOwnerEmailNotFound(String message) {
        super(message);
    }
}