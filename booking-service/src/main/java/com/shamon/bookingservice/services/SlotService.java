package com.shamon.bookingservice.services;

import com.shamon.bookingservice.model.Booking;
import com.shamon.bookingservice.model.Slot;

import java.util.Date;
import java.util.List;

public interface SlotService {
    public List<Slot> getAllSlotFromRepo();
    public Slot addAllSlotTobookingdb(Slot slot);
    public List<Slot> getSlotsForGroundByDate(String groundId, String date);
    public Slot getSlotById(String slotId);
    public Slot getSlotByDate(String slotDate);
    public Slot updateSlotById(String slotId,Slot updatedslot);
    public Slot bookSlot(String slotId);
}
