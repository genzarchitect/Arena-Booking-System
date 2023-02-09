package com.shamon.bookingservice.exceptions;

public class EmptySlotList extends RuntimeException{
    public EmptySlotList(String slotListIsEmpty) {
        super(slotListIsEmpty);
    }
}

